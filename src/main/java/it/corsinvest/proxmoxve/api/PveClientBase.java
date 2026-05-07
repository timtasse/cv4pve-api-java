/*
 * SPDX-FileCopyrightText: Copyright Corsinvest Srl
 * SPDX-License-Identifier: MIT
 */
package it.corsinvest.proxmoxve.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Proxmox VE Client Base
 */
@SuppressWarnings("unused")
public class PveClientBase {

    private static final Logger logger = Logger.getLogger(PveClientBase.class.getName());

    private String ticketCSRFPreventionToken;
    private String ticketPVEAuthCookie;
    private final String hostname;
    private final int port;
    private Result lastResult;
    private ResponseType responseType = ResponseType.JSON;
    private String apiToken;
    private Proxy proxy = Proxy.NO_PROXY;
    private int timeout = 0;
    private boolean validateCertificate = false;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public PveClientBase(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    /**
     * Gets the hostname configured.
     *
     * @return String The configured hostname.
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * Gets the port configured.
     *
     * @return int The configured port.
     */
    public int getPort() {
        return port;
    }

    /**
     * Get Validate Certificate
     *
     * @return boolean Whether SSL certificate validation is enabled
     */
    public boolean getValidateCertificate() {
        return validateCertificate;
    }

    /**
     * Set Validate Certificate
     *
     * @param validateCertificate Whether to validate SSL certificates
     */
    public void setValidateCertificate(boolean validateCertificate) {
        this.validateCertificate = validateCertificate;
    }

    /**
     * Get proxy
     *
     * @return Proxy Current proxy configuration
     */
    public Proxy getProxy() {
        return proxy;
    }

    /**
     * Set proxy
     *
     * @param proxy Proxy configuration to use
     */
    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }

    /**
     * Get the response type that is going to be returned when doing requests
     * (json, png).
     *
     * @return ResponseType Current response type configuration
     */
    public ResponseType getResponseType() {
        return responseType;
    }

    /**
     * Set the response type that is going to be returned when doing requests
     * (json, png).
     *
     * @param responseType Response type to set
     */
    public void setResponseType(ResponseType responseType) {
        this.responseType = responseType;
    }

    /**
     * Set timeout connection
     *
     * @param timeout Connection timeout in milliseconds
     */
    public void setTimeout(int timeout) {
        if (timeout < 0) {
            throw new IllegalArgumentException("timeout can not be negative");
        }
        this.timeout = timeout;
    }

    /**
     * Return timeout connection
     *
     * @return int Connection timeout in milliseconds
     */
    public int getTimeout() {
        return timeout;
    }

    /**
     * Creation ticket from login.
     *
     * @param username user name or &lt;username&gt;@&lt;realm&gt;
     * @param password password connection
     * @return boolean indicating if login was successful
     * @throws PveExceptionAuthentication if authentication fails
     */
    public boolean login(String username, String password) throws PveExceptionAuthentication {
        var realm = "pam";
        var data = username.split("@");
        if (data.length > 1) {
            username = data[0];
            realm = data[1];
        }

        return login(username, password, realm, null);
    }

    /**
     * Creation ticket from login.
     *
     * @param username user name
     * @param password password connection
     * @param realm    pam/pve or custom
     * @return boolean indicating if login was successful
     * @throws PveExceptionAuthentication if authentication fails
     */
    public boolean login(String username, String password, String realm)
            throws PveExceptionAuthentication {
        return login(username, password, realm, null);
    }

    /**
     * Creation ticket from login.
     *
     * @param username user name
     * @param password password connection
     * @param realm    pam/pve or custom
     * @param otp      One-time password for Two-factor authentication.
     * @return boolean indicating if login was successful
     * @throws PveExceptionAuthentication if authentication fails
     */
    public boolean login(String username, String password, String realm, String otp)
            throws PveExceptionAuthentication {
        var params = new java.util.HashMap<String, Object>();
        params.put("password", password);
        params.put("username", username);
        params.put("realm", realm);
        if (otp != null) {
            params.put("otp", otp);
        }
        var result = create("/access/ticket", params);

        if (result.isSuccessStatusCode()) {
            var dataNode = result.getData();
            if (dataNode.has("NeedTFA")) {
                throw new PveExceptionAuthentication(result,
                        "Couldn't authenticate user: missing Two Factor Authentication (TFA)");
            }

            ticketCSRFPreventionToken = dataNode.get("CSRFPreventionToken").asText();
            ticketPVEAuthCookie = dataNode.get("ticket").asText();
        }
        return result.isSuccessStatusCode();
    }

    /**
     * Returns the base URL used to interact with the Proxmox VE API.
     *
     * @return The proxmox API URL.
     */
    public String getApiUrl() {
        return "https://" + getHostname() + ":" + getPort() + "/api2/json";
    }

    /**
     * Execute method GET
     *
     * @param resource   URL request
     * @param parameters Additional parameters
     * @return Result
     */
    public Result get(String resource, Map<String, Object> parameters) {
        return executeAction(resource, MethodType.GET, parameters);
    }

    /**
     * Execute method PUT
     *
     * @param resource   URL request
     * @param parameters Additional parameters
     * @return Result
     */
    public Result set(String resource, Map<String, Object> parameters) {
        return executeAction(resource, MethodType.SET, parameters);
    }

    /**
     * Execute method POST
     *
     * @param resource   URL request
     * @param parameters Additional parameters
     * @return Result
     */
    public Result create(String resource, Map<String, Object> parameters) {
        return executeAction(resource, MethodType.CREATE, parameters);
    }

    /**
     * Execute method DELETE
     *
     * @param resource   URL request
     * @param parameters Additional parameters
     * @return Result
     */
    public Result delete(String resource, Map<String, Object> parameters) {
        return executeAction(resource, MethodType.DELETE, parameters);
    }

    /**
     * Return Api Token
     *
     * @return String API token string
     */
    public String getApiToken() {
        return apiToken;
    }

    /**
     * Set Api Token format USER@REALM!TOKENID=UUID
     *
     * @param apiToken API token string
     */
    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    private void setToken(HttpURLConnection httpCon) {
        if (ticketCSRFPreventionToken != null) {
            httpCon.setRequestProperty("CSRFPreventionToken", ticketCSRFPreventionToken);
            httpCon.setRequestProperty("Cookie", "PVEAuthCookie=" + ticketPVEAuthCookie);
        }

        if (apiToken != null && !apiToken.isEmpty()) {
            httpCon.setRequestProperty("Authorization", "PVEAPIToken " + apiToken);
        }
    }

    private void setConnectionTimeout(HttpURLConnection httpCon) {
        if (timeout > 0) {
            httpCon.setConnectTimeout(timeout);
        }
    }

    /**
     * Configure SSL context for a specific HTTPS connection (not global)
     *
     * @param httpsConn The HTTPS connection to configure
     */
    private void configureTrustAllSSL(HttpsURLConnection httpsConn) {
        if (!validateCertificate) {
            try {
                // Create trust manager that trusts all certificates
                var trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }
                        @Override
                        public void checkClientTrusted(X509Certificate[] certs, String authType) {
                        }
                        @Override
                        public void checkServerTrusted(X509Certificate[] certs, String authType) {
                        }
                    }
                };

                // Create SSL context
                var sc = SSLContext.getInstance("TLS");
                sc.init(null, trustAllCerts, new java.security.SecureRandom());

                // Apply to THIS connection only (not global)
                httpsConn.setSSLSocketFactory(sc.getSocketFactory());

                // Set hostname verifier for THIS connection only
                httpsConn.setHostnameVerifier((hostname, session) -> true);

            } catch (NoSuchAlgorithmException | KeyManagementException ex) {
                logger.log(Level.SEVERE, "Failed to configure SSL", ex);
            }
        }
    }

    /**
     * Build URL-encoded query string from parameters
     *
     * @param params Parameters to encode
     * @return URL-encoded query string
     */
    private String buildQueryString(Map<String, Object> params) {
        var query = new StringBuilder();
        params.forEach((key, value) -> {
            if (!query.isEmpty()) {
                query.append("&");
            }
            query.append(URLEncoder.encode(key, StandardCharsets.UTF_8))
                 .append("=")
                 .append(URLEncoder.encode(value.toString(), StandardCharsets.UTF_8));
        });
        return query.toString();
    }

    /**
     * Read response from HTTP connection, handling both success and error streams
     *
     * @param httpCon HTTP connection
     * @param statusCode HTTP status code
     * @return Response body as string
     * @throws IOException if reading fails
     */
    private String readResponse(HttpURLConnection httpCon, int statusCode) throws IOException {
        // Choose the correct stream based on status code
        var stream = (statusCode >= 200 && statusCode < 400)
            ? httpCon.getInputStream()
            : httpCon.getErrorStream();

        if (stream == null) {
            return "";
        }

        try (var reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {
            var sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            return sb.toString();
        }
    }

    private Result executeAction(String resource, MethodType methodType, Map<String, Object> parameters) {
        if (methodType == null) {
            throw new AssertionError("methodType is null");
        }

        var url = getApiUrl() + resource;

        // decode http method
        var httpMethod = switch (methodType) {
            case GET -> "GET";
            case SET -> "PUT";
            case CREATE -> "POST";
            case DELETE -> "DELETE";
        };

        var params = new LinkedHashMap<String, Object>();
        if (parameters != null) {
            parameters.entrySet().stream().filter(entry -> (entry.getValue() != null)).forEachOrdered(entry -> {
                var value = entry.getValue();
                if (value instanceof Boolean) {
                    params.put(entry.getKey(), Boolean.TRUE.equals(value) ? 1 : 0);
                } else {
                    params.put(entry.getKey(), value);
                }
            });
        }

        var statusCode = 0;
        var reasonPhrase = "";
        JsonNode response = null;
        HttpURLConnection httpCon = null;

        try {
            switch (methodType) {
                case GET: {
                    if (!params.isEmpty()) {
                        url += "?" + buildQueryString(params);
                    }

                    httpCon = (HttpURLConnection) URI.create(url).toURL().openConnection(proxy);

                    // Configure SSL for this connection only (not global)
                    if (httpCon instanceof HttpsURLConnection httpsConn) {
                        configureTrustAllSSL(httpsConn);
                    }

                    httpCon.setRequestMethod("GET");
                    setConnectionTimeout(httpCon);
                    setToken(httpCon);
                    break;
                }

                case SET, CREATE: {
                    var data = objectMapper.writeValueAsString(params);
                    httpCon = (HttpURLConnection) URI.create(url).toURL().openConnection(proxy);

                    // Configure SSL for this connection only (not global)
                    if (httpCon instanceof HttpsURLConnection httpsConn) {
                        configureTrustAllSSL(httpsConn);
                    }

                    httpCon.setRequestMethod(httpMethod);
                    httpCon.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                    httpCon.setRequestProperty("Content-Length", String.valueOf(data.length()));
                    setConnectionTimeout(httpCon);
                    setToken(httpCon);

                    httpCon.setDoOutput(true);
                    httpCon.getOutputStream().write(data.getBytes(StandardCharsets.UTF_8));
                    break;
                }

                case DELETE: {
                    httpCon = (HttpURLConnection) URI.create(url).toURL().openConnection(proxy);

                    // Configure SSL for this connection only (not global)
                    if (httpCon instanceof HttpsURLConnection httpsConn) {
                        configureTrustAllSSL(httpsConn);
                    }

                    httpCon.setRequestMethod("DELETE");
                    setConnectionTimeout(httpCon);
                    setToken(httpCon);
                    break;
                }
            }

            if (logger.isLoggable(Level.FINE)) {
                logger.log(Level.FINE, "Method: {0}, Url: {1}", new Object[] { httpMethod, url });
                if (methodType != MethodType.GET && !params.isEmpty()) {
                    var paramsStr = new StringBuilder("Parameters:");
                    params.forEach((key, value) -> paramsStr.append("\n  ").append(key).append(" : ").append(value));
                    logger.fine(paramsStr.toString());
                }
            }

            statusCode = httpCon.getResponseCode();
            reasonPhrase = httpCon.getResponseMessage();

            // Read response using the appropriate stream (success or error)
            String responseBody = readResponse(httpCon, statusCode);

            if (!responseBody.isEmpty()) {
                response = switch (getResponseType()) {
                    case JSON -> objectMapper.readTree(responseBody);
                    case PNG -> objectMapper.createObjectNode()
                            .put("data", "data:image/png;base64,"
                                    + Base64.getEncoder().encodeToString(responseBody.getBytes(StandardCharsets.UTF_8)));
                };
            }

        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Error executing request", ex);
        }

        lastResult = new Result(response,
                statusCode,
                reasonPhrase,
                resource,
                parameters,
                methodType,
                getResponseType());

        if (logger.isLoggable(Level.FINER)) {
            logger.log(Level.FINER, """
                    Response: {0}
                    StatusCode: {1}
                    ReasonPhrase: {2}
                    IsSuccessStatusCode: {3}
                    =============================
                    """,
                    new Object[] {
                            response != null ? response.toPrettyString() : "null",
                            lastResult.getStatusCode(),
                            lastResult.getReasonPhrase(),
                            lastResult.isSuccessStatusCode()
                    });
        } else if (logger.isLoggable(Level.FINE)) {
            logger.fine("=============================");
        }
        return lastResult;
    }

    /**
     * Last result
     *
     * @return Result
     */
    public Result getLastResult() {
        return lastResult;
    }

    /**
     * Add indexed parameter
     *
     * @param parameters Parameters map to add to
     * @param name       Name parameter to use as prefix
     * @param value      Values map with index as key
     */
    public static void addIndexedParameter(Map<String, Object> parameters, String name, Map<Integer, String> value) {
        if (value != null) {
            value.forEach((key, value1) -> parameters.put(name + key, value1));
        }
    }

    /**
     * Wait for task to finish
     *
     * @param task    Task identifier
     * @param wait    Millisecond wait next check
     * @param timeOut Millisecond timeout
     * @return boolean True if task finished within timeout, false otherwise
     */
    public boolean waitForTaskToFinish(String task, long wait, long timeOut) {
        var isRunning = true;
        if (wait <= 0) {
            wait = 500;
        }
        if (timeOut < wait) {
            timeOut = wait + 5000;
        }

        var timeStart = System.currentTimeMillis();
        while (isRunning && (System.currentTimeMillis() - timeStart) < timeOut) {
            isRunning = taskIsRunning(task);
            try {
                Thread.sleep(wait);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        return System.currentTimeMillis() - timeStart < timeOut;
    }

    /**
     * Check task is running
     *
     * @param task Task identifier
     * @return boolean True if task is running, false otherwise
     */
    public boolean taskIsRunning(String task) {
        return readTaskStatus(task).getData().get("status").asText().equals("running");
    }

    /**
     * Return exit status code task
     *
     * @param task Task identifier
     * @return String Exit status of the task
     */
    public String getExitStatusTask(String task) {
        return readTaskStatus(task).getData().get("exitstatus").asText();
    }

    /**
     * Get node from task
     *
     * @param task Task
     * @return String
     */
    public static String getNodeFromTask(String task) {
        return task.split(":")[1];
    }

    /**
     * Read task status.
     *
     * @param task Task identifier to read status for
     * @return Result containing task status information
     */
    private Result readTaskStatus(String task) {
        return get("/nodes/" + getNodeFromTask(task) + "/tasks/" + task + "/status", null);
    }
}

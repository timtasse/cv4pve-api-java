/*
 * SPDX-FileCopyrightText: Copyright Corsinvest Srl
 * SPDX-License-Identifier: MIT
 */
package it.corsinvest.proxmoxve.api;

import java.net.HttpURLConnection;
import java.util.Map;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Result request API
 */
@SuppressWarnings("unused")
public class Result {

    private final String reasonPhrase;
    private final int statusCode;
    private final JsonNode response;
    private final String requestResource;
    private final Map<String, Object> requestParameters;
    private final MethodType methodType;
    private final ResponseType responseType;

    protected Result(JsonNode response,
            int statusCode,
            String reasonPhrase,
            String requestResource,
            Map<String, Object> requestParameters,
            MethodType methodType,
            ResponseType responseType) {
        this.response = response;
        this.statusCode = statusCode;
        this.reasonPhrase = reasonPhrase;
        this.requestResource = requestResource;
        this.requestParameters = requestParameters;
        this.methodType = methodType;
        this.responseType = responseType;
    }

    /**
     * Method type
     *
     * @return
     */
    public MethodType getMethodType() {
        return methodType;
    }

    /**
     * Response Type
     *
     * @return
     */
    public ResponseType getResponseType() {
        return responseType;
    }

    /**
     * Resource request
     *
     * @return
     */
    public String getRequestResource() {
        return requestResource;
    }

    /**
     * Request parameter
     *
     * @return
     */
    public Map<String, Object> getRequestParameters() {
        return requestParameters;
    }

    /**
     * Gets the reason phrase which typically is sent by servers together with
     * the status code.
     *
     * @return
     */
    public String getReasonPhrase() {
        return reasonPhrase;
    }

    /**
     * Contains the values of status codes defined for HTTP.
     *
     * @return
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * Gets a value that indicates if the HTTP response was successful.
     *
     * @return
     */
    public boolean isSuccessStatusCode() {
        return statusCode == HttpURLConnection.HTTP_OK;
    }

    /**
     * Proxmox VE response.
     *
     * @return JsonNode
     */
    public JsonNode getResponse() {
        return response;
    }

    /**
     * Get the data field from the response.
     *
     * @return JsonNode representing the data field, or null if not present
     */
    public JsonNode getData() {
        return response != null ? response.get("data") : null;
    }

    /**
     * Get if response Proxmox VE contain errors
     *
     * @return
     */
    public boolean responseInError() {
        return response.has("errors") && !response.get("errors").isNull();
    }

    /**
     * Get error
     *
     * @return
     */
    public String getError() {
        var ret = new StringBuilder();
        if (responseInError()) {
            var errors = response.get("errors");
            if (errors.isObject()) {
                errors.fieldNames().forEachRemaining(fieldName -> {
                    if (!ret.isEmpty()) {
                        ret.append("\n");
                    }
                    ret.append(fieldName).append(" : ").append(errors.get(fieldName).asText());
                });
            }
        }
        return ret.toString();
    }
}

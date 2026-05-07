package it.corsinvest.proxmoxve.api.cluster;

import it.corsinvest.proxmoxve.api.PveClient;
import it.corsinvest.proxmoxve.api.Result;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class PVEMetrics {

    private final PveClient client;

    public PVEMetrics(PveClient client) {
        this.client = client;

    }

    private PVEServer server;

    public PVEServer getServer() {
        return server == null ? (server = new PVEServer(client)) : server;
    }

    private PVEExport export;

    public PVEExport getExport() {
        return export == null ? (export = new PVEExport(client)) : export;
    }

    public static class PVEServer {

        private final PveClient client;

        protected PVEServer(PveClient client) {
            this.client = client;

        }

        public PVEServer.PVEIdItem get(Object id) {
            return new PVEIdItem(client, id);
        }

        public static class PVEIdItem {

            private final PveClient client;
            private final Object id;

            protected PVEIdItem(PveClient client, Object id) {
                this.client = client;
                this.id = id;
            }

            /**
             * Remove Metric server.
             *
             * @return Result
             */

            public Result delete() {
                return client.delete("/cluster/metrics/server/" + this.id, null);
            }

            /**
             * Read metric server configuration.
             *
             * @return Result
             */

            public Result read() {
                return client.get("/cluster/metrics/server/" + this.id, null);
            }

            /**
             * Create a new external metric server config
             *
             * @param port                     server network port
             * @param server                   server dns name or IP address
             * @param type                     Plugin type.
             *                                 Enum: graphite,influxdb,opentelemetry
             * @param api_path_prefix          An API path prefix inserted between
             *                                 '&amp;lt;host&amp;gt;:&amp;lt;port&amp;gt;/'
             *                                 and '/api2/'. Can be useful if the InfluxDB
             *                                 service runs behind a reverse proxy.
             * @param bucket                   The InfluxDB bucket/db. Only necessary when
             *                                 using the http v2 api.
             * @param disable                  Flag to disable the plugin.
             * @param influxdbproto            Enum: udp,http,https
             * @param max_body_size            InfluxDB max-body-size in bytes. Requests are
             *                                 batched up to this size.
             * @param mtu                      MTU for metrics transmission over UDP
             * @param organization             The InfluxDB organization. Only necessary
             *                                 when using the http v2 api. Has no meaning
             *                                 when using v2 compatibility api.
             * @param otel_compression         Compression algorithm for requests
             *                                 Enum: none,gzip
             * @param otel_headers             Custom HTTP headers (JSON format, base64
             *                                 encoded)
             * @param otel_max_body_size       Maximum request body size in bytes
             * @param otel_path                OTLP endpoint path
             * @param otel_protocol            HTTP protocol
             *                                 Enum: http,https
             * @param otel_resource_attributes Additional resource attributes as JSON,
             *                                 base64 encoded
             * @param otel_timeout             HTTP request timeout in seconds
             * @param otel_verify_ssl          Verify SSL certificates
             * @param path                     root graphite path (ex:
             *                                 proxmox.mycluster.mykey)
             * @param proto                    Protocol to send graphite data. TCP or UDP
             *                                 (default)
             *                                 Enum: udp,tcp
             * @param timeout                  graphite TCP socket timeout (default=1)
             * @param token                    The InfluxDB access token. Only necessary
             *                                 when using the http v2 api. If the v2
             *                                 compatibility api is used, use
             *                                 'user:password' instead.
             * @param verify_certificate       Set to 0 to disable certificate verification
             *                                 for https endpoints.
             * @return Result
             */

            public Result create(int port, String server, String type, String api_path_prefix, String bucket,
                                 Boolean disable, String influxdbproto, Integer max_body_size, Integer mtu,
                                 String organization, String otel_compression, String otel_headers,
                                 Integer otel_max_body_size, String otel_path, String otel_protocol,
                                 String otel_resource_attributes, Integer otel_timeout, Boolean otel_verify_ssl, String path,
                                 String proto, Integer timeout, String token, Boolean verify_certificate) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("port", port);
                parameters.put("server", server);
                parameters.put("type", type);
                parameters.put("api-path-prefix", api_path_prefix);
                parameters.put("bucket", bucket);
                parameters.put("disable", disable);
                parameters.put("influxdbproto", influxdbproto);
                parameters.put("max-body-size", max_body_size);
                parameters.put("mtu", mtu);
                parameters.put("organization", organization);
                parameters.put("otel-compression", otel_compression);
                parameters.put("otel-headers", otel_headers);
                parameters.put("otel-max-body-size", otel_max_body_size);
                parameters.put("otel-path", otel_path);
                parameters.put("otel-protocol", otel_protocol);
                parameters.put("otel-resource-attributes", otel_resource_attributes);
                parameters.put("otel-timeout", otel_timeout);
                parameters.put("otel-verify-ssl", otel_verify_ssl);
                parameters.put("path", path);
                parameters.put("proto", proto);
                parameters.put("timeout", timeout);
                parameters.put("token", token);
                parameters.put("verify-certificate", verify_certificate);
                return client.create("/cluster/metrics/server/" + this.id, parameters);
            }

            /**
             * Create a new external metric server config
             *
             * @param port   server network port
             * @param server server dns name or IP address
             * @param type   Plugin type.
             *               Enum: graphite,influxdb,opentelemetry
             * @return Result
             */

            public Result create(int port, String server, String type) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("port", port);
                parameters.put("server", server);
                parameters.put("type", type);
                return client.create("/cluster/metrics/server/" + this.id, parameters);
            }

            /**
             * Update metric server configuration.
             *
             * @param port                     server network port
             * @param server                   server dns name or IP address
             * @param api_path_prefix          An API path prefix inserted between
             *                                 '&amp;lt;host&amp;gt;:&amp;lt;port&amp;gt;/'
             *                                 and '/api2/'. Can be useful if the InfluxDB
             *                                 service runs behind a reverse proxy.
             * @param bucket                   The InfluxDB bucket/db. Only necessary when
             *                                 using the http v2 api.
             * @param delete                   A list of settings you want to delete.
             * @param digest                   Prevent changes if current configuration file
             *                                 has a different digest. This can be used to
             *                                 prevent concurrent modifications.
             * @param disable                  Flag to disable the plugin.
             * @param influxdbproto            Enum: udp,http,https
             * @param max_body_size            InfluxDB max-body-size in bytes. Requests are
             *                                 batched up to this size.
             * @param mtu                      MTU for metrics transmission over UDP
             * @param organization             The InfluxDB organization. Only necessary
             *                                 when using the http v2 api. Has no meaning
             *                                 when using v2 compatibility api.
             * @param otel_compression         Compression algorithm for requests
             *                                 Enum: none,gzip
             * @param otel_headers             Custom HTTP headers (JSON format, base64
             *                                 encoded)
             * @param otel_max_body_size       Maximum request body size in bytes
             * @param otel_path                OTLP endpoint path
             * @param otel_protocol            HTTP protocol
             *                                 Enum: http,https
             * @param otel_resource_attributes Additional resource attributes as JSON,
             *                                 base64 encoded
             * @param otel_timeout             HTTP request timeout in seconds
             * @param otel_verify_ssl          Verify SSL certificates
             * @param path                     root graphite path (ex:
             *                                 proxmox.mycluster.mykey)
             * @param proto                    Protocol to send graphite data. TCP or UDP
             *                                 (default)
             *                                 Enum: udp,tcp
             * @param timeout                  graphite TCP socket timeout (default=1)
             * @param token                    The InfluxDB access token. Only necessary
             *                                 when using the http v2 api. If the v2
             *                                 compatibility api is used, use
             *                                 'user:password' instead.
             * @param verify_certificate       Set to 0 to disable certificate verification
             *                                 for https endpoints.
             * @return Result
             */

            public Result update(int port, String server, String api_path_prefix, String bucket, String delete,
                                 String digest, Boolean disable, String influxdbproto, Integer max_body_size, Integer mtu,
                                 String organization, String otel_compression, String otel_headers,
                                 Integer otel_max_body_size, String otel_path, String otel_protocol,
                                 String otel_resource_attributes, Integer otel_timeout, Boolean otel_verify_ssl, String path,
                                 String proto, Integer timeout, String token, Boolean verify_certificate) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("port", port);
                parameters.put("server", server);
                parameters.put("api-path-prefix", api_path_prefix);
                parameters.put("bucket", bucket);
                parameters.put("delete", delete);
                parameters.put("digest", digest);
                parameters.put("disable", disable);
                parameters.put("influxdbproto", influxdbproto);
                parameters.put("max-body-size", max_body_size);
                parameters.put("mtu", mtu);
                parameters.put("organization", organization);
                parameters.put("otel-compression", otel_compression);
                parameters.put("otel-headers", otel_headers);
                parameters.put("otel-max-body-size", otel_max_body_size);
                parameters.put("otel-path", otel_path);
                parameters.put("otel-protocol", otel_protocol);
                parameters.put("otel-resource-attributes", otel_resource_attributes);
                parameters.put("otel-timeout", otel_timeout);
                parameters.put("otel-verify-ssl", otel_verify_ssl);
                parameters.put("path", path);
                parameters.put("proto", proto);
                parameters.put("timeout", timeout);
                parameters.put("token", token);
                parameters.put("verify-certificate", verify_certificate);
                return client.set("/cluster/metrics/server/" + this.id, parameters);
            }

            /**
             * Update metric server configuration.
             *
             * @param port   server network port
             * @param server server dns name or IP address
             * @return Result
             */

            public Result update(int port, String server) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("port", port);
                parameters.put("server", server);
                return client.set("/cluster/metrics/server/" + this.id, parameters);
            }

        }

        /**
         * List configured metric servers.
         *
         * @return Result
         */

        public Result serverIndex() {
            return client.get("/cluster/metrics/server", null);
        }

    }

    public static class PVEExport {

        private final PveClient client;

        protected PVEExport(PveClient client) {
            this.client = client;

        }

        /**
         * Retrieve metrics of the cluster.
         *
         * @param history    Also return historic values. Returns full available metric
         *                   history unless `start-time` is also set
         * @param local_only Only return metrics for the current node instead of the
         *                   whole cluster
         * @param node_list  Only return metrics from nodes passed as comma-separated
         *                   list
         * @param start_time Only include metrics with a timestamp &amp;gt; start-time.
         * @return Result
         */

        public Result export(Boolean history, Boolean local_only, String node_list, Integer start_time) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("history", history);
            parameters.put("local-only", local_only);
            parameters.put("node-list", node_list);
            parameters.put("start-time", start_time);
            return client.get("/cluster/metrics/export", parameters);
        }

        /**
         * Retrieve metrics of the cluster.
         *
         * @return Result
         */

        public Result export() {
            return client.get("/cluster/metrics/export", null);
        }

    }

    /**
     * Metrics index.
     *
     * @return Result
     */

    public Result index() {
        return client.get("/cluster/metrics", null);
    }

}

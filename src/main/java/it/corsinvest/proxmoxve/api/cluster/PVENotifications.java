package it.corsinvest.proxmoxve.api.cluster;

import it.corsinvest.proxmoxve.api.PveClient;
import it.corsinvest.proxmoxve.api.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class PVENotifications {

    private final PveClient client;

    public PVENotifications(PveClient client) {
        this.client = client;

    }

    private PVEMatcherFields matcherFields;

    public PVEMatcherFields getMatcherFields() {
        return matcherFields == null ? (matcherFields = new PVEMatcherFields(client)) : matcherFields;
    }

    private PVEMatcherFieldValues matcherFieldValues;

    public PVEMatcherFieldValues getMatcherFieldValues() {
        return matcherFieldValues == null ? (matcherFieldValues = new PVEMatcherFieldValues(client))
                : matcherFieldValues;
    }

    private PVEEndpoints endpoints;

    public PVEEndpoints getEndpoints() {
        return endpoints == null ? (endpoints = new PVEEndpoints(client)) : endpoints;
    }

    private PVETargets targets;

    public PVETargets getTargets() {
        return targets == null ? (targets = new PVETargets(client)) : targets;
    }

    private PVEMatchers matchers;

    public PVEMatchers getMatchers() {
        return matchers == null ? (matchers = new PVEMatchers(client)) : matchers;
    }

    public static class PVEMatcherFields {

        private final PveClient client;

        protected PVEMatcherFields(PveClient client) {
            this.client = client;

        }

        /**
         * Returns known notification metadata fields
         *
         * @return Result
         */

        public Result getMatcherFields() {
            return client.get("/cluster/notifications/matcher-fields", null);
        }

    }

    public static class PVEMatcherFieldValues {

        private final PveClient client;

        protected PVEMatcherFieldValues(PveClient client) {
            this.client = client;

        }

        /**
         * Returns known notification metadata fields and their known values
         *
         * @return Result
         */

        public Result getMatcherFieldValues() {
            return client.get("/cluster/notifications/matcher-field-values", null);
        }

    }

    public static class PVEEndpoints {

        private final PveClient client;

        protected PVEEndpoints(PveClient client) {
            this.client = client;

        }

        private PVEEndpoints.PVESendmail sendmail;

        public PVEEndpoints.PVESendmail getSendmail() {
            return sendmail == null ? (sendmail = new PVESendmail(client)) : sendmail;
        }

        private PVEEndpoints.PVEGotify gotify;

        public PVEEndpoints.PVEGotify getGotify() {
            return gotify == null ? (gotify = new PVEGotify(client)) : gotify;
        }

        private PVEEndpoints.PVESmtp smtp;

        public PVEEndpoints.PVESmtp getSmtp() {
            return smtp == null ? (smtp = new PVESmtp(client)) : smtp;
        }

        private PVEEndpoints.PVEWebhook webhook;

        public PVEEndpoints.PVEWebhook getWebhook() {
            return webhook == null ? (webhook = new PVEWebhook(client)) : webhook;
        }

        public static class PVESendmail {

            private final PveClient client;

            protected PVESendmail(PveClient client) {
                this.client = client;

            }

            public PVEEndpoints.PVESendmail.PVENameItem get(Object name) {
                return new PVENameItem(client, name);
            }

            public static class PVENameItem {

                private final PveClient client;
                private final Object name;

                protected PVENameItem(PveClient client, Object name) {
                    this.client = client;
                    this.name = name;
                }

                /**
                 * Remove sendmail endpoint
                 *
                 * @return Result
                 */

                public Result deleteSendmailEndpoint() {
                    return client.delete("/cluster/notifications/endpoints/sendmail/" + this.name, null);
                }

                /**
                 * Return a specific sendmail endpoint
                 *
                 * @return Result
                 */

                public Result getSendmailEndpoint() {
                    return client.get("/cluster/notifications/endpoints/sendmail/" + this.name, null);
                }

                /**
                 * Update existing sendmail endpoint
                 *
                 * @param author       Author of the mail
                 * @param comment      Comment
                 * @param delete       A list of settings you want to delete.
                 * @param digest       Prevent changes if current configuration file has a
                 *                     different digest. This can be used to prevent concurrent
                 *                     modifications.
                 * @param disable      Disable this target
                 * @param from_address `From` address for the mail
                 * @param mailto       List of email recipients
                 * @param mailto_user  List of users
                 * @return Result
                 */

                public Result updateSendmailEndpoint(String author, String comment, List<Object> delete,
                                                     String digest, Boolean disable, String from_address, List<Object> mailto,
                                                     List<Object> mailto_user) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("author", author);
                    parameters.put("comment", comment);
                    parameters.put("delete", delete);
                    parameters.put("digest", digest);
                    parameters.put("disable", disable);
                    parameters.put("from-address", from_address);
                    parameters.put("mailto", mailto);
                    parameters.put("mailto-user", mailto_user);
                    return client.set("/cluster/notifications/endpoints/sendmail/" + this.name,
                            parameters);
                }

                /**
                 * Update existing sendmail endpoint
                 *
                 * @return Result
                 */

                public Result updateSendmailEndpoint() {
                    return client.set("/cluster/notifications/endpoints/sendmail/" + this.name, null);
                }

            }

            /**
             * Returns a list of all sendmail endpoints
             *
             * @return Result
             */

            public Result getSendmailEndpoints() {
                return client.get("/cluster/notifications/endpoints/sendmail", null);
            }

            /**
             * Create a new sendmail endpoint
             *
             * @param name         The name of the endpoint.
             * @param author       Author of the mail
             * @param comment      Comment
             * @param disable      Disable this target
             * @param from_address `From` address for the mail
             * @param mailto       List of email recipients
             * @param mailto_user  List of users
             * @return Result
             */

            public Result createSendmailEndpoint(String name, String author, String comment, Boolean disable,
                                                 String from_address, List<Object> mailto, List<Object> mailto_user) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("name", name);
                parameters.put("author", author);
                parameters.put("comment", comment);
                parameters.put("disable", disable);
                parameters.put("from-address", from_address);
                parameters.put("mailto", mailto);
                parameters.put("mailto-user", mailto_user);
                return client.create("/cluster/notifications/endpoints/sendmail", parameters);
            }

            /**
             * Create a new sendmail endpoint
             *
             * @param name The name of the endpoint.
             * @return Result
             */

            public Result createSendmailEndpoint(String name) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("name", name);
                return client.create("/cluster/notifications/endpoints/sendmail", parameters);
            }

        }

        public static class PVEGotify {

            private final PveClient client;

            protected PVEGotify(PveClient client) {
                this.client = client;

            }

            public PVEEndpoints.PVEGotify.PVENameItem get(Object name) {
                return new PVENameItem(client, name);
            }

            public static class PVENameItem {

                private final PveClient client;
                private final Object name;

                protected PVENameItem(PveClient client, Object name) {
                    this.client = client;
                    this.name = name;
                }

                /**
                 * Remove gotify endpoint
                 *
                 * @return Result
                 */

                public Result deleteGotifyEndpoint() {
                    return client.delete("/cluster/notifications/endpoints/gotify/" + this.name, null);
                }

                /**
                 * Return a specific gotify endpoint
                 *
                 * @return Result
                 */

                public Result getGotifyEndpoint() {
                    return client.get("/cluster/notifications/endpoints/gotify/" + this.name, null);
                }

                /**
                 * Update existing gotify endpoint
                 *
                 * @param comment Comment
                 * @param delete  A list of settings you want to delete.
                 * @param digest  Prevent changes if current configuration file has a different
                 *                digest. This can be used to prevent concurrent modifications.
                 * @param disable Disable this target
                 * @param server  Server URL
                 * @param token   Secret token
                 * @return Result
                 */

                public Result updateGotifyEndpoint(String comment, List<Object> delete, String digest,
                                                   Boolean disable, String server, String token) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("comment", comment);
                    parameters.put("delete", delete);
                    parameters.put("digest", digest);
                    parameters.put("disable", disable);
                    parameters.put("server", server);
                    parameters.put("token", token);
                    return client.set("/cluster/notifications/endpoints/gotify/" + this.name, parameters);
                }

                /**
                 * Update existing gotify endpoint
                 *
                 * @return Result
                 */

                public Result updateGotifyEndpoint() {
                    return client.set("/cluster/notifications/endpoints/gotify/" + this.name, null);
                }

            }

            /**
             * Returns a list of all gotify endpoints
             *
             * @return Result
             */

            public Result getGotifyEndpoints() {
                return client.get("/cluster/notifications/endpoints/gotify", null);
            }

            /**
             * Create a new gotify endpoint
             *
             * @param name    The name of the endpoint.
             * @param server  Server URL
             * @param token   Secret token
             * @param comment Comment
             * @param disable Disable this target
             * @return Result
             */

            public Result createGotifyEndpoint(String name, String server, String token, String comment,
                                               Boolean disable) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("name", name);
                parameters.put("server", server);
                parameters.put("token", token);
                parameters.put("comment", comment);
                parameters.put("disable", disable);
                return client.create("/cluster/notifications/endpoints/gotify", parameters);
            }

            /**
             * Create a new gotify endpoint
             *
             * @param name   The name of the endpoint.
             * @param server Server URL
             * @param token  Secret token
             * @return Result
             */

            public Result createGotifyEndpoint(String name, String server, String token) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("name", name);
                parameters.put("server", server);
                parameters.put("token", token);
                return client.create("/cluster/notifications/endpoints/gotify", parameters);
            }

        }

        public static class PVESmtp {

            private final PveClient client;

            protected PVESmtp(PveClient client) {
                this.client = client;

            }

            public PVEEndpoints.PVESmtp.PVENameItem get(Object name) {
                return new PVENameItem(client, name);
            }

            public static class PVENameItem {

                private final PveClient client;
                private final Object name;

                protected PVENameItem(PveClient client, Object name) {
                    this.client = client;
                    this.name = name;
                }

                /**
                 * Remove smtp endpoint
                 *
                 * @return Result
                 */

                public Result deleteSmtpEndpoint() {
                    return client.delete("/cluster/notifications/endpoints/smtp/" + this.name, null);
                }

                /**
                 * Return a specific smtp endpoint
                 *
                 * @return Result
                 */

                public Result getSmtpEndpoint() {
                    return client.get("/cluster/notifications/endpoints/smtp/" + this.name, null);
                }

                /**
                 * Update existing smtp endpoint
                 *
                 * @param author       Author of the mail. Defaults to 'Proxmox VE'.
                 * @param comment      Comment
                 * @param delete       A list of settings you want to delete.
                 * @param digest       Prevent changes if current configuration file has a
                 *                     different digest. This can be used to prevent concurrent
                 *                     modifications.
                 * @param disable      Disable this target
                 * @param from_address `From` address for the mail
                 * @param mailto       List of email recipients
                 * @param mailto_user  List of users
                 * @param mode         Determine which encryption method shall be used for the
                 *                     connection.
                 *                     Enum: insecure,starttls,tls
                 * @param password     Password for SMTP authentication
                 * @param port         The port to be used. Defaults to 465 for TLS based
                 *                     connections, 587 for STARTTLS based connections and port
                 *                     25 for insecure plain-text connections.
                 * @param server       The address of the SMTP server.
                 * @param username     Username for SMTP authentication
                 * @return Result
                 */

                public Result updateSmtpEndpoint(String author, String comment, List<Object> delete,
                                                 String digest, Boolean disable, String from_address, List<Object> mailto,
                                                 List<Object> mailto_user, String mode, String password, Integer port, String server,
                                                 String username) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("author", author);
                    parameters.put("comment", comment);
                    parameters.put("delete", delete);
                    parameters.put("digest", digest);
                    parameters.put("disable", disable);
                    parameters.put("from-address", from_address);
                    parameters.put("mailto", mailto);
                    parameters.put("mailto-user", mailto_user);
                    parameters.put("mode", mode);
                    parameters.put("password", password);
                    parameters.put("port", port);
                    parameters.put("server", server);
                    parameters.put("username", username);
                    return client.set("/cluster/notifications/endpoints/smtp/" + this.name, parameters);
                }

                /**
                 * Update existing smtp endpoint
                 *
                 * @return Result
                 */

                public Result updateSmtpEndpoint() {
                    return client.set("/cluster/notifications/endpoints/smtp/" + this.name, null);
                }

            }

            /**
             * Returns a list of all smtp endpoints
             *
             * @return Result
             */

            public Result getSmtpEndpoints() {
                return client.get("/cluster/notifications/endpoints/smtp", null);
            }

            /**
             * Create a new smtp endpoint
             *
             * @param from_address `From` address for the mail
             * @param name         The name of the endpoint.
             * @param server       The address of the SMTP server.
             * @param author       Author of the mail. Defaults to 'Proxmox VE'.
             * @param comment      Comment
             * @param disable      Disable this target
             * @param mailto       List of email recipients
             * @param mailto_user  List of users
             * @param mode         Determine which encryption method shall be used for the
             *                     connection.
             *                     Enum: insecure,starttls,tls
             * @param password     Password for SMTP authentication
             * @param port         The port to be used. Defaults to 465 for TLS based
             *                     connections, 587 for STARTTLS based connections and port
             *                     25 for insecure plain-text connections.
             * @param username     Username for SMTP authentication
             * @return Result
             */

            public Result createSmtpEndpoint(String from_address, String name, String server, String author,
                                             String comment, Boolean disable, List<Object> mailto, List<Object> mailto_user, String mode,
                                             String password, Integer port, String username) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("from-address", from_address);
                parameters.put("name", name);
                parameters.put("server", server);
                parameters.put("author", author);
                parameters.put("comment", comment);
                parameters.put("disable", disable);
                parameters.put("mailto", mailto);
                parameters.put("mailto-user", mailto_user);
                parameters.put("mode", mode);
                parameters.put("password", password);
                parameters.put("port", port);
                parameters.put("username", username);
                return client.create("/cluster/notifications/endpoints/smtp", parameters);
            }

            /**
             * Create a new smtp endpoint
             *
             * @param from_address `From` address for the mail
             * @param name         The name of the endpoint.
             * @param server       The address of the SMTP server.
             * @return Result
             */

            public Result createSmtpEndpoint(String from_address, String name, String server) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("from-address", from_address);
                parameters.put("name", name);
                parameters.put("server", server);
                return client.create("/cluster/notifications/endpoints/smtp", parameters);
            }

        }

        public static class PVEWebhook {

            private final PveClient client;

            protected PVEWebhook(PveClient client) {
                this.client = client;

            }

            public PVEEndpoints.PVEWebhook.PVENameItem get(Object name) {
                return new PVENameItem(client, name);
            }

            public static class PVENameItem {

                private final PveClient client;
                private final Object name;

                protected PVENameItem(PveClient client, Object name) {
                    this.client = client;
                    this.name = name;
                }

                /**
                 * Remove webhook endpoint
                 *
                 * @return Result
                 */

                public Result deleteWebhookEndpoint() {
                    return client.delete("/cluster/notifications/endpoints/webhook/" + this.name, null);
                }

                /**
                 * Return a specific webhook endpoint
                 *
                 * @return Result
                 */

                public Result getWebhookEndpoint() {
                    return client.get("/cluster/notifications/endpoints/webhook/" + this.name, null);
                }

                /**
                 * Update existing webhook endpoint
                 *
                 * @param body    HTTP body, base64 encoded
                 * @param comment Comment
                 * @param delete  A list of settings you want to delete.
                 * @param digest  Prevent changes if current configuration file has a different
                 *                digest. This can be used to prevent concurrent modifications.
                 * @param disable Disable this target
                 * @param header  HTTP headers to set. These have to be formatted as a property
                 *                string in the format
                 *                name=&amp;lt;name&amp;gt;,value=&amp;lt;base64 of
                 *                value&amp;gt;
                 * @param method  HTTP method
                 *                Enum: post,put,get
                 * @param secret  Secrets to set. These have to be formatted as a property
                 *                string in the format
                 *                name=&amp;lt;name&amp;gt;,value=&amp;lt;base64 of
                 *                value&amp;gt;
                 * @param url     Server URL
                 * @return Result
                 */

                public Result updateWebhookEndpoint(String body, String comment, List<Object> delete,
                                                    String digest, Boolean disable, List<Object> header, String method, List<Object> secret,
                                                    String url) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("body", body);
                    parameters.put("comment", comment);
                    parameters.put("delete", delete);
                    parameters.put("digest", digest);
                    parameters.put("disable", disable);
                    parameters.put("header", header);
                    parameters.put("method", method);
                    parameters.put("secret", secret);
                    parameters.put("url", url);
                    return client.set("/cluster/notifications/endpoints/webhook/" + this.name, parameters);
                }

                /**
                 * Update existing webhook endpoint
                 *
                 * @return Result
                 */

                public Result updateWebhookEndpoint() {
                    return client.set("/cluster/notifications/endpoints/webhook/" + this.name, null);
                }

            }

            /**
             * Returns a list of all webhook endpoints
             *
             * @return Result
             */

            public Result getWebhookEndpoints() {
                return client.get("/cluster/notifications/endpoints/webhook", null);
            }

            /**
             * Create a new webhook endpoint
             *
             * @param method  HTTP method
             *                Enum: post,put,get
             * @param name    The name of the endpoint.
             * @param url     Server URL
             * @param body    HTTP body, base64 encoded
             * @param comment Comment
             * @param disable Disable this target
             * @param header  HTTP headers to set. These have to be formatted as a property
             *                string in the format
             *                name=&amp;lt;name&amp;gt;,value=&amp;lt;base64 of
             *                value&amp;gt;
             * @param secret  Secrets to set. These have to be formatted as a property
             *                string in the format
             *                name=&amp;lt;name&amp;gt;,value=&amp;lt;base64 of
             *                value&amp;gt;
             * @return Result
             */

            public Result createWebhookEndpoint(String method, String name, String url, String body,
                                                String comment, Boolean disable, List<Object> header, List<Object> secret) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("method", method);
                parameters.put("name", name);
                parameters.put("url", url);
                parameters.put("body", body);
                parameters.put("comment", comment);
                parameters.put("disable", disable);
                parameters.put("header", header);
                parameters.put("secret", secret);
                return client.create("/cluster/notifications/endpoints/webhook", parameters);
            }

            /**
             * Create a new webhook endpoint
             *
             * @param method HTTP method
             *               Enum: post,put,get
             * @param name   The name of the endpoint.
             * @param url    Server URL
             * @return Result
             */

            public Result createWebhookEndpoint(String method, String name, String url) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("method", method);
                parameters.put("name", name);
                parameters.put("url", url);
                return client.create("/cluster/notifications/endpoints/webhook", parameters);
            }

        }

        /**
         * Index for all available endpoint types.
         *
         * @return Result
         */

        public Result endpointsIndex() {
            return client.get("/cluster/notifications/endpoints", null);
        }

    }

    public static class PVETargets {

        private final PveClient client;

        protected PVETargets(PveClient client) {
            this.client = client;

        }

        public PVETargets.PVENameItem get(Object name) {
            return new PVENameItem(client, name);
        }

        public static class PVENameItem {

            private final PveClient client;
            private final Object name;

            protected PVENameItem(PveClient client, Object name) {
                this.client = client;
                this.name = name;
            }

            private PVETargets.PVENameItem.PVETest test;

            public PVETargets.PVENameItem.PVETest getTest() {
                return test == null ? (test = new PVETest(client, this.name)) : test;
            }

            public static class PVETest {

                private final PveClient client;
                private final Object name;

                protected PVETest(PveClient client, Object name) {
                    this.client = client;
                    this.name = name;
                }

                /**
                 * Send a test notification to a provided target.
                 *
                 * @return Result
                 */

                public Result testTarget() {
                    return client.create("/cluster/notifications/targets/" + this.name + "/test", null);
                }

            }

        }

        /**
         * Returns a list of all entities that can be used as notification targets.
         *
         * @return Result
         */

        public Result getAllTargets() {
            return client.get("/cluster/notifications/targets", null);
        }

    }

    public static class PVEMatchers {

        private final PveClient client;

        protected PVEMatchers(PveClient client) {
            this.client = client;

        }

        public PVEMatchers.PVENameItem get(Object name) {
            return new PVENameItem(client, name);
        }

        public static class PVENameItem {

            private final PveClient client;
            private final Object name;

            protected PVENameItem(PveClient client, Object name) {
                this.client = client;
                this.name = name;
            }

            /**
             * Remove matcher
             *
             * @return Result
             */

            public Result deleteMatcher() {
                return client.delete("/cluster/notifications/matchers/" + this.name, null);
            }

            /**
             * Return a specific matcher
             *
             * @return Result
             */

            public Result getMatcher() {
                return client.get("/cluster/notifications/matchers/" + this.name, null);
            }

            /**
             * Update existing matcher
             *
             * @param comment        Comment
             * @param delete         A list of settings you want to delete.
             * @param digest         Prevent changes if current configuration file has a
             *                       different digest. This can be used to prevent
             *                       concurrent modifications.
             * @param disable        Disable this matcher
             * @param invert_match   Invert match of the whole matcher
             * @param match_calendar Match notification timestamp
             * @param match_field    Metadata fields to match (regex or exact match). Must
             *                       be in the form
             *                       (regex|exact):&amp;lt;field&amp;gt;=&amp;lt;value&amp;gt;
             * @param match_severity Notification severities to match
             * @param mode           Choose between 'all' and 'any' for when multiple
             *                       properties are specified
             *                       Enum: all,any
             * @param target         Targets to notify on match
             * @return Result
             */

            public Result updateMatcher(String comment, List<Object> delete, String digest, Boolean disable,
                                        Boolean invert_match, List<Object> match_calendar, List<Object> match_field,
                                        List<Object> match_severity, String mode, List<Object> target) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("comment", comment);
                parameters.put("delete", delete);
                parameters.put("digest", digest);
                parameters.put("disable", disable);
                parameters.put("invert-match", invert_match);
                parameters.put("match-calendar", match_calendar);
                parameters.put("match-field", match_field);
                parameters.put("match-severity", match_severity);
                parameters.put("mode", mode);
                parameters.put("target", target);
                return client.set("/cluster/notifications/matchers/" + this.name, parameters);
            }

            /**
             * Update existing matcher
             *
             * @return Result
             */

            public Result updateMatcher() {
                return client.set("/cluster/notifications/matchers/" + this.name, null);
            }

        }

        /**
         * Returns a list of all matchers
         *
         * @return Result
         */

        public Result getMatchers() {
            return client.get("/cluster/notifications/matchers", null);
        }

        /**
         * Create a new matcher
         *
         * @param name           Name of the matcher.
         * @param comment        Comment
         * @param disable        Disable this matcher
         * @param invert_match   Invert match of the whole matcher
         * @param match_calendar Match notification timestamp
         * @param match_field    Metadata fields to match (regex or exact match). Must
         *                       be in the form
         *                       (regex|exact):&amp;lt;field&amp;gt;=&amp;lt;value&amp;gt;
         * @param match_severity Notification severities to match
         * @param mode           Choose between 'all' and 'any' for when multiple
         *                       properties are specified
         *                       Enum: all,any
         * @param target         Targets to notify on match
         * @return Result
         */

        public Result createMatcher(String name, String comment, Boolean disable, Boolean invert_match,
                                    List<Object> match_calendar, List<Object> match_field, List<Object> match_severity, String mode,
                                    List<Object> target) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("name", name);
            parameters.put("comment", comment);
            parameters.put("disable", disable);
            parameters.put("invert-match", invert_match);
            parameters.put("match-calendar", match_calendar);
            parameters.put("match-field", match_field);
            parameters.put("match-severity", match_severity);
            parameters.put("mode", mode);
            parameters.put("target", target);
            return client.create("/cluster/notifications/matchers", parameters);
        }

        /**
         * Create a new matcher
         *
         * @param name Name of the matcher.
         * @return Result
         */

        public Result createMatcher(String name) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("name", name);
            return client.create("/cluster/notifications/matchers", parameters);
        }

    }

    /**
     * Index for notification-related API endpoints.
     *
     * @return Result
     */

    public Result index() {
        return client.get("/cluster/notifications", null);
    }

}

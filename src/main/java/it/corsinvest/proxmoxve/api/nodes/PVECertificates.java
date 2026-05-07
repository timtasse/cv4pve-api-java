package it.corsinvest.proxmoxve.api.nodes;

import it.corsinvest.proxmoxve.api.PveClient;
import it.corsinvest.proxmoxve.api.Result;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class PVECertificates {

    private final PveClient client;
    private final Object node;

    public PVECertificates(PveClient client, Object node) {
        this.client = client;
        this.node = node;
    }

    private PVEAcme acme;

    public PVEAcme getAcme() {
        return acme == null ? (acme = new PVEAcme(client, this.node)) : acme;
    }

    private PVEInfo info;

    public PVEInfo getInfo() {
        return info == null ? (info = new PVEInfo(client, this.node)) : info;
    }

    private PVECustom custom;

    public PVECustom getCustom() {
        return custom == null ? (custom = new PVECustom(client, this.node)) : custom;
    }

    public static class PVEAcme {

        private final PveClient client;
        private final Object node;

        protected PVEAcme(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        private PVEAcme.PVECertificate certificate;

        public PVEAcme.PVECertificate getCertificate() {
            return certificate == null ? (certificate = new PVECertificate(client, this.node))
                    : certificate;
        }

        public static class PVECertificate {

            private final PveClient client;
            private final Object node;

            protected PVECertificate(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            /**
             * Revoke existing certificate from CA.
             *
             * @return Result
             */

            public Result revokeCertificate() {
                return client.delete("/nodes/" + this.node + "/certificates/acme/certificate", null);
            }

            /**
             * Order a new certificate from ACME-compatible CA.
             *
             * @param force Overwrite existing custom certificate.
             * @return Result
             */

            public Result newCertificate(Boolean force) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("force", force);
                return client.create("/nodes/" + this.node + "/certificates/acme/certificate", parameters);
            }

            /**
             * Order a new certificate from ACME-compatible CA.
             *
             * @return Result
             */

            public Result newCertificate() {
                return client.create("/nodes/" + this.node + "/certificates/acme/certificate", null);
            }

            /**
             * Renew existing certificate from CA.
             *
             * @param force Force renewal even if expiry is more than 30 days away.
             * @return Result
             */

            public Result renewCertificate(Boolean force) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("force", force);
                return client.set("/nodes/" + this.node + "/certificates/acme/certificate", parameters);
            }

            /**
             * Renew existing certificate from CA.
             *
             * @return Result
             */

            public Result renewCertificate() {
                return client.set("/nodes/" + this.node + "/certificates/acme/certificate", null);
            }

        }

        /**
         * ACME index.
         *
         * @return Result
         */

        public Result index() {
            return client.get("/nodes/" + this.node + "/certificates/acme", null);
        }

    }

    public static class PVEInfo {

        private final PveClient client;
        private final Object node;

        protected PVEInfo(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        /**
         * Get information about node's certificates.
         *
         * @return Result
         */

        public Result info() {
            return client.get("/nodes/" + this.node + "/certificates/info", null);
        }

    }

    public static class PVECustom {

        private final PveClient client;
        private final Object node;

        protected PVECustom(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        /**
         * DELETE custom certificate chain and key.
         *
         * @param restart Restart pveproxy.
         * @return Result
         */

        public Result removeCustomCert(Boolean restart) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("restart", restart);
            return client.delete("/nodes/" + this.node + "/certificates/custom", parameters);
        }

        /**
         * DELETE custom certificate chain and key.
         *
         * @return Result
         */

        public Result removeCustomCert() {
            return client.delete("/nodes/" + this.node + "/certificates/custom", null);
        }

        /**
         * Upload or update custom certificate chain and key.
         *
         * @param certificates PEM encoded certificate (chain).
         * @param force        Overwrite existing custom or ACME certificate files.
         * @param key          PEM encoded private key.
         * @param restart      Restart pveproxy.
         * @return Result
         */

        public Result uploadCustomCert(String certificates, Boolean force, String key, Boolean restart) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("certificates", certificates);
            parameters.put("force", force);
            parameters.put("key", key);
            parameters.put("restart", restart);
            return client.create("/nodes/" + this.node + "/certificates/custom", parameters);
        }

        /**
         * Upload or update custom certificate chain and key.
         *
         * @param certificates PEM encoded certificate (chain).
         * @return Result
         */

        public Result uploadCustomCert(String certificates) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("certificates", certificates);
            return client.create("/nodes/" + this.node + "/certificates/custom", parameters);
        }

    }

    /**
     * Node index.
     *
     * @return Result
     */

    public Result index() {
        return client.get("/nodes/" + this.node + "/certificates", null);
    }

}

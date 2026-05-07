package it.corsinvest.proxmoxve.api.cluster;

import it.corsinvest.proxmoxve.api.PveClient;
import it.corsinvest.proxmoxve.api.Result;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class PVEAcme {

    private final PveClient client;

    public PVEAcme(PveClient client) {
        this.client = client;

    }

    private PVEPlugins plugins;

    public PVEPlugins getPlugins() {
        return plugins == null ? (plugins = new PVEPlugins(client)) : plugins;
    }

    private PVEAccount account;

    public PVEAccount getAccount() {
        return account == null ? (account = new PVEAccount(client)) : account;
    }

    private PVETos tos;

    public PVETos getTos() {
        return tos == null ? (tos = new PVETos(client)) : tos;
    }

    private PVEMeta meta;

    public PVEMeta getMeta() {
        return meta == null ? (meta = new PVEMeta(client)) : meta;
    }

    private PVEDirectories directories;

    public PVEDirectories getDirectories() {
        return directories == null ? (directories = new PVEDirectories(client)) : directories;
    }

    private PVEChallengeSchema challengeSchema;

    public PVEChallengeSchema getChallengeSchema() {
        return challengeSchema == null ? (challengeSchema = new PVEChallengeSchema(client)) : challengeSchema;
    }

    public static class PVEPlugins {

        private final PveClient client;

        protected PVEPlugins(PveClient client) {
            this.client = client;

        }

        public PVEPlugins.PVEIdItem get(Object id) {
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
             * Delete ACME plugin configuration.
             *
             * @return Result
             */

            public Result deletePlugin() {
                return client.delete("/cluster/acme/plugins/" + this.id, null);
            }

            /**
             * Get ACME plugin configuration.
             *
             * @return Result
             */

            public Result getPluginConfig() {
                return client.get("/cluster/acme/plugins/" + this.id, null);
            }

            /**
             * Update ACME plugin configuration.
             *
             * @param api              API plugin name
             *                         Enum:
             *                         1984hosting,acmedns,acmeproxy,active24,ad,ali,alviy,anx,artfiles,arvan,aurora,autodns,aws,azion,azure,beget,bookmyname,bunny,cf,clouddns,cloudns,cn,conoha,constellix,cpanel,curanet,cyon,da,ddnss,desec,df,dgon,dnsexit,dnshome,dnsimple,dnsservices,doapi,domeneshop,dp,dpi,dreamhost,duckdns,durabledns,dyn,dynu,dynv6,easydns,edgecenter,edgedns,euserv,exoscale,fornex,freedns,freemyip,gandi_livedns,gcloud,gcore,gd,geoscaling,googledomains,he,he_ddns,hetzner,hexonet,hostingde,huaweicloud,infoblox,infomaniak,internetbs,inwx,ionos,ionos_cloud,ipv64,ispconfig,jd,joker,kappernet,kas,kinghost,knot,la,leaseweb,lexicon,limacity,linode,linode_v4,loopia,lua,maradns,me,miab,mijnhost,misaka,myapi,mydevil,mydnsjp,mythic_beasts,namecheap,namecom,namesilo,nanelo,nederhost,neodigit,netcup,netlify,nic,njalla,nm,nsd,nsone,nsupdate,nw,oci,omglol,one,online,openprovider,openstack,opnsense,ovh,pdns,pleskxml,pointhq,porkbun,rackcorp,rackspace,rage4,rcode0,regru,scaleway,schlundtech,selectel,selfhost,servercow,simply,technitium,tele3,tencent,timeweb,transip,udr,ultra,unoeuro,variomedia,veesp,vercel,vscale,vultr,websupport,west_cn,world4you,yandex360,yc,zilore,zone,zoneedit,zonomi
             * @param data             DNS plugin data. (base64 encoded)
             * @param delete           A list of settings you want to delete.
             * @param digest           Prevent changes if current configuration file has a
             *                         different digest. This can be used to prevent
             *                         concurrent modifications.
             * @param disable          Flag to disable the config.
             * @param nodes            List of cluster node names.
             * @param validation_delay Extra delay in seconds to wait before requesting
             *                         validation. Allows to cope with a long TTL of DNS
             *                         records.
             * @return Result
             */

            public Result updatePlugin(String api, String data, String delete, String digest, Boolean disable,
                                       String nodes, Integer validation_delay) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("api", api);
                parameters.put("data", data);
                parameters.put("delete", delete);
                parameters.put("digest", digest);
                parameters.put("disable", disable);
                parameters.put("nodes", nodes);
                parameters.put("validation-delay", validation_delay);
                return client.set("/cluster/acme/plugins/" + this.id, parameters);
            }

            /**
             * Update ACME plugin configuration.
             *
             * @return Result
             */

            public Result updatePlugin() {
                return client.set("/cluster/acme/plugins/" + this.id, null);
            }

        }

        /**
         * ACME plugin index.
         *
         * @param type Only list ACME plugins of a specific type
         *             Enum: dns,standalone
         * @return Result
         */

        public Result index(String type) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("type", type);
            return client.get("/cluster/acme/plugins", parameters);
        }

        /**
         * ACME plugin index.
         *
         * @return Result
         */

        public Result index() {
            return client.get("/cluster/acme/plugins", null);
        }

        /**
         * Add ACME plugin configuration.
         *
         * @param id               ACME Plugin ID name
         * @param type             ACME challenge type.
         *                         Enum: dns,standalone
         * @param api              API plugin name
         *                         Enum:
         *                         1984hosting,acmedns,acmeproxy,active24,ad,ali,alviy,anx,artfiles,arvan,aurora,autodns,aws,azion,azure,beget,bookmyname,bunny,cf,clouddns,cloudns,cn,conoha,constellix,cpanel,curanet,cyon,da,ddnss,desec,df,dgon,dnsexit,dnshome,dnsimple,dnsservices,doapi,domeneshop,dp,dpi,dreamhost,duckdns,durabledns,dyn,dynu,dynv6,easydns,edgecenter,edgedns,euserv,exoscale,fornex,freedns,freemyip,gandi_livedns,gcloud,gcore,gd,geoscaling,googledomains,he,he_ddns,hetzner,hexonet,hostingde,huaweicloud,infoblox,infomaniak,internetbs,inwx,ionos,ionos_cloud,ipv64,ispconfig,jd,joker,kappernet,kas,kinghost,knot,la,leaseweb,lexicon,limacity,linode,linode_v4,loopia,lua,maradns,me,miab,mijnhost,misaka,myapi,mydevil,mydnsjp,mythic_beasts,namecheap,namecom,namesilo,nanelo,nederhost,neodigit,netcup,netlify,nic,njalla,nm,nsd,nsone,nsupdate,nw,oci,omglol,one,online,openprovider,openstack,opnsense,ovh,pdns,pleskxml,pointhq,porkbun,rackcorp,rackspace,rage4,rcode0,regru,scaleway,schlundtech,selectel,selfhost,servercow,simply,technitium,tele3,tencent,timeweb,transip,udr,ultra,unoeuro,variomedia,veesp,vercel,vscale,vultr,websupport,west_cn,world4you,yandex360,yc,zilore,zone,zoneedit,zonomi
         * @param data             DNS plugin data. (base64 encoded)
         * @param disable          Flag to disable the config.
         * @param nodes            List of cluster node names.
         * @param validation_delay Extra delay in seconds to wait before requesting
         *                         validation. Allows to cope with a long TTL of DNS
         *                         records.
         * @return Result
         */

        public Result addPlugin(String id, String type, String api, String data, Boolean disable, String nodes,
                                Integer validation_delay) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("id", id);
            parameters.put("type", type);
            parameters.put("api", api);
            parameters.put("data", data);
            parameters.put("disable", disable);
            parameters.put("nodes", nodes);
            parameters.put("validation-delay", validation_delay);
            return client.create("/cluster/acme/plugins", parameters);
        }

        /**
         * Add ACME plugin configuration.
         *
         * @param id   ACME Plugin ID name
         * @param type ACME challenge type.
         *             Enum: dns,standalone
         * @return Result
         */

        public Result addPlugin(String id, String type) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("id", id);
            parameters.put("type", type);
            return client.create("/cluster/acme/plugins", parameters);
        }

    }

    public static class PVEAccount {

        private final PveClient client;

        protected PVEAccount(PveClient client) {
            this.client = client;

        }

        public PVEAccount.PVENameItem get(Object name) {
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
             * Deactivate existing ACME account at CA.
             *
             * @return Result
             */

            public Result deactivateAccount() {
                return client.delete("/cluster/acme/account/" + this.name, null);
            }

            /**
             * Return existing ACME account information.
             *
             * @return Result
             */

            public Result getAccount() {
                return client.get("/cluster/acme/account/" + this.name, null);
            }

            /**
             * Update existing ACME account information with CA. Note: not specifying any
             * new account information triggers a refresh.
             *
             * @param contact Contact email addresses.
             * @return Result
             */

            public Result updateAccount(String contact) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("contact", contact);
                return client.set("/cluster/acme/account/" + this.name, parameters);
            }

            /**
             * Update existing ACME account information with CA. Note: not specifying any
             * new account information triggers a refresh.
             *
             * @return Result
             */

            public Result updateAccount() {
                return client.set("/cluster/acme/account/" + this.name, null);
            }

        }

        /**
         * ACMEAccount index.
         *
         * @return Result
         */

        public Result accountIndex() {
            return client.get("/cluster/acme/account", null);
        }

        /**
         * Register a new ACME account with CA.
         *
         * @param contact      Contact email addresses.
         * @param directory    URL of ACME CA directory endpoint.
         * @param eab_hmac_key HMAC key for External Account Binding.
         * @param eab_kid      Key Identifier for External Account Binding.
         * @param name         ACME account config file name.
         * @param tos_url      URL of CA TermsOfService - setting this indicates
         *                     agreement.
         * @return Result
         */

        public Result registerAccount(String contact, String directory, String eab_hmac_key, String eab_kid,
                                      String name, String tos_url) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("contact", contact);
            parameters.put("directory", directory);
            parameters.put("eab-hmac-key", eab_hmac_key);
            parameters.put("eab-kid", eab_kid);
            parameters.put("name", name);
            parameters.put("tos_url", tos_url);
            return client.create("/cluster/acme/account", parameters);
        }

        /**
         * Register a new ACME account with CA.
         *
         * @param contact Contact email addresses.
         * @return Result
         */

        public Result registerAccount(String contact) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("contact", contact);
            return client.create("/cluster/acme/account", parameters);
        }

    }

    public static class PVETos {

        private final PveClient client;

        protected PVETos(PveClient client) {
            this.client = client;

        }

        /**
         * Retrieve ACME TermsOfService URL from CA. Deprecated, please use
         * /cluster/acme/meta.
         *
         * @param directory URL of ACME CA directory endpoint.
         * @return Result
         */

        public Result getTos(String directory) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("directory", directory);
            return client.get("/cluster/acme/tos", parameters);
        }

        /**
         * Retrieve ACME TermsOfService URL from CA. Deprecated, please use
         * /cluster/acme/meta.
         *
         * @return Result
         */

        public Result getTos() {
            return client.get("/cluster/acme/tos", null);
        }

    }

    public static class PVEMeta {

        private final PveClient client;

        protected PVEMeta(PveClient client) {
            this.client = client;

        }

        /**
         * Retrieve ACME Directory Meta Information
         *
         * @param directory URL of ACME CA directory endpoint.
         * @return Result
         */

        public Result getMeta(String directory) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("directory", directory);
            return client.get("/cluster/acme/meta", parameters);
        }

        /**
         * Retrieve ACME Directory Meta Information
         *
         * @return Result
         */

        public Result getMeta() {
            return client.get("/cluster/acme/meta", null);
        }

    }

    public static class PVEDirectories {

        private final PveClient client;

        protected PVEDirectories(PveClient client) {
            this.client = client;

        }

        /**
         * Get named known ACME directory endpoints.
         *
         * @return Result
         */

        public Result getDirectories() {
            return client.get("/cluster/acme/directories", null);
        }

    }

    public static class PVEChallengeSchema {

        private final PveClient client;

        protected PVEChallengeSchema(PveClient client) {
            this.client = client;

        }

        /**
         * Get schema of ACME challenge types.
         *
         * @return Result
         */

        public Result challengeschema() {
            return client.get("/cluster/acme/challenge-schema", null);
        }

    }

    /**
     * ACMEAccount index.
     *
     * @return Result
     */

    public Result index() {
        return client.get("/cluster/acme", null);
    }

}

package it.corsinvest.proxmoxve.api.nodes;

import it.corsinvest.proxmoxve.api.PveClient;
import it.corsinvest.proxmoxve.api.Result;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class PVEScan {

    private final PveClient client;
    private final Object node;

    public PVEScan(PveClient client, Object node) {
        this.client = client;
        this.node = node;
    }

    private PVENfs nfs;

    public PVENfs getNfs() {
        return nfs == null ? (nfs = new PVENfs(client, this.node)) : nfs;
    }

    private PVECifs cifs;

    public PVECifs getCifs() {
        return cifs == null ? (cifs = new PVECifs(client, this.node)) : cifs;
    }

    private PVEPbs pbs;

    public PVEPbs getPbs() {
        return pbs == null ? (pbs = new PVEPbs(client, this.node)) : pbs;
    }

    private PVEIscsi iscsi;

    public PVEIscsi getIscsi() {
        return iscsi == null ? (iscsi = new PVEIscsi(client, this.node)) : iscsi;
    }

    private PVELvm lvm;

    public PVELvm getLvm() {
        return lvm == null ? (lvm = new PVELvm(client, this.node)) : lvm;
    }

    private PVELvmthin lvmthin;

    public PVELvmthin getLvmthin() {
        return lvmthin == null ? (lvmthin = new PVELvmthin(client, this.node)) : lvmthin;
    }

    private PVEZfs zfs;

    public PVEZfs getZfs() {
        return zfs == null ? (zfs = new PVEZfs(client, this.node)) : zfs;
    }

    public static class PVENfs {

        private final PveClient client;
        private final Object node;

        protected PVENfs(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        /**
         * Scan remote NFS server.
         *
         * @param server The server address (name or IP).
         * @return Result
         */

        public Result nfsscan(String server) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("server", server);
            return client.get("/nodes/" + this.node + "/scan/nfs", parameters);
        }

    }

    public static class PVECifs {

        private final PveClient client;
        private final Object node;

        protected PVECifs(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        /**
         * Scan remote CIFS server.
         *
         * @param server   The server address (name or IP).
         * @param domain   SMB domain (Workgroup).
         * @param password User password.
         * @param username User name.
         * @return Result
         */

        public Result cifsscan(String server, String domain, String password, String username) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("server", server);
            parameters.put("domain", domain);
            parameters.put("password", password);
            parameters.put("username", username);
            return client.get("/nodes/" + this.node + "/scan/cifs", parameters);
        }

        /**
         * Scan remote CIFS server.
         *
         * @param server The server address (name or IP).
         * @return Result
         */

        public Result cifsscan(String server) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("server", server);
            return client.get("/nodes/" + this.node + "/scan/cifs", parameters);
        }

    }

    public static class PVEPbs {

        private final PveClient client;
        private final Object node;

        protected PVEPbs(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        /**
         * Scan remote Proxmox Backup Server.
         *
         * @param password    User password or API token secret.
         * @param server      The server address (name or IP).
         * @param username    User-name or API token-ID.
         * @param fingerprint Certificate SHA 256 fingerprint.
         * @param port        Optional port.
         * @return Result
         */

        public Result pbsscan(String password, String server, String username, String fingerprint,
                              Integer port) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("password", password);
            parameters.put("server", server);
            parameters.put("username", username);
            parameters.put("fingerprint", fingerprint);
            parameters.put("port", port);
            return client.get("/nodes/" + this.node + "/scan/pbs", parameters);
        }

        /**
         * Scan remote Proxmox Backup Server.
         *
         * @param password User password or API token secret.
         * @param server   The server address (name or IP).
         * @param username User-name or API token-ID.
         * @return Result
         */

        public Result pbsscan(String password, String server, String username) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("password", password);
            parameters.put("server", server);
            parameters.put("username", username);
            return client.get("/nodes/" + this.node + "/scan/pbs", parameters);
        }

    }

    public static class PVEIscsi {

        private final PveClient client;
        private final Object node;

        protected PVEIscsi(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        /**
         * Scan remote iSCSI server.
         *
         * @param portal The iSCSI portal (IP or DNS name with optional port).
         * @return Result
         */

        public Result iscsiscan(String portal) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("portal", portal);
            return client.get("/nodes/" + this.node + "/scan/iscsi", parameters);
        }

    }

    public static class PVELvm {

        private final PveClient client;
        private final Object node;

        protected PVELvm(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        /**
         * List local LVM volume groups.
         *
         * @return Result
         */

        public Result lvmscan() {
            return client.get("/nodes/" + this.node + "/scan/lvm", null);
        }

    }

    public static class PVELvmthin {

        private final PveClient client;
        private final Object node;

        protected PVELvmthin(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        /**
         * List local LVM Thin Pools.
         *
         * @param vg
         * @return Result
         */

        public Result lvmthinscan(String vg) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("vg", vg);
            return client.get("/nodes/" + this.node + "/scan/lvmthin", parameters);
        }

    }

    public static class PVEZfs {

        private final PveClient client;
        private final Object node;

        protected PVEZfs(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        /**
         * Scan zfs pool list on local node.
         *
         * @return Result
         */

        public Result zfsscan() {
            return client.get("/nodes/" + this.node + "/scan/zfs", null);
        }

    }

    /**
     * Index of available scan methods
     *
     * @return Result
     */

    public Result index() {
        return client.get("/nodes/" + this.node + "/scan", null);
    }

}

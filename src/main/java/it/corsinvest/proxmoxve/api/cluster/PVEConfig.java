package it.corsinvest.proxmoxve.api.cluster;

import it.corsinvest.proxmoxve.api.PveClient;
import it.corsinvest.proxmoxve.api.Result;

import java.util.HashMap;
import java.util.Map;

import static it.corsinvest.proxmoxve.api.PveClientBase.addIndexedParameter;

@SuppressWarnings("unused")
public class PVEConfig {

    private final PveClient client;

    public PVEConfig(PveClient client) {
        this.client = client;

    }

    private PVEApiversion apiversion;

    public PVEApiversion getApiversion() {
        return apiversion == null ? (apiversion = new PVEApiversion(client)) : apiversion;
    }

    private PVENodes nodes;

    public PVENodes getNodes() {
        return nodes == null ? (nodes = new PVENodes(client)) : nodes;
    }

    private PVEJoin join;

    public PVEJoin getJoin() {
        return join == null ? (join = new PVEJoin(client)) : join;
    }

    private PVETotem totem;

    public PVETotem getTotem() {
        return totem == null ? (totem = new PVETotem(client)) : totem;
    }

    private PVEQdevice qdevice;

    public PVEQdevice getQdevice() {
        return qdevice == null ? (qdevice = new PVEQdevice(client)) : qdevice;
    }

    public static class PVEApiversion {

        private final PveClient client;

        protected PVEApiversion(PveClient client) {
            this.client = client;

        }

        /**
         * Return the version of the cluster join API available on this node.
         *
         * @return Result
         */

        public Result joinApiVersion() {
            return client.get("/cluster/config/apiversion", null);
        }

    }

    public static class PVENodes {

        private final PveClient client;

        protected PVENodes(PveClient client) {
            this.client = client;

        }

        public PVENodes.PVENodeItem get(Object node) {
            return new PVENodeItem(client, node);
        }

        public static class PVENodeItem {

            private final PveClient client;
            private final Object node;

            protected PVENodeItem(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            /**
             * Removes a node from the cluster configuration.
             *
             * @return Result
             */

            public Result delnode() {
                return client.delete("/cluster/config/nodes/" + this.node, null);
            }

            /**
             * Adds a node to the cluster configuration. This call is for internal use.
             *
             * @param apiversion  The JOIN_API_VERSION of the new node.
             * @param force       Do not throw error if node already exists.
             * @param linkN       Address and priority information of a single corosync
             *                    link. (up to 8 links supported; link0..link7)
             * @param newNodeIp IP Address of node to add. Used as fallback if no links
             *                    are given.
             * @param nodeid      Node id for this node.
             * @param votes       Number of votes for this node
             * @return Result
             */

            public Result addnode(Integer apiversion, Boolean force, Map<Integer, String> linkN,
                                  String newNodeIp, Integer nodeid, Integer votes) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("apiversion", apiversion);
                parameters.put("force", force);
                parameters.put("new_node_ip", newNodeIp);
                parameters.put("nodeid", nodeid);
                parameters.put("votes", votes);
                addIndexedParameter(parameters, "link", linkN);
                return client.create("/cluster/config/nodes/" + this.node, parameters);
            }

            /**
             * Adds a node to the cluster configuration. This call is for internal use.
             *
             * @return Result
             */

            public Result addnode() {
                return client.create("/cluster/config/nodes/" + this.node, null);
            }

        }

        /**
         * Corosync node list.
         *
         * @return Result
         */

        public Result nodes() {
            return client.get("/cluster/config/nodes", null);
        }

    }

    public static class PVEJoin {

        private final PveClient client;

        protected PVEJoin(PveClient client) {
            this.client = client;

        }

        /**
         * Get information needed to join this cluster over the connected node.
         *
         * @param node The node for which the joinee gets the nodeinfo.
         * @return Result
         */

        public Result joinInfo(String node) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("node", node);
            return client.get("/cluster/config/join", parameters);
        }

        /**
         * Get information needed to join this cluster over the connected node.
         *
         * @return Result
         */

        public Result joinInfo() {
            return client.get("/cluster/config/join", null);
        }

        /**
         * Joins this node into an existing cluster. If no links are given, default to
         * IP resolved by node's hostname on single link (fallback fails for clusters
         * with multiple links).
         *
         * @param fingerprint Certificate SHA 256 fingerprint.
         * @param hostname    Hostname (or IP) of an existing cluster member.
         * @param password    Superuser (root) password of peer node.
         * @param force       Do not throw error if node already exists.
         * @param linkN       Address and priority information of a single corosync
         *                    link. (up to 8 links supported; link0..link7)
         * @param nodeid      Node id for this node.
         * @param votes       Number of votes for this node
         * @return Result
         */

        public Result join(String fingerprint, String hostname, String password, Boolean force,
                           Map<Integer, String> linkN, Integer nodeid, Integer votes) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("fingerprint", fingerprint);
            parameters.put("hostname", hostname);
            parameters.put("password", password);
            parameters.put("force", force);
            parameters.put("nodeid", nodeid);
            parameters.put("votes", votes);
            addIndexedParameter(parameters, "link", linkN);
            return client.create("/cluster/config/join", parameters);
        }

        /**
         * Joins this node into an existing cluster. If no links are given, default to
         * IP resolved by node's hostname on single link (fallback fails for clusters
         * with multiple links).
         *
         * @param fingerprint Certificate SHA 256 fingerprint.
         * @param hostname    Hostname (or IP) of an existing cluster member.
         * @param password    Superuser (root) password of peer node.
         * @return Result
         */

        public Result join(String fingerprint, String hostname, String password) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("fingerprint", fingerprint);
            parameters.put("hostname", hostname);
            parameters.put("password", password);
            return client.create("/cluster/config/join", parameters);
        }

    }

    public static class PVETotem {

        private final PveClient client;

        protected PVETotem(PveClient client) {
            this.client = client;

        }

        /**
         * Get corosync totem protocol settings.
         *
         * @return Result
         */

        public Result totem() {
            return client.get("/cluster/config/totem", null);
        }

    }

    public static class PVEQdevice {

        private final PveClient client;

        protected PVEQdevice(PveClient client) {
            this.client = client;

        }

        /**
         * Get QDevice status
         *
         * @return Result
         */

        public Result status() {
            return client.get("/cluster/config/qdevice", null);
        }

    }

    /**
     * Directory index.
     *
     * @return Result
     */

    public Result index() {
        return client.get("/cluster/config", null);
    }

    /**
     * Generate new cluster configuration. If no links given, default to local IP
     * address as link0.
     *
     * @param clustername The name of the cluster.
     * @param linkN       Address and priority information of a single corosync
     *                    link. (up to 8 links supported; link0..link7)
     * @param nodeid      Node id for this node.
     * @param votes       Number of votes for this node.
     * @return Result
     */

    public Result create(String clustername, Map<Integer, String> linkN, Integer nodeid, Integer votes) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("clustername", clustername);
        parameters.put("nodeid", nodeid);
        parameters.put("votes", votes);
        addIndexedParameter(parameters, "link", linkN);
        return client.create("/cluster/config", parameters);
    }

    /**
     * Generate new cluster configuration. If no links given, default to local IP
     * address as link0.
     *
     * @param clustername The name of the cluster.
     * @return Result
     */

    public Result create(String clustername) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("clustername", clustername);
        return client.create("/cluster/config", parameters);
    }

}

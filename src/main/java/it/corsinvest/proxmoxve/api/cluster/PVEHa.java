package it.corsinvest.proxmoxve.api.cluster;

import it.corsinvest.proxmoxve.api.PveClient;
import it.corsinvest.proxmoxve.api.Result;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class PVEHa {

    private final PveClient client;

    public PVEHa(PveClient client) {
        this.client = client;

    }

    private PVEResources resources;

    public PVEResources getResources() {
        return resources == null ? (resources = new PVEResources(client)) : resources;
    }

    private PVEGroups groups;

    public PVEGroups getGroups() {
        return groups == null ? (groups = new PVEGroups(client)) : groups;
    }

    private PVERules rules;

    public PVERules getRules() {
        return rules == null ? (rules = new PVERules(client)) : rules;
    }

    private PVEStatus status;

    public PVEStatus getStatus() {
        return status == null ? (status = new PVEStatus(client)) : status;
    }

    public static class PVEResources {

        private final PveClient client;

        protected PVEResources(PveClient client) {
            this.client = client;

        }

        public PVEResources.PVESidItem get(Object sid) {
            return new PVESidItem(client, sid);
        }

        public static class PVESidItem {

            private final PveClient client;
            private final Object sid;

            protected PVESidItem(PveClient client, Object sid) {
                this.client = client;
                this.sid = sid;
            }

            private PVEResources.PVESidItem.PVEMigrate migrate;

            public PVEResources.PVESidItem.PVEMigrate getMigrate() {
                return migrate == null ? (migrate = new PVEMigrate(client, this.sid)) : migrate;
            }

            private PVEResources.PVESidItem.PVERelocate relocate;

            public PVEResources.PVESidItem.PVERelocate getRelocate() {
                return relocate == null ? (relocate = new PVERelocate(client, this.sid)) : relocate;
            }

            public static class PVEMigrate {

                private final PveClient client;
                private final Object sid;

                protected PVEMigrate(PveClient client, Object sid) {
                    this.client = client;
                    this.sid = sid;
                }

                /**
                 * Request resource migration (online) to another node.
                 *
                 * @param node Target node.
                 * @return Result
                 */

                public Result migrate(String node) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("node", node);
                    return client.create("/cluster/ha/resources/" + this.sid + "/migrate", parameters);
                }

            }

            public static class PVERelocate {

                private final PveClient client;
                private final Object sid;

                protected PVERelocate(PveClient client, Object sid) {
                    this.client = client;
                    this.sid = sid;
                }

                /**
                 * Request resource relocatzion to another node. This stops the service on the
                 * old node, and restarts it on the target node.
                 *
                 * @param node Target node.
                 * @return Result
                 */

                public Result relocate(String node) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("node", node);
                    return client.create("/cluster/ha/resources/" + this.sid + "/relocate", parameters);
                }

            }

            /**
             * Delete resource configuration.
             *
             * @param purge Remove this resource from rules that reference it, deleting the
             *              rule if this resource is the only resource in the rule
             * @return Result
             */

            public Result delete(Boolean purge) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("purge", purge);
                return client.delete("/cluster/ha/resources/" + this.sid, parameters);
            }

            /**
             * Delete resource configuration.
             *
             * @return Result
             */

            public Result delete() {
                return client.delete("/cluster/ha/resources/" + this.sid, null);
            }

            /**
             * Read resource configuration.
             *
             * @return Result
             */

            public Result read() {
                return client.get("/cluster/ha/resources/" + this.sid, null);
            }

            /**
             * Update resource configuration.
             *
             * @param comment      Description.
             * @param delete       A list of settings you want to delete.
             * @param digest       Prevent changes if current configuration file has a
             *                     different digest. This can be used to prevent concurrent
             *                     modifications.
             * @param failback     Automatically migrate HA resource to the node with the
             *                     highest priority according to their node affinity rules,
             *                     if a node with a higher priority than the current node
             *                     comes online.
             * @param group        The HA group identifier.
             * @param max_relocate Maximal number of service relocate tries when a service
             *                     failes to start.
             * @param max_restart  Maximal number of tries to restart the service on a node
             *                     after its start failed.
             * @param state        Requested resource state.
             *                     Enum: started,stopped,enabled,disabled,ignored
             * @return Result
             */

            public Result update(String comment, String delete, String digest, Boolean failback, String group,
                                 Integer max_relocate, Integer max_restart, String state) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("comment", comment);
                parameters.put("delete", delete);
                parameters.put("digest", digest);
                parameters.put("failback", failback);
                parameters.put("group", group);
                parameters.put("max_relocate", max_relocate);
                parameters.put("max_restart", max_restart);
                parameters.put("state", state);
                return client.set("/cluster/ha/resources/" + this.sid, parameters);
            }

            /**
             * Update resource configuration.
             *
             * @return Result
             */

            public Result update() {
                return client.set("/cluster/ha/resources/" + this.sid, null);
            }

        }

        /**
         * List HA resources.
         *
         * @param type Only list resources of specific type
         *             Enum: ct,vm
         * @return Result
         */

        public Result index(String type) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("type", type);
            return client.get("/cluster/ha/resources", parameters);
        }

        /**
         * List HA resources.
         *
         * @return Result
         */

        public Result index() {
            return client.get("/cluster/ha/resources", null);
        }

        /**
         * Create a new HA resource.
         *
         * @param sid          HA resource ID. This consists of a resource type followed
         *                     by a resource specific name, separated with colon
         *                     (example: vm:100 / ct:100). For virtual machines and
         *                     containers, you can simply use the VM or CT id as a
         *                     shortcut (example: 100).
         * @param comment      Description.
         * @param failback     Automatically migrate HA resource to the node with the
         *                     highest priority according to their node affinity rules,
         *                     if a node with a higher priority than the current node
         *                     comes online.
         * @param group        The HA group identifier.
         * @param max_relocate Maximal number of service relocate tries when a service
         *                     failes to start.
         * @param max_restart  Maximal number of tries to restart the service on a node
         *                     after its start failed.
         * @param state        Requested resource state.
         *                     Enum: started,stopped,enabled,disabled,ignored
         * @param type         Resource type.
         *                     Enum: ct,vm
         * @return Result
         */

        public Result create(String sid, String comment, Boolean failback, String group, Integer max_relocate,
                             Integer max_restart, String state, String type) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("sid", sid);
            parameters.put("comment", comment);
            parameters.put("failback", failback);
            parameters.put("group", group);
            parameters.put("max_relocate", max_relocate);
            parameters.put("max_restart", max_restart);
            parameters.put("state", state);
            parameters.put("type", type);
            return client.create("/cluster/ha/resources", parameters);
        }

        /**
         * Create a new HA resource.
         *
         * @param sid HA resource ID. This consists of a resource type followed by a
         *            resource specific name, separated with colon (example: vm:100 /
         *            ct:100). For virtual machines and containers, you can simply use
         *            the VM or CT id as a shortcut (example: 100).
         * @return Result
         */

        public Result create(String sid) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("sid", sid);
            return client.create("/cluster/ha/resources", parameters);
        }

    }

    public static class PVEGroups {

        private final PveClient client;

        protected PVEGroups(PveClient client) {
            this.client = client;

        }

        public PVEGroups.PVEGroupItem get(Object group) {
            return new PVEGroupItem(client, group);
        }

        public static class PVEGroupItem {

            private final PveClient client;
            private final Object group;

            protected PVEGroupItem(PveClient client, Object group) {
                this.client = client;
                this.group = group;
            }

            /**
             * Delete ha group configuration. (deprecated in favor of HA rules)
             *
             * @return Result
             */

            public Result delete() {
                return client.delete("/cluster/ha/groups/" + this.group, null);
            }

            /**
             * Read ha group configuration. (deprecated in favor of HA rules)
             *
             * @return Result
             */

            public Result read() {
                return client.get("/cluster/ha/groups/" + this.group, null);
            }

            /**
             * Update ha group configuration. (deprecated in favor of HA rules)
             *
             * @param comment    Description.
             * @param delete     A list of settings you want to delete.
             * @param digest     Prevent changes if current configuration file has a
             *                   different digest. This can be used to prevent concurrent
             *                   modifications.
             * @param nodes      List of cluster node names with optional priority.
             * @param nofailback The CRM tries to run services on the node with the highest
             *                   priority. If a node with higher priority comes online, the
             *                   CRM migrates the service to that node. Enabling nofailback
             *                   prevents that behavior.
             * @param restricted Resources bound to restricted groups may only run on nodes
             *                   defined by the group.
             * @return Result
             */

            public Result update(String comment, String delete, String digest, String nodes, Boolean nofailback,
                                 Boolean restricted) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("comment", comment);
                parameters.put("delete", delete);
                parameters.put("digest", digest);
                parameters.put("nodes", nodes);
                parameters.put("nofailback", nofailback);
                parameters.put("restricted", restricted);
                return client.set("/cluster/ha/groups/" + this.group, parameters);
            }

            /**
             * Update ha group configuration. (deprecated in favor of HA rules)
             *
             * @return Result
             */

            public Result update() {
                return client.set("/cluster/ha/groups/" + this.group, null);
            }

        }

        /**
         * Get HA groups. (deprecated in favor of HA rules)
         *
         * @return Result
         */

        public Result index() {
            return client.get("/cluster/ha/groups", null);
        }

        /**
         * Create a new HA group. (deprecated in favor of HA rules)
         *
         * @param group      The HA group identifier.
         * @param nodes      List of cluster node names with optional priority.
         * @param comment    Description.
         * @param nofailback The CRM tries to run services on the node with the highest
         *                   priority. If a node with higher priority comes online, the
         *                   CRM migrates the service to that node. Enabling nofailback
         *                   prevents that behavior.
         * @param restricted Resources bound to restricted groups may only run on nodes
         *                   defined by the group.
         * @param type       Group type.
         *                   Enum: group
         * @return Result
         */

        public Result create(String group, String nodes, String comment, Boolean nofailback, Boolean restricted,
                             String type) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("group", group);
            parameters.put("nodes", nodes);
            parameters.put("comment", comment);
            parameters.put("nofailback", nofailback);
            parameters.put("restricted", restricted);
            parameters.put("type", type);
            return client.create("/cluster/ha/groups", parameters);
        }

        /**
         * Create a new HA group. (deprecated in favor of HA rules)
         *
         * @param group The HA group identifier.
         * @param nodes List of cluster node names with optional priority.
         * @return Result
         */

        public Result create(String group, String nodes) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("group", group);
            parameters.put("nodes", nodes);
            return client.create("/cluster/ha/groups", parameters);
        }

    }

    public static class PVERules {

        private final PveClient client;

        protected PVERules(PveClient client) {
            this.client = client;

        }

        public PVERules.PVERuleItem get(Object rule) {
            return new PVERuleItem(client, rule);
        }

        public static class PVERuleItem {

            private final PveClient client;
            private final Object rule;

            protected PVERuleItem(PveClient client, Object rule) {
                this.client = client;
                this.rule = rule;
            }

            /**
             * Delete HA rule.
             *
             * @return Result
             */

            public Result deleteRule() {
                return client.delete("/cluster/ha/rules/" + this.rule, null);
            }

            /**
             * Read HA rule.
             *
             * @return Result
             */

            public Result readRule() {
                return client.get("/cluster/ha/rules/" + this.rule, null);
            }

            /**
             * Update HA rule.
             *
             * @param type      HA rule type.
             *                  Enum: node-affinity,resource-affinity
             * @param affinity  Describes whether the HA resources are supposed to be kept
             *                  on the same node ('positive'), or are supposed to be kept on
             *                  separate nodes ('negative').
             *                  Enum: positive,negative
             * @param comment   HA rule description.
             * @param delete    A list of settings you want to delete.
             * @param digest    Prevent changes if current configuration file has a
             *                  different digest. This can be used to prevent concurrent
             *                  modifications.
             * @param disable   Whether the HA rule is disabled.
             * @param nodes     List of cluster node names with optional priority.
             * @param resources List of HA resource IDs. This consists of a list of resource
             *                  types followed by a resource specific name separated with a
             *                  colon (example: vm:100,ct:101).
             * @param strict    Describes whether the node affinity rule is strict or
             *                  non-strict.
             * @return Result
             */

            public Result updateRule(String type, String affinity, String comment, String delete, String digest,
                                     Boolean disable, String nodes, String resources, Boolean strict) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("type", type);
                parameters.put("affinity", affinity);
                parameters.put("comment", comment);
                parameters.put("delete", delete);
                parameters.put("digest", digest);
                parameters.put("disable", disable);
                parameters.put("nodes", nodes);
                parameters.put("resources", resources);
                parameters.put("strict", strict);
                return client.set("/cluster/ha/rules/" + this.rule, parameters);
            }

            /**
             * Update HA rule.
             *
             * @param type HA rule type.
             *             Enum: node-affinity,resource-affinity
             * @return Result
             */

            public Result updateRule(String type) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("type", type);
                return client.set("/cluster/ha/rules/" + this.rule, parameters);
            }

        }

        /**
         * Get HA rules.
         *
         * @param resource Limit the returned list to rules affecting the specified
         *                 resource.
         * @param type     Limit the returned list to the specified rule type.
         *                 Enum: node-affinity,resource-affinity
         * @return Result
         */

        public Result index(String resource, String type) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("resource", resource);
            parameters.put("type", type);
            return client.get("/cluster/ha/rules", parameters);
        }

        /**
         * Get HA rules.
         *
         * @return Result
         */

        public Result index() {
            return client.get("/cluster/ha/rules", null);
        }

        /**
         * Create HA rule.
         *
         * @param resources List of HA resource IDs. This consists of a list of resource
         *                  types followed by a resource specific name separated with a
         *                  colon (example: vm:100,ct:101).
         * @param rule      HA rule identifier.
         * @param type      HA rule type.
         *                  Enum: node-affinity,resource-affinity
         * @param affinity  Describes whether the HA resources are supposed to be kept
         *                  on the same node ('positive'), or are supposed to be kept on
         *                  separate nodes ('negative').
         *                  Enum: positive,negative
         * @param comment   HA rule description.
         * @param disable   Whether the HA rule is disabled.
         * @param nodes     List of cluster node names with optional priority.
         * @param strict    Describes whether the node affinity rule is strict or
         *                  non-strict.
         * @return Result
         */

        public Result createRule(String resources, String rule, String type, String affinity, String comment,
                                 Boolean disable, String nodes, Boolean strict) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("resources", resources);
            parameters.put("rule", rule);
            parameters.put("type", type);
            parameters.put("affinity", affinity);
            parameters.put("comment", comment);
            parameters.put("disable", disable);
            parameters.put("nodes", nodes);
            parameters.put("strict", strict);
            return client.create("/cluster/ha/rules", parameters);
        }

        /**
         * Create HA rule.
         *
         * @param resources List of HA resource IDs. This consists of a list of resource
         *                  types followed by a resource specific name separated with a
         *                  colon (example: vm:100,ct:101).
         * @param rule      HA rule identifier.
         * @param type      HA rule type.
         *                  Enum: node-affinity,resource-affinity
         * @return Result
         */

        public Result createRule(String resources, String rule, String type) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("resources", resources);
            parameters.put("rule", rule);
            parameters.put("type", type);
            return client.create("/cluster/ha/rules", parameters);
        }

    }

    public static class PVEStatus {

        private final PveClient client;

        protected PVEStatus(PveClient client) {
            this.client = client;

        }

        private PVEStatus.PVECurrent current;

        public PVEStatus.PVECurrent getCurrent() {
            return current == null ? (current = new PVECurrent(client)) : current;
        }

        private PVEStatus.PVEManagerStatus managerStatus;

        public PVEStatus.PVEManagerStatus getManagerStatus() {
            return managerStatus == null ? (managerStatus = new PVEManagerStatus(client)) : managerStatus;
        }

        public static class PVECurrent {

            private final PveClient client;

            protected PVECurrent(PveClient client) {
                this.client = client;

            }

            /**
             * Get HA manger status.
             *
             * @return Result
             */

            public Result status() {
                return client.get("/cluster/ha/status/current", null);
            }

        }

        public static class PVEManagerStatus {

            private final PveClient client;

            protected PVEManagerStatus(PveClient client) {
                this.client = client;

            }

            /**
             * Get full HA manger status, including LRM status.
             *
             * @return Result
             */

            public Result managerStatus() {
                return client.get("/cluster/ha/status/manager_status", null);
            }

        }

        /**
         * Directory index.
         *
         * @return Result
         */

        public Result index() {
            return client.get("/cluster/ha/status", null);
        }

    }

    /**
     * Directory index.
     *
     * @return Result
     */

    public Result index() {
        return client.get("/cluster/ha", null);
    }

}

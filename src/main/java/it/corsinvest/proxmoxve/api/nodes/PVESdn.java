package it.corsinvest.proxmoxve.api.nodes;

import it.corsinvest.proxmoxve.api.PveClient;
import it.corsinvest.proxmoxve.api.Result;

@SuppressWarnings("unused")
public class PVESdn {

    private final PveClient client;
    private final Object node;

    public PVESdn(PveClient client, Object node) {
        this.client = client;
        this.node = node;
    }

    private PVEFabrics fabrics;

    public PVEFabrics getFabrics() {
        return fabrics == null ? (fabrics = new PVEFabrics(client, this.node)) : fabrics;
    }

    private PVEZones zones;

    public PVEZones getZones() {
        return zones == null ? (zones = new PVEZones(client, this.node)) : zones;
    }

    private PVEVnets vnets;

    public PVEVnets getVnets() {
        return vnets == null ? (vnets = new PVEVnets(client, this.node)) : vnets;
    }

    public static class PVEFabrics {

        private final PveClient client;
        private final Object node;

        protected PVEFabrics(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        public PVEFabrics.PVEFabricItem get(Object fabric) {
            return new PVEFabricItem(client, this.node, fabric);
        }

        public static class PVEFabricItem {

            private final PveClient client;
            private final Object node;
            private final Object fabric;

            protected PVEFabricItem(PveClient client, Object node, Object fabric) {
                this.client = client;
                this.node = node;
                this.fabric = fabric;
            }

            private PVEFabrics.PVEFabricItem.PVERoutes routes;

            public PVEFabrics.PVEFabricItem.PVERoutes getRoutes() {
                return routes == null ? (routes = new PVERoutes(client, this.node, this.fabric)) : routes;
            }

            private PVEFabrics.PVEFabricItem.PVENeighbors neighbors;

            public PVEFabrics.PVEFabricItem.PVENeighbors getNeighbors() {
                return neighbors == null ? (neighbors = new PVENeighbors(client, this.node, this.fabric))
                        : neighbors;
            }

            private PVEFabrics.PVEFabricItem.PVEInterfaces interfaces;

            public PVEFabrics.PVEFabricItem.PVEInterfaces getInterfaces() {
                return interfaces == null ? (interfaces = new PVEInterfaces(client, this.node, this.fabric))
                        : interfaces;
            }

            public static class PVERoutes {

                private final PveClient client;
                private final Object node;
                private final Object fabric;

                protected PVERoutes(PveClient client, Object node, Object fabric) {
                    this.client = client;
                    this.node = node;
                    this.fabric = fabric;
                }

                /**
                 * Get all routes for a fabric.
                 *
                 * @return Result
                 */

                public Result routes() {
                    return client.get("/nodes/" + this.node + "/sdn/fabrics/" + this.fabric + "/routes",
                            null);
                }

            }

            public static class PVENeighbors {

                private final PveClient client;
                private final Object node;
                private final Object fabric;

                protected PVENeighbors(PveClient client, Object node, Object fabric) {
                    this.client = client;
                    this.node = node;
                    this.fabric = fabric;
                }

                /**
                 * Get all neighbors for a fabric.
                 *
                 * @return Result
                 */

                public Result neighbors() {
                    return client.get("/nodes/" + this.node + "/sdn/fabrics/" + this.fabric + "/neighbors",
                            null);
                }

            }

            public static class PVEInterfaces {

                private final PveClient client;
                private final Object node;
                private final Object fabric;

                protected PVEInterfaces(PveClient client, Object node, Object fabric) {
                    this.client = client;
                    this.node = node;
                    this.fabric = fabric;
                }

                /**
                 * Get all interfaces for a fabric.
                 *
                 * @return Result
                 */

                public Result interfaces() {
                    return client.get("/nodes/" + this.node + "/sdn/fabrics/" + this.fabric + "/interfaces",
                            null);
                }

            }

            /**
             * Directory index for SDN fabric status.
             *
             * @return Result
             */

            public Result diridx() {
                return client.get("/nodes/" + this.node + "/sdn/fabrics/" + this.fabric, null);
            }

        }

    }

    public static class PVEZones {

        private final PveClient client;
        private final Object node;

        protected PVEZones(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        public PVEZones.PVEZoneItem get(Object zone) {
            return new PVEZoneItem(client, this.node, zone);
        }

        public static class PVEZoneItem {

            private final PveClient client;
            private final Object node;
            private final Object zone;

            protected PVEZoneItem(PveClient client, Object node, Object zone) {
                this.client = client;
                this.node = node;
                this.zone = zone;
            }

            private PVEZones.PVEZoneItem.PVEContent content;

            public PVEZones.PVEZoneItem.PVEContent getContent() {
                return content == null ? (content = new PVEContent(client, this.node, this.zone)) : content;
            }

            private PVEZones.PVEZoneItem.PVEBridges bridges;

            public PVEZones.PVEZoneItem.PVEBridges getBridges() {
                return bridges == null ? (bridges = new PVEBridges(client, this.node, this.zone)) : bridges;
            }

            private PVEZones.PVEZoneItem.PVEIpVrf ipVrf;

            public PVEZones.PVEZoneItem.PVEIpVrf getIpVrf() {
                return ipVrf == null ? (ipVrf = new PVEIpVrf(client, this.node, this.zone)) : ipVrf;
            }

            public static class PVEContent {

                private final PveClient client;
                private final Object node;
                private final Object zone;

                protected PVEContent(PveClient client, Object node, Object zone) {
                    this.client = client;
                    this.node = node;
                    this.zone = zone;
                }

                /**
                 * List zone content.
                 *
                 * @return Result
                 */

                public Result index() {
                    return client.get("/nodes/" + this.node + "/sdn/zones/" + this.zone + "/content", null);
                }

            }

            public static class PVEBridges {

                private final PveClient client;
                private final Object node;
                private final Object zone;

                protected PVEBridges(PveClient client, Object node, Object zone) {
                    this.client = client;
                    this.node = node;
                    this.zone = zone;
                }

                /**
                 * Get a list of all bridges (vnets) that are part of a zone, as well as the
                 * ports that are members of that bridge.
                 *
                 * @return Result
                 */

                public Result bridges() {
                    return client.get("/nodes/" + this.node + "/sdn/zones/" + this.zone + "/bridges", null);
                }

            }

            public static class PVEIpVrf {

                private final PveClient client;
                private final Object node;
                private final Object zone;

                protected PVEIpVrf(PveClient client, Object node, Object zone) {
                    this.client = client;
                    this.node = node;
                    this.zone = zone;
                }

                /**
                 * Get the IP VRF of an EVPN zone.
                 *
                 * @return Result
                 */

                public Result ipVrf() {
                    return client.get("/nodes/" + this.node + "/sdn/zones/" + this.zone + "/ip-vrf", null);
                }

            }

            /**
             * Directory index for SDN zone status.
             *
             * @return Result
             */

            public Result diridx() {
                return client.get("/nodes/" + this.node + "/sdn/zones/" + this.zone, null);
            }

        }

        /**
         * Get status for all zones.
         *
         * @return Result
         */

        public Result index() {
            return client.get("/nodes/" + this.node + "/sdn/zones", null);
        }

    }

    public static class PVEVnets {

        private final PveClient client;
        private final Object node;

        protected PVEVnets(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        public PVEVnets.PVEVnetItem get(Object vnet) {
            return new PVEVnetItem(client, this.node, vnet);
        }

        public static class PVEVnetItem {

            private final PveClient client;
            private final Object node;
            private final Object vnet;

            protected PVEVnetItem(PveClient client, Object node, Object vnet) {
                this.client = client;
                this.node = node;
                this.vnet = vnet;
            }

            private PVEVnets.PVEVnetItem.PVEMacVrf macVrf;

            public PVEVnets.PVEVnetItem.PVEMacVrf getMacVrf() {
                return macVrf == null ? (macVrf = new PVEMacVrf(client, this.node, this.vnet)) : macVrf;
            }

            public static class PVEMacVrf {

                private final PveClient client;
                private final Object node;
                private final Object vnet;

                protected PVEMacVrf(PveClient client, Object node, Object vnet) {
                    this.client = client;
                    this.node = node;
                    this.vnet = vnet;
                }

                /**
                 * Get the MAC VRF for a VNet in an EVPN zone.
                 *
                 * @return Result
                 */

                public Result macVrf() {
                    return client.get("/nodes/" + this.node + "/sdn/vnets/" + this.vnet + "/mac-vrf", null);
                }

            }

            /**
             *
             * @return Result
             */

            public Result diridx() {
                return client.get("/nodes/" + this.node + "/sdn/vnets/" + this.vnet, null);
            }

        }

    }

    /**
     * SDN index.
     *
     * @return Result
     */

    public Result sdnindex() {
        return client.get("/nodes/" + this.node + "/sdn", null);
    }

}

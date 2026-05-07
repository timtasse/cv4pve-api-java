package it.corsinvest.proxmoxve.api.cluster;

import it.corsinvest.proxmoxve.api.PveClient;
import it.corsinvest.proxmoxve.api.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class PVEMapping {

    private final PveClient client;

    public PVEMapping(PveClient client) {
        this.client = client;

    }

    private PVEDir dir;

    public PVEDir getDir() {
        return dir == null ? (dir = new PVEDir(client)) : dir;
    }

    private PVEPci pci;

    public PVEPci getPci() {
        return pci == null ? (pci = new PVEPci(client)) : pci;
    }

    private PVEUsb usb;

    public PVEUsb getUsb() {
        return usb == null ? (usb = new PVEUsb(client)) : usb;
    }

    public static class PVEDir {

        private final PveClient client;

        protected PVEDir(PveClient client) {
            this.client = client;

        }

        public PVEDir.PVEIdItem get(Object id) {
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
             * Remove directory mapping.
             *
             * @return Result
             */

            public Result delete() {
                return client.delete("/cluster/mapping/dir/" + this.id, null);
            }

            /**
             * Get directory mapping.
             *
             * @return Result
             */

            public Result get() {
                return client.get("/cluster/mapping/dir/" + this.id, null);
            }

            /**
             * Update a directory mapping.
             *
             * @param delete      A list of settings you want to delete.
             * @param description Description of the directory mapping
             * @param digest      Prevent changes if current configuration file has a
             *                    different digest. This can be used to prevent concurrent
             *                    modifications.
             * @param map         A list of maps for the cluster nodes.
             * @return Result
             */

            public Result update(String delete, String description, String digest, List<Object> map) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("delete", delete);
                parameters.put("description", description);
                parameters.put("digest", digest);
                parameters.put("map", map);
                return client.set("/cluster/mapping/dir/" + this.id, parameters);
            }

            /**
             * Update a directory mapping.
             *
             * @return Result
             */

            public Result update() {
                return client.set("/cluster/mapping/dir/" + this.id, null);
            }

        }

        /**
         * List directory mapping
         *
         * @param check_node If given, checks the configurations on the given node for
         *                   correctness, and adds relevant diagnostics for the
         *                   directory to the response.
         * @return Result
         */

        public Result index(String check_node) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("check-node", check_node);
            return client.get("/cluster/mapping/dir", parameters);
        }

        /**
         * List directory mapping
         *
         * @return Result
         */

        public Result index() {
            return client.get("/cluster/mapping/dir", null);
        }

        /**
         * Create a new directory mapping.
         *
         * @param id          The ID of the directory mapping
         * @param map         A list of maps for the cluster nodes.
         * @param description Description of the directory mapping
         * @return Result
         */

        public Result create(String id, List<Object> map, String description) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("id", id);
            parameters.put("map", map);
            parameters.put("description", description);
            return client.create("/cluster/mapping/dir", parameters);
        }

        /**
         * Create a new directory mapping.
         *
         * @param id  The ID of the directory mapping
         * @param map A list of maps for the cluster nodes.
         * @return Result
         */

        public Result create(String id, List<Object> map) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("id", id);
            parameters.put("map", map);
            return client.create("/cluster/mapping/dir", parameters);
        }

    }

    public static class PVEPci {

        private final PveClient client;

        protected PVEPci(PveClient client) {
            this.client = client;

        }

        public PVEPci.PVEIdItem get(Object id) {
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
             * Remove Hardware Mapping.
             *
             * @return Result
             */

            public Result delete() {
                return client.delete("/cluster/mapping/pci/" + this.id, null);
            }

            /**
             * Get PCI Mapping.
             *
             * @return Result
             */

            public Result get() {
                return client.get("/cluster/mapping/pci/" + this.id, null);
            }

            /**
             * Update a hardware mapping.
             *
             * @param delete                 A list of settings you want to delete.
             * @param description            Description of the logical PCI device.
             * @param digest                 Prevent changes if current configuration file
             *                               has a different digest. This can be used to
             *                               prevent concurrent modifications.
             * @param live_migration_capable Marks the device(s) as being able to be
             *                               live-migrated (Experimental). This needs
             *                               hardware and driver support to work.
             * @param map                    A list of maps for the cluster nodes.
             * @param mdev                   Marks the device(s) as being capable of
             *                               providing mediated devices.
             * @return Result
             */

            public Result update(String delete, String description, String digest,
                                 Boolean live_migration_capable, List<Object> map, Boolean mdev) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("delete", delete);
                parameters.put("description", description);
                parameters.put("digest", digest);
                parameters.put("live-migration-capable", live_migration_capable);
                parameters.put("map", map);
                parameters.put("mdev", mdev);
                return client.set("/cluster/mapping/pci/" + this.id, parameters);
            }

            /**
             * Update a hardware mapping.
             *
             * @return Result
             */

            public Result update() {
                return client.set("/cluster/mapping/pci/" + this.id, null);
            }

        }

        /**
         * List PCI Hardware Mapping
         *
         * @param check_node If given, checks the configurations on the given node for
         *                   correctness, and adds relevant diagnostics for the devices
         *                   to the response.
         * @return Result
         */

        public Result index(String check_node) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("check-node", check_node);
            return client.get("/cluster/mapping/pci", parameters);
        }

        /**
         * List PCI Hardware Mapping
         *
         * @return Result
         */

        public Result index() {
            return client.get("/cluster/mapping/pci", null);
        }

        /**
         * Create a new hardware mapping.
         *
         * @param id                     The ID of the logical PCI mapping.
         * @param map                    A list of maps for the cluster nodes.
         * @param description            Description of the logical PCI device.
         * @param live_migration_capable Marks the device(s) as being able to be
         *                               live-migrated (Experimental). This needs
         *                               hardware and driver support to work.
         * @param mdev                   Marks the device(s) as being capable of
         *                               providing mediated devices.
         * @return Result
         */

        public Result create(String id, List<Object> map, String description, Boolean live_migration_capable,
                             Boolean mdev) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("id", id);
            parameters.put("map", map);
            parameters.put("description", description);
            parameters.put("live-migration-capable", live_migration_capable);
            parameters.put("mdev", mdev);
            return client.create("/cluster/mapping/pci", parameters);
        }

        /**
         * Create a new hardware mapping.
         *
         * @param id  The ID of the logical PCI mapping.
         * @param map A list of maps for the cluster nodes.
         * @return Result
         */

        public Result create(String id, List<Object> map) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("id", id);
            parameters.put("map", map);
            return client.create("/cluster/mapping/pci", parameters);
        }

    }

    public static class PVEUsb {

        private final PveClient client;

        protected PVEUsb(PveClient client) {
            this.client = client;

        }

        public PVEUsb.PVEIdItem get(Object id) {
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
             * Remove Hardware Mapping.
             *
             * @return Result
             */

            public Result delete() {
                return client.delete("/cluster/mapping/usb/" + this.id, null);
            }

            /**
             * Get USB Mapping.
             *
             * @return Result
             */

            public Result get() {
                return client.get("/cluster/mapping/usb/" + this.id, null);
            }

            /**
             * Update a hardware mapping.
             *
             * @param map         A list of maps for the cluster nodes.
             * @param delete      A list of settings you want to delete.
             * @param description Description of the logical USB device.
             * @param digest      Prevent changes if current configuration file has a
             *                    different digest. This can be used to prevent concurrent
             *                    modifications.
             * @return Result
             */

            public Result update(List<Object> map, String delete, String description, String digest) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("map", map);
                parameters.put("delete", delete);
                parameters.put("description", description);
                parameters.put("digest", digest);
                return client.set("/cluster/mapping/usb/" + this.id, parameters);
            }

            /**
             * Update a hardware mapping.
             *
             * @param map A list of maps for the cluster nodes.
             * @return Result
             */

            public Result update(List<Object> map) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("map", map);
                return client.set("/cluster/mapping/usb/" + this.id, parameters);
            }

        }

        /**
         * List USB Hardware Mappings
         *
         * @param check_node If given, checks the configurations on the given node for
         *                   correctness, and adds relevant errors to the devices.
         * @return Result
         */

        public Result index(String check_node) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("check-node", check_node);
            return client.get("/cluster/mapping/usb", parameters);
        }

        /**
         * List USB Hardware Mappings
         *
         * @return Result
         */

        public Result index() {
            return client.get("/cluster/mapping/usb", null);
        }

        /**
         * Create a new hardware mapping.
         *
         * @param id          The ID of the logical USB mapping.
         * @param map         A list of maps for the cluster nodes.
         * @param description Description of the logical USB device.
         * @return Result
         */

        public Result create(String id, List<Object> map, String description) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("id", id);
            parameters.put("map", map);
            parameters.put("description", description);
            return client.create("/cluster/mapping/usb", parameters);
        }

        /**
         * Create a new hardware mapping.
         *
         * @param id  The ID of the logical USB mapping.
         * @param map A list of maps for the cluster nodes.
         * @return Result
         */

        public Result create(String id, List<Object> map) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("id", id);
            parameters.put("map", map);
            return client.create("/cluster/mapping/usb", parameters);
        }

    }

    /**
     * List resource types.
     *
     * @return Result
     */

    public Result index() {
        return client.get("/cluster/mapping", null);
    }

}

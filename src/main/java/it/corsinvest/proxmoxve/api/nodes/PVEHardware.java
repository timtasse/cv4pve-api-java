package it.corsinvest.proxmoxve.api.nodes;

import it.corsinvest.proxmoxve.api.PveClient;
import it.corsinvest.proxmoxve.api.Result;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class PVEHardware {

    private final PveClient client;
    private final Object node;

    public PVEHardware(PveClient client, Object node) {
        this.client = client;
        this.node = node;
    }

    private PVEPci pci;

    public PVEPci getPci() {
        return pci == null ? (pci = new PVEPci(client, this.node)) : pci;
    }

    private PVEUsb usb;

    public PVEUsb getUsb() {
        return usb == null ? (usb = new PVEUsb(client, this.node)) : usb;
    }

    public static class PVEPci {

        private final PveClient client;
        private final Object node;

        protected PVEPci(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        public PVEPci.PVEPciIdOrMappingItem get(Object pci_id_or_mapping) {
            return new PVEPciIdOrMappingItem(client, this.node, pci_id_or_mapping);
        }

        public static class PVEPciIdOrMappingItem {

            private final PveClient client;
            private final Object node;
            private final Object pci_id_or_mapping;

            protected PVEPciIdOrMappingItem(PveClient client, Object node, Object pci_id_or_mapping) {
                this.client = client;
                this.node = node;
                this.pci_id_or_mapping = pci_id_or_mapping;
            }

            private PVEPci.PVEPciIdOrMappingItem.PVEMdev mdev;

            public PVEPci.PVEPciIdOrMappingItem.PVEMdev getMdev() {
                return mdev == null ? (mdev = new PVEMdev(client, this.node, this.pci_id_or_mapping))
                        : mdev;
            }

            public static class PVEMdev {

                private final PveClient client;
                private final Object node;
                private final Object pci_id_or_mapping;

                protected PVEMdev(PveClient client, Object node, Object pci_id_or_mapping) {
                    this.client = client;
                    this.node = node;
                    this.pci_id_or_mapping = pci_id_or_mapping;
                }

                /**
                 * List mediated device types for given PCI device.
                 *
                 * @param pci_id_or_mapping The PCI ID or mapping to list the mdev types for.
                 * @return Result
                 */

                public Result mdevscan(String pci_id_or_mapping) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("pci-id-or-mapping", pci_id_or_mapping);
                    return client.get(
                            "/nodes/" + this.node + "/hardware/pci/" + this.pci_id_or_mapping + "/mdev",
                            parameters);
                }

            }

            /**
             * Index of available pci methods
             *
             * @param pci_id_or_mapping
             * @return Result
             */

            public Result pciIndex(String pci_id_or_mapping) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("pci-id-or-mapping", pci_id_or_mapping);
                return client.get("/nodes/" + this.node + "/hardware/pci/" + this.pci_id_or_mapping,
                        parameters);
            }

        }

        /**
         * List local PCI devices.
         *
         * @param pci_class_blacklist A list of blacklisted PCI classes, which will not
         *                            be returned. Following are filtered by default:
         *                            Memory Controller (05), Bridge (06) and Processor
         *                            (0b).
         * @param verbose             If disabled, does only print the PCI IDs.
         *                            Otherwise, additional information like vendor and
         *                            device will be returned.
         * @return Result
         */

        public Result pciScan(String pci_class_blacklist, Boolean verbose) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("pci-class-blacklist", pci_class_blacklist);
            parameters.put("verbose", verbose);
            return client.get("/nodes/" + this.node + "/hardware/pci", parameters);
        }

        /**
         * List local PCI devices.
         *
         * @return Result
         */

        public Result pciScan() {
            return client.get("/nodes/" + this.node + "/hardware/pci", null);
        }

    }

    public static class PVEUsb {

        private final PveClient client;
        private final Object node;

        protected PVEUsb(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        /**
         * List local USB devices.
         *
         * @return Result
         */

        public Result usbscan() {
            return client.get("/nodes/" + this.node + "/hardware/usb", null);
        }

    }

    /**
     * Index of hardware types
     *
     * @return Result
     */

    public Result index() {
        return client.get("/nodes/" + this.node + "/hardware", null);
    }

}

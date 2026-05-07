package it.corsinvest.proxmoxve.api.nodes;

import it.corsinvest.proxmoxve.api.PveClient;
import it.corsinvest.proxmoxve.api.Result;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class PVENetwork {

    private final PveClient client;
    private final Object node;

    public PVENetwork(PveClient client, Object node) {
        this.client = client;
        this.node = node;
    }

    public PVEIfaceItem get(Object iface) {
        return new PVEIfaceItem(client, this.node, iface);
    }

    public static class PVEIfaceItem {

        private final PveClient client;
        private final Object node;
        private final Object iface;

        protected PVEIfaceItem(PveClient client, Object node, Object iface) {
            this.client = client;
            this.node = node;
            this.iface = iface;
        }

        /**
         * Delete network device configuration
         *
         * @return Result
         */

        public Result deleteNetwork() {
            return client.delete("/nodes/" + this.node + "/network/" + this.iface, null);
        }

        /**
         * Read network device configuration
         *
         * @return Result
         */

        public Result networkConfig() {
            return client.get("/nodes/" + this.node + "/network/" + this.iface, null);
        }

        /**
         * Update network device configuration
         *
         * @param type                  Network interface type
         *                              Enum:
         *                              bridge,bond,eth,alias,vlan,fabric,OVSBridge,OVSBond,OVSPort,OVSIntPort,vnet,unknown
         * @param address               IP address.
         * @param address6              IP address.
         * @param autostart             Automatically start interface on boot.
         * @param bond_primary          Specify the primary interface for active-backup
         *                              bond.
         * @param bond_mode             Bonding mode.
         *                              Enum:
         *                              balance-rr,active-backup,balance-xor,broadcast,802.3ad,balance-tlb,balance-alb,balance-slb,lacp-balance-slb,lacp-balance-tcp
         * @param bond_xmit_hash_policy Selects the transmit hash policy to use for
         *                              slave selection in balance-xor and 802.3ad
         *                              modes.
         *                              Enum: layer2,layer2+3,layer3+4
         * @param bridge_ports          Specify the interfaces you want to add to your
         *                              bridge.
         * @param bridge_vids           Specify the allowed VLANs. For example: '2 4
         *                              100-200'. Only used if the bridge is VLAN aware.
         * @param bridge_vlan_aware     Enable bridge vlan support.
         * @param cidr                  IPv4 CIDR.
         * @param cidr6                 IPv6 CIDR.
         * @param comments              Comments
         * @param comments6             Comments
         * @param delete                A list of settings you want to delete.
         * @param gateway               Default gateway address.
         * @param gateway6              Default ipv6 gateway address.
         * @param mtu                   MTU.
         * @param netmask               Network mask.
         * @param netmask6              Network mask.
         * @param ovs_bonds             Specify the interfaces used by the bonding
         *                              device.
         * @param ovs_bridge            The OVS bridge associated with an OVS port. This
         *                              is required when you create an OVS port.
         * @param ovs_options           OVS interface options.
         * @param ovs_ports             Specify the interfaces you want to add to your
         *                              bridge.
         * @param ovs_tag               Specify a VLan tag (used by OVSPort, OVSIntPort,
         *                              OVSBond)
         * @param slaves                Specify the interfaces used by the bonding
         *                              device.
         * @param vlan_id               vlan-id for a custom named vlan interface
         *                              (ifupdown2 only).
         * @param vlan_raw_device       Specify the raw interface for the vlan
         *                              interface.
         * @return Result
         */

        public Result updateNetwork(String type, String address, String address6, Boolean autostart,
                                    String bond_primary, String bond_mode, String bond_xmit_hash_policy, String bridge_ports,
                                    String bridge_vids, Boolean bridge_vlan_aware, String cidr, String cidr6, String comments,
                                    String comments6, String delete, String gateway, String gateway6, Integer mtu,
                                    String netmask, Integer netmask6, String ovs_bonds, String ovs_bridge, String ovs_options,
                                    String ovs_ports, Integer ovs_tag, String slaves, Integer vlan_id, String vlan_raw_device) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("type", type);
            parameters.put("address", address);
            parameters.put("address6", address6);
            parameters.put("autostart", autostart);
            parameters.put("bond-primary", bond_primary);
            parameters.put("bond_mode", bond_mode);
            parameters.put("bond_xmit_hash_policy", bond_xmit_hash_policy);
            parameters.put("bridge_ports", bridge_ports);
            parameters.put("bridge_vids", bridge_vids);
            parameters.put("bridge_vlan_aware", bridge_vlan_aware);
            parameters.put("cidr", cidr);
            parameters.put("cidr6", cidr6);
            parameters.put("comments", comments);
            parameters.put("comments6", comments6);
            parameters.put("delete", delete);
            parameters.put("gateway", gateway);
            parameters.put("gateway6", gateway6);
            parameters.put("mtu", mtu);
            parameters.put("netmask", netmask);
            parameters.put("netmask6", netmask6);
            parameters.put("ovs_bonds", ovs_bonds);
            parameters.put("ovs_bridge", ovs_bridge);
            parameters.put("ovs_options", ovs_options);
            parameters.put("ovs_ports", ovs_ports);
            parameters.put("ovs_tag", ovs_tag);
            parameters.put("slaves", slaves);
            parameters.put("vlan-id", vlan_id);
            parameters.put("vlan-raw-device", vlan_raw_device);
            return client.set("/nodes/" + this.node + "/network/" + this.iface, parameters);
        }

        /**
         * Update network device configuration
         *
         * @param type Network interface type
         *             Enum:
         *             bridge,bond,eth,alias,vlan,fabric,OVSBridge,OVSBond,OVSPort,OVSIntPort,vnet,unknown
         * @return Result
         */

        public Result updateNetwork(String type) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("type", type);
            return client.set("/nodes/" + this.node + "/network/" + this.iface, parameters);
        }

    }

    /**
     * Revert network configuration changes.
     *
     * @return Result
     */

    public Result revertNetworkChanges() {
        return client.delete("/nodes/" + this.node + "/network", null);
    }

    /**
     * List available networks
     *
     * @param type Only list specific interface types.
     *             Enum:
     *             bridge,bond,eth,alias,vlan,fabric,OVSBridge,OVSBond,OVSPort,OVSIntPort,vnet,any_bridge,any_local_bridge,include_sdn
     * @return Result
     */

    public Result index(String type) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("type", type);
        return client.get("/nodes/" + this.node + "/network", parameters);
    }

    /**
     * List available networks
     *
     * @return Result
     */

    public Result index() {
        return client.get("/nodes/" + this.node + "/network", null);
    }

    /**
     * Create network device configuration
     *
     * @param iface                 Network interface name.
     * @param type                  Network interface type
     *                              Enum:
     *                              bridge,bond,eth,alias,vlan,fabric,OVSBridge,OVSBond,OVSPort,OVSIntPort,vnet,unknown
     * @param address               IP address.
     * @param address6              IP address.
     * @param autostart             Automatically start interface on boot.
     * @param bond_primary          Specify the primary interface for active-backup
     *                              bond.
     * @param bond_mode             Bonding mode.
     *                              Enum:
     *                              balance-rr,active-backup,balance-xor,broadcast,802.3ad,balance-tlb,balance-alb,balance-slb,lacp-balance-slb,lacp-balance-tcp
     * @param bond_xmit_hash_policy Selects the transmit hash policy to use for
     *                              slave selection in balance-xor and 802.3ad
     *                              modes.
     *                              Enum: layer2,layer2+3,layer3+4
     * @param bridge_ports          Specify the interfaces you want to add to your
     *                              bridge.
     * @param bridge_vids           Specify the allowed VLANs. For example: '2 4
     *                              100-200'. Only used if the bridge is VLAN aware.
     * @param bridge_vlan_aware     Enable bridge vlan support.
     * @param cidr                  IPv4 CIDR.
     * @param cidr6                 IPv6 CIDR.
     * @param comments              Comments
     * @param comments6             Comments
     * @param gateway               Default gateway address.
     * @param gateway6              Default ipv6 gateway address.
     * @param mtu                   MTU.
     * @param netmask               Network mask.
     * @param netmask6              Network mask.
     * @param ovs_bonds             Specify the interfaces used by the bonding
     *                              device.
     * @param ovs_bridge            The OVS bridge associated with an OVS port. This
     *                              is required when you create an OVS port.
     * @param ovs_options           OVS interface options.
     * @param ovs_ports             Specify the interfaces you want to add to your
     *                              bridge.
     * @param ovs_tag               Specify a VLan tag (used by OVSPort, OVSIntPort,
     *                              OVSBond)
     * @param slaves                Specify the interfaces used by the bonding
     *                              device.
     * @param vlan_id               vlan-id for a custom named vlan interface
     *                              (ifupdown2 only).
     * @param vlan_raw_device       Specify the raw interface for the vlan
     *                              interface.
     * @return Result
     */

    public Result createNetwork(String iface, String type, String address, String address6,
                                Boolean autostart, String bond_primary, String bond_mode, String bond_xmit_hash_policy,
                                String bridge_ports, String bridge_vids, Boolean bridge_vlan_aware, String cidr, String cidr6,
                                String comments, String comments6, String gateway, String gateway6, Integer mtu, String netmask,
                                Integer netmask6, String ovs_bonds, String ovs_bridge, String ovs_options, String ovs_ports,
                                Integer ovs_tag, String slaves, Integer vlan_id, String vlan_raw_device) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("iface", iface);
        parameters.put("type", type);
        parameters.put("address", address);
        parameters.put("address6", address6);
        parameters.put("autostart", autostart);
        parameters.put("bond-primary", bond_primary);
        parameters.put("bond_mode", bond_mode);
        parameters.put("bond_xmit_hash_policy", bond_xmit_hash_policy);
        parameters.put("bridge_ports", bridge_ports);
        parameters.put("bridge_vids", bridge_vids);
        parameters.put("bridge_vlan_aware", bridge_vlan_aware);
        parameters.put("cidr", cidr);
        parameters.put("cidr6", cidr6);
        parameters.put("comments", comments);
        parameters.put("comments6", comments6);
        parameters.put("gateway", gateway);
        parameters.put("gateway6", gateway6);
        parameters.put("mtu", mtu);
        parameters.put("netmask", netmask);
        parameters.put("netmask6", netmask6);
        parameters.put("ovs_bonds", ovs_bonds);
        parameters.put("ovs_bridge", ovs_bridge);
        parameters.put("ovs_options", ovs_options);
        parameters.put("ovs_ports", ovs_ports);
        parameters.put("ovs_tag", ovs_tag);
        parameters.put("slaves", slaves);
        parameters.put("vlan-id", vlan_id);
        parameters.put("vlan-raw-device", vlan_raw_device);
        return client.create("/nodes/" + this.node + "/network", parameters);
    }

    /**
     * Create network device configuration
     *
     * @param iface Network interface name.
     * @param type  Network interface type
     *              Enum:
     *              bridge,bond,eth,alias,vlan,fabric,OVSBridge,OVSBond,OVSPort,OVSIntPort,vnet,unknown
     * @return Result
     */

    public Result createNetwork(String iface, String type) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("iface", iface);
        parameters.put("type", type);
        return client.create("/nodes/" + this.node + "/network", parameters);
    }

    /**
     * Reload network configuration
     *
     * @param regenerate_frr Whether FRR config generation should get skipped or
     *                       not.
     * @return Result
     */

    public Result reloadNetworkConfig(Boolean regenerate_frr) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("regenerate-frr", regenerate_frr);
        return client.set("/nodes/" + this.node + "/network", parameters);
    }

    /**
     * Reload network configuration
     *
     * @return Result
     */

    public Result reloadNetworkConfig() {
        return client.set("/nodes/" + this.node + "/network", null);
    }

}

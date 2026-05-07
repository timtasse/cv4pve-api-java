package it.corsinvest.proxmoxve.api.cluster;

import it.corsinvest.proxmoxve.api.PveClient;
import it.corsinvest.proxmoxve.api.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class PVESdn {

    private final PveClient client;

    public PVESdn(PveClient client) {
        this.client = client;

    }

    private PVEVnets vnets;

    public PVEVnets getVnets() {
        return vnets == null ? (vnets = new PVEVnets(client)) : vnets;
    }

    private PVEZones zones;

    public PVEZones getZones() {
        return zones == null ? (zones = new PVEZones(client)) : zones;
    }

    private PVEControllers controllers;

    public PVEControllers getControllers() {
        return controllers == null ? (controllers = new PVEControllers(client)) : controllers;
    }

    private PVEIpams ipams;

    public PVEIpams getIpams() {
        return ipams == null ? (ipams = new PVEIpams(client)) : ipams;
    }

    private PVEDns dns;

    public PVEDns getDns() {
        return dns == null ? (dns = new PVEDns(client)) : dns;
    }

    private PVEFabrics fabrics;

    public PVEFabrics getFabrics() {
        return fabrics == null ? (fabrics = new PVEFabrics(client)) : fabrics;
    }

    private PVELock lock;

    public PVELock getLock() {
        return lock == null ? (lock = new PVELock(client)) : lock;
    }

    private PVERollback rollback;

    public PVERollback getRollback() {
        return rollback == null ? (rollback = new PVERollback(client)) : rollback;
    }

    public static class PVEVnets {

        private final PveClient client;

        protected PVEVnets(PveClient client) {
            this.client = client;

        }

        public PVEVnets.PVEVnetItem get(Object vnet) {
            return new PVEVnetItem(client, vnet);
        }

        public static class PVEVnetItem {

            private final PveClient client;
            private final Object vnet;

            protected PVEVnetItem(PveClient client, Object vnet) {
                this.client = client;
                this.vnet = vnet;
            }

            private PVEVnets.PVEVnetItem.PVEFirewall firewall;

            public PVEVnets.PVEVnetItem.PVEFirewall getFirewall() {
                return firewall == null ? (firewall = new PVEFirewall(client, this.vnet)) : firewall;
            }

            private PVEVnets.PVEVnetItem.PVESubnets subnets;

            public PVEVnets.PVEVnetItem.PVESubnets getSubnets() {
                return subnets == null ? (subnets = new PVESubnets(client, this.vnet)) : subnets;
            }

            private PVEVnets.PVEVnetItem.PVEIps ips;

            public PVEVnets.PVEVnetItem.PVEIps getIps() {
                return ips == null ? (ips = new PVEIps(client, this.vnet)) : ips;
            }

            public static class PVEFirewall {

                private final PveClient client;
                private final Object vnet;

                protected PVEFirewall(PveClient client, Object vnet) {
                    this.client = client;
                    this.vnet = vnet;
                }

                private PVEVnets.PVEVnetItem.PVEFirewall.PVERules rules;

                public PVEVnets.PVEVnetItem.PVEFirewall.PVERules getRules() {
                    return rules == null ? (rules = new PVERules(client, this.vnet)) : rules;
                }

                private PVEVnets.PVEVnetItem.PVEFirewall.PVEOptions options;

                public PVEVnets.PVEVnetItem.PVEFirewall.PVEOptions getOptions() {
                    return options == null ? (options = new PVEOptions(client, this.vnet)) : options;
                }

                public static class PVERules {

                    private final PveClient client;
                    private final Object vnet;

                    protected PVERules(PveClient client, Object vnet) {
                        this.client = client;
                        this.vnet = vnet;
                    }

                    public PVEVnets.PVEVnetItem.PVEFirewall.PVERules.PVEPosItem get(Object pos) {
                        return new PVEPosItem(client, this.vnet, pos);
                    }

                    public static class PVEPosItem {

                        private final PveClient client;
                        private final Object vnet;
                        private final Object pos;

                        protected PVEPosItem(PveClient client, Object vnet, Object pos) {
                            this.client = client;
                            this.vnet = vnet;
                            this.pos = pos;
                        }

                        /**
                         * Delete rule.
                         *
                         * @param digest Prevent changes if current configuration file has a different
                         *               digest. This can be used to prevent concurrent modifications.
                         * @return Result
                         */

                        public Result deleteRule(String digest) {
                            Map<String, Object> parameters = new HashMap<>();
                            parameters.put("digest", digest);
                            return client.delete(
                                    "/cluster/sdn/vnets/" + this.vnet + "/firewall/rules/" + this.pos,
                                    parameters);
                        }

                        /**
                         * Delete rule.
                         *
                         * @return Result
                         */

                        public Result deleteRule() {
                            return client.delete(
                                    "/cluster/sdn/vnets/" + this.vnet + "/firewall/rules/" + this.pos,
                                    null);
                        }

                        /**
                         * Get single rule data.
                         *
                         * @return Result
                         */

                        public Result getRule() {
                            return client.get(
                                    "/cluster/sdn/vnets/" + this.vnet + "/firewall/rules/" + this.pos,
                                    null);
                        }

                        /**
                         * Modify rule data.
                         *
                         * @param action    Rule action ('ACCEPT', 'DROP', 'REJECT') or security group
                         *                  name.
                         * @param comment   Descriptive comment.
                         * @param delete    A list of settings you want to delete.
                         * @param dest      Restrict packet destination address. This can refer to a
                         *                  single IP address, an IP set ('+ipsetname') or an IP alias
                         *                  definition. You can also specify an address range like
                         *                  '20.34.101.207-201.3.9.99', or a list of IP addresses and
                         *                  networks (entries are separated by comma). Please do not mix
                         *                  IPv4 and IPv6 addresses inside such lists.
                         * @param digest    Prevent changes if current configuration file has a
                         *                  different digest. This can be used to prevent concurrent
                         *                  modifications.
                         * @param dport     Restrict TCP/UDP destination port. You can use service names
                         *                  or simple numbers (0-65535), as defined in '/etc/services'.
                         *                  Port ranges can be specified with '\d+:\d+', for example
                         *                  '80:85', and you can use comma separated list to match
                         *                  several ports or ranges.
                         * @param enable    Flag to enable/disable a rule.
                         * @param icmp_type Specify icmp-type. Only valid if proto equals 'icmp' or
                         *                  'icmpv6'/'ipv6-icmp'.
                         * @param iface     Network interface name. You have to use network
                         *                  configuration key names for VMs and containers ('net\d+').
                         *                  Host related rules can use arbitrary strings.
                         * @param log       Log level for firewall rule.
                         *                  Enum: emerg,alert,crit,err,warning,notice,info,debug,nolog
                         * @param macro     Use predefined standard macro.
                         * @param moveto    Move rule to new position &amp;lt;moveto&amp;gt;. Other
                         *                  arguments are ignored.
                         * @param proto     IP protocol. You can use protocol names ('tcp'/'udp') or
                         *                  simple numbers, as defined in '/etc/protocols'.
                         * @param source    Restrict packet source address. This can refer to a single
                         *                  IP address, an IP set ('+ipsetname') or an IP alias
                         *                  definition. You can also specify an address range like
                         *                  '20.34.101.207-201.3.9.99', or a list of IP addresses and
                         *                  networks (entries are separated by comma). Please do not mix
                         *                  IPv4 and IPv6 addresses inside such lists.
                         * @param sport     Restrict TCP/UDP source port. You can use service names or
                         *                  simple numbers (0-65535), as defined in '/etc/services'.
                         *                  Port ranges can be specified with '\d+:\d+', for example
                         *                  '80:85', and you can use comma separated list to match
                         *                  several ports or ranges.
                         * @param type      Rule type.
                         *                  Enum: in,out,forward,group
                         * @return Result
                         */

                        public Result updateRule(String action, String comment, String delete, String dest,
                                                 String digest, String dport, Integer enable, String icmp_type, String iface,
                                                 String log, String macro, Integer moveto, String proto, String source,
                                                 String sport, String type) {
                            Map<String, Object> parameters = new HashMap<>();
                            parameters.put("action", action);
                            parameters.put("comment", comment);
                            parameters.put("delete", delete);
                            parameters.put("dest", dest);
                            parameters.put("digest", digest);
                            parameters.put("dport", dport);
                            parameters.put("enable", enable);
                            parameters.put("icmp-type", icmp_type);
                            parameters.put("iface", iface);
                            parameters.put("log", log);
                            parameters.put("macro", macro);
                            parameters.put("moveto", moveto);
                            parameters.put("proto", proto);
                            parameters.put("source", source);
                            parameters.put("sport", sport);
                            parameters.put("type", type);
                            return client.set(
                                    "/cluster/sdn/vnets/" + this.vnet + "/firewall/rules/" + this.pos,
                                    parameters);
                        }

                        /**
                         * Modify rule data.
                         *
                         * @return Result
                         */

                        public Result updateRule() {
                            return client.set(
                                    "/cluster/sdn/vnets/" + this.vnet + "/firewall/rules/" + this.pos,
                                    null);
                        }

                    }

                    /**
                     * List rules.
                     *
                     * @return Result
                     */

                    public Result getRules() {
                        return client.get("/cluster/sdn/vnets/" + this.vnet + "/firewall/rules", null);
                    }

                    /**
                     * Create new rule.
                     *
                     * @param action    Rule action ('ACCEPT', 'DROP', 'REJECT') or security group
                     *                  name.
                     * @param type      Rule type.
                     *                  Enum: in,out,forward,group
                     * @param comment   Descriptive comment.
                     * @param dest      Restrict packet destination address. This can refer to a
                     *                  single IP address, an IP set ('+ipsetname') or an IP alias
                     *                  definition. You can also specify an address range like
                     *                  '20.34.101.207-201.3.9.99', or a list of IP addresses and
                     *                  networks (entries are separated by comma). Please do not mix
                     *                  IPv4 and IPv6 addresses inside such lists.
                     * @param digest    Prevent changes if current configuration file has a
                     *                  different digest. This can be used to prevent concurrent
                     *                  modifications.
                     * @param dport     Restrict TCP/UDP destination port. You can use service names
                     *                  or simple numbers (0-65535), as defined in '/etc/services'.
                     *                  Port ranges can be specified with '\d+:\d+', for example
                     *                  '80:85', and you can use comma separated list to match
                     *                  several ports or ranges.
                     * @param enable    Flag to enable/disable a rule.
                     * @param icmp_type Specify icmp-type. Only valid if proto equals 'icmp' or
                     *                  'icmpv6'/'ipv6-icmp'.
                     * @param iface     Network interface name. You have to use network
                     *                  configuration key names for VMs and containers ('net\d+').
                     *                  Host related rules can use arbitrary strings.
                     * @param log       Log level for firewall rule.
                     *                  Enum: emerg,alert,crit,err,warning,notice,info,debug,nolog
                     * @param macro     Use predefined standard macro.
                     * @param pos       Update rule at position &amp;lt;pos&amp;gt;.
                     * @param proto     IP protocol. You can use protocol names ('tcp'/'udp') or
                     *                  simple numbers, as defined in '/etc/protocols'.
                     * @param source    Restrict packet source address. This can refer to a single
                     *                  IP address, an IP set ('+ipsetname') or an IP alias
                     *                  definition. You can also specify an address range like
                     *                  '20.34.101.207-201.3.9.99', or a list of IP addresses and
                     *                  networks (entries are separated by comma). Please do not mix
                     *                  IPv4 and IPv6 addresses inside such lists.
                     * @param sport     Restrict TCP/UDP source port. You can use service names or
                     *                  simple numbers (0-65535), as defined in '/etc/services'.
                     *                  Port ranges can be specified with '\d+:\d+', for example
                     *                  '80:85', and you can use comma separated list to match
                     *                  several ports or ranges.
                     * @return Result
                     */

                    public Result createRule(String action, String type, String comment, String dest,
                                             String digest, String dport, Integer enable, String icmp_type, String iface,
                                             String log, String macro, Integer pos, String proto, String source, String sport) {
                        Map<String, Object> parameters = new HashMap<>();
                        parameters.put("action", action);
                        parameters.put("type", type);
                        parameters.put("comment", comment);
                        parameters.put("dest", dest);
                        parameters.put("digest", digest);
                        parameters.put("dport", dport);
                        parameters.put("enable", enable);
                        parameters.put("icmp-type", icmp_type);
                        parameters.put("iface", iface);
                        parameters.put("log", log);
                        parameters.put("macro", macro);
                        parameters.put("pos", pos);
                        parameters.put("proto", proto);
                        parameters.put("source", source);
                        parameters.put("sport", sport);
                        return client.create("/cluster/sdn/vnets/" + this.vnet + "/firewall/rules", parameters);
                    }

                    /**
                     * Create new rule.
                     *
                     * @param action Rule action ('ACCEPT', 'DROP', 'REJECT') or security group
                     *               name.
                     * @param type   Rule type.
                     *               Enum: in,out,forward,group
                     * @return Result
                     */

                    public Result createRule(String action, String type) {
                        Map<String, Object> parameters = new HashMap<>();
                        parameters.put("action", action);
                        parameters.put("type", type);
                        return client.create("/cluster/sdn/vnets/" + this.vnet + "/firewall/rules", parameters);
                    }

                }

                public static class PVEOptions {

                    private final PveClient client;
                    private final Object vnet;

                    protected PVEOptions(PveClient client, Object vnet) {
                        this.client = client;
                        this.vnet = vnet;
                    }

                    /**
                     * Get vnet firewall options.
                     *
                     * @return Result
                     */

                    public Result getOptions() {
                        return client.get("/cluster/sdn/vnets/" + this.vnet + "/firewall/options", null);
                    }

                    /**
                     * Set Firewall options.
                     *
                     * @param delete            A list of settings you want to delete.
                     * @param digest            Prevent changes if current configuration file has a
                     *                          different digest. This can be used to prevent
                     *                          concurrent modifications.
                     * @param enable            Enable/disable firewall rules.
                     * @param log_level_forward Log level for forwarded traffic.
                     *                          Enum:
                     *                          emerg,alert,crit,err,warning,notice,info,debug,nolog
                     * @param policy_forward    Forward policy.
                     *                          Enum: ACCEPT,DROP
                     * @return Result
                     */

                    public Result setOptions(String delete, String digest, Boolean enable,
                                             String log_level_forward, String policy_forward) {
                        Map<String, Object> parameters = new HashMap<>();
                        parameters.put("delete", delete);
                        parameters.put("digest", digest);
                        parameters.put("enable", enable);
                        parameters.put("log_level_forward", log_level_forward);
                        parameters.put("policy_forward", policy_forward);
                        return client.set("/cluster/sdn/vnets/" + this.vnet + "/firewall/options", parameters);
                    }

                    /**
                     * Set Firewall options.
                     *
                     * @return Result
                     */

                    public Result setOptions() {
                        return client.set("/cluster/sdn/vnets/" + this.vnet + "/firewall/options", null);
                    }

                }

                /**
                 * Directory index.
                 *
                 * @return Result
                 */

                public Result index() {
                    return client.get("/cluster/sdn/vnets/" + this.vnet + "/firewall", null);
                }

            }

            public static class PVESubnets {

                private final PveClient client;
                private final Object vnet;

                protected PVESubnets(PveClient client, Object vnet) {
                    this.client = client;
                    this.vnet = vnet;
                }

                public PVEVnets.PVEVnetItem.PVESubnets.PVESubnetItem get(Object subnet) {
                    return new PVESubnetItem(client, this.vnet, subnet);
                }

                public static class PVESubnetItem {

                    private final PveClient client;
                    private final Object vnet;
                    private final Object subnet;

                    protected PVESubnetItem(PveClient client, Object vnet, Object subnet) {
                        this.client = client;
                        this.vnet = vnet;
                        this.subnet = subnet;
                    }

                    /**
                     * Delete sdn subnet object configuration.
                     *
                     * @param lock_token the token for unlocking the global SDN configuration
                     * @return Result
                     */

                    public Result delete(String lock_token) {
                        Map<String, Object> parameters = new HashMap<>();
                        parameters.put("lock-token", lock_token);
                        return client.delete("/cluster/sdn/vnets/" + this.vnet + "/subnets/" + this.subnet,
                                parameters);
                    }

                    /**
                     * Delete sdn subnet object configuration.
                     *
                     * @return Result
                     */

                    public Result delete() {
                        return client.delete("/cluster/sdn/vnets/" + this.vnet + "/subnets/" + this.subnet,
                                null);
                    }

                    /**
                     * Read sdn subnet configuration.
                     *
                     * @param pending Display pending config.
                     * @param running Display running config.
                     * @return Result
                     */

                    public Result read(Boolean pending, Boolean running) {
                        Map<String, Object> parameters = new HashMap<>();
                        parameters.put("pending", pending);
                        parameters.put("running", running);
                        return client.get("/cluster/sdn/vnets/" + this.vnet + "/subnets/" + this.subnet,
                                parameters);
                    }

                    /**
                     * Read sdn subnet configuration.
                     *
                     * @return Result
                     */

                    public Result read() {
                        return client.get("/cluster/sdn/vnets/" + this.vnet + "/subnets/" + this.subnet,
                                null);
                    }

                    /**
                     * Update sdn subnet object configuration.
                     *
                     * @param delete          A list of settings you want to delete.
                     * @param dhcp_dns_server IP address for the DNS server
                     * @param dhcp_range      A list of DHCP ranges for this subnet
                     * @param digest          Prevent changes if current configuration file has a
                     *                        different digest. This can be used to prevent
                     *                        concurrent modifications.
                     * @param dnszoneprefix   dns domain zone prefix ex: 'adm' -&amp;gt;
                     *                        &amp;lt;hostname&amp;gt;.adm.mydomain.com
                     * @param gateway         Subnet Gateway: Will be assigned on vnet for layer3
                     *                        zones
                     * @param lock_token      the token for unlocking the global SDN configuration
                     * @param snat            enable masquerade for this subnet if pve-firewall
                     * @return Result
                     */

                    public Result update(String delete, String dhcp_dns_server, List<Object> dhcp_range,
                                         String digest, String dnszoneprefix, String gateway, String lock_token,
                                         Boolean snat) {
                        Map<String, Object> parameters = new HashMap<>();
                        parameters.put("delete", delete);
                        parameters.put("dhcp-dns-server", dhcp_dns_server);
                        parameters.put("dhcp-range", dhcp_range);
                        parameters.put("digest", digest);
                        parameters.put("dnszoneprefix", dnszoneprefix);
                        parameters.put("gateway", gateway);
                        parameters.put("lock-token", lock_token);
                        parameters.put("snat", snat);
                        return client.set("/cluster/sdn/vnets/" + this.vnet + "/subnets/" + this.subnet,
                                parameters);
                    }

                    /**
                     * Update sdn subnet object configuration.
                     *
                     * @return Result
                     */

                    public Result update() {
                        return client.set("/cluster/sdn/vnets/" + this.vnet + "/subnets/" + this.subnet,
                                null);
                    }

                }

                /**
                 * SDN subnets index.
                 *
                 * @param pending Display pending config.
                 * @param running Display running config.
                 * @return Result
                 */

                public Result index(Boolean pending, Boolean running) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("pending", pending);
                    parameters.put("running", running);
                    return client.get("/cluster/sdn/vnets/" + this.vnet + "/subnets", parameters);
                }

                /**
                 * SDN subnets index.
                 *
                 * @return Result
                 */

                public Result index() {
                    return client.get("/cluster/sdn/vnets/" + this.vnet + "/subnets", null);
                }

                /**
                 * Create a new sdn subnet object.
                 *
                 * @param subnet          The SDN subnet object identifier.
                 * @param type            Enum: subnet
                 * @param dhcp_dns_server IP address for the DNS server
                 * @param dhcp_range      A list of DHCP ranges for this subnet
                 * @param dnszoneprefix   dns domain zone prefix ex: 'adm' -&amp;gt;
                 *                        &amp;lt;hostname&amp;gt;.adm.mydomain.com
                 * @param gateway         Subnet Gateway: Will be assigned on vnet for layer3
                 *                        zones
                 * @param lock_token      the token for unlocking the global SDN configuration
                 * @param snat            enable masquerade for this subnet if pve-firewall
                 * @return Result
                 */

                public Result create(String subnet, String type, String dhcp_dns_server,
                                     List<Object> dhcp_range, String dnszoneprefix, String gateway, String lock_token,
                                     Boolean snat) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("subnet", subnet);
                    parameters.put("type", type);
                    parameters.put("dhcp-dns-server", dhcp_dns_server);
                    parameters.put("dhcp-range", dhcp_range);
                    parameters.put("dnszoneprefix", dnszoneprefix);
                    parameters.put("gateway", gateway);
                    parameters.put("lock-token", lock_token);
                    parameters.put("snat", snat);
                    return client.create("/cluster/sdn/vnets/" + this.vnet + "/subnets", parameters);
                }

                /**
                 * Create a new sdn subnet object.
                 *
                 * @param subnet The SDN subnet object identifier.
                 * @param type   Enum: subnet
                 * @return Result
                 */

                public Result create(String subnet, String type) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("subnet", subnet);
                    parameters.put("type", type);
                    return client.create("/cluster/sdn/vnets/" + this.vnet + "/subnets", parameters);
                }

            }

            public static class PVEIps {

                private final PveClient client;
                private final Object vnet;

                protected PVEIps(PveClient client, Object vnet) {
                    this.client = client;
                    this.vnet = vnet;
                }

                /**
                 * Delete IP Mappings in a VNet
                 *
                 * @param ip   The IP address to delete
                 * @param zone The SDN zone object identifier.
                 * @param mac  Unicast MAC address.
                 * @return Result
                 */

                public Result ipdelete(String ip, String zone, String mac) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("ip", ip);
                    parameters.put("zone", zone);
                    parameters.put("mac", mac);
                    return client.delete("/cluster/sdn/vnets/" + this.vnet + "/ips", parameters);
                }

                /**
                 * Delete IP Mappings in a VNet
                 *
                 * @param ip   The IP address to delete
                 * @param zone The SDN zone object identifier.
                 * @return Result
                 */

                public Result ipdelete(String ip, String zone) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("ip", ip);
                    parameters.put("zone", zone);
                    return client.delete("/cluster/sdn/vnets/" + this.vnet + "/ips", parameters);
                }

                /**
                 * Create IP Mapping in a VNet
                 *
                 * @param ip   The IP address to associate with the given MAC address
                 * @param zone The SDN zone object identifier.
                 * @param mac  Unicast MAC address.
                 * @return Result
                 */

                public Result ipcreate(String ip, String zone, String mac) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("ip", ip);
                    parameters.put("zone", zone);
                    parameters.put("mac", mac);
                    return client.create("/cluster/sdn/vnets/" + this.vnet + "/ips", parameters);
                }

                /**
                 * Create IP Mapping in a VNet
                 *
                 * @param ip   The IP address to associate with the given MAC address
                 * @param zone The SDN zone object identifier.
                 * @return Result
                 */

                public Result ipcreate(String ip, String zone) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("ip", ip);
                    parameters.put("zone", zone);
                    return client.create("/cluster/sdn/vnets/" + this.vnet + "/ips", parameters);
                }

                /**
                 * Update IP Mapping in a VNet
                 *
                 * @param ip   The IP address to associate with the given MAC address
                 * @param zone The SDN zone object identifier.
                 * @param mac  Unicast MAC address.
                 * @param vmid The (unique) ID of the VM.
                 * @return Result
                 */

                public Result ipupdate(String ip, String zone, String mac, Integer vmid) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("ip", ip);
                    parameters.put("zone", zone);
                    parameters.put("mac", mac);
                    parameters.put("vmid", vmid);
                    return client.set("/cluster/sdn/vnets/" + this.vnet + "/ips", parameters);
                }

                /**
                 * Update IP Mapping in a VNet
                 *
                 * @param ip   The IP address to associate with the given MAC address
                 * @param zone The SDN zone object identifier.
                 * @return Result
                 */

                public Result ipupdate(String ip, String zone) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("ip", ip);
                    parameters.put("zone", zone);
                    return client.set("/cluster/sdn/vnets/" + this.vnet + "/ips", parameters);
                }

            }

            /**
             * Delete sdn vnet object configuration.
             *
             * @param lock_token the token for unlocking the global SDN configuration
             * @return Result
             */

            public Result delete(String lock_token) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("lock-token", lock_token);
                return client.delete("/cluster/sdn/vnets/" + this.vnet, parameters);
            }

            /**
             * Delete sdn vnet object configuration.
             *
             * @return Result
             */

            public Result delete() {
                return client.delete("/cluster/sdn/vnets/" + this.vnet, null);
            }

            /**
             * Read sdn vnet configuration.
             *
             * @param pending Display pending config.
             * @param running Display running config.
             * @return Result
             */

            public Result read(Boolean pending, Boolean running) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("pending", pending);
                parameters.put("running", running);
                return client.get("/cluster/sdn/vnets/" + this.vnet, parameters);
            }

            /**
             * Read sdn vnet configuration.
             *
             * @return Result
             */

            public Result read() {
                return client.get("/cluster/sdn/vnets/" + this.vnet, null);
            }

            /**
             * Update sdn vnet object configuration.
             *
             * @param alias         Alias name of the VNet.
             * @param delete        A list of settings you want to delete.
             * @param digest        Prevent changes if current configuration file has a
             *                      different digest. This can be used to prevent concurrent
             *                      modifications.
             * @param isolate_ports If true, sets the isolated property for all interfaces
             *                      on the bridge of this VNet.
             * @param lock_token    the token for unlocking the global SDN configuration
             * @param tag           VLAN Tag (for VLAN or QinQ zones) or VXLAN VNI (for
             *                      VXLAN or EVPN zones).
             * @param vlanaware     Allow VLANs to pass through this vnet.
             * @param zone          Name of the zone this VNet belongs to.
             * @return Result
             */

            public Result update(String alias, String delete, String digest, Boolean isolate_ports,
                                 String lock_token, Integer tag, Boolean vlanaware, String zone) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("alias", alias);
                parameters.put("delete", delete);
                parameters.put("digest", digest);
                parameters.put("isolate-ports", isolate_ports);
                parameters.put("lock-token", lock_token);
                parameters.put("tag", tag);
                parameters.put("vlanaware", vlanaware);
                parameters.put("zone", zone);
                return client.set("/cluster/sdn/vnets/" + this.vnet, parameters);
            }

            /**
             * Update sdn vnet object configuration.
             *
             * @return Result
             */

            public Result update() {
                return client.set("/cluster/sdn/vnets/" + this.vnet, null);
            }

        }

        /**
         * SDN vnets index.
         *
         * @param pending Display pending config.
         * @param running Display running config.
         * @return Result
         */

        public Result index(Boolean pending, Boolean running) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("pending", pending);
            parameters.put("running", running);
            return client.get("/cluster/sdn/vnets", parameters);
        }

        /**
         * SDN vnets index.
         *
         * @return Result
         */

        public Result index() {
            return client.get("/cluster/sdn/vnets", null);
        }

        /**
         * Create a new sdn vnet object.
         *
         * @param vnet          The SDN vnet object identifier.
         * @param zone          Name of the zone this VNet belongs to.
         * @param alias         Alias name of the VNet.
         * @param isolate_ports If true, sets the isolated property for all interfaces
         *                      on the bridge of this VNet.
         * @param lock_token    the token for unlocking the global SDN configuration
         * @param tag           VLAN Tag (for VLAN or QinQ zones) or VXLAN VNI (for
         *                      VXLAN or EVPN zones).
         * @param type          Type of the VNet.
         *                      Enum: vnet
         * @param vlanaware     Allow VLANs to pass through this vnet.
         * @return Result
         */

        public Result create(String vnet, String zone, String alias, Boolean isolate_ports, String lock_token,
                             Integer tag, String type, Boolean vlanaware) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("vnet", vnet);
            parameters.put("zone", zone);
            parameters.put("alias", alias);
            parameters.put("isolate-ports", isolate_ports);
            parameters.put("lock-token", lock_token);
            parameters.put("tag", tag);
            parameters.put("type", type);
            parameters.put("vlanaware", vlanaware);
            return client.create("/cluster/sdn/vnets", parameters);
        }

        /**
         * Create a new sdn vnet object.
         *
         * @param vnet The SDN vnet object identifier.
         * @param zone Name of the zone this VNet belongs to.
         * @return Result
         */

        public Result create(String vnet, String zone) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("vnet", vnet);
            parameters.put("zone", zone);
            return client.create("/cluster/sdn/vnets", parameters);
        }

    }

    public static class PVEZones {

        private final PveClient client;

        protected PVEZones(PveClient client) {
            this.client = client;

        }

        public PVEZones.PVEZoneItem get(Object zone) {
            return new PVEZoneItem(client, zone);
        }

        public static class PVEZoneItem {

            private final PveClient client;
            private final Object zone;

            protected PVEZoneItem(PveClient client, Object zone) {
                this.client = client;
                this.zone = zone;
            }

            /**
             * Delete sdn zone object configuration.
             *
             * @param lock_token the token for unlocking the global SDN configuration
             * @return Result
             */

            public Result delete(String lock_token) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("lock-token", lock_token);
                return client.delete("/cluster/sdn/zones/" + this.zone, parameters);
            }

            /**
             * Delete sdn zone object configuration.
             *
             * @return Result
             */

            public Result delete() {
                return client.delete("/cluster/sdn/zones/" + this.zone, null);
            }

            /**
             * Read sdn zone configuration.
             *
             * @param pending Display pending config.
             * @param running Display running config.
             * @return Result
             */

            public Result read(Boolean pending, Boolean running) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("pending", pending);
                parameters.put("running", running);
                return client.get("/cluster/sdn/zones/" + this.zone, parameters);
            }

            /**
             * Read sdn zone configuration.
             *
             * @return Result
             */

            public Result read() {
                return client.get("/cluster/sdn/zones/" + this.zone, null);
            }

            /**
             * Update sdn zone object configuration.
             *
             * @param advertise_subnets           Advertise IP prefixes (Type-5 routes)
             *                                    instead of MAC/IP pairs (Type-2 routes).
             * @param bridge                      The bridge for which VLANs should be
             *                                    managed.
             * @param bridge_disable_mac_learning Disable auto mac learning.
             * @param controller                  Controller for this zone.
             * @param delete                      A list of settings you want to delete.
             * @param dhcp                        Type of the DHCP backend for this zone
             *                                    Enum: dnsmasq
             * @param digest                      Prevent changes if current configuration
             *                                    file has a different digest. This can be
             *                                    used to prevent concurrent modifications.
             * @param disable_arp_nd_suppression  Suppress IPv4 ARP &amp;&amp; IPv6
             *                                    Neighbour Discovery messages.
             * @param dns                         dns api server
             * @param dnszone                     dns domain zone ex: mydomain.com
             * @param dp_id                       Faucet dataplane id
             * @param exitnodes                   List of cluster node names.
             * @param exitnodes_local_routing     Allow exitnodes to connect to EVPN guests.
             * @param exitnodes_primary           Force traffic through this exitnode first.
             * @param fabric                      SDN fabric to use as underlay for this
             *                                    VXLAN zone.
             * @param ipam                        use a specific ipam
             * @param lock_token                  the token for unlocking the global SDN
             *                                    configuration
             * @param mac                         Anycast logical router mac address.
             * @param mtu                         MTU of the zone, will be used for the
             *                                    created VNet bridges.
             * @param nodes                       List of cluster node names.
             * @param peers                       Comma-separated list of peers, that are
             *                                    part of the VXLAN zone. Usually the IPs of
             *                                    the nodes.
             * @param reversedns                  reverse dns api server
             * @param rt_import                   List of Route Targets that should be
             *                                    imported into the VRF of the zone.
             * @param tag                         Service-VLAN Tag (outer VLAN)
             * @param vlan_protocol               Which VLAN protocol should be used for the
             *                                    creation of the QinQ zone.
             *                                    Enum: 802.1q,802.1ad
             * @param vrf_vxlan                   VNI for the zone VRF.
             * @param vxlan_port                  UDP port that should be used for the VXLAN
             *                                    tunnel (default 4789).
             * @return Result
             */

            public Result update(Boolean advertise_subnets, String bridge, Boolean bridge_disable_mac_learning,
                                 String controller, String delete, String dhcp, String digest,
                                 Boolean disable_arp_nd_suppression, String dns, String dnszone, Integer dp_id,
                                 String exitnodes, Boolean exitnodes_local_routing, String exitnodes_primary, String fabric,
                                 String ipam, String lock_token, String mac, Integer mtu, String nodes, String peers,
                                 String reversedns, String rt_import, Integer tag, String vlan_protocol, Integer vrf_vxlan,
                                 Integer vxlan_port) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("advertise-subnets", advertise_subnets);
                parameters.put("bridge", bridge);
                parameters.put("bridge-disable-mac-learning", bridge_disable_mac_learning);
                parameters.put("controller", controller);
                parameters.put("delete", delete);
                parameters.put("dhcp", dhcp);
                parameters.put("digest", digest);
                parameters.put("disable-arp-nd-suppression", disable_arp_nd_suppression);
                parameters.put("dns", dns);
                parameters.put("dnszone", dnszone);
                parameters.put("dp-id", dp_id);
                parameters.put("exitnodes", exitnodes);
                parameters.put("exitnodes-local-routing", exitnodes_local_routing);
                parameters.put("exitnodes-primary", exitnodes_primary);
                parameters.put("fabric", fabric);
                parameters.put("ipam", ipam);
                parameters.put("lock-token", lock_token);
                parameters.put("mac", mac);
                parameters.put("mtu", mtu);
                parameters.put("nodes", nodes);
                parameters.put("peers", peers);
                parameters.put("reversedns", reversedns);
                parameters.put("rt-import", rt_import);
                parameters.put("tag", tag);
                parameters.put("vlan-protocol", vlan_protocol);
                parameters.put("vrf-vxlan", vrf_vxlan);
                parameters.put("vxlan-port", vxlan_port);
                return client.set("/cluster/sdn/zones/" + this.zone, parameters);
            }

            /**
             * Update sdn zone object configuration.
             *
             * @return Result
             */

            public Result update() {
                return client.set("/cluster/sdn/zones/" + this.zone, null);
            }

        }

        /**
         * SDN zones index.
         *
         * @param pending Display pending config.
         * @param running Display running config.
         * @param type    Only list SDN zones of specific type
         *                Enum: evpn,faucet,qinq,simple,vlan,vxlan
         * @return Result
         */

        public Result index(Boolean pending, Boolean running, String type) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("pending", pending);
            parameters.put("running", running);
            parameters.put("type", type);
            return client.get("/cluster/sdn/zones", parameters);
        }

        /**
         * SDN zones index.
         *
         * @return Result
         */

        public Result index() {
            return client.get("/cluster/sdn/zones", null);
        }

        /**
         * Create a new sdn zone object.
         *
         * @param type                        Plugin type.
         *                                    Enum: evpn,faucet,qinq,simple,vlan,vxlan
         * @param zone                        The SDN zone object identifier.
         * @param advertise_subnets           Advertise IP prefixes (Type-5 routes)
         *                                    instead of MAC/IP pairs (Type-2 routes).
         * @param bridge                      The bridge for which VLANs should be
         *                                    managed.
         * @param bridge_disable_mac_learning Disable auto mac learning.
         * @param controller                  Controller for this zone.
         * @param dhcp                        Type of the DHCP backend for this zone
         *                                    Enum: dnsmasq
         * @param disable_arp_nd_suppression  Suppress IPv4 ARP &amp;&amp; IPv6
         *                                    Neighbour Discovery messages.
         * @param dns                         dns api server
         * @param dnszone                     dns domain zone ex: mydomain.com
         * @param dp_id                       Faucet dataplane id
         * @param exitnodes                   List of cluster node names.
         * @param exitnodes_local_routing     Allow exitnodes to connect to EVPN guests.
         * @param exitnodes_primary           Force traffic through this exitnode first.
         * @param fabric                      SDN fabric to use as underlay for this
         *                                    VXLAN zone.
         * @param ipam                        use a specific ipam
         * @param lock_token                  the token for unlocking the global SDN
         *                                    configuration
         * @param mac                         Anycast logical router mac address.
         * @param mtu                         MTU of the zone, will be used for the
         *                                    created VNet bridges.
         * @param nodes                       List of cluster node names.
         * @param peers                       Comma-separated list of peers, that are
         *                                    part of the VXLAN zone. Usually the IPs of
         *                                    the nodes.
         * @param reversedns                  reverse dns api server
         * @param rt_import                   List of Route Targets that should be
         *                                    imported into the VRF of the zone.
         * @param tag                         Service-VLAN Tag (outer VLAN)
         * @param vlan_protocol               Which VLAN protocol should be used for the
         *                                    creation of the QinQ zone.
         *                                    Enum: 802.1q,802.1ad
         * @param vrf_vxlan                   VNI for the zone VRF.
         * @param vxlan_port                  UDP port that should be used for the VXLAN
         *                                    tunnel (default 4789).
         * @return Result
         */

        public Result create(String type, String zone, Boolean advertise_subnets, String bridge,
                             Boolean bridge_disable_mac_learning, String controller, String dhcp,
                             Boolean disable_arp_nd_suppression, String dns, String dnszone, Integer dp_id, String exitnodes,
                             Boolean exitnodes_local_routing, String exitnodes_primary, String fabric, String ipam,
                             String lock_token, String mac, Integer mtu, String nodes, String peers, String reversedns,
                             String rt_import, Integer tag, String vlan_protocol, Integer vrf_vxlan, Integer vxlan_port) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("type", type);
            parameters.put("zone", zone);
            parameters.put("advertise-subnets", advertise_subnets);
            parameters.put("bridge", bridge);
            parameters.put("bridge-disable-mac-learning", bridge_disable_mac_learning);
            parameters.put("controller", controller);
            parameters.put("dhcp", dhcp);
            parameters.put("disable-arp-nd-suppression", disable_arp_nd_suppression);
            parameters.put("dns", dns);
            parameters.put("dnszone", dnszone);
            parameters.put("dp-id", dp_id);
            parameters.put("exitnodes", exitnodes);
            parameters.put("exitnodes-local-routing", exitnodes_local_routing);
            parameters.put("exitnodes-primary", exitnodes_primary);
            parameters.put("fabric", fabric);
            parameters.put("ipam", ipam);
            parameters.put("lock-token", lock_token);
            parameters.put("mac", mac);
            parameters.put("mtu", mtu);
            parameters.put("nodes", nodes);
            parameters.put("peers", peers);
            parameters.put("reversedns", reversedns);
            parameters.put("rt-import", rt_import);
            parameters.put("tag", tag);
            parameters.put("vlan-protocol", vlan_protocol);
            parameters.put("vrf-vxlan", vrf_vxlan);
            parameters.put("vxlan-port", vxlan_port);
            return client.create("/cluster/sdn/zones", parameters);
        }

        /**
         * Create a new sdn zone object.
         *
         * @param type Plugin type.
         *             Enum: evpn,faucet,qinq,simple,vlan,vxlan
         * @param zone The SDN zone object identifier.
         * @return Result
         */

        public Result create(String type, String zone) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("type", type);
            parameters.put("zone", zone);
            return client.create("/cluster/sdn/zones", parameters);
        }

    }

    public static class PVEControllers {

        private final PveClient client;

        protected PVEControllers(PveClient client) {
            this.client = client;

        }

        public PVEControllers.PVEControllerItem get(Object controller) {
            return new PVEControllerItem(client, controller);
        }

        public static class PVEControllerItem {

            private final PveClient client;
            private final Object controller;

            protected PVEControllerItem(PveClient client, Object controller) {
                this.client = client;
                this.controller = controller;
            }

            /**
             * Delete sdn controller object configuration.
             *
             * @param lock_token the token for unlocking the global SDN configuration
             * @return Result
             */

            public Result delete(String lock_token) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("lock-token", lock_token);
                return client.delete("/cluster/sdn/controllers/" + this.controller, parameters);
            }

            /**
             * Delete sdn controller object configuration.
             *
             * @return Result
             */

            public Result delete() {
                return client.delete("/cluster/sdn/controllers/" + this.controller, null);
            }

            /**
             * Read sdn controller configuration.
             *
             * @param pending Display pending config.
             * @param running Display running config.
             * @return Result
             */

            public Result read(Boolean pending, Boolean running) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("pending", pending);
                parameters.put("running", running);
                return client.get("/cluster/sdn/controllers/" + this.controller, parameters);
            }

            /**
             * Read sdn controller configuration.
             *
             * @return Result
             */

            public Result read() {
                return client.get("/cluster/sdn/controllers/" + this.controller, null);
            }

            /**
             * Update sdn controller object configuration.
             *
             * @param asn                         autonomous system number
             * @param bgp_multipath_as_path_relax Consider different AS paths of equal
             *                                    length for multipath computation.
             * @param delete                      A list of settings you want to delete.
             * @param digest                      Prevent changes if current configuration
             *                                    file has a different digest. This can be
             *                                    used to prevent concurrent modifications.
             * @param ebgp                        Enable eBGP (remote-as external).
             * @param ebgp_multihop               Set maximum amount of hops for eBGP peers.
             * @param fabric                      SDN fabric to use as underlay for this
             *                                    EVPN controller.
             * @param isis_domain                 Name of the IS-IS domain.
             * @param isis_ifaces                 Comma-separated list of interfaces where
             *                                    IS-IS should be active.
             * @param isis_net                    Network Entity title for this node in the
             *                                    IS-IS network.
             * @param lock_token                  the token for unlocking the global SDN
             *                                    configuration
             * @param loopback                    Name of the loopback/dummy interface that
             *                                    provides the Router-IP.
             * @param node                        The cluster node name.
             * @param peers                       peers address list.
             * @return Result
             */

            public Result update(Integer asn, Boolean bgp_multipath_as_path_relax, String delete, String digest,
                                 Boolean ebgp, Integer ebgp_multihop, String fabric, String isis_domain, String isis_ifaces,
                                 String isis_net, String lock_token, String loopback, String node, String peers) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("asn", asn);
                parameters.put("bgp-multipath-as-path-relax", bgp_multipath_as_path_relax);
                parameters.put("delete", delete);
                parameters.put("digest", digest);
                parameters.put("ebgp", ebgp);
                parameters.put("ebgp-multihop", ebgp_multihop);
                parameters.put("fabric", fabric);
                parameters.put("isis-domain", isis_domain);
                parameters.put("isis-ifaces", isis_ifaces);
                parameters.put("isis-net", isis_net);
                parameters.put("lock-token", lock_token);
                parameters.put("loopback", loopback);
                parameters.put("node", node);
                parameters.put("peers", peers);
                return client.set("/cluster/sdn/controllers/" + this.controller, parameters);
            }

            /**
             * Update sdn controller object configuration.
             *
             * @return Result
             */

            public Result update() {
                return client.set("/cluster/sdn/controllers/" + this.controller, null);
            }

        }

        /**
         * SDN controllers index.
         *
         * @param pending Display pending config.
         * @param running Display running config.
         * @param type    Only list sdn controllers of specific type
         *                Enum: bgp,evpn,faucet,isis
         * @return Result
         */

        public Result index(Boolean pending, Boolean running, String type) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("pending", pending);
            parameters.put("running", running);
            parameters.put("type", type);
            return client.get("/cluster/sdn/controllers", parameters);
        }

        /**
         * SDN controllers index.
         *
         * @return Result
         */

        public Result index() {
            return client.get("/cluster/sdn/controllers", null);
        }

        /**
         * Create a new sdn controller object.
         *
         * @param controller                  The SDN controller object identifier.
         * @param type                        Plugin type.
         *                                    Enum: bgp,evpn,faucet,isis
         * @param asn                         autonomous system number
         * @param bgp_multipath_as_path_relax Consider different AS paths of equal
         *                                    length for multipath computation.
         * @param ebgp                        Enable eBGP (remote-as external).
         * @param ebgp_multihop               Set maximum amount of hops for eBGP peers.
         * @param fabric                      SDN fabric to use as underlay for this
         *                                    EVPN controller.
         * @param isis_domain                 Name of the IS-IS domain.
         * @param isis_ifaces                 Comma-separated list of interfaces where
         *                                    IS-IS should be active.
         * @param isis_net                    Network Entity title for this node in the
         *                                    IS-IS network.
         * @param lock_token                  the token for unlocking the global SDN
         *                                    configuration
         * @param loopback                    Name of the loopback/dummy interface that
         *                                    provides the Router-IP.
         * @param node                        The cluster node name.
         * @param peers                       peers address list.
         * @return Result
         */

        public Result create(String controller, String type, Integer asn, Boolean bgp_multipath_as_path_relax,
                             Boolean ebgp, Integer ebgp_multihop, String fabric, String isis_domain, String isis_ifaces,
                             String isis_net, String lock_token, String loopback, String node, String peers) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("controller", controller);
            parameters.put("type", type);
            parameters.put("asn", asn);
            parameters.put("bgp-multipath-as-path-relax", bgp_multipath_as_path_relax);
            parameters.put("ebgp", ebgp);
            parameters.put("ebgp-multihop", ebgp_multihop);
            parameters.put("fabric", fabric);
            parameters.put("isis-domain", isis_domain);
            parameters.put("isis-ifaces", isis_ifaces);
            parameters.put("isis-net", isis_net);
            parameters.put("lock-token", lock_token);
            parameters.put("loopback", loopback);
            parameters.put("node", node);
            parameters.put("peers", peers);
            return client.create("/cluster/sdn/controllers", parameters);
        }

        /**
         * Create a new sdn controller object.
         *
         * @param controller The SDN controller object identifier.
         * @param type       Plugin type.
         *                   Enum: bgp,evpn,faucet,isis
         * @return Result
         */

        public Result create(String controller, String type) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("controller", controller);
            parameters.put("type", type);
            return client.create("/cluster/sdn/controllers", parameters);
        }

    }

    public static class PVEIpams {

        private final PveClient client;

        protected PVEIpams(PveClient client) {
            this.client = client;

        }

        public PVEIpams.PVEIpamItem get(Object ipam) {
            return new PVEIpamItem(client, ipam);
        }

        public static class PVEIpamItem {

            private final PveClient client;
            private final Object ipam;

            protected PVEIpamItem(PveClient client, Object ipam) {
                this.client = client;
                this.ipam = ipam;
            }

            private PVEIpams.PVEIpamItem.PVEStatus status;

            public PVEIpams.PVEIpamItem.PVEStatus getStatus() {
                return status == null ? (status = new PVEStatus(client, this.ipam)) : status;
            }

            public static class PVEStatus {

                private final PveClient client;
                private final Object ipam;

                protected PVEStatus(PveClient client, Object ipam) {
                    this.client = client;
                    this.ipam = ipam;
                }

                /**
                 * List PVE IPAM Entries
                 *
                 * @return Result
                 */

                public Result ipamindex() {
                    return client.get("/cluster/sdn/ipams/" + this.ipam + "/status", null);
                }

            }

            /**
             * Delete sdn ipam object configuration.
             *
             * @param lock_token the token for unlocking the global SDN configuration
             * @return Result
             */

            public Result delete(String lock_token) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("lock-token", lock_token);
                return client.delete("/cluster/sdn/ipams/" + this.ipam, parameters);
            }

            /**
             * Delete sdn ipam object configuration.
             *
             * @return Result
             */

            public Result delete() {
                return client.delete("/cluster/sdn/ipams/" + this.ipam, null);
            }

            /**
             * Read sdn ipam configuration.
             *
             * @return Result
             */

            public Result read() {
                return client.get("/cluster/sdn/ipams/" + this.ipam, null);
            }

            /**
             * Update sdn ipam object configuration.
             *
             * @param delete      A list of settings you want to delete.
             * @param digest      Prevent changes if current configuration file has a
             *                    different digest. This can be used to prevent concurrent
             *                    modifications.
             * @param fingerprint Certificate SHA 256 fingerprint.
             * @param lock_token  the token for unlocking the global SDN configuration
             * @param section
             * @param token
             * @param url
             * @return Result
             */

            public Result update(String delete, String digest, String fingerprint, String lock_token,
                                 Integer section, String token, String url) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("delete", delete);
                parameters.put("digest", digest);
                parameters.put("fingerprint", fingerprint);
                parameters.put("lock-token", lock_token);
                parameters.put("section", section);
                parameters.put("token", token);
                parameters.put("url", url);
                return client.set("/cluster/sdn/ipams/" + this.ipam, parameters);
            }

            /**
             * Update sdn ipam object configuration.
             *
             * @return Result
             */

            public Result update() {
                return client.set("/cluster/sdn/ipams/" + this.ipam, null);
            }

        }

        /**
         * SDN ipams index.
         *
         * @param type Only list sdn ipams of specific type
         *             Enum: netbox,phpipam,pve
         * @return Result
         */

        public Result index(String type) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("type", type);
            return client.get("/cluster/sdn/ipams", parameters);
        }

        /**
         * SDN ipams index.
         *
         * @return Result
         */

        public Result index() {
            return client.get("/cluster/sdn/ipams", null);
        }

        /**
         * Create a new sdn ipam object.
         *
         * @param ipam        The SDN ipam object identifier.
         * @param type        Plugin type.
         *                    Enum: netbox,phpipam,pve
         * @param fingerprint Certificate SHA 256 fingerprint.
         * @param lock_token  the token for unlocking the global SDN configuration
         * @param section
         * @param token
         * @param url
         * @return Result
         */

        public Result create(String ipam, String type, String fingerprint, String lock_token, Integer section,
                             String token, String url) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("ipam", ipam);
            parameters.put("type", type);
            parameters.put("fingerprint", fingerprint);
            parameters.put("lock-token", lock_token);
            parameters.put("section", section);
            parameters.put("token", token);
            parameters.put("url", url);
            return client.create("/cluster/sdn/ipams", parameters);
        }

        /**
         * Create a new sdn ipam object.
         *
         * @param ipam The SDN ipam object identifier.
         * @param type Plugin type.
         *             Enum: netbox,phpipam,pve
         * @return Result
         */

        public Result create(String ipam, String type) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("ipam", ipam);
            parameters.put("type", type);
            return client.create("/cluster/sdn/ipams", parameters);
        }

    }

    public static class PVEDns {

        private final PveClient client;

        protected PVEDns(PveClient client) {
            this.client = client;

        }

        public PVEDns.PVEDnsItem get(Object dns) {
            return new PVEDnsItem(client, dns);
        }

        public static class PVEDnsItem {

            private final PveClient client;
            private final Object dns;

            protected PVEDnsItem(PveClient client, Object dns) {
                this.client = client;
                this.dns = dns;
            }

            /**
             * Delete sdn dns object configuration.
             *
             * @param lock_token the token for unlocking the global SDN configuration
             * @return Result
             */

            public Result delete(String lock_token) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("lock-token", lock_token);
                return client.delete("/cluster/sdn/dns/" + this.dns, parameters);
            }

            /**
             * Delete sdn dns object configuration.
             *
             * @return Result
             */

            public Result delete() {
                return client.delete("/cluster/sdn/dns/" + this.dns, null);
            }

            /**
             * Read sdn dns configuration.
             *
             * @return Result
             */

            public Result read() {
                return client.get("/cluster/sdn/dns/" + this.dns, null);
            }

            /**
             * Update sdn dns object configuration.
             *
             * @param delete        A list of settings you want to delete.
             * @param digest        Prevent changes if current configuration file has a
             *                      different digest. This can be used to prevent concurrent
             *                      modifications.
             * @param fingerprint   Certificate SHA 256 fingerprint.
             * @param key
             * @param lock_token    the token for unlocking the global SDN configuration
             * @param reversemaskv6
             * @param ttl
             * @param url
             * @return Result
             */

            public Result update(String delete, String digest, String fingerprint, String key,
                                 String lock_token, Integer reversemaskv6, Integer ttl, String url) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("delete", delete);
                parameters.put("digest", digest);
                parameters.put("fingerprint", fingerprint);
                parameters.put("key", key);
                parameters.put("lock-token", lock_token);
                parameters.put("reversemaskv6", reversemaskv6);
                parameters.put("ttl", ttl);
                parameters.put("url", url);
                return client.set("/cluster/sdn/dns/" + this.dns, parameters);
            }

            /**
             * Update sdn dns object configuration.
             *
             * @return Result
             */

            public Result update() {
                return client.set("/cluster/sdn/dns/" + this.dns, null);
            }

        }

        /**
         * SDN dns index.
         *
         * @param type Only list sdn dns of specific type
         *             Enum: powerdns
         * @return Result
         */

        public Result index(String type) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("type", type);
            return client.get("/cluster/sdn/dns", parameters);
        }

        /**
         * SDN dns index.
         *
         * @return Result
         */

        public Result index() {
            return client.get("/cluster/sdn/dns", null);
        }

        /**
         * Create a new sdn dns object.
         *
         * @param dns           The SDN dns object identifier.
         * @param key
         * @param type          Plugin type.
         *                      Enum: powerdns
         * @param url
         * @param fingerprint   Certificate SHA 256 fingerprint.
         * @param lock_token    the token for unlocking the global SDN configuration
         * @param reversemaskv6
         * @param reversev6mask
         * @param ttl
         * @return Result
         */

        public Result create(String dns, String key, String type, String url, String fingerprint,
                             String lock_token, Integer reversemaskv6, Integer reversev6mask, Integer ttl) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("dns", dns);
            parameters.put("key", key);
            parameters.put("type", type);
            parameters.put("url", url);
            parameters.put("fingerprint", fingerprint);
            parameters.put("lock-token", lock_token);
            parameters.put("reversemaskv6", reversemaskv6);
            parameters.put("reversev6mask", reversev6mask);
            parameters.put("ttl", ttl);
            return client.create("/cluster/sdn/dns", parameters);
        }

        /**
         * Create a new sdn dns object.
         *
         * @param dns  The SDN dns object identifier.
         * @param key
         * @param type Plugin type.
         *             Enum: powerdns
         * @param url
         * @return Result
         */

        public Result create(String dns, String key, String type, String url) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("dns", dns);
            parameters.put("key", key);
            parameters.put("type", type);
            parameters.put("url", url);
            return client.create("/cluster/sdn/dns", parameters);
        }

    }

    public static class PVEFabrics {

        private final PveClient client;

        protected PVEFabrics(PveClient client) {
            this.client = client;

        }

        private PVEFabrics.PVEFabric fabric;

        public PVEFabrics.PVEFabric getFabric() {
            return fabric == null ? (fabric = new PVEFabric(client)) : fabric;
        }

        private PVEFabrics.PVENode node;

        public PVEFabrics.PVENode getNode() {
            return node == null ? (node = new PVENode(client)) : node;
        }

        private PVEFabrics.PVEAll all;

        public PVEFabrics.PVEAll getAll() {
            return all == null ? (all = new PVEAll(client)) : all;
        }

        public static class PVEFabric {

            private final PveClient client;

            protected PVEFabric(PveClient client) {
                this.client = client;

            }

            public PVEFabrics.PVEFabric.PVEIdItem get(Object id) {
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
                 * Add a fabric
                 *
                 * @return Result
                 */

                public Result deleteFabric() {
                    return client.delete("/cluster/sdn/fabrics/fabric/" + this.id, null);
                }

                /**
                 * Update a fabric
                 *
                 * @return Result
                 */

                public Result getFabric() {
                    return client.get("/cluster/sdn/fabrics/fabric/" + this.id, null);
                }

                /**
                 * Update a fabric
                 *
                 * @param delete
                 * @param protocol       Type of configuration entry in an SDN Fabric section
                 *                       config
                 *                       Enum: openfabric,ospf
                 * @param area           OSPF area. Either a IPv4 address or a 32-bit number.
                 *                       Gets validated in rust.
                 * @param csnp_interval  The csnp_interval property for Openfabric
                 * @param digest         Prevent changes if current configuration file has a
                 *                       different digest. This can be used to prevent
                 *                       concurrent modifications.
                 * @param hello_interval The hello_interval property for Openfabric
                 * @param ip6_prefix     The IP prefix for Node IPs
                 * @param ip_prefix      The IP prefix for Node IPs
                 * @param lock_token     the token for unlocking the global SDN configuration
                 * @return Result
                 */

                public Result updateFabric(List<Object> delete, String protocol, String area,
                                           Float csnp_interval, String digest, Float hello_interval, String ip6_prefix,
                                           String ip_prefix, String lock_token) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("delete", delete);
                    parameters.put("protocol", protocol);
                    parameters.put("area", area);
                    parameters.put("csnp_interval", csnp_interval);
                    parameters.put("digest", digest);
                    parameters.put("hello_interval", hello_interval);
                    parameters.put("ip6_prefix", ip6_prefix);
                    parameters.put("ip_prefix", ip_prefix);
                    parameters.put("lock-token", lock_token);
                    return client.set("/cluster/sdn/fabrics/fabric/" + this.id, parameters);
                }

                /**
                 * Update a fabric
                 *
                 * @param delete
                 * @param protocol Type of configuration entry in an SDN Fabric section config
                 *                 Enum: openfabric,ospf
                 * @return Result
                 */

                public Result updateFabric(List<Object> delete, String protocol) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("delete", delete);
                    parameters.put("protocol", protocol);
                    return client.set("/cluster/sdn/fabrics/fabric/" + this.id, parameters);
                }

            }

            /**
             * SDN Fabrics Index
             *
             * @param pending Display pending config.
             * @param running Display running config.
             * @return Result
             */

            public Result index(Boolean pending, Boolean running) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("pending", pending);
                parameters.put("running", running);
                return client.get("/cluster/sdn/fabrics/fabric", parameters);
            }

            /**
             * SDN Fabrics Index
             *
             * @return Result
             */

            public Result index() {
                return client.get("/cluster/sdn/fabrics/fabric", null);
            }

            /**
             * Add a fabric
             *
             * @param id             Identifier for SDN fabrics
             * @param protocol       Type of configuration entry in an SDN Fabric section
             *                       config
             *                       Enum: openfabric,ospf
             * @param area           OSPF area. Either a IPv4 address or a 32-bit number.
             *                       Gets validated in rust.
             * @param csnp_interval  The csnp_interval property for Openfabric
             * @param digest         Prevent changes if current configuration file has a
             *                       different digest. This can be used to prevent
             *                       concurrent modifications.
             * @param hello_interval The hello_interval property for Openfabric
             * @param ip6_prefix     The IP prefix for Node IPs
             * @param ip_prefix      The IP prefix for Node IPs
             * @param lock_token     the token for unlocking the global SDN configuration
             * @return Result
             */

            public Result addFabric(String id, String protocol, String area, Float csnp_interval, String digest,
                                    Float hello_interval, String ip6_prefix, String ip_prefix, String lock_token) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("id", id);
                parameters.put("protocol", protocol);
                parameters.put("area", area);
                parameters.put("csnp_interval", csnp_interval);
                parameters.put("digest", digest);
                parameters.put("hello_interval", hello_interval);
                parameters.put("ip6_prefix", ip6_prefix);
                parameters.put("ip_prefix", ip_prefix);
                parameters.put("lock-token", lock_token);
                return client.create("/cluster/sdn/fabrics/fabric", parameters);
            }

            /**
             * Add a fabric
             *
             * @param id       Identifier for SDN fabrics
             * @param protocol Type of configuration entry in an SDN Fabric section config
             *                 Enum: openfabric,ospf
             * @return Result
             */

            public Result addFabric(String id, String protocol) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("id", id);
                parameters.put("protocol", protocol);
                return client.create("/cluster/sdn/fabrics/fabric", parameters);
            }

        }

        public static class PVENode {

            private final PveClient client;

            protected PVENode(PveClient client) {
                this.client = client;

            }

            public PVEFabrics.PVENode.PVEFabricIdItem get(Object fabric_id) {
                return new PVEFabricIdItem(client, fabric_id);
            }

            public static class PVEFabricIdItem {

                private final PveClient client;
                private final Object fabric_id;

                protected PVEFabricIdItem(PveClient client, Object fabric_id) {
                    this.client = client;
                    this.fabric_id = fabric_id;
                }

                public PVEFabrics.PVENode.PVEFabricIdItem.PVENodeIdItem get(Object node_id) {
                    return new PVENodeIdItem(client, this.fabric_id, node_id);
                }

                public static class PVENodeIdItem {

                    private final PveClient client;
                    private final Object fabric_id;
                    private final Object node_id;

                    protected PVENodeIdItem(PveClient client, Object fabric_id, Object node_id) {
                        this.client = client;
                        this.fabric_id = fabric_id;
                        this.node_id = node_id;
                    }

                    /**
                     * Add a node
                     *
                     * @return Result
                     */

                    public Result deleteNode() {
                        return client.delete(
                                "/cluster/sdn/fabrics/node/" + this.fabric_id + "/" + this.node_id, null);
                    }

                    /**
                     * Get a node
                     *
                     * @return Result
                     */

                    public Result getNode() {
                        return client.get(
                                "/cluster/sdn/fabrics/node/" + this.fabric_id + "/" + this.node_id, null);
                    }

                    /**
                     * Update a node
                     *
                     * @param interfaces
                     * @param protocol   Type of configuration entry in an SDN Fabric section config
                     *                   Enum: openfabric,ospf
                     * @param delete
                     * @param digest     Prevent changes if current configuration file has a
                     *                   different digest. This can be used to prevent concurrent
                     *                   modifications.
                     * @param ip         IPv4 address for this node
                     * @param ip6        IPv6 address for this node
                     * @param lock_token the token for unlocking the global SDN configuration
                     * @return Result
                     */

                    public Result updateNode(List<Object> interfaces, String protocol, List<Object> delete,
                                             String digest, String ip, String ip6, String lock_token) {
                        Map<String, Object> parameters = new HashMap<>();
                        parameters.put("interfaces", interfaces);
                        parameters.put("protocol", protocol);
                        parameters.put("delete", delete);
                        parameters.put("digest", digest);
                        parameters.put("ip", ip);
                        parameters.put("ip6", ip6);
                        parameters.put("lock-token", lock_token);
                        return client.set(
                                "/cluster/sdn/fabrics/node/" + this.fabric_id + "/" + this.node_id,
                                parameters);
                    }

                    /**
                     * Update a node
                     *
                     * @param interfaces
                     * @param protocol   Type of configuration entry in an SDN Fabric section config
                     *                   Enum: openfabric,ospf
                     * @return Result
                     */

                    public Result updateNode(List<Object> interfaces, String protocol) {
                        Map<String, Object> parameters = new HashMap<>();
                        parameters.put("interfaces", interfaces);
                        parameters.put("protocol", protocol);
                        return client.set(
                                "/cluster/sdn/fabrics/node/" + this.fabric_id + "/" + this.node_id,
                                parameters);
                    }

                }

                /**
                 * SDN Fabrics Index
                 *
                 * @param pending Display pending config.
                 * @param running Display running config.
                 * @return Result
                 */

                public Result listNodesFabric(Boolean pending, Boolean running) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("pending", pending);
                    parameters.put("running", running);
                    return client.get("/cluster/sdn/fabrics/node/" + this.fabric_id, parameters);
                }

                /**
                 * SDN Fabrics Index
                 *
                 * @return Result
                 */

                public Result listNodesFabric() {
                    return client.get("/cluster/sdn/fabrics/node/" + this.fabric_id, null);
                }

                /**
                 * Add a node
                 *
                 * @param interfaces
                 * @param node_id    Identifier for nodes in an SDN fabric
                 * @param protocol   Type of configuration entry in an SDN Fabric section config
                 *                   Enum: openfabric,ospf
                 * @param digest     Prevent changes if current configuration file has a
                 *                   different digest. This can be used to prevent concurrent
                 *                   modifications.
                 * @param ip         IPv4 address for this node
                 * @param ip6        IPv6 address for this node
                 * @param lock_token the token for unlocking the global SDN configuration
                 * @return Result
                 */

                public Result addNode(List<Object> interfaces, String node_id, String protocol, String digest,
                                      String ip, String ip6, String lock_token) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("interfaces", interfaces);
                    parameters.put("node_id", node_id);
                    parameters.put("protocol", protocol);
                    parameters.put("digest", digest);
                    parameters.put("ip", ip);
                    parameters.put("ip6", ip6);
                    parameters.put("lock-token", lock_token);
                    return client.create("/cluster/sdn/fabrics/node/" + this.fabric_id, parameters);
                }

                /**
                 * Add a node
                 *
                 * @param interfaces
                 * @param node_id    Identifier for nodes in an SDN fabric
                 * @param protocol   Type of configuration entry in an SDN Fabric section config
                 *                   Enum: openfabric,ospf
                 * @return Result
                 */

                public Result addNode(List<Object> interfaces, String node_id, String protocol) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("interfaces", interfaces);
                    parameters.put("node_id", node_id);
                    parameters.put("protocol", protocol);
                    return client.create("/cluster/sdn/fabrics/node/" + this.fabric_id, parameters);
                }

            }

            /**
             * SDN Fabrics Index
             *
             * @param pending Display pending config.
             * @param running Display running config.
             * @return Result
             */

            public Result listNodes(Boolean pending, Boolean running) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("pending", pending);
                parameters.put("running", running);
                return client.get("/cluster/sdn/fabrics/node", parameters);
            }

            /**
             * SDN Fabrics Index
             *
             * @return Result
             */

            public Result listNodes() {
                return client.get("/cluster/sdn/fabrics/node", null);
            }

        }

        public static class PVEAll {

            private final PveClient client;

            protected PVEAll(PveClient client) {
                this.client = client;

            }

            /**
             * SDN Fabrics Index
             *
             * @param pending Display pending config.
             * @param running Display running config.
             * @return Result
             */

            public Result listAll(Boolean pending, Boolean running) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("pending", pending);
                parameters.put("running", running);
                return client.get("/cluster/sdn/fabrics/all", parameters);
            }

            /**
             * SDN Fabrics Index
             *
             * @return Result
             */

            public Result listAll() {
                return client.get("/cluster/sdn/fabrics/all", null);
            }

        }

        /**
         * SDN Fabrics Index
         *
         * @return Result
         */

        public Result index() {
            return client.get("/cluster/sdn/fabrics", null);
        }

    }

    public static class PVELock {

        private final PveClient client;

        protected PVELock(PveClient client) {
            this.client = client;

        }

        /**
         * Release global lock for SDN configuration
         *
         * @param force      if true, allow releasing lock without providing the token
         * @param lock_token the token for unlocking the global SDN configuration
         * @return Result
         */

        public Result releaseLock(Boolean force, String lock_token) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("force", force);
            parameters.put("lock-token", lock_token);
            return client.delete("/cluster/sdn/lock", parameters);
        }

        /**
         * Release global lock for SDN configuration
         *
         * @return Result
         */

        public Result releaseLock() {
            return client.delete("/cluster/sdn/lock", null);
        }

        /**
         * Acquire global lock for SDN configuration
         *
         * @param allow_pending if true, allow acquiring lock even though there are
         *                      pending changes
         * @return Result
         */

        public Result lock(Boolean allow_pending) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("allow-pending", allow_pending);
            return client.create("/cluster/sdn/lock", parameters);
        }

        /**
         * Acquire global lock for SDN configuration
         *
         * @return Result
         */

        public Result lock() {
            return client.create("/cluster/sdn/lock", null);
        }

    }

    public static class PVERollback {

        private final PveClient client;

        protected PVERollback(PveClient client) {
            this.client = client;

        }

        /**
         * Rollback pending changes to SDN configuration
         *
         * @param lock_token   the token for unlocking the global SDN configuration
         * @param release_lock When lock-token has been provided and configuration
         *                     successfully rollbacked, release the lock automatically
         *                     afterwards
         * @return Result
         */

        public Result rollback(String lock_token, Boolean release_lock) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("lock-token", lock_token);
            parameters.put("release-lock", release_lock);
            return client.create("/cluster/sdn/rollback", parameters);
        }

        /**
         * Rollback pending changes to SDN configuration
         *
         * @return Result
         */

        public Result rollback() {
            return client.create("/cluster/sdn/rollback", null);
        }

    }

    /**
     * Directory index.
     *
     * @return Result
     */

    public Result index() {
        return client.get("/cluster/sdn", null);
    }

    /**
     * Apply sdn controller changes &amp;&amp; reload.
     *
     * @param lock_token   the token for unlocking the global SDN configuration
     * @param release_lock When lock-token has been provided and configuration
     *                     successfully commited, release the lock automatically
     *                     afterwards
     * @return Result
     */

    public Result reload(String lock_token, Boolean release_lock) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("lock-token", lock_token);
        parameters.put("release-lock", release_lock);
        return client.set("/cluster/sdn", parameters);
    }

    /**
     * Apply sdn controller changes &amp;&amp; reload.
     *
     * @return Result
     */

    public Result reload() {
        return client.set("/cluster/sdn", null);
    }

}

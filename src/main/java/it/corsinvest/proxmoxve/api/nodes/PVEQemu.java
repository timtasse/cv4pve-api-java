package it.corsinvest.proxmoxve.api.nodes;

import it.corsinvest.proxmoxve.api.PveClient;
import it.corsinvest.proxmoxve.api.PveClientBase;
import it.corsinvest.proxmoxve.api.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class PVEQemu {

    private final PveClient client;
    private final Object node;

    public PVEQemu(PveClient client, Object node) {
        this.client = client;
        this.node = node;
    }

    public PVEVmidItem get(Object vmid) {
        return new PVEVmidItem(client, this.node, vmid);
    }

    public static class PVEVmidItem {

        private final PveClient client;
        private final Object node;
        private final Object vmid;

        protected PVEVmidItem(PveClient client, Object node, Object vmid) {
            this.client = client;
            this.node = node;
            this.vmid = vmid;
        }

        public PveClient getClient() {
            return client;
        }

        public Object getNode() {
            return node;
        }

        public Object getVmid() {
            return vmid;
        }

        private PVEVmidItem.PVEFirewall firewall;

        public PVEVmidItem.PVEFirewall getFirewall() {
            return firewall == null ? (firewall = new PVEFirewall(client, this.node, this.vmid)) : firewall;
        }

        private PVEVmidItem.PVEAgent agent;

        public PVEVmidItem.PVEAgent getAgent() {
            return agent == null ? (agent = new PVEAgent(client, this.node, this.vmid)) : agent;
        }

        private PVEVmidItem.PVERrd rrd;

        public PVEVmidItem.PVERrd getRrd() {
            return rrd == null ? (rrd = new PVERrd(client, this.node, this.vmid)) : rrd;
        }

        private PVEVmidItem.PVERrddata rrddata;

        public PVEVmidItem.PVERrddata getRrddata() {
            return rrddata == null ? (rrddata = new PVERrddata(client, this.node, this.vmid)) : rrddata;
        }

        private PVEVmidItem.PVEConfig config;

        public PVEVmidItem.PVEConfig getConfig() {
            return config == null ? (config = new PVEConfig(client, this.node, this.vmid)) : config;
        }

        private PVEVmidItem.PVEPending pending;

        public PVEVmidItem.PVEPending getPending() {
            return pending == null ? (pending = new PVEPending(client, this.node, this.vmid)) : pending;
        }

        private PVEVmidItem.PVECloudinit cloudinit;

        public PVEVmidItem.PVECloudinit getCloudinit() {
            return cloudinit == null ? (cloudinit = new PVECloudinit(client, this.node, this.vmid))
                    : cloudinit;
        }

        private PVEVmidItem.PVEUnlink unlink;

        public PVEVmidItem.PVEUnlink getUnlink() {
            return unlink == null ? (unlink = new PVEUnlink(client, this.node, this.vmid)) : unlink;
        }

        private PVEVmidItem.PVEVncproxy vncproxy;

        public PVEVmidItem.PVEVncproxy getVncproxy() {
            return vncproxy == null ? (vncproxy = new PVEVncproxy(client, this.node, this.vmid)) : vncproxy;
        }

        private PVEVmidItem.PVETermproxy termproxy;

        public PVEVmidItem.PVETermproxy getTermproxy() {
            return termproxy == null ? (termproxy = new PVETermproxy(client, this.node, this.vmid))
                    : termproxy;
        }

        private PVEVmidItem.PVEVncwebsocket vncwebsocket;

        public PVEVmidItem.PVEVncwebsocket getVncwebsocket() {
            return vncwebsocket == null ? (vncwebsocket = new PVEVncwebsocket(client, this.node, this.vmid))
                    : vncwebsocket;
        }

        private PVEVmidItem.PVESpiceproxy spiceproxy;

        public PVEVmidItem.PVESpiceproxy getSpiceproxy() {
            return spiceproxy == null ? (spiceproxy = new PVESpiceproxy(client, this.node, this.vmid))
                    : spiceproxy;
        }

        private PVEVmidItem.PVEStatus status;

        public PVEVmidItem.PVEStatus getStatus() {
            return status == null ? (status = new PVEStatus(client, this.node, this.vmid)) : status;
        }

        private PVEVmidItem.PVESendkey sendkey;

        public PVEVmidItem.PVESendkey getSendkey() {
            return sendkey == null ? (sendkey = new PVESendkey(client, this.node, this.vmid)) : sendkey;
        }

        private PVEVmidItem.PVEFeature feature;

        public PVEVmidItem.PVEFeature getFeature() {
            return feature == null ? (feature = new PVEFeature(client, this.node, this.vmid)) : feature;
        }

        private PVEVmidItem.PVEClone clone;

        public PVEVmidItem.PVEClone getClone() {
            return clone == null ? (clone = new PVEClone(client, this.node, this.vmid)) : clone;
        }

        private PVEVmidItem.PVEMoveDisk moveDisk;

        public PVEVmidItem.PVEMoveDisk getMoveDisk() {
            return moveDisk == null ? (moveDisk = new PVEMoveDisk(client, this.node, this.vmid)) : moveDisk;
        }

        private PVEVmidItem.PVEMigrate migrate;

        public PVEVmidItem.PVEMigrate getMigrate() {
            return migrate == null ? (migrate = new PVEMigrate(client, this.node, this.vmid)) : migrate;
        }

        private PVEVmidItem.PVERemoteMigrate remoteMigrate;

        public PVEVmidItem.PVERemoteMigrate getRemoteMigrate() {
            return remoteMigrate == null
                    ? (remoteMigrate = new PVERemoteMigrate(client, this.node, this.vmid))
                    : remoteMigrate;
        }

        private PVEVmidItem.PVEMonitor monitor;

        public PVEVmidItem.PVEMonitor getMonitor() {
            return monitor == null ? (monitor = new PVEMonitor(client, this.node, this.vmid)) : monitor;
        }

        private PVEVmidItem.PVEResize resize;

        public PVEVmidItem.PVEResize getResize() {
            return resize == null ? (resize = new PVEResize(client, this.node, this.vmid)) : resize;
        }

        private PVEVmidItem.PVESnapshot snapshot;

        public PVEVmidItem.PVESnapshot getSnapshot() {
            return snapshot == null ? (snapshot = new PVESnapshot(client, this.node, this.vmid)) : snapshot;
        }

        private PVEVmidItem.PVETemplate template;

        public PVEVmidItem.PVETemplate getTemplate() {
            return template == null ? (template = new PVETemplate(client, this.node, this.vmid)) : template;
        }

        private PVEVmidItem.PVEMtunnel mtunnel;

        public PVEVmidItem.PVEMtunnel getMtunnel() {
            return mtunnel == null ? (mtunnel = new PVEMtunnel(client, this.node, this.vmid)) : mtunnel;
        }

        private PVEVmidItem.PVEMtunnelwebsocket mtunnelwebsocket;

        public PVEVmidItem.PVEMtunnelwebsocket getMtunnelwebsocket() {
            return mtunnelwebsocket == null
                    ? (mtunnelwebsocket = new PVEMtunnelwebsocket(client, this.node, this.vmid))
                    : mtunnelwebsocket;
        }

        private PVEVmidItem.PVEDbusVmstate dbusVmstate;

        public PVEVmidItem.PVEDbusVmstate getDbusVmstate() {
            return dbusVmstate == null ? (dbusVmstate = new PVEDbusVmstate(client, this.node, this.vmid))
                    : dbusVmstate;
        }

        public static class PVEFirewall {

            private final PveClient client;
            private final Object node;
            private final Object vmid;

            protected PVEFirewall(PveClient client, Object node, Object vmid) {
                this.client = client;
                this.node = node;
                this.vmid = vmid;
            }

            private PVEVmidItem.PVEFirewall.PVERules rules;

            public PVEVmidItem.PVEFirewall.PVERules getRules() {
                return rules == null ? (rules = new PVERules(client, this.node, this.vmid)) : rules;
            }

            private PVEVmidItem.PVEFirewall.PVEAliases aliases;

            public PVEVmidItem.PVEFirewall.PVEAliases getAliases() {
                return aliases == null ? (aliases = new PVEAliases(client, this.node, this.vmid)) : aliases;
            }

            private PVEVmidItem.PVEFirewall.PVEIpset ipset;

            public PVEVmidItem.PVEFirewall.PVEIpset getIpset() {
                return ipset == null ? (ipset = new PVEIpset(client, this.node, this.vmid)) : ipset;
            }

            private PVEVmidItem.PVEFirewall.PVEOptions options;

            public PVEVmidItem.PVEFirewall.PVEOptions getOptions() {
                return options == null ? (options = new PVEOptions(client, this.node, this.vmid)) : options;
            }

            private PVEVmidItem.PVEFirewall.PVELog log;

            public PVEVmidItem.PVEFirewall.PVELog getLog() {
                return log == null ? (log = new PVELog(client, this.node, this.vmid)) : log;
            }

            private PVEVmidItem.PVEFirewall.PVERefs refs;

            public PVEVmidItem.PVEFirewall.PVERefs getRefs() {
                return refs == null ? (refs = new PVERefs(client, this.node, this.vmid)) : refs;
            }

            public static class PVERules {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVERules(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                public PVEVmidItem.PVEFirewall.PVERules.PVEPosItem get(Object pos) {
                    return new PVEPosItem(client, this.node, this.vmid, pos);
                }

                public static class PVEPosItem {

                    private final PveClient client;
                    private final Object node;
                    private final Object vmid;
                    private final Object pos;

                    protected PVEPosItem(PveClient client, Object node, Object vmid, Object pos) {
                        this.client = client;
                        this.node = node;
                        this.vmid = vmid;
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
                        return client.delete("/nodes/" + this.node + "/qemu/" + this.vmid
                                + "/firewall/rules/" + this.pos, parameters);
                    }

                    /**
                     * Delete rule.
                     *
                     * @return Result
                     */

                    public Result deleteRule() {
                        return client.delete("/nodes/" + this.node + "/qemu/" + this.vmid
                                + "/firewall/rules/" + this.pos, null);
                    }

                    /**
                     * Get single rule data.
                     *
                     * @return Result
                     */

                    public Result getRule() {
                        return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/firewall/rules/"
                                + this.pos, null);
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
                        return client.set("/nodes/" + this.node + "/qemu/" + this.vmid + "/firewall/rules/"
                                + this.pos, parameters);
                    }

                    /**
                     * Modify rule data.
                     *
                     * @return Result
                     */

                    public Result updateRule() {
                        return client.set("/nodes/" + this.node + "/qemu/" + this.vmid + "/firewall/rules/"
                                + this.pos, null);
                    }

                }

                /**
                 * List rules.
                 *
                 * @return Result
                 */

                public Result getRules() {
                    return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/firewall/rules",
                            null);
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
                    return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/firewall/rules",
                            parameters);
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
                    return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/firewall/rules",
                            parameters);
                }

            }

            public static class PVEAliases {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVEAliases(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                public PVEVmidItem.PVEFirewall.PVEAliases.PVENameItem get(Object name) {
                    return new PVENameItem(client, this.node, this.vmid, name);
                }

                public static class PVENameItem {

                    private final PveClient client;
                    private final Object node;
                    private final Object vmid;
                    private final Object name;

                    protected PVENameItem(PveClient client, Object node, Object vmid, Object name) {
                        this.client = client;
                        this.node = node;
                        this.vmid = vmid;
                        this.name = name;
                    }

                    /**
                     * Remove IP or Network alias.
                     *
                     * @param digest Prevent changes if current configuration file has a different
                     *               digest. This can be used to prevent concurrent modifications.
                     * @return Result
                     */

                    public Result removeAlias(String digest) {
                        Map<String, Object> parameters = new HashMap<>();
                        parameters.put("digest", digest);
                        return client.delete("/nodes/" + this.node + "/qemu/" + this.vmid
                                + "/firewall/aliases/" + this.name, parameters);
                    }

                    /**
                     * Remove IP or Network alias.
                     *
                     * @return Result
                     */

                    public Result removeAlias() {
                        return client.delete("/nodes/" + this.node + "/qemu/" + this.vmid
                                + "/firewall/aliases/" + this.name, null);
                    }

                    /**
                     * Read alias.
                     *
                     * @return Result
                     */

                    public Result readAlias() {
                        return client.get("/nodes/" + this.node + "/qemu/" + this.vmid
                                + "/firewall/aliases/" + this.name, null);
                    }

                    /**
                     * Update IP or Network alias.
                     *
                     * @param cidr    Network/IP specification in CIDR format.
                     * @param comment
                     * @param digest  Prevent changes if current configuration file has a different
                     *                digest. This can be used to prevent concurrent modifications.
                     * @param rename  Rename an existing alias.
                     * @return Result
                     */

                    public Result updateAlias(String cidr, String comment, String digest, String rename) {
                        Map<String, Object> parameters = new HashMap<>();
                        parameters.put("cidr", cidr);
                        parameters.put("comment", comment);
                        parameters.put("digest", digest);
                        parameters.put("rename", rename);
                        return client.set("/nodes/" + this.node + "/qemu/" + this.vmid
                                + "/firewall/aliases/" + this.name, parameters);
                    }

                    /**
                     * Update IP or Network alias.
                     *
                     * @param cidr Network/IP specification in CIDR format.
                     * @return Result
                     */

                    public Result updateAlias(String cidr) {
                        Map<String, Object> parameters = new HashMap<>();
                        parameters.put("cidr", cidr);
                        return client.set("/nodes/" + this.node + "/qemu/" + this.vmid
                                + "/firewall/aliases/" + this.name, parameters);
                    }

                }

                /**
                 * List aliases
                 *
                 * @return Result
                 */

                public Result getAliases() {
                    return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/firewall/aliases",
                            null);
                }

                /**
                 * Create IP or Network Alias.
                 *
                 * @param cidr    Network/IP specification in CIDR format.
                 * @param name    Alias name.
                 * @param comment
                 * @return Result
                 */

                public Result createAlias(String cidr, String name, String comment) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("cidr", cidr);
                    parameters.put("name", name);
                    parameters.put("comment", comment);
                    return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/firewall/aliases",
                            parameters);
                }

                /**
                 * Create IP or Network Alias.
                 *
                 * @param cidr Network/IP specification in CIDR format.
                 * @param name Alias name.
                 * @return Result
                 */

                public Result createAlias(String cidr, String name) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("cidr", cidr);
                    parameters.put("name", name);
                    return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/firewall/aliases",
                            parameters);
                }

            }

            public static class PVEIpset {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVEIpset(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                public PVEVmidItem.PVEFirewall.PVEIpset.PVENameItem get(Object name) {
                    return new PVENameItem(client, this.node, this.vmid, name);
                }

                public static class PVENameItem {

                    private final PveClient client;
                    private final Object node;
                    private final Object vmid;
                    private final Object name;

                    protected PVENameItem(PveClient client, Object node, Object vmid, Object name) {
                        this.client = client;
                        this.node = node;
                        this.vmid = vmid;
                        this.name = name;
                    }

                    public PVEVmidItem.PVEFirewall.PVEIpset.PVENameItem.PVECidrItem get(Object cidr) {
                        return new PVECidrItem(client, this.node, this.vmid, this.name, cidr);
                    }

                    public static class PVECidrItem {

                        private final PveClient client;
                        private final Object node;
                        private final Object vmid;
                        private final Object name;
                        private final Object cidr;

                        protected PVECidrItem(PveClient client, Object node, Object vmid, Object name,
                                              Object cidr) {
                            this.client = client;
                            this.node = node;
                            this.vmid = vmid;
                            this.name = name;
                            this.cidr = cidr;
                        }

                        /**
                         * Remove IP or Network from IPSet.
                         *
                         * @param digest Prevent changes if current configuration file has a different
                         *               digest. This can be used to prevent concurrent modifications.
                         * @return Result
                         */

                        public Result removeIp(String digest) {
                            Map<String, Object> parameters = new HashMap<>();
                            parameters.put("digest", digest);
                            return client.delete("/nodes/" + this.node + "/qemu/" + this.vmid
                                    + "/firewall/ipset/" + this.name + "/" + this.cidr, parameters);
                        }

                        /**
                         * Remove IP or Network from IPSet.
                         *
                         * @return Result
                         */

                        public Result removeIp() {
                            return client.delete("/nodes/" + this.node + "/qemu/" + this.vmid
                                    + "/firewall/ipset/" + this.name + "/" + this.cidr, null);
                        }

                        /**
                         * Read IP or Network settings from IPSet.
                         *
                         * @return Result
                         */

                        public Result readIp() {
                            return client.get("/nodes/" + this.node + "/qemu/" + this.vmid
                                    + "/firewall/ipset/" + this.name + "/" + this.cidr, null);
                        }

                        /**
                         * Update IP or Network settings
                         *
                         * @param comment
                         * @param digest  Prevent changes if current configuration file has a different
                         *                digest. This can be used to prevent concurrent modifications.
                         * @param nomatch
                         * @return Result
                         */

                        public Result updateIp(String comment, String digest, Boolean nomatch) {
                            Map<String, Object> parameters = new HashMap<>();
                            parameters.put("comment", comment);
                            parameters.put("digest", digest);
                            parameters.put("nomatch", nomatch);
                            return client.set("/nodes/" + this.node + "/qemu/" + this.vmid
                                    + "/firewall/ipset/" + this.name + "/" + this.cidr, parameters);
                        }

                        /**
                         * Update IP or Network settings
                         *
                         * @return Result
                         */

                        public Result updateIp() {
                            return client.set("/nodes/" + this.node + "/qemu/" + this.vmid
                                    + "/firewall/ipset/" + this.name + "/" + this.cidr, null);
                        }

                    }

                    /**
                     * Delete IPSet
                     *
                     * @param force Delete all members of the IPSet, if there are any.
                     * @return Result
                     */

                    public Result deleteIpset(Boolean force) {
                        Map<String, Object> parameters = new HashMap<>();
                        parameters.put("force", force);
                        return client.delete("/nodes/" + this.node + "/qemu/" + this.vmid
                                + "/firewall/ipset/" + this.name, parameters);
                    }

                    /**
                     * Delete IPSet
                     *
                     * @return Result
                     */

                    public Result deleteIpset() {
                        return client.delete("/nodes/" + this.node + "/qemu/" + this.vmid
                                + "/firewall/ipset/" + this.name, null);
                    }

                    /**
                     * List IPSet content
                     *
                     * @return Result
                     */

                    public Result getIpset() {
                        return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/firewall/ipset/"
                                + this.name, null);
                    }

                    /**
                     * Add IP or Network to IPSet.
                     *
                     * @param cidr    Network/IP specification in CIDR format.
                     * @param comment
                     * @param nomatch
                     * @return Result
                     */

                    public Result createIp(String cidr, String comment, Boolean nomatch) {
                        Map<String, Object> parameters = new HashMap<>();
                        parameters.put("cidr", cidr);
                        parameters.put("comment", comment);
                        parameters.put("nomatch", nomatch);
                        return client.create("/nodes/" + this.node + "/qemu/" + this.vmid
                                + "/firewall/ipset/" + this.name, parameters);
                    }

                    /**
                     * Add IP or Network to IPSet.
                     *
                     * @param cidr Network/IP specification in CIDR format.
                     * @return Result
                     */

                    public Result createIp(String cidr) {
                        Map<String, Object> parameters = new HashMap<>();
                        parameters.put("cidr", cidr);
                        return client.create("/nodes/" + this.node + "/qemu/" + this.vmid
                                + "/firewall/ipset/" + this.name, parameters);
                    }

                }

                /**
                 * List IPSets
                 *
                 * @return Result
                 */

                public Result ipsetIndex() {
                    return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/firewall/ipset",
                            null);
                }

                /**
                 * Create new IPSet
                 *
                 * @param name    IP set name.
                 * @param comment
                 * @param digest  Prevent changes if current configuration file has a different
                 *                digest. This can be used to prevent concurrent modifications.
                 * @param rename  Rename an existing IPSet. You can set 'rename' to the same
                 *                value as 'name' to update the 'comment' of an existing IPSet.
                 * @return Result
                 */

                public Result createIpset(String name, String comment, String digest, String rename) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("name", name);
                    parameters.put("comment", comment);
                    parameters.put("digest", digest);
                    parameters.put("rename", rename);
                    return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/firewall/ipset",
                            parameters);
                }

                /**
                 * Create new IPSet
                 *
                 * @param name IP set name.
                 * @return Result
                 */

                public Result createIpset(String name) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("name", name);
                    return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/firewall/ipset",
                            parameters);
                }

            }

            public static class PVEOptions {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVEOptions(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Get VM firewall options.
                 *
                 * @return Result
                 */

                public Result getOptions() {
                    return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/firewall/options",
                            null);
                }

                /**
                 * Set Firewall options.
                 *
                 * @param delete        A list of settings you want to delete.
                 * @param dhcp          Enable DHCP.
                 * @param digest        Prevent changes if current configuration file has a
                 *                      different digest. This can be used to prevent concurrent
                 *                      modifications.
                 * @param enable        Enable/disable firewall rules.
                 * @param ipfilter      Enable default IP filters. This is equivalent to adding
                 *                      an empty ipfilter-net&amp;lt;id&amp;gt; ipset for every
                 *                      interface. Such ipsets implicitly contain sane default
                 *                      restrictions such as restricting IPv6 link local
                 *                      addresses to the one derived from the interface's MAC
                 *                      address. For containers the configured IP addresses will
                 *                      be implicitly added.
                 * @param log_level_in  Log level for incoming traffic.
                 *                      Enum:
                 *                      emerg,alert,crit,err,warning,notice,info,debug,nolog
                 * @param log_level_out Log level for outgoing traffic.
                 *                      Enum:
                 *                      emerg,alert,crit,err,warning,notice,info,debug,nolog
                 * @param macfilter     Enable/disable MAC address filter.
                 * @param ndp           Enable NDP (Neighbor Discovery Protocol).
                 * @param policy_in     Input policy.
                 *                      Enum: ACCEPT,REJECT,DROP
                 * @param policy_out    Output policy.
                 *                      Enum: ACCEPT,REJECT,DROP
                 * @param radv          Allow sending Router Advertisement.
                 * @return Result
                 */

                public Result setOptions(String delete, Boolean dhcp, String digest, Boolean enable,
                                         Boolean ipfilter, String log_level_in, String log_level_out, Boolean macfilter,
                                         Boolean ndp, String policy_in, String policy_out, Boolean radv) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("delete", delete);
                    parameters.put("dhcp", dhcp);
                    parameters.put("digest", digest);
                    parameters.put("enable", enable);
                    parameters.put("ipfilter", ipfilter);
                    parameters.put("log_level_in", log_level_in);
                    parameters.put("log_level_out", log_level_out);
                    parameters.put("macfilter", macfilter);
                    parameters.put("ndp", ndp);
                    parameters.put("policy_in", policy_in);
                    parameters.put("policy_out", policy_out);
                    parameters.put("radv", radv);
                    return client.set("/nodes/" + this.node + "/qemu/" + this.vmid + "/firewall/options",
                            parameters);
                }

                /**
                 * Set Firewall options.
                 *
                 * @return Result
                 */

                public Result setOptions() {
                    return client.set("/nodes/" + this.node + "/qemu/" + this.vmid + "/firewall/options",
                            null);
                }

            }

            public static class PVELog {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVELog(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Read firewall log
                 *
                 * @param limit
                 * @param since Display log since this UNIX epoch.
                 * @param start
                 * @param until Display log until this UNIX epoch.
                 * @return Result
                 */

                public Result log(Integer limit, Integer since, Integer start, Integer until) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("limit", limit);
                    parameters.put("since", since);
                    parameters.put("start", start);
                    parameters.put("until", until);
                    return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/firewall/log",
                            parameters);
                }

                /**
                 * Read firewall log
                 *
                 * @return Result
                 */

                public Result log() {
                    return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/firewall/log", null);
                }

            }

            public static class PVERefs {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVERefs(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Lists possible IPSet/Alias reference which are allowed in source/dest
                 * properties.
                 *
                 * @param type Only list references of specified type.
                 *             Enum: alias,ipset
                 * @return Result
                 */

                public Result refs(String type) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("type", type);
                    return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/firewall/refs",
                            parameters);
                }

                /**
                 * Lists possible IPSet/Alias reference which are allowed in source/dest
                 * properties.
                 *
                 * @return Result
                 */

                public Result refs() {
                    return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/firewall/refs",
                            null);
                }

            }

            /**
             * Directory index.
             *
             * @return Result
             */

            public Result index() {
                return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/firewall", null);
            }

        }

        public static class PVEAgent {

            private final PveClient client;
            private final Object node;
            private final Object vmid;

            protected PVEAgent(PveClient client, Object node, Object vmid) {
                this.client = client;
                this.node = node;
                this.vmid = vmid;
            }

            private PVEVmidItem.PVEAgent.PVEFsfreezeFreeze fsfreezeFreeze;

            public PVEVmidItem.PVEAgent.PVEFsfreezeFreeze getFsfreezeFreeze() {
                return fsfreezeFreeze == null
                        ? (fsfreezeFreeze = new PVEFsfreezeFreeze(client, this.node, this.vmid))
                        : fsfreezeFreeze;
            }

            private PVEVmidItem.PVEAgent.PVEFsfreezeStatus fsfreezeStatus;

            public PVEVmidItem.PVEAgent.PVEFsfreezeStatus getFsfreezeStatus() {
                return fsfreezeStatus == null
                        ? (fsfreezeStatus = new PVEFsfreezeStatus(client, this.node, this.vmid))
                        : fsfreezeStatus;
            }

            private PVEVmidItem.PVEAgent.PVEFsfreezeThaw fsfreezeThaw;

            public PVEVmidItem.PVEAgent.PVEFsfreezeThaw getFsfreezeThaw() {
                return fsfreezeThaw == null
                        ? (fsfreezeThaw = new PVEFsfreezeThaw(client, this.node, this.vmid))
                        : fsfreezeThaw;
            }

            private PVEVmidItem.PVEAgent.PVEFstrim fstrim;

            public PVEVmidItem.PVEAgent.PVEFstrim getFstrim() {
                return fstrim == null ? (fstrim = new PVEFstrim(client, this.node, this.vmid)) : fstrim;
            }

            private PVEVmidItem.PVEAgent.PVEGetFsinfo getFsinfo;

            public PVEVmidItem.PVEAgent.PVEGetFsinfo getGetFsinfo() {
                return getFsinfo == null ? (getFsinfo = new PVEGetFsinfo(client, this.node, this.vmid))
                        : getFsinfo;
            }

            private PVEVmidItem.PVEAgent.PVEGetHostName getHostName;

            public PVEVmidItem.PVEAgent.PVEGetHostName getGetHostName() {
                return getHostName == null
                        ? (getHostName = new PVEGetHostName(client, this.node, this.vmid))
                        : getHostName;
            }

            private PVEVmidItem.PVEAgent.PVEGetMemoryBlockInfo getMemoryBlockInfo;

            public PVEVmidItem.PVEAgent.PVEGetMemoryBlockInfo getGetMemoryBlockInfo() {
                return getMemoryBlockInfo == null
                        ? (getMemoryBlockInfo = new PVEGetMemoryBlockInfo(client, this.node, this.vmid))
                        : getMemoryBlockInfo;
            }

            private PVEVmidItem.PVEAgent.PVEGetMemoryBlocks getMemoryBlocks;

            public PVEVmidItem.PVEAgent.PVEGetMemoryBlocks getGetMemoryBlocks() {
                return getMemoryBlocks == null
                        ? (getMemoryBlocks = new PVEGetMemoryBlocks(client, this.node, this.vmid))
                        : getMemoryBlocks;
            }

            private PVEVmidItem.PVEAgent.PVEGetOsinfo getOsinfo;

            public PVEVmidItem.PVEAgent.PVEGetOsinfo getGetOsinfo() {
                return getOsinfo == null ? (getOsinfo = new PVEGetOsinfo(client, this.node, this.vmid))
                        : getOsinfo;
            }

            private PVEVmidItem.PVEAgent.PVEGetTime getTime;

            public PVEVmidItem.PVEAgent.PVEGetTime getGetTime() {
                return getTime == null ? (getTime = new PVEGetTime(client, this.node, this.vmid)) : getTime;
            }

            private PVEVmidItem.PVEAgent.PVEGetTimezone getTimezone;

            public PVEVmidItem.PVEAgent.PVEGetTimezone getGetTimezone() {
                return getTimezone == null
                        ? (getTimezone = new PVEGetTimezone(client, this.node, this.vmid))
                        : getTimezone;
            }

            private PVEVmidItem.PVEAgent.PVEGetUsers getUsers;

            public PVEVmidItem.PVEAgent.PVEGetUsers getGetUsers() {
                return getUsers == null ? (getUsers = new PVEGetUsers(client, this.node, this.vmid))
                        : getUsers;
            }

            private PVEVmidItem.PVEAgent.PVEGetVcpus getVcpus;

            public PVEVmidItem.PVEAgent.PVEGetVcpus getGetVcpus() {
                return getVcpus == null ? (getVcpus = new PVEGetVcpus(client, this.node, this.vmid))
                        : getVcpus;
            }

            private PVEVmidItem.PVEAgent.PVEInfo info;

            public PVEVmidItem.PVEAgent.PVEInfo getInfo() {
                return info == null ? (info = new PVEInfo(client, this.node, this.vmid)) : info;
            }

            private PVEVmidItem.PVEAgent.PVENetworkGetInterfaces networkGetInterfaces;

            public PVEVmidItem.PVEAgent.PVENetworkGetInterfaces getNetworkGetInterfaces() {
                return networkGetInterfaces == null
                        ? (networkGetInterfaces = new PVENetworkGetInterfaces(client, this.node, this.vmid))
                        : networkGetInterfaces;
            }

            private PVEVmidItem.PVEAgent.PVEPing ping;

            public PVEVmidItem.PVEAgent.PVEPing getPing() {
                return ping == null ? (ping = new PVEPing(client, this.node, this.vmid)) : ping;
            }

            private PVEVmidItem.PVEAgent.PVEShutdown shutdown;

            public PVEVmidItem.PVEAgent.PVEShutdown getShutdown() {
                return shutdown == null ? (shutdown = new PVEShutdown(client, this.node, this.vmid))
                        : shutdown;
            }

            private PVEVmidItem.PVEAgent.PVESuspendDisk suspendDisk;

            public PVEVmidItem.PVEAgent.PVESuspendDisk getSuspendDisk() {
                return suspendDisk == null
                        ? (suspendDisk = new PVESuspendDisk(client, this.node, this.vmid))
                        : suspendDisk;
            }

            private PVEVmidItem.PVEAgent.PVESuspendHybrid suspendHybrid;

            public PVEVmidItem.PVEAgent.PVESuspendHybrid getSuspendHybrid() {
                return suspendHybrid == null
                        ? (suspendHybrid = new PVESuspendHybrid(client, this.node, this.vmid))
                        : suspendHybrid;
            }

            private PVEVmidItem.PVEAgent.PVESuspendRam suspendRam;

            public PVEVmidItem.PVEAgent.PVESuspendRam getSuspendRam() {
                return suspendRam == null ? (suspendRam = new PVESuspendRam(client, this.node, this.vmid))
                        : suspendRam;
            }

            private PVEVmidItem.PVEAgent.PVESetUserPassword setUserPassword;

            public PVEVmidItem.PVEAgent.PVESetUserPassword getSetUserPassword() {
                return setUserPassword == null
                        ? (setUserPassword = new PVESetUserPassword(client, this.node, this.vmid))
                        : setUserPassword;
            }

            private PVEVmidItem.PVEAgent.PVEExec exec;

            public PVEVmidItem.PVEAgent.PVEExec getExec() {
                return exec == null ? (exec = new PVEExec(client, this.node, this.vmid)) : exec;
            }

            private PVEVmidItem.PVEAgent.PVEExecStatus execStatus;

            public PVEVmidItem.PVEAgent.PVEExecStatus getExecStatus() {
                return execStatus == null ? (execStatus = new PVEExecStatus(client, this.node, this.vmid))
                        : execStatus;
            }

            private PVEVmidItem.PVEAgent.PVEFileRead fileRead;

            public PVEVmidItem.PVEAgent.PVEFileRead getFileRead() {
                return fileRead == null ? (fileRead = new PVEFileRead(client, this.node, this.vmid))
                        : fileRead;
            }

            private PVEVmidItem.PVEAgent.PVEFileWrite fileWrite;

            public PVEVmidItem.PVEAgent.PVEFileWrite getFileWrite() {
                return fileWrite == null ? (fileWrite = new PVEFileWrite(client, this.node, this.vmid))
                        : fileWrite;
            }

            public static class PVEFsfreezeFreeze {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVEFsfreezeFreeze(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Execute fsfreeze-freeze.
                 *
                 * @return Result
                 */

                public Result fsfreezeFreeze() {
                    return client.create(
                            "/nodes/" + this.node + "/qemu/" + this.vmid + "/agent/fsfreeze-freeze", null);
                }

            }

            public static class PVEFsfreezeStatus {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVEFsfreezeStatus(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Execute fsfreeze-status.
                 *
                 * @return Result
                 */

                public Result fsfreezeStatus() {
                    return client.create(
                            "/nodes/" + this.node + "/qemu/" + this.vmid + "/agent/fsfreeze-status", null);
                }

            }

            public static class PVEFsfreezeThaw {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVEFsfreezeThaw(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Execute fsfreeze-thaw.
                 *
                 * @return Result
                 */

                public Result fsfreezeThaw() {
                    return client.create(
                            "/nodes/" + this.node + "/qemu/" + this.vmid + "/agent/fsfreeze-thaw", null);
                }

            }

            public static class PVEFstrim {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVEFstrim(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Execute fstrim.
                 *
                 * @return Result
                 */

                public Result fstrim() {
                    return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/agent/fstrim",
                            null);
                }

            }

            public static class PVEGetFsinfo {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVEGetFsinfo(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Execute get-fsinfo.
                 *
                 * @return Result
                 */

                public Result getFsinfo() {
                    return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/agent/get-fsinfo",
                            null);
                }

            }

            public static class PVEGetHostName {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVEGetHostName(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Execute get-host-name.
                 *
                 * @return Result
                 */

                public Result getHostName() {
                    return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/agent/get-host-name",
                            null);
                }

            }

            public static class PVEGetMemoryBlockInfo {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVEGetMemoryBlockInfo(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Execute get-memory-block-info.
                 *
                 * @return Result
                 */

                public Result getMemoryBlockInfo() {
                    return client.get(
                            "/nodes/" + this.node + "/qemu/" + this.vmid + "/agent/get-memory-block-info",
                            null);
                }

            }

            public static class PVEGetMemoryBlocks {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVEGetMemoryBlocks(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Execute get-memory-blocks.
                 *
                 * @return Result
                 */

                public Result getMemoryBlocks() {
                    return client.get(
                            "/nodes/" + this.node + "/qemu/" + this.vmid + "/agent/get-memory-blocks",
                            null);
                }

            }

            public static class PVEGetOsinfo {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVEGetOsinfo(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Execute get-osinfo.
                 *
                 * @return Result
                 */

                public Result getOsinfo() {
                    return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/agent/get-osinfo",
                            null);
                }

            }

            public static class PVEGetTime {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVEGetTime(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Execute get-time.
                 *
                 * @return Result
                 */

                public Result getTime() {
                    return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/agent/get-time",
                            null);
                }

            }

            public static class PVEGetTimezone {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVEGetTimezone(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Execute get-timezone.
                 *
                 * @return Result
                 */

                public Result getTimezone() {
                    return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/agent/get-timezone",
                            null);
                }

            }

            public static class PVEGetUsers {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVEGetUsers(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Execute get-users.
                 *
                 * @return Result
                 */

                public Result getUsers() {
                    return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/agent/get-users",
                            null);
                }

            }

            public static class PVEGetVcpus {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVEGetVcpus(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Execute get-vcpus.
                 *
                 * @return Result
                 */

                public Result getVcpus() {
                    return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/agent/get-vcpus",
                            null);
                }

            }

            public static class PVEInfo {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVEInfo(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Execute info.
                 *
                 * @return Result
                 */

                public Result info() {
                    return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/agent/info", null);
                }

            }

            public static class PVENetworkGetInterfaces {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVENetworkGetInterfaces(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Execute network-get-interfaces.
                 *
                 * @return Result
                 */

                public Result networkGetInterfaces() {
                    return client.get(
                            "/nodes/" + this.node + "/qemu/" + this.vmid + "/agent/network-get-interfaces",
                            null);
                }

            }

            public static class PVEPing {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVEPing(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Execute ping.
                 *
                 * @return Result
                 */

                public Result ping() {
                    return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/agent/ping",
                            null);
                }

            }

            public static class PVEShutdown {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVEShutdown(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Execute shutdown.
                 *
                 * @return Result
                 */

                public Result shutdown() {
                    return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/agent/shutdown",
                            null);
                }

            }

            public static class PVESuspendDisk {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVESuspendDisk(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Execute suspend-disk.
                 *
                 * @return Result
                 */

                public Result suspendDisk() {
                    return client.create(
                            "/nodes/" + this.node + "/qemu/" + this.vmid + "/agent/suspend-disk", null);
                }

            }

            public static class PVESuspendHybrid {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVESuspendHybrid(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Execute suspend-hybrid.
                 *
                 * @return Result
                 */

                public Result suspendHybrid() {
                    return client.create(
                            "/nodes/" + this.node + "/qemu/" + this.vmid + "/agent/suspend-hybrid", null);
                }

            }

            public static class PVESuspendRam {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVESuspendRam(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Execute suspend-ram.
                 *
                 * @return Result
                 */

                public Result suspendRam() {
                    return client.create(
                            "/nodes/" + this.node + "/qemu/" + this.vmid + "/agent/suspend-ram", null);
                }

            }

            public static class PVESetUserPassword {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVESetUserPassword(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Sets the password for the given user to the given password
                 *
                 * @param password The new password.
                 * @param username The user to set the password for.
                 * @param crypted  set to 1 if the password has already been passed through
                 *                 crypt()
                 * @return Result
                 */

                public Result setUserPassword(String password, String username, Boolean crypted) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("password", password);
                    parameters.put("username", username);
                    parameters.put("crypted", crypted);
                    return client.create(
                            "/nodes/" + this.node + "/qemu/" + this.vmid + "/agent/set-user-password",
                            parameters);
                }

                /**
                 * Sets the password for the given user to the given password
                 *
                 * @param password The new password.
                 * @param username The user to set the password for.
                 * @return Result
                 */

                public Result setUserPassword(String password, String username) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("password", password);
                    parameters.put("username", username);
                    return client.create(
                            "/nodes/" + this.node + "/qemu/" + this.vmid + "/agent/set-user-password",
                            parameters);
                }

            }

            public static class PVEExec {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVEExec(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Executes the given command in the vm via the guest-agent and returns an
                 * object with the pid.
                 *
                 * @param command    The command as a list of program + arguments.
                 * @param input_data Data to pass as 'input-data' to the guest. Usually treated
                 *                   as STDIN to 'command'.
                 * @return Result
                 */

                public Result exec(List<Object> command, String input_data) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("command", command);
                    parameters.put("input-data", input_data);
                    return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/agent/exec",
                            parameters);
                }

                /**
                 * Executes the given command in the vm via the guest-agent and returns an
                 * object with the pid.
                 *
                 * @param command The command as a list of program + arguments.
                 * @return Result
                 */

                public Result exec(List<Object> command) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("command", command);
                    return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/agent/exec",
                            parameters);
                }

            }

            public static class PVEExecStatus {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVEExecStatus(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Gets the status of the given pid started by the guest-agent
                 *
                 * @param pid The PID to query
                 * @return Result
                 */

                public Result execStatus(int pid) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("pid", pid);
                    return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/agent/exec-status",
                            parameters);
                }

            }

            public static class PVEFileRead {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVEFileRead(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Reads the given file via guest agent. Is limited to 16777216 bytes.
                 *
                 * @param file The path to the file
                 * @return Result
                 */

                public Result fileRead(String file) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("file", file);
                    return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/agent/file-read",
                            parameters);
                }

            }

            public static class PVEFileWrite {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVEFileWrite(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Writes the given file via guest agent.
                 *
                 * @param content The content to write into the file.
                 * @param file    The path to the file.
                 * @param encode  If set, the content will be encoded as base64 (required by
                 *                QEMU).Otherwise, the content needs to be encoded beforehand -
                 *                defaults to true.
                 * @return Result
                 */

                public Result fileWrite(String content, String file, Boolean encode) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("content", content);
                    parameters.put("file", file);
                    parameters.put("encode", encode);
                    return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/agent/file-write",
                            parameters);
                }

                /**
                 * Writes the given file via guest agent.
                 *
                 * @param content The content to write into the file.
                 * @param file    The path to the file.
                 * @return Result
                 */

                public Result fileWrite(String content, String file) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("content", content);
                    parameters.put("file", file);
                    return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/agent/file-write",
                            parameters);
                }

            }

            /**
             * QEMU Guest Agent command index.
             *
             * @return Result
             */

            public Result index() {
                return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/agent", null);
            }

            /**
             * Execute QEMU Guest Agent commands.
             *
             * @param command The QGA command.
             *                Enum:
             *                fsfreeze-freeze,fsfreeze-status,fsfreeze-thaw,fstrim,get-fsinfo,get-host-name,get-memory-block-info,get-memory-blocks,get-osinfo,get-time,get-timezone,get-users,get-vcpus,info,network-get-interfaces,ping,shutdown,suspend-disk,suspend-hybrid,suspend-ram
             * @return Result
             */

            public Result agent(String command) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("command", command);
                return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/agent", parameters);
            }

        }

        public static class PVERrd {

            private final PveClient client;
            private final Object node;
            private final Object vmid;

            protected PVERrd(PveClient client, Object node, Object vmid) {
                this.client = client;
                this.node = node;
                this.vmid = vmid;
            }

            /**
             * Read VM RRD statistics (returns PNG)
             *
             * @param ds        The list of datasources you want to display.
             * @param timeframe Specify the time frame you are interested in.
             *                  Enum: hour,day,week,month,year
             * @param cf        The RRD consolidation function
             *                  Enum: AVERAGE,MAX
             * @return Result
             */

            public Result rrd(String ds, String timeframe, String cf) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("ds", ds);
                parameters.put("timeframe", timeframe);
                parameters.put("cf", cf);
                return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/rrd", parameters);
            }

            /**
             * Read VM RRD statistics (returns PNG)
             *
             * @param ds        The list of datasources you want to display.
             * @param timeframe Specify the time frame you are interested in.
             *                  Enum: hour,day,week,month,year
             * @return Result
             */

            public Result rrd(String ds, String timeframe) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("ds", ds);
                parameters.put("timeframe", timeframe);
                return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/rrd", parameters);
            }

        }

        public static class PVERrddata {

            private final PveClient client;
            private final Object node;
            private final Object vmid;

            protected PVERrddata(PveClient client, Object node, Object vmid) {
                this.client = client;
                this.node = node;
                this.vmid = vmid;
            }

            /**
             * Read VM RRD statistics
             *
             * @param timeframe Specify the time frame you are interested in.
             *                  Enum: hour,day,week,month,year
             * @param cf        The RRD consolidation function
             *                  Enum: AVERAGE,MAX
             * @return Result
             */

            public Result rrddata(String timeframe, String cf) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("timeframe", timeframe);
                parameters.put("cf", cf);
                return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/rrddata", parameters);
            }

            /**
             * Read VM RRD statistics
             *
             * @param timeframe Specify the time frame you are interested in.
             *                  Enum: hour,day,week,month,year
             * @return Result
             */

            public Result rrddata(String timeframe) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("timeframe", timeframe);
                return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/rrddata", parameters);
            }

        }

        public static class PVEConfig {

            private final PveClient client;
            private final Object node;
            private final Object vmid;

            protected PVEConfig(PveClient client, Object node, Object vmid) {
                this.client = client;
                this.node = node;
                this.vmid = vmid;
            }

            /**
             * Get the virtual machine configuration with pending configuration changes
             * applied. Set the 'current' parameter to get the current configuration
             * instead.
             *
             * @param current  Get current values (instead of pending values).
             * @param snapshot Fetch config values from given snapshot.
             * @return Result
             */

            public Result vmConfig(Boolean current, String snapshot) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("current", current);
                parameters.put("snapshot", snapshot);
                return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/config", parameters);
            }

            /**
             * Get the virtual machine configuration with pending configuration changes
             * applied. Set the 'current' parameter to get the current configuration
             * instead.
             *
             * @return Result
             */

            public Result vmConfig() {
                return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/config", null);
            }

            /**
             * Set virtual machine options (asynchronous API).
             *
             * @param acpi                   Enable/disable ACPI.
             * @param affinity               List of host cores used to execute guest
             *                               processes, for example: 0,5,8-11
             * @param agent                  Enable/disable communication with the QEMU
             *                               Guest Agent and its properties.
             * @param allow_ksm              Allow memory pages of this guest to be merged
             *                               via KSM (Kernel Samepage Merging).
             * @param amd_sev                Secure Encrypted Virtualization (SEV) features
             *                               by AMD CPUs
             * @param arch                   Virtual processor architecture. Defaults to the
             *                               host.
             *                               Enum: x86_64,aarch64
             * @param args                   Arbitrary arguments passed to kvm.
             * @param audio0                 Configure an audio device, useful in combination
             *                               with QXL/Spice.
             * @param autostart              Automatic restart after crash (currently
             *                               ignored).
             * @param background_delay       Time to wait for the task to finish. We return
             *                               'null' if the task finish within that time.
             * @param balloon                Amount of target RAM for the VM in MiB. Using
             *                               zero disables the ballon driver.
             * @param bios                   Select BIOS implementation.
             *                               Enum: seabios,ovmf
             * @param boot                   Specify guest boot order. Use the 'order='
             *                               sub-property as usage with no key or 'legacy='
             *                               is deprecated.
             * @param bootdisk               Enable booting from specified disk. Deprecated:
             *                               Use 'boot: order=foo;bar' instead.
             * @param cdrom                  This is an alias for option -ide2
             * @param cicustom               cloud-init: Specify custom files to replace the
             *                               automatically generated ones at start.
             * @param cipassword             cloud-init: Password to assign the user. Using
             *                               this is generally not recommended. Use ssh keys
             *                               instead. Also note that older cloud-init
             *                               versions do not support hashed passwords.
             * @param citype                 Specifies the cloud-init configuration format.
             *                               The default depends on the configured operating
             *                               system type (`ostype`). We use the `nocloud`
             *                               format for Linux, and `configdrive2` for
             *                               windows.
             *                               Enum: configdrive2,nocloud,opennebula
             * @param ciupgrade              cloud-init: do an automatic package upgrade
             *                               after the first boot.
             * @param ciuser                 cloud-init: Username to change ssh keys and
             *                               password for instead of the image's configured
             *                               default user.
             * @param cores                  The number of cores per socket.
             * @param cpu                    Emulated CPU type.
             * @param cpulimit               Limit of CPU usage.
             * @param cpuunits               CPU weight for a VM, will be clamped to [1,
             *                               10000] in cgroup v2.
             * @param delete                 A list of settings you want to delete.
             * @param description            Description for the VM. Shown in the
             *                               web-interface VM's summary. This is saved as
             *                               comment inside the configuration file.
             * @param digest                 Prevent changes if current configuration file
             *                               has different SHA1 digest. This can be used to
             *                               prevent concurrent modifications.
             * @param efidisk0               Configure a disk for storing EFI vars. Use the
             *                               special syntax STORAGE_ID:SIZE_IN_GiB to
             *                               allocate a new volume. Note that SIZE_IN_GiB is
             *                               ignored here and that the default EFI vars are
             *                               copied to the volume instead. Use STORAGE_ID:0
             *                               and the 'import-from' parameter to import from
             *                               an existing volume.
             * @param force                  Force physical removal. Without this, we simply
             *                               remove the disk from the config file and create
             *                               an additional configuration entry called
             *                               'unused[n]', which contains the volume ID.
             *                               Unlink of unused[n] always cause physical
             *                               removal.
             * @param freeze                 Freeze CPU at startup (use 'c' monitor command
             *                               to start execution).
             * @param hookscript             Script that will be executed during various
             *                               steps in the vms lifetime.
             * @param hostpciN               Map host PCI devices into guest.
             * @param hotplug                Selectively enable hotplug features. This is a
             *                               comma separated list of hotplug features:
             *                               'network', 'disk', 'cpu', 'memory', 'usb' and
             *                               'cloudinit'. Use '0' to disable hotplug
             *                               completely. Using '1' as value is an alias for
             *                               the default `network,disk,usb`. USB hotplugging
             *                               is possible for guests with machine version
             *                               &amp;gt;= 7.1 and ostype l26 or windows
             *                               &amp;gt; 7.
             * @param hugepages              Enables hugepages memory. Sets the size of
             *                               hugepages in MiB. If the value is set to 'any'
             *                               then 1 GiB hugepages will be used if possible,
             *                               otherwise the size will fall back to 2 MiB.
             *                               Enum: any,2,1024
             * @param ideN                   Use volume as IDE hard disk or CD-ROM (n is 0
             *                               to 3). Use the special syntax
             *                               STORAGE_ID:SIZE_IN_GiB to allocate a new
             *                               volume. Use STORAGE_ID:0 and the 'import-from'
             *                               parameter to import from an existing volume.
             * @param import_working_storage A file-based storage with 'images' content-type
             *                               enabled, which is used as an intermediary
             *                               extraction storage during import. Defaults to
             *                               the source storage.
             * @param intel_tdx              Trusted Domain Extension (TDX) features by
             *                               Intel CPUs
             * @param ipconfigN              cloud-init: Specify IP addresses and gateways
             *                               for the corresponding interface. IP addresses
             *                               use CIDR notation, gateways are optional but
             *                               need an IP of the same type specified. The
             *                               special string 'dhcp' can be used for IP
             *                               addresses to use DHCP, in which case no
             *                               explicit gateway should be provided. For IPv6
             *                               the special string 'auto' can be used to use
             *                               stateless autoconfiguration. This requires
             *                               cloud-init 19.4 or newer. If cloud-init is
             *                               enabled and neither an IPv4 nor an IPv6 address
             *                               is specified, it defaults to using dhcp on
             *                               IPv4.
             * @param ivshmem                Inter-VM shared memory. Useful for direct
             *                               communication between VMs, or to the host.
             * @param keephugepages          Use together with hugepages. If enabled,
             *                               hugepages will not be deleted after VM
             *                               shutdown and can be used for subsequent starts.
             * @param keyboard               Keyboard layout for VNC server. This option is
             *                               generally not required and is often better
             *                               handled from within the guest OS.
             *                               Enum:
             *                               de,de-ch,da,en-gb,en-us,es,fi,fr,fr-be,fr-ca,fr-ch,hu,is,it,ja,lt,mk,nl,no,pl,pt,pt-br,sv,sl,tr
             * @param kvm                    Enable/disable KVM hardware virtualization.
             * @param localtime              Set the real time clock (RTC) to local time.
             *                               This is enabled by default if the `ostype`
             *                               indicates a Microsoft Windows OS.
             * @param lock_                  Lock/unlock the VM.
             *                               Enum:
             *                               backup,clone,create,migrate,rollback,snapshot,snapshot-delete,suspending,suspended
             * @param machine                Specify the QEMU machine.
             * @param memory                 Memory properties.
             * @param migrate_downtime       Set maximum tolerated downtime (in seconds) for
             *                               migrations. Should the migration not be able to
             *                               converge in the very end, because too much
             *                               newly dirtied RAM needs to be transferred, the
             *                               limit will be increased automatically
             *                               step-by-step until migration can converge.
             * @param migrate_speed          Set maximum speed (in MB/s) for migrations.
             *                               Value 0 is no limit.
             * @param name                   Set a name for the VM. Only used on the
             *                               configuration web interface.
             * @param nameserver             cloud-init: Sets DNS server IP address for a
             *                               container. Create will automatically use the
             *                               setting from the host if neither searchdomain
             *                               nor nameserver are set.
             * @param netN                   Specify network devices.
             * @param numa                   Enable/disable NUMA.
             * @param numaN                  NUMA topology.
             * @param onboot                 Specifies whether a VM will be started during
             *                               system bootup.
             * @param ostype                 Specify guest operating system.
             *                               Enum:
             *                               other,wxp,w2k,w2k3,w2k8,wvista,win7,win8,win10,win11,l24,l26,solaris
             * @param parallelN              Map host parallel devices (n is 0 to 2).
             * @param protection             Sets the protection flag of the VM. This will
             *                               disable the remove VM and remove disk
             *                               operations.
             * @param reboot                 Allow reboot. If set to '0' the VM exit on
             *                               reboot.
             * @param revert                 Revert a pending change.
             * @param rng0                   Configure a VirtIO-based Random Number
             *                               Generator.
             * @param sataN                  Use volume as SATA hard disk or CD-ROM (n is 0
             *                               to 5). Use the special syntax
             *                               STORAGE_ID:SIZE_IN_GiB to allocate a new
             *                               volume. Use STORAGE_ID:0 and the 'import-from'
             *                               parameter to import from an existing volume.
             * @param scsiN                  Use volume as SCSI hard disk or CD-ROM (n is 0
             *                               to 30). Use the special syntax
             *                               STORAGE_ID:SIZE_IN_GiB to allocate a new
             *                               volume. Use STORAGE_ID:0 and the 'import-from'
             *                               parameter to import from an existing volume.
             * @param scsihw                 SCSI controller model
             *                               Enum:
             *                               lsi,lsi53c810,virtio-scsi-pci,virtio-scsi-single,megasas,pvscsi
             * @param searchdomain           cloud-init: Sets DNS search domains for a
             *                               container. Create will automatically use the
             *                               setting from the host if neither searchdomain
             *                               nor nameserver are set.
             * @param serialN                Create a serial device inside the VM (n is 0 to
             *                               3)
             * @param shares                 Amount of memory shares for auto-ballooning.
             *                               The larger the number is, the more memory this
             *                               VM gets. Number is relative to weights of all
             *                               other running VMs. Using zero disables
             *                               auto-ballooning. Auto-ballooning is done by
             *                               pvestatd.
             * @param skiplock               Ignore locks - only root is allowed to use this
             *                               option.
             * @param smbios1                Specify SMBIOS type 1 fields.
             * @param smp                    The number of CPUs. Please use option -sockets
             *                               instead.
             * @param sockets                The number of CPU sockets.
             * @param spice_enhancements     Configure additional enhancements for SPICE.
             * @param sshkeys                cloud-init: Setup public SSH keys (one key per
             *                               line, OpenSSH format).
             * @param startdate              Set the initial date of the real time clock.
             *                               Valid format for date are:'now' or
             *                               '2006-06-17T16:01:21' or '2006-06-17'.
             * @param startup                Startup and shutdown behavior. Order is a
             *                               non-negative number defining the general
             *                               startup order. Shutdown in done with reverse
             *                               ordering. Additionally, you can set the 'up' or
             *                               'down' delay in seconds, which specifies a
             *                               delay to wait before the next VM is started or
             *                               stopped.
             * @param tablet                 Enable/disable the USB tablet device.
             * @param tags                   Tags of the VM. This is only meta information.
             * @param tdf                    Enable/disable time drift fix.
             * @param template               Enable/disable Template.
             * @param tpmstate0              Configure a Disk for storing TPM state. The
             *                               format is fixed to 'raw'. Use the special
             *                               syntax STORAGE_ID:SIZE_IN_GiB to allocate a new
             *                               volume. Note that SIZE_IN_GiB is ignored here
             *                               and 4 MiB will be used instead. Use
             *                               STORAGE_ID:0 and the 'import-from' parameter to
             *                               import from an existing volume.
             * @param unusedN                Reference to unused volumes. This is used
             *                               internally, and should not be modified
             *                               manually.
             * @param usbN                   Configure a USB device (n is 0 to 4, for
             *                               machine version &amp;gt;= 7.1 and ostype l26 or
             *                               windows &amp;gt; 7, n can be up to 14).
             * @param vcpus                  Number of hotplugged vcpus.
             * @param vga                    Configure the VGA hardware.
             * @param virtioN                Use volume as VIRTIO hard disk (n is 0 to 15).
             *                               Use the special syntax STORAGE_ID:SIZE_IN_GiB
             *                               to allocate a new volume. Use STORAGE_ID:0 and
             *                               the 'import-from' parameter to import from an
             *                               existing volume.
             * @param virtiofsN              Configuration for sharing a directory between
             *                               host and guest using Virtio-fs.
             * @param vmgenid                Set VM Generation ID. Use '1' to autogenerate
             *                               on create or update, pass '0' to disable
             *                               explicitly.
             * @param vmstatestorage         Default storage for VM state volumes/files.
             * @param watchdog               Create a virtual hardware watchdog device.
             * @return Result
             */

            public Result updateVmAsync(Boolean acpi, String affinity, String agent, Boolean allow_ksm,
                                        String amd_sev, String arch, String args, String audio0, Boolean autostart,
                                        Integer background_delay, Integer balloon, String bios, String boot, String bootdisk,
                                        String cdrom, String cicustom, String cipassword, String citype, Boolean ciupgrade,
                                        String ciuser, Integer cores, String cpu, Float cpulimit, Integer cpuunits,
                                        String delete, String description, String digest, String efidisk0, Boolean force,
                                        Boolean freeze, String hookscript, Map<Integer, String> hostpciN, String hotplug,
                                        String hugepages, Map<Integer, String> ideN, String import_working_storage,
                                        String intel_tdx, Map<Integer, String> ipconfigN, String ivshmem, Boolean keephugepages,
                                        String keyboard, Boolean kvm, Boolean localtime, String lock_, String machine,
                                        String memory, Float migrate_downtime, Integer migrate_speed, String name,
                                        String nameserver, Map<Integer, String> netN, Boolean numa, Map<Integer, String> numaN,
                                        Boolean onboot, String ostype, Map<Integer, String> parallelN, Boolean protection,
                                        Boolean reboot, String revert, String rng0, Map<Integer, String> sataN,
                                        Map<Integer, String> scsiN, String scsihw, String searchdomain,
                                        Map<Integer, String> serialN, Integer shares, Boolean skiplock, String smbios1,
                                        Integer smp, Integer sockets, String spice_enhancements, String sshkeys,
                                        String startdate, String startup, Boolean tablet, String tags, Boolean tdf,
                                        Boolean template, String tpmstate0, Map<Integer, String> unusedN,
                                        Map<Integer, String> usbN, Integer vcpus, String vga, Map<Integer, String> virtioN,
                                        Map<Integer, String> virtiofsN, String vmgenid, String vmstatestorage,
                                        String watchdog) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("acpi", acpi);
                parameters.put("affinity", affinity);
                parameters.put("agent", agent);
                parameters.put("allow-ksm", allow_ksm);
                parameters.put("amd-sev", amd_sev);
                parameters.put("arch", arch);
                parameters.put("args", args);
                parameters.put("audio0", audio0);
                parameters.put("autostart", autostart);
                parameters.put("background_delay", background_delay);
                parameters.put("balloon", balloon);
                parameters.put("bios", bios);
                parameters.put("boot", boot);
                parameters.put("bootdisk", bootdisk);
                parameters.put("cdrom", cdrom);
                parameters.put("cicustom", cicustom);
                parameters.put("cipassword", cipassword);
                parameters.put("citype", citype);
                parameters.put("ciupgrade", ciupgrade);
                parameters.put("ciuser", ciuser);
                parameters.put("cores", cores);
                parameters.put("cpu", cpu);
                parameters.put("cpulimit", cpulimit);
                parameters.put("cpuunits", cpuunits);
                parameters.put("delete", delete);
                parameters.put("description", description);
                parameters.put("digest", digest);
                parameters.put("efidisk0", efidisk0);
                parameters.put("force", force);
                parameters.put("freeze", freeze);
                parameters.put("hookscript", hookscript);
                parameters.put("hotplug", hotplug);
                parameters.put("hugepages", hugepages);
                parameters.put("import-working-storage", import_working_storage);
                parameters.put("intel-tdx", intel_tdx);
                parameters.put("ivshmem", ivshmem);
                parameters.put("keephugepages", keephugepages);
                parameters.put("keyboard", keyboard);
                parameters.put("kvm", kvm);
                parameters.put("localtime", localtime);
                parameters.put("lock", lock_);
                parameters.put("machine", machine);
                parameters.put("memory", memory);
                parameters.put("migrate_downtime", migrate_downtime);
                parameters.put("migrate_speed", migrate_speed);
                parameters.put("name", name);
                parameters.put("nameserver", nameserver);
                parameters.put("numa", numa);
                parameters.put("onboot", onboot);
                parameters.put("ostype", ostype);
                parameters.put("protection", protection);
                parameters.put("reboot", reboot);
                parameters.put("revert", revert);
                parameters.put("rng0", rng0);
                parameters.put("scsihw", scsihw);
                parameters.put("searchdomain", searchdomain);
                parameters.put("shares", shares);
                parameters.put("skiplock", skiplock);
                parameters.put("smbios1", smbios1);
                parameters.put("smp", smp);
                parameters.put("sockets", sockets);
                parameters.put("spice_enhancements", spice_enhancements);
                parameters.put("sshkeys", sshkeys);
                parameters.put("startdate", startdate);
                parameters.put("startup", startup);
                parameters.put("tablet", tablet);
                parameters.put("tags", tags);
                parameters.put("tdf", tdf);
                parameters.put("template", template);
                parameters.put("tpmstate0", tpmstate0);
                parameters.put("vcpus", vcpus);
                parameters.put("vga", vga);
                parameters.put("vmgenid", vmgenid);
                parameters.put("vmstatestorage", vmstatestorage);
                parameters.put("watchdog", watchdog);
                PveClientBase.addIndexedParameter(parameters, "hostpci", hostpciN);
                PveClientBase.addIndexedParameter(parameters, "ide", ideN);
                PveClientBase.addIndexedParameter(parameters, "ipconfig", ipconfigN);
                PveClientBase.addIndexedParameter(parameters, "net", netN);
                PveClientBase.addIndexedParameter(parameters, "numa", numaN);
                PveClientBase.addIndexedParameter(parameters, "parallel", parallelN);
                PveClientBase.addIndexedParameter(parameters, "sata", sataN);
                PveClientBase.addIndexedParameter(parameters, "scsi", scsiN);
                PveClientBase.addIndexedParameter(parameters, "serial", serialN);
                PveClientBase.addIndexedParameter(parameters, "unused", unusedN);
                PveClientBase.addIndexedParameter(parameters, "usb", usbN);
                PveClientBase.addIndexedParameter(parameters, "virtio", virtioN);
                PveClientBase.addIndexedParameter(parameters, "virtiofs", virtiofsN);
                return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/config", parameters);
            }

            /**
             * Set virtual machine options (asynchronous API).
             *
             * @return Result
             */

            public Result updateVmAsync() {
                return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/config", null);
            }

            /**
             * Set virtual machine options (synchronous API) - You should consider using the
             * POST method instead for any actions involving hotplug or storage allocation.
             *
             * @param acpi               Enable/disable ACPI.
             * @param affinity           List of host cores used to execute guest processes,
             *                           for example: 0,5,8-11
             * @param agent              Enable/disable communication with the QEMU Guest
             *                           Agent and its properties.
             * @param allow_ksm          Allow memory pages of this guest to be merged via
             *                           KSM (Kernel Samepage Merging).
             * @param amd_sev            Secure Encrypted Virtualization (SEV) features by
             *                           AMD CPUs
             * @param arch               Virtual processor architecture. Defaults to the
             *                           host.
             *                           Enum: x86_64,aarch64
             * @param args               Arbitrary arguments passed to kvm.
             * @param audio0             Configure an audio device, useful in combination
             *                           with QXL/Spice.
             * @param autostart          Automatic restart after crash (currently ignored).
             * @param balloon            Amount of target RAM for the VM in MiB. Using zero
             *                           disables the ballon driver.
             * @param bios               Select BIOS implementation.
             *                           Enum: seabios,ovmf
             * @param boot               Specify guest boot order. Use the 'order='
             *                           sub-property as usage with no key or 'legacy=' is
             *                           deprecated.
             * @param bootdisk           Enable booting from specified disk. Deprecated: Use
             *                           'boot: order=foo;bar' instead.
             * @param cdrom              This is an alias for option -ide2
             * @param cicustom           cloud-init: Specify custom files to replace the
             *                           automatically generated ones at start.
             * @param cipassword         cloud-init: Password to assign the user. Using this
             *                           is generally not recommended. Use ssh keys instead.
             *                           Also note that older cloud-init versions do not
             *                           support hashed passwords.
             * @param citype             Specifies the cloud-init configuration format. The
             *                           default depends on the configured operating system
             *                           type (`ostype`). We use the `nocloud` format for
             *                           Linux, and `configdrive2` for windows.
             *                           Enum: configdrive2,nocloud,opennebula
             * @param ciupgrade          cloud-init: do an automatic package upgrade after
             *                           the first boot.
             * @param ciuser             cloud-init: Username to change ssh keys and
             *                           password for instead of the image's configured
             *                           default user.
             * @param cores              The number of cores per socket.
             * @param cpu                Emulated CPU type.
             * @param cpulimit           Limit of CPU usage.
             * @param cpuunits           CPU weight for a VM, will be clamped to [1, 10000]
             *                           in cgroup v2.
             * @param delete             A list of settings you want to delete.
             * @param description        Description for the VM. Shown in the web-interface
             *                           VM's summary. This is saved as comment inside the
             *                           configuration file.
             * @param digest             Prevent changes if current configuration file has
             *                           different SHA1 digest. This can be used to prevent
             *                           concurrent modifications.
             * @param efidisk0           Configure a disk for storing EFI vars. Use the
             *                           special syntax STORAGE_ID:SIZE_IN_GiB to allocate a
             *                           new volume. Note that SIZE_IN_GiB is ignored here
             *                           and that the default EFI vars are copied to the
             *                           volume instead. Use STORAGE_ID:0 and the
             *                           'import-from' parameter to import from an existing
             *                           volume.
             * @param force              Force physical removal. Without this, we simply
             *                           remove the disk from the config file and create an
             *                           additional configuration entry called 'unused[n]',
             *                           which contains the volume ID. Unlink of unused[n]
             *                           always cause physical removal.
             * @param freeze             Freeze CPU at startup (use 'c' monitor command to
             *                           start execution).
             * @param hookscript         Script that will be executed during various steps
             *                           in the vms lifetime.
             * @param hostpciN           Map host PCI devices into guest.
             * @param hotplug            Selectively enable hotplug features. This is a
             *                           comma separated list of hotplug features:
             *                           'network', 'disk', 'cpu', 'memory', 'usb' and
             *                           'cloudinit'. Use '0' to disable hotplug completely.
             *                           Using '1' as value is an alias for the default
             *                           `network,disk,usb`. USB hotplugging is possible for
             *                           guests with machine version &amp;gt;= 7.1 and
             *                           ostype l26 or windows &amp;gt; 7.
             * @param hugepages          Enables hugepages memory. Sets the size of
             *                           hugepages in MiB. If the value is set to 'any' then
             *                           1 GiB hugepages will be used if possible, otherwise
             *                           the size will fall back to 2 MiB.
             *                           Enum: any,2,1024
             * @param ideN               Use volume as IDE hard disk or CD-ROM (n is 0 to
             *                           3). Use the special syntax STORAGE_ID:SIZE_IN_GiB
             *                           to allocate a new volume. Use STORAGE_ID:0 and the
             *                           'import-from' parameter to import from an existing
             *                           volume.
             * @param intel_tdx          Trusted Domain Extension (TDX) features by Intel
             *                           CPUs
             * @param ipconfigN          cloud-init: Specify IP addresses and gateways for
             *                           the corresponding interface. IP addresses use CIDR
             *                           notation, gateways are optional but need an IP of
             *                           the same type specified. The special string 'dhcp'
             *                           can be used for IP addresses to use DHCP, in which
             *                           case no explicit gateway should be provided. For
             *                           IPv6 the special string 'auto' can be used to use
             *                           stateless autoconfiguration. This requires
             *                           cloud-init 19.4 or newer. If cloud-init is enabled
             *                           and neither an IPv4 nor an IPv6 address is
             *                           specified, it defaults to using dhcp on IPv4.
             * @param ivshmem            Inter-VM shared memory. Useful for direct
             *                           communication between VMs, or to the host.
             * @param keephugepages      Use together with hugepages. If enabled, hugepages
             *                           will not be deleted after VM shutdown and can
             *                           be used for subsequent starts.
             * @param keyboard           Keyboard layout for VNC server. This option is
             *                           generally not required and is often better handled
             *                           from within the guest OS.
             *                           Enum:
             *                           de,de-ch,da,en-gb,en-us,es,fi,fr,fr-be,fr-ca,fr-ch,hu,is,it,ja,lt,mk,nl,no,pl,pt,pt-br,sv,sl,tr
             * @param kvm                Enable/disable KVM hardware virtualization.
             * @param localtime          Set the real time clock (RTC) to local time. This
             *                           is enabled by default if the `ostype` indicates a
             *                           Microsoft Windows OS.
             * @param lock_              Lock/unlock the VM.
             *                           Enum:
             *                           backup,clone,create,migrate,rollback,snapshot,snapshot-delete,suspending,suspended
             * @param machine            Specify the QEMU machine.
             * @param memory             Memory properties.
             * @param migrate_downtime   Set maximum tolerated downtime (in seconds) for
             *                           migrations. Should the migration not be able to
             *                           converge in the very end, because too much newly
             *                           dirtied RAM needs to be transferred, the limit will
             *                           be increased automatically step-by-step until
             *                           migration can converge.
             * @param migrate_speed      Set maximum speed (in MB/s) for migrations. Value 0
             *                           is no limit.
             * @param name               Set a name for the VM. Only used on the
             *                           configuration web interface.
             * @param nameserver         cloud-init: Sets DNS server IP address for a
             *                           container. Create will automatically use the
             *                           setting from the host if neither searchdomain nor
             *                           nameserver are set.
             * @param netN               Specify network devices.
             * @param numa               Enable/disable NUMA.
             * @param numaN              NUMA topology.
             * @param onboot             Specifies whether a VM will be started during
             *                           system bootup.
             * @param ostype             Specify guest operating system.
             *                           Enum:
             *                           other,wxp,w2k,w2k3,w2k8,wvista,win7,win8,win10,win11,l24,l26,solaris
             * @param parallelN          Map host parallel devices (n is 0 to 2).
             * @param protection         Sets the protection flag of the VM. This will
             *                           disable the remove VM and remove disk operations.
             * @param reboot             Allow reboot. If set to '0' the VM exit on reboot.
             * @param revert             Revert a pending change.
             * @param rng0               Configure a VirtIO-based Random Number Generator.
             * @param sataN              Use volume as SATA hard disk or CD-ROM (n is 0 to
             *                           5). Use the special syntax STORAGE_ID:SIZE_IN_GiB
             *                           to allocate a new volume. Use STORAGE_ID:0 and the
             *                           'import-from' parameter to import from an existing
             *                           volume.
             * @param scsiN              Use volume as SCSI hard disk or CD-ROM (n is 0 to
             *                           30). Use the special syntax STORAGE_ID:SIZE_IN_GiB
             *                           to allocate a new volume. Use STORAGE_ID:0 and the
             *                           'import-from' parameter to import from an existing
             *                           volume.
             * @param scsihw             SCSI controller model
             *                           Enum:
             *                           lsi,lsi53c810,virtio-scsi-pci,virtio-scsi-single,megasas,pvscsi
             * @param searchdomain       cloud-init: Sets DNS search domains for a
             *                           container. Create will automatically use the
             *                           setting from the host if neither searchdomain nor
             *                           nameserver are set.
             * @param serialN            Create a serial device inside the VM (n is 0 to 3)
             * @param shares             Amount of memory shares for auto-ballooning. The
             *                           larger the number is, the more memory this VM gets.
             *                           Number is relative to weights of all other running
             *                           VMs. Using zero disables auto-ballooning.
             *                           Auto-ballooning is done by pvestatd.
             * @param skiplock           Ignore locks - only root is allowed to use this
             *                           option.
             * @param smbios1            Specify SMBIOS type 1 fields.
             * @param smp                The number of CPUs. Please use option -sockets
             *                           instead.
             * @param sockets            The number of CPU sockets.
             * @param spice_enhancements Configure additional enhancements for SPICE.
             * @param sshkeys            cloud-init: Setup public SSH keys (one key per
             *                           line, OpenSSH format).
             * @param startdate          Set the initial date of the real time clock. Valid
             *                           format for date are:'now' or '2006-06-17T16:01:21'
             *                           or '2006-06-17'.
             * @param startup            Startup and shutdown behavior. Order is a
             *                           non-negative number defining the general startup
             *                           order. Shutdown in done with reverse ordering.
             *                           Additionally, you can set the 'up' or 'down' delay
             *                           in seconds, which specifies a delay to wait before
             *                           the next VM is started or stopped.
             * @param tablet             Enable/disable the USB tablet device.
             * @param tags               Tags of the VM. This is only meta information.
             * @param tdf                Enable/disable time drift fix.
             * @param template           Enable/disable Template.
             * @param tpmstate0          Configure a Disk for storing TPM state. The format
             *                           is fixed to 'raw'. Use the special syntax
             *                           STORAGE_ID:SIZE_IN_GiB to allocate a new volume.
             *                           Note that SIZE_IN_GiB is ignored here and 4 MiB
             *                           will be used instead. Use STORAGE_ID:0 and the
             *                           'import-from' parameter to import from an existing
             *                           volume.
             * @param unusedN            Reference to unused volumes. This is used
             *                           internally, and should not be modified manually.
             * @param usbN               Configure a USB device (n is 0 to 4, for machine
             *                           version &amp;gt;= 7.1 and ostype l26 or windows
             *                           &amp;gt; 7, n can be up to 14).
             * @param vcpus              Number of hotplugged vcpus.
             * @param vga                Configure the VGA hardware.
             * @param virtioN            Use volume as VIRTIO hard disk (n is 0 to 15). Use
             *                           the special syntax STORAGE_ID:SIZE_IN_GiB to
             *                           allocate a new volume. Use STORAGE_ID:0 and the
             *                           'import-from' parameter to import from an existing
             *                           volume.
             * @param virtiofsN          Configuration for sharing a directory between host
             *                           and guest using Virtio-fs.
             * @param vmgenid            Set VM Generation ID. Use '1' to autogenerate on
             *                           create or update, pass '0' to disable explicitly.
             * @param vmstatestorage     Default storage for VM state volumes/files.
             * @param watchdog           Create a virtual hardware watchdog device.
             * @return Result
             */

            public Result updateVm(Boolean acpi, String affinity, String agent, Boolean allow_ksm,
                                   String amd_sev, String arch, String args, String audio0, Boolean autostart,
                                   Integer balloon, String bios, String boot, String bootdisk, String cdrom,
                                   String cicustom, String cipassword, String citype, Boolean ciupgrade, String ciuser,
                                   Integer cores, String cpu, Float cpulimit, Integer cpuunits, String delete,
                                   String description, String digest, String efidisk0, Boolean force, Boolean freeze,
                                   String hookscript, Map<Integer, String> hostpciN, String hotplug, String hugepages,
                                   Map<Integer, String> ideN, String intel_tdx, Map<Integer, String> ipconfigN,
                                   String ivshmem, Boolean keephugepages, String keyboard, Boolean kvm, Boolean localtime,
                                   String lock_, String machine, String memory, Float migrate_downtime,
                                   Integer migrate_speed, String name, String nameserver, Map<Integer, String> netN,
                                   Boolean numa, Map<Integer, String> numaN, Boolean onboot, String ostype,
                                   Map<Integer, String> parallelN, Boolean protection, Boolean reboot, String revert,
                                   String rng0, Map<Integer, String> sataN, Map<Integer, String> scsiN, String scsihw,
                                   String searchdomain, Map<Integer, String> serialN, Integer shares, Boolean skiplock,
                                   String smbios1, Integer smp, Integer sockets, String spice_enhancements, String sshkeys,
                                   String startdate, String startup, Boolean tablet, String tags, Boolean tdf,
                                   Boolean template, String tpmstate0, Map<Integer, String> unusedN,
                                   Map<Integer, String> usbN, Integer vcpus, String vga, Map<Integer, String> virtioN,
                                   Map<Integer, String> virtiofsN, String vmgenid, String vmstatestorage,
                                   String watchdog) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("acpi", acpi);
                parameters.put("affinity", affinity);
                parameters.put("agent", agent);
                parameters.put("allow-ksm", allow_ksm);
                parameters.put("amd-sev", amd_sev);
                parameters.put("arch", arch);
                parameters.put("args", args);
                parameters.put("audio0", audio0);
                parameters.put("autostart", autostart);
                parameters.put("balloon", balloon);
                parameters.put("bios", bios);
                parameters.put("boot", boot);
                parameters.put("bootdisk", bootdisk);
                parameters.put("cdrom", cdrom);
                parameters.put("cicustom", cicustom);
                parameters.put("cipassword", cipassword);
                parameters.put("citype", citype);
                parameters.put("ciupgrade", ciupgrade);
                parameters.put("ciuser", ciuser);
                parameters.put("cores", cores);
                parameters.put("cpu", cpu);
                parameters.put("cpulimit", cpulimit);
                parameters.put("cpuunits", cpuunits);
                parameters.put("delete", delete);
                parameters.put("description", description);
                parameters.put("digest", digest);
                parameters.put("efidisk0", efidisk0);
                parameters.put("force", force);
                parameters.put("freeze", freeze);
                parameters.put("hookscript", hookscript);
                parameters.put("hotplug", hotplug);
                parameters.put("hugepages", hugepages);
                parameters.put("intel-tdx", intel_tdx);
                parameters.put("ivshmem", ivshmem);
                parameters.put("keephugepages", keephugepages);
                parameters.put("keyboard", keyboard);
                parameters.put("kvm", kvm);
                parameters.put("localtime", localtime);
                parameters.put("lock", lock_);
                parameters.put("machine", machine);
                parameters.put("memory", memory);
                parameters.put("migrate_downtime", migrate_downtime);
                parameters.put("migrate_speed", migrate_speed);
                parameters.put("name", name);
                parameters.put("nameserver", nameserver);
                parameters.put("numa", numa);
                parameters.put("onboot", onboot);
                parameters.put("ostype", ostype);
                parameters.put("protection", protection);
                parameters.put("reboot", reboot);
                parameters.put("revert", revert);
                parameters.put("rng0", rng0);
                parameters.put("scsihw", scsihw);
                parameters.put("searchdomain", searchdomain);
                parameters.put("shares", shares);
                parameters.put("skiplock", skiplock);
                parameters.put("smbios1", smbios1);
                parameters.put("smp", smp);
                parameters.put("sockets", sockets);
                parameters.put("spice_enhancements", spice_enhancements);
                parameters.put("sshkeys", sshkeys);
                parameters.put("startdate", startdate);
                parameters.put("startup", startup);
                parameters.put("tablet", tablet);
                parameters.put("tags", tags);
                parameters.put("tdf", tdf);
                parameters.put("template", template);
                parameters.put("tpmstate0", tpmstate0);
                parameters.put("vcpus", vcpus);
                parameters.put("vga", vga);
                parameters.put("vmgenid", vmgenid);
                parameters.put("vmstatestorage", vmstatestorage);
                parameters.put("watchdog", watchdog);
                PveClientBase.addIndexedParameter(parameters, "hostpci", hostpciN);
                PveClientBase.addIndexedParameter(parameters, "ide", ideN);
                PveClientBase.addIndexedParameter(parameters, "ipconfig", ipconfigN);
                PveClientBase.addIndexedParameter(parameters, "net", netN);
                PveClientBase.addIndexedParameter(parameters, "numa", numaN);
                PveClientBase.addIndexedParameter(parameters, "parallel", parallelN);
                PveClientBase.addIndexedParameter(parameters, "sata", sataN);
                PveClientBase.addIndexedParameter(parameters, "scsi", scsiN);
                PveClientBase.addIndexedParameter(parameters, "serial", serialN);
                PveClientBase.addIndexedParameter(parameters, "unused", unusedN);
                PveClientBase.addIndexedParameter(parameters, "usb", usbN);
                PveClientBase.addIndexedParameter(parameters, "virtio", virtioN);
                PveClientBase.addIndexedParameter(parameters, "virtiofs", virtiofsN);
                return client.set("/nodes/" + this.node + "/qemu/" + this.vmid + "/config", parameters);
            }

            /**
             * Set virtual machine options (synchronous API) - You should consider using the
             * POST method instead for any actions involving hotplug or storage allocation.
             *
             * @return Result
             */

            public Result updateVm() {
                return client.set("/nodes/" + this.node + "/qemu/" + this.vmid + "/config", null);
            }

        }

        public static class PVEPending {

            private final PveClient client;
            private final Object node;
            private final Object vmid;

            protected PVEPending(PveClient client, Object node, Object vmid) {
                this.client = client;
                this.node = node;
                this.vmid = vmid;
            }

            /**
             * Get the virtual machine configuration with both current and pending values.
             *
             * @return Result
             */

            public Result vmPending() {
                return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/pending", null);
            }

        }

        public static class PVECloudinit {

            private final PveClient client;
            private final Object node;
            private final Object vmid;

            protected PVECloudinit(PveClient client, Object node, Object vmid) {
                this.client = client;
                this.node = node;
                this.vmid = vmid;
            }

            private PVEVmidItem.PVECloudinit.PVEDump dump;

            public PVEVmidItem.PVECloudinit.PVEDump getDump() {
                return dump == null ? (dump = new PVEDump(client, this.node, this.vmid)) : dump;
            }

            public static class PVEDump {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVEDump(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Get automatically generated cloudinit config.
                 *
                 * @param type Config type.
                 *             Enum: user,network,meta
                 * @return Result
                 */

                public Result cloudinitGeneratedConfigDump(String type) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("type", type);
                    return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/cloudinit/dump",
                            parameters);
                }

            }

            /**
             * Get the cloudinit configuration with both current and pending values.
             *
             * @return Result
             */

            public Result cloudinitPending() {
                return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/cloudinit", null);
            }

            /**
             * Regenerate and change cloudinit config drive.
             *
             * @return Result
             */

            public Result cloudinitUpdate() {
                return client.set("/nodes/" + this.node + "/qemu/" + this.vmid + "/cloudinit", null);
            }

        }

        public static class PVEUnlink {

            private final PveClient client;
            private final Object node;
            private final Object vmid;

            protected PVEUnlink(PveClient client, Object node, Object vmid) {
                this.client = client;
                this.node = node;
                this.vmid = vmid;
            }

            /**
             * Unlink/delete disk images.
             *
             * @param idlist A list of disk IDs you want to delete.
             * @param force  Force physical removal. Without this, we simply remove the disk
             *               from the config file and create an additional configuration
             *               entry called 'unused[n]', which contains the volume ID. Unlink
             *               of unused[n] always cause physical removal.
             * @return Result
             */

            public Result unlink(String idlist, Boolean force) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("idlist", idlist);
                parameters.put("force", force);
                return client.set("/nodes/" + this.node + "/qemu/" + this.vmid + "/unlink", parameters);
            }

            /**
             * Unlink/delete disk images.
             *
             * @param idlist A list of disk IDs you want to delete.
             * @return Result
             */

            public Result unlink(String idlist) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("idlist", idlist);
                return client.set("/nodes/" + this.node + "/qemu/" + this.vmid + "/unlink", parameters);
            }

        }

        public static class PVEVncproxy {

            private final PveClient client;
            private final Object node;
            private final Object vmid;

            protected PVEVncproxy(PveClient client, Object node, Object vmid) {
                this.client = client;
                this.node = node;
                this.vmid = vmid;
            }

            /**
             * Creates a TCP VNC proxy connections.
             *
             * @param generate_password Generates a random password to be used as ticket
             *                          instead of the API ticket.
             * @param websocket         Prepare for websocket upgrade (only required when
             *                          using serial terminal, otherwise upgrade is always
             *                          possible).
             * @return Result
             */

            public Result vncproxy(Boolean generate_password, Boolean websocket) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("generate-password", generate_password);
                parameters.put("websocket", websocket);
                return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/vncproxy",
                        parameters);
            }

            /**
             * Creates a TCP VNC proxy connections.
             *
             * @return Result
             */

            public Result vncproxy() {
                return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/vncproxy", null);
            }

        }

        public static class PVETermproxy {

            private final PveClient client;
            private final Object node;
            private final Object vmid;

            protected PVETermproxy(PveClient client, Object node, Object vmid) {
                this.client = client;
                this.node = node;
                this.vmid = vmid;
            }

            /**
             * Creates a TCP proxy connections.
             *
             * @param serial opens a serial terminal (defaults to display)
             *               Enum: serial0,serial1,serial2,serial3
             * @return Result
             */

            public Result termproxy(String serial) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("serial", serial);
                return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/termproxy",
                        parameters);
            }

            /**
             * Creates a TCP proxy connections.
             *
             * @return Result
             */

            public Result termproxy() {
                return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/termproxy", null);
            }

        }

        public static class PVEVncwebsocket {

            private final PveClient client;
            private final Object node;
            private final Object vmid;

            protected PVEVncwebsocket(PveClient client, Object node, Object vmid) {
                this.client = client;
                this.node = node;
                this.vmid = vmid;
            }

            /**
             * Opens a websocket for VNC traffic.
             *
             * @param port      Port number returned by previous vncproxy call.
             * @param vncticket Ticket from previous call to vncproxy.
             * @return Result
             */

            public Result vncwebsocket(int port, String vncticket) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("port", port);
                parameters.put("vncticket", vncticket);
                return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/vncwebsocket",
                        parameters);
            }

        }

        public static class PVESpiceproxy {

            private final PveClient client;
            private final Object node;
            private final Object vmid;

            protected PVESpiceproxy(PveClient client, Object node, Object vmid) {
                this.client = client;
                this.node = node;
                this.vmid = vmid;
            }

            /**
             * Returns a SPICE configuration to connect to the VM.
             *
             * @param proxy SPICE proxy server. This can be used by the client to specify
             *              the proxy server. All nodes in a cluster runs 'spiceproxy', so
             *              it is up to the client to choose one. By default, we return the
             *              node where the VM is currently running. As reasonable setting is
             *              to use same node you use to connect to the API (This is
             *              window.location.hostname for the JS GUI).
             * @return Result
             */

            public Result spiceproxy(String proxy) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("proxy", proxy);
                return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/spiceproxy",
                        parameters);
            }

            /**
             * Returns a SPICE configuration to connect to the VM.
             *
             * @return Result
             */

            public Result spiceproxy() {
                return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/spiceproxy", null);
            }

        }

        public static class PVEStatus {

            private final PveClient client;
            private final Object node;
            private final Object vmid;

            protected PVEStatus(PveClient client, Object node, Object vmid) {
                this.client = client;
                this.node = node;
                this.vmid = vmid;
            }

            private PVEVmidItem.PVEStatus.PVECurrent current;

            public PVEVmidItem.PVEStatus.PVECurrent getCurrent() {
                return current == null ? (current = new PVECurrent(client, this.node, this.vmid)) : current;
            }

            private PVEVmidItem.PVEStatus.PVEStart start;

            public PVEVmidItem.PVEStatus.PVEStart getStart() {
                return start == null ? (start = new PVEStart(client, this.node, this.vmid)) : start;
            }

            private PVEVmidItem.PVEStatus.PVEStop stop;

            public PVEVmidItem.PVEStatus.PVEStop getStop() {
                return stop == null ? (stop = new PVEStop(client, this.node, this.vmid)) : stop;
            }

            private PVEVmidItem.PVEStatus.PVEReset reset;

            public PVEVmidItem.PVEStatus.PVEReset getReset() {
                return reset == null ? (reset = new PVEReset(client, this.node, this.vmid)) : reset;
            }

            private PVEVmidItem.PVEStatus.PVEShutdown shutdown;

            public PVEVmidItem.PVEStatus.PVEShutdown getShutdown() {
                return shutdown == null ? (shutdown = new PVEShutdown(client, this.node, this.vmid))
                        : shutdown;
            }

            private PVEVmidItem.PVEStatus.PVEReboot reboot;

            public PVEVmidItem.PVEStatus.PVEReboot getReboot() {
                return reboot == null ? (reboot = new PVEReboot(client, this.node, this.vmid)) : reboot;
            }

            private PVEVmidItem.PVEStatus.PVESuspend suspend;

            public PVEVmidItem.PVEStatus.PVESuspend getSuspend() {
                return suspend == null ? (suspend = new PVESuspend(client, this.node, this.vmid)) : suspend;
            }

            private PVEVmidItem.PVEStatus.PVEResume resume;

            public PVEVmidItem.PVEStatus.PVEResume getResume() {
                return resume == null ? (resume = new PVEResume(client, this.node, this.vmid)) : resume;
            }

            public static class PVECurrent {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVECurrent(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Get virtual machine status.
                 *
                 * @return Result
                 */

                public Result vmStatus() {
                    return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/status/current",
                            null);
                }

            }

            public static class PVEStart {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVEStart(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Start virtual machine.
                 *
                 * @param force_cpu            Override QEMU's -cpu argument with the given
                 *                             string.
                 * @param machine              Specify the QEMU machine.
                 * @param migratedfrom         The cluster node name.
                 * @param migration_network    CIDR of the (sub) network that is used for
                 *                             migration.
                 * @param migration_type       Migration traffic is encrypted using an SSH
                 *                             tunnel by default. On secure, completely private
                 *                             networks this can be disabled to increase
                 *                             performance.
                 *                             Enum: secure,insecure
                 * @param nets_host_mtu        Used for migration compat. List of VirtIO network
                 *                             devices and their effective host_mtu setting
                 *                             according to the QEMU object model on the source
                 *                             side of the migration. A value of 0 means that
                 *                             the host_mtu parameter is to be avoided for the
                 *                             corresponding device.
                 * @param skiplock             Ignore locks - only root is allowed to use this
                 *                             option.
                 * @param stateuri             Some command save/restore state from this
                 *                             location.
                 * @param targetstorage        Mapping from source to target storages. Providing
                 *                             only a single storage ID maps all source storages
                 *                             to that storage. Providing the special value '1'
                 *                             will map each source storage to itself.
                 * @param timeout              Wait maximal timeout seconds.
                 * @param with_conntrack_state Whether to migrate conntrack entries for running
                 *                             VMs.
                 * @return Result
                 */

                public Result vmStart(String force_cpu, String machine, String migratedfrom,
                                      String migration_network, String migration_type, String nets_host_mtu,
                                      Boolean skiplock, String stateuri, String targetstorage, Integer timeout,
                                      Boolean with_conntrack_state) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("force-cpu", force_cpu);
                    parameters.put("machine", machine);
                    parameters.put("migratedfrom", migratedfrom);
                    parameters.put("migration_network", migration_network);
                    parameters.put("migration_type", migration_type);
                    parameters.put("nets-host-mtu", nets_host_mtu);
                    parameters.put("skiplock", skiplock);
                    parameters.put("stateuri", stateuri);
                    parameters.put("targetstorage", targetstorage);
                    parameters.put("timeout", timeout);
                    parameters.put("with-conntrack-state", with_conntrack_state);
                    return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/status/start",
                            parameters);
                }

                /**
                 * Start virtual machine.
                 *
                 * @return Result
                 */

                public Result vmStart() {
                    return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/status/start",
                            null);
                }

            }

            public static class PVEStop {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVEStop(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Stop virtual machine. The qemu process will exit immediately. This is akin to
                 * pulling the power plug of a running computer and may damage the VM data.
                 *
                 * @param keepActive        Do not deactivate storage volumes.
                 * @param migratedfrom      The cluster node name.
                 * @param overrule_shutdown Try to abort active 'qmshutdown' tasks before
                 *                          stopping.
                 * @param skiplock          Ignore locks - only root is allowed to use this
                 *                          option.
                 * @param timeout           Wait maximal timeout seconds.
                 * @return Result
                 */

                public Result vmStop(Boolean keepActive, String migratedfrom, Boolean overrule_shutdown,
                                     Boolean skiplock, Integer timeout) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("keepActive", keepActive);
                    parameters.put("migratedfrom", migratedfrom);
                    parameters.put("overrule-shutdown", overrule_shutdown);
                    parameters.put("skiplock", skiplock);
                    parameters.put("timeout", timeout);
                    return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/status/stop",
                            parameters);
                }

                /**
                 * Stop virtual machine. The qemu process will exit immediately. This is akin to
                 * pulling the power plug of a running computer and may damage the VM data.
                 *
                 * @return Result
                 */

                public Result vmStop() {
                    return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/status/stop",
                            null);
                }

            }

            public static class PVEReset {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVEReset(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Reset virtual machine.
                 *
                 * @param skiplock Ignore locks - only root is allowed to use this option.
                 * @return Result
                 */

                public Result vmReset(Boolean skiplock) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("skiplock", skiplock);
                    return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/status/reset",
                            parameters);
                }

                /**
                 * Reset virtual machine.
                 *
                 * @return Result
                 */

                public Result vmReset() {
                    return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/status/reset",
                            null);
                }

            }

            public static class PVEShutdown {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVEShutdown(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Shutdown virtual machine. This is similar to pressing the power button on a
                 * physical machine. This will send an ACPI event for the guest OS, which should
                 * then proceed to a clean shutdown.
                 *
                 * @param forceStop  Make sure the VM stops.
                 * @param keepActive Do not deactivate storage volumes.
                 * @param skiplock   Ignore locks - only root is allowed to use this option.
                 * @param timeout    Wait maximal timeout seconds.
                 * @return Result
                 */

                public Result vmShutdown(Boolean forceStop, Boolean keepActive, Boolean skiplock,
                                         Integer timeout) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("forceStop", forceStop);
                    parameters.put("keepActive", keepActive);
                    parameters.put("skiplock", skiplock);
                    parameters.put("timeout", timeout);
                    return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/status/shutdown",
                            parameters);
                }

                /**
                 * Shutdown virtual machine. This is similar to pressing the power button on a
                 * physical machine. This will send an ACPI event for the guest OS, which should
                 * then proceed to a clean shutdown.
                 *
                 * @return Result
                 */

                public Result vmShutdown() {
                    return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/status/shutdown",
                            null);
                }

            }

            public static class PVEReboot {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVEReboot(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Reboot the VM by shutting it down, and starting it again. Applies pending
                 * changes.
                 *
                 * @param timeout Wait maximal timeout seconds for the shutdown.
                 * @return Result
                 */

                public Result vmReboot(Integer timeout) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("timeout", timeout);
                    return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/status/reboot",
                            parameters);
                }

                /**
                 * Reboot the VM by shutting it down, and starting it again. Applies pending
                 * changes.
                 *
                 * @return Result
                 */

                public Result vmReboot() {
                    return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/status/reboot",
                            null);
                }

            }

            public static class PVESuspend {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVESuspend(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Suspend virtual machine.
                 *
                 * @param skiplock     Ignore locks - only root is allowed to use this option.
                 * @param statestorage The storage for the VM state
                 * @param todisk       If set, suspends the VM to disk. Will be resumed on next
                 *                     VM start.
                 * @return Result
                 */

                public Result vmSuspend(Boolean skiplock, String statestorage, Boolean todisk) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("skiplock", skiplock);
                    parameters.put("statestorage", statestorage);
                    parameters.put("todisk", todisk);
                    return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/status/suspend",
                            parameters);
                }

                /**
                 * Suspend virtual machine.
                 *
                 * @return Result
                 */

                public Result vmSuspend() {
                    return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/status/suspend",
                            null);
                }

            }

            public static class PVEResume {

                private final PveClient client;
                private final Object node;
                private final Object vmid;

                protected PVEResume(PveClient client, Object node, Object vmid) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                }

                /**
                 * Resume virtual machine.
                 *
                 * @param nocheck
                 * @param skiplock Ignore locks - only root is allowed to use this option.
                 * @return Result
                 */

                public Result vmResume(Boolean nocheck, Boolean skiplock) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("nocheck", nocheck);
                    parameters.put("skiplock", skiplock);
                    return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/status/resume",
                            parameters);
                }

                /**
                 * Resume virtual machine.
                 *
                 * @return Result
                 */

                public Result vmResume() {
                    return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/status/resume",
                            null);
                }

            }

            /**
             * Directory index
             *
             * @return Result
             */

            public Result vmcmdidx() {
                return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/status", null);
            }

        }

        public static class PVESendkey {

            private final PveClient client;
            private final Object node;
            private final Object vmid;

            protected PVESendkey(PveClient client, Object node, Object vmid) {
                this.client = client;
                this.node = node;
                this.vmid = vmid;
            }

            /**
             * Send key event to virtual machine.
             *
             * @param key      The key (qemu monitor encoding).
             * @param skiplock Ignore locks - only root is allowed to use this option.
             * @return Result
             */

            public Result vmSendkey(String key, Boolean skiplock) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("key", key);
                parameters.put("skiplock", skiplock);
                return client.set("/nodes/" + this.node + "/qemu/" + this.vmid + "/sendkey", parameters);
            }

            /**
             * Send key event to virtual machine.
             *
             * @param key The key (qemu monitor encoding).
             * @return Result
             */

            public Result vmSendkey(String key) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("key", key);
                return client.set("/nodes/" + this.node + "/qemu/" + this.vmid + "/sendkey", parameters);
            }

        }

        public static class PVEFeature {

            private final PveClient client;
            private final Object node;
            private final Object vmid;

            protected PVEFeature(PveClient client, Object node, Object vmid) {
                this.client = client;
                this.node = node;
                this.vmid = vmid;
            }

            /**
             * Check if feature for virtual machine is available.
             *
             * @param feature  Feature to check.
             *                 Enum: snapshot,clone,copy
             * @param snapname The name of the snapshot.
             * @return Result
             */

            public Result vmFeature(String feature, String snapname) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("feature", feature);
                parameters.put("snapname", snapname);
                return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/feature", parameters);
            }

            /**
             * Check if feature for virtual machine is available.
             *
             * @param feature Feature to check.
             *                Enum: snapshot,clone,copy
             * @return Result
             */

            public Result vmFeature(String feature) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("feature", feature);
                return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/feature", parameters);
            }

        }

        public static class PVEClone {

            private final PveClient client;
            private final Object node;
            private final Object vmid;

            protected PVEClone(PveClient client, Object node, Object vmid) {
                this.client = client;
                this.node = node;
                this.vmid = vmid;
            }

            /**
             * Create a copy of virtual machine/template.
             *
             * @param newid       VMID for the clone.
             * @param bwlimit     Override I/O bandwidth limit (in KiB/s).
             * @param description Description for the new VM.
             * @param format      Target format for file storage. Only valid for full clone.
             *                    Enum: raw,qcow2,vmdk
             * @param full        Create a full copy of all disks. This is always done when
             *                    you clone a normal VM. For VM templates, we try to create
             *                    a linked clone by default.
             * @param name        Set a name for the new VM.
             * @param pool        Add the new VM to the specified pool.
             * @param snapname    The name of the snapshot.
             * @param storage     Target storage for full clone.
             * @param target      Target node. Only allowed if the original VM is on shared
             *                    storage.
             * @return Result
             */

            public Result cloneVm(int newid, Integer bwlimit, String description, String format,
                                  Boolean full, String name, String pool, String snapname, String storage,
                                  String target) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("newid", newid);
                parameters.put("bwlimit", bwlimit);
                parameters.put("description", description);
                parameters.put("format", format);
                parameters.put("full", full);
                parameters.put("name", name);
                parameters.put("pool", pool);
                parameters.put("snapname", snapname);
                parameters.put("storage", storage);
                parameters.put("target", target);
                return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/clone", parameters);
            }

            /**
             * Create a copy of virtual machine/template.
             *
             * @param newid VMID for the clone.
             * @return Result
             */

            public Result cloneVm(int newid) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("newid", newid);
                return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/clone", parameters);
            }

        }

        public static class PVEMoveDisk {

            private final PveClient client;
            private final Object node;
            private final Object vmid;

            protected PVEMoveDisk(PveClient client, Object node, Object vmid) {
                this.client = client;
                this.node = node;
                this.vmid = vmid;
            }

            /**
             * Move volume to different storage or to a different VM.
             *
             * @param disk          The disk you want to move.
             *                      Enum:
             *                      ide0,ide1,ide2,ide3,scsi0,scsi1,scsi2,scsi3,scsi4,scsi5,scsi6,scsi7,scsi8,scsi9,scsi10,scsi11,scsi12,scsi13,scsi14,scsi15,scsi16,scsi17,scsi18,scsi19,scsi20,scsi21,scsi22,scsi23,scsi24,scsi25,scsi26,scsi27,scsi28,scsi29,scsi30,virtio0,virtio1,virtio2,virtio3,virtio4,virtio5,virtio6,virtio7,virtio8,virtio9,virtio10,virtio11,virtio12,virtio13,virtio14,virtio15,sata0,sata1,sata2,sata3,sata4,sata5,efidisk0,tpmstate0,unused0,unused1,unused2,unused3,unused4,unused5,unused6,unused7,unused8,unused9,unused10,unused11,unused12,unused13,unused14,unused15,unused16,unused17,unused18,unused19,unused20,unused21,unused22,unused23,unused24,unused25,unused26,unused27,unused28,unused29,unused30,unused31,unused32,unused33,unused34,unused35,unused36,unused37,unused38,unused39,unused40,unused41,unused42,unused43,unused44,unused45,unused46,unused47,unused48,unused49,unused50,unused51,unused52,unused53,unused54,unused55,unused56,unused57,unused58,unused59,unused60,unused61,unused62,unused63,unused64,unused65,unused66,unused67,unused68,unused69,unused70,unused71,unused72,unused73,unused74,unused75,unused76,unused77,unused78,unused79,unused80,unused81,unused82,unused83,unused84,unused85,unused86,unused87,unused88,unused89,unused90,unused91,unused92,unused93,unused94,unused95,unused96,unused97,unused98,unused99,unused100,unused101,unused102,unused103,unused104,unused105,unused106,unused107,unused108,unused109,unused110,unused111,unused112,unused113,unused114,unused115,unused116,unused117,unused118,unused119,unused120,unused121,unused122,unused123,unused124,unused125,unused126,unused127,unused128,unused129,unused130,unused131,unused132,unused133,unused134,unused135,unused136,unused137,unused138,unused139,unused140,unused141,unused142,unused143,unused144,unused145,unused146,unused147,unused148,unused149,unused150,unused151,unused152,unused153,unused154,unused155,unused156,unused157,unused158,unused159,unused160,unused161,unused162,unused163,unused164,unused165,unused166,unused167,unused168,unused169,unused170,unused171,unused172,unused173,unused174,unused175,unused176,unused177,unused178,unused179,unused180,unused181,unused182,unused183,unused184,unused185,unused186,unused187,unused188,unused189,unused190,unused191,unused192,unused193,unused194,unused195,unused196,unused197,unused198,unused199,unused200,unused201,unused202,unused203,unused204,unused205,unused206,unused207,unused208,unused209,unused210,unused211,unused212,unused213,unused214,unused215,unused216,unused217,unused218,unused219,unused220,unused221,unused222,unused223,unused224,unused225,unused226,unused227,unused228,unused229,unused230,unused231,unused232,unused233,unused234,unused235,unused236,unused237,unused238,unused239,unused240,unused241,unused242,unused243,unused244,unused245,unused246,unused247,unused248,unused249,unused250,unused251,unused252,unused253,unused254,unused255
             * @param bwlimit       Override I/O bandwidth limit (in KiB/s).
             * @param delete        Delete the original disk after successful copy. By
             *                      default, the original disk is kept as unused disk.
             * @param digest        Prevent changes if current configuration file has
             *                      different SHA1 digest. This can be used to prevent
             *                      concurrent modifications.
             * @param format        Target Format.
             *                      Enum: raw,qcow2,vmdk
             * @param storage       Target storage.
             * @param target_digest Prevent changes if the current config file of the target
             *                      VM has a different SHA1 digest. This can be used to
             *                      detect concurrent modifications.
             * @param target_disk   The config key the disk will be moved to on the target
             *                      VM (for example, ide0 or scsi1). Default is the source
             *                      disk key.
             *                      Enum:
             *                      ide0,ide1,ide2,ide3,scsi0,scsi1,scsi2,scsi3,scsi4,scsi5,scsi6,scsi7,scsi8,scsi9,scsi10,scsi11,scsi12,scsi13,scsi14,scsi15,scsi16,scsi17,scsi18,scsi19,scsi20,scsi21,scsi22,scsi23,scsi24,scsi25,scsi26,scsi27,scsi28,scsi29,scsi30,virtio0,virtio1,virtio2,virtio3,virtio4,virtio5,virtio6,virtio7,virtio8,virtio9,virtio10,virtio11,virtio12,virtio13,virtio14,virtio15,sata0,sata1,sata2,sata3,sata4,sata5,efidisk0,tpmstate0,unused0,unused1,unused2,unused3,unused4,unused5,unused6,unused7,unused8,unused9,unused10,unused11,unused12,unused13,unused14,unused15,unused16,unused17,unused18,unused19,unused20,unused21,unused22,unused23,unused24,unused25,unused26,unused27,unused28,unused29,unused30,unused31,unused32,unused33,unused34,unused35,unused36,unused37,unused38,unused39,unused40,unused41,unused42,unused43,unused44,unused45,unused46,unused47,unused48,unused49,unused50,unused51,unused52,unused53,unused54,unused55,unused56,unused57,unused58,unused59,unused60,unused61,unused62,unused63,unused64,unused65,unused66,unused67,unused68,unused69,unused70,unused71,unused72,unused73,unused74,unused75,unused76,unused77,unused78,unused79,unused80,unused81,unused82,unused83,unused84,unused85,unused86,unused87,unused88,unused89,unused90,unused91,unused92,unused93,unused94,unused95,unused96,unused97,unused98,unused99,unused100,unused101,unused102,unused103,unused104,unused105,unused106,unused107,unused108,unused109,unused110,unused111,unused112,unused113,unused114,unused115,unused116,unused117,unused118,unused119,unused120,unused121,unused122,unused123,unused124,unused125,unused126,unused127,unused128,unused129,unused130,unused131,unused132,unused133,unused134,unused135,unused136,unused137,unused138,unused139,unused140,unused141,unused142,unused143,unused144,unused145,unused146,unused147,unused148,unused149,unused150,unused151,unused152,unused153,unused154,unused155,unused156,unused157,unused158,unused159,unused160,unused161,unused162,unused163,unused164,unused165,unused166,unused167,unused168,unused169,unused170,unused171,unused172,unused173,unused174,unused175,unused176,unused177,unused178,unused179,unused180,unused181,unused182,unused183,unused184,unused185,unused186,unused187,unused188,unused189,unused190,unused191,unused192,unused193,unused194,unused195,unused196,unused197,unused198,unused199,unused200,unused201,unused202,unused203,unused204,unused205,unused206,unused207,unused208,unused209,unused210,unused211,unused212,unused213,unused214,unused215,unused216,unused217,unused218,unused219,unused220,unused221,unused222,unused223,unused224,unused225,unused226,unused227,unused228,unused229,unused230,unused231,unused232,unused233,unused234,unused235,unused236,unused237,unused238,unused239,unused240,unused241,unused242,unused243,unused244,unused245,unused246,unused247,unused248,unused249,unused250,unused251,unused252,unused253,unused254,unused255
             * @param target_vmid   The (unique) ID of the VM.
             * @return Result
             */

            public Result moveVmDisk(String disk, Integer bwlimit, Boolean delete, String digest,
                                     String format, String storage, String target_digest, String target_disk,
                                     Integer target_vmid) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("disk", disk);
                parameters.put("bwlimit", bwlimit);
                parameters.put("delete", delete);
                parameters.put("digest", digest);
                parameters.put("format", format);
                parameters.put("storage", storage);
                parameters.put("target-digest", target_digest);
                parameters.put("target-disk", target_disk);
                parameters.put("target-vmid", target_vmid);
                return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/move_disk",
                        parameters);
            }

            /**
             * Move volume to different storage or to a different VM.
             *
             * @param disk The disk you want to move.
             *             Enum:
             *             ide0,ide1,ide2,ide3,scsi0,scsi1,scsi2,scsi3,scsi4,scsi5,scsi6,scsi7,scsi8,scsi9,scsi10,scsi11,scsi12,scsi13,scsi14,scsi15,scsi16,scsi17,scsi18,scsi19,scsi20,scsi21,scsi22,scsi23,scsi24,scsi25,scsi26,scsi27,scsi28,scsi29,scsi30,virtio0,virtio1,virtio2,virtio3,virtio4,virtio5,virtio6,virtio7,virtio8,virtio9,virtio10,virtio11,virtio12,virtio13,virtio14,virtio15,sata0,sata1,sata2,sata3,sata4,sata5,efidisk0,tpmstate0,unused0,unused1,unused2,unused3,unused4,unused5,unused6,unused7,unused8,unused9,unused10,unused11,unused12,unused13,unused14,unused15,unused16,unused17,unused18,unused19,unused20,unused21,unused22,unused23,unused24,unused25,unused26,unused27,unused28,unused29,unused30,unused31,unused32,unused33,unused34,unused35,unused36,unused37,unused38,unused39,unused40,unused41,unused42,unused43,unused44,unused45,unused46,unused47,unused48,unused49,unused50,unused51,unused52,unused53,unused54,unused55,unused56,unused57,unused58,unused59,unused60,unused61,unused62,unused63,unused64,unused65,unused66,unused67,unused68,unused69,unused70,unused71,unused72,unused73,unused74,unused75,unused76,unused77,unused78,unused79,unused80,unused81,unused82,unused83,unused84,unused85,unused86,unused87,unused88,unused89,unused90,unused91,unused92,unused93,unused94,unused95,unused96,unused97,unused98,unused99,unused100,unused101,unused102,unused103,unused104,unused105,unused106,unused107,unused108,unused109,unused110,unused111,unused112,unused113,unused114,unused115,unused116,unused117,unused118,unused119,unused120,unused121,unused122,unused123,unused124,unused125,unused126,unused127,unused128,unused129,unused130,unused131,unused132,unused133,unused134,unused135,unused136,unused137,unused138,unused139,unused140,unused141,unused142,unused143,unused144,unused145,unused146,unused147,unused148,unused149,unused150,unused151,unused152,unused153,unused154,unused155,unused156,unused157,unused158,unused159,unused160,unused161,unused162,unused163,unused164,unused165,unused166,unused167,unused168,unused169,unused170,unused171,unused172,unused173,unused174,unused175,unused176,unused177,unused178,unused179,unused180,unused181,unused182,unused183,unused184,unused185,unused186,unused187,unused188,unused189,unused190,unused191,unused192,unused193,unused194,unused195,unused196,unused197,unused198,unused199,unused200,unused201,unused202,unused203,unused204,unused205,unused206,unused207,unused208,unused209,unused210,unused211,unused212,unused213,unused214,unused215,unused216,unused217,unused218,unused219,unused220,unused221,unused222,unused223,unused224,unused225,unused226,unused227,unused228,unused229,unused230,unused231,unused232,unused233,unused234,unused235,unused236,unused237,unused238,unused239,unused240,unused241,unused242,unused243,unused244,unused245,unused246,unused247,unused248,unused249,unused250,unused251,unused252,unused253,unused254,unused255
             * @return Result
             */

            public Result moveVmDisk(String disk) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("disk", disk);
                return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/move_disk",
                        parameters);
            }

        }

        public static class PVEMigrate {

            private final PveClient client;
            private final Object node;
            private final Object vmid;

            protected PVEMigrate(PveClient client, Object node, Object vmid) {
                this.client = client;
                this.node = node;
                this.vmid = vmid;
            }

            /**
             * Get preconditions for migration.
             *
             * @param target Target node.
             * @return Result
             */

            public Result migrateVmPrecondition(String target) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("target", target);
                return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/migrate", parameters);
            }

            /**
             * Get preconditions for migration.
             *
             * @return Result
             */

            public Result migrateVmPrecondition() {
                return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/migrate", null);
            }

            /**
             * Migrate virtual machine. Creates a new migration task.
             *
             * @param target               Target node.
             * @param bwlimit              Override I/O bandwidth limit (in KiB/s).
             * @param force                Allow to migrate VMs which use local devices.
             *                             Only root may use this option.
             * @param migration_network    CIDR of the (sub) network that is used for
             *                             migration.
             * @param migration_type       Migration traffic is encrypted using an SSH
             *                             tunnel by default. On secure, completely private
             *                             networks this can be disabled to increase
             *                             performance.
             *                             Enum: secure,insecure
             * @param online               Use online/live migration if VM is running.
             *                             Ignored if VM is stopped.
             * @param targetstorage        Mapping from source to target storages. Providing
             *                             only a single storage ID maps all source storages
             *                             to that storage. Providing the special value '1'
             *                             will map each source storage to itself.
             * @param with_conntrack_state Whether to migrate conntrack entries for running
             *                             VMs.
             * @param with_local_disks     Enable live storage migration for local disk
             * @return Result
             */

            public Result migrateVm(String target, Integer bwlimit, Boolean force, String migration_network,
                                    String migration_type, Boolean online, String targetstorage,
                                    Boolean with_conntrack_state, Boolean with_local_disks) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("target", target);
                parameters.put("bwlimit", bwlimit);
                parameters.put("force", force);
                parameters.put("migration_network", migration_network);
                parameters.put("migration_type", migration_type);
                parameters.put("online", online);
                parameters.put("targetstorage", targetstorage);
                parameters.put("with-conntrack-state", with_conntrack_state);
                parameters.put("with-local-disks", with_local_disks);
                return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/migrate", parameters);
            }

            /**
             * Migrate virtual machine. Creates a new migration task.
             *
             * @param target Target node.
             * @return Result
             */

            public Result migrateVm(String target) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("target", target);
                return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/migrate", parameters);
            }

        }

        public static class PVERemoteMigrate {

            private final PveClient client;
            private final Object node;
            private final Object vmid;

            protected PVERemoteMigrate(PveClient client, Object node, Object vmid) {
                this.client = client;
                this.node = node;
                this.vmid = vmid;
            }

            /**
             * Migrate virtual machine to a remote cluster. Creates a new migration task.
             * EXPERIMENTAL feature!
             *
             * @param target_bridge   Mapping from source to target bridges. Providing only
             *                        a single bridge ID maps all source bridges to that
             *                        bridge. Providing the special value '1' will map each
             *                        source bridge to itself.
             * @param target_endpoint Remote target endpoint
             * @param target_storage  Mapping from source to target storages. Providing only
             *                        a single storage ID maps all source storages to that
             *                        storage. Providing the special value '1' will map each
             *                        source storage to itself.
             * @param bwlimit         Override I/O bandwidth limit (in KiB/s).
             * @param delete          Delete the original VM and related data after
             *                        successful migration. By default, the original VM is
             *                        kept on the source cluster in a stopped state.
             * @param online          Use online/live migration if VM is running. Ignored if
             *                        VM is stopped.
             * @param target_vmid     The (unique) ID of the VM.
             * @return Result
             */

            public Result remoteMigrateVm(String target_bridge, String target_endpoint,
                                          String target_storage, Integer bwlimit, Boolean delete, Boolean online,
                                          Integer target_vmid) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("target-bridge", target_bridge);
                parameters.put("target-endpoint", target_endpoint);
                parameters.put("target-storage", target_storage);
                parameters.put("bwlimit", bwlimit);
                parameters.put("delete", delete);
                parameters.put("online", online);
                parameters.put("target-vmid", target_vmid);
                return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/remote_migrate",
                        parameters);
            }

            /**
             * Migrate virtual machine to a remote cluster. Creates a new migration task.
             * EXPERIMENTAL feature!
             *
             * @param target_bridge   Mapping from source to target bridges. Providing only
             *                        a single bridge ID maps all source bridges to that
             *                        bridge. Providing the special value '1' will map each
             *                        source bridge to itself.
             * @param target_endpoint Remote target endpoint
             * @param target_storage  Mapping from source to target storages. Providing only
             *                        a single storage ID maps all source storages to that
             *                        storage. Providing the special value '1' will map each
             *                        source storage to itself.
             * @return Result
             */

            public Result remoteMigrateVm(String target_bridge, String target_endpoint,
                                          String target_storage) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("target-bridge", target_bridge);
                parameters.put("target-endpoint", target_endpoint);
                parameters.put("target-storage", target_storage);
                return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/remote_migrate",
                        parameters);
            }

        }

        public static class PVEMonitor {

            private final PveClient client;
            private final Object node;
            private final Object vmid;

            protected PVEMonitor(PveClient client, Object node, Object vmid) {
                this.client = client;
                this.node = node;
                this.vmid = vmid;
            }

            /**
             * Execute QEMU monitor commands.
             *
             * @param command The monitor command.
             * @return Result
             */

            public Result monitor(String command) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("command", command);
                return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/monitor", parameters);
            }

        }

        public static class PVEResize {

            private final PveClient client;
            private final Object node;
            private final Object vmid;

            protected PVEResize(PveClient client, Object node, Object vmid) {
                this.client = client;
                this.node = node;
                this.vmid = vmid;
            }

            /**
             * Extend volume size.
             *
             * @param disk     The disk you want to resize.
             *                 Enum:
             *                 ide0,ide1,ide2,ide3,scsi0,scsi1,scsi2,scsi3,scsi4,scsi5,scsi6,scsi7,scsi8,scsi9,scsi10,scsi11,scsi12,scsi13,scsi14,scsi15,scsi16,scsi17,scsi18,scsi19,scsi20,scsi21,scsi22,scsi23,scsi24,scsi25,scsi26,scsi27,scsi28,scsi29,scsi30,virtio0,virtio1,virtio2,virtio3,virtio4,virtio5,virtio6,virtio7,virtio8,virtio9,virtio10,virtio11,virtio12,virtio13,virtio14,virtio15,sata0,sata1,sata2,sata3,sata4,sata5,efidisk0,tpmstate0
             * @param size     The new size. With the `+` sign the value is added to the
             *                 actual size of the volume and without it, the value is taken
             *                 as an absolute one. Shrinking disk size is not supported.
             * @param digest   Prevent changes if current configuration file has different
             *                 SHA1 digest. This can be used to prevent concurrent
             *                 modifications.
             * @param skiplock Ignore locks - only root is allowed to use this option.
             * @return Result
             */

            public Result resizeVm(String disk, String size, String digest, Boolean skiplock) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("disk", disk);
                parameters.put("size", size);
                parameters.put("digest", digest);
                parameters.put("skiplock", skiplock);
                return client.set("/nodes/" + this.node + "/qemu/" + this.vmid + "/resize", parameters);
            }

            /**
             * Extend volume size.
             *
             * @param disk The disk you want to resize.
             *             Enum:
             *             ide0,ide1,ide2,ide3,scsi0,scsi1,scsi2,scsi3,scsi4,scsi5,scsi6,scsi7,scsi8,scsi9,scsi10,scsi11,scsi12,scsi13,scsi14,scsi15,scsi16,scsi17,scsi18,scsi19,scsi20,scsi21,scsi22,scsi23,scsi24,scsi25,scsi26,scsi27,scsi28,scsi29,scsi30,virtio0,virtio1,virtio2,virtio3,virtio4,virtio5,virtio6,virtio7,virtio8,virtio9,virtio10,virtio11,virtio12,virtio13,virtio14,virtio15,sata0,sata1,sata2,sata3,sata4,sata5,efidisk0,tpmstate0
             * @param size The new size. With the `+` sign the value is added to the actual
             *             size of the volume and without it, the value is taken as an
             *             absolute one. Shrinking disk size is not supported.
             * @return Result
             */

            public Result resizeVm(String disk, String size) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("disk", disk);
                parameters.put("size", size);
                return client.set("/nodes/" + this.node + "/qemu/" + this.vmid + "/resize", parameters);
            }

        }

        public static class PVESnapshot {

            private final PveClient client;
            private final Object node;
            private final Object vmid;

            protected PVESnapshot(PveClient client, Object node, Object vmid) {
                this.client = client;
                this.node = node;
                this.vmid = vmid;
            }

            public PVEVmidItem.PVESnapshot.PVESnapnameItem get(Object snapname) {
                return new PVESnapnameItem(client, this.node, this.vmid, snapname);
            }

            public static class PVESnapnameItem {

                private final PveClient client;
                private final Object node;
                private final Object vmid;
                private final Object snapname;

                protected PVESnapnameItem(PveClient client, Object node, Object vmid, Object snapname) {
                    this.client = client;
                    this.node = node;
                    this.vmid = vmid;
                    this.snapname = snapname;
                }

                private PVEVmidItem.PVESnapshot.PVESnapnameItem.PVEConfig config;

                public PVEVmidItem.PVESnapshot.PVESnapnameItem.PVEConfig getConfig() {
                    return config == null
                            ? (config = new PVEConfig(client, this.node, this.vmid, this.snapname))
                            : config;
                }

                private PVEVmidItem.PVESnapshot.PVESnapnameItem.PVERollback rollback;

                public PVEVmidItem.PVESnapshot.PVESnapnameItem.PVERollback getRollback() {
                    return rollback == null
                            ? (rollback = new PVERollback(client, this.node, this.vmid, this.snapname))
                            : rollback;
                }

                public static class PVEConfig {

                    private final PveClient client;
                    private final Object node;
                    private final Object vmid;
                    private final Object snapname;

                    protected PVEConfig(PveClient client, Object node, Object vmid, Object snapname) {
                        this.client = client;
                        this.node = node;
                        this.vmid = vmid;
                        this.snapname = snapname;
                    }

                    /**
                     * Get snapshot configuration
                     *
                     * @return Result
                     */

                    public Result getSnapshotConfig() {
                        return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/snapshot/"
                                + this.snapname + "/config", null);
                    }

                    /**
                     * Update snapshot metadata.
                     *
                     * @param description A textual description or comment.
                     * @return Result
                     */

                    public Result updateSnapshotConfig(String description) {
                        Map<String, Object> parameters = new HashMap<>();
                        parameters.put("description", description);
                        return client.set("/nodes/" + this.node + "/qemu/" + this.vmid + "/snapshot/"
                                + this.snapname + "/config", parameters);
                    }

                    /**
                     * Update snapshot metadata.
                     *
                     * @return Result
                     */

                    public Result updateSnapshotConfig() {
                        return client.set("/nodes/" + this.node + "/qemu/" + this.vmid + "/snapshot/"
                                + this.snapname + "/config", null);
                    }

                }

                public static class PVERollback {

                    private final PveClient client;
                    private final Object node;
                    private final Object vmid;
                    private final Object snapname;

                    protected PVERollback(PveClient client, Object node, Object vmid, Object snapname) {
                        this.client = client;
                        this.node = node;
                        this.vmid = vmid;
                        this.snapname = snapname;
                    }

                    /**
                     * Rollback VM state to specified snapshot.
                     *
                     * @param start Whether the VM should get started after rolling back
                     *              successfully. (Note: VMs will be automatically started if the
                     *              snapshot includes RAM.)
                     * @return Result
                     */

                    public Result rollback(Boolean start) {
                        Map<String, Object> parameters = new HashMap<>();
                        parameters.put("start", start);
                        return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/snapshot/"
                                + this.snapname + "/rollback", parameters);
                    }

                    /**
                     * Rollback VM state to specified snapshot.
                     *
                     * @return Result
                     */

                    public Result rollback() {
                        return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/snapshot/"
                                + this.snapname + "/rollback", null);
                    }

                }

                /**
                 * Delete a VM snapshot.
                 *
                 * @param force For removal from config file, even if removing disk snapshots
                 *              fails.
                 * @return Result
                 */

                public Result delsnapshot(Boolean force) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("force", force);
                    return client.delete("/nodes/" + this.node + "/qemu/" + this.vmid + "/snapshot/"
                            + this.snapname, parameters);
                }

                /**
                 * Delete a VM snapshot.
                 *
                 * @return Result
                 */

                public Result delsnapshot() {
                    return client.delete("/nodes/" + this.node + "/qemu/" + this.vmid + "/snapshot/"
                            + this.snapname, null);
                }

                /**
                 *
                 * @return Result
                 */

                public Result snapshotCmdIdx() {
                    return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/snapshot/"
                            + this.snapname, null);
                }

            }

            /**
             * List all snapshots.
             *
             * @return Result
             */

            public Result snapshotList() {
                return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/snapshot", null);
            }

            /**
             * Snapshot a VM.
             *
             * @param snapname    The name of the snapshot.
             * @param description A textual description or comment.
             * @param vmstate     Save the vmstate
             * @return Result
             */

            public Result snapshot(String snapname, String description, Boolean vmstate) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("snapname", snapname);
                parameters.put("description", description);
                parameters.put("vmstate", vmstate);
                return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/snapshot",
                        parameters);
            }

            /**
             * Snapshot a VM.
             *
             * @param snapname The name of the snapshot.
             * @return Result
             */

            public Result snapshot(String snapname) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("snapname", snapname);
                return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/snapshot",
                        parameters);
            }

        }

        public static class PVETemplate {

            private final PveClient client;
            private final Object node;
            private final Object vmid;

            protected PVETemplate(PveClient client, Object node, Object vmid) {
                this.client = client;
                this.node = node;
                this.vmid = vmid;
            }

            /**
             * Create a Template.
             *
             * @param disk If you want to convert only 1 disk to base image.
             *             Enum:
             *             ide0,ide1,ide2,ide3,scsi0,scsi1,scsi2,scsi3,scsi4,scsi5,scsi6,scsi7,scsi8,scsi9,scsi10,scsi11,scsi12,scsi13,scsi14,scsi15,scsi16,scsi17,scsi18,scsi19,scsi20,scsi21,scsi22,scsi23,scsi24,scsi25,scsi26,scsi27,scsi28,scsi29,scsi30,virtio0,virtio1,virtio2,virtio3,virtio4,virtio5,virtio6,virtio7,virtio8,virtio9,virtio10,virtio11,virtio12,virtio13,virtio14,virtio15,sata0,sata1,sata2,sata3,sata4,sata5,efidisk0,tpmstate0
             * @return Result
             */

            public Result template(String disk) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("disk", disk);
                return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/template",
                        parameters);
            }

            /**
             * Create a Template.
             *
             * @return Result
             */

            public Result template() {
                return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/template", null);
            }

        }

        public static class PVEMtunnel {

            private final PveClient client;
            private final Object node;
            private final Object vmid;

            protected PVEMtunnel(PveClient client, Object node, Object vmid) {
                this.client = client;
                this.node = node;
                this.vmid = vmid;
            }

            /**
             * Migration tunnel endpoint - only for internal use by VM migration.
             *
             * @param bridges  List of network bridges to check availability. Will be
             *                 checked again for actually used bridges during migration.
             * @param storages List of storages to check permission and availability. Will
             *                 be checked again for all actually used storages during
             *                 migration.
             * @return Result
             */

            public Result mtunnel(String bridges, String storages) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("bridges", bridges);
                parameters.put("storages", storages);
                return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/mtunnel", parameters);
            }

            /**
             * Migration tunnel endpoint - only for internal use by VM migration.
             *
             * @return Result
             */

            public Result mtunnel() {
                return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/mtunnel", null);
            }

        }

        public static class PVEMtunnelwebsocket {

            private final PveClient client;
            private final Object node;
            private final Object vmid;

            protected PVEMtunnelwebsocket(PveClient client, Object node, Object vmid) {
                this.client = client;
                this.node = node;
                this.vmid = vmid;
            }

            /**
             * Migration tunnel endpoint for websocket upgrade - only for internal use by VM
             * migration.
             *
             * @param socket unix socket to forward to
             * @param ticket ticket return by initial 'mtunnel' API call, or retrieved via
             *               'ticket' tunnel command
             * @return Result
             */

            public Result mtunnelwebsocket(String socket, String ticket) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("socket", socket);
                parameters.put("ticket", ticket);
                return client.get("/nodes/" + this.node + "/qemu/" + this.vmid + "/mtunnelwebsocket",
                        parameters);
            }

        }

        public static class PVEDbusVmstate {

            private final PveClient client;
            private final Object node;
            private final Object vmid;

            protected PVEDbusVmstate(PveClient client, Object node, Object vmid) {
                this.client = client;
                this.node = node;
                this.vmid = vmid;
            }

            /**
             * Control the dbus-vmstate helper for a given running VM.
             *
             * @param action Action to perform on the DBus VMState helper.
             *               Enum: start,stop
             * @return Result
             */

            public Result dbusVmstate(String action) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("action", action);
                return client.create("/nodes/" + this.node + "/qemu/" + this.vmid + "/dbus-vmstate",
                        parameters);
            }

        }

        /**
         * Destroy the VM and all used/owned volumes. Removes any VM specific
         * permissions and firewall rules
         *
         * @param destroy_unreferenced_disks If set, destroy additionally all disks not
         *                                   referenced in the config but with a
         *                                   matching VMID from all enabled storages.
         * @param purge                      Remove VMID from configurations, like
         *                                   backup &amp; replication jobs and HA.
         * @param skiplock                   Ignore locks - only root is allowed to use
         *                                   this option.
         * @return Result
         */

        public Result destroyVm(Boolean destroy_unreferenced_disks, Boolean purge, Boolean skiplock) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("destroy-unreferenced-disks", destroy_unreferenced_disks);
            parameters.put("purge", purge);
            parameters.put("skiplock", skiplock);
            return client.delete("/nodes/" + this.node + "/qemu/" + this.vmid, parameters);
        }

        /**
         * Destroy the VM and all used/owned volumes. Removes any VM specific
         * permissions and firewall rules
         *
         * @return Result
         */

        public Result destroyVm() {
            return client.delete("/nodes/" + this.node + "/qemu/" + this.vmid, null);
        }

        /**
         * Directory index
         *
         * @return Result
         */

        public Result vmdiridx() {
            return client.get("/nodes/" + this.node + "/qemu/" + this.vmid, null);
        }

    }

    /**
     * Virtual machine index (per node).
     *
     * @param full Determine the full status of active VMs.
     * @return Result
     */

    public Result vmlist(Boolean full) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("full", full);
        return client.get("/nodes/" + this.node + "/qemu", parameters);
    }

    /**
     * Virtual machine index (per node).
     *
     * @return Result
     */

    public Result vmlist() {
        return client.get("/nodes/" + this.node + "/qemu", null);
    }

    /**
     * Create or restore a virtual machine.
     *
     * @param vmid                   The (unique) ID of the VM.
     * @param acpi                   Enable/disable ACPI.
     * @param affinity               List of host cores used to execute guest
     *                               processes, for example: 0,5,8-11
     * @param agent                  Enable/disable communication with the QEMU
     *                               Guest Agent and its properties.
     * @param allow_ksm              Allow memory pages of this guest to be merged
     *                               via KSM (Kernel Samepage Merging).
     * @param amd_sev                Secure Encrypted Virtualization (SEV) features
     *                               by AMD CPUs
     * @param arch                   Virtual processor architecture. Defaults to the
     *                               host.
     *                               Enum: x86_64,aarch64
     * @param archive                The backup archive. Either the file system path
     *                               to a .tar or .vma file (use '-' to pipe data
     *                               from stdin) or a proxmox storage backup volume
     *                               identifier.
     * @param args                   Arbitrary arguments passed to kvm.
     * @param audio0                 Configure an audio device, useful in combination
     *                               with QXL/Spice.
     * @param autostart              Automatic restart after crash (currently
     *                               ignored).
     * @param balloon                Amount of target RAM for the VM in MiB. Using
     *                               zero disables the ballon driver.
     * @param bios                   Select BIOS implementation.
     *                               Enum: seabios,ovmf
     * @param boot                   Specify guest boot order. Use the 'order='
     *                               sub-property as usage with no key or 'legacy='
     *                               is deprecated.
     * @param bootdisk               Enable booting from specified disk. Deprecated:
     *                               Use 'boot: order=foo;bar' instead.
     * @param bwlimit                Override I/O bandwidth limit (in KiB/s).
     * @param cdrom                  This is an alias for option -ide2
     * @param cicustom               cloud-init: Specify custom files to replace the
     *                               automatically generated ones at start.
     * @param cipassword             cloud-init: Password to assign the user. Using
     *                               this is generally not recommended. Use ssh keys
     *                               instead. Also note that older cloud-init
     *                               versions do not support hashed passwords.
     * @param citype                 Specifies the cloud-init configuration format.
     *                               The default depends on the configured operating
     *                               system type (`ostype`). We use the `nocloud`
     *                               format for Linux, and `configdrive2` for
     *                               windows.
     *                               Enum: configdrive2,nocloud,opennebula
     * @param ciupgrade              cloud-init: do an automatic package upgrade
     *                               after the first boot.
     * @param ciuser                 cloud-init: Username to change ssh keys and
     *                               password for instead of the image's configured
     *                               default user.
     * @param cores                  The number of cores per socket.
     * @param cpu                    Emulated CPU type.
     * @param cpulimit               Limit of CPU usage.
     * @param cpuunits               CPU weight for a VM, will be clamped to [1,
     *                               10000] in cgroup v2.
     * @param description            Description for the VM. Shown in the
     *                               web-interface VM's summary. This is saved as
     *                               comment inside the configuration file.
     * @param efidisk0               Configure a disk for storing EFI vars. Use the
     *                               special syntax STORAGE_ID:SIZE_IN_GiB to
     *                               allocate a new volume. Note that SIZE_IN_GiB is
     *                               ignored here and that the default EFI vars are
     *                               copied to the volume instead. Use STORAGE_ID:0
     *                               and the 'import-from' parameter to import from
     *                               an existing volume.
     * @param force                  Allow to overwrite existing VM.
     * @param freeze                 Freeze CPU at startup (use 'c' monitor command
     *                               to start execution).
     * @param ha_managed             Add the VM as a HA resource after it was
     *                               created.
     * @param hookscript             Script that will be executed during various
     *                               steps in the vms lifetime.
     * @param hostpciN               Map host PCI devices into guest.
     * @param hotplug                Selectively enable hotplug features. This is a
     *                               comma separated list of hotplug features:
     *                               'network', 'disk', 'cpu', 'memory', 'usb' and
     *                               'cloudinit'. Use '0' to disable hotplug
     *                               completely. Using '1' as value is an alias for
     *                               the default `network,disk,usb`. USB hotplugging
     *                               is possible for guests with machine version
     *                               &amp;gt;= 7.1 and ostype l26 or windows
     *                               &amp;gt; 7.
     * @param hugepages              Enables hugepages memory. Sets the size of
     *                               hugepages in MiB. If the value is set to 'any'
     *                               then 1 GiB hugepages will be used if possible,
     *                               otherwise the size will fall back to 2 MiB.
     *                               Enum: any,2,1024
     * @param ideN                   Use volume as IDE hard disk or CD-ROM (n is 0
     *                               to 3). Use the special syntax
     *                               STORAGE_ID:SIZE_IN_GiB to allocate a new
     *                               volume. Use STORAGE_ID:0 and the 'import-from'
     *                               parameter to import from an existing volume.
     * @param import_working_storage A file-based storage with 'images' content-type
     *                               enabled, which is used as an intermediary
     *                               extraction storage during import. Defaults to
     *                               the source storage.
     * @param intel_tdx              Trusted Domain Extension (TDX) features by
     *                               Intel CPUs
     * @param ipconfigN              cloud-init: Specify IP addresses and gateways
     *                               for the corresponding interface. IP addresses
     *                               use CIDR notation, gateways are optional but
     *                               need an IP of the same type specified. The
     *                               special string 'dhcp' can be used for IP
     *                               addresses to use DHCP, in which case no
     *                               explicit gateway should be provided. For IPv6
     *                               the special string 'auto' can be used to use
     *                               stateless autoconfiguration. This requires
     *                               cloud-init 19.4 or newer. If cloud-init is
     *                               enabled and neither an IPv4 nor an IPv6 address
     *                               is specified, it defaults to using dhcp on
     *                               IPv4.
     * @param ivshmem                Inter-VM shared memory. Useful for direct
     *                               communication between VMs, or to the host.
     * @param keephugepages          Use together with hugepages. If enabled,
     *                               hugepages will not be deleted after VM
     *                               shutdown and can be used for subsequent starts.
     * @param keyboard               Keyboard layout for VNC server. This option is
     *                               generally not required and is often better
     *                               handled from within the guest OS.
     *                               Enum:
     *                               de,de-ch,da,en-gb,en-us,es,fi,fr,fr-be,fr-ca,fr-ch,hu,is,it,ja,lt,mk,nl,no,pl,pt,pt-br,sv,sl,tr
     * @param kvm                    Enable/disable KVM hardware virtualization.
     * @param live_restore           Start the VM immediately while importing or
     *                               restoring in the background.
     * @param localtime              Set the real time clock (RTC) to local time.
     *                               This is enabled by default if the `ostype`
     *                               indicates a Microsoft Windows OS.
     * @param lock_                  Lock/unlock the VM.
     *                               Enum:
     *                               backup,clone,create,migrate,rollback,snapshot,snapshot-delete,suspending,suspended
     * @param machine                Specify the QEMU machine.
     * @param memory                 Memory properties.
     * @param migrate_downtime       Set maximum tolerated downtime (in seconds) for
     *                               migrations. Should the migration not be able to
     *                               converge in the very end, because too much
     *                               newly dirtied RAM needs to be transferred, the
     *                               limit will be increased automatically
     *                               step-by-step until migration can converge.
     * @param migrate_speed          Set maximum speed (in MB/s) for migrations.
     *                               Value 0 is no limit.
     * @param name                   Set a name for the VM. Only used on the
     *                               configuration web interface.
     * @param nameserver             cloud-init: Sets DNS server IP address for a
     *                               container. Create will automatically use the
     *                               setting from the host if neither searchdomain
     *                               nor nameserver are set.
     * @param netN                   Specify network devices.
     * @param numa                   Enable/disable NUMA.
     * @param numaN                  NUMA topology.
     * @param onboot                 Specifies whether a VM will be started during
     *                               system bootup.
     * @param ostype                 Specify guest operating system.
     *                               Enum:
     *                               other,wxp,w2k,w2k3,w2k8,wvista,win7,win8,win10,win11,l24,l26,solaris
     * @param parallelN              Map host parallel devices (n is 0 to 2).
     * @param pool                   Add the VM to the specified pool.
     * @param protection             Sets the protection flag of the VM. This will
     *                               disable the remove VM and remove disk
     *                               operations.
     * @param reboot                 Allow reboot. If set to '0' the VM exit on
     *                               reboot.
     * @param rng0                   Configure a VirtIO-based Random Number
     *                               Generator.
     * @param sataN                  Use volume as SATA hard disk or CD-ROM (n is 0
     *                               to 5). Use the special syntax
     *                               STORAGE_ID:SIZE_IN_GiB to allocate a new
     *                               volume. Use STORAGE_ID:0 and the 'import-from'
     *                               parameter to import from an existing volume.
     * @param scsiN                  Use volume as SCSI hard disk or CD-ROM (n is 0
     *                               to 30). Use the special syntax
     *                               STORAGE_ID:SIZE_IN_GiB to allocate a new
     *                               volume. Use STORAGE_ID:0 and the 'import-from'
     *                               parameter to import from an existing volume.
     * @param scsihw                 SCSI controller model
     *                               Enum:
     *                               lsi,lsi53c810,virtio-scsi-pci,virtio-scsi-single,megasas,pvscsi
     * @param searchdomain           cloud-init: Sets DNS search domains for a
     *                               container. Create will automatically use the
     *                               setting from the host if neither searchdomain
     *                               nor nameserver are set.
     * @param serialN                Create a serial device inside the VM (n is 0 to
     *                               3)
     * @param shares                 Amount of memory shares for auto-ballooning.
     *                               The larger the number is, the more memory this
     *                               VM gets. Number is relative to weights of all
     *                               other running VMs. Using zero disables
     *                               auto-ballooning. Auto-ballooning is done by
     *                               pvestatd.
     * @param smbios1                Specify SMBIOS type 1 fields.
     * @param smp                    The number of CPUs. Please use option -sockets
     *                               instead.
     * @param sockets                The number of CPU sockets.
     * @param spice_enhancements     Configure additional enhancements for SPICE.
     * @param sshkeys                cloud-init: Setup public SSH keys (one key per
     *                               line, OpenSSH format).
     * @param start                  Start VM after it was created successfully.
     * @param startdate              Set the initial date of the real time clock.
     *                               Valid format for date are:'now' or
     *                               '2006-06-17T16:01:21' or '2006-06-17'.
     * @param startup                Startup and shutdown behavior. Order is a
     *                               non-negative number defining the general
     *                               startup order. Shutdown in done with reverse
     *                               ordering. Additionally, you can set the 'up' or
     *                               'down' delay in seconds, which specifies a
     *                               delay to wait before the next VM is started or
     *                               stopped.
     * @param storage                Default storage.
     * @param tablet                 Enable/disable the USB tablet device.
     * @param tags                   Tags of the VM. This is only meta information.
     * @param tdf                    Enable/disable time drift fix.
     * @param template               Enable/disable Template.
     * @param tpmstate0              Configure a Disk for storing TPM state. The
     *                               format is fixed to 'raw'. Use the special
     *                               syntax STORAGE_ID:SIZE_IN_GiB to allocate a new
     *                               volume. Note that SIZE_IN_GiB is ignored here
     *                               and 4 MiB will be used instead. Use
     *                               STORAGE_ID:0 and the 'import-from' parameter to
     *                               import from an existing volume.
     * @param unique                 Assign a unique random ethernet address.
     * @param unusedN                Reference to unused volumes. This is used
     *                               internally, and should not be modified
     *                               manually.
     * @param usbN                   Configure a USB device (n is 0 to 4, for
     *                               machine version &amp;gt;= 7.1 and ostype l26 or
     *                               windows &amp;gt; 7, n can be up to 14).
     * @param vcpus                  Number of hotplugged vcpus.
     * @param vga                    Configure the VGA hardware.
     * @param virtioN                Use volume as VIRTIO hard disk (n is 0 to 15).
     *                               Use the special syntax STORAGE_ID:SIZE_IN_GiB
     *                               to allocate a new volume. Use STORAGE_ID:0 and
     *                               the 'import-from' parameter to import from an
     *                               existing volume.
     * @param virtiofsN              Configuration for sharing a directory between
     *                               host and guest using Virtio-fs.
     * @param vmgenid                Set VM Generation ID. Use '1' to autogenerate
     *                               on create or update, pass '0' to disable
     *                               explicitly.
     * @param vmstatestorage         Default storage for VM state volumes/files.
     * @param watchdog               Create a virtual hardware watchdog device.
     * @return Result
     */

    public Result createVm(int vmid, Boolean acpi, String affinity, String agent, Boolean allow_ksm,
                           String amd_sev, String arch, String archive, String args, String audio0, Boolean autostart,
                           Integer balloon, String bios, String boot, String bootdisk, Integer bwlimit, String cdrom,
                           String cicustom, String cipassword, String citype, Boolean ciupgrade, String ciuser,
                           Integer cores, String cpu, Float cpulimit, Integer cpuunits, String description,
                           String efidisk0, Boolean force, Boolean freeze, Boolean ha_managed, String hookscript,
                           Map<Integer, String> hostpciN, String hotplug, String hugepages, Map<Integer, String> ideN,
                           String import_working_storage, String intel_tdx, Map<Integer, String> ipconfigN, String ivshmem,
                           Boolean keephugepages, String keyboard, Boolean kvm, Boolean live_restore, Boolean localtime,
                           String lock_, String machine, String memory, Float migrate_downtime, Integer migrate_speed,
                           String name, String nameserver, Map<Integer, String> netN, Boolean numa,
                           Map<Integer, String> numaN, Boolean onboot, String ostype, Map<Integer, String> parallelN,
                           String pool, Boolean protection, Boolean reboot, String rng0, Map<Integer, String> sataN,
                           Map<Integer, String> scsiN, String scsihw, String searchdomain, Map<Integer, String> serialN,
                           Integer shares, String smbios1, Integer smp, Integer sockets, String spice_enhancements,
                           String sshkeys, Boolean start, String startdate, String startup, String storage, Boolean tablet,
                           String tags, Boolean tdf, Boolean template, String tpmstate0, Boolean unique,
                           Map<Integer, String> unusedN, Map<Integer, String> usbN, Integer vcpus, String vga,
                           Map<Integer, String> virtioN, Map<Integer, String> virtiofsN, String vmgenid,
                           String vmstatestorage, String watchdog) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("vmid", vmid);
        parameters.put("acpi", acpi);
        parameters.put("affinity", affinity);
        parameters.put("agent", agent);
        parameters.put("allow-ksm", allow_ksm);
        parameters.put("amd-sev", amd_sev);
        parameters.put("arch", arch);
        parameters.put("archive", archive);
        parameters.put("args", args);
        parameters.put("audio0", audio0);
        parameters.put("autostart", autostart);
        parameters.put("balloon", balloon);
        parameters.put("bios", bios);
        parameters.put("boot", boot);
        parameters.put("bootdisk", bootdisk);
        parameters.put("bwlimit", bwlimit);
        parameters.put("cdrom", cdrom);
        parameters.put("cicustom", cicustom);
        parameters.put("cipassword", cipassword);
        parameters.put("citype", citype);
        parameters.put("ciupgrade", ciupgrade);
        parameters.put("ciuser", ciuser);
        parameters.put("cores", cores);
        parameters.put("cpu", cpu);
        parameters.put("cpulimit", cpulimit);
        parameters.put("cpuunits", cpuunits);
        parameters.put("description", description);
        parameters.put("efidisk0", efidisk0);
        parameters.put("force", force);
        parameters.put("freeze", freeze);
        parameters.put("ha-managed", ha_managed);
        parameters.put("hookscript", hookscript);
        parameters.put("hotplug", hotplug);
        parameters.put("hugepages", hugepages);
        parameters.put("import-working-storage", import_working_storage);
        parameters.put("intel-tdx", intel_tdx);
        parameters.put("ivshmem", ivshmem);
        parameters.put("keephugepages", keephugepages);
        parameters.put("keyboard", keyboard);
        parameters.put("kvm", kvm);
        parameters.put("live-restore", live_restore);
        parameters.put("localtime", localtime);
        parameters.put("lock", lock_);
        parameters.put("machine", machine);
        parameters.put("memory", memory);
        parameters.put("migrate_downtime", migrate_downtime);
        parameters.put("migrate_speed", migrate_speed);
        parameters.put("name", name);
        parameters.put("nameserver", nameserver);
        parameters.put("numa", numa);
        parameters.put("onboot", onboot);
        parameters.put("ostype", ostype);
        parameters.put("pool", pool);
        parameters.put("protection", protection);
        parameters.put("reboot", reboot);
        parameters.put("rng0", rng0);
        parameters.put("scsihw", scsihw);
        parameters.put("searchdomain", searchdomain);
        parameters.put("shares", shares);
        parameters.put("smbios1", smbios1);
        parameters.put("smp", smp);
        parameters.put("sockets", sockets);
        parameters.put("spice_enhancements", spice_enhancements);
        parameters.put("sshkeys", sshkeys);
        parameters.put("start", start);
        parameters.put("startdate", startdate);
        parameters.put("startup", startup);
        parameters.put("storage", storage);
        parameters.put("tablet", tablet);
        parameters.put("tags", tags);
        parameters.put("tdf", tdf);
        parameters.put("template", template);
        parameters.put("tpmstate0", tpmstate0);
        parameters.put("unique", unique);
        parameters.put("vcpus", vcpus);
        parameters.put("vga", vga);
        parameters.put("vmgenid", vmgenid);
        parameters.put("vmstatestorage", vmstatestorage);
        parameters.put("watchdog", watchdog);
        PveClientBase.addIndexedParameter(parameters, "hostpci", hostpciN);
        PveClientBase.addIndexedParameter(parameters, "ide", ideN);
        PveClientBase.addIndexedParameter(parameters, "ipconfig", ipconfigN);
        PveClientBase.addIndexedParameter(parameters, "net", netN);
        PveClientBase.addIndexedParameter(parameters, "numa", numaN);
        PveClientBase.addIndexedParameter(parameters, "parallel", parallelN);
        PveClientBase.addIndexedParameter(parameters, "sata", sataN);
        PveClientBase.addIndexedParameter(parameters, "scsi", scsiN);
        PveClientBase.addIndexedParameter(parameters, "serial", serialN);
        PveClientBase.addIndexedParameter(parameters, "unused", unusedN);
        PveClientBase.addIndexedParameter(parameters, "usb", usbN);
        PveClientBase.addIndexedParameter(parameters, "virtio", virtioN);
        PveClientBase.addIndexedParameter(parameters, "virtiofs", virtiofsN);
        return client.create("/nodes/" + this.node + "/qemu", parameters);
    }

    /**
     * Create or restore a virtual machine.
     *
     * @param vmid       The (unique) ID of the VM.
     * @param parameters Map with VM Parameters
     * @return Result
     */
    public Result createVm(final int vmid, final Map<String, Object> parameters) {
        parameters.put("vmid", vmid);
        return client.create("/nodes/" + this.node + "/qemu", parameters);
    }

    /**
     * Create or restore a virtual machine.
     *
     * @param vmid The (unique) ID of the VM.
     * @return Result
     */

    public Result createVm(int vmid) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("vmid", vmid);
        return client.create("/nodes/" + this.node + "/qemu", parameters);
    }

}

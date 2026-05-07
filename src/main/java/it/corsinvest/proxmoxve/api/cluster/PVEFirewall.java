package it.corsinvest.proxmoxve.api.cluster;

import it.corsinvest.proxmoxve.api.PveClient;
import it.corsinvest.proxmoxve.api.Result;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class PVEFirewall {

    private final PveClient client;

    public PVEFirewall(PveClient client) {
        this.client = client;

    }

    private PVEGroups groups;

    public PVEGroups getGroups() {
        return groups == null ? (groups = new PVEGroups(client)) : groups;
    }

    private PVERules rules;

    public PVERules getRules() {
        return rules == null ? (rules = new PVERules(client)) : rules;
    }

    private PVEIpset ipset;

    public PVEIpset getIpset() {
        return ipset == null ? (ipset = new PVEIpset(client)) : ipset;
    }

    private PVEAliases aliases;

    public PVEAliases getAliases() {
        return aliases == null ? (aliases = new PVEAliases(client)) : aliases;
    }

    private PVEOptions options;

    public PVEOptions getOptions() {
        return options == null ? (options = new PVEOptions(client)) : options;
    }

    private PVEMacros macros;

    public PVEMacros getMacros() {
        return macros == null ? (macros = new PVEMacros(client)) : macros;
    }

    private PVERefs refs;

    public PVERefs getRefs() {
        return refs == null ? (refs = new PVERefs(client)) : refs;
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

            public PVEGroups.PVEGroupItem.PVEPosItem get(Object pos) {
                return new PVEPosItem(client, this.group, pos);
            }

            public static class PVEPosItem {

                private final PveClient client;
                private final Object group;
                private final Object pos;

                protected PVEPosItem(PveClient client, Object group, Object pos) {
                    this.client = client;
                    this.group = group;
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
                    return client.delete("/cluster/firewall/groups/" + this.group + "/" + this.pos,
                            parameters);
                }

                /**
                 * Delete rule.
                 *
                 * @return Result
                 */

                public Result deleteRule() {
                    return client.delete("/cluster/firewall/groups/" + this.group + "/" + this.pos, null);
                }

                /**
                 * Get single rule data.
                 *
                 * @return Result
                 */

                public Result getRule() {
                    return client.get("/cluster/firewall/groups/" + this.group + "/" + this.pos, null);
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
                                         String digest, String dport, Integer enable, String icmp_type, String iface, String log,
                                         String macro, Integer moveto, String proto, String source, String sport, String type) {
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
                    return client.set("/cluster/firewall/groups/" + this.group + "/" + this.pos,
                            parameters);
                }

                /**
                 * Modify rule data.
                 *
                 * @return Result
                 */

                public Result updateRule() {
                    return client.set("/cluster/firewall/groups/" + this.group + "/" + this.pos, null);
                }

            }

            /**
             * Delete security group.
             *
             * @return Result
             */

            public Result deleteSecurityGroup() {
                return client.delete("/cluster/firewall/groups/" + this.group, null);
            }

            /**
             * List rules.
             *
             * @return Result
             */

            public Result getRules() {
                return client.get("/cluster/firewall/groups/" + this.group, null);
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

            public Result createRule(String action, String type, String comment, String dest, String digest,
                                     String dport, Integer enable, String icmp_type, String iface, String log, String macro,
                                     Integer pos, String proto, String source, String sport) {
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
                return client.create("/cluster/firewall/groups/" + this.group, parameters);
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
                return client.create("/cluster/firewall/groups/" + this.group, parameters);
            }

        }

        /**
         * List security groups.
         *
         * @return Result
         */

        public Result listSecurityGroups() {
            return client.get("/cluster/firewall/groups", null);
        }

        /**
         * Create new security group.
         *
         * @param group   Security Group name.
         * @param comment
         * @param digest  Prevent changes if current configuration file has a different
         *                digest. This can be used to prevent concurrent modifications.
         * @param rename  Rename/update an existing security group. You can set 'rename'
         *                to the same value as 'name' to update the 'comment' of an
         *                existing group.
         * @return Result
         */

        public Result createSecurityGroup(String group, String comment, String digest, String rename) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("group", group);
            parameters.put("comment", comment);
            parameters.put("digest", digest);
            parameters.put("rename", rename);
            return client.create("/cluster/firewall/groups", parameters);
        }

        /**
         * Create new security group.
         *
         * @param group Security Group name.
         * @return Result
         */

        public Result createSecurityGroup(String group) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("group", group);
            return client.create("/cluster/firewall/groups", parameters);
        }

    }

    public static class PVERules {

        private final PveClient client;

        protected PVERules(PveClient client) {
            this.client = client;

        }

        public PVERules.PVEPosItem get(Object pos) {
            return new PVEPosItem(client, pos);
        }

        public static class PVEPosItem {

            private final PveClient client;
            private final Object pos;

            protected PVEPosItem(PveClient client, Object pos) {
                this.client = client;
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
                return client.delete("/cluster/firewall/rules/" + this.pos, parameters);
            }

            /**
             * Delete rule.
             *
             * @return Result
             */

            public Result deleteRule() {
                return client.delete("/cluster/firewall/rules/" + this.pos, null);
            }

            /**
             * Get single rule data.
             *
             * @return Result
             */

            public Result getRule() {
                return client.get("/cluster/firewall/rules/" + this.pos, null);
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

            public Result updateRule(String action, String comment, String delete, String dest, String digest,
                                     String dport, Integer enable, String icmp_type, String iface, String log, String macro,
                                     Integer moveto, String proto, String source, String sport, String type) {
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
                return client.set("/cluster/firewall/rules/" + this.pos, parameters);
            }

            /**
             * Modify rule data.
             *
             * @return Result
             */

            public Result updateRule() {
                return client.set("/cluster/firewall/rules/" + this.pos, null);
            }

        }

        /**
         * List rules.
         *
         * @return Result
         */

        public Result getRules() {
            return client.get("/cluster/firewall/rules", null);
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

        public Result createRule(String action, String type, String comment, String dest, String digest,
                                 String dport, Integer enable, String icmp_type, String iface, String log, String macro,
                                 Integer pos, String proto, String source, String sport) {
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
            return client.create("/cluster/firewall/rules", parameters);
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
            return client.create("/cluster/firewall/rules", parameters);
        }

    }

    public static class PVEIpset {

        private final PveClient client;

        protected PVEIpset(PveClient client) {
            this.client = client;

        }

        public PVEIpset.PVENameItem get(Object name) {
            return new PVENameItem(client, name);
        }

        public static class PVENameItem {

            private final PveClient client;
            private final Object name;

            protected PVENameItem(PveClient client, Object name) {
                this.client = client;
                this.name = name;
            }

            public PVEIpset.PVENameItem.PVECidrItem get(Object cidr) {
                return new PVECidrItem(client, this.name, cidr);
            }

            public static class PVECidrItem {

                private final PveClient client;
                private final Object name;
                private final Object cidr;

                protected PVECidrItem(PveClient client, Object name, Object cidr) {
                    this.client = client;
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
                    return client.delete("/cluster/firewall/ipset/" + this.name + "/" + this.cidr,
                            parameters);
                }

                /**
                 * Remove IP or Network from IPSet.
                 *
                 * @return Result
                 */

                public Result removeIp() {
                    return client.delete("/cluster/firewall/ipset/" + this.name + "/" + this.cidr, null);
                }

                /**
                 * Read IP or Network settings from IPSet.
                 *
                 * @return Result
                 */

                public Result readIp() {
                    return client.get("/cluster/firewall/ipset/" + this.name + "/" + this.cidr, null);
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
                    return client.set("/cluster/firewall/ipset/" + this.name + "/" + this.cidr,
                            parameters);
                }

                /**
                 * Update IP or Network settings
                 *
                 * @return Result
                 */

                public Result updateIp() {
                    return client.set("/cluster/firewall/ipset/" + this.name + "/" + this.cidr, null);
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
                return client.delete("/cluster/firewall/ipset/" + this.name, parameters);
            }

            /**
             * Delete IPSet
             *
             * @return Result
             */

            public Result deleteIpset() {
                return client.delete("/cluster/firewall/ipset/" + this.name, null);
            }

            /**
             * List IPSet content
             *
             * @return Result
             */

            public Result getIpset() {
                return client.get("/cluster/firewall/ipset/" + this.name, null);
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
                return client.create("/cluster/firewall/ipset/" + this.name, parameters);
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
                return client.create("/cluster/firewall/ipset/" + this.name, parameters);
            }

        }

        /**
         * List IPSets
         *
         * @return Result
         */

        public Result ipsetIndex() {
            return client.get("/cluster/firewall/ipset", null);
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
            return client.create("/cluster/firewall/ipset", parameters);
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
            return client.create("/cluster/firewall/ipset", parameters);
        }

    }

    public static class PVEAliases {

        private final PveClient client;

        protected PVEAliases(PveClient client) {
            this.client = client;

        }

        public PVEAliases.PVENameItem get(Object name) {
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
             * Remove IP or Network alias.
             *
             * @param digest Prevent changes if current configuration file has a different
             *               digest. This can be used to prevent concurrent modifications.
             * @return Result
             */

            public Result removeAlias(String digest) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("digest", digest);
                return client.delete("/cluster/firewall/aliases/" + this.name, parameters);
            }

            /**
             * Remove IP or Network alias.
             *
             * @return Result
             */

            public Result removeAlias() {
                return client.delete("/cluster/firewall/aliases/" + this.name, null);
            }

            /**
             * Read alias.
             *
             * @return Result
             */

            public Result readAlias() {
                return client.get("/cluster/firewall/aliases/" + this.name, null);
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
                return client.set("/cluster/firewall/aliases/" + this.name, parameters);
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
                return client.set("/cluster/firewall/aliases/" + this.name, parameters);
            }

        }

        /**
         * List aliases
         *
         * @return Result
         */

        public Result getAliases() {
            return client.get("/cluster/firewall/aliases", null);
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
            return client.create("/cluster/firewall/aliases", parameters);
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
            return client.create("/cluster/firewall/aliases", parameters);
        }

    }

    public static class PVEOptions {

        private final PveClient client;

        protected PVEOptions(PveClient client) {
            this.client = client;

        }

        /**
         * Get Firewall options.
         *
         * @return Result
         */

        public Result getOptions() {
            return client.get("/cluster/firewall/options", null);
        }

        /**
         * Set Firewall options.
         *
         * @param delete         A list of settings you want to delete.
         * @param digest         Prevent changes if current configuration file has a
         *                       different digest. This can be used to prevent
         *                       concurrent modifications.
         * @param ebtables       Enable ebtables rules cluster wide.
         * @param enable         Enable or disable the firewall cluster wide.
         * @param log_ratelimit  Log ratelimiting settings
         * @param policy_forward Forward policy.
         *                       Enum: ACCEPT,DROP
         * @param policy_in      Input policy.
         *                       Enum: ACCEPT,REJECT,DROP
         * @param policy_out     Output policy.
         *                       Enum: ACCEPT,REJECT,DROP
         * @return Result
         */

        public Result setOptions(String delete, String digest, Boolean ebtables, Integer enable,
                                 String log_ratelimit, String policy_forward, String policy_in, String policy_out) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("delete", delete);
            parameters.put("digest", digest);
            parameters.put("ebtables", ebtables);
            parameters.put("enable", enable);
            parameters.put("log_ratelimit", log_ratelimit);
            parameters.put("policy_forward", policy_forward);
            parameters.put("policy_in", policy_in);
            parameters.put("policy_out", policy_out);
            return client.set("/cluster/firewall/options", parameters);
        }

        /**
         * Set Firewall options.
         *
         * @return Result
         */

        public Result setOptions() {
            return client.set("/cluster/firewall/options", null);
        }

    }

    public static class PVEMacros {

        private final PveClient client;

        protected PVEMacros(PveClient client) {
            this.client = client;

        }

        /**
         * List available macros
         *
         * @return Result
         */

        public Result getMacros() {
            return client.get("/cluster/firewall/macros", null);
        }

    }

    public static class PVERefs {

        private final PveClient client;

        protected PVERefs(PveClient client) {
            this.client = client;

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
            return client.get("/cluster/firewall/refs", parameters);
        }

        /**
         * Lists possible IPSet/Alias reference which are allowed in source/dest
         * properties.
         *
         * @return Result
         */

        public Result refs() {
            return client.get("/cluster/firewall/refs", null);
        }

    }

    /**
     * Directory index.
     *
     * @return Result
     */

    public Result index() {
        return client.get("/cluster/firewall", null);
    }

}

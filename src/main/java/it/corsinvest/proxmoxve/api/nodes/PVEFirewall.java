package it.corsinvest.proxmoxve.api.nodes;

import it.corsinvest.proxmoxve.api.PveClient;
import it.corsinvest.proxmoxve.api.Result;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class PVEFirewall {

    private final PveClient client;
    private final Object node;

    public PVEFirewall(PveClient client, Object node) {
        this.client = client;
        this.node = node;
    }

    private PVERules rules;

    public PVERules getRules() {
        return rules == null ? (rules = new PVERules(client, this.node)) : rules;
    }

    private PVEOptions options;

    public PVEOptions getOptions() {
        return options == null ? (options = new PVEOptions(client, this.node)) : options;
    }

    private PVELog log;

    public PVELog getLog() {
        return log == null ? (log = new PVELog(client, this.node)) : log;
    }

    public static class PVERules {

        private final PveClient client;
        private final Object node;

        protected PVERules(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        public PVERules.PVEPosItem get(Object pos) {
            return new PVEPosItem(client, this.node, pos);
        }

        public static class PVEPosItem {

            private final PveClient client;
            private final Object node;
            private final Object pos;

            protected PVEPosItem(PveClient client, Object node, Object pos) {
                this.client = client;
                this.node = node;
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
                return client.delete("/nodes/" + this.node + "/firewall/rules/" + this.pos,
                        parameters);
            }

            /**
             * Delete rule.
             *
             * @return Result
             */

            public Result deleteRule() {
                return client.delete("/nodes/" + this.node + "/firewall/rules/" + this.pos, null);
            }

            /**
             * Get single rule data.
             *
             * @return Result
             */

            public Result getRule() {
                return client.get("/nodes/" + this.node + "/firewall/rules/" + this.pos, null);
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
                return client.set("/nodes/" + this.node + "/firewall/rules/" + this.pos, parameters);
            }

            /**
             * Modify rule data.
             *
             * @return Result
             */

            public Result updateRule() {
                return client.set("/nodes/" + this.node + "/firewall/rules/" + this.pos, null);
            }

        }

        /**
         * List rules.
         *
         * @return Result
         */

        public Result getRules() {
            return client.get("/nodes/" + this.node + "/firewall/rules", null);
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
            return client.create("/nodes/" + this.node + "/firewall/rules", parameters);
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
            return client.create("/nodes/" + this.node + "/firewall/rules", parameters);
        }

    }

    public static class PVEOptions {

        private final PveClient client;
        private final Object node;

        protected PVEOptions(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        /**
         * Get host firewall options.
         *
         * @return Result
         */

        public Result getOptions() {
            return client.get("/nodes/" + this.node + "/firewall/options", null);
        }

        /**
         * Set Firewall options.
         *
         * @param delete                               A list of settings you want to
         *                                             delete.
         * @param digest                               Prevent changes if current
         *                                             configuration file has a
         *                                             different digest. This can be
         *                                             used to prevent concurrent
         *                                             modifications.
         * @param enable                               Enable host firewall rules.
         * @param log_level_forward                    Log level for forwarded traffic.
         *                                             Enum:
         *                                             emerg,alert,crit,err,warning,notice,info,debug,nolog
         * @param log_level_in                         Log level for incoming traffic.
         *                                             Enum:
         *                                             emerg,alert,crit,err,warning,notice,info,debug,nolog
         * @param log_level_out                        Log level for outgoing traffic.
         *                                             Enum:
         *                                             emerg,alert,crit,err,warning,notice,info,debug,nolog
         * @param log_nf_conntrack                     Enable logging of conntrack
         *                                             information.
         * @param ndp                                  Enable NDP (Neighbor Discovery
         *                                             Protocol).
         * @param nf_conntrack_allow_invalid           Allow invalid packets on
         *                                             connection tracking.
         * @param nf_conntrack_helpers                 Enable conntrack helpers for
         *                                             specific protocols. Supported
         *                                             protocols: amanda, ftp, irc,
         *                                             netbios-ns, pptp, sane, sip,
         *                                             snmp, tftp
         * @param nf_conntrack_max                     Maximum number of tracked
         *                                             connections.
         * @param nf_conntrack_tcp_timeout_established Conntrack established timeout.
         * @param nf_conntrack_tcp_timeout_syn_recv    Conntrack syn recv timeout.
         * @param nftables                             Enable nftables based firewall
         *                                             (tech preview)
         * @param nosmurfs                             Enable SMURFS filter.
         * @param protection_synflood                  Enable synflood protection
         * @param protection_synflood_burst            Synflood protection rate burst by
         *                                             ip src.
         * @param protection_synflood_rate             Synflood protection rate syn/sec
         *                                             by ip src.
         * @param smurf_log_level                      Log level for SMURFS filter.
         *                                             Enum:
         *                                             emerg,alert,crit,err,warning,notice,info,debug,nolog
         * @param tcp_flags_log_level                  Log level for illegal tcp flags
         *                                             filter.
         *                                             Enum:
         *                                             emerg,alert,crit,err,warning,notice,info,debug,nolog
         * @param tcpflags                             Filter illegal combinations of
         *                                             TCP flags.
         * @return Result
         */

        public Result setOptions(String delete, String digest, Boolean enable, String log_level_forward,
                                 String log_level_in, String log_level_out, Boolean log_nf_conntrack, Boolean ndp,
                                 Boolean nf_conntrack_allow_invalid, String nf_conntrack_helpers, Integer nf_conntrack_max,
                                 Integer nf_conntrack_tcp_timeout_established, Integer nf_conntrack_tcp_timeout_syn_recv,
                                 Boolean nftables, Boolean nosmurfs, Boolean protection_synflood,
                                 Integer protection_synflood_burst, Integer protection_synflood_rate, String smurf_log_level,
                                 String tcp_flags_log_level, Boolean tcpflags) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("delete", delete);
            parameters.put("digest", digest);
            parameters.put("enable", enable);
            parameters.put("log_level_forward", log_level_forward);
            parameters.put("log_level_in", log_level_in);
            parameters.put("log_level_out", log_level_out);
            parameters.put("log_nf_conntrack", log_nf_conntrack);
            parameters.put("ndp", ndp);
            parameters.put("nf_conntrack_allow_invalid", nf_conntrack_allow_invalid);
            parameters.put("nf_conntrack_helpers", nf_conntrack_helpers);
            parameters.put("nf_conntrack_max", nf_conntrack_max);
            parameters.put("nf_conntrack_tcp_timeout_established", nf_conntrack_tcp_timeout_established);
            parameters.put("nf_conntrack_tcp_timeout_syn_recv", nf_conntrack_tcp_timeout_syn_recv);
            parameters.put("nftables", nftables);
            parameters.put("nosmurfs", nosmurfs);
            parameters.put("protection_synflood", protection_synflood);
            parameters.put("protection_synflood_burst", protection_synflood_burst);
            parameters.put("protection_synflood_rate", protection_synflood_rate);
            parameters.put("smurf_log_level", smurf_log_level);
            parameters.put("tcp_flags_log_level", tcp_flags_log_level);
            parameters.put("tcpflags", tcpflags);
            return client.set("/nodes/" + this.node + "/firewall/options", parameters);
        }

        /**
         * Set Firewall options.
         *
         * @return Result
         */

        public Result setOptions() {
            return client.set("/nodes/" + this.node + "/firewall/options", null);
        }

    }

    public static class PVELog {

        private final PveClient client;
        private final Object node;

        protected PVELog(PveClient client, Object node) {
            this.client = client;
            this.node = node;
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
            return client.get("/nodes/" + this.node + "/firewall/log", parameters);
        }

        /**
         * Read firewall log
         *
         * @return Result
         */

        public Result log() {
            return client.get("/nodes/" + this.node + "/firewall/log", null);
        }

    }

    /**
     * Directory index.
     *
     * @return Result
     */

    public Result index() {
        return client.get("/nodes/" + this.node + "/firewall", null);
    }

}

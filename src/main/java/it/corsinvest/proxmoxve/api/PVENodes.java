package it.corsinvest.proxmoxve.api;

import it.corsinvest.proxmoxve.api.nodes.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class PVENodes {

    private final PveClient client;

    protected PVENodes(PveClient client) {
        this.client = client;

    }

    public PVENodeItem get(Object node) {
        return new PVENodeItem(client, node);
    }

    public static class PVENodeItem {

        private final PveClient client;
        private final Object node;

        protected PVENodeItem(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        public PveClient getClient() {
            return client;
        }

        private PVEQemu qemu;

        public PVEQemu getQemu() {
            return qemu == null ? (qemu = new PVEQemu(client, this.node)) : qemu;
        }

        private PVELxc lxc;

        public PVELxc getLxc() {
            return lxc == null ? (lxc = new PVELxc(client, this.node)) : lxc;
        }

        private PVECeph ceph;

        public PVECeph getCeph() {
            return ceph == null ? (ceph = new PVECeph(client, this.node)) : ceph;
        }

        private PVENodeItem.PVEVzdump vzdump;

        public PVENodeItem.PVEVzdump getVzdump() {
            return vzdump == null ? (vzdump = new PVEVzdump(client, this.node)) : vzdump;
        }

        private PVENodeItem.PVEServices services;

        public PVENodeItem.PVEServices getServices() {
            return services == null ? (services = new PVEServices(client, this.node)) : services;
        }

        private PVENodeItem.PVESubscription subscription;

        public PVENodeItem.PVESubscription getSubscription() {
            return subscription == null ? (subscription = new PVESubscription(client, this.node)) : subscription;
        }

        private PVENetwork network;

        public PVENetwork getNetwork() {
            return network == null ? (network = new PVENetwork(client, this.node)) : network;
        }

        private PVENodeItem.PVETasks tasks;

        public PVENodeItem.PVETasks getTasks() {
            return tasks == null ? (tasks = new PVETasks(client, this.node)) : tasks;
        }

        private PVEScan scan;

        public PVEScan getScan() {
            return scan == null ? (scan = new PVEScan(client, this.node)) : scan;
        }

        private PVEHardware hardware;

        public PVEHardware getHardware() {
            return hardware == null ? (hardware = new PVEHardware(client, this.node)) : hardware;
        }

        private PVENodeItem.PVECapabilities capabilities;

        public PVENodeItem.PVECapabilities getCapabilities() {
            return capabilities == null ? (capabilities = new PVECapabilities(client, this.node)) : capabilities;
        }

        private PVEStorage storage;

        public PVEStorage getStorage() {
            return storage == null ? (storage = new PVEStorage(client, this.node)) : storage;
        }

        private PVEDisks disks;

        public PVEDisks getDisks() {
            return disks == null ? (disks = new PVEDisks(client, this.node)) : disks;
        }

        private PVEApt apt;

        public PVEApt getApt() {
            return apt == null ? (apt = new PVEApt(client, this.node)) : apt;
        }

        private PVEFirewall firewall;

        public PVEFirewall getFirewall() {
            return firewall == null ? (firewall = new PVEFirewall(client, this.node)) : firewall;
        }

        private PVENodeItem.PVEReplication replication;

        public PVENodeItem.PVEReplication getReplication() {
            return replication == null ? (replication = new PVEReplication(client, this.node)) : replication;
        }

        private PVECertificates certificates;

        public PVECertificates getCertificates() {
            return certificates == null ? (certificates = new PVECertificates(client, this.node)) : certificates;
        }

        private PVENodeItem.PVEConfig config;

        public PVENodeItem.PVEConfig getConfig() {
            return config == null ? (config = new PVEConfig(client, this.node)) : config;
        }

        private PVESdn sdn;

        public PVESdn getSdn() {
            return sdn == null ? (sdn = new PVESdn(client, this.node)) : sdn;
        }

        private PVENodeItem.PVEVersion version;

        public PVENodeItem.PVEVersion getVersion() {
            return version == null ? (version = new PVEVersion(client, this.node)) : version;
        }

        private PVENodeItem.PVEStatus status;

        public PVENodeItem.PVEStatus getStatus() {
            return status == null ? (status = new PVEStatus(client, this.node)) : status;
        }

        private PVENodeItem.PVENetstat netstat;

        public PVENodeItem.PVENetstat getNetstat() {
            return netstat == null ? (netstat = new PVENetstat(client, this.node)) : netstat;
        }

        private PVENodeItem.PVEExecute execute;

        public PVENodeItem.PVEExecute getExecute() {
            return execute == null ? (execute = new PVEExecute(client, this.node)) : execute;
        }

        private PVENodeItem.PVEWakeonlan wakeonlan;

        public PVENodeItem.PVEWakeonlan getWakeonlan() {
            return wakeonlan == null ? (wakeonlan = new PVEWakeonlan(client, this.node)) : wakeonlan;
        }

        private PVENodeItem.PVERrd rrd;

        public PVENodeItem.PVERrd getRrd() {
            return rrd == null ? (rrd = new PVERrd(client, this.node)) : rrd;
        }

        private PVENodeItem.PVERrddata rrddata;

        public PVENodeItem.PVERrddata getRrddata() {
            return rrddata == null ? (rrddata = new PVERrddata(client, this.node)) : rrddata;
        }

        private PVENodeItem.PVESyslog syslog;

        public PVENodeItem.PVESyslog getSyslog() {
            return syslog == null ? (syslog = new PVESyslog(client, this.node)) : syslog;
        }

        private PVENodeItem.PVEJournal journal;

        public PVENodeItem.PVEJournal getJournal() {
            return journal == null ? (journal = new PVEJournal(client, this.node)) : journal;
        }

        private PVENodeItem.PVEVncshell vncshell;

        public PVENodeItem.PVEVncshell getVncshell() {
            return vncshell == null ? (vncshell = new PVEVncshell(client, this.node)) : vncshell;
        }

        private PVENodeItem.PVETermproxy termproxy;

        public PVENodeItem.PVETermproxy getTermproxy() {
            return termproxy == null ? (termproxy = new PVETermproxy(client, this.node)) : termproxy;
        }

        private PVENodeItem.PVEVncwebsocket vncwebsocket;

        public PVENodeItem.PVEVncwebsocket getVncwebsocket() {
            return vncwebsocket == null ? (vncwebsocket = new PVEVncwebsocket(client, this.node)) : vncwebsocket;
        }

        private PVENodeItem.PVESpiceshell spiceshell;

        public PVENodeItem.PVESpiceshell getSpiceshell() {
            return spiceshell == null ? (spiceshell = new PVESpiceshell(client, this.node)) : spiceshell;
        }

        private PVENodeItem.PVEDns dns;

        public PVENodeItem.PVEDns getDns() {
            return dns == null ? (dns = new PVEDns(client, this.node)) : dns;
        }

        private PVENodeItem.PVETime time;

        public PVENodeItem.PVETime getTime() {
            return time == null ? (time = new PVETime(client, this.node)) : time;
        }

        private PVENodeItem.PVEAplinfo aplinfo;

        public PVENodeItem.PVEAplinfo getAplinfo() {
            return aplinfo == null ? (aplinfo = new PVEAplinfo(client, this.node)) : aplinfo;
        }

        private PVENodeItem.PVEQueryOciRepoTags queryOciRepoTags;

        public PVENodeItem.PVEQueryOciRepoTags getQueryOciRepoTags() {
            return queryOciRepoTags == null ? (queryOciRepoTags = new PVEQueryOciRepoTags(client, this.node))
                    : queryOciRepoTags;
        }

        private PVENodeItem.PVEQueryUrlMetadata queryUrlMetadata;

        public PVENodeItem.PVEQueryUrlMetadata getQueryUrlMetadata() {
            return queryUrlMetadata == null ? (queryUrlMetadata = new PVEQueryUrlMetadata(client, this.node))
                    : queryUrlMetadata;
        }

        private PVENodeItem.PVEReport report;

        public PVENodeItem.PVEReport getReport() {
            return report == null ? (report = new PVEReport(client, this.node)) : report;
        }

        private PVENodeItem.PVEStartall startall;

        public PVENodeItem.PVEStartall getStartall() {
            return startall == null ? (startall = new PVEStartall(client, this.node)) : startall;
        }

        private PVENodeItem.PVEStopall stopall;

        public PVENodeItem.PVEStopall getStopall() {
            return stopall == null ? (stopall = new PVEStopall(client, this.node)) : stopall;
        }

        private PVENodeItem.PVESuspendall suspendall;

        public PVENodeItem.PVESuspendall getSuspendall() {
            return suspendall == null ? (suspendall = new PVESuspendall(client, this.node)) : suspendall;
        }

        private PVENodeItem.PVEMigrateall migrateall;

        public PVENodeItem.PVEMigrateall getMigrateall() {
            return migrateall == null ? (migrateall = new PVEMigrateall(client, this.node)) : migrateall;
        }

        private PVENodeItem.PVEHosts hosts;

        public PVENodeItem.PVEHosts getHosts() {
            return hosts == null ? (hosts = new PVEHosts(client, this.node)) : hosts;
        }

        public static class PVEVzdump {

            private final PveClient client;
            private final Object node;

            protected PVEVzdump(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            private PVENodeItem.PVEVzdump.PVEDefaults defaults;

            public PVENodeItem.PVEVzdump.PVEDefaults getDefaults() {
                return defaults == null ? (defaults = new PVEDefaults(client, this.node)) : defaults;
            }

            private PVENodeItem.PVEVzdump.PVEExtractconfig extractconfig;

            public PVENodeItem.PVEVzdump.PVEExtractconfig getExtractconfig() {
                return extractconfig == null ? (extractconfig = new PVEExtractconfig(client, this.node))
                        : extractconfig;
            }

            public static class PVEDefaults {

                private final PveClient client;
                private final Object node;

                protected PVEDefaults(PveClient client, Object node) {
                    this.client = client;
                    this.node = node;
                }

                /**
                 * Get the currently configured vzdump defaults.
                 *
                 * @param storage The storage identifier.
                 * @return Result
                 */

                public Result defaults(String storage) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("storage", storage);
                    return client.get("/nodes/" + this.node + "/vzdump/defaults", parameters);
                }

                /**
                 * Get the currently configured vzdump defaults.
                 *
                 * @return Result
                 */

                public Result defaults() {
                    return client.get("/nodes/" + this.node + "/vzdump/defaults", null);
                }

            }

            public static class PVEExtractconfig {

                private final PveClient client;
                private final Object node;

                protected PVEExtractconfig(PveClient client, Object node) {
                    this.client = client;
                    this.node = node;
                }

                /**
                 * Extract configuration from vzdump backup archive.
                 *
                 * @param volume Volume identifier
                 * @return Result
                 */

                public Result extractconfig(String volume) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("volume", volume);
                    return client.get("/nodes/" + this.node + "/vzdump/extractconfig", parameters);
                }

            }

            /**
             * Create backup.
             *
             * @param all                       Backup all known guest systems on this host.
             * @param bwlimit                   Limit I/O bandwidth (in KiB/s).
             * @param compress                  Compress dump file.
             *                                  Enum: 0,1,gzip,lzo,zstd
             * @param dumpdir                   Store resulting files to specified
             *                                  directory.
             * @param exclude                   Exclude specified guest systems (assumes
             *                                  --all)
             * @param exclude_path              Exclude certain files/directories (shell
             *                                  globs). Paths starting with '/' are anchored
             *                                  to the container's root, other paths match
             *                                  relative to each subdirectory.
             * @param fleecing                  Options for backup fleecing (VM only).
             * @param ionice                    Set IO priority when using the BFQ
             *                                  scheduler. For snapshot and suspend mode
             *                                  backups of VMs, this only affects the
             *                                  compressor. A value of 8 means the idle
             *                                  priority is used, otherwise the best-effort
             *                                  priority is used with the specified value.
             * @param job_id                    The ID of the backup job. If set, the
             *                                  'backup-job' metadata field of the backup
             *                                  notification will be set to this value. Only
             *                                  root@pam can set this parameter.
             * @param lockwait                  Maximal time to wait for the global lock
             *                                  (minutes).
             * @param mailnotification          Deprecated: use notification
             *                                  targets/matchers instead. Specify when to
             *                                  send a notification mail
             *                                  Enum: always,failure
             * @param mailto                    Deprecated: Use notification
             *                                  targets/matchers instead. Comma-separated
             *                                  list of email addresses or users that should
             *                                  receive email notifications.
             * @param maxfiles                  Deprecated: use 'prune-backups' instead.
             *                                  Maximal number of backup files per guest
             *                                  system.
             * @param mode                      Backup mode.
             *                                  Enum: snapshot,suspend,stop
             * @param notes_template            Template string for generating notes for the
             *                                  backup(s). It can contain variables which
             *                                  will be replaced by their values. Currently
             *                                  supported are {{cluster}}, {{guestname}},
             *                                  {{node}}, and {{vmid}}, but more might be
             *                                  added in the future. Needs to be a single
             *                                  line, newline and backslash need to be
             *                                  escaped as '\n' and '\\' respectively.
             * @param notification_mode         Determine which notification system to use.
             *                                  If set to 'legacy-sendmail', vzdump will
             *                                  consider the mailto/mailnotification
             *                                  parameters and send emails to the specified
             *                                  address(es) via the 'sendmail' command. If
             *                                  set to 'notification-system', a notification
             *                                  will be sent via PVE's notification system,
             *                                  and the mailto and mailnotification will be
             *                                  ignored. If set to 'auto' (default setting),
             *                                  an email will be sent if mailto is set, and
             *                                  the notification system will be used if not.
             *                                  Enum:
             *                                  auto,legacy-sendmail,notification-system
             * @param pbs_change_detection_mode PBS mode used to detect file changes and
             *                                  switch encoding format for container
             *                                  backups.
             *                                  Enum: legacy,data,metadata
             * @param performance               Other performance-related settings.
             * @param pigz                      Use pigz instead of gzip when N&amp;gt;0.
             *                                  N=1 uses half of cores, N&amp;gt;1 uses N as
             *                                  thread count.
             * @param pool                      Backup all known guest systems included in
             *                                  the specified pool.
             * @param protected_                If true, mark backup(s) as protected.
             * @param prune_backups             Use these retention options instead of those
             *                                  from the storage configuration.
             * @param quiet                     Be quiet.
             * @param remove                    Prune older backups according to
             *                                  'prune-backups'.
             * @param script                    Use specified hook script.
             * @param stdexcludes               Exclude temporary files and logs.
             * @param stdout                    Write tar to stdout, not to a file.
             * @param stop                      Stop running backup jobs on this host.
             * @param stopwait                  Maximal time to wait until a guest system is
             *                                  stopped (minutes).
             * @param storage                   Store resulting file to this storage.
             * @param tmpdir                    Store temporary files to specified
             *                                  directory.
             * @param vmid                      The ID of the guest system you want to
             *                                  backup.
             * @param zstd                      Zstd threads. N=0 uses half of the available
             *                                  cores, if N is set to a value bigger than 0,
             *                                  N is used as thread count.
             * @return Result
             */

            public Result vzdump(Boolean all, Integer bwlimit, String compress, String dumpdir, String exclude,
                                 List<Object> exclude_path, String fleecing, Integer ionice, String job_id, Integer lockwait,
                                 String mailnotification, String mailto, Integer maxfiles, String mode, String notes_template,
                                 String notification_mode, String pbs_change_detection_mode, String performance, Integer pigz,
                                 String pool, Boolean protected_, String prune_backups, Boolean quiet, Boolean remove,
                                 String script, Boolean stdexcludes, Boolean stdout, Boolean stop, Integer stopwait,
                                 String storage, String tmpdir, String vmid, Integer zstd) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("all", all);
                parameters.put("bwlimit", bwlimit);
                parameters.put("compress", compress);
                parameters.put("dumpdir", dumpdir);
                parameters.put("exclude", exclude);
                parameters.put("exclude-path", exclude_path);
                parameters.put("fleecing", fleecing);
                parameters.put("ionice", ionice);
                parameters.put("job-id", job_id);
                parameters.put("lockwait", lockwait);
                parameters.put("mailnotification", mailnotification);
                parameters.put("mailto", mailto);
                parameters.put("maxfiles", maxfiles);
                parameters.put("mode", mode);
                parameters.put("notes-template", notes_template);
                parameters.put("notification-mode", notification_mode);
                parameters.put("pbs-change-detection-mode", pbs_change_detection_mode);
                parameters.put("performance", performance);
                parameters.put("pigz", pigz);
                parameters.put("pool", pool);
                parameters.put("protected", protected_);
                parameters.put("prune-backups", prune_backups);
                parameters.put("quiet", quiet);
                parameters.put("remove", remove);
                parameters.put("script", script);
                parameters.put("stdexcludes", stdexcludes);
                parameters.put("stdout", stdout);
                parameters.put("stop", stop);
                parameters.put("stopwait", stopwait);
                parameters.put("storage", storage);
                parameters.put("tmpdir", tmpdir);
                parameters.put("vmid", vmid);
                parameters.put("zstd", zstd);
                return client.create("/nodes/" + this.node + "/vzdump", parameters);
            }

            /**
             * Create backup.
             *
             * @return Result
             */

            public Result vzdump() {
                return client.create("/nodes/" + this.node + "/vzdump", null);
            }

        }

        public static class PVEServices {

            private final PveClient client;
            private final Object node;

            protected PVEServices(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            public PVENodeItem.PVEServices.PVEServiceItem get(Object service) {
                return new PVEServiceItem(client, this.node, service);
            }

            public static class PVEServiceItem {

                private final PveClient client;
                private final Object node;
                private final Object service;

                protected PVEServiceItem(PveClient client, Object node, Object service) {
                    this.client = client;
                    this.node = node;
                    this.service = service;
                }

                private PVENodeItem.PVEServices.PVEServiceItem.PVEState state;

                public PVENodeItem.PVEServices.PVEServiceItem.PVEState getState() {
                    return state == null ? (state = new PVEState(client, this.node, this.service)) : state;
                }

                private PVENodeItem.PVEServices.PVEServiceItem.PVEStart start;

                public PVENodeItem.PVEServices.PVEServiceItem.PVEStart getStart() {
                    return start == null ? (start = new PVEStart(client, this.node, this.service)) : start;
                }

                private PVENodeItem.PVEServices.PVEServiceItem.PVEStop stop;

                public PVENodeItem.PVEServices.PVEServiceItem.PVEStop getStop() {
                    return stop == null ? (stop = new PVEStop(client, this.node, this.service)) : stop;
                }

                private PVENodeItem.PVEServices.PVEServiceItem.PVERestart restart;

                public PVENodeItem.PVEServices.PVEServiceItem.PVERestart getRestart() {
                    return restart == null ? (restart = new PVERestart(client, this.node, this.service)) : restart;
                }

                private PVENodeItem.PVEServices.PVEServiceItem.PVEReload reload;

                public PVENodeItem.PVEServices.PVEServiceItem.PVEReload getReload() {
                    return reload == null ? (reload = new PVEReload(client, this.node, this.service)) : reload;
                }

                public static class PVEState {

                    private final PveClient client;
                    private final Object node;
                    private final Object service;

                    protected PVEState(PveClient client, Object node, Object service) {
                        this.client = client;
                        this.node = node;
                        this.service = service;
                    }

                    /**
                     * Read service properties
                     *
                     * @return Result
                     */

                    public Result serviceState() {
                        return client.get("/nodes/" + this.node + "/services/" + this.service + "/state", null);
                    }

                }

                public static class PVEStart {

                    private final PveClient client;
                    private final Object node;
                    private final Object service;

                    protected PVEStart(PveClient client, Object node, Object service) {
                        this.client = client;
                        this.node = node;
                        this.service = service;
                    }

                    /**
                     * Start service.
                     *
                     * @return Result
                     */

                    public Result serviceStart() {
                        return client.create("/nodes/" + this.node + "/services/" + this.service + "/start", null);
                    }

                }

                public static class PVEStop {

                    private final PveClient client;
                    private final Object node;
                    private final Object service;

                    protected PVEStop(PveClient client, Object node, Object service) {
                        this.client = client;
                        this.node = node;
                        this.service = service;
                    }

                    /**
                     * Stop service.
                     *
                     * @return Result
                     */

                    public Result serviceStop() {
                        return client.create("/nodes/" + this.node + "/services/" + this.service + "/stop", null);
                    }

                }

                public static class PVERestart {

                    private final PveClient client;
                    private final Object node;
                    private final Object service;

                    protected PVERestart(PveClient client, Object node, Object service) {
                        this.client = client;
                        this.node = node;
                        this.service = service;
                    }

                    /**
                     * Hard restart service. Use reload if you want to reduce interruptions.
                     *
                     * @return Result
                     */

                    public Result serviceRestart() {
                        return client.create("/nodes/" + this.node + "/services/" + this.service + "/restart",
                                null);
                    }

                }

                public static class PVEReload {

                    private final PveClient client;
                    private final Object node;
                    private final Object service;

                    protected PVEReload(PveClient client, Object node, Object service) {
                        this.client = client;
                        this.node = node;
                        this.service = service;
                    }

                    /**
                     * Reload service. Falls back to restart if service cannot be reloaded.
                     *
                     * @return Result
                     */

                    public Result serviceReload() {
                        return client.create("/nodes/" + this.node + "/services/" + this.service + "/reload", null);
                    }

                }

                /**
                 * Directory index
                 *
                 * @return Result
                 */

                public Result srvcmdidx() {
                    return client.get("/nodes/" + this.node + "/services/" + this.service, null);
                }

            }

            /**
             * Service list.
             *
             * @return Result
             */

            public Result index() {
                return client.get("/nodes/" + this.node + "/services", null);
            }

        }

        public static class PVESubscription {

            private final PveClient client;
            private final Object node;

            protected PVESubscription(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            /**
             * Delete subscription key of this node.
             *
             * @return Result
             */

            public Result delete() {
                return client.delete("/nodes/" + this.node + "/subscription", null);
            }

            /**
             * Read subscription info.
             *
             * @return Result
             */

            public Result get() {
                return client.get("/nodes/" + this.node + "/subscription", null);
            }

            /**
             * Update subscription info.
             *
             * @param force Always connect to server, even if local cache is still valid.
             * @return Result
             */

            public Result update(Boolean force) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("force", force);
                return client.create("/nodes/" + this.node + "/subscription", parameters);
            }

            /**
             * Update subscription info.
             *
             * @return Result
             */

            public Result update() {
                return client.create("/nodes/" + this.node + "/subscription", null);
            }

            /**
             * Set subscription key.
             *
             * @param key Proxmox VE subscription key
             * @return Result
             */

            public Result set(String key) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("key", key);
                return client.set("/nodes/" + this.node + "/subscription", parameters);
            }

        }

        public static class PVETasks {

            private final PveClient client;
            private final Object node;

            protected PVETasks(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            public PVENodeItem.PVETasks.PVEUpidItem get(Object upid) {
                return new PVEUpidItem(client, this.node, upid);
            }

            public static class PVEUpidItem {

                private final PveClient client;
                private final Object node;
                private final Object upid;

                protected PVEUpidItem(PveClient client, Object node, Object upid) {
                    this.client = client;
                    this.node = node;
                    this.upid = upid;
                }

                private PVENodeItem.PVETasks.PVEUpidItem.PVELog log;

                public PVENodeItem.PVETasks.PVEUpidItem.PVELog getLog() {
                    return log == null ? (log = new PVELog(client, this.node, this.upid)) : log;
                }

                private PVENodeItem.PVETasks.PVEUpidItem.PVEStatus status;

                public PVENodeItem.PVETasks.PVEUpidItem.PVEStatus getStatus() {
                    return status == null ? (status = new PVEStatus(client, this.node, this.upid)) : status;
                }

                public static class PVELog {

                    private final PveClient client;
                    private final Object node;
                    private final Object upid;

                    protected PVELog(PveClient client, Object node, Object upid) {
                        this.client = client;
                        this.node = node;
                        this.upid = upid;
                    }

                    /**
                     * Read task log.
                     *
                     * @param download Whether the tasklog file should be downloaded. This parameter
                     *                 can't be used in conjunction with other parameters
                     * @param limit    The number of lines to read from the tasklog.
                     * @param start    Start at this line when reading the tasklog
                     * @return Result
                     */

                    public Result readTaskLog(Boolean download, Integer limit, Integer start) {
                        Map<String, Object> parameters = new HashMap<>();
                        parameters.put("download", download);
                        parameters.put("limit", limit);
                        parameters.put("start", start);
                        return client.get("/nodes/" + this.node + "/tasks/" + this.upid + "/log", parameters);
                    }

                    /**
                     * Read task log.
                     *
                     * @return Result
                     */

                    public Result readTaskLog() {
                        return client.get("/nodes/" + this.node + "/tasks/" + this.upid + "/log", null);
                    }

                }

                public static class PVEStatus {

                    private final PveClient client;
                    private final Object node;
                    private final Object upid;

                    protected PVEStatus(PveClient client, Object node, Object upid) {
                        this.client = client;
                        this.node = node;
                        this.upid = upid;
                    }

                    /**
                     * Read task status.
                     *
                     * @return Result
                     */

                    public Result readTaskStatus() {
                        return client.get("/nodes/" + this.node + "/tasks/" + this.upid + "/status", null);
                    }

                }

                /**
                 * Stop a task.
                 *
                 * @return Result
                 */

                public Result stopTask() {
                    return client.delete("/nodes/" + this.node + "/tasks/" + this.upid, null);
                }

                /**
                 *
                 * @return Result
                 */

                public Result upidIndex() {
                    return client.get("/nodes/" + this.node + "/tasks/" + this.upid, null);
                }

            }

            /**
             * Read task list for one node (finished tasks).
             *
             * @param errors       Only list tasks with a status of ERROR.
             * @param limit        Only list this number of tasks.
             * @param since        Only list tasks since this UNIX epoch.
             * @param source       List archived, active or all tasks.
             *                     Enum: archive,active,all
             * @param start        List tasks beginning from this offset.
             * @param statusfilter List of Task States that should be returned.
             * @param typefilter   Only list tasks of this type (e.g., vzstart, vzdump).
             * @param until        Only list tasks until this UNIX epoch.
             * @param userfilter   Only list tasks from this user.
             * @param vmid         Only list tasks for this VM.
             * @return Result
             */

            public Result nodeTasks(Boolean errors, Integer limit, Integer since, String source, Integer start,
                                    String statusfilter, String typefilter, Integer until, String userfilter, Integer vmid) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("errors", errors);
                parameters.put("limit", limit);
                parameters.put("since", since);
                parameters.put("source", source);
                parameters.put("start", start);
                parameters.put("statusfilter", statusfilter);
                parameters.put("typefilter", typefilter);
                parameters.put("until", until);
                parameters.put("userfilter", userfilter);
                parameters.put("vmid", vmid);
                return client.get("/nodes/" + this.node + "/tasks", parameters);
            }

            /**
             * Read task list for one node (finished tasks).
             *
             * @return Result
             */

            public Result nodeTasks() {
                return client.get("/nodes/" + this.node + "/tasks", null);
            }

        }

        public static class PVECapabilities {

            private final PveClient client;
            private final Object node;

            protected PVECapabilities(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            private PVENodeItem.PVECapabilities.PVEQemu qemu;

            public PVENodeItem.PVECapabilities.PVEQemu getQemu() {
                return qemu == null ? (qemu = new PVEQemu(client, this.node)) : qemu;
            }

            public static class PVEQemu {

                private final PveClient client;
                private final Object node;

                protected PVEQemu(PveClient client, Object node) {
                    this.client = client;
                    this.node = node;
                }

                private PVENodeItem.PVECapabilities.PVEQemu.PVECpu cpu;

                public PVENodeItem.PVECapabilities.PVEQemu.PVECpu getCpu() {
                    return cpu == null ? (cpu = new PVECpu(client, this.node)) : cpu;
                }

                private PVENodeItem.PVECapabilities.PVEQemu.PVECpuFlags cpuFlags;

                public PVENodeItem.PVECapabilities.PVEQemu.PVECpuFlags getCpuFlags() {
                    return cpuFlags == null ? (cpuFlags = new PVECpuFlags(client, this.node)) : cpuFlags;
                }

                private PVENodeItem.PVECapabilities.PVEQemu.PVEMachines machines;

                public PVENodeItem.PVECapabilities.PVEQemu.PVEMachines getMachines() {
                    return machines == null ? (machines = new PVEMachines(client, this.node)) : machines;
                }

                private PVENodeItem.PVECapabilities.PVEQemu.PVEMigration migration;

                public PVENodeItem.PVECapabilities.PVEQemu.PVEMigration getMigration() {
                    return migration == null ? (migration = new PVEMigration(client, this.node)) : migration;
                }

                public static class PVECpu {

                    private final PveClient client;
                    private final Object node;

                    protected PVECpu(PveClient client, Object node) {
                        this.client = client;
                        this.node = node;
                    }

                    /**
                     * List all custom and default CPU models.
                     *
                     * @return Result
                     */

                    public Result index() {
                        return client.get("/nodes/" + this.node + "/capabilities/qemu/cpu", null);
                    }

                }

                public static class PVECpuFlags {

                    private final PveClient client;
                    private final Object node;

                    protected PVECpuFlags(PveClient client, Object node) {
                        this.client = client;
                        this.node = node;
                    }

                    /**
                     * List of available VM-specific CPU flags.
                     *
                     * @return Result
                     */

                    public Result index() {
                        return client.get("/nodes/" + this.node + "/capabilities/qemu/cpu-flags", null);
                    }

                }

                public static class PVEMachines {

                    private final PveClient client;
                    private final Object node;

                    protected PVEMachines(PveClient client, Object node) {
                        this.client = client;
                        this.node = node;
                    }

                    /**
                     * Get available QEMU/KVM machine types.
                     *
                     * @return Result
                     */

                    public Result types() {
                        return client.get("/nodes/" + this.node + "/capabilities/qemu/machines", null);
                    }

                }

                public static class PVEMigration {

                    private final PveClient client;
                    private final Object node;

                    protected PVEMigration(PveClient client, Object node) {
                        this.client = client;
                        this.node = node;
                    }

                    /**
                     * Get node-specific QEMU migration capabilities of the node. Requires the
                     * 'Sys.Audit' permission on '/nodes/&amp;lt;node&amp;gt;'.
                     *
                     * @return Result
                     */

                    public Result capabilities() {
                        return client.get("/nodes/" + this.node + "/capabilities/qemu/migration", null);
                    }

                }

                /**
                 * QEMU capabilities index.
                 *
                 * @return Result
                 */

                public Result qemuCapsIndex() {
                    return client.get("/nodes/" + this.node + "/capabilities/qemu", null);
                }

            }

            /**
             * Node capabilities index.
             *
             * @return Result
             */

            public Result index() {
                return client.get("/nodes/" + this.node + "/capabilities", null);
            }

        }

        public static class PVEReplication {

            private final PveClient client;
            private final Object node;

            protected PVEReplication(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            public PVENodeItem.PVEReplication.PVEIdItem get(Object id) {
                return new PVEIdItem(client, this.node, id);
            }

            public static class PVEIdItem {

                private final PveClient client;
                private final Object node;
                private final Object id;

                protected PVEIdItem(PveClient client, Object node, Object id) {
                    this.client = client;
                    this.node = node;
                    this.id = id;
                }

                private PVENodeItem.PVEReplication.PVEIdItem.PVEStatus status;

                public PVENodeItem.PVEReplication.PVEIdItem.PVEStatus getStatus() {
                    return status == null ? (status = new PVEStatus(client, this.node, this.id)) : status;
                }

                private PVENodeItem.PVEReplication.PVEIdItem.PVELog log;

                public PVENodeItem.PVEReplication.PVEIdItem.PVELog getLog() {
                    return log == null ? (log = new PVELog(client, this.node, this.id)) : log;
                }

                private PVENodeItem.PVEReplication.PVEIdItem.PVEScheduleNow scheduleNow;

                public PVENodeItem.PVEReplication.PVEIdItem.PVEScheduleNow getScheduleNow() {
                    return scheduleNow == null ? (scheduleNow = new PVEScheduleNow(client, this.node, this.id))
                            : scheduleNow;
                }

                public static class PVEStatus {

                    private final PveClient client;
                    private final Object node;
                    private final Object id;

                    protected PVEStatus(PveClient client, Object node, Object id) {
                        this.client = client;
                        this.node = node;
                        this.id = id;
                    }

                    /**
                     * Get replication job status.
                     *
                     * @return Result
                     */

                    public Result jobStatus() {
                        return client.get("/nodes/" + this.node + "/replication/" + this.id + "/status", null);
                    }

                }

                public static class PVELog {

                    private final PveClient client;
                    private final Object node;
                    private final Object id;

                    protected PVELog(PveClient client, Object node, Object id) {
                        this.client = client;
                        this.node = node;
                        this.id = id;
                    }

                    /**
                     * Read replication job log.
                     *
                     * @return Result
                     */

                    public Result readJobLog(Integer limit, Integer start) {
                        Map<String, Object> parameters = new HashMap<>();
                        parameters.put("limit", limit);
                        parameters.put("start", start);
                        return client.get("/nodes/" + this.node + "/replication/" + this.id + "/log", parameters);
                    }

                    /**
                     * Read replication job log.
                     *
                     * @return Result
                     */

                    public Result readJobLog() {
                        return client.get("/nodes/" + this.node + "/replication/" + this.id + "/log", null);
                    }

                }

                public static class PVEScheduleNow {

                    private final PveClient client;
                    private final Object node;
                    private final Object id;

                    protected PVEScheduleNow(PveClient client, Object node, Object id) {
                        this.client = client;
                        this.node = node;
                        this.id = id;
                    }

                    /**
                     * Schedule replication job to start as soon as possible.
                     *
                     * @return Result
                     */

                    public Result scheduleNow() {
                        return client.create("/nodes/" + this.node + "/replication/" + this.id + "/schedule_now",
                                null);
                    }

                }

                /**
                 * Directory index.
                 *
                 * @return Result
                 */

                public Result index() {
                    return client.get("/nodes/" + this.node + "/replication/" + this.id, null);
                }

            }

            /**
             * List status of all replication jobs on this node.
             *
             * @param guest Only list replication jobs for this guest.
             * @return Result
             */

            public Result status(Integer guest) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("guest", guest);
                return client.get("/nodes/" + this.node + "/replication", parameters);
            }

            /**
             * List status of all replication jobs on this node.
             *
             * @return Result
             */

            public Result status() {
                return client.get("/nodes/" + this.node + "/replication", null);
            }

        }

        public static class PVEConfig {

            private final PveClient client;
            private final Object node;

            protected PVEConfig(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            /**
             * Get node configuration options.
             *
             * @param property Return only a specific property from the node configuration.
             *                 Enum:
             *                 acme,acmedomain0,acmedomain1,acmedomain2,acmedomain3,acmedomain4,acmedomain5,ballooning-target,description,startall-onboot-delay,wakeonlan
             * @return Result
             */

            public Result getConfig(String property) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("property", property);
                return client.get("/nodes/" + this.node + "/config", parameters);
            }

            /**
             * Get node configuration options.
             *
             * @return Result
             */

            public Result getConfig() {
                return client.get("/nodes/" + this.node + "/config", null);
            }

            /**
             * Set node configuration options.
             *
             * @param acme                  Node specific ACME settings.
             * @param acmedomainN           ACME domain and validation plugin
             * @param ballooning_target     RAM usage target for ballooning (in percent of
             *                              total memory)
             * @param delete                A list of settings you want to delete.
             * @param description           Description for the Node. Shown in the
             *                              web-interface node notes panel. This is saved as
             *                              comment inside the configuration file.
             * @param digest                Prevent changes if current configuration file
             *                              has different SHA1 digest. This can be used to
             *                              prevent concurrent modifications.
             * @param startall_onboot_delay Initial delay in seconds, before starting all
             *                              the Virtual Guests with on-boot enabled.
             * @param wakeonlan             Node specific wake on LAN settings.
             * @return Result
             */

            public Result setOptions(String acme, Map<Integer, String> acmedomainN, Integer ballooning_target,
                                     String delete, String description, String digest, Integer startall_onboot_delay,
                                     String wakeonlan) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("acme", acme);
                parameters.put("ballooning-target", ballooning_target);
                parameters.put("delete", delete);
                parameters.put("description", description);
                parameters.put("digest", digest);
                parameters.put("startall-onboot-delay", startall_onboot_delay);
                parameters.put("wakeonlan", wakeonlan);
                PveClientBase.addIndexedParameter(parameters, "acmedomain", acmedomainN);
                return client.set("/nodes/" + this.node + "/config", parameters);
            }

            /**
             * Set node configuration options.
             *
             * @return Result
             */

            public Result setOptions() {
                return client.set("/nodes/" + this.node + "/config", null);
            }

        }

        public static class PVEVersion {

            private final PveClient client;
            private final Object node;

            protected PVEVersion(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            /**
             * API version details
             *
             * @return Result
             */

            public Result version() {
                return client.get("/nodes/" + this.node + "/version", null);
            }

        }

        public static class PVEStatus {

            private final PveClient client;
            private final Object node;

            protected PVEStatus(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            /**
             * Read node status
             *
             * @return Result
             */

            public Result status() {
                return client.get("/nodes/" + this.node + "/status", null);
            }

            /**
             * Reboot or shutdown a node.
             *
             * @param command Specify the command.
             *                Enum: reboot,shutdown
             * @return Result
             */

            public Result nodeCmd(String command) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("command", command);
                return client.create("/nodes/" + this.node + "/status", parameters);
            }

        }

        public static class PVENetstat {

            private final PveClient client;
            private final Object node;

            protected PVENetstat(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            /**
             * Read tap/vm network device interface counters
             *
             * @return Result
             */

            public Result netstat() {
                return client.get("/nodes/" + this.node + "/netstat", null);
            }

        }

        public static class PVEExecute {

            private final PveClient client;
            private final Object node;

            protected PVEExecute(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            /**
             * Execute multiple commands in order, root only.
             *
             * @param commands JSON encoded array of commands.
             * @return Result
             */

            public Result execute(String commands) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("commands", commands);
                return client.create("/nodes/" + this.node + "/execute", parameters);
            }

        }

        public static class PVEWakeonlan {

            private final PveClient client;
            private final Object node;

            protected PVEWakeonlan(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            /**
             * Try to wake a node via 'wake on LAN' network packet.
             *
             * @return Result
             */

            public Result wakeonlan() {
                return client.create("/nodes/" + this.node + "/wakeonlan", null);
            }

        }

        public static class PVERrd {

            private final PveClient client;
            private final Object node;

            protected PVERrd(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            /**
             * Read node RRD statistics (returns PNG)
             *
             * @param ds        The list of datasources you want to display.
             * @param timeframe Specify the time frame you are interested in.
             *                  Enum: hour,day,week,month,year,decade
             * @param cf        The RRD consolidation function
             *                  Enum: AVERAGE,MAX
             * @return Result
             */

            public Result rrd(String ds, String timeframe, String cf) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("ds", ds);
                parameters.put("timeframe", timeframe);
                parameters.put("cf", cf);
                return client.get("/nodes/" + this.node + "/rrd", parameters);
            }

            /**
             * Read node RRD statistics (returns PNG)
             *
             * @param ds        The list of datasources you want to display.
             * @param timeframe Specify the time frame you are interested in.
             *                  Enum: hour,day,week,month,year,decade
             * @return Result
             */

            public Result rrd(String ds, String timeframe) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("ds", ds);
                parameters.put("timeframe", timeframe);
                return client.get("/nodes/" + this.node + "/rrd", parameters);
            }

        }

        public static class PVERrddata {

            private final PveClient client;
            private final Object node;

            protected PVERrddata(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            /**
             * Read node RRD statistics
             *
             * @param timeframe Specify the time frame you are interested in.
             *                  Enum: hour,day,week,month,year,decade
             * @param cf        The RRD consolidation function
             *                  Enum: AVERAGE,MAX
             * @return Result
             */

            public Result rrddata(String timeframe, String cf) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("timeframe", timeframe);
                parameters.put("cf", cf);
                return client.get("/nodes/" + this.node + "/rrddata", parameters);
            }

            /**
             * Read node RRD statistics
             *
             * @param timeframe Specify the time frame you are interested in.
             *                  Enum: hour,day,week,month,year,decade
             * @return Result
             */

            public Result rrddata(String timeframe) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("timeframe", timeframe);
                return client.get("/nodes/" + this.node + "/rrddata", parameters);
            }

        }

        public static class PVESyslog {

            private final PveClient client;
            private final Object node;

            protected PVESyslog(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            /**
             * Read system log
             *
             * @param service Service ID
             * @param since   Display all log since this date-time string.
             * @param until   Display all log until this date-time string.
             * @return Result
             */

            public Result syslog(Integer limit, String service, String since, Integer start, String until) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("limit", limit);
                parameters.put("service", service);
                parameters.put("since", since);
                parameters.put("start", start);
                parameters.put("until", until);
                return client.get("/nodes/" + this.node + "/syslog", parameters);
            }

            /**
             * Read system log
             *
             * @return Result
             */

            public Result syslog() {
                return client.get("/nodes/" + this.node + "/syslog", null);
            }

        }

        public static class PVEJournal {

            private final PveClient client;
            private final Object node;

            protected PVEJournal(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            /**
             * Read Journal
             *
             * @param endcursor   End before the given Cursor. Conflicts with 'until'
             * @param lastentries Limit to the last X lines. Conflicts with a range.
             * @param since       Display all log since this UNIX epoch. Conflicts with
             *                    'startcursor'.
             * @param startcursor Start after the given Cursor. Conflicts with 'since'
             * @param until       Display all log until this UNIX epoch. Conflicts with
             *                    'endcursor'.
             * @return Result
             */

            public Result journal(String endcursor, Integer lastentries, Integer since, String startcursor,
                                  Integer until) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("endcursor", endcursor);
                parameters.put("lastentries", lastentries);
                parameters.put("since", since);
                parameters.put("startcursor", startcursor);
                parameters.put("until", until);
                return client.get("/nodes/" + this.node + "/journal", parameters);
            }

            /**
             * Read Journal
             *
             * @return Result
             */

            public Result journal() {
                return client.get("/nodes/" + this.node + "/journal", null);
            }

        }

        public static class PVEVncshell {

            private final PveClient client;
            private final Object node;

            protected PVEVncshell(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            /**
             * Creates a VNC Shell proxy.
             *
             * @param cmd       Run specific command or default to login (requires
             *                  'root@pam')
             *                  Enum: ceph_install,login,upgrade
             * @param cmd_opts  Add parameters to a command. Encoded as null terminated
             *                  strings.
             * @param height    sets the height of the console in pixels.
             * @param websocket use websocket instead of standard vnc.
             * @param width     sets the width of the console in pixels.
             * @return Result
             */

            public Result vncshell(String cmd, String cmd_opts, Integer height, Boolean websocket, Integer width) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("cmd", cmd);
                parameters.put("cmd-opts", cmd_opts);
                parameters.put("height", height);
                parameters.put("websocket", websocket);
                parameters.put("width", width);
                return client.create("/nodes/" + this.node + "/vncshell", parameters);
            }

            /**
             * Creates a VNC Shell proxy.
             *
             * @return Result
             */

            public Result vncshell() {
                return client.create("/nodes/" + this.node + "/vncshell", null);
            }

        }

        public static class PVETermproxy {

            private final PveClient client;
            private final Object node;

            protected PVETermproxy(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            /**
             * Creates a VNC Shell proxy.
             *
             * @param cmd      Run specific command or default to login (requires
             *                 'root@pam')
             *                 Enum: ceph_install,login,upgrade
             * @param cmd_opts Add parameters to a command. Encoded as null terminated
             *                 strings.
             * @return Result
             */

            public Result termproxy(String cmd, String cmd_opts) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("cmd", cmd);
                parameters.put("cmd-opts", cmd_opts);
                return client.create("/nodes/" + this.node + "/termproxy", parameters);
            }

            /**
             * Creates a VNC Shell proxy.
             *
             * @return Result
             */

            public Result termproxy() {
                return client.create("/nodes/" + this.node + "/termproxy", null);
            }

        }

        public static class PVEVncwebsocket {

            private final PveClient client;
            private final Object node;

            protected PVEVncwebsocket(PveClient client, Object node) {
                this.client = client;
                this.node = node;
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
                return client.get("/nodes/" + this.node + "/vncwebsocket", parameters);
            }

        }

        public static class PVESpiceshell {

            private final PveClient client;
            private final Object node;

            protected PVESpiceshell(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            /**
             * Creates a SPICE shell.
             *
             * @param cmd      Run specific command or default to login (requires
             *                 'root@pam')
             *                 Enum: ceph_install,login,upgrade
             * @param cmd_opts Add parameters to a command. Encoded as null terminated
             *                 strings.
             * @param proxy    SPICE proxy server. This can be used by the client to specify
             *                 the proxy server. All nodes in a cluster runs 'spiceproxy',
             *                 so it is up to the client to choose one. By default, we
             *                 return the node where the VM is currently running. As
             *                 reasonable setting is to use same node you use to connect to
             *                 the API (This is window.location.hostname for the JS GUI).
             * @return Result
             */

            public Result spiceshell(String cmd, String cmd_opts, String proxy) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("cmd", cmd);
                parameters.put("cmd-opts", cmd_opts);
                parameters.put("proxy", proxy);
                return client.create("/nodes/" + this.node + "/spiceshell", parameters);
            }

            /**
             * Creates a SPICE shell.
             *
             * @return Result
             */

            public Result spiceshell() {
                return client.create("/nodes/" + this.node + "/spiceshell", null);
            }

        }

        public static class PVEDns {

            private final PveClient client;
            private final Object node;

            protected PVEDns(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            /**
             * Read DNS settings.
             *
             * @return Result
             */

            public Result dns() {
                return client.get("/nodes/" + this.node + "/dns", null);
            }

            /**
             * Write DNS settings.
             *
             * @param search Search domain for host-name lookup.
             * @param dns1   First name server IP address.
             * @param dns2   Second name server IP address.
             * @param dns3   Third name server IP address.
             * @return Result
             */

            public Result updateDns(String search, String dns1, String dns2, String dns3) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("search", search);
                parameters.put("dns1", dns1);
                parameters.put("dns2", dns2);
                parameters.put("dns3", dns3);
                return client.set("/nodes/" + this.node + "/dns", parameters);
            }

            /**
             * Write DNS settings.
             *
             * @param search Search domain for host-name lookup.
             * @return Result
             */

            public Result updateDns(String search) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("search", search);
                return client.set("/nodes/" + this.node + "/dns", parameters);
            }

        }

        public static class PVETime {

            private final PveClient client;
            private final Object node;

            protected PVETime(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            /**
             * Read server time and time zone settings.
             *
             * @return Result
             */

            public Result time() {
                return client.get("/nodes/" + this.node + "/time", null);
            }

            /**
             * Set time zone.
             *
             * @param timezone Time zone. The file '/usr/share/zoneinfo/zone.tab' contains
             *                 the list of valid names.
             * @return Result
             */

            public Result setTimezone(String timezone) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("timezone", timezone);
                return client.set("/nodes/" + this.node + "/time", parameters);
            }

        }

        public static class PVEAplinfo {

            private final PveClient client;
            private final Object node;

            protected PVEAplinfo(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            /**
             * Get list of appliances.
             *
             * @return Result
             */

            public Result aplinfo() {
                return client.get("/nodes/" + this.node + "/aplinfo", null);
            }

            /**
             * Download appliance templates.
             *
             * @param storage  The storage where the template will be stored
             * @param template The template which will downloaded
             * @return Result
             */

            public Result aplDownload(String storage, String template) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("storage", storage);
                parameters.put("template", template);
                return client.create("/nodes/" + this.node + "/aplinfo", parameters);
            }

        }

        public static class PVEQueryOciRepoTags {

            private final PveClient client;
            private final Object node;

            protected PVEQueryOciRepoTags(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            /**
             * List all tags for an OCI repository reference.
             *
             * @param reference The reference to the repository to query tags from.
             * @return Result
             */

            public Result queryOciRepoTags(String reference) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("reference", reference);
                return client.get("/nodes/" + this.node + "/query-oci-repo-tags", parameters);
            }

        }

        public static class PVEQueryUrlMetadata {

            private final PveClient client;
            private final Object node;

            protected PVEQueryUrlMetadata(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            /**
             * Query metadata of an URL: file size, file name and mime type.
             *
             * @param url                 The URL to query the metadata from.
             * @param verify_certificates If false, no SSL/TLS certificates will be
             *                            verified.
             * @return Result
             */

            public Result queryUrlMetadata(String url, Boolean verify_certificates) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("url", url);
                parameters.put("verify-certificates", verify_certificates);
                return client.get("/nodes/" + this.node + "/query-url-metadata", parameters);
            }

            /**
             * Query metadata of an URL: file size, file name and mime type.
             *
             * @param url The URL to query the metadata from.
             * @return Result
             */

            public Result queryUrlMetadata(String url) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("url", url);
                return client.get("/nodes/" + this.node + "/query-url-metadata", parameters);
            }

        }

        public static class PVEReport {

            private final PveClient client;
            private final Object node;

            protected PVEReport(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            /**
             * Gather various systems information about a node
             *
             * @return Result
             */

            public Result report() {
                return client.get("/nodes/" + this.node + "/report", null);
            }

        }

        public static class PVEStartall {

            private final PveClient client;
            private final Object node;

            protected PVEStartall(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            /**
             * Start all VMs and containers located on this node (by default only those with
             * onboot=1).
             *
             * @param force Issue start command even if virtual guest have 'onboot' not set
             *              or set to off.
             * @param vms   Only consider guests from this comma separated list of VMIDs.
             * @return Result
             */

            public Result startall(Boolean force, String vms) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("force", force);
                parameters.put("vms", vms);
                return client.create("/nodes/" + this.node + "/startall", parameters);
            }

            /**
             * Start all VMs and containers located on this node (by default only those with
             * onboot=1).
             *
             * @return Result
             */

            public Result startall() {
                return client.create("/nodes/" + this.node + "/startall", null);
            }

        }

        public static class PVEStopall {

            private final PveClient client;
            private final Object node;

            protected PVEStopall(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            /**
             * Stop all VMs and Containers.
             *
             * @param force_stop Force a hard-stop after the timeout.
             * @param timeout    Timeout for each guest shutdown task. Depending on
             *                   `force-stop`, the shutdown gets then simply aborted or a
             *                   hard-stop is forced.
             * @param vms        Only consider Guests with these IDs.
             * @return Result
             */

            public Result stopall(Boolean force_stop, Integer timeout, String vms) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("force-stop", force_stop);
                parameters.put("timeout", timeout);
                parameters.put("vms", vms);
                return client.create("/nodes/" + this.node + "/stopall", parameters);
            }

            /**
             * Stop all VMs and Containers.
             *
             * @return Result
             */

            public Result stopall() {
                return client.create("/nodes/" + this.node + "/stopall", null);
            }

        }

        public static class PVESuspendall {

            private final PveClient client;
            private final Object node;

            protected PVESuspendall(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            /**
             * Suspend all VMs.
             *
             * @param vms Only consider Guests with these IDs.
             * @return Result
             */

            public Result suspendall(String vms) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("vms", vms);
                return client.create("/nodes/" + this.node + "/suspendall", parameters);
            }

            /**
             * Suspend all VMs.
             *
             * @return Result
             */

            public Result suspendall() {
                return client.create("/nodes/" + this.node + "/suspendall", null);
            }

        }

        public static class PVEMigrateall {

            private final PveClient client;
            private final Object node;

            protected PVEMigrateall(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            /**
             * Migrate all VMs and Containers.
             *
             * @param target           Target node.
             * @param maxworkers       Maximal number of parallel migration job. If not set,
             *                         uses'max_workers' from datacenter.cfg. One of both
             *                         must be set!
             * @param vms              Only consider Guests with these IDs.
             * @param with_local_disks Enable live storage migration for local disk
             * @return Result
             */

            public Result migrateall(String target, Integer maxworkers, String vms, Boolean with_local_disks) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("target", target);
                parameters.put("maxworkers", maxworkers);
                parameters.put("vms", vms);
                parameters.put("with-local-disks", with_local_disks);
                return client.create("/nodes/" + this.node + "/migrateall", parameters);
            }

            /**
             * Migrate all VMs and Containers.
             *
             * @param target Target node.
             * @return Result
             */

            public Result migrateall(String target) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("target", target);
                return client.create("/nodes/" + this.node + "/migrateall", parameters);
            }

        }

        public static class PVEHosts {

            private final PveClient client;
            private final Object node;

            protected PVEHosts(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            /**
             * Get the content of /etc/hosts.
             *
             * @return Result
             */

            public Result getEtcHosts() {
                return client.get("/nodes/" + this.node + "/hosts", null);
            }

            /**
             * Write /etc/hosts.
             *
             * @param data   The target content of /etc/hosts.
             * @param digest Prevent changes if current configuration file has a different
             *               digest. This can be used to prevent concurrent modifications.
             * @return Result
             */

            public Result writeEtcHosts(String data, String digest) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("data", data);
                parameters.put("digest", digest);
                return client.create("/nodes/" + this.node + "/hosts", parameters);
            }

            /**
             * Write /etc/hosts.
             *
             * @param data The target content of /etc/hosts.
             * @return Result
             */

            public Result writeEtcHosts(String data) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("data", data);
                return client.create("/nodes/" + this.node + "/hosts", parameters);
            }

        }

        /**
         * Node index.
         *
         * @return Result
         */

        public Result index() {
            return client.get("/nodes/" + this.node, null);
        }

    }

    /**
     * Cluster node index.
     *
     * @return Result
     */

    public Result index() {
        return client.get("/nodes", null);
    }

}

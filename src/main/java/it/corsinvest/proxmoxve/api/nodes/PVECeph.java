package it.corsinvest.proxmoxve.api.nodes;

import it.corsinvest.proxmoxve.api.PveClient;
import it.corsinvest.proxmoxve.api.Result;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class PVECeph {

    private final PveClient client;
    private final Object node;

    public PVECeph(PveClient client, Object node) {
        this.client = client;
        this.node = node;
    }

    private PVECfg cfg;

    public PVECfg getCfg() {
        return cfg == null ? (cfg = new PVECfg(client, this.node)) : cfg;
    }

    private PVEOsd osd;

    public PVEOsd getOsd() {
        return osd == null ? (osd = new PVEOsd(client, this.node)) : osd;
    }

    private PVEMds mds;

    public PVEMds getMds() {
        return mds == null ? (mds = new PVEMds(client, this.node)) : mds;
    }

    private PVEMgr mgr;

    public PVEMgr getMgr() {
        return mgr == null ? (mgr = new PVEMgr(client, this.node)) : mgr;
    }

    private PVEMon mon;

    public PVEMon getMon() {
        return mon == null ? (mon = new PVEMon(client, this.node)) : mon;
    }

    private PVEFs fs;

    public PVEFs getFs() {
        return fs == null ? (fs = new PVEFs(client, this.node)) : fs;
    }

    private PVEPool pool;

    public PVEPool getPool() {
        return pool == null ? (pool = new PVEPool(client, this.node)) : pool;
    }

    private PVEInit init;

    public PVEInit getInit() {
        return init == null ? (init = new PVEInit(client, this.node)) : init;
    }

    private PVEStop stop;

    public PVEStop getStop() {
        return stop == null ? (stop = new PVEStop(client, this.node)) : stop;
    }

    private PVEStart start;

    public PVEStart getStart() {
        return start == null ? (start = new PVEStart(client, this.node)) : start;
    }

    private PVERestart restart;

    public PVERestart getRestart() {
        return restart == null ? (restart = new PVERestart(client, this.node)) : restart;
    }

    private PVEStatus status;

    public PVEStatus getStatus() {
        return status == null ? (status = new PVEStatus(client, this.node)) : status;
    }

    private PVECrush crush;

    public PVECrush getCrush() {
        return crush == null ? (crush = new PVECrush(client, this.node)) : crush;
    }

    private PVELog log;

    public PVELog getLog() {
        return log == null ? (log = new PVELog(client, this.node)) : log;
    }

    private PVERules rules;

    public PVERules getRules() {
        return rules == null ? (rules = new PVERules(client, this.node)) : rules;
    }

    private PVECmdSafety cmdSafety;

    public PVECmdSafety getCmdSafety() {
        return cmdSafety == null ? (cmdSafety = new PVECmdSafety(client, this.node)) : cmdSafety;
    }

    public static class PVECfg {

        private final PveClient client;
        private final Object node;

        protected PVECfg(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        private PVECfg.PVERaw raw;

        public PVECfg.PVERaw getRaw() {
            return raw == null ? (raw = new PVERaw(client, this.node)) : raw;
        }

        private PVECfg.PVEDb db;

        public PVECfg.PVEDb getDb() {
            return db == null ? (db = new PVEDb(client, this.node)) : db;
        }

        private PVECfg.PVEValue value;

        public PVECfg.PVEValue getValue() {
            return value == null ? (value = new PVEValue(client, this.node)) : value;
        }

        public static class PVERaw {

            private final PveClient client;
            private final Object node;

            protected PVERaw(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            /**
             * Get the Ceph configuration file.
             *
             * @return Result
             */

            public Result raw() {
                return client.get("/nodes/" + this.node + "/ceph/cfg/raw", null);
            }

        }

        public static class PVEDb {

            private final PveClient client;
            private final Object node;

            protected PVEDb(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            /**
             * Get the Ceph configuration database.
             *
             * @return Result
             */

            public Result db() {
                return client.get("/nodes/" + this.node + "/ceph/cfg/db", null);
            }

        }

        public static class PVEValue {

            private final PveClient client;
            private final Object node;

            protected PVEValue(PveClient client, Object node) {
                this.client = client;
                this.node = node;
            }

            /**
             * Get configured values from either the config file or config DB.
             *
             * @param config_keys List of &amp;lt;section&amp;gt;:&amp;lt;config key&amp;gt;
             *                    items.
             * @return Result
             */

            public Result value(String config_keys) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("config-keys", config_keys);
                return client.get("/nodes/" + this.node + "/ceph/cfg/value", parameters);
            }

        }

        /**
         * Directory index.
         *
         * @return Result
         */

        public Result index() {
            return client.get("/nodes/" + this.node + "/ceph/cfg", null);
        }

    }

    public static class PVEOsd {

        private final PveClient client;
        private final Object node;

        protected PVEOsd(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        public PVEOsd.PVEOsdidItem get(Object osdid) {
            return new PVEOsdidItem(client, this.node, osdid);
        }

        public static class PVEOsdidItem {

            private final PveClient client;
            private final Object node;
            private final Object osdid;

            protected PVEOsdidItem(PveClient client, Object node, Object osdid) {
                this.client = client;
                this.node = node;
                this.osdid = osdid;
            }

            private PVEOsd.PVEOsdidItem.PVEMetadata metadata;

            public PVEOsd.PVEOsdidItem.PVEMetadata getMetadata() {
                return metadata == null ? (metadata = new PVEMetadata(client, this.node, this.osdid))
                        : metadata;
            }

            private PVEOsd.PVEOsdidItem.PVELvInfo lvInfo;

            public PVEOsd.PVEOsdidItem.PVELvInfo getLvInfo() {
                return lvInfo == null ? (lvInfo = new PVELvInfo(client, this.node, this.osdid)) : lvInfo;
            }

            private PVEOsd.PVEOsdidItem.PVEIn in;

            public PVEOsd.PVEOsdidItem.PVEIn getIn() {
                return in == null ? (in = new PVEIn(client, this.node, this.osdid)) : in;
            }

            private PVEOsd.PVEOsdidItem.PVEOut out;

            public PVEOsd.PVEOsdidItem.PVEOut getOut() {
                return out == null ? (out = new PVEOut(client, this.node, this.osdid)) : out;
            }

            private PVEOsd.PVEOsdidItem.PVEScrub scrub;

            public PVEOsd.PVEOsdidItem.PVEScrub getScrub() {
                return scrub == null ? (scrub = new PVEScrub(client, this.node, this.osdid)) : scrub;
            }

            public static class PVEMetadata {

                private final PveClient client;
                private final Object node;
                private final Object osdid;

                protected PVEMetadata(PveClient client, Object node, Object osdid) {
                    this.client = client;
                    this.node = node;
                    this.osdid = osdid;
                }

                /**
                 * Get OSD details
                 *
                 * @return Result
                 */

                public Result osddetails() {
                    return client.get("/nodes/" + this.node + "/ceph/osd/" + this.osdid + "/metadata",
                            null);
                }

            }

            public static class PVELvInfo {

                private final PveClient client;
                private final Object node;
                private final Object osdid;

                protected PVELvInfo(PveClient client, Object node, Object osdid) {
                    this.client = client;
                    this.node = node;
                    this.osdid = osdid;
                }

                /**
                 * Get OSD volume details
                 *
                 * @param type OSD device type
                 *             Enum: block,db,wal
                 * @return Result
                 */

                public Result osdvolume(String type) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("type", type);
                    return client.get("/nodes/" + this.node + "/ceph/osd/" + this.osdid + "/lv-info",
                            parameters);
                }

                /**
                 * Get OSD volume details
                 *
                 * @return Result
                 */

                public Result osdvolume() {
                    return client.get("/nodes/" + this.node + "/ceph/osd/" + this.osdid + "/lv-info", null);
                }

            }

            public static class PVEIn {

                private final PveClient client;
                private final Object node;
                private final Object osdid;

                protected PVEIn(PveClient client, Object node, Object osdid) {
                    this.client = client;
                    this.node = node;
                    this.osdid = osdid;
                }

                /**
                 * ceph osd in
                 *
                 * @return Result
                 */

                public Result in() {
                    return client.create("/nodes/" + this.node + "/ceph/osd/" + this.osdid + "/in", null);
                }

            }

            public static class PVEOut {

                private final PveClient client;
                private final Object node;
                private final Object osdid;

                protected PVEOut(PveClient client, Object node, Object osdid) {
                    this.client = client;
                    this.node = node;
                    this.osdid = osdid;
                }

                /**
                 * ceph osd out
                 *
                 * @return Result
                 */

                public Result out() {
                    return client.create("/nodes/" + this.node + "/ceph/osd/" + this.osdid + "/out", null);
                }

            }

            public static class PVEScrub {

                private final PveClient client;
                private final Object node;
                private final Object osdid;

                protected PVEScrub(PveClient client, Object node, Object osdid) {
                    this.client = client;
                    this.node = node;
                    this.osdid = osdid;
                }

                /**
                 * Instruct the OSD to scrub.
                 *
                 * @param deep If set, instructs a deep scrub instead of a normal one.
                 * @return Result
                 */

                public Result scrub(Boolean deep) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("deep", deep);
                    return client.create("/nodes/" + this.node + "/ceph/osd/" + this.osdid + "/scrub",
                            parameters);
                }

                /**
                 * Instruct the OSD to scrub.
                 *
                 * @return Result
                 */

                public Result scrub() {
                    return client.create("/nodes/" + this.node + "/ceph/osd/" + this.osdid + "/scrub",
                            null);
                }

            }

            /**
             * Destroy OSD
             *
             * @param cleanup If set, we remove partition table entries.
             * @return Result
             */

            public Result destroyosd(Boolean cleanup) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("cleanup", cleanup);
                return client.delete("/nodes/" + this.node + "/ceph/osd/" + this.osdid, parameters);
            }

            /**
             * Destroy OSD
             *
             * @return Result
             */

            public Result destroyosd() {
                return client.delete("/nodes/" + this.node + "/ceph/osd/" + this.osdid, null);
            }

            /**
             * OSD index.
             *
             * @return Result
             */

            public Result osdindex() {
                return client.get("/nodes/" + this.node + "/ceph/osd/" + this.osdid, null);
            }

        }

        /**
         * Get Ceph osd list/tree.
         *
         * @return Result
         */

        public Result index() {
            return client.get("/nodes/" + this.node + "/ceph/osd", null);
        }

        /**
         * Create OSD
         *
         * @param dev                Block device name.
         * @param crush_device_class Set the device class of the OSD in crush.
         * @param db_dev             Block device name for block.db.
         * @param db_dev_size        Size in GiB for block.db.
         * @param encrypted          Enables encryption of the OSD.
         * @param osds_per_device    OSD services per physical device. Only useful for
         *                           fast NVMe devices to utilize their performance better.
         * @param wal_dev            Block device name for block.wal.
         * @param wal_dev_size       Size in GiB for block.wal.
         * @return Result
         */

        public Result createosd(String dev, String crush_device_class, String db_dev, Float db_dev_size,
                                Boolean encrypted, Integer osds_per_device, String wal_dev, Float wal_dev_size) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("dev", dev);
            parameters.put("crush-device-class", crush_device_class);
            parameters.put("db_dev", db_dev);
            parameters.put("db_dev_size", db_dev_size);
            parameters.put("encrypted", encrypted);
            parameters.put("osds-per-device", osds_per_device);
            parameters.put("wal_dev", wal_dev);
            parameters.put("wal_dev_size", wal_dev_size);
            return client.create("/nodes/" + this.node + "/ceph/osd", parameters);
        }

        /**
         * Create OSD
         *
         * @param dev Block device name.
         * @return Result
         */

        public Result createosd(String dev) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("dev", dev);
            return client.create("/nodes/" + this.node + "/ceph/osd", parameters);
        }

    }

    public static class PVEMds {

        private final PveClient client;
        private final Object node;

        protected PVEMds(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        public PVEMds.PVENameItem get(Object name) {
            return new PVENameItem(client, this.node, name);
        }

        public static class PVENameItem {

            private final PveClient client;
            private final Object node;
            private final Object name;

            protected PVENameItem(PveClient client, Object node, Object name) {
                this.client = client;
                this.node = node;
                this.name = name;
            }

            /**
             * Destroy Ceph Metadata Server
             *
             * @return Result
             */

            public Result destroymds() {
                return client.delete("/nodes/" + this.node + "/ceph/mds/" + this.name, null);
            }

            /**
             * Create Ceph Metadata Server (MDS)
             *
             * @param hotstandby Determines whether a ceph-mds daemon should poll and replay
             *                   the log of an active MDS. Faster switch on MDS failure, but
             *                   needs more idle resources.
             * @return Result
             */

            public Result createmds(Boolean hotstandby) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("hotstandby", hotstandby);
                return client.create("/nodes/" + this.node + "/ceph/mds/" + this.name, parameters);
            }

            /**
             * Create Ceph Metadata Server (MDS)
             *
             * @return Result
             */

            public Result createmds() {
                return client.create("/nodes/" + this.node + "/ceph/mds/" + this.name, null);
            }

        }

        /**
         * MDS directory index.
         *
         * @return Result
         */

        public Result index() {
            return client.get("/nodes/" + this.node + "/ceph/mds", null);
        }

    }

    public static class PVEMgr {

        private final PveClient client;
        private final Object node;

        protected PVEMgr(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        public PVEMgr.PVEIdItem get(Object id) {
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

            /**
             * Destroy Ceph Manager.
             *
             * @return Result
             */

            public Result destroymgr() {
                return client.delete("/nodes/" + this.node + "/ceph/mgr/" + this.id, null);
            }

            /**
             * Create Ceph Manager
             *
             * @return Result
             */

            public Result createmgr() {
                return client.create("/nodes/" + this.node + "/ceph/mgr/" + this.id, null);
            }

        }

        /**
         * MGR directory index.
         *
         * @return Result
         */

        public Result index() {
            return client.get("/nodes/" + this.node + "/ceph/mgr", null);
        }

    }

    public static class PVEMon {

        private final PveClient client;
        private final Object node;

        protected PVEMon(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        public PVEMon.PVEMonidItem get(Object monid) {
            return new PVEMonidItem(client, this.node, monid);
        }

        public static class PVEMonidItem {

            private final PveClient client;
            private final Object node;
            private final Object monid;

            protected PVEMonidItem(PveClient client, Object node, Object monid) {
                this.client = client;
                this.node = node;
                this.monid = monid;
            }

            /**
             * Destroy Ceph Monitor and Manager.
             *
             * @return Result
             */

            public Result destroymon() {
                return client.delete("/nodes/" + this.node + "/ceph/mon/" + this.monid, null);
            }

            /**
             * Create Ceph Monitor and Manager
             *
             * @param mon_address Overwrites autodetected monitor IP address(es). Must be in
             *                    the public network(s) of Ceph.
             * @return Result
             */

            public Result createmon(String mon_address) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("mon-address", mon_address);
                return client.create("/nodes/" + this.node + "/ceph/mon/" + this.monid, parameters);
            }

            /**
             * Create Ceph Monitor and Manager
             *
             * @return Result
             */

            public Result createmon() {
                return client.create("/nodes/" + this.node + "/ceph/mon/" + this.monid, null);
            }

        }

        /**
         * Get Ceph monitor list.
         *
         * @return Result
         */

        public Result listmon() {
            return client.get("/nodes/" + this.node + "/ceph/mon", null);
        }

    }

    public static class PVEFs {

        private final PveClient client;
        private final Object node;

        protected PVEFs(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        public PVEFs.PVENameItem get(Object name) {
            return new PVENameItem(client, this.node, name);
        }

        public static class PVENameItem {

            private final PveClient client;
            private final Object node;
            private final Object name;

            protected PVENameItem(PveClient client, Object node, Object name) {
                this.client = client;
                this.node = node;
                this.name = name;
            }

            /**
             * Create a Ceph filesystem
             *
             * @param add_storage Configure the created CephFS as storage for this cluster.
             * @param pg_num      Number of placement groups for the backing data pool. The
             *                    metadata pool will use a quarter of this.
             * @return Result
             */

            public Result createfs(Boolean add_storage, Integer pg_num) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("add-storage", add_storage);
                parameters.put("pg_num", pg_num);
                return client.create("/nodes/" + this.node + "/ceph/fs/" + this.name, parameters);
            }

            /**
             * Create a Ceph filesystem
             *
             * @return Result
             */

            public Result createfs() {
                return client.create("/nodes/" + this.node + "/ceph/fs/" + this.name, null);
            }

        }

        /**
         * Directory index.
         *
         * @return Result
         */

        public Result index() {
            return client.get("/nodes/" + this.node + "/ceph/fs", null);
        }

    }

    public static class PVEPool {

        private final PveClient client;
        private final Object node;

        protected PVEPool(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        public PVEPool.PVENameItem get(Object name) {
            return new PVENameItem(client, this.node, name);
        }

        public static class PVENameItem {

            private final PveClient client;
            private final Object node;
            private final Object name;

            protected PVENameItem(PveClient client, Object node, Object name) {
                this.client = client;
                this.node = node;
                this.name = name;
            }

            private PVEPool.PVENameItem.PVEStatus status;

            public PVEPool.PVENameItem.PVEStatus getStatus() {
                return status == null ? (status = new PVEStatus(client, this.node, this.name)) : status;
            }

            public static class PVEStatus {

                private final PveClient client;
                private final Object node;
                private final Object name;

                protected PVEStatus(PveClient client, Object node, Object name) {
                    this.client = client;
                    this.node = node;
                    this.name = name;
                }

                /**
                 * Show the current pool status.
                 *
                 * @param verbose If enabled, will display additional data(e.g. statistics).
                 * @return Result
                 */

                public Result getpool(Boolean verbose) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("verbose", verbose);
                    return client.get("/nodes/" + this.node + "/ceph/pool/" + this.name + "/status",
                            parameters);
                }

                /**
                 * Show the current pool status.
                 *
                 * @return Result
                 */

                public Result getpool() {
                    return client.get("/nodes/" + this.node + "/ceph/pool/" + this.name + "/status", null);
                }

            }

            /**
             * Destroy pool
             *
             * @param force            If true, destroys pool even if in use
             * @param remove_ecprofile Remove the erasure code profile. Defaults to true, if
             *                         applicable.
             * @param remove_storages  Remove all pveceph-managed storages configured for
             *                         this pool
             * @return Result
             */

            public Result destroypool(Boolean force, Boolean remove_ecprofile, Boolean remove_storages) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("force", force);
                parameters.put("remove_ecprofile", remove_ecprofile);
                parameters.put("remove_storages", remove_storages);
                return client.delete("/nodes/" + this.node + "/ceph/pool/" + this.name, parameters);
            }

            /**
             * Destroy pool
             *
             * @return Result
             */

            public Result destroypool() {
                return client.delete("/nodes/" + this.node + "/ceph/pool/" + this.name, null);
            }

            /**
             * Pool index.
             *
             * @return Result
             */

            public Result poolindex() {
                return client.get("/nodes/" + this.node + "/ceph/pool/" + this.name, null);
            }

            /**
             * Change POOL settings
             *
             * @param application       The application of the pool.
             *                          Enum: rbd,cephfs,rgw
             * @param crush_rule        The rule to use for mapping object placement in the
             *                          cluster.
             * @param min_size          Minimum number of replicas per object
             * @param pg_autoscale_mode The automatic PG scaling mode of the pool.
             *                          Enum: on,off,warn
             * @param pg_num            Number of placement groups.
             * @param pg_num_min        Minimal number of placement groups.
             * @param size              Number of replicas per object
             * @param target_size       The estimated target size of the pool for the PG
             *                          autoscaler.
             * @param target_size_ratio The estimated target ratio of the pool for the PG
             *                          autoscaler.
             * @return Result
             */

            public Result setpool(String application, String crush_rule, Integer min_size,
                                  String pg_autoscale_mode, Integer pg_num, Integer pg_num_min, Integer size,
                                  String target_size, Float target_size_ratio) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("application", application);
                parameters.put("crush_rule", crush_rule);
                parameters.put("min_size", min_size);
                parameters.put("pg_autoscale_mode", pg_autoscale_mode);
                parameters.put("pg_num", pg_num);
                parameters.put("pg_num_min", pg_num_min);
                parameters.put("size", size);
                parameters.put("target_size", target_size);
                parameters.put("target_size_ratio", target_size_ratio);
                return client.set("/nodes/" + this.node + "/ceph/pool/" + this.name, parameters);
            }

            /**
             * Change POOL settings
             *
             * @return Result
             */

            public Result setpool() {
                return client.set("/nodes/" + this.node + "/ceph/pool/" + this.name, null);
            }

        }

        /**
         * List all pools and their settings (which are settable by the POST/PUT
         * endpoints).
         *
         * @return Result
         */

        public Result lspools() {
            return client.get("/nodes/" + this.node + "/ceph/pool", null);
        }

        /**
         * Create Ceph pool
         *
         * @param name              The name of the pool. It must be unique.
         * @param add_storages      Configure VM and CT storage using the new pool.
         * @param application       The application of the pool.
         *                          Enum: rbd,cephfs,rgw
         * @param crush_rule        The rule to use for mapping object placement in the
         *                          cluster.
         * @param erasure_coding    Create an erasure coded pool for RBD with an
         *                          accompaning replicated pool for metadata storage.
         *                          With EC, the common ceph options 'size', 'min_size'
         *                          and 'crush_rule' parameters will be applied to the
         *                          metadata pool.
         * @param min_size          Minimum number of replicas per object
         * @param pg_autoscale_mode The automatic PG scaling mode of the pool.
         *                          Enum: on,off,warn
         * @param pg_num            Number of placement groups.
         * @param pg_num_min        Minimal number of placement groups.
         * @param size              Number of replicas per object
         * @param target_size       The estimated target size of the pool for the PG
         *                          autoscaler.
         * @param target_size_ratio The estimated target ratio of the pool for the PG
         *                          autoscaler.
         * @return Result
         */

        public Result createpool(String name, Boolean add_storages, String application, String crush_rule,
                                 String erasure_coding, Integer min_size, String pg_autoscale_mode, Integer pg_num,
                                 Integer pg_num_min, Integer size, String target_size, Float target_size_ratio) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("name", name);
            parameters.put("add_storages", add_storages);
            parameters.put("application", application);
            parameters.put("crush_rule", crush_rule);
            parameters.put("erasure-coding", erasure_coding);
            parameters.put("min_size", min_size);
            parameters.put("pg_autoscale_mode", pg_autoscale_mode);
            parameters.put("pg_num", pg_num);
            parameters.put("pg_num_min", pg_num_min);
            parameters.put("size", size);
            parameters.put("target_size", target_size);
            parameters.put("target_size_ratio", target_size_ratio);
            return client.create("/nodes/" + this.node + "/ceph/pool", parameters);
        }

        /**
         * Create Ceph pool
         *
         * @param name The name of the pool. It must be unique.
         * @return Result
         */

        public Result createpool(String name) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("name", name);
            return client.create("/nodes/" + this.node + "/ceph/pool", parameters);
        }

    }

    public static class PVEInit {

        private final PveClient client;
        private final Object node;

        protected PVEInit(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        /**
         * Create initial ceph default configuration and setup symlinks.
         *
         * @param cluster_network Declare a separate cluster network, OSDs will
         *                        routeheartbeat, object replication and recovery
         *                        traffic over it
         * @param disable_cephx   Disable cephx authentication. WARNING: cephx is a
         *                        security feature protecting against man-in-the-middle
         *                        attacks. Only consider disabling cephx if your network
         *                        is private!
         * @param min_size        Minimum number of available replicas per object to
         *                        allow I/O
         * @param network         Use specific network for all ceph related traffic
         * @param pg_bits         Placement group bits, used to specify the default
         *                        number of placement groups. Depreacted. This setting
         *                        was deprecated in recent Ceph versions.
         * @param size            Targeted number of replicas per object
         * @return Result
         */

        public Result init(String cluster_network, Boolean disable_cephx, Integer min_size, String network,
                           Integer pg_bits, Integer size) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("cluster-network", cluster_network);
            parameters.put("disable_cephx", disable_cephx);
            parameters.put("min_size", min_size);
            parameters.put("network", network);
            parameters.put("pg_bits", pg_bits);
            parameters.put("size", size);
            return client.create("/nodes/" + this.node + "/ceph/init", parameters);
        }

        /**
         * Create initial ceph default configuration and setup symlinks.
         *
         * @return Result
         */

        public Result init() {
            return client.create("/nodes/" + this.node + "/ceph/init", null);
        }

    }

    public static class PVEStop {

        private final PveClient client;
        private final Object node;

        protected PVEStop(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        /**
         * Stop ceph services.
         *
         * @param service Ceph service name.
         * @return Result
         */

        public Result stop(String service) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("service", service);
            return client.create("/nodes/" + this.node + "/ceph/stop", parameters);
        }

        /**
         * Stop ceph services.
         *
         * @return Result
         */

        public Result stop() {
            return client.create("/nodes/" + this.node + "/ceph/stop", null);
        }

    }

    public static class PVEStart {

        private final PveClient client;
        private final Object node;

        protected PVEStart(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        /**
         * Start ceph services.
         *
         * @param service Ceph service name.
         * @return Result
         */

        public Result start(String service) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("service", service);
            return client.create("/nodes/" + this.node + "/ceph/start", parameters);
        }

        /**
         * Start ceph services.
         *
         * @return Result
         */

        public Result start() {
            return client.create("/nodes/" + this.node + "/ceph/start", null);
        }

    }

    public static class PVERestart {

        private final PveClient client;
        private final Object node;

        protected PVERestart(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        /**
         * Restart ceph services.
         *
         * @param service Ceph service name.
         * @return Result
         */

        public Result restart(String service) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("service", service);
            return client.create("/nodes/" + this.node + "/ceph/restart", parameters);
        }

        /**
         * Restart ceph services.
         *
         * @return Result
         */

        public Result restart() {
            return client.create("/nodes/" + this.node + "/ceph/restart", null);
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
         * Get ceph status.
         *
         * @return Result
         */

        public Result status() {
            return client.get("/nodes/" + this.node + "/ceph/status", null);
        }

    }

    public static class PVECrush {

        private final PveClient client;
        private final Object node;

        protected PVECrush(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        /**
         * Get OSD crush map
         *
         * @return Result
         */

        public Result crush() {
            return client.get("/nodes/" + this.node + "/ceph/crush", null);
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
         * Read ceph log
         *
         * @param limit
         * @param start
         * @return Result
         */

        public Result log(Integer limit, Integer start) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("limit", limit);
            parameters.put("start", start);
            return client.get("/nodes/" + this.node + "/ceph/log", parameters);
        }

        /**
         * Read ceph log
         *
         * @return Result
         */

        public Result log() {
            return client.get("/nodes/" + this.node + "/ceph/log", null);
        }

    }

    public static class PVERules {

        private final PveClient client;
        private final Object node;

        protected PVERules(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        /**
         * List ceph rules.
         *
         * @return Result
         */

        public Result rules() {
            return client.get("/nodes/" + this.node + "/ceph/rules", null);
        }

    }

    public static class PVECmdSafety {

        private final PveClient client;
        private final Object node;

        protected PVECmdSafety(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        /**
         * Heuristical check if it is safe to perform an action.
         *
         * @param action  Action to check
         *                Enum: stop,destroy
         * @param id      ID of the service
         * @param service Service type
         *                Enum: osd,mon,mds
         * @return Result
         */

        public Result cmdSafety(String action, String id, String service) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("action", action);
            parameters.put("id", id);
            parameters.put("service", service);
            return client.get("/nodes/" + this.node + "/ceph/cmd-safety", parameters);
        }

    }

    /**
     * Directory index.
     *
     * @return Result
     */

    public Result index() {
        return client.get("/nodes/" + this.node + "/ceph", null);
    }

}

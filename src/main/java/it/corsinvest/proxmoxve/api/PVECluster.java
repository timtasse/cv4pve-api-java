package it.corsinvest.proxmoxve.api;

import it.corsinvest.proxmoxve.api.cluster.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class PVECluster {

    private final PveClient client;

    protected PVECluster(final PveClient client) {
        this.client = client;
    }

    public PveClient getClient() {
        return this.client;
    }

    private PVEReplication replication;

    public PVEReplication getReplication() {
        return replication == null ? (replication = new PVEReplication(client)) : replication;
    }

    private PVEMetrics metrics;

    public PVEMetrics getMetrics() {
        return metrics == null ? (metrics = new PVEMetrics(client)) : metrics;
    }

    private PVENotifications notifications;

    public PVENotifications getNotifications() {
        return notifications == null ? (notifications = new PVENotifications(client)) : notifications;
    }

    private PVEConfig config;

    public PVEConfig getConfig() {
        return config == null ? (config = new PVEConfig(client)) : config;
    }

    private PVEFirewall firewall;

    public PVEFirewall getFirewall() {
        return firewall == null ? (firewall = new PVEFirewall(client)) : firewall;
    }

    private PVEBackup backup;

    public PVEBackup getBackup() {
        return backup == null ? (backup = new PVEBackup(client)) : backup;
    }

    private PVEBackupInfo backupInfo;

    public PVEBackupInfo getBackupInfo() {
        return backupInfo == null ? (backupInfo = new PVEBackupInfo(client)) : backupInfo;
    }

    private PVEHa ha;

    public PVEHa getHa() {
        return ha == null ? (ha = new PVEHa(client)) : ha;
    }

    private PVEAcme acme;

    public PVEAcme getAcme() {
        return acme == null ? (acme = new PVEAcme(client)) : acme;
    }

    private PVECeph ceph;

    public PVECeph getCeph() {
        return ceph == null ? (ceph = new PVECeph(client)) : ceph;
    }

    private PVEJobs jobs;

    public PVEJobs getJobs() {
        return jobs == null ? (jobs = new PVEJobs(client)) : jobs;
    }

    private PVEMapping mapping;

    public PVEMapping getMapping() {
        return mapping == null ? (mapping = new PVEMapping(client)) : mapping;
    }

    private PVEBulkAction bulkAction;

    public PVEBulkAction getBulkAction() {
        return bulkAction == null ? (bulkAction = new PVEBulkAction(client)) : bulkAction;
    }

    private PVESdn sdn;

    public PVESdn getSdn() {
        return sdn == null ? (sdn = new PVESdn(client)) : sdn;
    }

    private PVELog log;

    public PVELog getLog() {
        return log == null ? (log = new PVELog(client)) : log;
    }

    private PVEResources resources;

    public PVEResources getResources() {
        return resources == null ? (resources = new PVEResources(client)) : resources;
    }

    private PVETasks tasks;

    public PVETasks getTasks() {
        return tasks == null ? (tasks = new PVETasks(client)) : tasks;
    }

    private PVEOptions options;

    public PVEOptions getOptions() {
        return options == null ? (options = new PVEOptions(client)) : options;
    }

    private PVEStatus status;

    public PVEStatus getStatus() {
        return status == null ? (status = new PVEStatus(client)) : status;
    }

    private PVENextid nextid;

    public PVENextid getNextid() {
        return nextid == null ? (nextid = new PVENextid(client)) : nextid;
    }

    public static class PVEReplication {

        private final PveClient client;

        protected PVEReplication(PveClient client) {
            this.client = client;

        }

        public PVEIdItem get(Object id) {
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
             * Mark replication job for removal.
             *
             * @param force Will remove the jobconfig entry, but will not cleanup.
             * @param keep  Keep replicated data at target (do not remove).
             * @return Result
             */

            public Result delete(Boolean force, Boolean keep) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("force", force);
                parameters.put("keep", keep);
                return client.delete("/cluster/replication/" + this.id, parameters);
            }

            /**
             * Mark replication job for removal.
             *
             * @return Result
             */

            public Result delete() {
                return client.delete("/cluster/replication/" + this.id, null);
            }

            /**
             * Read replication job configuration.
             *
             * @return Result
             */

            public Result read() {
                return client.get("/cluster/replication/" + this.id, null);
            }

            /**
             * Update replication job configuration.
             *
             * @param comment    Description.
             * @param delete     A list of settings you want to delete.
             * @param digest     Prevent changes if current configuration file has a
             *                   different digest. This can be used to prevent concurrent
             *                   modifications.
             * @param disable    Flag to disable/deactivate the entry.
             * @param rate       Rate limit in mbps (megabytes per second) as floating point
             *                   number.
             * @param remove_job Mark the replication job for removal. The job will remove
             *                   all local replication snapshots. When set to 'full', it
             *                   also tries to remove replicated volumes on the target. The
             *                   job then removes itself from the configuration file.
             *                   Enum: local,full
             * @param schedule   Storage replication schedule. The format is a subset of
             *                   `systemd` calendar events.
             * @param source     For internal use, to detect if the guest was stolen.
             * @return Result
             */

            public Result update(String comment, String delete, String digest, Boolean disable, Float rate,
                                 String remove_job, String schedule, String source) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("comment", comment);
                parameters.put("delete", delete);
                parameters.put("digest", digest);
                parameters.put("disable", disable);
                parameters.put("rate", rate);
                parameters.put("remove_job", remove_job);
                parameters.put("schedule", schedule);
                parameters.put("source", source);
                return client.set("/cluster/replication/" + this.id, parameters);
            }

            /**
             * Update replication job configuration.
             *
             * @return Result
             */

            public Result update() {
                return client.set("/cluster/replication/" + this.id, null);
            }

        }

        /**
         * List replication jobs.
         *
         * @return Result
         */

        public Result index() {
            return client.get("/cluster/replication", null);
        }

        /**
         * Create a new replication job
         *
         * @param id         Replication Job ID. The ID is composed of a Guest ID and a
         *                   job number, separated by a hyphen, i.e.
         *                   '&amp;lt;GUEST&amp;gt;-&amp;lt;JOBNUM&amp;gt;'.
         * @param target     Target node.
         * @param type       Section type.
         *                   Enum: local
         * @param comment    Description.
         * @param disable    Flag to disable/deactivate the entry.
         * @param rate       Rate limit in mbps (megabytes per second) as floating point
         *                   number.
         * @param remove_job Mark the replication job for removal. The job will remove
         *                   all local replication snapshots. When set to 'full', it
         *                   also tries to remove replicated volumes on the target. The
         *                   job then removes itself from the configuration file.
         *                   Enum: local,full
         * @param schedule   Storage replication schedule. The format is a subset of
         *                   `systemd` calendar events.
         * @param source     For internal use, to detect if the guest was stolen.
         * @return Result
         */

        public Result create(String id, String target, String type, String comment, Boolean disable, Float rate,
                             String remove_job, String schedule, String source) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("id", id);
            parameters.put("target", target);
            parameters.put("type", type);
            parameters.put("comment", comment);
            parameters.put("disable", disable);
            parameters.put("rate", rate);
            parameters.put("remove_job", remove_job);
            parameters.put("schedule", schedule);
            parameters.put("source", source);
            return client.create("/cluster/replication", parameters);
        }

        /**
         * Create a new replication job
         *
         * @param id     Replication Job ID. The ID is composed of a Guest ID and a job
         *               number, separated by a hyphen, i.e.
         *               '&amp;lt;GUEST&amp;gt;-&amp;lt;JOBNUM&amp;gt;'.
         * @param target Target node.
         * @param type   Section type.
         *               Enum: local
         * @return Result
         */

        public Result create(String id, String target, String type) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("id", id);
            parameters.put("target", target);
            parameters.put("type", type);
            return client.create("/cluster/replication", parameters);
        }

    }

    public static class PVEBackupInfo {

        private final PveClient client;

        protected PVEBackupInfo(PveClient client) {
            this.client = client;

        }

        private PVENotBackedUp notBackedUp;

        public PVENotBackedUp getNotBackedUp() {
            return notBackedUp == null ? (notBackedUp = new PVENotBackedUp(client)) : notBackedUp;
        }

        public static class PVENotBackedUp {

            private final PveClient client;

            protected PVENotBackedUp(PveClient client) {
                this.client = client;

            }

            /**
             * Shows all guests which are not covered by any backup job.
             *
             * @return Result
             */

            public Result getGuestsNotInBackup() {
                return client.get("/cluster/backup-info/not-backed-up", null);
            }

        }

        /**
         * Index for backup info related endpoints
         *
         * @return Result
         */

        public Result index() {
            return client.get("/cluster/backup-info", null);
        }

    }

    public static class PVECeph {

        private final PveClient client;

        protected PVECeph(PveClient client) {
            this.client = client;

        }

        private PVEMetadata metadata;

        public PVEMetadata getMetadata() {
            return metadata == null ? (metadata = new PVEMetadata(client)) : metadata;
        }

        private PVEStatus status;

        public PVEStatus getStatus() {
            return status == null ? (status = new PVEStatus(client)) : status;
        }

        private PVEFlags flags;

        public PVEFlags getFlags() {
            return flags == null ? (flags = new PVEFlags(client)) : flags;
        }

        public static class PVEMetadata {

            private final PveClient client;

            protected PVEMetadata(PveClient client) {
                this.client = client;

            }

            /**
             * Get ceph metadata.
             *
             * @param scope Enum: all,versions
             * @return Result
             */

            public Result metadata(String scope) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("scope", scope);
                return client.get("/cluster/ceph/metadata", parameters);
            }

            /**
             * Get ceph metadata.
             *
             * @return Result
             */

            public Result metadata() {
                return client.get("/cluster/ceph/metadata", null);
            }

        }

        public static class PVEStatus {

            private final PveClient client;

            protected PVEStatus(PveClient client) {
                this.client = client;

            }

            /**
             * Get ceph status.
             *
             * @return Result
             */

            public Result status() {
                return client.get("/cluster/ceph/status", null);
            }

        }

        public static class PVEFlags {

            private final PveClient client;

            protected PVEFlags(PveClient client) {
                this.client = client;

            }

            public PVEFlagItem get(Object flag) {
                return new PVEFlagItem(client, flag);
            }

            public static class PVEFlagItem {

                private final PveClient client;
                private final Object flag;

                protected PVEFlagItem(PveClient client, Object flag) {
                    this.client = client;
                    this.flag = flag;
                }

                /**
                 * Get the status of a specific ceph flag.
                 *
                 * @return Result
                 */

                public Result getFlag() {
                    return client.get("/cluster/ceph/flags/" + this.flag, null);
                }

                /**
                 * Set or clear (unset) a specific ceph flag
                 *
                 * @param value The new value of the flag
                 * @return Result
                 */

                public Result updateFlag(boolean value) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("value", value);
                    return client.set("/cluster/ceph/flags/" + this.flag, parameters);
                }

            }

            /**
             * get the status of all ceph flags
             *
             * @return Result
             */

            public Result getAllFlags() {
                return client.get("/cluster/ceph/flags", null);
            }

            /**
             * Set/Unset multiple ceph flags at once.
             *
             * @param nobackfill   Backfilling of PGs is suspended.
             * @param nodeep_scrub Deep Scrubbing is disabled.
             * @param nodown       OSD failure reports are being ignored, such that the
             *                     monitors will not mark OSDs down.
             * @param noin         OSDs that were previously marked out will not be marked
             *                     back in when they start.
             * @param noout        OSDs will not automatically be marked out after the
             *                     configured interval.
             * @param norebalance  Rebalancing of PGs is suspended.
             * @param norecover    Recovery of PGs is suspended.
             * @param noscrub      Scrubbing is disabled.
             * @param notieragent  Cache tiering activity is suspended.
             * @param noup         OSDs are not allowed to start.
             * @param pause        Pauses read and writes.
             * @return Result
             */

            public Result setFlags(Boolean nobackfill, Boolean nodeep_scrub, Boolean nodown, Boolean noin,
                                   Boolean noout, Boolean norebalance, Boolean norecover, Boolean noscrub, Boolean notieragent,
                                   Boolean noup, Boolean pause) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("nobackfill", nobackfill);
                parameters.put("nodeep-scrub", nodeep_scrub);
                parameters.put("nodown", nodown);
                parameters.put("noin", noin);
                parameters.put("noout", noout);
                parameters.put("norebalance", norebalance);
                parameters.put("norecover", norecover);
                parameters.put("noscrub", noscrub);
                parameters.put("notieragent", notieragent);
                parameters.put("noup", noup);
                parameters.put("pause", pause);
                return client.set("/cluster/ceph/flags", parameters);
            }

            /**
             * Set/Unset multiple ceph flags at once.
             *
             * @return Result
             */

            public Result setFlags() {
                return client.set("/cluster/ceph/flags", null);
            }

        }

        /**
         * Cluster ceph index.
         *
         * @return Result
         */

        public Result cephindex() {
            return client.get("/cluster/ceph", null);
        }

    }

    public static class PVEJobs {

        private final PveClient client;

        protected PVEJobs(PveClient client) {
            this.client = client;

        }

        private PVERealmSync realmSync;

        public PVERealmSync getRealmSync() {
            return realmSync == null ? (realmSync = new PVERealmSync(client)) : realmSync;
        }

        private PVEScheduleAnalyze scheduleAnalyze;

        public PVEScheduleAnalyze getScheduleAnalyze() {
            return scheduleAnalyze == null ? (scheduleAnalyze = new PVEScheduleAnalyze(client)) : scheduleAnalyze;
        }

        public static class PVERealmSync {

            private final PveClient client;

            protected PVERealmSync(PveClient client) {
                this.client = client;

            }

            public PVEIdItem get(Object id) {
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
                 * Delete realm-sync job definition.
                 *
                 * @return Result
                 */

                public Result deleteJob() {
                    return client.delete("/cluster/jobs/realm-sync/" + this.id, null);
                }

                /**
                 * Read realm-sync job definition.
                 *
                 * @return Result
                 */

                public Result readJob() {
                    return client.get("/cluster/jobs/realm-sync/" + this.id, null);
                }

                /**
                 * Create new realm-sync job.
                 *
                 * @param schedule        Backup schedule. The format is a subset of `systemd`
                 *                        calendar events.
                 * @param comment         Description for the Job.
                 * @param enable_new      Enable newly synced users immediately.
                 * @param enabled         Determines if the job is enabled.
                 * @param realm           Authentication domain ID
                 * @param remove_vanished A semicolon-separated list of things to remove when
                 *                        they or the user vanishes during a sync. The following
                 *                        values are possible: 'entry' removes the user/group
                 *                        when not returned from the sync. 'properties' removes
                 *                        the set properties on existing user/group that do not
                 *                        appear in the source (even custom ones). 'acl' removes
                 *                        acls when the user/group is not returned from the
                 *                        sync. Instead of a list it also can be 'none' (the
                 *                        default).
                 * @param scope           Select what to sync.
                 *                        Enum: users,groups,both
                 * @return Result
                 */

                public Result createJob(String schedule, String comment, Boolean enable_new, Boolean enabled,
                                        String realm, String remove_vanished, String scope) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("schedule", schedule);
                    parameters.put("comment", comment);
                    parameters.put("enable-new", enable_new);
                    parameters.put("enabled", enabled);
                    parameters.put("realm", realm);
                    parameters.put("remove-vanished", remove_vanished);
                    parameters.put("scope", scope);
                    return client.create("/cluster/jobs/realm-sync/" + this.id, parameters);
                }

                /**
                 * Create new realm-sync job.
                 *
                 * @param schedule Backup schedule. The format is a subset of `systemd` calendar
                 *                 events.
                 * @return Result
                 */

                public Result createJob(String schedule) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("schedule", schedule);
                    return client.create("/cluster/jobs/realm-sync/" + this.id, parameters);
                }

                /**
                 * Update realm-sync job definition.
                 *
                 * @param schedule        Backup schedule. The format is a subset of `systemd`
                 *                        calendar events.
                 * @param comment         Description for the Job.
                 * @param delete          A list of settings you want to delete.
                 * @param enable_new      Enable newly synced users immediately.
                 * @param enabled         Determines if the job is enabled.
                 * @param remove_vanished A semicolon-separated list of things to remove when
                 *                        they or the user vanishes during a sync. The following
                 *                        values are possible: 'entry' removes the user/group
                 *                        when not returned from the sync. 'properties' removes
                 *                        the set properties on existing user/group that do not
                 *                        appear in the source (even custom ones). 'acl' removes
                 *                        acls when the user/group is not returned from the
                 *                        sync. Instead of a list it also can be 'none' (the
                 *                        default).
                 * @param scope           Select what to sync.
                 *                        Enum: users,groups,both
                 * @return Result
                 */

                public Result updateJob(String schedule, String comment, String delete, Boolean enable_new,
                                        Boolean enabled, String remove_vanished, String scope) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("schedule", schedule);
                    parameters.put("comment", comment);
                    parameters.put("delete", delete);
                    parameters.put("enable-new", enable_new);
                    parameters.put("enabled", enabled);
                    parameters.put("remove-vanished", remove_vanished);
                    parameters.put("scope", scope);
                    return client.set("/cluster/jobs/realm-sync/" + this.id, parameters);
                }

                /**
                 * Update realm-sync job definition.
                 *
                 * @param schedule Backup schedule. The format is a subset of `systemd` calendar
                 *                 events.
                 * @return Result
                 */

                public Result updateJob(String schedule) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("schedule", schedule);
                    return client.set("/cluster/jobs/realm-sync/" + this.id, parameters);
                }

            }

            /**
             * List configured realm-sync-jobs.
             *
             * @return Result
             */

            public Result syncjobIndex() {
                return client.get("/cluster/jobs/realm-sync", null);
            }

        }

        public static class PVEScheduleAnalyze {

            private final PveClient client;

            protected PVEScheduleAnalyze(PveClient client) {
                this.client = client;

            }

            /**
             * Returns a list of future schedule runtimes.
             *
             * @param schedule   Job schedule. The format is a subset of `systemd` calendar
             *                   events.
             * @param iterations Number of event-iteration to simulate and return.
             * @param starttime  UNIX timestamp to start the calculation from. Defaults to
             *                   the current time.
             * @return Result
             */

            public Result scheduleAnalyze(String schedule, Integer iterations, Integer starttime) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("schedule", schedule);
                parameters.put("iterations", iterations);
                parameters.put("starttime", starttime);
                return client.get("/cluster/jobs/schedule-analyze", parameters);
            }

            /**
             * Returns a list of future schedule runtimes.
             *
             * @param schedule Job schedule. The format is a subset of `systemd` calendar
             *                 events.
             * @return Result
             */

            public Result scheduleAnalyze(String schedule) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("schedule", schedule);
                return client.get("/cluster/jobs/schedule-analyze", parameters);
            }

        }

        /**
         * Index for jobs related endpoints.
         *
         * @return Result
         */

        public Result index() {
            return client.get("/cluster/jobs", null);
        }

    }

    public static class PVEBulkAction {

        private final PveClient client;

        protected PVEBulkAction(PveClient client) {
            this.client = client;

        }

        private PVEGuest guest;

        public PVEGuest getGuest() {
            return guest == null ? (guest = new PVEGuest(client)) : guest;
        }

        public static class PVEGuest {

            private final PveClient client;

            protected PVEGuest(PveClient client) {
                this.client = client;

            }

            private PVEStart start;

            public PVEStart getStart() {
                return start == null ? (start = new PVEStart(client)) : start;
            }

            private PVEShutdown shutdown;

            public PVEShutdown getShutdown() {
                return shutdown == null ? (shutdown = new PVEShutdown(client)) : shutdown;
            }

            private PVESuspend suspend;

            public PVESuspend getSuspend() {
                return suspend == null ? (suspend = new PVESuspend(client)) : suspend;
            }

            private PVEMigrate migrate;

            public PVEMigrate getMigrate() {
                return migrate == null ? (migrate = new PVEMigrate(client)) : migrate;
            }

            public static class PVEStart {

                private final PveClient client;

                protected PVEStart(PveClient client) {
                    this.client = client;

                }

                /**
                 * Bulk start or resume all guests on the cluster.
                 *
                 * @param maxworkers How many parallel tasks at maximum should be started.
                 * @param timeout    Default start timeout in seconds. Only valid for VMs.
                 *                   (default depends on the guest configuration).
                 * @param vms        Only consider guests from this list of VMIDs.
                 * @return Result
                 */

                public Result start(Integer maxworkers, Integer timeout, List<Object> vms) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("maxworkers", maxworkers);
                    parameters.put("timeout", timeout);
                    parameters.put("vms", vms);
                    return client.create("/cluster/bulk-action/guest/start", parameters);
                }

                /**
                 * Bulk start or resume all guests on the cluster.
                 *
                 * @return Result
                 */

                public Result start() {
                    return client.create("/cluster/bulk-action/guest/start", null);
                }

            }

            public static class PVEShutdown {

                private final PveClient client;

                protected PVEShutdown(PveClient client) {
                    this.client = client;

                }

                /**
                 * Bulk shutdown all guests on the cluster.
                 *
                 * @param force_stop Makes sure the Guest stops after the timeout.
                 * @param maxworkers How many parallel tasks at maximum should be started.
                 * @param timeout    Default shutdown timeout in seconds if none is configured
                 *                   for the guest.
                 * @param vms        Only consider guests from this list of VMIDs.
                 * @return Result
                 */

                public Result shutdown(Boolean force_stop, Integer maxworkers, Integer timeout, List<Object> vms) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("force-stop", force_stop);
                    parameters.put("maxworkers", maxworkers);
                    parameters.put("timeout", timeout);
                    parameters.put("vms", vms);
                    return client.create("/cluster/bulk-action/guest/shutdown", parameters);
                }

                /**
                 * Bulk shutdown all guests on the cluster.
                 *
                 * @return Result
                 */

                public Result shutdown() {
                    return client.create("/cluster/bulk-action/guest/shutdown", null);
                }

            }

            public static class PVESuspend {

                private final PveClient client;

                protected PVESuspend(PveClient client) {
                    this.client = client;

                }

                /**
                 * Bulk suspend all guests on the cluster.
                 *
                 * @param maxworkers   How many parallel tasks at maximum should be started.
                 * @param statestorage The storage for the VM state.
                 * @param to_disk      If set, suspends the guests to disk. Will be resumed on
                 *                     next start.
                 * @param vms          Only consider guests from this list of VMIDs.
                 * @return Result
                 */

                public Result suspend(Integer maxworkers, String statestorage, Boolean to_disk, List<Object> vms) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("maxworkers", maxworkers);
                    parameters.put("statestorage", statestorage);
                    parameters.put("to-disk", to_disk);
                    parameters.put("vms", vms);
                    return client.create("/cluster/bulk-action/guest/suspend", parameters);
                }

                /**
                 * Bulk suspend all guests on the cluster.
                 *
                 * @return Result
                 */

                public Result suspend() {
                    return client.create("/cluster/bulk-action/guest/suspend", null);
                }

            }

            public static class PVEMigrate {

                private final PveClient client;

                protected PVEMigrate(PveClient client) {
                    this.client = client;

                }

                /**
                 * Bulk migrate all guests on the cluster.
                 *
                 * @param target           Target node.
                 * @param maxworkers       How many parallel tasks at maximum should be started.
                 * @param online           Enable live migration for VMs and restart migration
                 *                         for CTs.
                 * @param vms              Only consider guests from this list of VMIDs.
                 * @param with_local_disks Enable live storage migration for local disk
                 * @return Result
                 */

                public Result migrate(String target, Integer maxworkers, Boolean online, List<Object> vms,
                                      Boolean with_local_disks) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("target", target);
                    parameters.put("maxworkers", maxworkers);
                    parameters.put("online", online);
                    parameters.put("vms", vms);
                    parameters.put("with-local-disks", with_local_disks);
                    return client.create("/cluster/bulk-action/guest/migrate", parameters);
                }

                /**
                 * Bulk migrate all guests on the cluster.
                 *
                 * @param target Target node.
                 * @return Result
                 */

                public Result migrate(String target) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("target", target);
                    return client.create("/cluster/bulk-action/guest/migrate", parameters);
                }

            }

            /**
             * Bulk action index.
             *
             * @return Result
             */

            public Result index() {
                return client.get("/cluster/bulk-action/guest", null);
            }

        }

        /**
         * List resource types.
         *
         * @return Result
         */

        public Result index() {
            return client.get("/cluster/bulk-action", null);
        }

    }

    public static class PVELog {

        private final PveClient client;

        protected PVELog(PveClient client) {
            this.client = client;

        }

        /**
         * Read cluster log
         *
         * @param max Maximum number of entries.
         * @return Result
         */

        public Result log(Integer max) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("max", max);
            return client.get("/cluster/log", parameters);
        }

        /**
         * Read cluster log
         *
         * @return Result
         */

        public Result log() {
            return client.get("/cluster/log", null);
        }

    }

    public static class PVEResources {

        private final PveClient client;

        protected PVEResources(PveClient client) {
            this.client = client;

        }

        /**
         * Resources index (cluster wide).
         *
         * @param type Resource type.
         *             Enum: vm,storage,node,sdn
         * @return Result
         */

        public Result resources(String type) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("type", type);
            return client.get("/cluster/resources", parameters);
        }

        /**
         * Resources index (cluster wide).
         *
         * @return Result
         */

        public Result resources() {
            return client.get("/cluster/resources", null);
        }

    }

    public static class PVETasks {

        private final PveClient client;

        protected PVETasks(PveClient client) {
            this.client = client;

        }

        /**
         * List recent tasks (cluster wide).
         *
         * @return Result
         */

        public Result tasks() {
            return client.get("/cluster/tasks", null);
        }

    }

    public static class PVEOptions {

        private final PveClient client;

        protected PVEOptions(PveClient client) {
            this.client = client;

        }

        /**
         * Get datacenter options. Without 'Sys.Audit' on '/' not all options are
         * returned.
         *
         * @return Result
         */

        public Result getOptions() {
            return client.get("/cluster/options", null);
        }

        /**
         * Set datacenter options.
         *
         * @param bwlimit            Set I/O bandwidth limit for various operations (in
         *                           KiB/s).
         * @param consent_text       Consent text that is displayed before logging in.
         * @param console            Select the default Console viewer. You can either
         *                           use the builtin java applet (VNC; deprecated and
         *                           maps to html5), an external virt-viewer comtatible
         *                           application (SPICE), an HTML5 based vnc viewer
         *                           (noVNC), or an HTML5 based console client
         *                           (xtermjs). If the selected viewer is not available
         *                           (e.g. SPICE not activated for the VM), the fallback
         *                           is noVNC.
         *                           Enum: applet,vv,html5,xtermjs
         * @param crs                Cluster resource scheduling settings.
         * @param delete             A list of settings you want to delete.
         * @param description        Datacenter description. Shown in the web-interface
         *                           datacenter notes panel. This is saved as comment
         *                           inside the configuration file.
         * @param email_from         Specify email address to send notification from
         *                           (default is root@$hostname)
         * @param fencing            Set the fencing mode of the HA cluster. Hardware
         *                           mode needs a valid configuration of fence devices
         *                           in /etc/pve/ha/fence.cfg. With both all two modes
         *                           are used. WARNING: 'hardware' and 'both' are
         *                           EXPERIMENTAL &amp; WIP
         *                           Enum: watchdog,hardware,both
         * @param ha                 Cluster wide HA settings.
         * @param http_proxy         Specify external http proxy which is used for
         *                           downloads (example:
         *                           'http://username:password@host:port/')
         * @param keyboard           Default keybord layout for vnc server.
         *                           Enum:
         *                           de,de-ch,da,en-gb,en-us,es,fi,fr,fr-be,fr-ca,fr-ch,hu,is,it,ja,lt,mk,nl,no,pl,pt,pt-br,sv,sl,tr
         * @param language           Default GUI language.
         *                           Enum:
         *                           ar,ca,da,de,en,es,eu,fa,fr,hr,he,it,ja,ka,kr,nb,nl,nn,pl,pt_BR,ru,sl,sv,tr,ukr,zh_CN,zh_TW
         * @param mac_prefix         Prefix for the auto-generated MAC addresses of
         *                           virtual guests. The default 'BC:24:11' is the OUI
         *                           assigned by the IEEE to Proxmox Server Solutions
         *                           GmbH for a 24-bit large MAC block. You're allowed
         *                           to use this in local networks, i.e., those not
         *                           directly reachable by the public (e.g., in a LAN or
         *                           behind NAT).
         * @param max_workers        Defines how many workers (per node) are maximal
         *                           started on actions like 'stopall VMs' or task from
         *                           the ha-manager.
         * @param migration          For cluster wide migration settings.
         * @param migration_unsecure Migration is secure using SSH tunnel by default.
         *                           For secure private networks you can disable it to
         *                           speed up migration. Deprecated, use the 'migration'
         *                           property instead!
         * @param next_id            Control the range for the free VMID auto-selection
         *                           pool.
         * @param notify             Cluster-wide notification settings.
         * @param registered_tags    A list of tags that require a `Sys.Modify` on '/'
         *                           to set and delete. Tags set here that are also in
         *                           'user-tag-access' also require `Sys.Modify`.
         * @param replication        For cluster wide replication settings.
         * @param tag_style          Tag style options.
         * @param u2f                u2f
         * @param user_tag_access    Privilege options for user-settable tags
         * @param webauthn           webauthn configuration
         * @return Result
         */

        public Result setOptions(String bwlimit, String consent_text, String console, String crs, String delete,
                                 String description, String email_from, String fencing, String ha, String http_proxy,
                                 String keyboard, String language, String mac_prefix, Integer max_workers, String migration,
                                 Boolean migration_unsecure, String next_id, String notify, String registered_tags,
                                 String replication, String tag_style, String u2f, String user_tag_access, String webauthn) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("bwlimit", bwlimit);
            parameters.put("consent-text", consent_text);
            parameters.put("console", console);
            parameters.put("crs", crs);
            parameters.put("delete", delete);
            parameters.put("description", description);
            parameters.put("email_from", email_from);
            parameters.put("fencing", fencing);
            parameters.put("ha", ha);
            parameters.put("http_proxy", http_proxy);
            parameters.put("keyboard", keyboard);
            parameters.put("language", language);
            parameters.put("mac_prefix", mac_prefix);
            parameters.put("max_workers", max_workers);
            parameters.put("migration", migration);
            parameters.put("migration_unsecure", migration_unsecure);
            parameters.put("next-id", next_id);
            parameters.put("notify", notify);
            parameters.put("registered-tags", registered_tags);
            parameters.put("replication", replication);
            parameters.put("tag-style", tag_style);
            parameters.put("u2f", u2f);
            parameters.put("user-tag-access", user_tag_access);
            parameters.put("webauthn", webauthn);
            return client.set("/cluster/options", parameters);
        }

        /**
         * Set datacenter options.
         *
         * @return Result
         */

        public Result setOptions() {
            return client.set("/cluster/options", null);
        }

    }

    public static class PVEStatus {

        private final PveClient client;

        protected PVEStatus(PveClient client) {
            this.client = client;

        }

        /**
         * Get cluster status information.
         *
         * @return Result
         */

        public Result getStatus() {
            return client.get("/cluster/status", null);
        }

    }

    public static class PVENextid {

        private final PveClient client;

        protected PVENextid(PveClient client) {
            this.client = client;

        }

        /**
         * Get next free VMID. Pass a VMID to assert that its free (at time of check).
         *
         * @param vmid The (unique) ID of the VM.
         * @return Result
         */

        public Result nextid(Integer vmid) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("vmid", vmid);
            return client.get("/cluster/nextid", parameters);
        }

        /**
         * Get next free VMID. Pass a VMID to assert that its free (at time of check).
         *
         * @return Result
         */

        public Result nextid() {
            return client.get("/cluster/nextid", null);
        }

    }

    /**
     * Cluster index.
     *
     * @return Result
     */

    public Result index() {
        return client.get("/cluster", null);
    }

}

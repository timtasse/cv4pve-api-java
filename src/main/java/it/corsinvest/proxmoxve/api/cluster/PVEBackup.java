package it.corsinvest.proxmoxve.api.cluster;

import it.corsinvest.proxmoxve.api.PveClient;
import it.corsinvest.proxmoxve.api.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class PVEBackup {

    private final PveClient client;

    public PVEBackup(PveClient client) {
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

        private PVEIdItem.PVEIncludedVolumes includedVolumes;

        public PVEIdItem.PVEIncludedVolumes getIncludedVolumes() {
            return includedVolumes == null ? (includedVolumes = new PVEIncludedVolumes(client, this.id))
                    : includedVolumes;
        }

        public static class PVEIncludedVolumes {

            private final PveClient client;
            private final Object id;

            protected PVEIncludedVolumes(PveClient client, Object id) {
                this.client = client;
                this.id = id;
            }

            /**
             * Returns included guests and the backup status of their disks. Optimized to be
             * used in ExtJS tree views.
             *
             * @return Result
             */

            public Result getVolumeBackupIncluded() {
                return client.get("/cluster/backup/" + this.id + "/included_volumes", null);
            }

        }

        /**
         * Delete vzdump backup job definition.
         *
         * @return Result
         */

        public Result deleteJob() {
            return client.delete("/cluster/backup/" + this.id, null);
        }

        /**
         * Read vzdump backup job definition.
         *
         * @return Result
         */

        public Result readJob() {
            return client.get("/cluster/backup/" + this.id, null);
        }

        /**
         * Update vzdump backup job definition.
         *
         * @param all                       Backup all known guest systems on this host.
         * @param bwlimit                   Limit I/O bandwidth (in KiB/s).
         * @param comment                   Description for the Job.
         * @param compress                  Compress dump file.
         *                                  Enum: 0,1,gzip,lzo,zstd
         * @param delete                    A list of settings you want to delete.
         * @param dow                       Day of week selection.
         * @param dumpdir                   Store resulting files to specified
         *                                  directory.
         * @param enabled                   Enable or disable the job.
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
         * @param node                      Only run if executed on this node.
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
         * @param repeat_missed             If true, the job will be run as soon as
         *                                  possible if it was missed while the
         *                                  scheduler was not running.
         * @param schedule                  Backup schedule. The format is a subset of
         *                                  `systemd` calendar events.
         * @param script                    Use specified hook script.
         * @param starttime                 Job Start time.
         * @param stdexcludes               Exclude temporary files and logs.
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

        public Result updateJob(Boolean all, Integer bwlimit, String comment, String compress, String delete,
                                String dow, String dumpdir, Boolean enabled, String exclude, List<Object> exclude_path,
                                String fleecing, Integer ionice, Integer lockwait, String mailnotification, String mailto,
                                Integer maxfiles, String mode, String node, String notes_template, String notification_mode,
                                String pbs_change_detection_mode, String performance, Integer pigz, String pool,
                                Boolean protected_, String prune_backups, Boolean quiet, Boolean remove, Boolean repeat_missed,
                                String schedule, String script, String starttime, Boolean stdexcludes, Boolean stop,
                                Integer stopwait, String storage, String tmpdir, String vmid, Integer zstd) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("all", all);
            parameters.put("bwlimit", bwlimit);
            parameters.put("comment", comment);
            parameters.put("compress", compress);
            parameters.put("delete", delete);
            parameters.put("dow", dow);
            parameters.put("dumpdir", dumpdir);
            parameters.put("enabled", enabled);
            parameters.put("exclude", exclude);
            parameters.put("exclude-path", exclude_path);
            parameters.put("fleecing", fleecing);
            parameters.put("ionice", ionice);
            parameters.put("lockwait", lockwait);
            parameters.put("mailnotification", mailnotification);
            parameters.put("mailto", mailto);
            parameters.put("maxfiles", maxfiles);
            parameters.put("mode", mode);
            parameters.put("node", node);
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
            parameters.put("repeat-missed", repeat_missed);
            parameters.put("schedule", schedule);
            parameters.put("script", script);
            parameters.put("starttime", starttime);
            parameters.put("stdexcludes", stdexcludes);
            parameters.put("stop", stop);
            parameters.put("stopwait", stopwait);
            parameters.put("storage", storage);
            parameters.put("tmpdir", tmpdir);
            parameters.put("vmid", vmid);
            parameters.put("zstd", zstd);
            return client.set("/cluster/backup/" + this.id, parameters);
        }

        /**
         * Update vzdump backup job definition.
         *
         * @return Result
         */

        public Result updateJob() {
            return client.set("/cluster/backup/" + this.id, null);
        }

    }

    /**
     * List vzdump backup schedule.
     *
     * @return Result
     */

    public Result index() {
        return client.get("/cluster/backup", null);
    }

    /**
     * Create new vzdump backup job.
     *
     * @param all                       Backup all known guest systems on this host.
     * @param bwlimit                   Limit I/O bandwidth (in KiB/s).
     * @param comment                   Description for the Job.
     * @param compress                  Compress dump file.
     *                                  Enum: 0,1,gzip,lzo,zstd
     * @param dow                       Day of week selection.
     * @param dumpdir                   Store resulting files to specified
     *                                  directory.
     * @param enabled                   Enable or disable the job.
     * @param exclude                   Exclude specified guest systems (assumes
     *                                  --all)
     * @param exclude_path              Exclude certain files/directories (shell
     *                                  globs). Paths starting with '/' are anchored
     *                                  to the container's root, other paths match
     *                                  relative to each subdirectory.
     * @param fleecing                  Options for backup fleecing (VM only).
     * @param id                        Job ID (will be autogenerated).
     * @param ionice                    Set IO priority when using the BFQ
     *                                  scheduler. For snapshot and suspend mode
     *                                  backups of VMs, this only affects the
     *                                  compressor. A value of 8 means the idle
     *                                  priority is used, otherwise the best-effort
     *                                  priority is used with the specified value.
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
     * @param node                      Only run if executed on this node.
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
     * @param repeat_missed             If true, the job will be run as soon as
     *                                  possible if it was missed while the
     *                                  scheduler was not running.
     * @param schedule                  Backup schedule. The format is a subset of
     *                                  `systemd` calendar events.
     * @param script                    Use specified hook script.
     * @param starttime                 Job Start time.
     * @param stdexcludes               Exclude temporary files and logs.
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

    public Result createJob(Boolean all, Integer bwlimit, String comment, String compress, String dow,
                            String dumpdir, Boolean enabled, String exclude, List<Object> exclude_path, String fleecing,
                            String id, Integer ionice, Integer lockwait, String mailnotification, String mailto,
                            Integer maxfiles, String mode, String node, String notes_template, String notification_mode,
                            String pbs_change_detection_mode, String performance, Integer pigz, String pool, Boolean protected_,
                            String prune_backups, Boolean quiet, Boolean remove, Boolean repeat_missed, String schedule,
                            String script, String starttime, Boolean stdexcludes, Boolean stop, Integer stopwait,
                            String storage, String tmpdir, String vmid, Integer zstd) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("all", all);
        parameters.put("bwlimit", bwlimit);
        parameters.put("comment", comment);
        parameters.put("compress", compress);
        parameters.put("dow", dow);
        parameters.put("dumpdir", dumpdir);
        parameters.put("enabled", enabled);
        parameters.put("exclude", exclude);
        parameters.put("exclude-path", exclude_path);
        parameters.put("fleecing", fleecing);
        parameters.put("id", id);
        parameters.put("ionice", ionice);
        parameters.put("lockwait", lockwait);
        parameters.put("mailnotification", mailnotification);
        parameters.put("mailto", mailto);
        parameters.put("maxfiles", maxfiles);
        parameters.put("mode", mode);
        parameters.put("node", node);
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
        parameters.put("repeat-missed", repeat_missed);
        parameters.put("schedule", schedule);
        parameters.put("script", script);
        parameters.put("starttime", starttime);
        parameters.put("stdexcludes", stdexcludes);
        parameters.put("stop", stop);
        parameters.put("stopwait", stopwait);
        parameters.put("storage", storage);
        parameters.put("tmpdir", tmpdir);
        parameters.put("vmid", vmid);
        parameters.put("zstd", zstd);
        return client.create("/cluster/backup", parameters);
    }

    /**
     * Create new vzdump backup job.
     *
     * @return Result
     */

    public Result createJob() {
        return client.create("/cluster/backup", null);
    }

}

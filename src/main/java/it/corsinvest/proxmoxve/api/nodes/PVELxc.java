package it.corsinvest.proxmoxve.api.nodes;

import it.corsinvest.proxmoxve.api.PveClient;
import it.corsinvest.proxmoxve.api.PveClientBase;
import it.corsinvest.proxmoxve.api.Result;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class PVELxc {

    private final PveClient client;
    private final Object node;

    public PVELxc(PveClient client, Object node) {
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

        private PVEVmidItem.PVEConfig config;

        public PVEVmidItem.PVEConfig getConfig() {
            return config == null ? (config = new PVEConfig(client, this.node, this.vmid)) : config;
        }

        private PVEVmidItem.PVEStatus status;

        public PVEVmidItem.PVEStatus getStatus() {
            return status == null ? (status = new PVEStatus(client, this.node, this.vmid)) : status;
        }

        private PVEVmidItem.PVESnapshot snapshot;

        public PVEVmidItem.PVESnapshot getSnapshot() {
            return snapshot == null ? (snapshot = new PVESnapshot(client, this.node, this.vmid)) : snapshot;
        }

        private PVEVmidItem.PVEFirewall firewall;

        public PVEVmidItem.PVEFirewall getFirewall() {
            return firewall == null ? (firewall = new PVEFirewall(client, this.node, this.vmid)) : firewall;
        }

        private PVEVmidItem.PVERrd rrd;

        public PVEVmidItem.PVERrd getRrd() {
            return rrd == null ? (rrd = new PVERrd(client, this.node, this.vmid)) : rrd;
        }

        private PVEVmidItem.PVERrddata rrddata;

        public PVEVmidItem.PVERrddata getRrddata() {
            return rrddata == null ? (rrddata = new PVERrddata(client, this.node, this.vmid)) : rrddata;
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

        private PVEVmidItem.PVERemoteMigrate remoteMigrate;

        public PVEVmidItem.PVERemoteMigrate getRemoteMigrate() {
            return remoteMigrate == null
                    ? (remoteMigrate = new PVERemoteMigrate(client, this.node, this.vmid))
                    : remoteMigrate;
        }

        private PVEVmidItem.PVEMigrate migrate;

        public PVEVmidItem.PVEMigrate getMigrate() {
            return migrate == null ? (migrate = new PVEMigrate(client, this.node, this.vmid)) : migrate;
        }

        private PVEVmidItem.PVEFeature feature;

        public PVEVmidItem.PVEFeature getFeature() {
            return feature == null ? (feature = new PVEFeature(client, this.node, this.vmid)) : feature;
        }

        private PVEVmidItem.PVETemplate template;

        public PVEVmidItem.PVETemplate getTemplate() {
            return template == null ? (template = new PVETemplate(client, this.node, this.vmid)) : template;
        }

        private PVEVmidItem.PVEClone clone;

        public PVEVmidItem.PVEClone getClone() {
            return clone == null ? (clone = new PVEClone(client, this.node, this.vmid)) : clone;
        }

        private PVEVmidItem.PVEResize resize;

        public PVEVmidItem.PVEResize getResize() {
            return resize == null ? (resize = new PVEResize(client, this.node, this.vmid)) : resize;
        }

        private PVEVmidItem.PVEMoveVolume moveVolume;

        public PVEVmidItem.PVEMoveVolume getMoveVolume() {
            return moveVolume == null ? (moveVolume = new PVEMoveVolume(client, this.node, this.vmid))
                    : moveVolume;
        }

        private PVEVmidItem.PVEPending pending;

        public PVEVmidItem.PVEPending getPending() {
            return pending == null ? (pending = new PVEPending(client, this.node, this.vmid)) : pending;
        }

        private PVEVmidItem.PVEInterfaces interfaces;

        public PVEVmidItem.PVEInterfaces getInterfaces() {
            return interfaces == null ? (interfaces = new PVEInterfaces(client, this.node, this.vmid))
                    : interfaces;
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
             * Get container configuration.
             *
             * @param current  Get current values (instead of pending values).
             * @param snapshot Fetch config values from given snapshot.
             * @return Result
             */

            public Result vmConfig(Boolean current, String snapshot) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("current", current);
                parameters.put("snapshot", snapshot);
                return client.get("/nodes/" + this.node + "/lxc/" + this.vmid + "/config", parameters);
            }

            /**
             * Get container configuration.
             *
             * @return Result
             */

            public Result vmConfig() {
                return client.get("/nodes/" + this.node + "/lxc/" + this.vmid + "/config", null);
            }

            /**
             * Set container options.
             *
             * @param arch         OS architecture type.
             *                     Enum: amd64,i386,arm64,armhf,riscv32,riscv64
             * @param cmode        Console mode. By default, the console command tries to
             *                     open a connection to one of the available tty devices. By
             *                     setting cmode to 'console' it tries to attach to
             *                     /dev/console instead. If you set cmode to 'shell', it
             *                     simply invokes a shell inside the container (no login).
             *                     Enum: shell,console,tty
             * @param console      Attach a console device (/dev/console) to the container.
             * @param cores        The number of cores assigned to the container. A
             *                     container can use all available cores by default.
             * @param cpulimit     Limit of CPU usage. NOTE: If the computer has 2 CPUs, it
             *                     has a total of '2' CPU time. Value '0' indicates no CPU
             *                     limit.
             * @param cpuunits     CPU weight for a container, will be clamped to [1, 10000]
             *                     in cgroup v2.
             * @param debug        Try to be more verbose. For now this only enables debug
             *                     log-level on start.
             * @param delete       A list of settings you want to delete.
             * @param description  Description for the Container. Shown in the web-interface
             *                     CT's summary. This is saved as comment inside the
             *                     configuration file.
             * @param devN         Device to pass through to the container
             * @param digest       Prevent changes if current configuration file has
             *                     different SHA1 digest. This can be used to prevent
             *                     concurrent modifications.
             * @param entrypoint   Command to run as init, optionally with arguments; may
             *                     start with an absolute path, relative path, or a binary
             *                     in $PATH.
             * @param env          The container runtime environment as NUL-separated list.
             *                     Replaces any lxc.environment.runtime entries in the
             *                     config.
             * @param features     Allow containers access to advanced features.
             * @param hookscript   Script that will be executed during various steps in the
             *                     containers lifetime.
             * @param hostname     Set a host name for the container.
             * @param lock_        Lock/unlock the container.
             *                     Enum:
             *                     backup,create,destroyed,disk,fstrim,migrate,mounted,rollback,snapshot,snapshot-delete
             * @param memory       Amount of RAM for the container in MB.
             * @param mpN          Use volume as container mount point. Use the special
             *                     syntax STORAGE_ID:SIZE_IN_GiB to allocate a new volume.
             * @param nameserver   Sets DNS server IP address for a container. Create will
             *                     automatically use the setting from the host if you
             *                     neither set searchdomain nor nameserver.
             * @param netN         Specifies network interfaces for the container.
             * @param onboot       Specifies whether a container will be started during
             *                     system bootup.
             * @param ostype       OS type. This is used to set up configuration inside the
             *                     container, and corresponds to lxc setup scripts in
             *                     /usr/share/lxc/config/&amp;lt;ostype&amp;gt;.common.conf.
             *                     Value 'unmanaged' can be used to skip and OS specific
             *                     setup.
             *                     Enum:
             *                     debian,devuan,ubuntu,centos,fedora,opensuse,archlinux,alpine,gentoo,nixos,unmanaged
             * @param protection   Sets the protection flag of the container. This will
             *                     prevent the CT or CT's disk remove/update operation.
             * @param revert       Revert a pending change.
             * @param rootfs       Use volume as container root.
             * @param searchdomain Sets DNS search domains for a container. Create will
             *                     automatically use the setting from the host if you
             *                     neither set searchdomain nor nameserver.
             * @param startup      Startup and shutdown behavior. Order is a non-negative
             *                     number defining the general startup order. Shutdown in
             *                     done with reverse ordering. Additionally, you can set the
             *                     'up' or 'down' delay in seconds, which specifies a delay
             *                     to wait before the next VM is started or stopped.
             * @param swap         Amount of SWAP for the container in MB.
             * @param tags         Tags of the Container. This is only meta information.
             * @param template     Enable/disable Template.
             * @param timezone     Time zone to use in the container. If option isn't set,
             *                     then nothing will be done. Can be set to 'host' to match
             *                     the host time zone, or an arbitrary time zone option from
             *                     /usr/share/zoneinfo/zone.tab
             * @param tty          Specify the number of tty available to the container
             * @param unprivileged Makes the container run as unprivileged user. For
             *                     creation, the default is 1. For restore, the default is
             *                     the value from the backup. (Should not be modified
             *                     manually.)
             * @param unusedN      Reference to unused volumes. This is used internally, and
             *                     should not be modified manually.
             * @return Result
             */

            public Result updateVm(String arch, String cmode, Boolean console, Integer cores,
                                   Float cpulimit, Integer cpuunits, Boolean debug, String delete, String description,
                                   Map<Integer, String> devN, String digest, String entrypoint, String env,
                                   String features, String hookscript, String hostname, String lock_, Integer memory,
                                   Map<Integer, String> mpN, String nameserver, Map<Integer, String> netN, Boolean onboot,
                                   String ostype, Boolean protection, String revert, String rootfs, String searchdomain,
                                   String startup, Integer swap, String tags, Boolean template, String timezone,
                                   Integer tty, Boolean unprivileged, Map<Integer, String> unusedN) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("arch", arch);
                parameters.put("cmode", cmode);
                parameters.put("console", console);
                parameters.put("cores", cores);
                parameters.put("cpulimit", cpulimit);
                parameters.put("cpuunits", cpuunits);
                parameters.put("debug", debug);
                parameters.put("delete", delete);
                parameters.put("description", description);
                parameters.put("digest", digest);
                parameters.put("entrypoint", entrypoint);
                parameters.put("env", env);
                parameters.put("features", features);
                parameters.put("hookscript", hookscript);
                parameters.put("hostname", hostname);
                parameters.put("lock", lock_);
                parameters.put("memory", memory);
                parameters.put("nameserver", nameserver);
                parameters.put("onboot", onboot);
                parameters.put("ostype", ostype);
                parameters.put("protection", protection);
                parameters.put("revert", revert);
                parameters.put("rootfs", rootfs);
                parameters.put("searchdomain", searchdomain);
                parameters.put("startup", startup);
                parameters.put("swap", swap);
                parameters.put("tags", tags);
                parameters.put("template", template);
                parameters.put("timezone", timezone);
                parameters.put("tty", tty);
                parameters.put("unprivileged", unprivileged);
                PveClientBase.addIndexedParameter(parameters, "dev", devN);
                PveClientBase.addIndexedParameter(parameters, "mp", mpN);
                PveClientBase.addIndexedParameter(parameters, "net", netN);
                PveClientBase.addIndexedParameter(parameters, "unused", unusedN);
                return client.set("/nodes/" + this.node + "/lxc/" + this.vmid + "/config", parameters);
            }

            /**
             * Set container options.
             *
             * @return Result
             */

            public Result updateVm() {
                return client.set("/nodes/" + this.node + "/lxc/" + this.vmid + "/config", null);
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

            private PVEVmidItem.PVEStatus.PVEShutdown shutdown;

            public PVEVmidItem.PVEStatus.PVEShutdown getShutdown() {
                return shutdown == null ? (shutdown = new PVEShutdown(client, this.node, this.vmid))
                        : shutdown;
            }

            private PVEVmidItem.PVEStatus.PVESuspend suspend;

            public PVEVmidItem.PVEStatus.PVESuspend getSuspend() {
                return suspend == null ? (suspend = new PVESuspend(client, this.node, this.vmid)) : suspend;
            }

            private PVEVmidItem.PVEStatus.PVEResume resume;

            public PVEVmidItem.PVEStatus.PVEResume getResume() {
                return resume == null ? (resume = new PVEResume(client, this.node, this.vmid)) : resume;
            }

            private PVEVmidItem.PVEStatus.PVEReboot reboot;

            public PVEVmidItem.PVEStatus.PVEReboot getReboot() {
                return reboot == null ? (reboot = new PVEReboot(client, this.node, this.vmid)) : reboot;
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
                    return client.get("/nodes/" + this.node + "/lxc/" + this.vmid + "/status/current",
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
                 * Start the container.
                 *
                 * @param debug    If set, enables very verbose debug log-level on start.
                 * @param skiplock Ignore locks - only root is allowed to use this option.
                 * @return Result
                 */

                public Result vmStart(Boolean debug, Boolean skiplock) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("debug", debug);
                    parameters.put("skiplock", skiplock);
                    return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/status/start",
                            parameters);
                }

                /**
                 * Start the container.
                 *
                 * @return Result
                 */

                public Result vmStart() {
                    return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/status/start",
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
                 * Stop the container. This will abruptly stop all processes running in the
                 * container.
                 *
                 * @param overrule_shutdown Try to abort active 'vzshutdown' tasks before
                 *                          stopping.
                 * @param skiplock          Ignore locks - only root is allowed to use this
                 *                          option.
                 * @return Result
                 */

                public Result vmStop(Boolean overrule_shutdown, Boolean skiplock) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("overrule-shutdown", overrule_shutdown);
                    parameters.put("skiplock", skiplock);
                    return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/status/stop",
                            parameters);
                }

                /**
                 * Stop the container. This will abruptly stop all processes running in the
                 * container.
                 *
                 * @return Result
                 */

                public Result vmStop() {
                    return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/status/stop",
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
                 * Shutdown the container. This will trigger a clean shutdown of the container,
                 * see lxc-stop(1) for details.
                 *
                 * @param forceStop Make sure the Container stops.
                 * @param timeout   Wait maximal timeout seconds.
                 * @return Result
                 */

                public Result vmShutdown(Boolean forceStop, Integer timeout) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("forceStop", forceStop);
                    parameters.put("timeout", timeout);
                    return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/status/shutdown",
                            parameters);
                }

                /**
                 * Shutdown the container. This will trigger a clean shutdown of the container,
                 * see lxc-stop(1) for details.
                 *
                 * @return Result
                 */

                public Result vmShutdown() {
                    return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/status/shutdown",
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
                 * Suspend the container. This is experimental.
                 *
                 * @return Result
                 */

                public Result vmSuspend() {
                    return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/status/suspend",
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
                 * Resume the container.
                 *
                 * @return Result
                 */

                public Result vmResume() {
                    return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/status/resume",
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
                 * Reboot the container by shutting it down, and starting it again. Applies
                 * pending changes.
                 *
                 * @param timeout Wait maximal timeout seconds for the shutdown.
                 * @return Result
                 */

                public Result vmReboot(Integer timeout) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("timeout", timeout);
                    return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/status/reboot",
                            parameters);
                }

                /**
                 * Reboot the container by shutting it down, and starting it again. Applies
                 * pending changes.
                 *
                 * @return Result
                 */

                public Result vmReboot() {
                    return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/status/reboot",
                            null);
                }

            }

            /**
             * Directory index
             *
             * @return Result
             */

            public Result vmcmdidx() {
                return client.get("/nodes/" + this.node + "/lxc/" + this.vmid + "/status", null);
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

                private PVEVmidItem.PVESnapshot.PVESnapnameItem.PVERollback rollback;

                public PVEVmidItem.PVESnapshot.PVESnapnameItem.PVERollback getRollback() {
                    return rollback == null
                            ? (rollback = new PVERollback(client, this.node, this.vmid, this.snapname))
                            : rollback;
                }

                private PVEVmidItem.PVESnapshot.PVESnapnameItem.PVEConfig config;

                public PVEVmidItem.PVESnapshot.PVESnapnameItem.PVEConfig getConfig() {
                    return config == null
                            ? (config = new PVEConfig(client, this.node, this.vmid, this.snapname))
                            : config;
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
                     * Rollback LXC state to specified snapshot.
                     *
                     * @param start Whether the container should get started after rolling back
                     *              successfully
                     * @return Result
                     */

                    public Result rollback(Boolean start) {
                        Map<String, Object> parameters = new HashMap<>();
                        parameters.put("start", start);
                        return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/snapshot/"
                                + this.snapname + "/rollback", parameters);
                    }

                    /**
                     * Rollback LXC state to specified snapshot.
                     *
                     * @return Result
                     */

                    public Result rollback() {
                        return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/snapshot/"
                                + this.snapname + "/rollback", null);
                    }

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
                        return client.get("/nodes/" + this.node + "/lxc/" + this.vmid + "/snapshot/"
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
                        return client.set("/nodes/" + this.node + "/lxc/" + this.vmid + "/snapshot/"
                                + this.snapname + "/config", parameters);
                    }

                    /**
                     * Update snapshot metadata.
                     *
                     * @return Result
                     */

                    public Result updateSnapshotConfig() {
                        return client.set("/nodes/" + this.node + "/lxc/" + this.vmid + "/snapshot/"
                                + this.snapname + "/config", null);
                    }

                }

                /**
                 * Delete a LXC snapshot.
                 *
                 * @param force For removal from config file, even if removing disk snapshots
                 *              fails.
                 * @return Result
                 */

                public Result delsnapshot(Boolean force) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("force", force);
                    return client.delete(
                            "/nodes/" + this.node + "/lxc/" + this.vmid + "/snapshot/" + this.snapname,
                            parameters);
                }

                /**
                 * Delete a LXC snapshot.
                 *
                 * @return Result
                 */

                public Result delsnapshot() {
                    return client.delete(
                            "/nodes/" + this.node + "/lxc/" + this.vmid + "/snapshot/" + this.snapname,
                            null);
                }

                /**
                 *
                 * @return Result
                 */

                public Result snapshotCmdIdx() {
                    return client.get(
                            "/nodes/" + this.node + "/lxc/" + this.vmid + "/snapshot/" + this.snapname,
                            null);
                }

            }

            /**
             * List all snapshots.
             *
             * @return Result
             */

            public Result list() {
                return client.get("/nodes/" + this.node + "/lxc/" + this.vmid + "/snapshot", null);
            }

            /**
             * Snapshot a container.
             *
             * @param snapname    The name of the snapshot.
             * @param description A textual description or comment.
             * @return Result
             */

            public Result snapshot(String snapname, String description) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("snapname", snapname);
                parameters.put("description", description);
                return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/snapshot", parameters);
            }

            /**
             * Snapshot a container.
             *
             * @param snapname The name of the snapshot.
             * @return Result
             */

            public Result snapshot(String snapname) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("snapname", snapname);
                return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/snapshot", parameters);
            }

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
                        return client.delete("/nodes/" + this.node + "/lxc/" + this.vmid
                                + "/firewall/rules/" + this.pos, parameters);
                    }

                    /**
                     * Delete rule.
                     *
                     * @return Result
                     */

                    public Result deleteRule() {
                        return client.delete("/nodes/" + this.node + "/lxc/" + this.vmid
                                + "/firewall/rules/" + this.pos, null);
                    }

                    /**
                     * Get single rule data.
                     *
                     * @return Result
                     */

                    public Result getRule() {
                        return client.get("/nodes/" + this.node + "/lxc/" + this.vmid + "/firewall/rules/"
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
                        return client.set("/nodes/" + this.node + "/lxc/" + this.vmid + "/firewall/rules/"
                                + this.pos, parameters);
                    }

                    /**
                     * Modify rule data.
                     *
                     * @return Result
                     */

                    public Result updateRule() {
                        return client.set("/nodes/" + this.node + "/lxc/" + this.vmid + "/firewall/rules/"
                                + this.pos, null);
                    }

                }

                /**
                 * List rules.
                 *
                 * @return Result
                 */

                public Result getRules() {
                    return client.get("/nodes/" + this.node + "/lxc/" + this.vmid + "/firewall/rules",
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
                    return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/firewall/rules",
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
                    return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/firewall/rules",
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
                        return client.delete("/nodes/" + this.node + "/lxc/" + this.vmid
                                + "/firewall/aliases/" + this.name, parameters);
                    }

                    /**
                     * Remove IP or Network alias.
                     *
                     * @return Result
                     */

                    public Result removeAlias() {
                        return client.delete("/nodes/" + this.node + "/lxc/" + this.vmid
                                + "/firewall/aliases/" + this.name, null);
                    }

                    /**
                     * Read alias.
                     *
                     * @return Result
                     */

                    public Result readAlias() {
                        return client.get("/nodes/" + this.node + "/lxc/" + this.vmid + "/firewall/aliases/"
                                + this.name, null);
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
                        return client.set("/nodes/" + this.node + "/lxc/" + this.vmid + "/firewall/aliases/"
                                + this.name, parameters);
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
                        return client.set("/nodes/" + this.node + "/lxc/" + this.vmid + "/firewall/aliases/"
                                + this.name, parameters);
                    }

                }

                /**
                 * List aliases
                 *
                 * @return Result
                 */

                public Result getAliases() {
                    return client.get("/nodes/" + this.node + "/lxc/" + this.vmid + "/firewall/aliases",
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
                    return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/firewall/aliases",
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
                    return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/firewall/aliases",
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
                            return client.delete("/nodes/" + this.node + "/lxc/" + this.vmid
                                    + "/firewall/ipset/" + this.name + "/" + this.cidr, parameters);
                        }

                        /**
                         * Remove IP or Network from IPSet.
                         *
                         * @return Result
                         */

                        public Result removeIp() {
                            return client.delete("/nodes/" + this.node + "/lxc/" + this.vmid
                                    + "/firewall/ipset/" + this.name + "/" + this.cidr, null);
                        }

                        /**
                         * Read IP or Network settings from IPSet.
                         *
                         * @return Result
                         */

                        public Result readIp() {
                            return client.get("/nodes/" + this.node + "/lxc/" + this.vmid
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
                            return client.set("/nodes/" + this.node + "/lxc/" + this.vmid
                                    + "/firewall/ipset/" + this.name + "/" + this.cidr, parameters);
                        }

                        /**
                         * Update IP or Network settings
                         *
                         * @return Result
                         */

                        public Result updateIp() {
                            return client.set("/nodes/" + this.node + "/lxc/" + this.vmid
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
                        return client.delete("/nodes/" + this.node + "/lxc/" + this.vmid
                                + "/firewall/ipset/" + this.name, parameters);
                    }

                    /**
                     * Delete IPSet
                     *
                     * @return Result
                     */

                    public Result deleteIpset() {
                        return client.delete("/nodes/" + this.node + "/lxc/" + this.vmid
                                + "/firewall/ipset/" + this.name, null);
                    }

                    /**
                     * List IPSet content
                     *
                     * @return Result
                     */

                    public Result getIpset() {
                        return client.get("/nodes/" + this.node + "/lxc/" + this.vmid + "/firewall/ipset/"
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
                        return client.create("/nodes/" + this.node + "/lxc/" + this.vmid
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
                        return client.create("/nodes/" + this.node + "/lxc/" + this.vmid
                                + "/firewall/ipset/" + this.name, parameters);
                    }

                }

                /**
                 * List IPSets
                 *
                 * @return Result
                 */

                public Result ipsetIndex() {
                    return client.get("/nodes/" + this.node + "/lxc/" + this.vmid + "/firewall/ipset",
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
                    return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/firewall/ipset",
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
                    return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/firewall/ipset",
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
                    return client.get("/nodes/" + this.node + "/lxc/" + this.vmid + "/firewall/options",
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
                    return client.set("/nodes/" + this.node + "/lxc/" + this.vmid + "/firewall/options",
                            parameters);
                }

                /**
                 * Set Firewall options.
                 *
                 * @return Result
                 */

                public Result setOptions() {
                    return client.set("/nodes/" + this.node + "/lxc/" + this.vmid + "/firewall/options",
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
                    return client.get("/nodes/" + this.node + "/lxc/" + this.vmid + "/firewall/log",
                            parameters);
                }

                /**
                 * Read firewall log
                 *
                 * @return Result
                 */

                public Result log() {
                    return client.get("/nodes/" + this.node + "/lxc/" + this.vmid + "/firewall/log", null);
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
                    return client.get("/nodes/" + this.node + "/lxc/" + this.vmid + "/firewall/refs",
                            parameters);
                }

                /**
                 * Lists possible IPSet/Alias reference which are allowed in source/dest
                 * properties.
                 *
                 * @return Result
                 */

                public Result refs() {
                    return client.get("/nodes/" + this.node + "/lxc/" + this.vmid + "/firewall/refs", null);
                }

            }

            /**
             * Directory index.
             *
             * @return Result
             */

            public Result index() {
                return client.get("/nodes/" + this.node + "/lxc/" + this.vmid + "/firewall", null);
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
                return client.get("/nodes/" + this.node + "/lxc/" + this.vmid + "/rrd", parameters);
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
                return client.get("/nodes/" + this.node + "/lxc/" + this.vmid + "/rrd", parameters);
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
                return client.get("/nodes/" + this.node + "/lxc/" + this.vmid + "/rrddata", parameters);
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
                return client.get("/nodes/" + this.node + "/lxc/" + this.vmid + "/rrddata", parameters);
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
             * @param height    sets the height of the console in pixels.
             * @param websocket use websocket instead of standard VNC.
             * @param width     sets the width of the console in pixels.
             * @return Result
             */

            public Result vncproxy(Integer height, Boolean websocket, Integer width) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("height", height);
                parameters.put("websocket", websocket);
                parameters.put("width", width);
                return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/vncproxy", parameters);
            }

            /**
             * Creates a TCP VNC proxy connections.
             *
             * @return Result
             */

            public Result vncproxy() {
                return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/vncproxy", null);
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
             * Creates a TCP proxy connection.
             *
             * @return Result
             */

            public Result termproxy() {
                return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/termproxy", null);
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
                return client.get("/nodes/" + this.node + "/lxc/" + this.vmid + "/vncwebsocket",
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
             * Returns a SPICE configuration to connect to the CT.
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
                return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/spiceproxy",
                        parameters);
            }

            /**
             * Returns a SPICE configuration to connect to the CT.
             *
             * @return Result
             */

            public Result spiceproxy() {
                return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/spiceproxy", null);
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
             * Migrate the container to another cluster. Creates a new migration task.
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
             * @param delete          Delete the original CT and related data after
             *                        successful migration. By default, the original CT is
             *                        kept on the source cluster in a stopped state.
             * @param online          Use online/live migration.
             * @param restart         Use restart migration
             * @param target_vmid     The (unique) ID of the VM.
             * @param timeout         Timeout in seconds for shutdown for restart migration
             * @return Result
             */

            public Result remoteMigrateVm(String target_bridge, String target_endpoint,
                                          String target_storage, Float bwlimit, Boolean delete, Boolean online, Boolean restart,
                                          Integer target_vmid, Integer timeout) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("target-bridge", target_bridge);
                parameters.put("target-endpoint", target_endpoint);
                parameters.put("target-storage", target_storage);
                parameters.put("bwlimit", bwlimit);
                parameters.put("delete", delete);
                parameters.put("online", online);
                parameters.put("restart", restart);
                parameters.put("target-vmid", target_vmid);
                parameters.put("timeout", timeout);
                return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/remote_migrate",
                        parameters);
            }

            /**
             * Migrate the container to another cluster. Creates a new migration task.
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
                return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/remote_migrate",
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
                return client.get("/nodes/" + this.node + "/lxc/" + this.vmid + "/migrate", parameters);
            }

            /**
             * Get preconditions for migration.
             *
             * @return Result
             */

            public Result migrateVmPrecondition() {
                return client.get("/nodes/" + this.node + "/lxc/" + this.vmid + "/migrate", null);
            }

            /**
             * Migrate the container to another node. Creates a new migration task.
             *
             * @param target         Target node.
             * @param bwlimit        Override I/O bandwidth limit (in KiB/s).
             * @param online         Use online/live migration.
             * @param restart        Use restart migration
             * @param target_storage Mapping from source to target storages. Providing only
             *                       a single storage ID maps all source storages to that
             *                       storage. Providing the special value '1' will map each
             *                       source storage to itself.
             * @param timeout        Timeout in seconds for shutdown for restart migration
             * @return Result
             */

            public Result migrateVm(String target, Float bwlimit, Boolean online, Boolean restart,
                                    String target_storage, Integer timeout) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("target", target);
                parameters.put("bwlimit", bwlimit);
                parameters.put("online", online);
                parameters.put("restart", restart);
                parameters.put("target-storage", target_storage);
                parameters.put("timeout", timeout);
                return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/migrate", parameters);
            }

            /**
             * Migrate the container to another node. Creates a new migration task.
             *
             * @param target Target node.
             * @return Result
             */

            public Result migrateVm(String target) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("target", target);
                return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/migrate", parameters);
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
                return client.get("/nodes/" + this.node + "/lxc/" + this.vmid + "/feature", parameters);
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
                return client.get("/nodes/" + this.node + "/lxc/" + this.vmid + "/feature", parameters);
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
             * @return Result
             */

            public Result template() {
                return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/template", null);
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
             * Create a container clone/copy
             *
             * @param newid       VMID for the clone.
             * @param bwlimit     Override I/O bandwidth limit (in KiB/s).
             * @param description Description for the new CT.
             * @param full        Create a full copy of all disks. This is always done when
             *                    you clone a normal CT. For CT templates, we try to create
             *                    a linked clone by default.
             * @param hostname    Set a hostname for the new CT.
             * @param pool        Add the new CT to the specified pool.
             * @param snapname    The name of the snapshot.
             * @param storage     Target storage for full clone.
             * @param target      Target node. Only allowed if the original VM is on shared
             *                    storage.
             * @return Result
             */

            public Result cloneVm(int newid, Float bwlimit, String description, Boolean full,
                                  String hostname, String pool, String snapname, String storage, String target) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("newid", newid);
                parameters.put("bwlimit", bwlimit);
                parameters.put("description", description);
                parameters.put("full", full);
                parameters.put("hostname", hostname);
                parameters.put("pool", pool);
                parameters.put("snapname", snapname);
                parameters.put("storage", storage);
                parameters.put("target", target);
                return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/clone", parameters);
            }

            /**
             * Create a container clone/copy
             *
             * @param newid VMID for the clone.
             * @return Result
             */

            public Result cloneVm(int newid) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("newid", newid);
                return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/clone", parameters);
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
             * Resize a container mount point.
             *
             * @param disk   The disk you want to resize.
             *               Enum:
             *               rootfs,mp0,mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15,mp16,mp17,mp18,mp19,mp20,mp21,mp22,mp23,mp24,mp25,mp26,mp27,mp28,mp29,mp30,mp31,mp32,mp33,mp34,mp35,mp36,mp37,mp38,mp39,mp40,mp41,mp42,mp43,mp44,mp45,mp46,mp47,mp48,mp49,mp50,mp51,mp52,mp53,mp54,mp55,mp56,mp57,mp58,mp59,mp60,mp61,mp62,mp63,mp64,mp65,mp66,mp67,mp68,mp69,mp70,mp71,mp72,mp73,mp74,mp75,mp76,mp77,mp78,mp79,mp80,mp81,mp82,mp83,mp84,mp85,mp86,mp87,mp88,mp89,mp90,mp91,mp92,mp93,mp94,mp95,mp96,mp97,mp98,mp99,mp100,mp101,mp102,mp103,mp104,mp105,mp106,mp107,mp108,mp109,mp110,mp111,mp112,mp113,mp114,mp115,mp116,mp117,mp118,mp119,mp120,mp121,mp122,mp123,mp124,mp125,mp126,mp127,mp128,mp129,mp130,mp131,mp132,mp133,mp134,mp135,mp136,mp137,mp138,mp139,mp140,mp141,mp142,mp143,mp144,mp145,mp146,mp147,mp148,mp149,mp150,mp151,mp152,mp153,mp154,mp155,mp156,mp157,mp158,mp159,mp160,mp161,mp162,mp163,mp164,mp165,mp166,mp167,mp168,mp169,mp170,mp171,mp172,mp173,mp174,mp175,mp176,mp177,mp178,mp179,mp180,mp181,mp182,mp183,mp184,mp185,mp186,mp187,mp188,mp189,mp190,mp191,mp192,mp193,mp194,mp195,mp196,mp197,mp198,mp199,mp200,mp201,mp202,mp203,mp204,mp205,mp206,mp207,mp208,mp209,mp210,mp211,mp212,mp213,mp214,mp215,mp216,mp217,mp218,mp219,mp220,mp221,mp222,mp223,mp224,mp225,mp226,mp227,mp228,mp229,mp230,mp231,mp232,mp233,mp234,mp235,mp236,mp237,mp238,mp239,mp240,mp241,mp242,mp243,mp244,mp245,mp246,mp247,mp248,mp249,mp250,mp251,mp252,mp253,mp254,mp255
             * @param size   The new size. With the '+' sign the value is added to the
             *               actual size of the volume and without it, the value is taken as
             *               an absolute one. Shrinking disk size is not supported.
             * @param digest Prevent changes if current configuration file has different
             *               SHA1 digest. This can be used to prevent concurrent
             *               modifications.
             * @return Result
             */

            public Result resizeVm(String disk, String size, String digest) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("disk", disk);
                parameters.put("size", size);
                parameters.put("digest", digest);
                return client.set("/nodes/" + this.node + "/lxc/" + this.vmid + "/resize", parameters);
            }

            /**
             * Resize a container mount point.
             *
             * @param disk The disk you want to resize.
             *             Enum:
             *             rootfs,mp0,mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15,mp16,mp17,mp18,mp19,mp20,mp21,mp22,mp23,mp24,mp25,mp26,mp27,mp28,mp29,mp30,mp31,mp32,mp33,mp34,mp35,mp36,mp37,mp38,mp39,mp40,mp41,mp42,mp43,mp44,mp45,mp46,mp47,mp48,mp49,mp50,mp51,mp52,mp53,mp54,mp55,mp56,mp57,mp58,mp59,mp60,mp61,mp62,mp63,mp64,mp65,mp66,mp67,mp68,mp69,mp70,mp71,mp72,mp73,mp74,mp75,mp76,mp77,mp78,mp79,mp80,mp81,mp82,mp83,mp84,mp85,mp86,mp87,mp88,mp89,mp90,mp91,mp92,mp93,mp94,mp95,mp96,mp97,mp98,mp99,mp100,mp101,mp102,mp103,mp104,mp105,mp106,mp107,mp108,mp109,mp110,mp111,mp112,mp113,mp114,mp115,mp116,mp117,mp118,mp119,mp120,mp121,mp122,mp123,mp124,mp125,mp126,mp127,mp128,mp129,mp130,mp131,mp132,mp133,mp134,mp135,mp136,mp137,mp138,mp139,mp140,mp141,mp142,mp143,mp144,mp145,mp146,mp147,mp148,mp149,mp150,mp151,mp152,mp153,mp154,mp155,mp156,mp157,mp158,mp159,mp160,mp161,mp162,mp163,mp164,mp165,mp166,mp167,mp168,mp169,mp170,mp171,mp172,mp173,mp174,mp175,mp176,mp177,mp178,mp179,mp180,mp181,mp182,mp183,mp184,mp185,mp186,mp187,mp188,mp189,mp190,mp191,mp192,mp193,mp194,mp195,mp196,mp197,mp198,mp199,mp200,mp201,mp202,mp203,mp204,mp205,mp206,mp207,mp208,mp209,mp210,mp211,mp212,mp213,mp214,mp215,mp216,mp217,mp218,mp219,mp220,mp221,mp222,mp223,mp224,mp225,mp226,mp227,mp228,mp229,mp230,mp231,mp232,mp233,mp234,mp235,mp236,mp237,mp238,mp239,mp240,mp241,mp242,mp243,mp244,mp245,mp246,mp247,mp248,mp249,mp250,mp251,mp252,mp253,mp254,mp255
             * @param size The new size. With the '+' sign the value is added to the actual
             *             size of the volume and without it, the value is taken as an
             *             absolute one. Shrinking disk size is not supported.
             * @return Result
             */

            public Result resizeVm(String disk, String size) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("disk", disk);
                parameters.put("size", size);
                return client.set("/nodes/" + this.node + "/lxc/" + this.vmid + "/resize", parameters);
            }

        }

        public static class PVEMoveVolume {

            private final PveClient client;
            private final Object node;
            private final Object vmid;

            protected PVEMoveVolume(PveClient client, Object node, Object vmid) {
                this.client = client;
                this.node = node;
                this.vmid = vmid;
            }

            /**
             * Move a rootfs-/mp-volume to a different storage or to a different container.
             *
             * @param volume        Volume which will be moved.
             *                      Enum:
             *                      rootfs,mp0,mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15,mp16,mp17,mp18,mp19,mp20,mp21,mp22,mp23,mp24,mp25,mp26,mp27,mp28,mp29,mp30,mp31,mp32,mp33,mp34,mp35,mp36,mp37,mp38,mp39,mp40,mp41,mp42,mp43,mp44,mp45,mp46,mp47,mp48,mp49,mp50,mp51,mp52,mp53,mp54,mp55,mp56,mp57,mp58,mp59,mp60,mp61,mp62,mp63,mp64,mp65,mp66,mp67,mp68,mp69,mp70,mp71,mp72,mp73,mp74,mp75,mp76,mp77,mp78,mp79,mp80,mp81,mp82,mp83,mp84,mp85,mp86,mp87,mp88,mp89,mp90,mp91,mp92,mp93,mp94,mp95,mp96,mp97,mp98,mp99,mp100,mp101,mp102,mp103,mp104,mp105,mp106,mp107,mp108,mp109,mp110,mp111,mp112,mp113,mp114,mp115,mp116,mp117,mp118,mp119,mp120,mp121,mp122,mp123,mp124,mp125,mp126,mp127,mp128,mp129,mp130,mp131,mp132,mp133,mp134,mp135,mp136,mp137,mp138,mp139,mp140,mp141,mp142,mp143,mp144,mp145,mp146,mp147,mp148,mp149,mp150,mp151,mp152,mp153,mp154,mp155,mp156,mp157,mp158,mp159,mp160,mp161,mp162,mp163,mp164,mp165,mp166,mp167,mp168,mp169,mp170,mp171,mp172,mp173,mp174,mp175,mp176,mp177,mp178,mp179,mp180,mp181,mp182,mp183,mp184,mp185,mp186,mp187,mp188,mp189,mp190,mp191,mp192,mp193,mp194,mp195,mp196,mp197,mp198,mp199,mp200,mp201,mp202,mp203,mp204,mp205,mp206,mp207,mp208,mp209,mp210,mp211,mp212,mp213,mp214,mp215,mp216,mp217,mp218,mp219,mp220,mp221,mp222,mp223,mp224,mp225,mp226,mp227,mp228,mp229,mp230,mp231,mp232,mp233,mp234,mp235,mp236,mp237,mp238,mp239,mp240,mp241,mp242,mp243,mp244,mp245,mp246,mp247,mp248,mp249,mp250,mp251,mp252,mp253,mp254,mp255,unused0,unused1,unused2,unused3,unused4,unused5,unused6,unused7,unused8,unused9,unused10,unused11,unused12,unused13,unused14,unused15,unused16,unused17,unused18,unused19,unused20,unused21,unused22,unused23,unused24,unused25,unused26,unused27,unused28,unused29,unused30,unused31,unused32,unused33,unused34,unused35,unused36,unused37,unused38,unused39,unused40,unused41,unused42,unused43,unused44,unused45,unused46,unused47,unused48,unused49,unused50,unused51,unused52,unused53,unused54,unused55,unused56,unused57,unused58,unused59,unused60,unused61,unused62,unused63,unused64,unused65,unused66,unused67,unused68,unused69,unused70,unused71,unused72,unused73,unused74,unused75,unused76,unused77,unused78,unused79,unused80,unused81,unused82,unused83,unused84,unused85,unused86,unused87,unused88,unused89,unused90,unused91,unused92,unused93,unused94,unused95,unused96,unused97,unused98,unused99,unused100,unused101,unused102,unused103,unused104,unused105,unused106,unused107,unused108,unused109,unused110,unused111,unused112,unused113,unused114,unused115,unused116,unused117,unused118,unused119,unused120,unused121,unused122,unused123,unused124,unused125,unused126,unused127,unused128,unused129,unused130,unused131,unused132,unused133,unused134,unused135,unused136,unused137,unused138,unused139,unused140,unused141,unused142,unused143,unused144,unused145,unused146,unused147,unused148,unused149,unused150,unused151,unused152,unused153,unused154,unused155,unused156,unused157,unused158,unused159,unused160,unused161,unused162,unused163,unused164,unused165,unused166,unused167,unused168,unused169,unused170,unused171,unused172,unused173,unused174,unused175,unused176,unused177,unused178,unused179,unused180,unused181,unused182,unused183,unused184,unused185,unused186,unused187,unused188,unused189,unused190,unused191,unused192,unused193,unused194,unused195,unused196,unused197,unused198,unused199,unused200,unused201,unused202,unused203,unused204,unused205,unused206,unused207,unused208,unused209,unused210,unused211,unused212,unused213,unused214,unused215,unused216,unused217,unused218,unused219,unused220,unused221,unused222,unused223,unused224,unused225,unused226,unused227,unused228,unused229,unused230,unused231,unused232,unused233,unused234,unused235,unused236,unused237,unused238,unused239,unused240,unused241,unused242,unused243,unused244,unused245,unused246,unused247,unused248,unused249,unused250,unused251,unused252,unused253,unused254,unused255
             * @param bwlimit       Override I/O bandwidth limit (in KiB/s).
             * @param delete        Delete the original volume after successful copy. By
             *                      default, the original is kept as an unused volume entry.
             * @param digest        Prevent changes if current configuration file has
             *                      different SHA1 " . "digest. This can be used to prevent
             *                      concurrent modifications.
             * @param storage       Target Storage.
             * @param target_digest Prevent changes if current configuration file of the
             *                      target " . "container has a different SHA1 digest. This
             *                      can be used to prevent " . "concurrent modifications.
             * @param target_vmid   The (unique) ID of the VM.
             * @param target_volume The config key the volume will be moved to. Default is
             *                      the source volume key.
             *                      Enum:
             *                      rootfs,mp0,mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15,mp16,mp17,mp18,mp19,mp20,mp21,mp22,mp23,mp24,mp25,mp26,mp27,mp28,mp29,mp30,mp31,mp32,mp33,mp34,mp35,mp36,mp37,mp38,mp39,mp40,mp41,mp42,mp43,mp44,mp45,mp46,mp47,mp48,mp49,mp50,mp51,mp52,mp53,mp54,mp55,mp56,mp57,mp58,mp59,mp60,mp61,mp62,mp63,mp64,mp65,mp66,mp67,mp68,mp69,mp70,mp71,mp72,mp73,mp74,mp75,mp76,mp77,mp78,mp79,mp80,mp81,mp82,mp83,mp84,mp85,mp86,mp87,mp88,mp89,mp90,mp91,mp92,mp93,mp94,mp95,mp96,mp97,mp98,mp99,mp100,mp101,mp102,mp103,mp104,mp105,mp106,mp107,mp108,mp109,mp110,mp111,mp112,mp113,mp114,mp115,mp116,mp117,mp118,mp119,mp120,mp121,mp122,mp123,mp124,mp125,mp126,mp127,mp128,mp129,mp130,mp131,mp132,mp133,mp134,mp135,mp136,mp137,mp138,mp139,mp140,mp141,mp142,mp143,mp144,mp145,mp146,mp147,mp148,mp149,mp150,mp151,mp152,mp153,mp154,mp155,mp156,mp157,mp158,mp159,mp160,mp161,mp162,mp163,mp164,mp165,mp166,mp167,mp168,mp169,mp170,mp171,mp172,mp173,mp174,mp175,mp176,mp177,mp178,mp179,mp180,mp181,mp182,mp183,mp184,mp185,mp186,mp187,mp188,mp189,mp190,mp191,mp192,mp193,mp194,mp195,mp196,mp197,mp198,mp199,mp200,mp201,mp202,mp203,mp204,mp205,mp206,mp207,mp208,mp209,mp210,mp211,mp212,mp213,mp214,mp215,mp216,mp217,mp218,mp219,mp220,mp221,mp222,mp223,mp224,mp225,mp226,mp227,mp228,mp229,mp230,mp231,mp232,mp233,mp234,mp235,mp236,mp237,mp238,mp239,mp240,mp241,mp242,mp243,mp244,mp245,mp246,mp247,mp248,mp249,mp250,mp251,mp252,mp253,mp254,mp255,unused0,unused1,unused2,unused3,unused4,unused5,unused6,unused7,unused8,unused9,unused10,unused11,unused12,unused13,unused14,unused15,unused16,unused17,unused18,unused19,unused20,unused21,unused22,unused23,unused24,unused25,unused26,unused27,unused28,unused29,unused30,unused31,unused32,unused33,unused34,unused35,unused36,unused37,unused38,unused39,unused40,unused41,unused42,unused43,unused44,unused45,unused46,unused47,unused48,unused49,unused50,unused51,unused52,unused53,unused54,unused55,unused56,unused57,unused58,unused59,unused60,unused61,unused62,unused63,unused64,unused65,unused66,unused67,unused68,unused69,unused70,unused71,unused72,unused73,unused74,unused75,unused76,unused77,unused78,unused79,unused80,unused81,unused82,unused83,unused84,unused85,unused86,unused87,unused88,unused89,unused90,unused91,unused92,unused93,unused94,unused95,unused96,unused97,unused98,unused99,unused100,unused101,unused102,unused103,unused104,unused105,unused106,unused107,unused108,unused109,unused110,unused111,unused112,unused113,unused114,unused115,unused116,unused117,unused118,unused119,unused120,unused121,unused122,unused123,unused124,unused125,unused126,unused127,unused128,unused129,unused130,unused131,unused132,unused133,unused134,unused135,unused136,unused137,unused138,unused139,unused140,unused141,unused142,unused143,unused144,unused145,unused146,unused147,unused148,unused149,unused150,unused151,unused152,unused153,unused154,unused155,unused156,unused157,unused158,unused159,unused160,unused161,unused162,unused163,unused164,unused165,unused166,unused167,unused168,unused169,unused170,unused171,unused172,unused173,unused174,unused175,unused176,unused177,unused178,unused179,unused180,unused181,unused182,unused183,unused184,unused185,unused186,unused187,unused188,unused189,unused190,unused191,unused192,unused193,unused194,unused195,unused196,unused197,unused198,unused199,unused200,unused201,unused202,unused203,unused204,unused205,unused206,unused207,unused208,unused209,unused210,unused211,unused212,unused213,unused214,unused215,unused216,unused217,unused218,unused219,unused220,unused221,unused222,unused223,unused224,unused225,unused226,unused227,unused228,unused229,unused230,unused231,unused232,unused233,unused234,unused235,unused236,unused237,unused238,unused239,unused240,unused241,unused242,unused243,unused244,unused245,unused246,unused247,unused248,unused249,unused250,unused251,unused252,unused253,unused254,unused255
             * @return Result
             */

            public Result moveVolume(String volume, Float bwlimit, Boolean delete, String digest,
                                     String storage, String target_digest, Integer target_vmid, String target_volume) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("volume", volume);
                parameters.put("bwlimit", bwlimit);
                parameters.put("delete", delete);
                parameters.put("digest", digest);
                parameters.put("storage", storage);
                parameters.put("target-digest", target_digest);
                parameters.put("target-vmid", target_vmid);
                parameters.put("target-volume", target_volume);
                return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/move_volume",
                        parameters);
            }

            /**
             * Move a rootfs-/mp-volume to a different storage or to a different container.
             *
             * @param volume Volume which will be moved.
             *               Enum:
             *               rootfs,mp0,mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15,mp16,mp17,mp18,mp19,mp20,mp21,mp22,mp23,mp24,mp25,mp26,mp27,mp28,mp29,mp30,mp31,mp32,mp33,mp34,mp35,mp36,mp37,mp38,mp39,mp40,mp41,mp42,mp43,mp44,mp45,mp46,mp47,mp48,mp49,mp50,mp51,mp52,mp53,mp54,mp55,mp56,mp57,mp58,mp59,mp60,mp61,mp62,mp63,mp64,mp65,mp66,mp67,mp68,mp69,mp70,mp71,mp72,mp73,mp74,mp75,mp76,mp77,mp78,mp79,mp80,mp81,mp82,mp83,mp84,mp85,mp86,mp87,mp88,mp89,mp90,mp91,mp92,mp93,mp94,mp95,mp96,mp97,mp98,mp99,mp100,mp101,mp102,mp103,mp104,mp105,mp106,mp107,mp108,mp109,mp110,mp111,mp112,mp113,mp114,mp115,mp116,mp117,mp118,mp119,mp120,mp121,mp122,mp123,mp124,mp125,mp126,mp127,mp128,mp129,mp130,mp131,mp132,mp133,mp134,mp135,mp136,mp137,mp138,mp139,mp140,mp141,mp142,mp143,mp144,mp145,mp146,mp147,mp148,mp149,mp150,mp151,mp152,mp153,mp154,mp155,mp156,mp157,mp158,mp159,mp160,mp161,mp162,mp163,mp164,mp165,mp166,mp167,mp168,mp169,mp170,mp171,mp172,mp173,mp174,mp175,mp176,mp177,mp178,mp179,mp180,mp181,mp182,mp183,mp184,mp185,mp186,mp187,mp188,mp189,mp190,mp191,mp192,mp193,mp194,mp195,mp196,mp197,mp198,mp199,mp200,mp201,mp202,mp203,mp204,mp205,mp206,mp207,mp208,mp209,mp210,mp211,mp212,mp213,mp214,mp215,mp216,mp217,mp218,mp219,mp220,mp221,mp222,mp223,mp224,mp225,mp226,mp227,mp228,mp229,mp230,mp231,mp232,mp233,mp234,mp235,mp236,mp237,mp238,mp239,mp240,mp241,mp242,mp243,mp244,mp245,mp246,mp247,mp248,mp249,mp250,mp251,mp252,mp253,mp254,mp255,unused0,unused1,unused2,unused3,unused4,unused5,unused6,unused7,unused8,unused9,unused10,unused11,unused12,unused13,unused14,unused15,unused16,unused17,unused18,unused19,unused20,unused21,unused22,unused23,unused24,unused25,unused26,unused27,unused28,unused29,unused30,unused31,unused32,unused33,unused34,unused35,unused36,unused37,unused38,unused39,unused40,unused41,unused42,unused43,unused44,unused45,unused46,unused47,unused48,unused49,unused50,unused51,unused52,unused53,unused54,unused55,unused56,unused57,unused58,unused59,unused60,unused61,unused62,unused63,unused64,unused65,unused66,unused67,unused68,unused69,unused70,unused71,unused72,unused73,unused74,unused75,unused76,unused77,unused78,unused79,unused80,unused81,unused82,unused83,unused84,unused85,unused86,unused87,unused88,unused89,unused90,unused91,unused92,unused93,unused94,unused95,unused96,unused97,unused98,unused99,unused100,unused101,unused102,unused103,unused104,unused105,unused106,unused107,unused108,unused109,unused110,unused111,unused112,unused113,unused114,unused115,unused116,unused117,unused118,unused119,unused120,unused121,unused122,unused123,unused124,unused125,unused126,unused127,unused128,unused129,unused130,unused131,unused132,unused133,unused134,unused135,unused136,unused137,unused138,unused139,unused140,unused141,unused142,unused143,unused144,unused145,unused146,unused147,unused148,unused149,unused150,unused151,unused152,unused153,unused154,unused155,unused156,unused157,unused158,unused159,unused160,unused161,unused162,unused163,unused164,unused165,unused166,unused167,unused168,unused169,unused170,unused171,unused172,unused173,unused174,unused175,unused176,unused177,unused178,unused179,unused180,unused181,unused182,unused183,unused184,unused185,unused186,unused187,unused188,unused189,unused190,unused191,unused192,unused193,unused194,unused195,unused196,unused197,unused198,unused199,unused200,unused201,unused202,unused203,unused204,unused205,unused206,unused207,unused208,unused209,unused210,unused211,unused212,unused213,unused214,unused215,unused216,unused217,unused218,unused219,unused220,unused221,unused222,unused223,unused224,unused225,unused226,unused227,unused228,unused229,unused230,unused231,unused232,unused233,unused234,unused235,unused236,unused237,unused238,unused239,unused240,unused241,unused242,unused243,unused244,unused245,unused246,unused247,unused248,unused249,unused250,unused251,unused252,unused253,unused254,unused255
             * @return Result
             */

            public Result moveVolume(String volume) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("volume", volume);
                return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/move_volume",
                        parameters);
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
             * Get container configuration, including pending changes.
             *
             * @return Result
             */

            public Result vmPending() {
                return client.get("/nodes/" + this.node + "/lxc/" + this.vmid + "/pending", null);
            }

        }

        public static class PVEInterfaces {

            private final PveClient client;
            private final Object node;
            private final Object vmid;

            protected PVEInterfaces(PveClient client, Object node, Object vmid) {
                this.client = client;
                this.node = node;
                this.vmid = vmid;
            }

            /**
             * Get IP addresses of the specified container interface.
             *
             * @return Result
             */

            public Result ip() {
                return client.get("/nodes/" + this.node + "/lxc/" + this.vmid + "/interfaces", null);
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
             * Migration tunnel endpoint - only for internal use by CT migration.
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
                return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/mtunnel", parameters);
            }

            /**
             * Migration tunnel endpoint - only for internal use by CT migration.
             *
             * @return Result
             */

            public Result mtunnel() {
                return client.create("/nodes/" + this.node + "/lxc/" + this.vmid + "/mtunnel", null);
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
                return client.get("/nodes/" + this.node + "/lxc/" + this.vmid + "/mtunnelwebsocket",
                        parameters);
            }

        }

        /**
         * Destroy the container (also delete all uses files).
         *
         * @param destroy_unreferenced_disks If set, destroy additionally all disks with
         *                                   the VMID from all enabled storages which
         *                                   are not referenced in the config.
         * @param force                      Force destroy, even if running.
         * @param purge                      Remove container from all related
         *                                   configurations. For example, backup jobs,
         *                                   replication jobs or HA. Related ACLs and
         *                                   Firewall entries will *always* be removed.
         * @return Result
         */

        public Result destroyVm(Boolean destroy_unreferenced_disks, Boolean force, Boolean purge) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("destroy-unreferenced-disks", destroy_unreferenced_disks);
            parameters.put("force", force);
            parameters.put("purge", purge);
            return client.delete("/nodes/" + this.node + "/lxc/" + this.vmid, parameters);
        }

        /**
         * Destroy the container (also delete all uses files).
         *
         * @return Result
         */

        public Result destroyVm() {
            return client.delete("/nodes/" + this.node + "/lxc/" + this.vmid, null);
        }

        /**
         * Directory index
         *
         * @return Result
         */

        public Result vmdiridx() {
            return client.get("/nodes/" + this.node + "/lxc/" + this.vmid, null);
        }

    }

    /**
     * LXC container index (per node).
     *
     * @return Result
     */

    public Result vmlist() {
        return client.get("/nodes/" + this.node + "/lxc", null);
    }

    /**
     * Create or restore a container.
     *
     * @param ostemplate           The OS template or backup file.
     * @param vmid                 The (unique) ID of the VM.
     * @param arch                 OS architecture type.
     *                             Enum: amd64,i386,arm64,armhf,riscv32,riscv64
     * @param bwlimit              Override I/O bandwidth limit (in KiB/s).
     * @param cmode                Console mode. By default, the console command
     *                             tries to open a connection to one of the
     *                             available tty devices. By setting cmode to
     *                             'console' it tries to attach to /dev/console
     *                             instead. If you set cmode to 'shell', it simply
     *                             invokes a shell inside the container (no login).
     *                             Enum: shell,console,tty
     * @param console              Attach a console device (/dev/console) to the
     *                             container.
     * @param cores                The number of cores assigned to the container. A
     *                             container can use all available cores by default.
     * @param cpulimit             Limit of CPU usage. NOTE: If the computer has 2
     *                             CPUs, it has a total of '2' CPU time. Value '0'
     *                             indicates no CPU limit.
     * @param cpuunits             CPU weight for a container, will be clamped to
     *                             [1, 10000] in cgroup v2.
     * @param debug                Try to be more verbose. For now this only enables
     *                             debug log-level on start.
     * @param description          Description for the Container. Shown in the
     *                             web-interface CT's summary. This is saved as
     *                             comment inside the configuration file.
     * @param devN                 Device to pass through to the container
     * @param entrypoint           Command to run as init, optionally with
     *                             arguments; may start with an absolute path,
     *                             relative path, or a binary in $PATH.
     * @param env                  The container runtime environment as
     *                             NUL-separated list. Replaces any
     *                             lxc.environment.runtime entries in the config.
     * @param features             Allow containers access to advanced features.
     * @param force                Allow to overwrite existing container.
     * @param ha_managed           Add the CT as a HA resource after it was created.
     * @param hookscript           Script that will be executed during various steps
     *                             in the containers lifetime.
     * @param hostname             Set a host name for the container.
     * @param ignore_unpack_errors Ignore errors when extracting the template.
     * @param lock_                Lock/unlock the container.
     *                             Enum:
     *                             backup,create,destroyed,disk,fstrim,migrate,mounted,rollback,snapshot,snapshot-delete
     * @param memory               Amount of RAM for the container in MB.
     * @param mpN                  Use volume as container mount point. Use the
     *                             special syntax STORAGE_ID:SIZE_IN_GiB to allocate
     *                             a new volume.
     * @param nameserver           Sets DNS server IP address for a container.
     *                             Create will automatically use the setting from
     *                             the host if you neither set searchdomain nor
     *                             nameserver.
     * @param netN                 Specifies network interfaces for the container.
     * @param onboot               Specifies whether a container will be started
     *                             during system bootup.
     * @param ostype               OS type. This is used to set up configuration
     *                             inside the container, and corresponds to lxc
     *                             setup scripts in
     *                             /usr/share/lxc/config/&amp;lt;ostype&amp;gt;.common.conf.
     *                             Value 'unmanaged' can be used to skip and OS
     *                             specific setup.
     *                             Enum:
     *                             debian,devuan,ubuntu,centos,fedora,opensuse,archlinux,alpine,gentoo,nixos,unmanaged
     * @param password             Sets root password inside container.
     * @param pool                 Add the VM to the specified pool.
     * @param protection           Sets the protection flag of the container. This
     *                             will prevent the CT or CT's disk remove/update
     *                             operation.
     * @param restore              Mark this as restore task.
     * @param rootfs               Use volume as container root.
     * @param searchdomain         Sets DNS search domains for a container. Create
     *                             will automatically use the setting from the host
     *                             if you neither set searchdomain nor nameserver.
     * @param ssh_public_keys      Setup public SSH keys (one key per line, OpenSSH
     *                             format).
     * @param start                Start the CT after its creation finished
     *                             successfully.
     * @param startup              Startup and shutdown behavior. Order is a
     *                             non-negative number defining the general startup
     *                             order. Shutdown in done with reverse ordering.
     *                             Additionally, you can set the 'up' or 'down' delay
     *                             in seconds, which specifies a delay to wait
     *                             before the next VM is started or stopped.
     * @param storage              Default Storage.
     * @param swap                 Amount of SWAP for the container in MB.
     * @param tags                 Tags of the Container. This is only meta
     *                             information.
     * @param template             Enable/disable Template.
     * @param timezone             Time zone to use in the container. If option
     *                             isn't set, then nothing will be done. Can be set
     *                             to 'host' to match the host time zone, or an
     *                             arbitrary time zone option from
     *                             /usr/share/zoneinfo/zone.tab
     * @param tty                  Specify the number of tty available to the
     *                             container
     * @param unique               Assign a unique random ethernet address.
     * @param unprivileged         Makes the container run as unprivileged user. For
     *                             creation, the default is 1. For restore, the
     *                             default is the value from the backup. (Should not
     *                             be modified manually.)
     * @param unusedN              Reference to unused volumes. This is used
     *                             internally, and should not be modified manually.
     * @return Result
     */

    public Result createVm(String ostemplate, int vmid, String arch, Float bwlimit, String cmode,
                           Boolean console, Integer cores, Float cpulimit, Integer cpuunits, Boolean debug,
                           String description, Map<Integer, String> devN, String entrypoint, String env, String features,
                           Boolean force, Boolean ha_managed, String hookscript, String hostname,
                           Boolean ignore_unpack_errors, String lock_, Integer memory, Map<Integer, String> mpN,
                           String nameserver, Map<Integer, String> netN, Boolean onboot, String ostype, String password,
                           String pool, Boolean protection, Boolean restore, String rootfs, String searchdomain,
                           String ssh_public_keys, Boolean start, String startup, String storage, Integer swap,
                           String tags, Boolean template, String timezone, Integer tty, Boolean unique,
                           Boolean unprivileged, Map<Integer, String> unusedN) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("ostemplate", ostemplate);
        parameters.put("vmid", vmid);
        parameters.put("arch", arch);
        parameters.put("bwlimit", bwlimit);
        parameters.put("cmode", cmode);
        parameters.put("console", console);
        parameters.put("cores", cores);
        parameters.put("cpulimit", cpulimit);
        parameters.put("cpuunits", cpuunits);
        parameters.put("debug", debug);
        parameters.put("description", description);
        parameters.put("entrypoint", entrypoint);
        parameters.put("env", env);
        parameters.put("features", features);
        parameters.put("force", force);
        parameters.put("ha-managed", ha_managed);
        parameters.put("hookscript", hookscript);
        parameters.put("hostname", hostname);
        parameters.put("ignore-unpack-errors", ignore_unpack_errors);
        parameters.put("lock", lock_);
        parameters.put("memory", memory);
        parameters.put("nameserver", nameserver);
        parameters.put("onboot", onboot);
        parameters.put("ostype", ostype);
        parameters.put("password", password);
        parameters.put("pool", pool);
        parameters.put("protection", protection);
        parameters.put("restore", restore);
        parameters.put("rootfs", rootfs);
        parameters.put("searchdomain", searchdomain);
        parameters.put("ssh-public-keys", ssh_public_keys);
        parameters.put("start", start);
        parameters.put("startup", startup);
        parameters.put("storage", storage);
        parameters.put("swap", swap);
        parameters.put("tags", tags);
        parameters.put("template", template);
        parameters.put("timezone", timezone);
        parameters.put("tty", tty);
        parameters.put("unique", unique);
        parameters.put("unprivileged", unprivileged);
        PveClientBase.addIndexedParameter(parameters, "dev", devN);
        PveClientBase.addIndexedParameter(parameters, "mp", mpN);
        PveClientBase.addIndexedParameter(parameters, "net", netN);
        PveClientBase.addIndexedParameter(parameters, "unused", unusedN);
        return client.create("/nodes/" + this.node + "/lxc", parameters);
    }

    /**
     * Create or restore a container.
     *
     * @param ostemplate The OS template or backup file.
     * @param vmid       The (unique) ID of the VM.
     * @return Result
     */

    public Result createVm(String ostemplate, int vmid) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("ostemplate", ostemplate);
        parameters.put("vmid", vmid);
        return client.create("/nodes/" + this.node + "/lxc", parameters);
    }

}

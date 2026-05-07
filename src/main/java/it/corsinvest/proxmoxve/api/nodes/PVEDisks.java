package it.corsinvest.proxmoxve.api.nodes;

import it.corsinvest.proxmoxve.api.PveClient;
import it.corsinvest.proxmoxve.api.Result;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class PVEDisks {

    private final PveClient client;
    private final Object node;

    public PVEDisks(PveClient client, Object node) {
        this.client = client;
        this.node = node;
    }

    private PVELvm lvm;

    public PVELvm getLvm() {
        return lvm == null ? (lvm = new PVELvm(client, this.node)) : lvm;
    }

    private PVELvmthin lvmthin;

    public PVELvmthin getLvmthin() {
        return lvmthin == null ? (lvmthin = new PVELvmthin(client, this.node)) : lvmthin;
    }

    private PVEDirectory directory;

    public PVEDirectory getDirectory() {
        return directory == null ? (directory = new PVEDirectory(client, this.node)) : directory;
    }

    private PVEZfs zfs;

    public PVEZfs getZfs() {
        return zfs == null ? (zfs = new PVEZfs(client, this.node)) : zfs;
    }

    private PVEList list;

    public PVEList getList() {
        return list == null ? (list = new PVEList(client, this.node)) : list;
    }

    private PVESmart smart;

    public PVESmart getSmart() {
        return smart == null ? (smart = new PVESmart(client, this.node)) : smart;
    }

    private PVEInitgpt initgpt;

    public PVEInitgpt getInitgpt() {
        return initgpt == null ? (initgpt = new PVEInitgpt(client, this.node)) : initgpt;
    }

    private PVEWipedisk wipedisk;

    public PVEWipedisk getWipedisk() {
        return wipedisk == null ? (wipedisk = new PVEWipedisk(client, this.node)) : wipedisk;
    }

    public static class PVELvm {

        private final PveClient client;
        private final Object node;

        protected PVELvm(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        public PVELvm.PVENameItem get(Object name) {
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
             * Remove an LVM Volume Group.
             *
             * @param cleanup_config Marks associated storage(s) as not available on this
             *                       node anymore or removes them from the configuration (if
             *                       configured for this node only).
             * @param cleanup_disks  Also wipe disks so they can be repurposed afterwards.
             * @return Result
             */

            public Result delete(Boolean cleanup_config, Boolean cleanup_disks) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("cleanup-config", cleanup_config);
                parameters.put("cleanup-disks", cleanup_disks);
                return client.delete("/nodes/" + this.node + "/disks/lvm/" + this.name, parameters);
            }

            /**
             * Remove an LVM Volume Group.
             *
             * @return Result
             */

            public Result delete() {
                return client.delete("/nodes/" + this.node + "/disks/lvm/" + this.name, null);
            }

        }

        /**
         * List LVM Volume Groups
         *
         * @return Result
         */

        public Result index() {
            return client.get("/nodes/" + this.node + "/disks/lvm", null);
        }

        /**
         * Create an LVM Volume Group
         *
         * @param device      The block device you want to create the volume group on
         * @param name        The storage identifier.
         * @param add_storage Configure storage using the Volume Group
         * @return Result
         */

        public Result create(String device, String name, Boolean add_storage) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("device", device);
            parameters.put("name", name);
            parameters.put("add_storage", add_storage);
            return client.create("/nodes/" + this.node + "/disks/lvm", parameters);
        }

        /**
         * Create an LVM Volume Group
         *
         * @param device The block device you want to create the volume group on
         * @param name   The storage identifier.
         * @return Result
         */

        public Result create(String device, String name) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("device", device);
            parameters.put("name", name);
            return client.create("/nodes/" + this.node + "/disks/lvm", parameters);
        }

    }

    public static class PVELvmthin {

        private final PveClient client;
        private final Object node;

        protected PVELvmthin(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        public PVELvmthin.PVENameItem get(Object name) {
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
             * Remove an LVM thin pool.
             *
             * @param volume_group   The storage identifier.
             * @param cleanup_config Marks associated storage(s) as not available on this
             *                       node anymore or removes them from the configuration (if
             *                       configured for this node only).
             * @param cleanup_disks  Also wipe disks so they can be repurposed afterwards.
             * @return Result
             */

            public Result delete(String volume_group, Boolean cleanup_config, Boolean cleanup_disks) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("volume-group", volume_group);
                parameters.put("cleanup-config", cleanup_config);
                parameters.put("cleanup-disks", cleanup_disks);
                return client.delete("/nodes/" + this.node + "/disks/lvmthin/" + this.name,
                        parameters);
            }

            /**
             * Remove an LVM thin pool.
             *
             * @param volume_group The storage identifier.
             * @return Result
             */

            public Result delete(String volume_group) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("volume-group", volume_group);
                return client.delete("/nodes/" + this.node + "/disks/lvmthin/" + this.name,
                        parameters);
            }

        }

        /**
         * List LVM thinpools
         *
         * @return Result
         */

        public Result index() {
            return client.get("/nodes/" + this.node + "/disks/lvmthin", null);
        }

        /**
         * Create an LVM thinpool
         *
         * @param device      The block device you want to create the thinpool on.
         * @param name        The storage identifier.
         * @param add_storage Configure storage using the thinpool.
         * @return Result
         */

        public Result create(String device, String name, Boolean add_storage) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("device", device);
            parameters.put("name", name);
            parameters.put("add_storage", add_storage);
            return client.create("/nodes/" + this.node + "/disks/lvmthin", parameters);
        }

        /**
         * Create an LVM thinpool
         *
         * @param device The block device you want to create the thinpool on.
         * @param name   The storage identifier.
         * @return Result
         */

        public Result create(String device, String name) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("device", device);
            parameters.put("name", name);
            return client.create("/nodes/" + this.node + "/disks/lvmthin", parameters);
        }

    }

    public static class PVEDirectory {

        private final PveClient client;
        private final Object node;

        protected PVEDirectory(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        public PVEDirectory.PVENameItem get(Object name) {
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
             * Unmounts the storage and removes the mount unit.
             *
             * @param cleanup_config Marks associated storage(s) as not available on this
             *                       node anymore or removes them from the configuration (if
             *                       configured for this node only).
             * @param cleanup_disks  Also wipe disk so it can be repurposed afterwards.
             * @return Result
             */

            public Result delete(Boolean cleanup_config, Boolean cleanup_disks) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("cleanup-config", cleanup_config);
                parameters.put("cleanup-disks", cleanup_disks);
                return client.delete("/nodes/" + this.node + "/disks/directory/" + this.name,
                        parameters);
            }

            /**
             * Unmounts the storage and removes the mount unit.
             *
             * @return Result
             */

            public Result delete() {
                return client.delete("/nodes/" + this.node + "/disks/directory/" + this.name, null);
            }

        }

        /**
         * PVE Managed Directory storages.
         *
         * @return Result
         */

        public Result index() {
            return client.get("/nodes/" + this.node + "/disks/directory", null);
        }

        /**
         * Create a Filesystem on an unused disk. Will be mounted under '/mnt/pve/NAME'.
         *
         * @param device      The block device you want to create the filesystem on.
         * @param name        The storage identifier.
         * @param add_storage Configure storage using the directory.
         * @param filesystem  The desired filesystem.
         *                    Enum: ext4,xfs
         * @return Result
         */

        public Result create(String device, String name, Boolean add_storage, String filesystem) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("device", device);
            parameters.put("name", name);
            parameters.put("add_storage", add_storage);
            parameters.put("filesystem", filesystem);
            return client.create("/nodes/" + this.node + "/disks/directory", parameters);
        }

        /**
         * Create a Filesystem on an unused disk. Will be mounted under '/mnt/pve/NAME'.
         *
         * @param device The block device you want to create the filesystem on.
         * @param name   The storage identifier.
         * @return Result
         */

        public Result create(String device, String name) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("device", device);
            parameters.put("name", name);
            return client.create("/nodes/" + this.node + "/disks/directory", parameters);
        }

    }

    public static class PVEZfs {

        private final PveClient client;
        private final Object node;

        protected PVEZfs(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        public PVEZfs.PVENameItem get(Object name) {
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
             * Destroy a ZFS pool.
             *
             * @param cleanup_config Marks associated storage(s) as not available on this
             *                       node anymore or removes them from the configuration (if
             *                       configured for this node only).
             * @param cleanup_disks  Also wipe disks so they can be repurposed afterwards.
             * @return Result
             */

            public Result delete(Boolean cleanup_config, Boolean cleanup_disks) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("cleanup-config", cleanup_config);
                parameters.put("cleanup-disks", cleanup_disks);
                return client.delete("/nodes/" + this.node + "/disks/zfs/" + this.name, parameters);
            }

            /**
             * Destroy a ZFS pool.
             *
             * @return Result
             */

            public Result delete() {
                return client.delete("/nodes/" + this.node + "/disks/zfs/" + this.name, null);
            }

            /**
             * Get details about a zpool.
             *
             * @return Result
             */

            public Result detail() {
                return client.get("/nodes/" + this.node + "/disks/zfs/" + this.name, null);
            }

        }

        /**
         * List Zpools.
         *
         * @return Result
         */

        public Result index() {
            return client.get("/nodes/" + this.node + "/disks/zfs", null);
        }

        /**
         * Create a ZFS pool.
         *
         * @param devices      The block devices you want to create the zpool on.
         * @param name         The storage identifier.
         * @param raidlevel    The RAID level to use.
         *                     Enum:
         *                     single,mirror,raid10,raidz,raidz2,raidz3,draid,draid2,draid3
         * @param add_storage  Configure storage using the zpool.
         * @param ashift       Pool sector size exponent.
         * @param compression  The compression algorithm to use.
         *                     Enum: on,off,gzip,lz4,lzjb,zle,zstd
         * @param draid_config
         * @return Result
         */

        public Result create(String devices, String name, String raidlevel, Boolean add_storage,
                             Integer ashift, String compression, String draid_config) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("devices", devices);
            parameters.put("name", name);
            parameters.put("raidlevel", raidlevel);
            parameters.put("add_storage", add_storage);
            parameters.put("ashift", ashift);
            parameters.put("compression", compression);
            parameters.put("draid-config", draid_config);
            return client.create("/nodes/" + this.node + "/disks/zfs", parameters);
        }

        /**
         * Create a ZFS pool.
         *
         * @param devices   The block devices you want to create the zpool on.
         * @param name      The storage identifier.
         * @param raidlevel The RAID level to use.
         *                  Enum:
         *                  single,mirror,raid10,raidz,raidz2,raidz3,draid,draid2,draid3
         * @return Result
         */

        public Result create(String devices, String name, String raidlevel) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("devices", devices);
            parameters.put("name", name);
            parameters.put("raidlevel", raidlevel);
            return client.create("/nodes/" + this.node + "/disks/zfs", parameters);
        }

    }

    public static class PVEList {

        private final PveClient client;
        private final Object node;

        protected PVEList(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        /**
         * List local disks.
         *
         * @param include_partitions Also include partitions.
         * @param skipsmart          Skip smart checks.
         * @param type               Only list specific types of disks.
         *                           Enum: unused,journal_disks
         * @return Result
         */

        public Result list(Boolean include_partitions, Boolean skipsmart, String type) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("include-partitions", include_partitions);
            parameters.put("skipsmart", skipsmart);
            parameters.put("type", type);
            return client.get("/nodes/" + this.node + "/disks/list", parameters);
        }

        /**
         * List local disks.
         *
         * @return Result
         */

        public Result list() {
            return client.get("/nodes/" + this.node + "/disks/list", null);
        }

    }

    public static class PVESmart {

        private final PveClient client;
        private final Object node;

        protected PVESmart(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        /**
         * Get SMART Health of a disk.
         *
         * @param disk       Block device name
         * @param healthonly If true returns only the health status
         * @return Result
         */

        public Result smart(String disk, Boolean healthonly) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("disk", disk);
            parameters.put("healthonly", healthonly);
            return client.get("/nodes/" + this.node + "/disks/smart", parameters);
        }

        /**
         * Get SMART Health of a disk.
         *
         * @param disk Block device name
         * @return Result
         */

        public Result smart(String disk) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("disk", disk);
            return client.get("/nodes/" + this.node + "/disks/smart", parameters);
        }

    }

    public static class PVEInitgpt {

        private final PveClient client;
        private final Object node;

        protected PVEInitgpt(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        /**
         * Initialize Disk with GPT
         *
         * @param disk Block device name
         * @param uuid UUID for the GPT table
         * @return Result
         */

        public Result initgpt(String disk, String uuid) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("disk", disk);
            parameters.put("uuid", uuid);
            return client.create("/nodes/" + this.node + "/disks/initgpt", parameters);
        }

        /**
         * Initialize Disk with GPT
         *
         * @param disk Block device name
         * @return Result
         */

        public Result initgpt(String disk) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("disk", disk);
            return client.create("/nodes/" + this.node + "/disks/initgpt", parameters);
        }

    }

    public static class PVEWipedisk {

        private final PveClient client;
        private final Object node;

        protected PVEWipedisk(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        /**
         * Wipe a disk or partition.
         *
         * @param disk Block device name
         * @return Result
         */

        public Result wipeDisk(String disk) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("disk", disk);
            return client.set("/nodes/" + this.node + "/disks/wipedisk", parameters);
        }

    }

    /**
     * Node index.
     *
     * @return Result
     */

    public Result index() {
        return client.get("/nodes/" + this.node + "/disks", null);
    }

}

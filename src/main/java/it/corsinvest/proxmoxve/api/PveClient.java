/*
 * SPDX-FileCopyrightText: Copyright Corsinvest Srl
 * SPDX-License-Identifier: MIT
 */

package it.corsinvest.proxmoxve.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Proxmox VE Client for interacting with the Proxmox Virtual Environment API.
 * This class provides a high-level interface for managing Proxmox VE resources
 * including clusters, nodes, virtual machines, storage, and access control.
 * <p>
 * The client handles authentication, request construction, and response parsing
 * to provide a convenient Java API for Proxmox VE administration tasks.
 */
@SuppressWarnings("unused")
public class PveClient extends PveClientBase {

    /**
     * Creates a new Proxmox VE client instance.
     *
     * @param hostname the hostname or IP address of the Proxmox VE server
     * @param port     the port number for the API (typically 8006)
     */
    public PveClient(String hostname, int port) {
        super(hostname, port);
    }

    public PveClient(String hostname, int port, String apiToken) {
        this(hostname, port);
        this.setApiToken(apiToken);
    }

    private PVECluster cluster;

    public PVECluster getCluster() {
        return cluster == null ? (cluster = new PVECluster(this)) : cluster;
    }

    private PVENodes nodes;

    public PVENodes getNodes() {
        return nodes == null ? (nodes = new PVENodes(this)) : nodes;
    }

    private PVEStorage storage;

    public PVEStorage getStorage() {
        return storage == null ? (storage = new PVEStorage(this)) : storage;
    }

    private PVEAccess access;

    public PVEAccess getAccess() {
        return access == null ? (access = new PVEAccess(this)) : access;
    }

    private PVEPools pools;

    public PVEPools getPools() {
        return pools == null ? (pools = new PVEPools(this)) : pools;
    }

    private PVEVersion version;

    public PVEVersion getVersion() {
        return version == null ? (version = new PVEVersion(this)) : version;
    }

    public static class PVEStorage {
        private final PveClient client;

        protected PVEStorage(PveClient client) {
            this.client = client;

        }

        public PVEStorageItem get(Object storage) {
            return new PVEStorageItem(client, storage);
        }

        public static class PVEStorageItem {
            private final PveClient client;
            private final Object storage;

            protected PVEStorageItem(PveClient client, Object storage) {
                this.client = client;
                this.storage = storage;
            }

            public PveClient getClient() {
                return client;
            }

            /**
             * Delete storage configuration.
             *
             * @return Result
             */

            public Result delete() {
                return client.delete("/storage/" + this.storage, null);
            }

            /**
             * Read storage configuration.
             *
             * @return Result
             */

            public Result read() {
                return client.get("/storage/" + this.storage, null);
            }

            /**
             * Update storage configuration.
             *
             * @param blocksize                block size
             * @param bwlimit                  Set I/O bandwidth limit for various
             *                                 operations (in KiB/s).
             * @param comstar_hg               host group for comstar views
             * @param comstar_tg               target group for comstar views
             * @param content                  Allowed content types. NOTE: the value
             *                                 'rootdir' is used for Containers, and value
             *                                 'images' for VMs.
             * @param content_dirs             Overrides for default content type
             *                                 directories.
             * @param create_base_path         Create the base directory if it doesn't
             *                                 exist.
             * @param create_subdirs           Populate the directory with the default
             *                                 structure.
             * @param data_pool                Data Pool (for erasure coding only)
             * @param delete                   A list of settings you want to delete.
             * @param digest                   Prevent changes if current configuration file
             *                                 has a different digest. This can be used to
             *                                 prevent concurrent modifications.
             * @param disable                  Flag to disable the storage.
             * @param domain                   CIFS domain.
             * @param encryption_key           Encryption key. Use 'autogen' to generate one
             *                                 automatically without passphrase.
             * @param fingerprint              Certificate SHA 256 fingerprint.
             * @param format                   Default image format.
             *                                 Enum: raw,qcow2,subvol,vmdk
             * @param fs_name                  The Ceph filesystem name.
             * @param fuse                     Mount CephFS through FUSE.
             * @param is_mountpoint            Assume the given path is an externally
             *                                 managed mountpoint and consider the storage
             *                                 offline if it is not mounted. Using a boolean
             *                                 (yes/no) value serves as a shortcut to using
             *                                 the target path in this field.
             * @param keyring                  Client keyring contents (for external
             *                                 clusters).
             * @param krbd                     Always access rbd through krbd kernel module.
             * @param lio_tpg                  target portal group for Linux LIO targets
             * @param master_pubkey            Base64-encoded, PEM-formatted public RSA key.
             *                                 Used to encrypt a copy of the encryption-key
             *                                 which will be added to each encrypted backup.
             * @param max_protected_backups    Maximal number of protected backups per
             *                                 guest. Use '-1' for unlimited.
             * @param mkdir                    Create the directory if it doesn't exist and
             *                                 populate it with default sub-dirs. NOTE:
             *                                 Deprecated, use the 'create-base-path' and
             *                                 'create-subdirs' options instead.
             * @param monhost                  IP addresses of monitors (for external
             *                                 clusters).
             * @param mountpoint               mount point
             * @param namespace_               Namespace.
             * @param nocow                    Set the NOCOW flag on files. Disables data
             *                                 checksumming and causes data errors to be
             *                                 unrecoverable from while allowing direct I/O.
             *                                 Only use this if data does not need to be any
             *                                 more safe than on a single ext4 formatted
             *                                 disk with no underlying raid system.
             * @param nodes                    List of nodes for which the storage
             *                                 configuration applies.
             * @param nowritecache             disable write caching on the target
             * @param options                  NFS/CIFS mount options (see 'man nfs' or 'man
             *                                 mount.cifs')
             * @param password                 Password for accessing the share/datastore.
             * @param pool                     Pool.
             * @param port                     Use this port to connect to the storage
             *                                 instead of the default one (for example, with
             *                                 PBS or ESXi). For NFS and CIFS, use the
             *                                 'options' option to configure the port via
             *                                 the mount options.
             * @param preallocation            Preallocation mode for raw and qcow2 images.
             *                                 Using 'metadata' on raw images results in
             *                                 preallocation=off.
             *                                 Enum: off,metadata,falloc,full
             * @param prune_backups            The retention options with shorter intervals
             *                                 are processed first with --keep-last being
             *                                 the very first one. Each option covers a
             *                                 specific period of time. We say that backups
             *                                 within this period are covered by this
             *                                 option. The next option does not take care of
             *                                 already covered backups and only considers
             *                                 older backups.
             * @param saferemove               Zero-out data when removing LVs.
             * @param saferemove_stepsize      Wipe step size in MiB. It will be capped to
             *                                 the maximum supported by the storage.
             *                                 Enum: 1,2,4,8,16,32
             * @param saferemove_throughput    Wipe throughput (cstream -t parameter value).
             * @param server                   Server IP or DNS name.
             * @param shared                   Indicate that this is a single storage with
             *                                 the same contents on all nodes (or all listed
             *                                 in the 'nodes' option). It will not make the
             *                                 contents of a local storage automatically
             *                                 accessible to other nodes, it just marks an
             *                                 already shared storage as such!
             * @param skip_cert_verification   Disable TLS certificate verification, only
             *                                 enable on fully trusted networks!
             * @param smbversion               SMB protocol version. 'default' if not set,
             *                                 negotiates the highest SMB2+ version
             *                                 supported by both the client and server.
             *                                 Enum: default,2.0,2.1,3,3.0,3.11
             * @param snapshot_as_volume_chain Enable support for creating storage-vendor
             *                                 agnostic snapshot through volume
             *                                 backing-chains.
             * @param sparse                   use sparse volumes
             * @param subdir                   Subdir to mount.
             * @param tagged_only              Only use logical volumes tagged with
             *                                 'pve-vm-ID'.
             * @param username                 RBD Id.
             * @param zfs_base_path            Base path where to look for the created ZFS
             *                                 block devices. Set automatically during
             *                                 creation if not specified. Usually
             *                                 '/dev/zvol'.
             * @return Result
             */

            public Result update(String blocksize, String bwlimit, String comstar_hg, String comstar_tg, String content,
                    String content_dirs, Boolean create_base_path, Boolean create_subdirs, String data_pool,
                    String delete, String digest, Boolean disable, String domain, String encryption_key,
                    String fingerprint, String format, String fs_name, Boolean fuse, String is_mountpoint,
                    String keyring, Boolean krbd, String lio_tpg, String master_pubkey, Integer max_protected_backups,
                    Boolean mkdir, String monhost, String mountpoint, String namespace_, Boolean nocow, String nodes,
                    Boolean nowritecache, String options, String password, String pool, Integer port,
                    String preallocation, String prune_backups, Boolean saferemove, Integer saferemove_stepsize,
                    String saferemove_throughput, String server, Boolean shared, Boolean skip_cert_verification,
                    String smbversion, Boolean snapshot_as_volume_chain, Boolean sparse, String subdir,
                    Boolean tagged_only, String username, String zfs_base_path) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("blocksize", blocksize);
                parameters.put("bwlimit", bwlimit);
                parameters.put("comstar_hg", comstar_hg);
                parameters.put("comstar_tg", comstar_tg);
                parameters.put("content", content);
                parameters.put("content-dirs", content_dirs);
                parameters.put("create-base-path", create_base_path);
                parameters.put("create-subdirs", create_subdirs);
                parameters.put("data-pool", data_pool);
                parameters.put("delete", delete);
                parameters.put("digest", digest);
                parameters.put("disable", disable);
                parameters.put("domain", domain);
                parameters.put("encryption-key", encryption_key);
                parameters.put("fingerprint", fingerprint);
                parameters.put("format", format);
                parameters.put("fs-name", fs_name);
                parameters.put("fuse", fuse);
                parameters.put("is_mountpoint", is_mountpoint);
                parameters.put("keyring", keyring);
                parameters.put("krbd", krbd);
                parameters.put("lio_tpg", lio_tpg);
                parameters.put("master-pubkey", master_pubkey);
                parameters.put("max-protected-backups", max_protected_backups);
                parameters.put("mkdir", mkdir);
                parameters.put("monhost", monhost);
                parameters.put("mountpoint", mountpoint);
                parameters.put("namespace", namespace_);
                parameters.put("nocow", nocow);
                parameters.put("nodes", nodes);
                parameters.put("nowritecache", nowritecache);
                parameters.put("options", options);
                parameters.put("password", password);
                parameters.put("pool", pool);
                parameters.put("port", port);
                parameters.put("preallocation", preallocation);
                parameters.put("prune-backups", prune_backups);
                parameters.put("saferemove", saferemove);
                parameters.put("saferemove-stepsize", saferemove_stepsize);
                parameters.put("saferemove_throughput", saferemove_throughput);
                parameters.put("server", server);
                parameters.put("shared", shared);
                parameters.put("skip-cert-verification", skip_cert_verification);
                parameters.put("smbversion", smbversion);
                parameters.put("snapshot-as-volume-chain", snapshot_as_volume_chain);
                parameters.put("sparse", sparse);
                parameters.put("subdir", subdir);
                parameters.put("tagged_only", tagged_only);
                parameters.put("username", username);
                parameters.put("zfs-base-path", zfs_base_path);
                return client.set("/storage/" + this.storage, parameters);
            }

            /**
             * Update storage configuration.
             *
             * @return Result
             */

            public Result update() {
                return client.set("/storage/" + this.storage, null);
            }

        }

        /**
         * Storage index.
         *
         * @param type Only list storage of specific type
         *             Enum:
         *             btrfs,cephfs,cifs,dir,esxi,iscsi,iscsidirect,lvm,lvmthin,nfs,pbs,rbd,zfs,zfspool
         * @return Result
         */

        public Result index(String type) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("type", type);
            return client.get("/storage", parameters);
        }

        /**
         * Storage index.
         *
         * @return Result
         */

        public Result index() {
            return client.get("/storage", null);
        }

        /**
         * Create a new storage.
         *
         * @param storage                  The storage identifier.
         * @param type                     Storage type.
         *                                 Enum:
         *                                 btrfs,cephfs,cifs,dir,esxi,iscsi,iscsidirect,lvm,lvmthin,nfs,pbs,rbd,zfs,zfspool
         * @param authsupported            Authsupported.
         * @param base_                    Base volume. This volume is automatically
         *                                 activated.
         * @param blocksize                block size
         * @param bwlimit                  Set I/O bandwidth limit for various
         *                                 operations (in KiB/s).
         * @param comstar_hg               host group for comstar views
         * @param comstar_tg               target group for comstar views
         * @param content                  Allowed content types. NOTE: the value
         *                                 'rootdir' is used for Containers, and value
         *                                 'images' for VMs.
         * @param content_dirs             Overrides for default content type
         *                                 directories.
         * @param create_base_path         Create the base directory if it doesn't
         *                                 exist.
         * @param create_subdirs           Populate the directory with the default
         *                                 structure.
         * @param data_pool                Data Pool (for erasure coding only)
         * @param datastore                Proxmox Backup Server datastore name.
         * @param disable                  Flag to disable the storage.
         * @param domain                   CIFS domain.
         * @param encryption_key           Encryption key. Use 'autogen' to generate one
         *                                 automatically without passphrase.
         * @param export                   NFS export path.
         * @param fingerprint              Certificate SHA 256 fingerprint.
         * @param format                   Default image format.
         *                                 Enum: raw,qcow2,subvol,vmdk
         * @param fs_name                  The Ceph filesystem name.
         * @param fuse                     Mount CephFS through FUSE.
         * @param is_mountpoint            Assume the given path is an externally
         *                                 managed mountpoint and consider the storage
         *                                 offline if it is not mounted. Using a boolean
         *                                 (yes/no) value serves as a shortcut to using
         *                                 the target path in this field.
         * @param iscsiprovider            iscsi provider
         * @param keyring                  Client keyring contents (for external
         *                                 clusters).
         * @param krbd                     Always access rbd through krbd kernel module.
         * @param lio_tpg                  target portal group for Linux LIO targets
         * @param master_pubkey            Base64-encoded, PEM-formatted public RSA key.
         *                                 Used to encrypt a copy of the encryption-key
         *                                 which will be added to each encrypted backup.
         * @param max_protected_backups    Maximal number of protected backups per
         *                                 guest. Use '-1' for unlimited.
         * @param mkdir                    Create the directory if it doesn't exist and
         *                                 populate it with default sub-dirs. NOTE:
         *                                 Deprecated, use the 'create-base-path' and
         *                                 'create-subdirs' options instead.
         * @param monhost                  IP addresses of monitors (for external
         *                                 clusters).
         * @param mountpoint               mount point
         * @param namespace_               Namespace.
         * @param nocow                    Set the NOCOW flag on files. Disables data
         *                                 checksumming and causes data errors to be
         *                                 unrecoverable from while allowing direct I/O.
         *                                 Only use this if data does not need to be any
         *                                 more safe than on a single ext4 formatted
         *                                 disk with no underlying raid system.
         * @param nodes                    List of nodes for which the storage
         *                                 configuration applies.
         * @param nowritecache             disable write caching on the target
         * @param options                  NFS/CIFS mount options (see 'man nfs' or 'man
         *                                 mount.cifs')
         * @param password                 Password for accessing the share/datastore.
         * @param path                     File system path.
         * @param pool                     Pool.
         * @param port                     Use this port to connect to the storage
         *                                 instead of the default one (for example, with
         *                                 PBS or ESXi). For NFS and CIFS, use the
         *                                 'options' option to configure the port via
         *                                 the mount options.
         * @param portal                   iSCSI portal (IP or DNS name with optional
         *                                 port).
         * @param preallocation            Preallocation mode for raw and qcow2 images.
         *                                 Using 'metadata' on raw images results in
         *                                 preallocation=off.
         *                                 Enum: off,metadata,falloc,full
         * @param prune_backups            The retention options with shorter intervals
         *                                 are processed first with --keep-last being
         *                                 the very first one. Each option covers a
         *                                 specific period of time. We say that backups
         *                                 within this period are covered by this
         *                                 option. The next option does not take care of
         *                                 already covered backups and only considers
         *                                 older backups.
         * @param saferemove               Zero-out data when removing LVs.
         * @param saferemove_stepsize      Wipe step size in MiB. It will be capped to
         *                                 the maximum supported by the storage.
         *                                 Enum: 1,2,4,8,16,32
         * @param saferemove_throughput    Wipe throughput (cstream -t parameter value).
         * @param server                   Server IP or DNS name.
         * @param share                    CIFS share.
         * @param shared                   Indicate that this is a single storage with
         *                                 the same contents on all nodes (or all listed
         *                                 in the 'nodes' option). It will not make the
         *                                 contents of a local storage automatically
         *                                 accessible to other nodes, it just marks an
         *                                 already shared storage as such!
         * @param skip_cert_verification   Disable TLS certificate verification, only
         *                                 enable on fully trusted networks!
         * @param smbversion               SMB protocol version. 'default' if not set,
         *                                 negotiates the highest SMB2+ version
         *                                 supported by both the client and server.
         *                                 Enum: default,2.0,2.1,3,3.0,3.11
         * @param snapshot_as_volume_chain Enable support for creating storage-vendor
         *                                 agnostic snapshot through volume
         *                                 backing-chains.
         * @param sparse                   use sparse volumes
         * @param subdir                   Subdir to mount.
         * @param tagged_only              Only use logical volumes tagged with
         *                                 'pve-vm-ID'.
         * @param target                   iSCSI target.
         * @param thinpool                 LVM thin pool LV name.
         * @param username                 RBD Id.
         * @param vgname                   Volume group name.
         * @param zfs_base_path            Base path where to look for the created ZFS
         *                                 block devices. Set automatically during
         *                                 creation if not specified. Usually
         *                                 '/dev/zvol'.
         * @return Result
         */

        public Result create(String storage, String type, String authsupported, String base_, String blocksize,
                String bwlimit, String comstar_hg, String comstar_tg, String content, String content_dirs,
                Boolean create_base_path, Boolean create_subdirs, String data_pool, String datastore, Boolean disable,
                String domain, String encryption_key, String export, String fingerprint, String format, String fs_name,
                Boolean fuse, String is_mountpoint, String iscsiprovider, String keyring, Boolean krbd, String lio_tpg,
                String master_pubkey, Integer max_protected_backups, Boolean mkdir, String monhost, String mountpoint,
                String namespace_, Boolean nocow, String nodes, Boolean nowritecache, String options, String password,
                String path, String pool, Integer port, String portal, String preallocation, String prune_backups,
                Boolean saferemove, Integer saferemove_stepsize, String saferemove_throughput, String server,
                String share, Boolean shared, Boolean skip_cert_verification, String smbversion,
                Boolean snapshot_as_volume_chain, Boolean sparse, String subdir, Boolean tagged_only, String target,
                String thinpool, String username, String vgname, String zfs_base_path) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("storage", storage);
            parameters.put("type", type);
            parameters.put("authsupported", authsupported);
            parameters.put("base", base_);
            parameters.put("blocksize", blocksize);
            parameters.put("bwlimit", bwlimit);
            parameters.put("comstar_hg", comstar_hg);
            parameters.put("comstar_tg", comstar_tg);
            parameters.put("content", content);
            parameters.put("content-dirs", content_dirs);
            parameters.put("create-base-path", create_base_path);
            parameters.put("create-subdirs", create_subdirs);
            parameters.put("data-pool", data_pool);
            parameters.put("datastore", datastore);
            parameters.put("disable", disable);
            parameters.put("domain", domain);
            parameters.put("encryption-key", encryption_key);
            parameters.put("export", export);
            parameters.put("fingerprint", fingerprint);
            parameters.put("format", format);
            parameters.put("fs-name", fs_name);
            parameters.put("fuse", fuse);
            parameters.put("is_mountpoint", is_mountpoint);
            parameters.put("iscsiprovider", iscsiprovider);
            parameters.put("keyring", keyring);
            parameters.put("krbd", krbd);
            parameters.put("lio_tpg", lio_tpg);
            parameters.put("master-pubkey", master_pubkey);
            parameters.put("max-protected-backups", max_protected_backups);
            parameters.put("mkdir", mkdir);
            parameters.put("monhost", monhost);
            parameters.put("mountpoint", mountpoint);
            parameters.put("namespace", namespace_);
            parameters.put("nocow", nocow);
            parameters.put("nodes", nodes);
            parameters.put("nowritecache", nowritecache);
            parameters.put("options", options);
            parameters.put("password", password);
            parameters.put("path", path);
            parameters.put("pool", pool);
            parameters.put("port", port);
            parameters.put("portal", portal);
            parameters.put("preallocation", preallocation);
            parameters.put("prune-backups", prune_backups);
            parameters.put("saferemove", saferemove);
            parameters.put("saferemove-stepsize", saferemove_stepsize);
            parameters.put("saferemove_throughput", saferemove_throughput);
            parameters.put("server", server);
            parameters.put("share", share);
            parameters.put("shared", shared);
            parameters.put("skip-cert-verification", skip_cert_verification);
            parameters.put("smbversion", smbversion);
            parameters.put("snapshot-as-volume-chain", snapshot_as_volume_chain);
            parameters.put("sparse", sparse);
            parameters.put("subdir", subdir);
            parameters.put("tagged_only", tagged_only);
            parameters.put("target", target);
            parameters.put("thinpool", thinpool);
            parameters.put("username", username);
            parameters.put("vgname", vgname);
            parameters.put("zfs-base-path", zfs_base_path);
            return client.create("/storage", parameters);
        }

        /**
         * Create a new storage.
         *
         * @param storage The storage identifier.
         * @param type    Storage type.
         *                Enum:
         *                btrfs,cephfs,cifs,dir,esxi,iscsi,iscsidirect,lvm,lvmthin,nfs,pbs,rbd,zfs,zfspool
         * @return Result
         */

        public Result create(String storage, String type) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("storage", storage);
            parameters.put("type", type);
            return client.create("/storage", parameters);
        }

    }

    public static class PVEAccess {
        private final PveClient client;

        protected PVEAccess(PveClient client) {
            this.client = client;

        }

        private PVEUsers users;

        public PVEUsers getUsers() {
            return users == null ? (users = new PVEUsers(client)) : users;
        }

        private PVEGroups groups;

        public PVEGroups getGroups() {
            return groups == null ? (groups = new PVEGroups(client)) : groups;
        }

        private PVERoles roles;

        public PVERoles getRoles() {
            return roles == null ? (roles = new PVERoles(client)) : roles;
        }

        private PVEAcl acl;

        public PVEAcl getAcl() {
            return acl == null ? (acl = new PVEAcl(client)) : acl;
        }

        private PVEDomains domains;

        public PVEDomains getDomains() {
            return domains == null ? (domains = new PVEDomains(client)) : domains;
        }

        private PVEOpenid openid;

        public PVEOpenid getOpenid() {
            return openid == null ? (openid = new PVEOpenid(client)) : openid;
        }

        private PVETfa tfa;

        public PVETfa getTfa() {
            return tfa == null ? (tfa = new PVETfa(client)) : tfa;
        }

        private PVETicket ticket;

        public PVETicket getTicket() {
            return ticket == null ? (ticket = new PVETicket(client)) : ticket;
        }

        private PVEVncticket vncticket;

        public PVEVncticket getVncticket() {
            return vncticket == null ? (vncticket = new PVEVncticket(client)) : vncticket;
        }

        private PVEPassword password;

        public PVEPassword getPassword() {
            return password == null ? (password = new PVEPassword(client)) : password;
        }

        private PVEPermissions permissions;

        public PVEPermissions getPermissions() {
            return permissions == null ? (permissions = new PVEPermissions(client)) : permissions;
        }

        public static class PVEUsers {
            private final PveClient client;

            protected PVEUsers(PveClient client) {
                this.client = client;

            }

            public PVEUseridItem get(Object userid) {
                return new PVEUseridItem(client, userid);
            }

            public static class PVEUseridItem {
                private final PveClient client;
                private final Object userid;

                protected PVEUseridItem(PveClient client, Object userid) {
                    this.client = client;
                    this.userid = userid;
                }

                private PVETfa tfa;

                public PVETfa getTfa() {
                    return tfa == null ? (tfa = new PVETfa(client, this.userid)) : tfa;
                }

                private PVEUnlockTfa unlockTfa;

                public PVEUnlockTfa getUnlockTfa() {
                    return unlockTfa == null ? (unlockTfa = new PVEUnlockTfa(client, this.userid)) : unlockTfa;
                }

                private PVEToken token;

                public PVEToken getToken() {
                    return token == null ? (token = new PVEToken(client, this.userid)) : token;
                }

                public static class PVETfa {
                    private final PveClient client;
                    private final Object userid;

                    protected PVETfa(PveClient client, Object userid) {
                        this.client = client;
                        this.userid = userid;
                    }

                    /**
                     * Get user TFA types (Personal and Realm).
                     *
                     * @param multiple Request all entries as an array.
                     * @return Result
                     */

                    public Result readUserTfaType(Boolean multiple) {
                        Map<String, Object> parameters = new HashMap<>();
                        parameters.put("multiple", multiple);
                        return client.get("/access/users/" + this.userid + "/tfa", parameters);
                    }

                    /**
                     * Get user TFA types (Personal and Realm).
                     *
                     * @return Result
                     */

                    public Result readUserTfaType() {
                        return client.get("/access/users/" + this.userid + "/tfa", null);
                    }

                }

                public static class PVEUnlockTfa {
                    private final PveClient client;
                    private final Object userid;

                    protected PVEUnlockTfa(PveClient client, Object userid) {
                        this.client = client;
                        this.userid = userid;
                    }

                    /**
                     * Unlock a user's TFA authentication.
                     *
                     * @return Result
                     */

                    public Result unlockTfa() {
                        return client.set("/access/users/" + this.userid + "/unlock-tfa", null);
                    }

                }

                public static class PVEToken {
                    private final PveClient client;
                    private final Object userid;

                    protected PVEToken(PveClient client, Object userid) {
                        this.client = client;
                        this.userid = userid;
                    }

                    public PVETokenidItem get(Object tokenid) {
                        return new PVETokenidItem(client, this.userid, tokenid);
                    }

                    public static class PVETokenidItem {
                        private final PveClient client;
                        private final Object userid;
                        private final Object tokenid;

                        protected PVETokenidItem(PveClient client, Object userid, Object tokenid) {
                            this.client = client;
                            this.userid = userid;
                            this.tokenid = tokenid;
                        }

                        /**
                         * Remove API token for a specific user.
                         *
                         * @return Result
                         */

                        public Result removeToken() {
                            return client.delete("/access/users/" + this.userid + "/token/" + this.tokenid, null);
                        }

                        /**
                         * Get specific API token information.
                         *
                         * @return Result
                         */

                        public Result readToken() {
                            return client.get("/access/users/" + this.userid + "/token/" + this.tokenid, null);
                        }

                        /**
                         * Generate a new API token for a specific user. NOTE: returns API token value,
                         * which needs to be stored as it cannot be retrieved afterwards!
                         *
                         * @param comment a comment for this token
                         * @param expire  API token expiration date (seconds since epoch). '0' means no
                         *                expiration date.
                         * @param privsep Restrict API token privileges with separate ACLs (default), or
                         *                give full privileges of corresponding user.
                         * @return Result
                         */

                        public Result generateToken(String comment, Integer expire, Boolean privsep) {
                            Map<String, Object> parameters = new HashMap<>();
                            parameters.put("comment", comment);
                            parameters.put("expire", expire);
                            parameters.put("privsep", privsep);
                            return client.create("/access/users/" + this.userid + "/token/" + this.tokenid,
                                    parameters);
                        }

                        /**
                         * Generate a new API token for a specific user. NOTE: returns API token value,
                         * which needs to be stored as it cannot be retrieved afterwards!
                         *
                         * @return Result
                         */

                        public Result generateToken() {
                            return client.create("/access/users/" + this.userid + "/token/" + this.tokenid, null);
                        }

                        /**
                         * Update API token for a specific user.
                         *
                         * @param comment a comment for this token
                         * @param delete  A list of settings you want to delete.
                         * @param expire  API token expiration date (seconds since epoch). '0' means no
                         *                expiration date.
                         * @param privsep Restrict API token privileges with separate ACLs (default), or
                         *                give full privileges of corresponding user.
                         * @return Result
                         */

                        public Result updateTokenInfo(String comment, String delete, Integer expire, Boolean privsep) {
                            Map<String, Object> parameters = new HashMap<>();
                            parameters.put("comment", comment);
                            parameters.put("delete", delete);
                            parameters.put("expire", expire);
                            parameters.put("privsep", privsep);
                            return client.set("/access/users/" + this.userid + "/token/" + this.tokenid,
                                    parameters);
                        }

                        /**
                         * Update API token for a specific user.
                         *
                         * @return Result
                         */

                        public Result updateTokenInfo() {
                            return client.set("/access/users/" + this.userid + "/token/" + this.tokenid, null);
                        }

                    }

                    /**
                     * Get user API tokens.
                     *
                     * @return Result
                     */

                    public Result tokenIndex() {
                        return client.get("/access/users/" + this.userid + "/token", null);
                    }

                }

                /**
                 * Delete user.
                 *
                 * @return Result
                 */

                public Result deleteUser() {
                    return client.delete("/access/users/" + this.userid, null);
                }

                /**
                 * Get user configuration.
                 *
                 * @return Result
                 */

                public Result readUser() {
                    return client.get("/access/users/" + this.userid, null);
                }

                /**
                 * Update user configuration.
                 *
                 * @param append
                 * @param comment
                 * @param email
                 * @param enable    Enable the account (default). You can set this to '0' to
                 *                  disable the account
                 * @param expire    Account expiration date (seconds since epoch). '0' means no
                 *                  expiration date.
                 * @param firstname
                 * @param groups
                 * @param keys      Keys for two factor auth (yubico).
                 * @param lastname
                 * @return Result
                 */

                public Result updateUser(Boolean append, String comment, String email, Boolean enable, Integer expire,
                        String firstname, String groups, String keys, String lastname) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("append", append);
                    parameters.put("comment", comment);
                    parameters.put("email", email);
                    parameters.put("enable", enable);
                    parameters.put("expire", expire);
                    parameters.put("firstname", firstname);
                    parameters.put("groups", groups);
                    parameters.put("keys", keys);
                    parameters.put("lastname", lastname);
                    return client.set("/access/users/" + this.userid, parameters);
                }

                /**
                 * Update user configuration.
                 *
                 * @return Result
                 */

                public Result updateUser() {
                    return client.set("/access/users/" + this.userid, null);
                }

            }

            /**
             * User index.
             *
             * @param enabled Optional filter for enable property.
             * @param full    Include group and token information.
             * @return Result
             */

            public Result index(Boolean enabled, Boolean full) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("enabled", enabled);
                parameters.put("full", full);
                return client.get("/access/users", parameters);
            }

            /**
             * User index.
             *
             * @return Result
             */

            public Result index() {
                return client.get("/access/users", null);
            }

            /**
             * Create new user.
             *
             * @param userid    Full User ID, in the `name@realm` format.
             * @param comment
             * @param email
             * @param enable    Enable the account (default). You can set this to '0' to
             *                  disable the account
             * @param expire    Account expiration date (seconds since epoch). '0' means no
             *                  expiration date.
             * @param firstname
             * @param groups
             * @param keys      Keys for two factor auth (yubico).
             * @param lastname
             * @param password  Initial password.
             * @return Result
             */

            public Result createUser(String userid, String comment, String email, Boolean enable, Integer expire,
                    String firstname, String groups, String keys, String lastname, String password) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("userid", userid);
                parameters.put("comment", comment);
                parameters.put("email", email);
                parameters.put("enable", enable);
                parameters.put("expire", expire);
                parameters.put("firstname", firstname);
                parameters.put("groups", groups);
                parameters.put("keys", keys);
                parameters.put("lastname", lastname);
                parameters.put("password", password);
                return client.create("/access/users", parameters);
            }

            /**
             * Create new user.
             *
             * @param userid Full User ID, in the `name@realm` format.
             * @return Result
             */

            public Result createUser(String userid) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("userid", userid);
                return client.create("/access/users", parameters);
            }

        }

        public static class PVEGroups {
            private final PveClient client;

            protected PVEGroups(PveClient client) {
                this.client = client;

            }

            public PVEGroupidItem get(Object groupid) {
                return new PVEGroupidItem(client, groupid);
            }

            public static class PVEGroupidItem {
                private final PveClient client;
                private final Object groupid;

                protected PVEGroupidItem(PveClient client, Object groupid) {
                    this.client = client;
                    this.groupid = groupid;
                }

                /**
                 * Delete group.
                 *
                 * @return Result
                 */

                public Result deleteGroup() {
                    return client.delete("/access/groups/" + this.groupid, null);
                }

                /**
                 * Get group configuration.
                 *
                 * @return Result
                 */

                public Result readGroup() {
                    return client.get("/access/groups/" + this.groupid, null);
                }

                /**
                 * Update group data.
                 *
                 * @param comment
                 * @return Result
                 */

                public Result updateGroup(String comment) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("comment", comment);
                    return client.set("/access/groups/" + this.groupid, parameters);
                }

                /**
                 * Update group data.
                 *
                 * @return Result
                 */

                public Result updateGroup() {
                    return client.set("/access/groups/" + this.groupid, null);
                }

            }

            /**
             * Group index.
             *
             * @return Result
             */

            public Result index() {
                return client.get("/access/groups", null);
            }

            /**
             * Create new group.
             *
             * @param groupid
             * @param comment
             * @return Result
             */

            public Result createGroup(String groupid, String comment) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("groupid", groupid);
                parameters.put("comment", comment);
                return client.create("/access/groups", parameters);
            }

            /**
             * Create new group.
             *
             * @param groupid
             * @return Result
             */

            public Result createGroup(String groupid) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("groupid", groupid);
                return client.create("/access/groups", parameters);
            }

        }

        public static class PVERoles {
            private final PveClient client;

            protected PVERoles(PveClient client) {
                this.client = client;

            }

            public PVERoleidItem get(Object roleid) {
                return new PVERoleidItem(client, roleid);
            }

            public static class PVERoleidItem {
                private final PveClient client;
                private final Object roleid;

                protected PVERoleidItem(PveClient client, Object roleid) {
                    this.client = client;
                    this.roleid = roleid;
                }

                /**
                 * Delete role.
                 *
                 * @return Result
                 */

                public Result deleteRole() {
                    return client.delete("/access/roles/" + this.roleid, null);
                }

                /**
                 * Get role configuration.
                 *
                 * @return Result
                 */

                public Result readRole() {
                    return client.get("/access/roles/" + this.roleid, null);
                }

                /**
                 * Update an existing role.
                 *
                 * @param append
                 * @param privs
                 * @return Result
                 */

                public Result updateRole(Boolean append, String privs) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("append", append);
                    parameters.put("privs", privs);
                    return client.set("/access/roles/" + this.roleid, parameters);
                }

                /**
                 * Update an existing role.
                 *
                 * @return Result
                 */

                public Result updateRole() {
                    return client.set("/access/roles/" + this.roleid, null);
                }

            }

            /**
             * Role index.
             *
             * @return Result
             */

            public Result index() {
                return client.get("/access/roles", null);
            }

            /**
             * Create new role.
             *
             * @param roleid
             * @param privs
             * @return Result
             */

            public Result createRole(String roleid, String privs) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("roleid", roleid);
                parameters.put("privs", privs);
                return client.create("/access/roles", parameters);
            }

            /**
             * Create new role.
             *
             * @param roleid
             * @return Result
             */

            public Result createRole(String roleid) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("roleid", roleid);
                return client.create("/access/roles", parameters);
            }

        }

        public static class PVEAcl {
            private final PveClient client;

            protected PVEAcl(PveClient client) {
                this.client = client;

            }

            /**
             * Get Access Control List (ACLs).
             *
             * @return Result
             */

            public Result readAcl() {
                return client.get("/access/acl", null);
            }

            /**
             * Update Access Control List (add or remove permissions).
             *
             * @param path      Access control path
             * @param roles     List of roles.
             * @param delete    Remove permissions (instead of adding it).
             * @param groups    List of groups.
             * @param propagate Allow to propagate (inherit) permissions.
             * @param tokens    List of API tokens.
             * @param users     List of users.
             * @return Result
             */

            public Result updateAcl(String path, String roles, Boolean delete, String groups, Boolean propagate,
                    String tokens, String users) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("path", path);
                parameters.put("roles", roles);
                parameters.put("delete", delete);
                parameters.put("groups", groups);
                parameters.put("propagate", propagate);
                parameters.put("tokens", tokens);
                parameters.put("users", users);
                return client.set("/access/acl", parameters);
            }

            /**
             * Update Access Control List (add or remove permissions).
             *
             * @param path  Access control path
             * @param roles List of roles.
             * @return Result
             */

            public Result updateAcl(String path, String roles) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("path", path);
                parameters.put("roles", roles);
                return client.set("/access/acl", parameters);
            }

        }

        public static class PVEDomains {
            private final PveClient client;

            protected PVEDomains(PveClient client) {
                this.client = client;

            }

            public PVERealmItem get(Object realm) {
                return new PVERealmItem(client, realm);
            }

            public static class PVERealmItem {
                private final PveClient client;
                private final Object realm;

                protected PVERealmItem(PveClient client, Object realm) {
                    this.client = client;
                    this.realm = realm;
                }

                private PVESync sync;

                public PVESync getSync() {
                    return sync == null ? (sync = new PVESync(client, this.realm)) : sync;
                }

                public static class PVESync {
                    private final PveClient client;
                    private final Object realm;

                    protected PVESync(PveClient client, Object realm) {
                        this.client = client;
                        this.realm = realm;
                    }

                    /**
                     * Syncs users and/or groups from the configured LDAP to user.cfg. NOTE: Synced
                     * groups will have the name 'name-$realm', so make sure those groups do not
                     * exist to prevent overwriting.
                     *
                     * @param dry_run         If set, does not write anything.
                     * @param enable_new      Enable newly synced users immediately.
                     * @param full            DEPRECATED: use 'remove-vanished' instead. If set,
                     *                        uses the LDAP Directory as source of truth, deleting
                     *                        users or groups not returned from the sync and
                     *                        removing all locally modified properties of synced
                     *                        users. If not set, only syncs information which is
                     *                        present in the synced data, and does not delete or
                     *                        modify anything else.
                     * @param purge           DEPRECATED: use 'remove-vanished' instead. Remove ACLs
                     *                        for users or groups which were removed from the config
                     *                        during a sync.
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

                    public Result sync(Boolean dry_run, Boolean enable_new, Boolean full, Boolean purge,
                            String remove_vanished, String scope) {
                        Map<String, Object> parameters = new HashMap<>();
                        parameters.put("dry-run", dry_run);
                        parameters.put("enable-new", enable_new);
                        parameters.put("full", full);
                        parameters.put("purge", purge);
                        parameters.put("remove-vanished", remove_vanished);
                        parameters.put("scope", scope);
                        return client.create("/access/domains/" + this.realm + "/sync", parameters);
                    }

                    /**
                     * Syncs users and/or groups from the configured LDAP to user.cfg. NOTE: Synced
                     * groups will have the name 'name-$realm', so make sure those groups do not
                     * exist to prevent overwriting.
                     *
                     * @return Result
                     */

                    public Result sync() {
                        return client.create("/access/domains/" + this.realm + "/sync", null);
                    }

                }

                /**
                 * Delete an authentication server.
                 *
                 * @return Result
                 */

                public Result delete() {
                    return client.delete("/access/domains/" + this.realm, null);
                }

                /**
                 * Get auth server configuration.
                 *
                 * @return Result
                 */

                public Result read() {
                    return client.get("/access/domains/" + this.realm, null);
                }

                /**
                 * Update authentication server settings.
                 *
                 * @param acr_values            Specifies the Authentication Context Class
                 *                              Reference values that theAuthorization Server is
                 *                              being requested to use for the Auth Request.
                 * @param autocreate            Automatically create users if they do not exist.
                 * @param base_dn               LDAP base domain name
                 * @param bind_dn               LDAP bind domain name
                 * @param capath                Path to the CA certificate store
                 * @param case_sensitive        username is case-sensitive
                 * @param cert                  Path to the client certificate
                 * @param certkey               Path to the client certificate key
                 * @param check_connection      Check bind connection to the server.
                 * @param client_id             OpenID Client ID
                 * @param client_key            OpenID Client Key
                 * @param comment               Description.
                 * @param default_              Use this as default realm
                 * @param delete                A list of settings you want to delete.
                 * @param digest                Prevent changes if current configuration file
                 *                              has a different digest. This can be used to
                 *                              prevent concurrent modifications.
                 * @param domain                AD domain name
                 * @param filter                LDAP filter for user sync.
                 * @param group_classes         The objectclasses for groups.
                 * @param group_dn              LDAP base domain name for group sync. If not
                 *                              set, the base_dn will be used.
                 * @param group_filter          LDAP filter for group sync.
                 * @param group_name_attr       LDAP attribute representing a groups name. If
                 *                              not set or found, the first value of the DN will
                 *                              be used as name.
                 * @param groups_autocreate     Automatically create groups if they do not
                 *                              exist.
                 * @param groups_claim          OpenID claim used to retrieve groups with.
                 * @param groups_overwrite      All groups will be overwritten for the user on
                 *                              login.
                 * @param issuer_url            OpenID Issuer Url
                 * @param mode                  LDAP protocol mode.
                 *                              Enum: ldap,ldaps,ldap+starttls
                 * @param password              LDAP bind password. Will be stored in
                 *                              '/etc/pve/priv/realm/&amp;lt;REALM&amp;gt;.pw'.
                 * @param port                  Server port.
                 * @param prompt                Specifies whether the Authorization Server
                 *                              prompts the End-User for reauthentication and
                 *                              consent.
                 * @param query_userinfo        Enables querying the userinfo endpoint for
                 *                              claims values.
                 * @param scopes                Specifies the scopes (user details) that should
                 *                              be authorized and returned, for example 'email'
                 *                              or 'profile'.
                 * @param secure                Use secure LDAPS protocol. DEPRECATED: use
                 *                              'mode' instead.
                 * @param server1               Server IP address (or DNS name)
                 * @param server2               Fallback Server IP address (or DNS name)
                 * @param sslversion            LDAPS TLS/SSL version. It's not recommended to
                 *                              use version older than 1.2!
                 *                              Enum: tlsv1,tlsv1_1,tlsv1_2,tlsv1_3
                 * @param sync_defaults_options The default options for behavior of
                 *                              synchronizations.
                 * @param sync_attributes       Comma separated list of key=value pairs for
                 *                              specifying which LDAP attributes map to which
                 *                              PVE user field. For example, to map the LDAP
                 *                              attribute 'mail' to PVEs 'email', write
                 *                              'email=mail'. By default, each PVE user field is
                 *                              represented by an LDAP attribute of the same
                 *                              name.
                 * @param tfa                   Use Two-factor authentication.
                 * @param user_attr             LDAP user attribute name
                 * @param user_classes          The objectclasses for users.
                 * @param verify                Verify the server's SSL certificate
                 * @return Result
                 */

                public Result update(String acr_values, Boolean autocreate, String base_dn, String bind_dn,
                        String capath, Boolean case_sensitive, String cert, String certkey, Boolean check_connection,
                        String client_id, String client_key, String comment, Boolean default_, String delete,
                        String digest, String domain, String filter, String group_classes, String group_dn,
                        String group_filter, String group_name_attr, Boolean groups_autocreate, String groups_claim,
                        Boolean groups_overwrite, String issuer_url, String mode, String password, Integer port,
                        String prompt, Boolean query_userinfo, String scopes, Boolean secure, String server1,
                        String server2, String sslversion, String sync_defaults_options, String sync_attributes,
                        String tfa, String user_attr, String user_classes, Boolean verify) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("acr-values", acr_values);
                    parameters.put("autocreate", autocreate);
                    parameters.put("base_dn", base_dn);
                    parameters.put("bind_dn", bind_dn);
                    parameters.put("capath", capath);
                    parameters.put("case-sensitive", case_sensitive);
                    parameters.put("cert", cert);
                    parameters.put("certkey", certkey);
                    parameters.put("check-connection", check_connection);
                    parameters.put("client-id", client_id);
                    parameters.put("client-key", client_key);
                    parameters.put("comment", comment);
                    parameters.put("default", default_);
                    parameters.put("delete", delete);
                    parameters.put("digest", digest);
                    parameters.put("domain", domain);
                    parameters.put("filter", filter);
                    parameters.put("group_classes", group_classes);
                    parameters.put("group_dn", group_dn);
                    parameters.put("group_filter", group_filter);
                    parameters.put("group_name_attr", group_name_attr);
                    parameters.put("groups-autocreate", groups_autocreate);
                    parameters.put("groups-claim", groups_claim);
                    parameters.put("groups-overwrite", groups_overwrite);
                    parameters.put("issuer-url", issuer_url);
                    parameters.put("mode", mode);
                    parameters.put("password", password);
                    parameters.put("port", port);
                    parameters.put("prompt", prompt);
                    parameters.put("query-userinfo", query_userinfo);
                    parameters.put("scopes", scopes);
                    parameters.put("secure", secure);
                    parameters.put("server1", server1);
                    parameters.put("server2", server2);
                    parameters.put("sslversion", sslversion);
                    parameters.put("sync-defaults-options", sync_defaults_options);
                    parameters.put("sync_attributes", sync_attributes);
                    parameters.put("tfa", tfa);
                    parameters.put("user_attr", user_attr);
                    parameters.put("user_classes", user_classes);
                    parameters.put("verify", verify);
                    return client.set("/access/domains/" + this.realm, parameters);
                }

                /**
                 * Update authentication server settings.
                 *
                 * @return Result
                 */

                public Result update() {
                    return client.set("/access/domains/" + this.realm, null);
                }

            }

            /**
             * Authentication domain index.
             *
             * @return Result
             */

            public Result index() {
                return client.get("/access/domains", null);
            }

            /**
             * Add an authentication server.
             *
             * @param realm                 Authentication domain ID
             * @param type                  Realm type.
             *                              Enum: ad,ldap,openid,pam,pve
             * @param acr_values            Specifies the Authentication Context Class
             *                              Reference values that theAuthorization Server is
             *                              being requested to use for the Auth Request.
             * @param autocreate            Automatically create users if they do not exist.
             * @param base_dn               LDAP base domain name
             * @param bind_dn               LDAP bind domain name
             * @param capath                Path to the CA certificate store
             * @param case_sensitive        username is case-sensitive
             * @param cert                  Path to the client certificate
             * @param certkey               Path to the client certificate key
             * @param check_connection      Check bind connection to the server.
             * @param client_id             OpenID Client ID
             * @param client_key            OpenID Client Key
             * @param comment               Description.
             * @param default_              Use this as default realm
             * @param domain                AD domain name
             * @param filter                LDAP filter for user sync.
             * @param group_classes         The objectclasses for groups.
             * @param group_dn              LDAP base domain name for group sync. If not
             *                              set, the base_dn will be used.
             * @param group_filter          LDAP filter for group sync.
             * @param group_name_attr       LDAP attribute representing a groups name. If
             *                              not set or found, the first value of the DN will
             *                              be used as name.
             * @param groups_autocreate     Automatically create groups if they do not
             *                              exist.
             * @param groups_claim          OpenID claim used to retrieve groups with.
             * @param groups_overwrite      All groups will be overwritten for the user on
             *                              login.
             * @param issuer_url            OpenID Issuer Url
             * @param mode                  LDAP protocol mode.
             *                              Enum: ldap,ldaps,ldap+starttls
             * @param password              LDAP bind password. Will be stored in
             *                              '/etc/pve/priv/realm/&amp;lt;REALM&amp;gt;.pw'.
             * @param port                  Server port.
             * @param prompt                Specifies whether the Authorization Server
             *                              prompts the End-User for reauthentication and
             *                              consent.
             * @param query_userinfo        Enables querying the userinfo endpoint for
             *                              claims values.
             * @param scopes                Specifies the scopes (user details) that should
             *                              be authorized and returned, for example 'email'
             *                              or 'profile'.
             * @param secure                Use secure LDAPS protocol. DEPRECATED: use
             *                              'mode' instead.
             * @param server1               Server IP address (or DNS name)
             * @param server2               Fallback Server IP address (or DNS name)
             * @param sslversion            LDAPS TLS/SSL version. It's not recommended to
             *                              use version older than 1.2!
             *                              Enum: tlsv1,tlsv1_1,tlsv1_2,tlsv1_3
             * @param sync_defaults_options The default options for behavior of
             *                              synchronizations.
             * @param sync_attributes       Comma separated list of key=value pairs for
             *                              specifying which LDAP attributes map to which
             *                              PVE user field. For example, to map the LDAP
             *                              attribute 'mail' to PVEs 'email', write
             *                              'email=mail'. By default, each PVE user field is
             *                              represented by an LDAP attribute of the same
             *                              name.
             * @param tfa                   Use Two-factor authentication.
             * @param user_attr             LDAP user attribute name
             * @param user_classes          The objectclasses for users.
             * @param username_claim        OpenID claim used to generate the unique
             *                              username.
             * @param verify                Verify the server's SSL certificate
             * @return Result
             */

            public Result create(String realm, String type, String acr_values, Boolean autocreate, String base_dn,
                    String bind_dn, String capath, Boolean case_sensitive, String cert, String certkey,
                    Boolean check_connection, String client_id, String client_key, String comment, Boolean default_,
                    String domain, String filter, String group_classes, String group_dn, String group_filter,
                    String group_name_attr, Boolean groups_autocreate, String groups_claim, Boolean groups_overwrite,
                    String issuer_url, String mode, String password, Integer port, String prompt,
                    Boolean query_userinfo, String scopes, Boolean secure, String server1, String server2,
                    String sslversion, String sync_defaults_options, String sync_attributes, String tfa,
                    String user_attr, String user_classes, String username_claim, Boolean verify) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("realm", realm);
                parameters.put("type", type);
                parameters.put("acr-values", acr_values);
                parameters.put("autocreate", autocreate);
                parameters.put("base_dn", base_dn);
                parameters.put("bind_dn", bind_dn);
                parameters.put("capath", capath);
                parameters.put("case-sensitive", case_sensitive);
                parameters.put("cert", cert);
                parameters.put("certkey", certkey);
                parameters.put("check-connection", check_connection);
                parameters.put("client-id", client_id);
                parameters.put("client-key", client_key);
                parameters.put("comment", comment);
                parameters.put("default", default_);
                parameters.put("domain", domain);
                parameters.put("filter", filter);
                parameters.put("group_classes", group_classes);
                parameters.put("group_dn", group_dn);
                parameters.put("group_filter", group_filter);
                parameters.put("group_name_attr", group_name_attr);
                parameters.put("groups-autocreate", groups_autocreate);
                parameters.put("groups-claim", groups_claim);
                parameters.put("groups-overwrite", groups_overwrite);
                parameters.put("issuer-url", issuer_url);
                parameters.put("mode", mode);
                parameters.put("password", password);
                parameters.put("port", port);
                parameters.put("prompt", prompt);
                parameters.put("query-userinfo", query_userinfo);
                parameters.put("scopes", scopes);
                parameters.put("secure", secure);
                parameters.put("server1", server1);
                parameters.put("server2", server2);
                parameters.put("sslversion", sslversion);
                parameters.put("sync-defaults-options", sync_defaults_options);
                parameters.put("sync_attributes", sync_attributes);
                parameters.put("tfa", tfa);
                parameters.put("user_attr", user_attr);
                parameters.put("user_classes", user_classes);
                parameters.put("username-claim", username_claim);
                parameters.put("verify", verify);
                return client.create("/access/domains", parameters);
            }

            /**
             * Add an authentication server.
             *
             * @param realm Authentication domain ID
             * @param type  Realm type.
             *              Enum: ad,ldap,openid,pam,pve
             * @return Result
             */

            public Result create(String realm, String type) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("realm", realm);
                parameters.put("type", type);
                return client.create("/access/domains", parameters);
            }

        }

        public static class PVEOpenid {
            private final PveClient client;

            protected PVEOpenid(PveClient client) {
                this.client = client;

            }

            private PVEAuthUrl authUrl;

            public PVEAuthUrl getAuthUrl() {
                return authUrl == null ? (authUrl = new PVEAuthUrl(client)) : authUrl;
            }

            private PVELogin login;

            public PVELogin getLogin() {
                return login == null ? (login = new PVELogin(client)) : login;
            }

            public static class PVEAuthUrl {
                private final PveClient client;

                protected PVEAuthUrl(PveClient client) {
                    this.client = client;

                }

                /**
                 * Get the OpenId Authorization Url for the specified realm.
                 *
                 * @param realm        Authentication domain ID
                 * @param redirect_url Redirection Url. The client should set this to the used
                 *                     server url (location.origin).
                 * @return Result
                 */

                public Result authUrl(String realm, String redirect_url) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("realm", realm);
                    parameters.put("redirect-url", redirect_url);
                    return client.create("/access/openid/auth-url", parameters);
                }

            }

            public static class PVELogin {
                private final PveClient client;

                protected PVELogin(PveClient client) {
                    this.client = client;

                }

                /**
                 * Verify OpenID authorization code and create a ticket.
                 *
                 * @param code         OpenId authorization code.
                 * @param redirect_url Redirection Url. The client should set this to the used
                 *                     server url (location.origin).
                 * @param state        OpenId state.
                 * @return Result
                 */

                public Result login(String code, String redirect_url, String state) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("code", code);
                    parameters.put("redirect-url", redirect_url);
                    parameters.put("state", state);
                    return client.create("/access/openid/login", parameters);
                }

            }

            /**
             * Directory index.
             *
             * @return Result
             */

            public Result index() {
                return client.get("/access/openid", null);
            }

        }

        public static class PVETfa {
            private final PveClient client;

            protected PVETfa(PveClient client) {
                this.client = client;

            }

            public PVEUseridItem get(Object userid) {
                return new PVEUseridItem(client, userid);
            }

            public static class PVEUseridItem {
                private final PveClient client;
                private final Object userid;

                protected PVEUseridItem(PveClient client, Object userid) {
                    this.client = client;
                    this.userid = userid;
                }

                public PVEIdItem get(Object id) {
                    return new PVEIdItem(client, this.userid, id);
                }

                public static class PVEIdItem {
                    private final PveClient client;
                    private final Object userid;
                    private final Object id;

                    protected PVEIdItem(PveClient client, Object userid, Object id) {
                        this.client = client;
                        this.userid = userid;
                        this.id = id;
                    }

                    /**
                     * Delete a TFA entry by ID.
                     *
                     * @param password The current password of the user performing the change.
                     * @return Result
                     */

                    public Result deleteTfa(String password) {
                        Map<String, Object> parameters = new HashMap<>();
                        parameters.put("password", password);
                        return client.delete("/access/tfa/" + this.userid + "/" + this.id, parameters);
                    }

                    /**
                     * Delete a TFA entry by ID.
                     *
                     * @return Result
                     */

                    public Result deleteTfa() {
                        return client.delete("/access/tfa/" + this.userid + "/" + this.id, null);
                    }

                    /**
                     * Fetch a requested TFA entry if present.
                     *
                     * @return Result
                     */

                    public Result getTfaEntry() {
                        return client.get("/access/tfa/" + this.userid + "/" + this.id, null);
                    }

                    /**
                     * Add a TFA entry for a user.
                     *
                     * @param description A description to distinguish multiple entries from one
                     *                    another
                     * @param enable      Whether the entry should be enabled for login.
                     * @param password    The current password of the user performing the change.
                     * @return Result
                     */

                    public Result updateTfaEntry(String description, Boolean enable, String password) {
                        Map<String, Object> parameters = new HashMap<>();
                        parameters.put("description", description);
                        parameters.put("enable", enable);
                        parameters.put("password", password);
                        return client.set("/access/tfa/" + this.userid + "/" + this.id, parameters);
                    }

                    /**
                     * Add a TFA entry for a user.
                     *
                     * @return Result
                     */

                    public Result updateTfaEntry() {
                        return client.set("/access/tfa/" + this.userid + "/" + this.id, null);
                    }

                }

                /**
                 * List TFA configurations of users.
                 *
                 * @return Result
                 */

                public Result listUserTfa() {
                    return client.get("/access/tfa/" + this.userid, null);
                }

                /**
                 * Add a TFA entry for a user.
                 *
                 * @param type        TFA Entry Type.
                 *                    Enum: totp,u2f,webauthn,recovery,yubico
                 * @param challenge   When responding to an u2f challenge: the original challenge
                 *                    string
                 * @param description A description to distinguish multiple entries from one
                 *                    another
                 * @param password    The current password of the user performing the change.
                 * @param totp        A totp URI.
                 * @param value       The current value for the provided totp URI, or a
                 *                    Webauthn/U2F challenge response
                 * @return Result
                 */

                public Result addTfaEntry(String type, String challenge, String description, String password,
                        String totp, String value) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("type", type);
                    parameters.put("challenge", challenge);
                    parameters.put("description", description);
                    parameters.put("password", password);
                    parameters.put("totp", totp);
                    parameters.put("value", value);
                    return client.create("/access/tfa/" + this.userid, parameters);
                }

                /**
                 * Add a TFA entry for a user.
                 *
                 * @param type TFA Entry Type.
                 *             Enum: totp,u2f,webauthn,recovery,yubico
                 * @return Result
                 */

                public Result addTfaEntry(String type) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("type", type);
                    return client.create("/access/tfa/" + this.userid, parameters);
                }

            }

            /**
             * List TFA configurations of users.
             *
             * @return Result
             */

            public Result listTfa() {
                return client.get("/access/tfa", null);
            }

        }

        public static class PVETicket {
            private final PveClient client;

            protected PVETicket(PveClient client) {
                this.client = client;

            }

            /**
             * Dummy. Useful for formatters which want to provide a login page.
             *
             * @return Result
             */

            public Result getTicket() {
                return client.get("/access/ticket", null);
            }

            /**
             * Create or verify authentication ticket.
             *
             * @param password      The secret password. This can also be a valid ticket.
             * @param username      Username
             * @param new_format    This parameter is now ignored and assumed to be 1.
             * @param otp           One-time password for Two-factor authentication.
             * @param path          Verify ticket, and check if user have access 'privs' on
             *                      'path'
             * @param privs         Verify ticket, and check if user have access 'privs' on
             *                      'path'
             * @param realm         You can optionally pass the realm using this parameter.
             *                      Normally the realm is simply added to the username
             *                      &amp;lt;username&amp;gt;@&amp;lt;realm&amp;gt;.
             * @param tfa_challenge The signed TFA challenge string the user wants to
             *                      respond to.
             * @return Result
             */

            public Result createTicket(String password, String username, Boolean new_format, String otp, String path,
                    String privs, String realm, String tfa_challenge) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("password", password);
                parameters.put("username", username);
                parameters.put("new-format", new_format);
                parameters.put("otp", otp);
                parameters.put("path", path);
                parameters.put("privs", privs);
                parameters.put("realm", realm);
                parameters.put("tfa-challenge", tfa_challenge);
                return client.create("/access/ticket", parameters);
            }

            /**
             * Create or verify authentication ticket.
             *
             * @param password The secret password. This can also be a valid ticket.
             * @param username Username
             * @return Result
             */

            public Result createTicket(String password, String username) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("password", password);
                parameters.put("username", username);
                return client.create("/access/ticket", parameters);
            }

        }

        public static class PVEVncticket {
            private final PveClient client;

            protected PVEVncticket(PveClient client) {
                this.client = client;

            }

            /**
             * verify VNC authentication ticket.
             *
             * @param authid    UserId or token
             * @param path      Verify ticket, and check if user have access 'privs' on
             *                  'path'
             * @param privs     Verify ticket, and check if user have access 'privs' on
             *                  'path'
             * @param vncticket The VNC ticket.
             * @return Result
             */

            public Result verifyVncTicket(String authid, String path, String privs, String vncticket) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("authid", authid);
                parameters.put("path", path);
                parameters.put("privs", privs);
                parameters.put("vncticket", vncticket);
                return client.create("/access/vncticket", parameters);
            }

        }

        public static class PVEPassword {
            private final PveClient client;

            protected PVEPassword(PveClient client) {
                this.client = client;

            }

            /**
             * Change user password.
             *
             * @param password              The new password.
             * @param userid                Full User ID, in the `name@realm` format.
             * @param confirmation_password The current password of the user performing the
             *                              change.
             * @return Result
             */

            public Result changePassword(String password, String userid, String confirmation_password) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("password", password);
                parameters.put("userid", userid);
                parameters.put("confirmation-password", confirmation_password);
                return client.set("/access/password", parameters);
            }

            /**
             * Change user password.
             *
             * @param password The new password.
             * @param userid   Full User ID, in the `name@realm` format.
             * @return Result
             */

            public Result changePassword(String password, String userid) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("password", password);
                parameters.put("userid", userid);
                return client.set("/access/password", parameters);
            }

        }

        public static class PVEPermissions {
            private final PveClient client;

            protected PVEPermissions(PveClient client) {
                this.client = client;

            }

            /**
             * Retrieve effective permissions of given user/token.
             *
             * @param path   Only dump this specific path, not the whole tree.
             * @param userid User ID or full API token ID
             * @return Result
             */

            public Result permissions(String path, String userid) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("path", path);
                parameters.put("userid", userid);
                return client.get("/access/permissions", parameters);
            }

            /**
             * Retrieve effective permissions of given user/token.
             *
             * @return Result
             */

            public Result permissions() {
                return client.get("/access/permissions", null);
            }

        }

        /**
         * Directory index.
         *
         * @return Result
         */

        public Result index() {
            return client.get("/access", null);
        }

    }

    public static class PVEPools {
        private final PveClient client;

        protected PVEPools(PveClient client) {
            this.client = client;

        }

        public PVEPoolidItem get(Object poolid) {
            return new PVEPoolidItem(client, poolid);
        }

        public static class PVEPoolidItem {
            private final PveClient client;
            private final Object poolid;

            protected PVEPoolidItem(PveClient client, Object poolid) {
                this.client = client;
                this.poolid = poolid;
            }

            /**
             * Delete pool (deprecated, no support for nested pools, use 'DELETE
             * /pools/?poolid={poolid}').
             *
             * @return Result
             */

            public Result deletePoolDeprecated() {
                return client.delete("/pools/" + this.poolid, null);
            }

            /**
             * Get pool configuration (deprecated, no support for nested pools, use 'GET
             * /pools/?poolid={poolid}').
             *
             * @param type
             *             Enum: qemu,lxc,storage
             * @return Result
             */

            public Result readPool(String type) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("type", type);
                return client.get("/pools/" + this.poolid, parameters);
            }

            /**
             * Get pool configuration (deprecated, no support for nested pools, use 'GET
             * /pools/?poolid={poolid}').
             *
             * @return Result
             */

            public Result readPool() {
                return client.get("/pools/" + this.poolid, null);
            }

            /**
             * Update pool data (deprecated, no support for nested pools - use 'PUT
             * /pools/?poolid={poolid}' instead).
             *
             * @param allow_move Allow adding a guest even if already in another pool. The
             *                   guest will be removed from its current pool and added to
             *                   this one.
             * @param comment
             * @param delete     Remove the passed VMIDs and/or storage IDs instead of
             *                   adding them.
             * @param storage    List of storage IDs to add or remove from this pool.
             * @param vms        List of guest VMIDs to add or remove from this pool.
             * @return Result
             */

            public Result updatePoolDeprecated(Boolean allow_move, String comment, Boolean delete, String storage,
                    String vms) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("allow-move", allow_move);
                parameters.put("comment", comment);
                parameters.put("delete", delete);
                parameters.put("storage", storage);
                parameters.put("vms", vms);
                return client.set("/pools/" + this.poolid, parameters);
            }

            /**
             * Update pool data (deprecated, no support for nested pools - use 'PUT
             * /pools/?poolid={poolid}' instead).
             *
             * @return Result
             */

            public Result updatePoolDeprecated() {
                return client.set("/pools/" + this.poolid, null);
            }

        }

        /**
         * Delete pool.
         *
         * @param poolid
         * @return Result
         */

        public Result deletePool(String poolid) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("poolid", poolid);
            return client.delete("/pools", parameters);
        }

        /**
         * List pools or get pool configuration.
         *
         * @param poolid
         * @param type
         *               Enum: qemu,lxc,storage
         * @return Result
         */

        public Result index(String poolid, String type) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("poolid", poolid);
            parameters.put("type", type);
            return client.get("/pools", parameters);
        }

        /**
         * List pools or get pool configuration.
         *
         * @return Result
         */

        public Result index() {
            return client.get("/pools", null);
        }

        /**
         * Create new pool.
         *
         * @param poolid
         * @param comment
         * @return Result
         */

        public Result createPool(String poolid, String comment) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("poolid", poolid);
            parameters.put("comment", comment);
            return client.create("/pools", parameters);
        }

        /**
         * Create new pool.
         *
         * @param poolid
         * @return Result
         */

        public Result createPool(String poolid) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("poolid", poolid);
            return client.create("/pools", parameters);
        }

        /**
         * Update pool.
         *
         * @param poolid
         * @param allow_move Allow adding a guest even if already in another pool. The
         *                   guest will be removed from its current pool and added to
         *                   this one.
         * @param comment
         * @param delete     Remove the passed VMIDs and/or storage IDs instead of
         *                   adding them.
         * @param storage    List of storage IDs to add or remove from this pool.
         * @param vms        List of guest VMIDs to add or remove from this pool.
         * @return Result
         */

        public Result updatePool(String poolid, Boolean allow_move, String comment, Boolean delete, String storage,
                String vms) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("poolid", poolid);
            parameters.put("allow-move", allow_move);
            parameters.put("comment", comment);
            parameters.put("delete", delete);
            parameters.put("storage", storage);
            parameters.put("vms", vms);
            return client.set("/pools", parameters);
        }

        /**
         * Update pool.
         *
         * @param poolid
         * @return Result
         */

        public Result updatePool(String poolid) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("poolid", poolid);
            return client.set("/pools", parameters);
        }

    }

    public static class PVEVersion {
        private final PveClient client;

        protected PVEVersion(PveClient client) {
            this.client = client;

        }

        /**
         * API version details, including some parts of the global datacenter config.
         *
         * @return Result
         */

        public Result version() {
            return client.get("/version", null);
        }

    }

}

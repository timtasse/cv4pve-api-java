package it.corsinvest.proxmoxve.api.nodes;

import it.corsinvest.proxmoxve.api.PveClient;
import it.corsinvest.proxmoxve.api.Result;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class PVEStorage {

    private final PveClient client;
    private final Object node;

    public PVEStorage(PveClient client, Object node) {
        this.client = client;
        this.node = node;
    }

    public PVEStorageItem get(Object storage) {
        return new PVEStorageItem(client, this.node, storage);
    }

    public static class PVEStorageItem {

        private final PveClient client;
        private final Object node;
        private final Object storage;

        protected PVEStorageItem(PveClient client, Object node, Object storage) {
            this.client = client;
            this.node = node;
            this.storage = storage;
        }

        private PVEStorageItem.PVEPrunebackups prunebackups;

        public PVEStorageItem.PVEPrunebackups getPrunebackups() {
            return prunebackups == null
                    ? (prunebackups = new PVEPrunebackups(client, this.node, this.storage))
                    : prunebackups;
        }

        private PVEStorageItem.PVEContent content;

        public PVEStorageItem.PVEContent getContent() {
            return content == null ? (content = new PVEContent(client, this.node, this.storage)) : content;
        }

        private PVEStorageItem.PVEFileRestore fileRestore;

        public PVEStorageItem.PVEFileRestore getFileRestore() {
            return fileRestore == null ? (fileRestore = new PVEFileRestore(client, this.node, this.storage))
                    : fileRestore;
        }

        private PVEStorageItem.PVEStatus status;

        public PVEStorageItem.PVEStatus getStatus() {
            return status == null ? (status = new PVEStatus(client, this.node, this.storage)) : status;
        }

        private PVEStorageItem.PVERrd rrd;

        public PVEStorageItem.PVERrd getRrd() {
            return rrd == null ? (rrd = new PVERrd(client, this.node, this.storage)) : rrd;
        }

        private PVEStorageItem.PVERrddata rrddata;

        public PVEStorageItem.PVERrddata getRrddata() {
            return rrddata == null ? (rrddata = new PVERrddata(client, this.node, this.storage)) : rrddata;
        }

        private PVEStorageItem.PVEUpload upload;

        public PVEStorageItem.PVEUpload getUpload() {
            return upload == null ? (upload = new PVEUpload(client, this.node, this.storage)) : upload;
        }

        private PVEStorageItem.PVEDownloadUrl downloadUrl;

        public PVEStorageItem.PVEDownloadUrl getDownloadUrl() {
            return downloadUrl == null ? (downloadUrl = new PVEDownloadUrl(client, this.node, this.storage))
                    : downloadUrl;
        }

        private PVEStorageItem.PVEOciRegistryPull ociRegistryPull;

        public PVEStorageItem.PVEOciRegistryPull getOciRegistryPull() {
            return ociRegistryPull == null
                    ? (ociRegistryPull = new PVEOciRegistryPull(client, this.node, this.storage))
                    : ociRegistryPull;
        }

        private PVEStorageItem.PVEImportMetadata importMetadata;

        public PVEStorageItem.PVEImportMetadata getImportMetadata() {
            return importMetadata == null
                    ? (importMetadata = new PVEImportMetadata(client, this.node, this.storage))
                    : importMetadata;
        }

        public static class PVEPrunebackups {

            private final PveClient client;
            private final Object node;
            private final Object storage;

            protected PVEPrunebackups(PveClient client, Object node, Object storage) {
                this.client = client;
                this.node = node;
                this.storage = storage;
            }

            /**
             * Prune backups. Only those using the standard naming scheme are considered.
             *
             * @param prune_backups Use these retention options instead of those from the
             *                      storage configuration.
             * @param type          Either 'qemu' or 'lxc'. Only consider backups for guests
             *                      of this type.
             *                      Enum: qemu,lxc
             * @param vmid          Only prune backups for this VM.
             * @return Result
             */

            public Result delete(String prune_backups, String type, Integer vmid) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("prune-backups", prune_backups);
                parameters.put("type", type);
                parameters.put("vmid", vmid);
                return client.delete("/nodes/" + this.node + "/storage/" + this.storage + "/prunebackups",
                        parameters);
            }

            /**
             * Prune backups. Only those using the standard naming scheme are considered.
             *
             * @return Result
             */

            public Result delete() {
                return client.delete("/nodes/" + this.node + "/storage/" + this.storage + "/prunebackups",
                        null);
            }

            /**
             * Get prune information for backups. NOTE: this is only a preview and might not
             * be what a subsequent prune call does if backups are removed/added in the
             * meantime.
             *
             * @param prune_backups Use these retention options instead of those from the
             *                      storage configuration.
             * @param type          Either 'qemu' or 'lxc'. Only consider backups for guests
             *                      of this type.
             *                      Enum: qemu,lxc
             * @param vmid          Only consider backups for this guest.
             * @return Result
             */

            public Result dryrun(String prune_backups, String type, Integer vmid) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("prune-backups", prune_backups);
                parameters.put("type", type);
                parameters.put("vmid", vmid);
                return client.get("/nodes/" + this.node + "/storage/" + this.storage + "/prunebackups",
                        parameters);
            }

            /**
             * Get prune information for backups. NOTE: this is only a preview and might not
             * be what a subsequent prune call does if backups are removed/added in the
             * meantime.
             *
             * @return Result
             */

            public Result dryrun() {
                return client.get("/nodes/" + this.node + "/storage/" + this.storage + "/prunebackups",
                        null);
            }

        }

        public static class PVEContent {

            private final PveClient client;
            private final Object node;
            private final Object storage;

            protected PVEContent(PveClient client, Object node, Object storage) {
                this.client = client;
                this.node = node;
                this.storage = storage;
            }

            public PVEStorageItem.PVEContent.PVEVolumeItem get(Object volume) {
                return new PVEVolumeItem(client, this.node, this.storage, volume);
            }

            public static class PVEVolumeItem {

                private final PveClient client;
                private final Object node;
                private final Object storage;
                private final Object volume;

                protected PVEVolumeItem(PveClient client, Object node, Object storage, Object volume) {
                    this.client = client;
                    this.node = node;
                    this.storage = storage;
                    this.volume = volume;
                }

                /**
                 * Delete volume
                 *
                 * @param delay Time to wait for the task to finish. We return 'null' if the
                 *              task finish within that time.
                 * @return Result
                 */

                public Result delete(Integer delay) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("delay", delay);
                    return client.delete("/nodes/" + this.node + "/storage/" + this.storage + "/content/"
                            + this.volume, parameters);
                }

                /**
                 * Delete volume
                 *
                 * @return Result
                 */

                public Result delete() {
                    return client.delete("/nodes/" + this.node + "/storage/" + this.storage + "/content/"
                            + this.volume, null);
                }

                /**
                 * Get volume attributes
                 *
                 * @return Result
                 */

                public Result info() {
                    return client.get("/nodes/" + this.node + "/storage/" + this.storage + "/content/"
                            + this.volume, null);
                }

                /**
                 * Copy a volume. This is experimental code - do not use.
                 *
                 * @param target      Target volume identifier
                 * @param target_node Target node. Default is local node.
                 * @return Result
                 */

                public Result copy(String target, String target_node) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("target", target);
                    parameters.put("target_node", target_node);
                    return client.create("/nodes/" + this.node + "/storage/" + this.storage + "/content/"
                            + this.volume, parameters);
                }

                /**
                 * Copy a volume. This is experimental code - do not use.
                 *
                 * @param target Target volume identifier
                 * @return Result
                 */

                public Result copy(String target) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("target", target);
                    return client.create("/nodes/" + this.node + "/storage/" + this.storage + "/content/"
                            + this.volume, parameters);
                }

                /**
                 * Update volume attributes
                 *
                 * @param notes      The new notes.
                 * @param protected_ Protection status. Currently only supported for backups.
                 * @return Result
                 */

                public Result updateattributes(String notes, Boolean protected_) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("notes", notes);
                    parameters.put("protected", protected_);
                    return client.set("/nodes/" + this.node + "/storage/" + this.storage + "/content/"
                            + this.volume, parameters);
                }

                /**
                 * Update volume attributes
                 *
                 * @return Result
                 */

                public Result updateattributes() {
                    return client.set("/nodes/" + this.node + "/storage/" + this.storage + "/content/"
                            + this.volume, null);
                }

            }

            /**
             * List storage content.
             *
             * @param content Only list content of this type.
             * @param vmid    Only list images for this VM
             * @return Result
             */

            public Result index(String content, Integer vmid) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("content", content);
                parameters.put("vmid", vmid);
                return client.get("/nodes/" + this.node + "/storage/" + this.storage + "/content",
                        parameters);
            }

            /**
             * List storage content.
             *
             * @return Result
             */

            public Result index() {
                return client.get("/nodes/" + this.node + "/storage/" + this.storage + "/content", null);
            }

            /**
             * Allocate disk images.
             *
             * @param filename The name of the file to create.
             * @param size     Size in kilobyte (1024 bytes). Optional suffixes 'M'
             *                 (megabyte, 1024K) and 'G' (gigabyte, 1024M)
             * @param vmid     Specify owner VM
             * @param format   Format of the image.
             *                 Enum: raw,qcow2,subvol,vmdk
             * @return Result
             */

            public Result create(String filename, String size, int vmid, String format) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("filename", filename);
                parameters.put("size", size);
                parameters.put("vmid", vmid);
                parameters.put("format", format);
                return client.create("/nodes/" + this.node + "/storage/" + this.storage + "/content",
                        parameters);
            }

            /**
             * Allocate disk images.
             *
             * @param filename The name of the file to create.
             * @param size     Size in kilobyte (1024 bytes). Optional suffixes 'M'
             *                 (megabyte, 1024K) and 'G' (gigabyte, 1024M)
             * @param vmid     Specify owner VM
             * @return Result
             */

            public Result create(String filename, String size, int vmid) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("filename", filename);
                parameters.put("size", size);
                parameters.put("vmid", vmid);
                return client.create("/nodes/" + this.node + "/storage/" + this.storage + "/content",
                        parameters);
            }

        }

        public static class PVEFileRestore {

            private final PveClient client;
            private final Object node;
            private final Object storage;

            protected PVEFileRestore(PveClient client, Object node, Object storage) {
                this.client = client;
                this.node = node;
                this.storage = storage;
            }

            private PVEStorageItem.PVEFileRestore.PVEList list;

            public PVEStorageItem.PVEFileRestore.PVEList getList() {
                return list == null ? (list = new PVEList(client, this.node, this.storage)) : list;
            }

            private PVEStorageItem.PVEFileRestore.PVEDownload download;

            public PVEStorageItem.PVEFileRestore.PVEDownload getDownload() {
                return download == null ? (download = new PVEDownload(client, this.node, this.storage))
                        : download;
            }

            public static class PVEList {

                private final PveClient client;
                private final Object node;
                private final Object storage;

                protected PVEList(PveClient client, Object node, Object storage) {
                    this.client = client;
                    this.node = node;
                    this.storage = storage;
                }

                /**
                 * List files and directories for single file restore under the given path.
                 *
                 * @param filepath base64-path to the directory or file being listed, or "/".
                 * @param volume   Backup volume ID or name. Currently only PBS snapshots are
                 *                 supported.
                 * @return Result
                 */

                public Result list(String filepath, String volume) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("filepath", filepath);
                    parameters.put("volume", volume);
                    return client.get(
                            "/nodes/" + this.node + "/storage/" + this.storage + "/file-restore/list",
                            parameters);
                }

            }

            public static class PVEDownload {

                private final PveClient client;
                private final Object node;
                private final Object storage;

                protected PVEDownload(PveClient client, Object node, Object storage) {
                    this.client = client;
                    this.node = node;
                    this.storage = storage;
                }

                /**
                 * Extract a file or directory (as zip archive) from a PBS backup.
                 *
                 * @param filepath base64-path to the directory or file to download.
                 * @param volume   Backup volume ID or name. Currently only PBS snapshots are
                 *                 supported.
                 * @param tar      Download dirs as 'tar.zst' instead of 'zip'.
                 * @return Result
                 */

                public Result download(String filepath, String volume, Boolean tar) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("filepath", filepath);
                    parameters.put("volume", volume);
                    parameters.put("tar", tar);
                    return client.get(
                            "/nodes/" + this.node + "/storage/" + this.storage + "/file-restore/download",
                            parameters);
                }

                /**
                 * Extract a file or directory (as zip archive) from a PBS backup.
                 *
                 * @param filepath base64-path to the directory or file to download.
                 * @param volume   Backup volume ID or name. Currently only PBS snapshots are
                 *                 supported.
                 * @return Result
                 */

                public Result download(String filepath, String volume) {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("filepath", filepath);
                    parameters.put("volume", volume);
                    return client.get(
                            "/nodes/" + this.node + "/storage/" + this.storage + "/file-restore/download",
                            parameters);
                }

            }

        }

        public static class PVEStatus {

            private final PveClient client;
            private final Object node;
            private final Object storage;

            protected PVEStatus(PveClient client, Object node, Object storage) {
                this.client = client;
                this.node = node;
                this.storage = storage;
            }

            /**
             * Read storage status.
             *
             * @return Result
             */

            public Result readStatus() {
                return client.get("/nodes/" + this.node + "/storage/" + this.storage + "/status", null);
            }

        }

        public static class PVERrd {

            private final PveClient client;
            private final Object node;
            private final Object storage;

            protected PVERrd(PveClient client, Object node, Object storage) {
                this.client = client;
                this.node = node;
                this.storage = storage;
            }

            /**
             * Read storage RRD statistics (returns PNG).
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
                return client.get("/nodes/" + this.node + "/storage/" + this.storage + "/rrd", parameters);
            }

            /**
             * Read storage RRD statistics (returns PNG).
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
                return client.get("/nodes/" + this.node + "/storage/" + this.storage + "/rrd", parameters);
            }

        }

        public static class PVERrddata {

            private final PveClient client;
            private final Object node;
            private final Object storage;

            protected PVERrddata(PveClient client, Object node, Object storage) {
                this.client = client;
                this.node = node;
                this.storage = storage;
            }

            /**
             * Read storage RRD statistics.
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
                return client.get("/nodes/" + this.node + "/storage/" + this.storage + "/rrddata",
                        parameters);
            }

            /**
             * Read storage RRD statistics.
             *
             * @param timeframe Specify the time frame you are interested in.
             *                  Enum: hour,day,week,month,year
             * @return Result
             */

            public Result rrddata(String timeframe) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("timeframe", timeframe);
                return client.get("/nodes/" + this.node + "/storage/" + this.storage + "/rrddata",
                        parameters);
            }

        }

        public static class PVEUpload {

            private final PveClient client;
            private final Object node;
            private final Object storage;

            protected PVEUpload(PveClient client, Object node, Object storage) {
                this.client = client;
                this.node = node;
                this.storage = storage;
            }

            /**
             * Upload templates, ISO images, OVAs and VM images.
             *
             * @param content            Content type.
             *                           Enum: iso,vztmpl,import
             * @param filename           The name of the file to create. Caution: This will
             *                           be normalized!
             * @param checksum           The expected checksum of the file.
             * @param checksum_algorithm The algorithm to calculate the checksum of the
             *                           file.
             *                           Enum: md5,sha1,sha224,sha256,sha384,sha512
             * @param tmpfilename        The source file name. This parameter is usually set
             *                           by the REST handler. You can only overwrite it when
             *                           connecting to the trusted port on localhost.
             * @return Result
             */

            public Result upload(String content, String filename, String checksum,
                                 String checksum_algorithm, String tmpfilename) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("content", content);
                parameters.put("filename", filename);
                parameters.put("checksum", checksum);
                parameters.put("checksum-algorithm", checksum_algorithm);
                parameters.put("tmpfilename", tmpfilename);
                return client.create("/nodes/" + this.node + "/storage/" + this.storage + "/upload",
                        parameters);
            }

            /**
             * Upload templates, ISO images, OVAs and VM images.
             *
             * @param content  Content type.
             *                 Enum: iso,vztmpl,import
             * @param filename The name of the file to create. Caution: This will be
             *                 normalized!
             * @return Result
             */

            public Result upload(String content, String filename) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("content", content);
                parameters.put("filename", filename);
                return client.create("/nodes/" + this.node + "/storage/" + this.storage + "/upload",
                        parameters);
            }

        }

        public static class PVEDownloadUrl {

            private final PveClient client;
            private final Object node;
            private final Object storage;

            protected PVEDownloadUrl(PveClient client, Object node, Object storage) {
                this.client = client;
                this.node = node;
                this.storage = storage;
            }

            /**
             * Download templates, ISO images, OVAs and VM images by using an URL.
             *
             * @param content             Content type.
             *                            Enum: iso,vztmpl,import
             * @param filename            The name of the file to create. Caution: This will
             *                            be normalized!
             * @param url                 The URL to download the file from.
             * @param checksum            The expected checksum of the file.
             * @param checksum_algorithm  The algorithm to calculate the checksum of the
             *                            file.
             *                            Enum: md5,sha1,sha224,sha256,sha384,sha512
             * @param compression         Decompress the downloaded file using the specified
             *                            compression algorithm.
             * @param verify_certificates If false, no SSL/TLS certificates will be
             *                            verified.
             * @return Result
             */

            public Result downloadUrl(String content, String filename, String url, String checksum,
                                      String checksum_algorithm, String compression, Boolean verify_certificates) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("content", content);
                parameters.put("filename", filename);
                parameters.put("url", url);
                parameters.put("checksum", checksum);
                parameters.put("checksum-algorithm", checksum_algorithm);
                parameters.put("compression", compression);
                parameters.put("verify-certificates", verify_certificates);
                return client.create("/nodes/" + this.node + "/storage/" + this.storage + "/download-url",
                        parameters);
            }

            /**
             * Download templates, ISO images, OVAs and VM images by using an URL.
             *
             * @param content  Content type.
             *                 Enum: iso,vztmpl,import
             * @param filename The name of the file to create. Caution: This will be
             *                 normalized!
             * @param url      The URL to download the file from.
             * @return Result
             */

            public Result downloadUrl(String content, String filename, String url) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("content", content);
                parameters.put("filename", filename);
                parameters.put("url", url);
                return client.create("/nodes/" + this.node + "/storage/" + this.storage + "/download-url",
                        parameters);
            }

        }

        public static class PVEOciRegistryPull {

            private final PveClient client;
            private final Object node;
            private final Object storage;

            protected PVEOciRegistryPull(PveClient client, Object node, Object storage) {
                this.client = client;
                this.node = node;
                this.storage = storage;
            }

            /**
             * Pull an OCI image from a registry.
             *
             * @param reference The reference to the OCI image to download.
             * @param filename  Custom destination file name of the OCI image. Caution: This
             *                  will be normalized!
             * @return Result
             */

            public Result ociRegistryPull(String reference, String filename) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("reference", reference);
                parameters.put("filename", filename);
                return client.create(
                        "/nodes/" + this.node + "/storage/" + this.storage + "/oci-registry-pull",
                        parameters);
            }

            /**
             * Pull an OCI image from a registry.
             *
             * @param reference The reference to the OCI image to download.
             * @return Result
             */

            public Result ociRegistryPull(String reference) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("reference", reference);
                return client.create(
                        "/nodes/" + this.node + "/storage/" + this.storage + "/oci-registry-pull",
                        parameters);
            }

        }

        public static class PVEImportMetadata {

            private final PveClient client;
            private final Object node;
            private final Object storage;

            protected PVEImportMetadata(PveClient client, Object node, Object storage) {
                this.client = client;
                this.node = node;
                this.storage = storage;
            }

            /**
             * Get the base parameters for creating a guest which imports data from a
             * foreign importable guest, like an ESXi VM
             *
             * @param volume Volume identifier for the guest archive/entry.
             * @return Result
             */

            public Result getImportMetadata(String volume) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("volume", volume);
                return client.get("/nodes/" + this.node + "/storage/" + this.storage + "/import-metadata",
                        parameters);
            }

        }

        /**
         *
         * @return Result
         */

        public Result diridx() {
            return client.get("/nodes/" + this.node + "/storage/" + this.storage, null);
        }

    }

    /**
     * Get status for all datastores.
     *
     * @param content Only list stores which support this content type.
     * @param enabled Only list stores which are enabled (not disabled in config).
     * @param format  Include information about formats
     * @param storage Only list status for specified storage
     * @param target  If target is different to 'node', we only lists shared
     *                storages which content is accessible on this 'node' and the
     *                specified 'target' node.
     * @return Result
     */

    public Result index(String content, Boolean enabled, Boolean format, String storage, String target) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("content", content);
        parameters.put("enabled", enabled);
        parameters.put("format", format);
        parameters.put("storage", storage);
        parameters.put("target", target);
        return client.get("/nodes/" + this.node + "/storage", parameters);
    }

    /**
     * Get status for all datastores.
     *
     * @return Result
     */

    public Result index() {
        return client.get("/nodes/" + this.node + "/storage", null);
    }

}

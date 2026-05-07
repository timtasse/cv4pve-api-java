package it.corsinvest.proxmoxve.api.nodes;

import it.corsinvest.proxmoxve.api.PveClient;
import it.corsinvest.proxmoxve.api.Result;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class PVEApt {

    private final PveClient client;
    private final Object node;

    public PVEApt(PveClient client, Object node) {
        this.client = client;
        this.node = node;
    }

    private PVEUpdate update;

    public PVEUpdate getUpdate() {
        return update == null ? (update = new PVEUpdate(client, this.node)) : update;
    }

    private PVEChangelog changelog;

    public PVEChangelog getChangelog() {
        return changelog == null ? (changelog = new PVEChangelog(client, this.node)) : changelog;
    }

    private PVERepositories repositories;

    public PVERepositories getRepositories() {
        return repositories == null ? (repositories = new PVERepositories(client, this.node))
                : repositories;
    }

    private PVEVersions versions;

    public PVEVersions getVersions() {
        return versions == null ? (versions = new PVEVersions(client, this.node)) : versions;
    }

    public static class PVEUpdate {

        private final PveClient client;
        private final Object node;

        protected PVEUpdate(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        /**
         * List available updates.
         *
         * @return Result
         */

        public Result listUpdates() {
            return client.get("/nodes/" + this.node + "/apt/update", null);
        }

        /**
         * This is used to resynchronize the package index files from their sources
         * (apt-get update).
         *
         * @param notify Send notification about new packages.
         * @param quiet  Only produces output suitable for logging, omitting progress
         *               indicators.
         * @return Result
         */

        public Result updateDatabase(Boolean notify, Boolean quiet) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("notify", notify);
            parameters.put("quiet", quiet);
            return client.create("/nodes/" + this.node + "/apt/update", parameters);
        }

        /**
         * This is used to resynchronize the package index files from their sources
         * (apt-get update).
         *
         * @return Result
         */

        public Result updateDatabase() {
            return client.create("/nodes/" + this.node + "/apt/update", null);
        }

    }

    public static class PVEChangelog {

        private final PveClient client;
        private final Object node;

        protected PVEChangelog(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        /**
         * Get package changelogs.
         *
         * @param name    Package name.
         * @param version Package version.
         * @return Result
         */

        public Result changelog(String name, String version) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("name", name);
            parameters.put("version", version);
            return client.get("/nodes/" + this.node + "/apt/changelog", parameters);
        }

        /**
         * Get package changelogs.
         *
         * @param name Package name.
         * @return Result
         */

        public Result changelog(String name) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("name", name);
            return client.get("/nodes/" + this.node + "/apt/changelog", parameters);
        }

    }

    public static class PVERepositories {

        private final PveClient client;
        private final Object node;

        protected PVERepositories(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        /**
         * Get APT repository information.
         *
         * @return Result
         */

        public Result repositories() {
            return client.get("/nodes/" + this.node + "/apt/repositories", null);
        }

        /**
         * Change the properties of a repository. Currently only allows
         * enabling/disabling.
         *
         * @param index   Index within the file (starting from 0).
         * @param path    Path to the containing file.
         * @param digest  Digest to detect modifications.
         * @param enabled Whether the repository should be enabled or not.
         * @return Result
         */

        public Result changeRepository(int index, String path, String digest, Boolean enabled) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("index", index);
            parameters.put("path", path);
            parameters.put("digest", digest);
            parameters.put("enabled", enabled);
            return client.create("/nodes/" + this.node + "/apt/repositories", parameters);
        }

        /**
         * Change the properties of a repository. Currently only allows
         * enabling/disabling.
         *
         * @param index Index within the file (starting from 0).
         * @param path  Path to the containing file.
         * @return Result
         */

        public Result changeRepository(int index, String path) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("index", index);
            parameters.put("path", path);
            return client.create("/nodes/" + this.node + "/apt/repositories", parameters);
        }

        /**
         * Add a standard repository to the configuration
         *
         * @param handle Handle that identifies a repository.
         * @param digest Digest to detect modifications.
         * @return Result
         */

        public Result addRepository(String handle, String digest) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("handle", handle);
            parameters.put("digest", digest);
            return client.set("/nodes/" + this.node + "/apt/repositories", parameters);
        }

        /**
         * Add a standard repository to the configuration
         *
         * @param handle Handle that identifies a repository.
         * @return Result
         */

        public Result addRepository(String handle) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("handle", handle);
            return client.set("/nodes/" + this.node + "/apt/repositories", parameters);
        }

    }

    public static class PVEVersions {

        private final PveClient client;
        private final Object node;

        protected PVEVersions(PveClient client, Object node) {
            this.client = client;
            this.node = node;
        }

        /**
         * Get package information for important Proxmox packages.
         *
         * @return Result
         */

        public Result versions() {
            return client.get("/nodes/" + this.node + "/apt/versions", null);
        }

    }

    /**
     * Directory index for apt (Advanced Package Tool).
     *
     * @return Result
     */

    public Result index() {
        return client.get("/nodes/" + this.node + "/apt", null);
    }

}

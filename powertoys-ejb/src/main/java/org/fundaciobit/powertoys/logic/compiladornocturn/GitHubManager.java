package org.fundaciobit.powertoys.logic.compiladornocturn;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.jboss.logging.Logger;
import org.kohsuke.github.*;
import org.kohsuke.github.GHProject.ProjectStateFilter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class GitHubManager {

    /**
     * Tipus d'autenticació que s'emprarà a l'hora d'instanciar el client GitHub.
     */
    public static enum AuthSchema {
        /**
         * Autenticació amb nom d'usuari i contrasenya
         */
        PASSWORD,
        /**
         * Autenticació amb token personal d'accés
         */
        OAUTH_TOKEN,
        /**
         * Autenticació amb token JWT
         */
        JWT_TOKEN,
        /**
         * Autenticació amb token d'instal·lació d'aplicació
         */
        APP_INSTALLATION_TOKEN,
        /**
         * Obtendrà les credencials de ~/.github o de System Environment Properties
         */
        SYSTEM_ENVIRONMENT,
        /**
         * Autenticació anònima
         */
        ANONYMOUS
    }

    private static final Logger LOG = Logger.getLogger(GitHubManager.class);

    private final GitHub github;

    /**
     * Constructor per inicialitzar el client GitHub amb les credencials d'usuari.
     *
     * @param authSchema Tipus d'autenticació que s'emplearà (PASSWORD, OAUTH_TOKEN,
     *                   JWT_TOKEN, APP_INSTALLATION_TOKEN, SYSTEM_ENVIRONMENT,
     *                   ANONYMOUS)
     * @param username   Nom d'usuari de GitHub. No és obligatori pel tipus
     *                   d'autenticació
     *                   OAUTH_TOKEN i no s'ha d'especificar per JWT_TOKEN,
     *                   APP_INSTALLATION_TOKEN, SYSTEM_ENVIRONMENT i ANONYMOUS
     * @param token      Token o contrasenya d'autenticació de GitHub. No s'ha
     *                   d'especificar
     *                   per SYSTEM_ENVIRONMENT i ANONYMOUS
     * @throws IOException Si hi ha algun error durant la inicialització del client
     *                     GitHub
     */
    public GitHubManager(AuthSchema authSchema, String username, String token) throws IOException {
        switch (authSchema) {
            case PASSWORD:
                this.github = new GitHubBuilder().withPassword(username, token).build();
                break;
            case OAUTH_TOKEN:
                if (username == null || username.isEmpty()) {
                    this.github = new GitHubBuilder().withOAuthToken(token).build();
                } else {
                    this.github = new GitHubBuilder().withOAuthToken(token, username).build();
                }
                break;
            case JWT_TOKEN:
                this.github = new GitHubBuilder().withJwtToken(token).build();
                break;
            case APP_INSTALLATION_TOKEN:
                this.github = new GitHubBuilder().withAppInstallationToken(token).build();
                break;
            case ANONYMOUS:
                this.github = GitHub.connectAnonymously();
                break;
            case SYSTEM_ENVIRONMENT:
                this.github = GitHub.connect();
                break;
            default:
                this.github = new GitHubBuilder().withPassword(username, token).build();
                break;
        }

        LOG.info("GitHub client initialized!");
    }

    /**
     * Constructor per inicialitzar el client GitHub amb les credencials d'usuari.
     *
     * @param propertyFilePath Fitxer de propietats amb les credencials d'usuari
     * @throws IOException Si hi ha algun error durant la inicialització del client
     */
    public GitHubManager(String propertyFilePath) throws IOException {
        this.github = GitHubBuilder.fromPropertyFile(propertyFilePath).build();

        LOG.info("GitHub client initialized!");
    }

    /**
     * Consulta tots els repositoris d'una organització.
     *
     * @param organization Nom de l'organització
     * @return Llista de repositoris de l'organització. Inclou els repositoris
     *         privats. Empleant un tamany de pàgina
     *         de 100 elements
     * @throws IOException Si hi ha algun error durant la consulta
     */
    public List<GHRepository> getRepositories(String organization) throws IOException {
        return new ArrayList<GHRepository>(github.getOrganization(organization).getRepositories().values());
        // return github.getOrganization(organization).listRepositories().toList();
    }

    /**
     * Consulta totes les branques d'un repositori.
     *
     * @param owner Propietari del repositori
     * @param repo  Nom del repositori
     * @return Llista de branques del repositori
     * @throws IOException Si hi ha algun error durant la consulta
     */
    public List<GHBranch> getBranches(String owner, String repo) throws IOException {
        return new ArrayList<GHBranch>(github.getRepository(owner + "/" + repo).getBranches().values());
    }

    /**
     * Consulta tots els projectes d'un repositori en un estat concret.
     *
     * @param owner Propietari del repositori
     * @param repo  Nom del repositori
     * @param state Estat dels projectes (open, closed, all)
     * @return Llista de projectes del repositori en l'estat especificat
     * @throws IOException Si hi ha algun error durant la consulta
     */
    public List<GHProject> getProjects(String owner, String repo, String state) throws IOException {
        return this.getProjects(owner, repo, GHProject.ProjectStateFilter.valueOf(state.toUpperCase()));
    }

    /**
     * Consulta tots els projectes d'un repositori en un estat concret.
     *
     * @param owner Propietari del repositori
     * @param repo  Nom del repositori
     * @param state Estat dels projectes (open, closed, all)
     * @return Llista de projectes del repositori en l'estat especificat
     * @throws IOException Si hi ha algun error durant la consulta
     */
    public List<GHProject> getProjects(String owner, String repo, ProjectStateFilter state) throws IOException {
        // if (state == ProjectStateFilter.ALL) {
        // Set<GHProject> set = new HashSet<GHProject>();
        // List<GHProject> openProjects = github.getRepository(owner + "/" + repo)
        // .listProjects(ProjectStateFilter.OPEN).toList();
        // List<GHProject> closedProjects = github.getRepository(owner + "/" + repo)
        // .listProjects(ProjectStateFilter.CLOSED).toList();
        // set.addAll(openProjects);
        // set.addAll(closedProjects);
        // return new ArrayList<GHProject>(set);
        // } else {
        // return github.getRepository(owner + "/" + repo)
        // .listProjects(state).toList();
        // }
        return github.getRepository(owner + "/" + repo)
                .listProjects(state).toList();
    }

    /**
     * Consulta un projecte en concret d'un repositori.
     *
     * @param owner     Propietari del repositori
     * @param repo      Nom del repositori
     * @param projectId ID del projecte
     * @return Projecte especificat
     * @throws IOException Si hi ha algun error durant la consulta
     */
    public GHProject getProject(String owner, String repo, int projectId) throws IOException {
        return this.getProjects(owner, repo, ProjectStateFilter.ALL).stream().filter(p -> p.getId() == projectId)
                .findFirst()
                .orElse(null);
    }

    /**
     * Consulta tots els issues d'un repositori.
     *
     * @param owner Propietari del repositori
     * @param repo  Nom del repositori
     * @return Llista d'issues del repositori
     * @throws IOException Si hi ha algun error durant la consulta
     */
    public List<GHIssue> getIssues(String owner, String repo) throws IOException {
        return github.getRepository(owner + "/" + repo).getIssues(GHIssueState.ALL);
    }

    /**
     * Consulta un issue en concret d'un repositori.
     *
     * @param owner       Propietari del repositori
     * @param repo        Nom del repositori
     * @param issueNumber Número de l'issue
     * @return Issue especificat
     * @throws IOException Si hi ha algun error durant la consulta
     */
    public GHIssue getIssue(String owner, String repo, int issueNumber) throws IOException {
        GHRepository ghRepo = github.getRepository(owner + "/" + repo);
        LOG.debug("Repositori obtingut: " + ghRepo.getFullName());
        GHIssue ghIssue = ghRepo.getIssue(issueNumber);
        LOG.debug("Issue obtingut: " + (ghIssue != null ? ghIssue.getTitle() : "null"));
        return ghIssue;
    }

    /**
     * Consulta tots els tags d'un repositori.
     *
     * @param owner Propietari del repositori
     * @param repo  Nom del repositori
     * @return Llista de tags del repositori
     * @throws IOException Si hi ha algun error durant la consulta
     */
    public List<GHTag> getTags(String owner, String repo) throws IOException {
        return github.getRepository(owner + "/" + repo).listTags().toList();
    }

    /**
     * Consulta el darrer tag d'un repositori.
     *
     * @param owner Propietari del repositori
     * @param repo  Nom del repositori
     * @return Darrer tag del repositori
     * @throws IOException Si hi ha algun error durant la consulta
     */
    public GHTag getLatestTag(String owner, String repo) throws IOException {
        List<GHTag> tags = getTags(owner, repo);
        return tags.isEmpty() ? null : tags.get(0);
    }

    /**
     * Clona un repositori en un directori específic.
     *
     * @param directory Directori on clonar el repositori
     * @param gitUrl    URL del repositori de GitHub
     * @throws Exception Si hi ha algun error durant la clonació
     */
    public void cloneRepository(Path directory, String gitUrl) throws Exception {
        Git.cloneRepository()
                .setURI(gitUrl)
                .setDirectory(directory.toFile())
                .call();
    }

    /**
     * Descarrega un repositori de GitHub i fa checkout al tag especificat.
     *
     * @param directory Ruta del directori on descarregar el repositori
     * @param gitUrl    URL del repositori de GitHub
     * @param tag       Tag del repositori a fer checkout
     * @throws GitAPIException
     * @throws TransportException
     * @throws InvalidRemoteException
     * @return El directori on clonar el repositori
     */
    public File cloneRepositoryAtTag(Path directory, String gitUrl, String tag)
            throws InvalidRemoteException, TransportException, GitAPIException {
        File repoDir = directory.toFile();

        // Descarregar el repositori de GitHub
        try (Git git = Git.cloneRepository()
                .setURI(gitUrl)
                .setDirectory(directory.toFile())
                .call()) {
            // Fer checkout al tag especificat
            git.checkout().setName(tag).call();
        }

        return repoDir;
    }

    public static void main(String[] args) {
        try {
            Properties configGH = new Properties();
            configGH.load(new FileInputStream("gh.properties"));
            String username = configGH.getProperty("githubmanager.username");
            String token = configGH.getProperty("githubmanager.token");

            // username = Configuracio.getGitHubManagerUser();
            // token = Configuracio.getGitHubManagerToken();

            GitHubManager client = new GitHubManager(AuthSchema.OAUTH_TOKEN, username, token);
            List<GHRepository> repos = client.getRepositories("Fundacio-Bit");
            LOG.info(repos);

            // Add more calls to test other methods
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
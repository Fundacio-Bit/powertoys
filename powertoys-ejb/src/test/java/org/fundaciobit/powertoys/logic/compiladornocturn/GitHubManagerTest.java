package org.fundaciobit.powertoys.logic.compiladornocturn;

import org.fundaciobit.powertoys.commons.utils.Configuracio;
import org.fundaciobit.powertoys.logic.compiladornocturn.GitHubManager.AuthSchema;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.kohsuke.github.*;
import org.kohsuke.github.GHProject.ProjectStateFilter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class GitHubManagerTest {

    @Parameterized.Parameter(0)
    public String owner;

    @Parameterized.Parameter(1)
    public String repo;

    @Parameterized.Parameter(2)
    public int projectId;

    @Parameterized.Parameter(3)
    public int issueNumber;

    // @Mock
    @Parameterized.Parameter(4)
    public String mockGhProjectName;

    // @Mock
    @Parameterized.Parameter(5)
    public String mockFirstGhProjectName;

    // @Mock
    @Parameterized.Parameter(6)
    public String mockGhIssueTitle;

    // @Mock
    @Parameterized.Parameter(7)
    public String mockGhIssueBody;

    // @Mock
    @Parameterized.Parameter(8)
    public String mockFirstGhIssueTitle;

    // @Mock
    @Parameterized.Parameter(9)
    public String mockFirstGhTagName;

    // @Mock
    private final int MIN_REPOS = 50;

    // @Mock
    private final int MIN_BRANCHES = 1;

    // @Mock
    private final String BRANCH_MAIN_NAME = "main";

    // @Mock
    private final int MIN_PROJECTS = 1;

    // @Mock
    private final int MIN_ISSUES = 1;

    // @Mock
    private final int MIN_TAGS = 1;

    private static String username;

    private static String token;

    private static String organization;

    private static GitHubManager gitHubManager;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        // owner, repo, projectId, issueNumber, mockGhProjectName,
        // mockFirstGhProjectName, mockGhIssueTitle, mockGhIssueBody,
        // mockFirstGhIssueTitle, mockFirstGhTagName
        return Arrays.asList(new Object[][] {
                {
                        "Fundacio-Bit",
                        "powertoys",
                        34,
                        21,
                        "powertoys-1.0.2",
                        "powertoys-unplanned",
                        "(10) Generar Client java API Rest per atacar a GitHUB",
                        "Adjunt un projecte per generar el client.", "Moure informació de EARs a menu PUBLIC",
                        "powertoys-1.0.0_2025-02-24"
                },
                {
                        "Fundacio-Bit",
                        "powertoys",
                        35,
                        7,
                        "powertoys-1.0.3",
                        "powertoys-unplanned",
                        "Eliminar pujades de fitxers ears que tenguin més d'una setmana",
                        "Crear un cron per esborrar les ears que tenguin més d'una setmana.",
                        "Moure informació de EARs a menu PUBLIC", "powertoys-1.0.0_2025-02-24"
                },
                {
                        "Fundacio-Bit",
                        "queesticfent",
                        15,
                        53,
                        "queesticfent-2.0.2",
                        "queesticfent-backlog",
                        "Quan estas a Gener de 2025 i afegeixes vacances et salta a Gener de 2024",
                        "Quan estàs a un mes de l'any que ve i afegeixes vacances et salta al mateix mes de l'any anterior.",
                        "Crear la base de QueEsticFent emprant GenApp", "queesticfent-2.0.0_20240416"
                }
        });
    }

    @BeforeClass
    public static void setUpClass() throws IOException {
        Properties configGH = new Properties();
        configGH.load(new FileInputStream("src\\\\test\\\\java\\\\org\\\\fundaciobit\\\\powertoys\\\\logic\\\\compiladornocturn\\\\testfiles\\\\gh.properties"));

        username = configGH.getProperty("githubmanager.username");
        token = configGH.getProperty("githubmanager.token");
        organization = configGH.getProperty("githubmanager.entitat");

        // username = Configuracio.getGitHubManagerUser();
        // token = Configuracio.getGitHubManagerToken();
        // organization = Configuracio.getGitHubManagerOrganization();

        gitHubManager = new GitHubManager(AuthSchema.OAUTH_TOKEN, username, token);
    }

    @Before
    public void setUp() throws IOException {
    }

    @Test
    public void testGetRepositories() throws IOException {
        List<GHRepository> result = gitHubManager.getRepositories(organization);

        assertNotNull(result);
        int nRepos = result.size();
        assertTrue(
                "El nombre de repositoris de " + organization + " (" + nRepos + ")"
                        + " hauria de ser major o igual a "
                        + MIN_REPOS,
                nRepos >= MIN_REPOS);
    }

    @Test
    public void testGetBranches() throws IOException {
        List<GHBranch> result = gitHubManager.getBranches(owner, repo);

        assertNotNull(result);
        int nBranches = result.size();
        assertTrue("El nombre de branques de " + this.owner + "/" + this.repo + " (" + nBranches + ")"
                + " hauria de ser major o igual a "
                + MIN_BRANCHES, nBranches >= MIN_BRANCHES);
        assertEquals(BRANCH_MAIN_NAME, result.get(0).getName());
    }

    @Test
    public void testGetProjects() throws IOException {
        List<GHProject> result = gitHubManager.getProjects(owner, repo, ProjectStateFilter.ALL);

        assertNotNull(result);
        int nProjects = result.size();
        assertTrue("El nombre de projectes de " + this.owner + "/" + this.repo + " (" + nProjects + ")"
                + " hauria de ser major o igual a "
                + MIN_PROJECTS, nProjects >= MIN_PROJECTS);
        String firstGhProjectName = result.get(nProjects - 1).getName();
        assertEquals("El nom del primer projecte de " + owner + "/" + repo + "hauria de ser \""
                + this.mockFirstGhProjectName + "\" i no \"" + firstGhProjectName + "\"", this.mockFirstGhProjectName,
                firstGhProjectName);
    }

    @Test
    public void testGetProject() throws IOException {
        GHProject result = gitHubManager.getProject(owner, repo, projectId);

        assertNotNull(result);
        String ghProjectName = result.getName();
        assertEquals("El nom del projecte " + owner + "/" + repo + "/" + projectId + "hauria de ser \""
                + this.mockGhProjectName + "\" i no \"" + ghProjectName + "\"", this.mockGhProjectName,
                ghProjectName);
    }

    @Test
    public void testGetIssues() throws IOException {
        List<GHIssue> result = gitHubManager.getIssues(owner, repo);

        assertNotNull(result);
        int nIssues = result.size();
        assertTrue("El nombre de Issues de " + this.owner + "/" + this.repo + " (" + nIssues + ")"
                + " hauria de ser major o igual a "
                + MIN_ISSUES, nIssues >= MIN_ISSUES);
        String firstGhIssueTitle = result.get(nIssues - 1).getTitle();
        assertEquals("El nom del primer Issue de " + owner + "/" + repo + "hauria de ser \""
                + this.mockFirstGhIssueTitle + "\" i no \"" + firstGhIssueTitle + "\"", this.mockFirstGhIssueTitle,
                firstGhIssueTitle);
    }

    @Test
    public void testGetIssue() throws IOException {
        GHIssue result = gitHubManager.getIssue(owner, repo, issueNumber);

        assertNotNull(result);
        String ghIssueTitle = result.getTitle();
        assertEquals("El nom de l'Issue " + owner + "/" + repo + "/" + issueNumber + "hauria de ser \""
                + this.mockGhIssueTitle + "\" i no \"" + ghIssueTitle + "\"", this.mockGhIssueTitle,
                ghIssueTitle);
        String ghIssueBody = result.getBody();
        assertTrue("El body de l'Issue " + owner + "/" + repo + "/" + issueNumber + "hauria de començar per \""
                + this.mockGhIssueBody + "\" i no per \"" + ghIssueBody + "\"",
                ghIssueBody.contains(this.mockGhIssueBody));
    }

    @Test
    public void testGetTags() throws IOException {
        List<GHTag> result = gitHubManager.getTags(owner, repo);

        assertNotNull(result);
        int nTags = result.size();
        assertTrue("El nombre de Tags de " + this.owner + "/" + this.repo + " (" + nTags + ")"
                + " hauria de ser major o igual a "
                + MIN_TAGS, nTags >= MIN_TAGS);
        String firstGhTagName = result.get(nTags - 1).getName();
        assertEquals("El nom del primer Tag de " + owner + "/" + repo + "hauria de ser \""
                + this.mockFirstGhTagName + "\" i no \"" + firstGhTagName + "\"", this.mockFirstGhTagName,
                firstGhTagName);
    }

    @Test
    public void testGetLatestTag() throws IOException {
        GHTag result = gitHubManager.getLatestTag(owner, repo);

        assertNotNull(result);
        assertNotEquals(
                "El nom del darrer tag del repositori " + owner + "/" + repo
                        + " no pot ser un string buit. Commit del tag trobat com a darrer: " + result.getCommit(),
                "", result.getName().trim());
    }
}

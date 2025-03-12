package org.fundaciobit.powertoys.logic.compiladornocturn;

import org.fundaciobit.powertoys.logic.compiladornocturn.GitHubManager.AuthSchema;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.kohsuke.github.GHTag;
import org.junit.runners.Parameterized.Parameter;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;

@RunWith(Enclosed.class)
public class CompiladorTest {

    @RunWith(Parameterized.class)
    public static class CompiladorPassantUrlItag {

        @Parameter(0)
        public String gitUrl;

        @Parameter(1)
        public String tag;

        @Parameter(2)
        public String comanda;

        private static Compilador compilador;

        private static String username;

        private static String token;

        private static GitHubManager gitHubManager;

        @BeforeClass
        public static void setUpClass() throws IOException {
            Properties configGH = new Properties();
            configGH.load(new FileInputStream(
                    "src\\\\test\\\\java\\\\org\\\\fundaciobit\\\\powertoys\\\\logic\\\\compiladornocturn\\\\testfiles\\\\gh.properties"));

            username = configGH.getProperty("githubmanager.username");
            token = configGH.getProperty("githubmanager.token");

            // username = Configuracio.getGitHubManagerUser();
            // token = Configuracio.getGitHubManagerToken();
            // organization = Configuracio.getGitHubManagerOrganization();

            gitHubManager = new GitHubManager(AuthSchema.OAUTH_TOKEN, username, token);
            compilador = new Compilador(gitHubManager);
        }

        @Before
        public void setUp() {
        }

        @Parameters
        public static Collection<Object[]> data() {
            final String URL_REPO = "https://github.com/Fundacio-Bit/powertoys.git";
            final String TAG_REPO = "powertoys-1.0.1_2025-03-05";

            return Arrays.asList(new Object[][] {
                    { URL_REPO, TAG_REPO, "echo No hem compilat, només hem clonat" },
                    { URL_REPO, TAG_REPO, "invalidcommand" },
                    { URL_REPO, TAG_REPO, "mvn clean install -DskipTests" }
            });
        }

        @Test
        public void testDescarregarICompilar() throws Exception {
            try {
                System.out.println("Inici del test, descarregant i compilant el repositori: " + gitUrl + " amb el tag: "
                        + tag + " i la comanda: " + comanda);
                compilador.descarregarICompilar(gitUrl, tag, comanda);
            } catch (IOException e) {
                if (comanda.equals("invalidcommand")) {
                    // Expected exception for invalid command
                    System.out
                            .println("Fi del test, NO hem fet la comanda, hem llançat una comanda invàlida a propòsit: "
                                    + "invalidcommand");
                    return;
                } else {
                    throw e;
                }
            } catch (RuntimeException e) {
                if (comanda.equals("invalidcommand")) {
                    // Expected exception for invalid command
                    System.out
                            .println("Fi del test, NO hem fet la comanda, hem llançat una comanda invàlida a propòsit: "
                                    + "invalidcommand");
                    return;
                } else {
                    throw e;
                }
            }
            System.out.println("Fi del test satisfactòriament.");
        }
    }

    @RunWith(Parameterized.class)
    public static class CompiladorDarrerTag {

        @Parameter(0)
        public String owner;

        @Parameter(1)
        public String repo;

        private final static String COMANDA = "mvn clean install -DskipTests";

        private static Compilador compilador;

        private static String username;

        private static String token;

        private static GitHubManager gitHubManager;

        @BeforeClass
        public static void setUpClass() throws IOException {
            Properties configGH = new Properties();
            configGH.load(new FileInputStream(
                    "src\\\\test\\\\java\\\\org\\\\fundaciobit\\\\powertoys\\\\logic\\\\compiladornocturn\\\\testfiles\\\\gh.properties"));

            username = configGH.getProperty("githubmanager.username");
            token = configGH.getProperty("githubmanager.token");

            // username = Configuracio.getGitHubManagerUser();
            // token = Configuracio.getGitHubManagerToken();

            gitHubManager = new GitHubManager(AuthSchema.OAUTH_TOKEN, username, token);
            compilador = new Compilador(gitHubManager);
        }

        @Before
        public void setUp() {
        }

        @Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][] {
                    { "Fundacio-Bit", "powertoys" },
                    { "Fundacio-Bit", "queesticfent" }
            });
        }

        @Test
        public void testDescarregarICompilarLatestTag() throws Exception {
            GHTag result = gitHubManager.getLatestTag(owner, repo);

            assertNotNull(result);
            assertNotEquals(
                    "El nom del darrer tag del repositori " + owner + "/" + repo
                            + " no pot ser un string buit. Commit del tag trobat com a darrer: " + result.getCommit(),
                    "", result.getName().trim());
            String responsable = result.getCommit().getCommitter().getName();
            System.out.println("El responsable del darrer tag del repositori " + owner + "/" + repo + " ("
                    + result.getName()
                    + ") és en " + responsable);
            assertNotEquals(
                    "El responsable del darrer tag del repositori " + owner + "/" + repo
                            + " no pot ser un string buit. Commit del tag trobat com a darrer: " + result.getCommit(),
                    "", responsable);

            compilador.descarregarICompilar(result.getOwner().getHttpTransportUrl(), result.getName(), COMANDA);
        }
    }
}
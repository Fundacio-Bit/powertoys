package org.fundaciobit.powertoys.logic.compiladornocturn;

import org.fundaciobit.powertoys.commons.utils.Configuracio;
import org.fundaciobit.powertoys.logic.compiladornocturn.GitHubManager.AuthSchema;
import org.jboss.logging.Logger;
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
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

@RunWith(Enclosed.class)
public class CompiladorTest {

    @RunWith(Parameterized.class)
    public static class CompiladorPassantUrlItag {

        private static final Logger log = Logger.getLogger(CompiladorPassantUrlItag.class);

        @Parameter(0)
        public String gitUrl;

        @Parameter(1)
        public String tag;

        @Parameter(2)
        public String comanda;

        private static Compilador compilador;

        private static Map<String, GitHubManager> gitHubManagers = new HashMap<>();;

        private static String nightlyCompilationTempDir;

        @BeforeClass
        public static void setUpClass() throws IOException {
            Properties configGH = new Properties();
            configGH.load(new FileInputStream("gh.properties"));
            Map<String, String[]> ghConfig = Configuracio.getGitHubOrganizations(configGH);

            // Map<String, String[]> ghConfig = Configuracio.getGitHubOrganizations();

            for (Entry<String, String[]> entry : ghConfig.entrySet()) {
                String organitzacio = entry.getKey();
                String username = entry.getValue()[0];
                String token = entry.getValue()[1];
                gitHubManagers.put(organitzacio, new GitHubManager(AuthSchema.OAUTH_TOKEN, username, token));
            }
            compilador = new Compilador();

            nightlyCompilationTempDir = Configuracio.getNightlyCompilationTempDir(configGH);
            // nightlyCompilationTempDir = Configuracio.getNightlyCompilationTempDir();
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
                log.info("Inici del test, descarregant i compilant el repositori: " + gitUrl + " amb el tag: "
                        + tag + " i la comanda: " + comanda);
                // TODO: extreure el nom de l'organització del gitUrl
                String organization = "Fundacio-Bit";
                Entry<Integer, String> result = compilador.descarregarICompilar(gitHubManagers.get(organization),
                        gitUrl, tag, comanda, nightlyCompilationTempDir);
                int exitCode = result.getKey();
                if (exitCode != 0) {
                    throw new RuntimeException("Error en la compilació, codi de sortida: " + exitCode + " -- comanda: "
                            + comanda + " -- gitUrl: " + gitUrl + " -- tag: " + tag);
                }
            } catch (IOException e) {
                if (comanda.equals("invalidcommand")) {
                    // Expected exception for invalid command
                    log.info("Fi del test, NO hem fet la comanda, hem llançat una comanda invàlida a propòsit: "
                            + "invalidcommand");
                    return;
                } else {
                    throw e;
                }
            } catch (RuntimeException e) {
                if (comanda.equals("invalidcommand")) {
                    // Expected exception for invalid command
                    log.info("Fi del test, NO hem fet la comanda, hem llançat una comanda invàlida a propòsit: "
                            + "invalidcommand");
                    return;
                } else {
                    throw e;
                }
            }
        }
    }

    @RunWith(Parameterized.class)
    public static class CompiladorDarrerTag {

        private static final Logger log = Logger.getLogger(CompiladorDarrerTag.class);

        @Parameter(0)
        public String owner;

        @Parameter(1)
        public String repo;

        private static Compilador compilador;

        private static Map<String, GitHubManager> gitHubManagers = new HashMap<>();;

        private static String nightlyCompilationTempDir;

        @BeforeClass
        public static void setUpClass() throws IOException {
            Properties configGH = new Properties();
            configGH.load(new FileInputStream("gh.properties"));
            Map<String, String[]> ghConfig = Configuracio.getGitHubOrganizations(configGH);

            // Map<String, String[]> ghConfig = Configuracio.getGitHubOrganizations();

            for (Entry<String, String[]> entry : ghConfig.entrySet()) {
                String organitzacio = entry.getKey();
                String username = entry.getValue()[0];
                String token = entry.getValue()[1];
                gitHubManagers.put(organitzacio, new GitHubManager(AuthSchema.OAUTH_TOKEN, username, token));
            }
            compilador = new Compilador();

            nightlyCompilationTempDir = Configuracio.getNightlyCompilationTempDir(configGH);
            // nightlyCompilationTempDir = Configuracio.getNightlyCompilationTempDir();
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
            log.info("Inici del test, descarregant i compilant el darrer tag del repositori: " + owner + "/" + repo);
            GitHubManager gitHubManager = gitHubManagers.get(owner);
            GHTag result = gitHubManager.getLatestTag(owner, repo);

            assertNotNull(result);
            assertNotEquals(
                    "El nom del darrer tag del repositori " + owner + "/" + repo
                            + " no pot ser un string buit. Commit del tag trobat com a darrer: " + result.getCommit(),
                    "", result.getName().trim());
            String responsable = result.getCommit().getCommitter().getName();
            log.info("El responsable del darrer tag del repositori " + owner + "/" + repo + " ("
                    + result.getName()
                    + ") és en " + responsable);
            assertNotEquals(
                    "El responsable del darrer tag del repositori " + owner + "/" + repo
                            + " no pot ser un string buit. Commit del tag trobat com a darrer: " + result.getCommit(),
                    "", responsable);

            Entry<Integer, String> resultCompilacio = compilador.descarregarICompilar(gitHubManager,
                    result.getOwner().getHttpTransportUrl(), result.getName(),
                    Compilador.COMANDA_COMPILACIO_MAVEN, nightlyCompilationTempDir);
            int exitCode = resultCompilacio.getKey();
            if (exitCode != 0) {
                throw new RuntimeException("Error en la compilació, codi de sortida: " + exitCode + " -- comanda: "
                        + Compilador.COMANDA_COMPILACIO_MAVEN + " -- gitUrl: " + result.getOwner().getHttpTransportUrl()
                        + " -- tag: " + result.getName());
            }
        }
    }
}
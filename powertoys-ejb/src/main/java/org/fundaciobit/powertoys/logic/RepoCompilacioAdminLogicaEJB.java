package org.fundaciobit.powertoys.logic;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.powertoys.commons.utils.Configuracio;
import org.fundaciobit.powertoys.commons.utils.Constants;
import org.fundaciobit.powertoys.ejb.FitxerService;
import org.fundaciobit.powertoys.ejb.RepoCompilacioEJB;
import org.fundaciobit.powertoys.logic.compiladornocturn.Compilador;
import org.fundaciobit.powertoys.logic.compiladornocturn.CompilacioGitHub;
import org.fundaciobit.powertoys.logic.compiladornocturn.GitHubManager;
import org.fundaciobit.powertoys.logic.compiladornocturn.GitHubManager.AuthSchema;
import org.fundaciobit.powertoys.model.entity.Compilacio;
import org.fundaciobit.powertoys.model.entity.RepoCompilacio;
import org.fundaciobit.powertoys.persistence.CompilacioJPA;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHTag;

/**
 * 
 * @author jpou
 *
 */
@Stateless(name = "RepoCompilacioAdminLogicaEJB")
public class RepoCompilacioAdminLogicaEJB extends RepoCompilacioEJB implements RepoCompilacioAdminLogicaService {

    @EJB(mappedName = org.fundaciobit.powertoys.logic.CompilacioAdminLogicaService.JNDI_NAME)
    protected org.fundaciobit.powertoys.logic.CompilacioAdminLogicaService compilacioEjb;

    private static String nightlyCompilationTempDir;
    private static Compilador compilador;
    private static Map<String, GitHubManager> gitHubManagers = new HashMap<>();

    private static Map<String, List<StringKeyValue>> orgsRepos = new HashMap<>();

    public static final short EXIT_CODE_IN_PROGRESS = -1;

    public RepoCompilacioAdminLogicaEJB() {
        super();

        try {
            setUpCompilador();
        } catch (IOException e) {
            String missatgeError = "Error inicialitzant el compilador: " + e.getMessage();
            log.error(missatgeError, e);
            // throw new I18NException("genapp.comodi", missatgeError);
        }

        try {
            setUpRepositoris();
            nightlyCompilationTempDir = Configuracio.getNightlyCompilationTempDir();
        } catch (I18NException e) {
            String missatgeError = "Error descarregant el llistat de repositoris: " + e.getMessage();
            log.error(missatgeError, e);
            // throw new I18NException("genapp.comodi", missatgeError);
        }

        nightlyCompilationTempDir = Configuracio.getNightlyCompilationTempDir();
    }

    private static void setUpCompilador() throws IOException {
        // Properties configGH = new Properties();
        // configGH.load(new FileInputStream("gh.properties"));
        // Map<String, String[]> ghConfig =
        // Configuracio.getGitHubOrganizations(configGH);

        Map<String, String[]> ghConfig = Configuracio.getGitHubOrganizations();

        for (Entry<String, String[]> entry : ghConfig.entrySet()) {
            String organitzacio = entry.getKey();
            String username = entry.getValue()[0];
            String token = entry.getValue()[1];
            gitHubManagers.put(organitzacio, new GitHubManager(AuthSchema.OAUTH_TOKEN, username, token));
        }
        compilador = new Compilador();
    }

    private void setUpRepositoris() throws I18NException {
        for (String org : getOrganizations()) {
            List<StringKeyValue> repos = new ArrayList<>();
            try {
                getRepositories(org).forEach(repo -> {
                    repos.add(new StringKeyValue(repo.getName(), repo.getFullName()));
                });
            } catch (Exception e) {
                String missatgeError = "Error al consultar els repositoris de l'organització " + org + ": "
                        + e.getMessage();
                log.error(missatgeError, e);
                throw new I18NException("genapp.comodi", missatgeError);
            }
            orgsRepos.put(org, repos);
        }
    }

    @RolesAllowed({ Constants.ROLE_EJB_FULL_ACCESS, Constants.ROLE_EJB_BASIC_ACCESS, Constants.ROLE_EJB_WS_ACCESS })
    public Collection<String> getOrgs() {
        return orgsRepos.keySet();
    }

    @RolesAllowed({ Constants.ROLE_EJB_FULL_ACCESS, Constants.ROLE_EJB_BASIC_ACCESS, Constants.ROLE_EJB_WS_ACCESS })
    public List<StringKeyValue> getRepos(String org) {
        if (org == null || org.isEmpty()) {
            List<StringKeyValue> repos = new ArrayList<>();
            for (List<StringKeyValue> orgRepos : orgsRepos.values()) {
                repos.addAll(orgRepos);
            }
            return repos;

        }

        return orgsRepos.get(org);
    }

    @RolesAllowed({ Constants.ROLE_EJB_FULL_ACCESS, Constants.ROLE_EJB_BASIC_ACCESS, Constants.ROLE_EJB_WS_ACCESS })
    public List<String> getOrganizations() {
        return gitHubManagers.keySet().stream().collect(Collectors.toList());
    }

    @RolesAllowed({ Constants.ROLE_EJB_FULL_ACCESS, Constants.ROLE_EJB_BASIC_ACCESS, Constants.ROLE_EJB_WS_ACCESS })
    public List<GHRepository> getRepositories(String owner) throws IOException, I18NException {
        List<GHRepository> result = gitHubManagers.get(owner).getRepositories(owner);

        if (result == null) {
            throw new I18NException("No s'ha trobat cap repositori de l'entitat " + owner);
        }
        int nRepos = result.size();
        log.info("Trobats " + nRepos + " repositoris de " + owner);

        return result;
    }

    @RolesAllowed({ Constants.ROLE_EJB_FULL_ACCESS, Constants.ROLE_EJB_BASIC_ACCESS, Constants.ROLE_EJB_WS_ACCESS })
    public CompilacioGitHub descarregarLatestTagIcrearCompilacio(RepoCompilacio instance)
            throws I18NException, IOException {
        Compilacio newCompilacio = new CompilacioJPA();
        newCompilacio.setRepocompilacioID(instance.getRepocompilacioID());

        // Obtenir darrer Tag
        String owner = instance.getOrganitzacioGitHub();
        String repo = instance.getRepositoriGitHub();
        GitHubManager ghManager = gitHubManagers.get(owner);
        GHTag latestTag = ghManager.getLatestTag(owner, repo);
        if (latestTag == null) {
            throw new I18NException("No s'ha trobat cap tag al repositori " + owner + "/" + repo);
        }
        String tagName = latestTag.getName();
        if (tagName.trim().isEmpty()) {
            throw new I18NException("El nom del darrer tag del repositori " + owner + "/" + repo
                    + " no pot ser un string buit. Commit del tag trobat com a darrer: " + latestTag.getCommit());
        }
        newCompilacio.setTagUrl(tagName);

        long startTime = System.currentTimeMillis();
        newCompilacio.setDataInici(new Timestamp(startTime));
        newCompilacio.setExitCode(EXIT_CODE_IN_PROGRESS);

        return new CompilacioGitHub(ghManager, latestTag.getOwner().getHttpTransportUrl(),
                compilacioEjb.create(newCompilacio), instance.getNom());
    }

    @Asynchronous
    @RolesAllowed({ Constants.ROLE_EJB_FULL_ACCESS, Constants.ROLE_EJB_BASIC_ACCESS, Constants.ROLE_EJB_WS_ACCESS })
    public Future<Compilacio> compilarAsync(CompilacioGitHub compilacioGitHub) throws Exception {
        Compilacio compilacio = null;
        Compilacio compilacioAcabada = null;
        try {
            compilacio = compilacioGitHub.getCompilacio();
            String tagName = compilacio.getTagUrl();
            Entry<Integer, String> compilacioResultat = compilador.descarregarICompilar(
                    compilacioGitHub.getGitHubManager(),
                    compilacioGitHub.getGitUrl(), tagName, Compilador.COMANDA_COMPILACIO_MAVEN,
                    nightlyCompilationTempDir);
            compilacio.setExitCode(compilacioResultat.getKey().shortValue());
            compilacio.setOutput(compilacioResultat.getValue());

            long endTime = System.currentTimeMillis();
            compilacio.setDataFi(new Timestamp(endTime));
            String repoCompilacioNom = compilacioGitHub.getRepoCompilacioNom();
            log.info(repoCompilacioNom + " " + tagName + " compilat en "
                    + (endTime - compilacio.getDataInici().getTime())
                    + " ms");

            compilacioAcabada = compilacioEjb.update(compilacio);

            String missatge = "Compilació forçada del repositori " + compilacioAcabada.getRepocompilacioID() + " "
                    + repoCompilacioNom + " executada i element guardat a la base de dades";
            log.info(missatge);
            log.info("CODI DE SORTIDA: " + compilacioAcabada.getExitCode());
            log.info("SORTIDA: " + compilacioAcabada.getOutput());

            return new javax.ejb.AsyncResult<Compilacio>(compilacioAcabada);
        } catch (Exception e) {
            if (compilacioAcabada == null && compilacio != null) {
                short exitCode = compilacio.getExitCode();
                if (exitCode == EXIT_CODE_IN_PROGRESS) {
                    compilacio.setDataFi(new Timestamp(System.currentTimeMillis()));
                    compilacio.setExitCode((short) -2);
                    compilacio.setOutput(e.getMessage());
                    compilacioAcabada = compilacioEjb.update(compilacio);
                }
            }
            throw e;
        }
    }

    public boolean compilationsRunning(long repoID) throws I18NException{
        for (Compilacio compilacio : compilacioEjb.findCompilacionsByRepoCompilacioID(repoID)) {
            if (compilacio.getExitCode() == EXIT_CODE_IN_PROGRESS) {
                return true;
            }
        }
        
        return false;
    }
}
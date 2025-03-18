package org.fundaciobit.powertoys.logic;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.powertoys.commons.utils.Configuracio;
import org.fundaciobit.powertoys.commons.utils.Constants;
import org.fundaciobit.powertoys.ejb.FitxerService;
import org.fundaciobit.powertoys.ejb.RepoCompilacioEJB;
import org.fundaciobit.powertoys.logic.compiladornocturn.Compilador;
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

    @EJB(mappedName = org.fundaciobit.powertoys.ejb.CompilacioService.JNDI_NAME)
    protected org.fundaciobit.powertoys.ejb.CompilacioService compilacioEjb;

    private static Compilador compilador;
    private static Map<String, GitHubManager> gitHubManagers = new HashMap<>();

    public RepoCompilacioAdminLogicaEJB() {
        super();
        try {
            setUpCompilador();
        } catch (IOException e) {
            String missatgeError = "Error inicialitzant el compilador: " + e.getMessage();
            log.error(missatgeError, e);
            // throw new I18NException("genapp.comodi", missatgeError);
        }
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
    public Compilacio descarregarICompilarLatestTag(RepoCompilacio instance) throws Exception {
        Compilacio newCompilacio = new CompilacioJPA();
        newCompilacio.setRepocompilacioID(instance.getRepocompilacioID());

        // Obtenir darrer Tag
        String owner = instance.getOrganitzacioGitHub();
        String repo = instance.getNom();
        GitHubManager ghManager = gitHubManagers.get(owner);
        GHTag latestTag = ghManager.getLatestTag(owner, repo);
        if (latestTag == null) {
            throw new I18NException("No s'ha trobat cap tag al repositori " + owner + "/" + repo);
        }
        if (latestTag.getName().trim().isEmpty()) {
            throw new I18NException("El nom del darrer tag del repositori " + owner + "/" + repo
                    + " no pot ser un string buit. Commit del tag trobat com a darrer: " + latestTag.getCommit());
        }
        newCompilacio.setTagUrl(latestTag.getName());

        // Compilam
        long startTime = System.currentTimeMillis();
        newCompilacio.setDataInici(new Timestamp(startTime));

        Entry<Integer, String> compilacioResultat = compilador.descarregarICompilar(ghManager,
                latestTag.getOwner().getHttpTransportUrl(), latestTag.getName(), Compilador.COMANDA_COMPILACIO_MAVEN);
        newCompilacio.setExitCode(compilacioResultat.getKey().shortValue());
        newCompilacio.setOutput(compilacioResultat.getValue());

        long endTime = System.currentTimeMillis();
        newCompilacio.setDataFi(new Timestamp(endTime));
        log.info(latestTag.getName() + " compilat en " + (endTime - startTime) + " ms");

        return compilacioEjb.create(newCompilacio);
    }

}
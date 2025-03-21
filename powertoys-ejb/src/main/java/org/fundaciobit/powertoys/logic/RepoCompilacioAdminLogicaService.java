package org.fundaciobit.powertoys.logic;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import javax.ejb.Local;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.powertoys.ejb.RepoCompilacioService;
import org.fundaciobit.powertoys.logic.compiladornocturn.CompilacioGitHub;
import org.fundaciobit.powertoys.model.entity.Compilacio;
import org.fundaciobit.powertoys.model.entity.RepoCompilacio;
import org.kohsuke.github.GHRepository;

/*
 * @author jpou
 */
@Local
public interface RepoCompilacioAdminLogicaService extends RepoCompilacioService {

    public static final String JNDI_NAME = "java:app/powertoys-ejb/RepoCompilacioAdminLogicaEJB!org.fundaciobit.powertoys.logic.RepoCompilacioAdminLogicaService";

    /*
     * public void deleteFull(AnnexJPA annex) throws I18NException;
     * 
     * 
     * public AnnexJPA createFull(AnnexJPA annex) throws I18NException;
     */
    public List<StringKeyValue> getRepos(String org);

    public Collection<String> getOrgs();

    public List<String> getOrganizations();

    public List<GHRepository> getRepositories(String owner) throws IOException, I18NException;

    public CompilacioGitHub descarregarLatestTagIcrearCompilacio(RepoCompilacio instance) throws I18NException, IOException;

    public Future<Compilacio> compilarAsync(CompilacioGitHub compilacioGitHub) throws Exception;
}

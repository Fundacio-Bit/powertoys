
package org.fundaciobit.powertoys.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.powertoys.persistence.RepoCompilacioJPA;
import org.fundaciobit.powertoys.persistence.RepoCompilacioIJPAManager;
import org.fundaciobit.powertoys.model.dao.IRepoCompilacioManager;

import org.fundaciobit.powertoys.model.entity.RepoCompilacio;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface RepoCompilacioService extends RepoCompilacioIJPAManager,IRepoCompilacioManager {

    public static final String JNDI_NAME = "java:app/powertoys-ejb/RepoCompilacioEJB!org.fundaciobit.powertoys.ejb.RepoCompilacioService";

    public RepoCompilacioJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(RepoCompilacio instance, FitxerService fitxerEjb) throws I18NException;
}

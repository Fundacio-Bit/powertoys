
package org.fundaciobit.powertoys.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.powertoys.persistence.EntornJPA;
import org.fundaciobit.powertoys.persistence.EntornIJPAManager;
import org.fundaciobit.powertoys.model.dao.IEntornManager;

import org.fundaciobit.powertoys.model.entity.Entorn;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface EntornService extends EntornIJPAManager,IEntornManager {

    public static final String JNDI_NAME = "java:app/powertoys-ejb/EntornEJB!org.fundaciobit.powertoys.ejb.EntornService";

    public EntornJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Entorn instance, FitxerService fitxerEjb) throws I18NException;
}

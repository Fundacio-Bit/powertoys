
package org.fundaciobit.powertoys.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.powertoys.persistence.EntornAplicacioJPA;
import org.fundaciobit.powertoys.persistence.EntornAplicacioIJPAManager;
import org.fundaciobit.powertoys.model.dao.IEntornAplicacioManager;

import org.fundaciobit.powertoys.model.entity.EntornAplicacio;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface EntornAplicacioService extends EntornAplicacioIJPAManager,IEntornAplicacioManager {

    public static final String JNDI_NAME = "java:app/powertoys-ejb/EntornAplicacioEJB!org.fundaciobit.powertoys.ejb.EntornAplicacioService";

    public EntornAplicacioJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(EntornAplicacio instance, FitxerService fitxerEjb) throws I18NException;
}

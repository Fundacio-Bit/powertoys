
package org.fundaciobit.powertoys.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.powertoys.persistence.AplicacioJPA;
import org.fundaciobit.powertoys.persistence.AplicacioIJPAManager;
import org.fundaciobit.powertoys.model.dao.IAplicacioManager;

import org.fundaciobit.powertoys.model.entity.Aplicacio;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface AplicacioService extends AplicacioIJPAManager,IAplicacioManager {

    public static final String JNDI_NAME = "java:app/powertoys-ejb/AplicacioEJB!org.fundaciobit.powertoys.ejb.AplicacioService";

    public AplicacioJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Aplicacio instance, FitxerService fitxerEjb) throws I18NException;
}

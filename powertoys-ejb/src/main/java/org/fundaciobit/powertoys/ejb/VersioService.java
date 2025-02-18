
package org.fundaciobit.powertoys.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.powertoys.persistence.VersioJPA;
import org.fundaciobit.powertoys.persistence.VersioIJPAManager;
import org.fundaciobit.powertoys.model.dao.IVersioManager;

import org.fundaciobit.powertoys.model.entity.Versio;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface VersioService extends VersioIJPAManager,IVersioManager {

    public static final String JNDI_NAME = "java:app/powertoys-ejb/VersioEJB!org.fundaciobit.powertoys.ejb.VersioService";

    public VersioJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Versio instance, FitxerService fitxerEjb) throws I18NException;
}

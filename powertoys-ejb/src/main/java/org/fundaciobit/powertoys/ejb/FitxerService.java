
package org.fundaciobit.powertoys.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.powertoys.persistence.FitxerJPA;
import org.fundaciobit.powertoys.persistence.FitxerIJPAManager;
import org.fundaciobit.powertoys.model.dao.IFitxerManager;

import org.fundaciobit.powertoys.model.entity.Fitxer;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface FitxerService extends FitxerIJPAManager,IFitxerManager {

    public static final String JNDI_NAME = "java:app/powertoys-ejb/FitxerEJB!org.fundaciobit.powertoys.ejb.FitxerService";

    public FitxerJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Fitxer instance, FitxerService fitxerEjb) throws I18NException;
}

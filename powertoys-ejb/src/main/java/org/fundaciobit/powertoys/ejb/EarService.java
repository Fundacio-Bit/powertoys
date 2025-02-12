
package org.fundaciobit.powertoys.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.powertoys.persistence.EarJPA;
import org.fundaciobit.powertoys.persistence.EarIJPAManager;
import org.fundaciobit.powertoys.model.dao.IEarManager;

import org.fundaciobit.powertoys.model.entity.Ear;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface EarService extends EarIJPAManager,IEarManager {

    public static final String JNDI_NAME = "java:app/powertoys-ejb/EarEJB!org.fundaciobit.powertoys.ejb.EarService";

    public EarJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Ear instance, FitxerService fitxerEjb) throws I18NException;
}

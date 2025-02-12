
package org.fundaciobit.powertoys.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.powertoys.persistence.EarSimpleJPA;
import org.fundaciobit.powertoys.persistence.EarSimpleIJPAManager;
import org.fundaciobit.powertoys.model.dao.IEarSimpleManager;

import org.fundaciobit.powertoys.model.entity.EarSimple;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface EarSimpleService extends EarSimpleIJPAManager,IEarSimpleManager {

    public static final String JNDI_NAME = "java:app/powertoys-ejb/EarSimpleEJB!org.fundaciobit.powertoys.ejb.EarSimpleService";

    public EarSimpleJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(EarSimple instance, FitxerService fitxerEjb) throws I18NException;
}

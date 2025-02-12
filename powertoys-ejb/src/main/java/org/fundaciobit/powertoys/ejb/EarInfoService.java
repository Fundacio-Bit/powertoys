
package org.fundaciobit.powertoys.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.powertoys.persistence.EarInfoJPA;
import org.fundaciobit.powertoys.persistence.EarInfoIJPAManager;
import org.fundaciobit.powertoys.model.dao.IEarInfoManager;

import org.fundaciobit.powertoys.model.entity.EarInfo;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface EarInfoService extends EarInfoIJPAManager,IEarInfoManager {

    public static final String JNDI_NAME = "java:app/powertoys-ejb/EarInfoEJB!org.fundaciobit.powertoys.ejb.EarInfoService";

    public EarInfoJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(EarInfo instance, FitxerService fitxerEjb) throws I18NException;
}

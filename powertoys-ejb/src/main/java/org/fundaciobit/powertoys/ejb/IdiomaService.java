
package org.fundaciobit.powertoys.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.powertoys.persistence.IdiomaJPA;
import org.fundaciobit.powertoys.persistence.IdiomaIJPAManager;
import org.fundaciobit.powertoys.model.dao.IIdiomaManager;

import org.fundaciobit.powertoys.model.entity.Idioma;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface IdiomaService extends IdiomaIJPAManager,IIdiomaManager {

    public static final String JNDI_NAME = "java:app/powertoys-ejb/IdiomaEJB!org.fundaciobit.powertoys.ejb.IdiomaService";

    public IdiomaJPA findByPrimaryKey(String _ID_);

    public void deleteIncludingFiles(Idioma instance, FitxerService fitxerEjb) throws I18NException;
}

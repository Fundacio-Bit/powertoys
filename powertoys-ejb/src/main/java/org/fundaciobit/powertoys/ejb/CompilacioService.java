
package org.fundaciobit.powertoys.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.powertoys.persistence.CompilacioJPA;
import org.fundaciobit.powertoys.persistence.CompilacioIJPAManager;
import org.fundaciobit.powertoys.model.dao.ICompilacioManager;

import org.fundaciobit.powertoys.model.entity.Compilacio;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface CompilacioService extends CompilacioIJPAManager,ICompilacioManager {

    public static final String JNDI_NAME = "java:app/powertoys-ejb/CompilacioEJB!org.fundaciobit.powertoys.ejb.CompilacioService";

    public CompilacioJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Compilacio instance, FitxerService fitxerEjb) throws I18NException;
}

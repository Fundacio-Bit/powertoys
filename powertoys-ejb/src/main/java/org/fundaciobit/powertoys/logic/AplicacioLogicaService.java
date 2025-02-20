
package org.fundaciobit.powertoys.logic;

import javax.ejb.Local;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.powertoys.ejb.AplicacioService;
import org.fundaciobit.powertoys.model.entity.Aplicacio;

/**
 * 
 * @author jpou
 *
 */
@Local
public interface AplicacioLogicaService extends AplicacioService {

    public static final String JNDI_NAME = "java:app/powertoys-ejb/AplicacioLogicaEJB!org.fundaciobit.powertoys.logic.AplicacioLogicaService";

    public void deleteAplicacioIncludingEntornIversio(Aplicacio instance) throws I18NException;
    // public void deleteAplicacioIncludingEntornIversio(Aplicacio instance,
    // EntornAplicacioService entornAplicacioEjb,
    // VersioService versioEjb) throws I18NException;

}

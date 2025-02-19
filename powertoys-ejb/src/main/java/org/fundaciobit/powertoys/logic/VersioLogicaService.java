
package org.fundaciobit.powertoys.logic;

import java.util.List;

import javax.ejb.Local;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.powertoys.ejb.VersioService;
import org.fundaciobit.powertoys.model.entity.Versio;

/**
 * 
 * @author jpou
 *
 */
@Local
public interface VersioLogicaService extends VersioService {

    public static final String JNDI_NAME = "java:app/powertoys-ejb/VersioLogicaEJB!org.fundaciobit.powertoys.logic.VersioLogicaService";

    public String refreshVersio(String domini, String contextPath, String versioGuardada,
            Long entornAplicacio) throws Exception;

    public List<Versio> getVersionsMajors() throws I18NException;

    public void refreshAllVersions() throws I18NException;

}

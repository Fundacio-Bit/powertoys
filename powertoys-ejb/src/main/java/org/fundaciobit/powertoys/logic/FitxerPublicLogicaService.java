package org.fundaciobit.powertoys.logic;

import javax.ejb.Local;

import org.fundaciobit.powertoys.ejb.FitxerService;

/*
 * @author jpou
 */
@Local
public interface FitxerPublicLogicaService extends FitxerService {

    public static final String JNDI_NAME = "java:app/powertoys-ejb/FitxerPublicLogicaEJB!org.fundaciobit.powertoys.logic.FitxerPublicLogicaService";
/*
    public void deleteFull(AnnexJPA annex) throws I18NException;

    
     * public AnnexJPA createFull(AnnexJPA annex) throws I18NException;
     */
}

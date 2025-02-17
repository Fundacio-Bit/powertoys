package org.fundaciobit.powertoys.logic;

import javax.ejb.Local;

import org.fundaciobit.powertoys.ejb.EarService;

/*
 * @author jpou
 */
@Local
public interface EarPublicLogicaService extends EarService {

    public static final String JNDI_NAME = "java:app/powertoys-ejb/EarPublicLogicaEJB!org.fundaciobit.powertoys.logic.EarPublicLogicaService";
    /*
     * public void deleteFull(AnnexJPA annex) throws I18NException;
     * 
     * 
     * public AnnexJPA createFull(AnnexJPA annex) throws I18NException;
     */
}

package org.fundaciobit.powertoys.logic;

import javax.ejb.Local;

import org.fundaciobit.powertoys.ejb.EarSimpleService;

/*
 * @author jpou
 */
@Local
public interface EarSimplePublicLogicaService extends EarSimpleService {

    public static final String JNDI_NAME = "java:app/powertoys-ejb/EarSimplePublicLogicaEJB!org.fundaciobit.powertoys.logic.EarSimplePublicLogicaService";
    /*
     * public void deleteFull(AnnexJPA annex) throws I18NException;
     * 
     * 
     * public AnnexJPA createFull(AnnexJPA annex) throws I18NException;
     */
}

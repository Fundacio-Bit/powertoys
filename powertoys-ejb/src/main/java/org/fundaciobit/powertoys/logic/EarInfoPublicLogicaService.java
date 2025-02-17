package org.fundaciobit.powertoys.logic;

import javax.ejb.Local;

import org.fundaciobit.powertoys.ejb.EarInfoService;

/*
 * @author jpou
 */
@Local
public interface EarInfoPublicLogicaService extends EarInfoService {

    public static final String JNDI_NAME = "java:app/powertoys-ejb/EarInfoPublicLogicaEJB!org.fundaciobit.powertoys.logic.EarInfoPublicLogicaService";
    /*
     * public void deleteFull(AnnexJPA annex) throws I18NException;
     * 
     * 
     * public AnnexJPA createFull(AnnexJPA annex) throws I18NException;
     */
}

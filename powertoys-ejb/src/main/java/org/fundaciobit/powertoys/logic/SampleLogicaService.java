package org.fundaciobit.powertoys.logic;

//import java.util.Set;

import javax.ejb.Local;

/*
import org.fundaciobit.powertoys.ejb.AnnexService;
import org.fundaciobit.powertoys.persistence.AnnexJPA;

import org.fundaciobit.genapp.common.i18n.I18NException;
*/
/**
 * 
 * @author anadal
 *
 */
@Local
public interface SampleLogicaService /* extends AnnexService */ {

    public static final String JNDI_NAME = "java:app/powertoys-ejb/SampleLogicaEJB!org.fundaciobit.powertoys.logic.SampleLogicaService";
/*
    public void deleteFull(AnnexJPA annex) throws I18NException;

    
     * public AnnexJPA createFull(AnnexJPA annex) throws I18NException;
     */
}

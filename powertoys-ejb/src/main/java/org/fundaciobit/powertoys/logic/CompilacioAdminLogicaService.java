package org.fundaciobit.powertoys.logic;

import java.util.List;

import javax.ejb.Local;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.powertoys.ejb.CompilacioService;
import org.fundaciobit.powertoys.model.entity.Compilacio;

/*
 * @author jpou
 */
@Local
public interface CompilacioAdminLogicaService extends CompilacioService {

    public static final String JNDI_NAME = "java:app/powertoys-ejb/CompilacioAdminLogicaEJB!org.fundaciobit.powertoys.logic.CompilacioAdminLogicaService";

    /*
     * public void deleteFull(AnnexJPA annex) throws I18NException;
     * 
     * 
     * public AnnexJPA createFull(AnnexJPA annex) throws I18NException;
     */
    public List<Compilacio> findCompilacionsByRepoCompilacioID(Long repoID) throws I18NException;
}

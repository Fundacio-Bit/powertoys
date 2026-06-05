package org.fundaciobit.powertoys.logic;

import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.powertoys.commons.utils.Constants;
import org.fundaciobit.powertoys.ejb.CompilacioEJB;
import org.fundaciobit.powertoys.model.entity.Compilacio;
import org.fundaciobit.powertoys.model.fields.CompilacioFields;

/**
 * 
 * @author jpou
 *
 */
@Stateless(name = "CompilacioAdminLogicaEJB")
public class CompilacioAdminLogicaEJB extends CompilacioEJB implements CompilacioAdminLogicaService {

    @Override
    @RolesAllowed({ Constants.ROLE_EJB_FULL_ACCESS, Constants.ROLE_EJB_BASIC_ACCESS, Constants.ROLE_EJB_WS_ACCESS })
    public List<Compilacio> findCompilacionsByRepoCompilacioID(Long repoID) throws I18NException {
        return this.select(CompilacioFields.REPOCOMPILACIOID.equal(repoID));
    }

}
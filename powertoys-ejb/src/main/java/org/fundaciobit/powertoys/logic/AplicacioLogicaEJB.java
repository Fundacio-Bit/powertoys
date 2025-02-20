package org.fundaciobit.powertoys.logic;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.powertoys.commons.utils.Constants;
import org.fundaciobit.powertoys.ejb.AplicacioEJB;
import org.fundaciobit.powertoys.model.entity.Aplicacio;
import org.fundaciobit.powertoys.model.entity.EntornAplicacio;

import org.fundaciobit.powertoys.model.fields.EntornAplicacioFields;
import org.fundaciobit.powertoys.model.fields.VersioFields;

/**
 * 
 * @author jpou
 *
 */
@PermitAll
@Stateless
public class AplicacioLogicaEJB extends AplicacioEJB implements AplicacioLogicaService {

    @EJB(mappedName = org.fundaciobit.powertoys.ejb.EntornAplicacioService.JNDI_NAME)
    protected org.fundaciobit.powertoys.ejb.EntornAplicacioService entornAplicacioEjb;

    @EJB(mappedName = org.fundaciobit.powertoys.ejb.VersioService.JNDI_NAME)
    protected org.fundaciobit.powertoys.ejb.VersioService versioEjb;

    @RolesAllowed({ Constants.ROLE_EJB_FULL_ACCESS, Constants.ROLE_EJB_BASIC_ACCESS, Constants.ROLE_EJB_WS_ACCESS })
    public void deleteAplicacioIncludingEntornIversio(Aplicacio instance) throws I18NException {
        List<EntornAplicacio> entornsAplicacio = this.entornAplicacioEjb
                .select(EntornAplicacioFields.APLICACIOID.equal(instance.getAplicacioID()));

        for (EntornAplicacio entornAplicacio : entornsAplicacio) {
            long entornAplicacioID = entornAplicacio.getEntornaplicacioid();
            // borram versions
            this.versioEjb.delete(VersioFields.ENTORNAPLICACIOID.equal(entornAplicacioID));

            // borram entornAplicacio
            this.entornAplicacioEjb.delete(entornAplicacioID);
        }

        // borram aplicacio
        this.delete(instance);
    }
}

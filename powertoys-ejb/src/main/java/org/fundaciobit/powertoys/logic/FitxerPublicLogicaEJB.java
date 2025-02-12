package org.fundaciobit.powertoys.logic;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.powertoys.ejb.FitxerEJB;
import org.fundaciobit.powertoys.model.entity.Fitxer;

/**
 * 
 * @author jpou
 *
 */
@Stateless(name = "FitxerPublicLogicaEJB")
public class FitxerPublicLogicaEJB extends FitxerEJB implements FitxerPublicLogicaService {

    @Override
    @PermitAll
    public Fitxer create(Fitxer instance) throws I18NException {
        return super.create(instance);
    }

    @Override
    @PermitAll
    public Fitxer update(Fitxer instance) throws I18NException {
        return super.update(instance);
    }

}
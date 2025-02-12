package org.fundaciobit.powertoys.logic;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.powertoys.ejb.EarSimpleEJB;
import org.fundaciobit.powertoys.ejb.FitxerService;
import org.fundaciobit.powertoys.model.entity.EarSimple;
import org.fundaciobit.powertoys.persistence.EarSimpleJPA;

/**
 * 
 * @author jpou
 *
 */
@Stateless(name = "EarSimplePublicLogicaEJB")
public class EarSimplePublicLogicaEJB extends EarSimpleEJB implements EarSimplePublicLogicaService {

    @Override
    @PermitAll
    public EarSimple create(EarSimple instance) throws I18NException {
        return super.create(instance);
    }

    @Override
    @PermitAll
    public EarSimple update(EarSimple instance) throws I18NException {
        return super.update(instance);
    }

    @Override
    @PermitAll
    public void deleteIncludingFiles(EarSimple instance, FitxerService fitxerEjb)
            throws I18NException {
        super.deleteIncludingFiles(instance, fitxerEjb);
    }

    @Override
    @PermitAll
    public EarSimpleJPA findByPrimaryKey(Long _ID_) {
        return (EarSimpleJPA) super.findByPrimaryKey(_ID_);
    }

}
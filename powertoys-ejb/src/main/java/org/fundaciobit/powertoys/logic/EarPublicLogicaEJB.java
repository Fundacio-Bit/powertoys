package org.fundaciobit.powertoys.logic;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.powertoys.ejb.EarEJB;
import org.fundaciobit.powertoys.ejb.FitxerService;
import org.fundaciobit.powertoys.model.entity.Ear;
import org.fundaciobit.powertoys.persistence.EarJPA;

/**
 * 
 * @author jpou
 *
 */
@Stateless(name = "EarPublicLogicaEJB")
public class EarPublicLogicaEJB extends EarEJB implements EarPublicLogicaService {

    @Override
    @PermitAll
    public Ear create(Ear instance) throws I18NException {
        return super.create(instance);
    }

    @Override
    @PermitAll
    public Ear update(Ear instance) throws I18NException {
        return super.update(instance);
    }

    @Override
    @PermitAll
    public void deleteIncludingFiles(Ear instance, FitxerService fitxerEjb)
            throws I18NException {
        super.deleteIncludingFiles(instance, fitxerEjb);
    }

    @Override
    @PermitAll
    public EarJPA findByPrimaryKey(Long _ID_) {
        return (EarJPA) super.findByPrimaryKey(_ID_);
    }

}
package org.fundaciobit.powertoys.logic;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.powertoys.ejb.EarInfoEJB;
import org.fundaciobit.powertoys.model.entity.EarInfo;
import org.fundaciobit.powertoys.persistence.EarInfoJPA;

/**
 * 
 * @author jpou
 *
 */
@Stateless(name = "EarInfoPublicLogicaEJB")
public class EarInfoPublicLogicaEJB extends EarInfoEJB implements EarInfoPublicLogicaService {

    @Override
    @PermitAll
    public EarInfo create(EarInfo instance) throws I18NException {
        return super.create(instance);
    }

    @Override
    @PermitAll
    public EarInfoJPA findByPrimaryKey(Long _ID_) {
        return (EarInfoJPA) super.findByPrimaryKey(_ID_);
    }

}
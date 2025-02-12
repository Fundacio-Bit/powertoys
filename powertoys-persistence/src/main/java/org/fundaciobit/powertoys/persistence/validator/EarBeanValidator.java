package org.fundaciobit.powertoys.persistence.validator;

import org.fundaciobit.powertoys.persistence.EarJPA;
import org.fundaciobit.genapp.common.validation.BeanValidatorResult;
import java.util.List;
import org.fundaciobit.genapp.common.i18n.I18NFieldError;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.validation.AbstractBeanValidator;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class EarBeanValidator 
      extends AbstractBeanValidator<EarJPA> {


  // EJB's
  protected final org.fundaciobit.powertoys.model.dao.IEarManager __earManager;


  public final EarValidator<EarJPA> _validator;


  public EarBeanValidator(org.fundaciobit.powertoys.model.dao.IEarManager __earManager) { 
    this.__earManager = __earManager;
    _validator = new EarValidator<EarJPA>();
  }

  public EarBeanValidator(EarValidator<EarJPA> _validator,
     org.fundaciobit.powertoys.model.dao.IEarManager __earManager) {
    this.__earManager = __earManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(EarJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<EarJPA> _bvr_ = new BeanValidatorResult<EarJPA>();
    _validator.validate(_bvr_, target, isNou, __earManager);
    return _bvr_.getErrors();
  }
}

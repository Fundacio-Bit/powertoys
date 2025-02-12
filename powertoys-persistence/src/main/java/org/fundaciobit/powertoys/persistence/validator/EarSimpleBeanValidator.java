package org.fundaciobit.powertoys.persistence.validator;

import org.fundaciobit.powertoys.persistence.EarSimpleJPA;
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
public class EarSimpleBeanValidator 
      extends AbstractBeanValidator<EarSimpleJPA> {


  // EJB's
  protected final org.fundaciobit.powertoys.model.dao.IEarSimpleManager __earSimpleManager;


  public final EarSimpleValidator<EarSimpleJPA> _validator;


  public EarSimpleBeanValidator(org.fundaciobit.powertoys.model.dao.IEarSimpleManager __earSimpleManager) { 
    this.__earSimpleManager = __earSimpleManager;
    _validator = new EarSimpleValidator<EarSimpleJPA>();
  }

  public EarSimpleBeanValidator(EarSimpleValidator<EarSimpleJPA> _validator,
     org.fundaciobit.powertoys.model.dao.IEarSimpleManager __earSimpleManager) {
    this.__earSimpleManager = __earSimpleManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(EarSimpleJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<EarSimpleJPA> _bvr_ = new BeanValidatorResult<EarSimpleJPA>();
    _validator.validate(_bvr_, target, isNou, __earSimpleManager);
    return _bvr_.getErrors();
  }
}

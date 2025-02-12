package org.fundaciobit.powertoys.persistence.validator;

import org.fundaciobit.powertoys.persistence.EarInfoJPA;
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
public class EarInfoBeanValidator 
      extends AbstractBeanValidator<EarInfoJPA> {


  // EJB's
  protected final org.fundaciobit.powertoys.model.dao.IEarManager __earManager;

  protected final org.fundaciobit.powertoys.model.dao.IEarInfoManager __earInfoManager;


  public final EarInfoValidator<EarInfoJPA> _validator;


  public EarInfoBeanValidator(org.fundaciobit.powertoys.model.dao.IEarManager __earManager,
     org.fundaciobit.powertoys.model.dao.IEarInfoManager __earInfoManager) { 
    this.__earManager = __earManager;
    this.__earInfoManager = __earInfoManager;
    _validator = new EarInfoValidator<EarInfoJPA>();
  }

  public EarInfoBeanValidator(EarInfoValidator<EarInfoJPA> _validator,
     org.fundaciobit.powertoys.model.dao.IEarManager __earManager,
     org.fundaciobit.powertoys.model.dao.IEarInfoManager __earInfoManager) {
    this.__earManager = __earManager;
    this.__earInfoManager = __earInfoManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(EarInfoJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<EarInfoJPA> _bvr_ = new BeanValidatorResult<EarInfoJPA>();
    _validator.validate(_bvr_, target, isNou, __earManager, __earInfoManager);
    return _bvr_.getErrors();
  }
}

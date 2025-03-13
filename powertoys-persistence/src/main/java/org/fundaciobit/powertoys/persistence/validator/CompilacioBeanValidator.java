package org.fundaciobit.powertoys.persistence.validator;

import org.fundaciobit.powertoys.persistence.CompilacioJPA;
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
public class CompilacioBeanValidator 
      extends AbstractBeanValidator<CompilacioJPA> {


  // EJB's
  protected final org.fundaciobit.powertoys.model.dao.ICompilacioManager __compilacioManager;

  protected final org.fundaciobit.powertoys.model.dao.IRepoCompilacioManager __repoCompilacioManager;


  public final CompilacioValidator<CompilacioJPA> _validator;


  public CompilacioBeanValidator(org.fundaciobit.powertoys.model.dao.ICompilacioManager __compilacioManager,
     org.fundaciobit.powertoys.model.dao.IRepoCompilacioManager __repoCompilacioManager) { 
    this.__compilacioManager = __compilacioManager;
    this.__repoCompilacioManager = __repoCompilacioManager;
    _validator = new CompilacioValidator<CompilacioJPA>();
  }

  public CompilacioBeanValidator(CompilacioValidator<CompilacioJPA> _validator,
     org.fundaciobit.powertoys.model.dao.ICompilacioManager __compilacioManager,
     org.fundaciobit.powertoys.model.dao.IRepoCompilacioManager __repoCompilacioManager) {
    this.__compilacioManager = __compilacioManager;
    this.__repoCompilacioManager = __repoCompilacioManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(CompilacioJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<CompilacioJPA> _bvr_ = new BeanValidatorResult<CompilacioJPA>();
    _validator.validate(_bvr_, target, isNou, __compilacioManager, __repoCompilacioManager);
    return _bvr_.getErrors();
  }
}

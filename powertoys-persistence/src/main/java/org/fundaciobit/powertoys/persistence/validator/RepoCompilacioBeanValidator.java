package org.fundaciobit.powertoys.persistence.validator;

import org.fundaciobit.powertoys.persistence.RepoCompilacioJPA;
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
public class RepoCompilacioBeanValidator 
      extends AbstractBeanValidator<RepoCompilacioJPA> {


  // EJB's
  protected final org.fundaciobit.powertoys.model.dao.IRepoCompilacioManager __repoCompilacioManager;


  public final RepoCompilacioValidator<RepoCompilacioJPA> _validator;


  public RepoCompilacioBeanValidator(org.fundaciobit.powertoys.model.dao.IRepoCompilacioManager __repoCompilacioManager) { 
    this.__repoCompilacioManager = __repoCompilacioManager;
    _validator = new RepoCompilacioValidator<RepoCompilacioJPA>();
  }

  public RepoCompilacioBeanValidator(RepoCompilacioValidator<RepoCompilacioJPA> _validator,
     org.fundaciobit.powertoys.model.dao.IRepoCompilacioManager __repoCompilacioManager) {
    this.__repoCompilacioManager = __repoCompilacioManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(RepoCompilacioJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<RepoCompilacioJPA> _bvr_ = new BeanValidatorResult<RepoCompilacioJPA>();
    _validator.validate(_bvr_, target, isNou, __repoCompilacioManager);
    return _bvr_.getErrors();
  }
}

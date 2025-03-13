package org.fundaciobit.powertoys.back.validator.webdb;

import org.apache.log4j.Logger;

import org.fundaciobit.genapp.common.validation.BeanValidatorResult;
import org.fundaciobit.genapp.common.i18n.I18NFieldError;
import java.util.List;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.web.validation.WebValidationResult;
import org.fundaciobit.powertoys.model.fields.*;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.fundaciobit.powertoys.persistence.validator.RepoCompilacioValidator;

import org.fundaciobit.powertoys.back.form.webdb.RepoCompilacioForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import org.fundaciobit.powertoys.model.entity.RepoCompilacio;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class RepoCompilacioWebValidator extends AbstractWebValidator<RepoCompilacioForm, RepoCompilacio>
     implements Validator, RepoCompilacioFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected RepoCompilacioValidator<RepoCompilacio> validator = new RepoCompilacioValidator<RepoCompilacio>();

  // EJB's
  @javax.ejb.EJB(mappedName = org.fundaciobit.powertoys.ejb.RepoCompilacioService.JNDI_NAME)
  protected org.fundaciobit.powertoys.ejb.RepoCompilacioService repoCompilacioEjb;



  public RepoCompilacioWebValidator() {
    super();    
  }
  
  @Override
  public RepoCompilacio getBeanOfForm(RepoCompilacioForm form) {
    return  form.getRepoCompilacio();
  }

  @Override
  public Class<RepoCompilacioForm> getClassOfForm() {
    return RepoCompilacioForm.class;
  }

  @Override
  public void validate(RepoCompilacioForm __form, RepoCompilacio __bean, Errors errors) {

    WebValidationResult<RepoCompilacioForm> wvr;
    wvr = new WebValidationResult<RepoCompilacioForm>(errors);

    boolean isNou;
    {
        Object objNou = errors.getFieldValue("nou");
        if (objNou == null) {
            isNou = false;
        } else { 
         Boolean nou = Boolean.parseBoolean(String.valueOf(objNou));
         isNou =  nou != null && nou.booleanValue();
        }
    }

    validate(__form, __bean , errors, wvr, isNou);
  }


  public void validate(RepoCompilacioForm __form, RepoCompilacio __bean, Errors errors,
    WebValidationResult<RepoCompilacioForm> wvr, boolean isNou) {

    BeanValidatorResult<RepoCompilacio> __vr = new BeanValidatorResult<RepoCompilacio>();
    validator.validate(__vr, __bean,
      isNou, repoCompilacioEjb);

    if (__vr.hasErrors()) {
        List<I18NFieldError> vrErrors = __vr.getErrors();
    	   for (I18NFieldError i18nFieldError : vrErrors) {
    	       wvr.rejectValue(i18nFieldError.getField(), i18nFieldError.getTranslation().getCode(), i18nFieldError.getTranslation().getArgs());
        }
    }


  } // Final de metode

  public String get(Field<?> field) {
    return field.fullName;
  }

  public RepoCompilacioValidator<RepoCompilacio> getValidator() {
    return validator;
  }

  public void setValidator(RepoCompilacioValidator<RepoCompilacio> validator) {
    this.validator = validator;
  }

}
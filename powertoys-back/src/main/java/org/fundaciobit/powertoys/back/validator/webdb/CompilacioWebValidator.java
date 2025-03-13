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
import org.fundaciobit.powertoys.persistence.validator.CompilacioValidator;

import org.fundaciobit.powertoys.back.form.webdb.CompilacioForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import org.fundaciobit.powertoys.model.entity.Compilacio;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class CompilacioWebValidator extends AbstractWebValidator<CompilacioForm, Compilacio>
     implements Validator, CompilacioFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected CompilacioValidator<Compilacio> validator = new CompilacioValidator<Compilacio>();

  // EJB's
  @javax.ejb.EJB(mappedName = org.fundaciobit.powertoys.ejb.CompilacioService.JNDI_NAME)
  protected org.fundaciobit.powertoys.ejb.CompilacioService compilacioEjb;

  @javax.ejb.EJB(mappedName = org.fundaciobit.powertoys.ejb.RepoCompilacioService.JNDI_NAME)
  protected org.fundaciobit.powertoys.ejb.RepoCompilacioService repoCompilacioEjb;



  public CompilacioWebValidator() {
    super();    
  }
  
  @Override
  public Compilacio getBeanOfForm(CompilacioForm form) {
    return  form.getCompilacio();
  }

  @Override
  public Class<CompilacioForm> getClassOfForm() {
    return CompilacioForm.class;
  }

  @Override
  public void validate(CompilacioForm __form, Compilacio __bean, Errors errors) {

    WebValidationResult<CompilacioForm> wvr;
    wvr = new WebValidationResult<CompilacioForm>(errors);

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


  public void validate(CompilacioForm __form, Compilacio __bean, Errors errors,
    WebValidationResult<CompilacioForm> wvr, boolean isNou) {

    BeanValidatorResult<Compilacio> __vr = new BeanValidatorResult<Compilacio>();
    validator.validate(__vr, __bean,
      isNou, compilacioEjb, repoCompilacioEjb);

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

  public CompilacioValidator<Compilacio> getValidator() {
    return validator;
  }

  public void setValidator(CompilacioValidator<Compilacio> validator) {
    this.validator = validator;
  }

}
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
import org.fundaciobit.powertoys.persistence.validator.EarInfoValidator;

import org.fundaciobit.powertoys.back.form.webdb.EarInfoForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import org.fundaciobit.powertoys.model.entity.EarInfo;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class EarInfoWebValidator extends AbstractWebValidator<EarInfoForm, EarInfo>
     implements Validator, EarInfoFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected EarInfoValidator<EarInfo> validator = new EarInfoValidator<EarInfo>();

  // EJB's
  @javax.ejb.EJB(mappedName = org.fundaciobit.powertoys.ejb.EarService.JNDI_NAME)
  protected org.fundaciobit.powertoys.ejb.EarService earEjb;

  @javax.ejb.EJB(mappedName = org.fundaciobit.powertoys.ejb.EarInfoService.JNDI_NAME)
  protected org.fundaciobit.powertoys.ejb.EarInfoService earInfoEjb;



  public EarInfoWebValidator() {
    super();    
  }
  
  @Override
  public EarInfo getBeanOfForm(EarInfoForm form) {
    return  form.getEarInfo();
  }

  @Override
  public Class<EarInfoForm> getClassOfForm() {
    return EarInfoForm.class;
  }

  @Override
  public void validate(EarInfoForm __form, EarInfo __bean, Errors errors) {

    WebValidationResult<EarInfoForm> wvr;
    wvr = new WebValidationResult<EarInfoForm>(errors);

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


  public void validate(EarInfoForm __form, EarInfo __bean, Errors errors,
    WebValidationResult<EarInfoForm> wvr, boolean isNou) {

    BeanValidatorResult<EarInfo> __vr = new BeanValidatorResult<EarInfo>();
    validator.validate(__vr, __bean,
      isNou, earEjb, earInfoEjb);

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

  public EarInfoValidator<EarInfo> getValidator() {
    return validator;
  }

  public void setValidator(EarInfoValidator<EarInfo> validator) {
    this.validator = validator;
  }

}
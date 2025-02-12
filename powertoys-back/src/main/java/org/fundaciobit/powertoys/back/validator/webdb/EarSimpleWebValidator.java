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
import org.fundaciobit.powertoys.persistence.validator.EarSimpleValidator;

import org.fundaciobit.powertoys.back.form.webdb.EarSimpleForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import org.fundaciobit.powertoys.model.entity.EarSimple;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class EarSimpleWebValidator extends AbstractWebValidator<EarSimpleForm, EarSimple>
     implements Validator, EarSimpleFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected EarSimpleValidator<EarSimple> validator = new EarSimpleValidator<EarSimple>();

  // EJB's
  @javax.ejb.EJB(mappedName = org.fundaciobit.powertoys.ejb.EarSimpleService.JNDI_NAME)
  protected org.fundaciobit.powertoys.ejb.EarSimpleService earSimpleEjb;



  public EarSimpleWebValidator() {
    super();    
  }
  
  @Override
  public EarSimple getBeanOfForm(EarSimpleForm form) {
    return  form.getEarSimple();
  }

  @Override
  public Class<EarSimpleForm> getClassOfForm() {
    return EarSimpleForm.class;
  }

  @Override
  public void validate(EarSimpleForm __form, EarSimple __bean, Errors errors) {

    WebValidationResult<EarSimpleForm> wvr;
    wvr = new WebValidationResult<EarSimpleForm>(errors);

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


  public void validate(EarSimpleForm __form, EarSimple __bean, Errors errors,
    WebValidationResult<EarSimpleForm> wvr, boolean isNou) {

    BeanValidatorResult<EarSimple> __vr = new BeanValidatorResult<EarSimple>();
    validator.validate(__vr, __bean,
      isNou, earSimpleEjb);

    if (__vr.hasErrors()) {
        List<I18NFieldError> vrErrors = __vr.getErrors();
    	   for (I18NFieldError i18nFieldError : vrErrors) {
    	       wvr.rejectValue(i18nFieldError.getField(), i18nFieldError.getTranslation().getCode(), i18nFieldError.getTranslation().getArgs());
        }
    }

    if (isNou) { // Creacio
      // ================ CREATION
      // Fitxers 
        if (!errors.hasFieldErrors(get(FITXERID))){
            CommonsMultipartFile fitxerID = ((EarSimpleForm)__form).getFitxerID();
            if (fitxerID == null || fitxerID.isEmpty()) {
                errors.rejectValue(get(FITXERID), "genapp.validation.required",
                new String[]{ org.fundaciobit.genapp.common.web.i18n.I18NUtils.tradueix(get(FITXERID)) },
                null);
            }
        }

    }

  } // Final de metode

  public String get(Field<?> field) {
    return field.fullName;
  }

  public EarSimpleValidator<EarSimple> getValidator() {
    return validator;
  }

  public void setValidator(EarSimpleValidator<EarSimple> validator) {
    this.validator = validator;
  }

}
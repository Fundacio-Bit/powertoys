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
import org.fundaciobit.powertoys.persistence.validator.EarValidator;

import org.fundaciobit.powertoys.back.form.webdb.EarForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import org.fundaciobit.powertoys.model.entity.Ear;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class EarWebValidator extends AbstractWebValidator<EarForm, Ear>
     implements Validator, EarFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected EarValidator<Ear> validator = new EarValidator<Ear>();

  // EJB's
  @javax.ejb.EJB(mappedName = org.fundaciobit.powertoys.ejb.EarService.JNDI_NAME)
  protected org.fundaciobit.powertoys.ejb.EarService earEjb;



  public EarWebValidator() {
    super();    
  }
  
  @Override
  public Ear getBeanOfForm(EarForm form) {
    return  form.getEar();
  }

  @Override
  public Class<EarForm> getClassOfForm() {
    return EarForm.class;
  }

  @Override
  public void validate(EarForm __form, Ear __bean, Errors errors) {

    WebValidationResult<EarForm> wvr;
    wvr = new WebValidationResult<EarForm>(errors);

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


  public void validate(EarForm __form, Ear __bean, Errors errors,
    WebValidationResult<EarForm> wvr, boolean isNou) {

    BeanValidatorResult<Ear> __vr = new BeanValidatorResult<Ear>();
    validator.validate(__vr, __bean,
      isNou, earEjb);

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
            CommonsMultipartFile fitxerID = ((EarForm)__form).getFitxerID();
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

  public EarValidator<Ear> getValidator() {
    return validator;
  }

  public void setValidator(EarValidator<Ear> validator) {
    this.validator = validator;
  }

}
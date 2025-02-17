package org.fundaciobit.powertoys.persistence.validator;

import org.apache.log4j.Logger;

import org.fundaciobit.powertoys.model.entity.EarInfo;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.powertoys.model.fields.EarInfoFields;
import org.fundaciobit.powertoys.model.fields.EarFields;

import org.fundaciobit.genapp.common.validation.IValidatorResult;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class EarInfoValidator<I extends EarInfo>
    extends org.fundaciobit.genapp.common.validation.AbstractValidator    implements EarInfoFields {

    protected final Logger log = Logger.getLogger(getClass());


  public EarInfoValidator() {
    super();    
  }
  

  /** Constructor */
  public void validate(IValidatorResult<I> __vr,I __target__, boolean __isNou__
    ,org.fundaciobit.powertoys.model.dao.IEarManager __earManager
    ,org.fundaciobit.powertoys.model.dao.IEarInfoManager __earInfoManager) {

    // Valors Not Null
    __vr.rejectIfEmptyOrWhitespace(__target__,EARID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(EARID)));

    __vr.rejectIfEmptyOrWhitespace(__target__,FILENAME, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(FILENAME)));

    // Check size
    if (__vr.getFieldErrorCount(FILENAME) == 0) {
      java.lang.String __filename = __target__.getFileName();
      if (__filename!= null && __filename.length() > 2147483647) {
        __vr.rejectValue(FILENAME, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(FILENAME)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(2147483647)));
      }
    }

    if (__vr.getFieldErrorCount(ERRORS) == 0) {
      java.lang.String __errors = __target__.getErrors();
      if (__errors!= null && __errors.length() > 2147483647) {
        __vr.rejectValue(ERRORS, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ERRORS)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(2147483647)));
      }
    }

    if (__vr.getFieldErrorCount(REDHATJARSTOMODULES) == 0) {
      java.lang.String __redhatjarstomodules = __target__.getRedhatJarsToModules();
      if (__redhatjarstomodules!= null && __redhatjarstomodules.length() > 2147483647) {
        __vr.rejectValue(REDHATJARSTOMODULES, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(REDHATJARSTOMODULES)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(2147483647)));
      }
    }

    if (__vr.getFieldErrorCount(JBOSSDEPLOYMENTSTRUCTURE) == 0) {
      java.lang.String __jbossdeploymentstructure = __target__.getJbossDeploymentStructure();
      if (__jbossdeploymentstructure!= null && __jbossdeploymentstructure.length() > 2147483647) {
        __vr.rejectValue(JBOSSDEPLOYMENTSTRUCTURE, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(JBOSSDEPLOYMENTSTRUCTURE)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(2147483647)));
      }
    }

    if (__vr.getFieldErrorCount(POTENCIALCANVIDEJARAMODUL) == 0) {
      java.lang.String __potencialcanvidejaramodul = __target__.getPotencialCanviDeJarAModul();
      if (__potencialcanvidejaramodul!= null && __potencialcanvidejaramodul.length() > 2147483647) {
        __vr.rejectValue(POTENCIALCANVIDEJARAMODUL, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(POTENCIALCANVIDEJARAMODUL)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(2147483647)));
      }
    }

    if (__isNou__) { // Creació
      // ================ CREATION
      // Fitxers 
      // ====== Check Unique MULTIPLES - NOU =======

      // Check Unique - no PK
      // Check Unique - PK no AutoIncrement amb UNA SOLA PK 
    } else {
      // ================ UPDATE

      // ====== Check Unique MULTIPLES - EDIT  =======

      // Check Unique - no PK
    }

    // Fields with References to Other tables 
    if (__vr.getFieldErrorCount(EARID) == 0) {
      java.lang.Long __earid = __target__.getEarID();
      Long __count_ = null;
      try { __count_ = __earManager.count(EarFields.EARID.equal(__earid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
      if (__count_ == null || __count_ == 0) {        
        __vr.rejectValue(EARID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("ear.ear"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("ear.earID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__earid)));
      }
    }

  } // Final de mètode
  public String get(Field<?> field) {
    return field.fullName;
  }
  
}
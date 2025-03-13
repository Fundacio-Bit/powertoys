package org.fundaciobit.powertoys.persistence.validator;

import org.apache.log4j.Logger;

import org.fundaciobit.powertoys.model.entity.Compilacio;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.powertoys.model.fields.CompilacioFields;
import org.fundaciobit.powertoys.model.fields.RepoCompilacioFields;

import org.fundaciobit.genapp.common.validation.IValidatorResult;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class CompilacioValidator<I extends Compilacio>
    extends org.fundaciobit.genapp.common.validation.AbstractValidator    implements CompilacioFields {

    protected final Logger log = Logger.getLogger(getClass());


  public CompilacioValidator() {
    super();    
  }
  

  /** Constructor */
  public void validate(IValidatorResult<I> __vr,I __target__, boolean __isNou__
    ,org.fundaciobit.powertoys.model.dao.ICompilacioManager __compilacioManager
    ,org.fundaciobit.powertoys.model.dao.IRepoCompilacioManager __repoCompilacioManager) {

    // Valors Not Null
    __vr.rejectIfEmptyOrWhitespace(__target__,REPOCOMPILACIOID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(REPOCOMPILACIOID)));

    __vr.rejectIfEmptyOrWhitespace(__target__,TAGURL, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(TAGURL)));

    __vr.rejectIfEmptyOrWhitespace(__target__,DATAINICI, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(DATAINICI)));

    __vr.rejectIfEmptyOrWhitespace(__target__,DATAFI, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(DATAFI)));

    __vr.rejectIfEmptyOrWhitespace(__target__,EXITCODE, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(EXITCODE)));

    // Check size
    if (__vr.getFieldErrorCount(TAGURL) == 0) {
      java.lang.String __tagurl = __target__.getTagUrl();
      if (__tagurl!= null && __tagurl.length() > 255) {
        __vr.rejectValue(TAGURL, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(TAGURL)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(OUTPUT) == 0) {
      java.lang.String __output = __target__.getOutput();
      if (__output!= null && __output.length() > 2147483647) {
        __vr.rejectValue(OUTPUT, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(OUTPUT)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(2147483647)));
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
    if (__vr.getFieldErrorCount(REPOCOMPILACIOID) == 0) {
      java.lang.Long __repocompilacioid = __target__.getRepocompilacioID();
      Long __count_ = null;
      try { __count_ = __repoCompilacioManager.count(RepoCompilacioFields.REPOCOMPILACIOID.equal(__repocompilacioid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
      if (__count_ == null || __count_ == 0) {        
        __vr.rejectValue(REPOCOMPILACIOID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("repoCompilacio.repoCompilacio"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("repoCompilacio.repocompilacioID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__repocompilacioid)));
      }
    }

  } // Final de mètode
  public String get(Field<?> field) {
    return field.fullName;
  }
  
}
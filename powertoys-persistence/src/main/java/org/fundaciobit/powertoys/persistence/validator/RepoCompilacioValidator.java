package org.fundaciobit.powertoys.persistence.validator;

import org.apache.log4j.Logger;

import org.fundaciobit.powertoys.model.entity.RepoCompilacio;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.powertoys.model.fields.RepoCompilacioFields;

import org.fundaciobit.genapp.common.validation.IValidatorResult;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class RepoCompilacioValidator<I extends RepoCompilacio>
    extends org.fundaciobit.genapp.common.validation.AbstractValidator    implements RepoCompilacioFields {

    protected final Logger log = Logger.getLogger(getClass());


  public RepoCompilacioValidator() {
    super();    
  }
  

  /** Constructor */
  public void validate(IValidatorResult<I> __vr,I __target__, boolean __isNou__
    ,org.fundaciobit.powertoys.model.dao.IRepoCompilacioManager __repoCompilacioManager) {

    // Valors Not Null
    __vr.rejectIfEmptyOrWhitespace(__target__,NOM, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOM)));

    __vr.rejectIfEmptyOrWhitespace(__target__,ORGANITZACIOGITHUB, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ORGANITZACIOGITHUB)));

    __vr.rejectIfEmptyOrWhitespace(__target__,REPOSITORIGITHUB, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(REPOSITORIGITHUB)));

    __vr.rejectIfEmptyOrWhitespace(__target__,ACTIU, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ACTIU)));

    // Check size
    if (__vr.getFieldErrorCount(NOM) == 0) {
      java.lang.String __nom = __target__.getNom();
      if (__nom!= null && __nom.length() > 255) {
        __vr.rejectValue(NOM, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOM)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(ORGANITZACIOGITHUB) == 0) {
      java.lang.String __organitzaciogithub = __target__.getOrganitzacioGitHub();
      if (__organitzaciogithub!= null && __organitzaciogithub.length() > 255) {
        __vr.rejectValue(ORGANITZACIOGITHUB, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ORGANITZACIOGITHUB)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(REPOSITORIGITHUB) == 0) {
      java.lang.String __repositorigithub = __target__.getRepositoriGitHub();
      if (__repositorigithub!= null && __repositorigithub.length() > 255) {
        __vr.rejectValue(REPOSITORIGITHUB, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(REPOSITORIGITHUB)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
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
  } // Final de mètode
  public String get(Field<?> field) {
    return field.fullName;
  }
  
}
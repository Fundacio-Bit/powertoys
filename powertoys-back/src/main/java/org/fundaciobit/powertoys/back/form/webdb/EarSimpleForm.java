package org.fundaciobit.powertoys.back.form.webdb;

import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.fundaciobit.powertoys.back.form.powertoysBaseForm;
import org.fundaciobit.powertoys.persistence.EarSimpleJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class EarSimpleForm extends powertoysBaseForm {
  
  private EarSimpleJPA earSimple;
  
  
  private CommonsMultipartFile fitxerID;
  private boolean fitxerIDDelete;
  
  public EarSimpleForm() {
  }
  
  public EarSimpleForm(EarSimpleForm __toClone) {
    super(__toClone);
      this.earSimple = __toClone.earSimple;
  }
  
  public EarSimpleForm(EarSimpleJPA earSimple, boolean nou) {
    super(nou);
    this.earSimple = earSimple;
  }
  
  public EarSimpleJPA getEarSimple() {
    return earSimple;
  }
  public void setEarSimple(EarSimpleJPA earSimple) {
    this.earSimple = earSimple;
  }
  
  
  public CommonsMultipartFile getFitxerID() {
    return fitxerID;
  }
  
   public void setFitxerID(CommonsMultipartFile fitxerID) {
    this.fitxerID = fitxerID;
  }
  public boolean isFitxerIDDelete() {
    return fitxerIDDelete;
  }
  
  public void setFitxerIDDelete(boolean fitxerIDDelete) {
    this.fitxerIDDelete = fitxerIDDelete;
   }
  
} // Final de Classe 

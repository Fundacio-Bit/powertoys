package org.fundaciobit.powertoys.back.form.webdb;

import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.fundaciobit.powertoys.back.form.PowerToysBaseForm;
import org.fundaciobit.powertoys.persistence.EarJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class EarForm extends PowerToysBaseForm {
  
  private EarJPA ear;
  
  
  private CommonsMultipartFile fitxerID;
  private boolean fitxerIDDelete;
  
  public EarForm() {
  }
  
  public EarForm(EarForm __toClone) {
    super(__toClone);
      this.ear = __toClone.ear;
  }
  
  public EarForm(EarJPA ear, boolean nou) {
    super(nou);
    this.ear = ear;
  }
  
  public EarJPA getEar() {
    return ear;
  }
  public void setEar(EarJPA ear) {
    this.ear = ear;
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

package org.fundaciobit.powertoys.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
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
    this.listOfValuesForJbossVersion = __toClone.listOfValuesForJbossVersion;
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
  private List<StringKeyValue> listOfValuesForJbossVersion;

  public List<StringKeyValue> getListOfValuesForJbossVersion() {
    return this.listOfValuesForJbossVersion;
  }

  public void setListOfValuesForJbossVersion(List<StringKeyValue> listOfValuesForJbossVersion) {
    this.listOfValuesForJbossVersion = listOfValuesForJbossVersion;
  }



  
} // Final de Classe 

package org.fundaciobit.powertoys.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.powertoys.back.form.PowerToysBaseForm;
import org.fundaciobit.powertoys.persistence.EarInfoJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class EarInfoForm extends PowerToysBaseForm {
  
  private EarInfoJPA earInfo;
  
  public EarInfoForm() {
  }
  
  public EarInfoForm(EarInfoForm __toClone) {
    super(__toClone);
      this.earInfo = __toClone.earInfo;
    this.listOfEarForEarID = __toClone.listOfEarForEarID;
  }
  
  public EarInfoForm(EarInfoJPA earInfo, boolean nou) {
    super(nou);
    this.earInfo = earInfo;
  }
  
  public EarInfoJPA getEarInfo() {
    return earInfo;
  }
  public void setEarInfo(EarInfoJPA earInfo) {
    this.earInfo = earInfo;
  }
  
  
  private List<StringKeyValue> listOfEarForEarID;

  public List<StringKeyValue> getListOfEarForEarID() {
    return this.listOfEarForEarID;
  }

  public void setListOfEarForEarID(List<StringKeyValue> listOfEarForEarID) {
    this.listOfEarForEarID = listOfEarForEarID;
  }



  
} // Final de Classe 

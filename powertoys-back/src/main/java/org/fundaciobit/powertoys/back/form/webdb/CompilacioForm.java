package org.fundaciobit.powertoys.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.powertoys.back.form.PowerToysBaseForm;
import org.fundaciobit.powertoys.persistence.CompilacioJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class CompilacioForm extends PowerToysBaseForm {
  
  private CompilacioJPA compilacio;
  
  public CompilacioForm() {
  }
  
  public CompilacioForm(CompilacioForm __toClone) {
    super(__toClone);
      this.compilacio = __toClone.compilacio;
    this.listOfRepoCompilacioForRepocompilacioID = __toClone.listOfRepoCompilacioForRepocompilacioID;
  }
  
  public CompilacioForm(CompilacioJPA compilacio, boolean nou) {
    super(nou);
    this.compilacio = compilacio;
  }
  
  public CompilacioJPA getCompilacio() {
    return compilacio;
  }
  public void setCompilacio(CompilacioJPA compilacio) {
    this.compilacio = compilacio;
  }
  
  
  private List<StringKeyValue> listOfRepoCompilacioForRepocompilacioID;

  public List<StringKeyValue> getListOfRepoCompilacioForRepocompilacioID() {
    return this.listOfRepoCompilacioForRepocompilacioID;
  }

  public void setListOfRepoCompilacioForRepocompilacioID(List<StringKeyValue> listOfRepoCompilacioForRepocompilacioID) {
    this.listOfRepoCompilacioForRepocompilacioID = listOfRepoCompilacioForRepocompilacioID;
  }



  
} // Final de Classe 

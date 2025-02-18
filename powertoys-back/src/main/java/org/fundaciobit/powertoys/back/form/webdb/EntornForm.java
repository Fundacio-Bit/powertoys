package org.fundaciobit.powertoys.back.form.webdb;

import org.fundaciobit.powertoys.back.form.PowerToysBaseForm;
import org.fundaciobit.powertoys.persistence.EntornJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class EntornForm extends PowerToysBaseForm {
  
  private EntornJPA entorn;
  
  public EntornForm() {
  }
  
  public EntornForm(EntornForm __toClone) {
    super(__toClone);
      this.entorn = __toClone.entorn;
  }
  
  public EntornForm(EntornJPA entorn, boolean nou) {
    super(nou);
    this.entorn = entorn;
  }
  
  public EntornJPA getEntorn() {
    return entorn;
  }
  public void setEntorn(EntornJPA entorn) {
    this.entorn = entorn;
  }
  
  
  
} // Final de Classe 

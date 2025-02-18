package org.fundaciobit.powertoys.back.form.webdb;

import org.fundaciobit.powertoys.back.form.PowerToysBaseForm;
import org.fundaciobit.powertoys.persistence.AplicacioJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class AplicacioForm extends PowerToysBaseForm {
  
  private AplicacioJPA aplicacio;
  
  public AplicacioForm() {
  }
  
  public AplicacioForm(AplicacioForm __toClone) {
    super(__toClone);
      this.aplicacio = __toClone.aplicacio;
  }
  
  public AplicacioForm(AplicacioJPA aplicacio, boolean nou) {
    super(nou);
    this.aplicacio = aplicacio;
  }
  
  public AplicacioJPA getAplicacio() {
    return aplicacio;
  }
  public void setAplicacio(AplicacioJPA aplicacio) {
    this.aplicacio = aplicacio;
  }
  
  
  
} // Final de Classe 

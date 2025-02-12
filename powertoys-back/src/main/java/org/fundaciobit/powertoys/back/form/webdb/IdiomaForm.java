package org.fundaciobit.powertoys.back.form.webdb;

import org.fundaciobit.powertoys.back.form.PowerToysBaseForm;
import org.fundaciobit.powertoys.persistence.IdiomaJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class IdiomaForm extends PowerToysBaseForm {
  
  private IdiomaJPA idioma;
  
  public IdiomaForm() {
  }
  
  public IdiomaForm(IdiomaForm __toClone) {
    super(__toClone);
      this.idioma = __toClone.idioma;
  }
  
  public IdiomaForm(IdiomaJPA idioma, boolean nou) {
    super(nou);
    this.idioma = idioma;
  }
  
  public IdiomaJPA getIdioma() {
    return idioma;
  }
  public void setIdioma(IdiomaJPA idioma) {
    this.idioma = idioma;
  }
  
  
  
} // Final de Classe 

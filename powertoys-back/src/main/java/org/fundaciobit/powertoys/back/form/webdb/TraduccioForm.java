package org.fundaciobit.powertoys.back.form.webdb;

import org.fundaciobit.powertoys.back.form.powertoysBaseForm;
import org.fundaciobit.powertoys.persistence.TraduccioJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class TraduccioForm extends powertoysBaseForm {
  
  private TraduccioJPA traduccio;
  
  public TraduccioForm() {
  }
  
  public TraduccioForm(TraduccioForm __toClone) {
    super(__toClone);
      this.traduccio = __toClone.traduccio;
  }
  
  public TraduccioForm(TraduccioJPA traduccio, boolean nou) {
    super(nou);
    this.traduccio = traduccio;
  }
  
  public TraduccioJPA getTraduccio() {
    return traduccio;
  }
  public void setTraduccio(TraduccioJPA traduccio) {
    this.traduccio = traduccio;
  }
  
  
  
} // Final de Classe 

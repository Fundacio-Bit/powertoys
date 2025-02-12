
package org.fundaciobit.powertoys.back.form.webdb;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.powertoys.back.form.PowerToysBaseFilterForm;

import org.fundaciobit.powertoys.model.fields.EarFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class EarFilterForm extends PowerToysBaseFilterForm implements EarFields {

  private java.lang.Long earIDDesde;

  public java.lang.Long getEarIDDesde() {
    return this.earIDDesde;
  }

  public void setEarIDDesde(java.lang.Long earIDDesde) {
    this.earIDDesde = earIDDesde;
  }


  private java.lang.Long earIDFins;

  public java.lang.Long getEarIDFins() {
    return this.earIDFins;
  }

  public void setEarIDFins(java.lang.Long earIDFins) {
    this.earIDFins = earIDFins;
  }


  public EarFilterForm() {
  }
  
  public EarFilterForm(EarFilterForm __toClone) {
    super(__toClone);
    this.earIDDesde = __toClone.earIDDesde;
    this.earIDFins = __toClone.earIDFins;
  }
  
  /* ========= UTILS ========== */

  @Override
  public List<Field<?>> getDefaultFilterByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] {  }));
  }

  @Override
  public List<Field<?>> getDefaultGroupByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] {  }));
  }


  protected OrderBy[] defaultOrderBy = null;


  public OrderBy[] getDefaultOrderBy() {
    return this.defaultOrderBy;
  }

  public void setDefaultOrderBy(OrderBy[] defOrderBy) {
    this.defaultOrderBy = defOrderBy;
  }

  @Override
  public String getTableModelName() {
    return _TABLE_MODEL;
  }

   // -----------------------
   // Maps de referencies.
   // -----------------------

   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}

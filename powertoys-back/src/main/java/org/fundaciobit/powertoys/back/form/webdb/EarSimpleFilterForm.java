
package org.fundaciobit.powertoys.back.form.webdb;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.powertoys.back.form.PowerToysBaseFilterForm;

import org.fundaciobit.powertoys.model.fields.EarSimpleFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class EarSimpleFilterForm extends PowerToysBaseFilterForm implements EarSimpleFields {

  private java.lang.Long earSimpleIDDesde;

  public java.lang.Long getEarSimpleIDDesde() {
    return this.earSimpleIDDesde;
  }

  public void setEarSimpleIDDesde(java.lang.Long earSimpleIDDesde) {
    this.earSimpleIDDesde = earSimpleIDDesde;
  }


  private java.lang.Long earSimpleIDFins;

  public java.lang.Long getEarSimpleIDFins() {
    return this.earSimpleIDFins;
  }

  public void setEarSimpleIDFins(java.lang.Long earSimpleIDFins) {
    this.earSimpleIDFins = earSimpleIDFins;
  }


  private java.lang.String nom;

  public java.lang.String getNom() {
    return this.nom;
  }

  public void setNom(java.lang.String nom) {
    this.nom = nom;
  }


  private java.lang.String detall;

  public java.lang.String getDetall() {
    return this.detall;
  }

  public void setDetall(java.lang.String detall) {
    this.detall = detall;
  }


  private java.sql.Timestamp dataDesde;

  public java.sql.Timestamp getDataDesde() {
    return this.dataDesde;
  }

  public void setDataDesde(java.sql.Timestamp dataDesde) {
    this.dataDesde = dataDesde;
  }


  private java.sql.Timestamp dataFins;

  public java.sql.Timestamp getDataFins() {
    return this.dataFins;
  }

  public void setDataFins(java.sql.Timestamp dataFins) {
    this.dataFins = dataFins;
  }


  public EarSimpleFilterForm() {
  }
  
  public EarSimpleFilterForm(EarSimpleFilterForm __toClone) {
    super(__toClone);
    this.earSimpleIDDesde = __toClone.earSimpleIDDesde;
    this.earSimpleIDFins = __toClone.earSimpleIDFins;
    this.nom = __toClone.nom;
    this.detall = __toClone.detall;
    this.dataDesde = __toClone.dataDesde;
    this.dataFins = __toClone.dataFins;
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

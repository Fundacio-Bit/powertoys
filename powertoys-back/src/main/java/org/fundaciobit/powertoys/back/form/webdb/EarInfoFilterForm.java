
package org.fundaciobit.powertoys.back.form.webdb;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.powertoys.back.form.powertoysBaseFilterForm;

import org.fundaciobit.powertoys.model.fields.EarInfoFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class EarInfoFilterForm extends powertoysBaseFilterForm implements EarInfoFields {

  private java.lang.Long earinfoIDDesde;

  public java.lang.Long getEarinfoIDDesde() {
    return this.earinfoIDDesde;
  }

  public void setEarinfoIDDesde(java.lang.Long earinfoIDDesde) {
    this.earinfoIDDesde = earinfoIDDesde;
  }


  private java.lang.Long earinfoIDFins;

  public java.lang.Long getEarinfoIDFins() {
    return this.earinfoIDFins;
  }

  public void setEarinfoIDFins(java.lang.Long earinfoIDFins) {
    this.earinfoIDFins = earinfoIDFins;
  }


  private java.lang.Long earidDesde;

  public java.lang.Long getEaridDesde() {
    return this.earidDesde;
  }

  public void setEaridDesde(java.lang.Long earidDesde) {
    this.earidDesde = earidDesde;
  }


  private java.lang.Long earidFins;

  public java.lang.Long getEaridFins() {
    return this.earidFins;
  }

  public void setEaridFins(java.lang.Long earidFins) {
    this.earidFins = earidFins;
  }


  private java.lang.String fileName;

  public java.lang.String getFileName() {
    return this.fileName;
  }

  public void setFileName(java.lang.String fileName) {
    this.fileName = fileName;
  }


  private java.lang.String errors;

  public java.lang.String getErrors() {
    return this.errors;
  }

  public void setErrors(java.lang.String errors) {
    this.errors = errors;
  }


  private java.lang.String redhatJarsToModules;

  public java.lang.String getRedhatJarsToModules() {
    return this.redhatJarsToModules;
  }

  public void setRedhatJarsToModules(java.lang.String redhatJarsToModules) {
    this.redhatJarsToModules = redhatJarsToModules;
  }


  private java.lang.String jbossDeploymentStructure;

  public java.lang.String getJbossDeploymentStructure() {
    return this.jbossDeploymentStructure;
  }

  public void setJbossDeploymentStructure(java.lang.String jbossDeploymentStructure) {
    this.jbossDeploymentStructure = jbossDeploymentStructure;
  }


  private java.lang.String potencialCanviDeJarAModul;

  public java.lang.String getPotencialCanviDeJarAModul() {
    return this.potencialCanviDeJarAModul;
  }

  public void setPotencialCanviDeJarAModul(java.lang.String potencialCanviDeJarAModul) {
    this.potencialCanviDeJarAModul = potencialCanviDeJarAModul;
  }


  public EarInfoFilterForm() {
  }
  
  public EarInfoFilterForm(EarInfoFilterForm __toClone) {
    super(__toClone);
    this.earinfoIDDesde = __toClone.earinfoIDDesde;
    this.earinfoIDFins = __toClone.earinfoIDFins;
    this.earidDesde = __toClone.earidDesde;
    this.earidFins = __toClone.earidFins;
    this.fileName = __toClone.fileName;
    this.errors = __toClone.errors;
    this.redhatJarsToModules = __toClone.redhatJarsToModules;
    this.jbossDeploymentStructure = __toClone.jbossDeploymentStructure;
    this.potencialCanviDeJarAModul = __toClone.potencialCanviDeJarAModul;
    this.mapOfEarForEarid = __toClone.mapOfEarForEarid;
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
  private Map<String, String> mapOfEarForEarid;

  public Map<String, String> getMapOfEarForEarid() {
    return this.mapOfEarForEarid;
  }

  public void setMapOfEarForEarid(Map<String, String> mapOfEarForEarid) {
    this.mapOfEarForEarid = mapOfEarForEarid;
  }




   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}

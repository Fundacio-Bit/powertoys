
package org.fundaciobit.powertoys.back.form.webdb;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.powertoys.back.form.PowerToysBaseFilterForm;

import org.fundaciobit.powertoys.model.fields.CompilacioFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class CompilacioFilterForm extends PowerToysBaseFilterForm implements CompilacioFields {

  private java.lang.Long compilacioIDDesde;

  public java.lang.Long getCompilacioIDDesde() {
    return this.compilacioIDDesde;
  }

  public void setCompilacioIDDesde(java.lang.Long compilacioIDDesde) {
    this.compilacioIDDesde = compilacioIDDesde;
  }


  private java.lang.Long compilacioIDFins;

  public java.lang.Long getCompilacioIDFins() {
    return this.compilacioIDFins;
  }

  public void setCompilacioIDFins(java.lang.Long compilacioIDFins) {
    this.compilacioIDFins = compilacioIDFins;
  }


  private java.lang.Long repocompilacioIDDesde;

  public java.lang.Long getRepocompilacioIDDesde() {
    return this.repocompilacioIDDesde;
  }

  public void setRepocompilacioIDDesde(java.lang.Long repocompilacioIDDesde) {
    this.repocompilacioIDDesde = repocompilacioIDDesde;
  }


  private java.lang.Long repocompilacioIDFins;

  public java.lang.Long getRepocompilacioIDFins() {
    return this.repocompilacioIDFins;
  }

  public void setRepocompilacioIDFins(java.lang.Long repocompilacioIDFins) {
    this.repocompilacioIDFins = repocompilacioIDFins;
  }


  private java.lang.String tagUrl;

  public java.lang.String getTagUrl() {
    return this.tagUrl;
  }

  public void setTagUrl(java.lang.String tagUrl) {
    this.tagUrl = tagUrl;
  }


  private java.sql.Timestamp dataIniciDesde;

  public java.sql.Timestamp getDataIniciDesde() {
    return this.dataIniciDesde;
  }

  public void setDataIniciDesde(java.sql.Timestamp dataIniciDesde) {
    this.dataIniciDesde = dataIniciDesde;
  }


  private java.sql.Timestamp dataIniciFins;

  public java.sql.Timestamp getDataIniciFins() {
    return this.dataIniciFins;
  }

  public void setDataIniciFins(java.sql.Timestamp dataIniciFins) {
    this.dataIniciFins = dataIniciFins;
  }


  private java.sql.Timestamp dataFiDesde;

  public java.sql.Timestamp getDataFiDesde() {
    return this.dataFiDesde;
  }

  public void setDataFiDesde(java.sql.Timestamp dataFiDesde) {
    this.dataFiDesde = dataFiDesde;
  }


  private java.sql.Timestamp dataFiFins;

  public java.sql.Timestamp getDataFiFins() {
    return this.dataFiFins;
  }

  public void setDataFiFins(java.sql.Timestamp dataFiFins) {
    this.dataFiFins = dataFiFins;
  }


  private java.lang.Short exitCodeDesde;

  public java.lang.Short getExitCodeDesde() {
    return this.exitCodeDesde;
  }

  public void setExitCodeDesde(java.lang.Short exitCodeDesde) {
    this.exitCodeDesde = exitCodeDesde;
  }


  private java.lang.Short exitCodeFins;

  public java.lang.Short getExitCodeFins() {
    return this.exitCodeFins;
  }

  public void setExitCodeFins(java.lang.Short exitCodeFins) {
    this.exitCodeFins = exitCodeFins;
  }


  private java.lang.String output;

  public java.lang.String getOutput() {
    return this.output;
  }

  public void setOutput(java.lang.String output) {
    this.output = output;
  }


  public CompilacioFilterForm() {
  }
  
  public CompilacioFilterForm(CompilacioFilterForm __toClone) {
    super(__toClone);
    this.compilacioIDDesde = __toClone.compilacioIDDesde;
    this.compilacioIDFins = __toClone.compilacioIDFins;
    this.repocompilacioIDDesde = __toClone.repocompilacioIDDesde;
    this.repocompilacioIDFins = __toClone.repocompilacioIDFins;
    this.tagUrl = __toClone.tagUrl;
    this.dataIniciDesde = __toClone.dataIniciDesde;
    this.dataIniciFins = __toClone.dataIniciFins;
    this.dataFiDesde = __toClone.dataFiDesde;
    this.dataFiFins = __toClone.dataFiFins;
    this.exitCodeDesde = __toClone.exitCodeDesde;
    this.exitCodeFins = __toClone.exitCodeFins;
    this.output = __toClone.output;
    this.mapOfRepoCompilacioForRepocompilacioID = __toClone.mapOfRepoCompilacioForRepocompilacioID;
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
  private Map<String, String> mapOfRepoCompilacioForRepocompilacioID;

  public Map<String, String> getMapOfRepoCompilacioForRepocompilacioID() {
    return this.mapOfRepoCompilacioForRepocompilacioID;
  }

  public void setMapOfRepoCompilacioForRepocompilacioID(Map<String, String> mapOfRepoCompilacioForRepocompilacioID) {
    this.mapOfRepoCompilacioForRepocompilacioID = mapOfRepoCompilacioForRepocompilacioID;
  }




   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}

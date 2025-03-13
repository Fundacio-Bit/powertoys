
package org.fundaciobit.powertoys.back.form.webdb;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.powertoys.back.form.PowerToysBaseFilterForm;

import org.fundaciobit.powertoys.model.fields.RepoCompilacioFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class RepoCompilacioFilterForm extends PowerToysBaseFilterForm implements RepoCompilacioFields {

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


  private java.lang.String nom;

  public java.lang.String getNom() {
    return this.nom;
  }

  public void setNom(java.lang.String nom) {
    this.nom = nom;
  }


  private java.lang.String organitzacioGitHub;

  public java.lang.String getOrganitzacioGitHub() {
    return this.organitzacioGitHub;
  }

  public void setOrganitzacioGitHub(java.lang.String organitzacioGitHub) {
    this.organitzacioGitHub = organitzacioGitHub;
  }


  private java.lang.String repositoriGitHub;

  public java.lang.String getRepositoriGitHub() {
    return this.repositoriGitHub;
  }

  public void setRepositoriGitHub(java.lang.String repositoriGitHub) {
    this.repositoriGitHub = repositoriGitHub;
  }


  private java.lang.Long ordreDesde;

  public java.lang.Long getOrdreDesde() {
    return this.ordreDesde;
  }

  public void setOrdreDesde(java.lang.Long ordreDesde) {
    this.ordreDesde = ordreDesde;
  }


  private java.lang.Long ordreFins;

  public java.lang.Long getOrdreFins() {
    return this.ordreFins;
  }

  public void setOrdreFins(java.lang.Long ordreFins) {
    this.ordreFins = ordreFins;
  }


  public RepoCompilacioFilterForm() {
  }
  
  public RepoCompilacioFilterForm(RepoCompilacioFilterForm __toClone) {
    super(__toClone);
    this.repocompilacioIDDesde = __toClone.repocompilacioIDDesde;
    this.repocompilacioIDFins = __toClone.repocompilacioIDFins;
    this.nom = __toClone.nom;
    this.organitzacioGitHub = __toClone.organitzacioGitHub;
    this.repositoriGitHub = __toClone.repositoriGitHub;
    this.ordreDesde = __toClone.ordreDesde;
    this.ordreFins = __toClone.ordreFins;
    this.mapOfValuesForOrganitzacioGitHub = __toClone.mapOfValuesForOrganitzacioGitHub;
    this.mapOfValuesForRepositoriGitHub = __toClone.mapOfValuesForRepositoriGitHub;
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
  private Map<String, String> mapOfValuesForOrganitzacioGitHub;

  public Map<String, String> getMapOfValuesForOrganitzacioGitHub() {
    return this.mapOfValuesForOrganitzacioGitHub;
  }

  public void setMapOfValuesForOrganitzacioGitHub(Map<String, String> mapOfValuesForOrganitzacioGitHub) {
    this.mapOfValuesForOrganitzacioGitHub = mapOfValuesForOrganitzacioGitHub;
  }



  private Map<String, String> mapOfValuesForRepositoriGitHub;

  public Map<String, String> getMapOfValuesForRepositoriGitHub() {
    return this.mapOfValuesForRepositoriGitHub;
  }

  public void setMapOfValuesForRepositoriGitHub(Map<String, String> mapOfValuesForRepositoriGitHub) {
    this.mapOfValuesForRepositoriGitHub = mapOfValuesForRepositoriGitHub;
  }




   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}

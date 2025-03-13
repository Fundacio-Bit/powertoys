package org.fundaciobit.powertoys.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.powertoys.back.form.PowerToysBaseForm;
import org.fundaciobit.powertoys.persistence.RepoCompilacioJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class RepoCompilacioForm extends PowerToysBaseForm {
  
  private RepoCompilacioJPA repoCompilacio;
  
  public RepoCompilacioForm() {
  }
  
  public RepoCompilacioForm(RepoCompilacioForm __toClone) {
    super(__toClone);
      this.repoCompilacio = __toClone.repoCompilacio;
    this.listOfValuesForOrganitzacioGitHub = __toClone.listOfValuesForOrganitzacioGitHub;
    this.listOfValuesForRepositoriGitHub = __toClone.listOfValuesForRepositoriGitHub;
  }
  
  public RepoCompilacioForm(RepoCompilacioJPA repoCompilacio, boolean nou) {
    super(nou);
    this.repoCompilacio = repoCompilacio;
  }
  
  public RepoCompilacioJPA getRepoCompilacio() {
    return repoCompilacio;
  }
  public void setRepoCompilacio(RepoCompilacioJPA repoCompilacio) {
    this.repoCompilacio = repoCompilacio;
  }
  
  
  private List<StringKeyValue> listOfValuesForOrganitzacioGitHub;

  public List<StringKeyValue> getListOfValuesForOrganitzacioGitHub() {
    return this.listOfValuesForOrganitzacioGitHub;
  }

  public void setListOfValuesForOrganitzacioGitHub(List<StringKeyValue> listOfValuesForOrganitzacioGitHub) {
    this.listOfValuesForOrganitzacioGitHub = listOfValuesForOrganitzacioGitHub;
  }



  private List<StringKeyValue> listOfValuesForRepositoriGitHub;

  public List<StringKeyValue> getListOfValuesForRepositoriGitHub() {
    return this.listOfValuesForRepositoriGitHub;
  }

  public void setListOfValuesForRepositoriGitHub(List<StringKeyValue> listOfValuesForRepositoriGitHub) {
    this.listOfValuesForRepositoriGitHub = listOfValuesForRepositoriGitHub;
  }



  
} // Final de Classe 

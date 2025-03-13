
package org.fundaciobit.powertoys.model.bean;

import org.fundaciobit.powertoys.model.entity.RepoCompilacio;


public class RepoCompilacioBean implements RepoCompilacio {



	long repocompilacioID;// PK
	java.lang.String nom;
	java.lang.String organitzacioGitHub;
	java.lang.String repositoriGitHub;
	java.lang.Long ordre;
	boolean actiu;


  /** Constructor Buit */
  public RepoCompilacioBean() {
  }

  /** Constructor amb tots els camps  */
  public RepoCompilacioBean(long repocompilacioID , java.lang.String nom , java.lang.String organitzacioGitHub , java.lang.String repositoriGitHub , java.lang.Long ordre , boolean actiu) {
    this.repocompilacioID=repocompilacioID;
    this.nom=nom;
    this.organitzacioGitHub=organitzacioGitHub;
    this.repositoriGitHub=repositoriGitHub;
    this.ordre=ordre;
    this.actiu=actiu;
}
  /** Constructor sense valors autoincrementals */
  public RepoCompilacioBean(java.lang.String nom , java.lang.String organitzacioGitHub , java.lang.String repositoriGitHub , java.lang.Long ordre , boolean actiu) {
    this.nom=nom;
    this.organitzacioGitHub=organitzacioGitHub;
    this.repositoriGitHub=repositoriGitHub;
    this.ordre=ordre;
    this.actiu=actiu;
}
  public RepoCompilacioBean(RepoCompilacio __bean) {
    this.setRepocompilacioID(__bean.getRepocompilacioID());
    this.setNom(__bean.getNom());
    this.setOrganitzacioGitHub(__bean.getOrganitzacioGitHub());
    this.setRepositoriGitHub(__bean.getRepositoriGitHub());
    this.setOrdre(__bean.getOrdre());
    this.setActiu(__bean.isActiu());
	}

	public long getRepocompilacioID() {
		return(repocompilacioID);
	};
	public void setRepocompilacioID(long _repocompilacioID_) {
		this.repocompilacioID = _repocompilacioID_;
	};

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
	};

	public java.lang.String getOrganitzacioGitHub() {
		return(organitzacioGitHub);
	};
	public void setOrganitzacioGitHub(java.lang.String _organitzacioGitHub_) {
		this.organitzacioGitHub = _organitzacioGitHub_;
	};

	public java.lang.String getRepositoriGitHub() {
		return(repositoriGitHub);
	};
	public void setRepositoriGitHub(java.lang.String _repositoriGitHub_) {
		this.repositoriGitHub = _repositoriGitHub_;
	};

	public java.lang.Long getOrdre() {
		return(ordre);
	};
	public void setOrdre(java.lang.Long _ordre_) {
		this.ordre = _ordre_;
	};

	public boolean isActiu() {
		return(actiu);
	};
	public void setActiu(boolean _actiu_) {
		this.actiu = _actiu_;
	};



  // ======================================

  public static RepoCompilacioBean toBean(RepoCompilacio __bean) {
    if (__bean == null) { return null;}
    RepoCompilacioBean __tmp = new RepoCompilacioBean();
    __tmp.setRepocompilacioID(__bean.getRepocompilacioID());
    __tmp.setNom(__bean.getNom());
    __tmp.setOrganitzacioGitHub(__bean.getOrganitzacioGitHub());
    __tmp.setRepositoriGitHub(__bean.getRepositoriGitHub());
    __tmp.setOrdre(__bean.getOrdre());
    __tmp.setActiu(__bean.isActiu());
		return __tmp;
	}



}

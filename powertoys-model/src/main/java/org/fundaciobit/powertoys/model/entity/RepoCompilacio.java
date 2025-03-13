package org.fundaciobit.powertoys.model.entity;

public interface RepoCompilacio extends org.fundaciobit.genapp.common.IGenAppEntity {

	public long getRepocompilacioID();
	public void setRepocompilacioID(long _repocompilacioID_);

	public java.lang.String getNom();
	public void setNom(java.lang.String _nom_);

	public java.lang.String getOrganitzacioGitHub();
	public void setOrganitzacioGitHub(java.lang.String _organitzacioGitHub_);

	public java.lang.String getRepositoriGitHub();
	public void setRepositoriGitHub(java.lang.String _repositoriGitHub_);

	public java.lang.Long getOrdre();
	public void setOrdre(java.lang.Long _ordre_);

	public boolean isActiu();
	public void setActiu(boolean _actiu_);



  // ======================================

}

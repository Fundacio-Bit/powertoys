package org.fundaciobit.powertoys.model.entity;

public interface EarSimple extends org.fundaciobit.genapp.common.IGenAppEntity {

	public long getEarSimpleID();
	public void setEarSimpleID(long _earSimpleID_);

	public long getFitxerID();
	public void setFitxerID(long _fitxerID_);

	public java.lang.String getNom();
	public void setNom(java.lang.String _nom_);

	public java.lang.String getDetall();
	public void setDetall(java.lang.String _detall_);

	public java.sql.Timestamp getData();
	public void setData(java.sql.Timestamp _data_);

  // Fitxer
  public <F extends Fitxer> F getFitxer();


  // ======================================

}

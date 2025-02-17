package org.fundaciobit.powertoys.model.entity;

public interface Ear extends org.fundaciobit.genapp.common.IGenAppEntity {

	public long getEarID();
	public void setEarID(long _earID_);

	public long getFitxerID();
	public void setFitxerID(long _fitxerID_);

	public java.sql.Timestamp getData();
	public void setData(java.sql.Timestamp _data_);

	public java.lang.String getNom();
	public void setNom(java.lang.String _nom_);

  // Fitxer
  public <F extends Fitxer> F getFitxer();


  // ======================================

}

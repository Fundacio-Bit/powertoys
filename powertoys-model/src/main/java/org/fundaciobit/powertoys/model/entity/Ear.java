package org.fundaciobit.powertoys.model.entity;

public interface Ear extends org.fundaciobit.genapp.common.IGenAppEntity {

	public long getEarID();
	public void setEarID(long _earID_);

	public long getFitxerID();
	public void setFitxerID(long _fitxerID_);

  // Fitxer
  public <F extends Fitxer> F getFitxer();


  // ======================================

}

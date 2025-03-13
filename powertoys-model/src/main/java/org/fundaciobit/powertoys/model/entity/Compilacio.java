package org.fundaciobit.powertoys.model.entity;

public interface Compilacio extends org.fundaciobit.genapp.common.IGenAppEntity {

	public long getCompilacioID();
	public void setCompilacioID(long _compilacioID_);

	public long getRepocompilacioID();
	public void setRepocompilacioID(long _repocompilacioID_);

	public java.lang.String getTagUrl();
	public void setTagUrl(java.lang.String _tagUrl_);

	public java.sql.Timestamp getDataInici();
	public void setDataInici(java.sql.Timestamp _dataInici_);

	public java.sql.Timestamp getDataFi();
	public void setDataFi(java.sql.Timestamp _dataFi_);

	public short getExitCode();
	public void setExitCode(short _exitCode_);

	public java.lang.String getOutput();
	public void setOutput(java.lang.String _output_);



  // ======================================

}

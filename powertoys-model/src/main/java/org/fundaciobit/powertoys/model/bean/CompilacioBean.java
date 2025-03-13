
package org.fundaciobit.powertoys.model.bean;

import org.fundaciobit.powertoys.model.entity.Compilacio;


public class CompilacioBean implements Compilacio {



	long compilacioID;// PK
	long repocompilacioID;
	java.lang.String tagUrl;
	java.sql.Timestamp dataInici;
	java.sql.Timestamp dataFi;
	short exitCode;
	java.lang.String output;


  /** Constructor Buit */
  public CompilacioBean() {
  }

  /** Constructor amb tots els camps  */
  public CompilacioBean(long compilacioID , long repocompilacioID , java.lang.String tagUrl , java.sql.Timestamp dataInici , java.sql.Timestamp dataFi , short exitCode , java.lang.String output) {
    this.compilacioID=compilacioID;
    this.repocompilacioID=repocompilacioID;
    this.tagUrl=tagUrl;
    this.dataInici=dataInici;
    this.dataFi=dataFi;
    this.exitCode=exitCode;
    this.output=output;
}
  /** Constructor sense valors autoincrementals */
  public CompilacioBean(long repocompilacioID , java.lang.String tagUrl , java.sql.Timestamp dataInici , java.sql.Timestamp dataFi , short exitCode , java.lang.String output) {
    this.repocompilacioID=repocompilacioID;
    this.tagUrl=tagUrl;
    this.dataInici=dataInici;
    this.dataFi=dataFi;
    this.exitCode=exitCode;
    this.output=output;
}
  public CompilacioBean(Compilacio __bean) {
    this.setCompilacioID(__bean.getCompilacioID());
    this.setRepocompilacioID(__bean.getRepocompilacioID());
    this.setTagUrl(__bean.getTagUrl());
    this.setDataInici(__bean.getDataInici());
    this.setDataFi(__bean.getDataFi());
    this.setExitCode(__bean.getExitCode());
    this.setOutput(__bean.getOutput());
	}

	public long getCompilacioID() {
		return(compilacioID);
	};
	public void setCompilacioID(long _compilacioID_) {
		this.compilacioID = _compilacioID_;
	};

	public long getRepocompilacioID() {
		return(repocompilacioID);
	};
	public void setRepocompilacioID(long _repocompilacioID_) {
		this.repocompilacioID = _repocompilacioID_;
	};

	public java.lang.String getTagUrl() {
		return(tagUrl);
	};
	public void setTagUrl(java.lang.String _tagUrl_) {
		this.tagUrl = _tagUrl_;
	};

	public java.sql.Timestamp getDataInici() {
		return(dataInici);
	};
	public void setDataInici(java.sql.Timestamp _dataInici_) {
		this.dataInici = _dataInici_;
	};

	public java.sql.Timestamp getDataFi() {
		return(dataFi);
	};
	public void setDataFi(java.sql.Timestamp _dataFi_) {
		this.dataFi = _dataFi_;
	};

	public short getExitCode() {
		return(exitCode);
	};
	public void setExitCode(short _exitCode_) {
		this.exitCode = _exitCode_;
	};

	public java.lang.String getOutput() {
		return(output);
	};
	public void setOutput(java.lang.String _output_) {
		this.output = _output_;
	};



  // ======================================

  public static CompilacioBean toBean(Compilacio __bean) {
    if (__bean == null) { return null;}
    CompilacioBean __tmp = new CompilacioBean();
    __tmp.setCompilacioID(__bean.getCompilacioID());
    __tmp.setRepocompilacioID(__bean.getRepocompilacioID());
    __tmp.setTagUrl(__bean.getTagUrl());
    __tmp.setDataInici(__bean.getDataInici());
    __tmp.setDataFi(__bean.getDataFi());
    __tmp.setExitCode(__bean.getExitCode());
    __tmp.setOutput(__bean.getOutput());
		return __tmp;
	}



}

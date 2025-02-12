
package org.fundaciobit.powertoys.model.bean;

import org.fundaciobit.powertoys.model.entity.EarInfo;


public class EarInfoBean implements EarInfo {



	long earinfoID;// PK
	long earid;
	java.lang.String fileName;
	java.lang.String errors;
	java.lang.String redhatJarsToModules;
	java.lang.String jbossDeploymentStructure;
	java.lang.String potencialCanviDeJarAModul;


  /** Constructor Buit */
  public EarInfoBean() {
  }

  /** Constructor amb tots els camps  */
  public EarInfoBean(long earinfoID , long earid , java.lang.String fileName , java.lang.String errors , java.lang.String redhatJarsToModules , java.lang.String jbossDeploymentStructure , java.lang.String potencialCanviDeJarAModul) {
    this.earinfoID=earinfoID;
    this.earid=earid;
    this.fileName=fileName;
    this.errors=errors;
    this.redhatJarsToModules=redhatJarsToModules;
    this.jbossDeploymentStructure=jbossDeploymentStructure;
    this.potencialCanviDeJarAModul=potencialCanviDeJarAModul;
}
  /** Constructor sense valors autoincrementals */
  public EarInfoBean(long earid , java.lang.String fileName , java.lang.String errors , java.lang.String redhatJarsToModules , java.lang.String jbossDeploymentStructure , java.lang.String potencialCanviDeJarAModul) {
    this.earid=earid;
    this.fileName=fileName;
    this.errors=errors;
    this.redhatJarsToModules=redhatJarsToModules;
    this.jbossDeploymentStructure=jbossDeploymentStructure;
    this.potencialCanviDeJarAModul=potencialCanviDeJarAModul;
}
  /** Constructor dels valors Not Null */
  public EarInfoBean(long earinfoID , long earid , java.lang.String fileName) {
    this.earinfoID=earinfoID;
    this.earid=earid;
    this.fileName=fileName;
}
  public EarInfoBean(EarInfo __bean) {
    this.setEarinfoID(__bean.getEarinfoID());
    this.setEarid(__bean.getEarid());
    this.setFileName(__bean.getFileName());
    this.setErrors(__bean.getErrors());
    this.setRedhatJarsToModules(__bean.getRedhatJarsToModules());
    this.setJbossDeploymentStructure(__bean.getJbossDeploymentStructure());
    this.setPotencialCanviDeJarAModul(__bean.getPotencialCanviDeJarAModul());
	}

	public long getEarinfoID() {
		return(earinfoID);
	};
	public void setEarinfoID(long _earinfoID_) {
		this.earinfoID = _earinfoID_;
	};

	public long getEarid() {
		return(earid);
	};
	public void setEarid(long _earid_) {
		this.earid = _earid_;
	};

	public java.lang.String getFileName() {
		return(fileName);
	};
	public void setFileName(java.lang.String _fileName_) {
		this.fileName = _fileName_;
	};

	public java.lang.String getErrors() {
		return(errors);
	};
	public void setErrors(java.lang.String _errors_) {
		this.errors = _errors_;
	};

	public java.lang.String getRedhatJarsToModules() {
		return(redhatJarsToModules);
	};
	public void setRedhatJarsToModules(java.lang.String _redhatJarsToModules_) {
		this.redhatJarsToModules = _redhatJarsToModules_;
	};

	public java.lang.String getJbossDeploymentStructure() {
		return(jbossDeploymentStructure);
	};
	public void setJbossDeploymentStructure(java.lang.String _jbossDeploymentStructure_) {
		this.jbossDeploymentStructure = _jbossDeploymentStructure_;
	};

	public java.lang.String getPotencialCanviDeJarAModul() {
		return(potencialCanviDeJarAModul);
	};
	public void setPotencialCanviDeJarAModul(java.lang.String _potencialCanviDeJarAModul_) {
		this.potencialCanviDeJarAModul = _potencialCanviDeJarAModul_;
	};



  // ======================================

  public static EarInfoBean toBean(EarInfo __bean) {
    if (__bean == null) { return null;}
    EarInfoBean __tmp = new EarInfoBean();
    __tmp.setEarinfoID(__bean.getEarinfoID());
    __tmp.setEarid(__bean.getEarid());
    __tmp.setFileName(__bean.getFileName());
    __tmp.setErrors(__bean.getErrors());
    __tmp.setRedhatJarsToModules(__bean.getRedhatJarsToModules());
    __tmp.setJbossDeploymentStructure(__bean.getJbossDeploymentStructure());
    __tmp.setPotencialCanviDeJarAModul(__bean.getPotencialCanviDeJarAModul());
		return __tmp;
	}



}

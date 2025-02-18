
package org.fundaciobit.powertoys.model.bean;

import org.fundaciobit.powertoys.model.entity.EntornAplicacio;


public class EntornAplicacioBean implements EntornAplicacio {



	long entornaplicacioid;// PK
	long aplicacioID;
	long entornid;


  /** Constructor Buit */
  public EntornAplicacioBean() {
  }

  /** Constructor amb tots els camps  */
  public EntornAplicacioBean(long entornaplicacioid , long aplicacioID , long entornid) {
    this.entornaplicacioid=entornaplicacioid;
    this.aplicacioID=aplicacioID;
    this.entornid=entornid;
}
  /** Constructor sense valors autoincrementals */
  public EntornAplicacioBean(long aplicacioID , long entornid) {
    this.aplicacioID=aplicacioID;
    this.entornid=entornid;
}
  public EntornAplicacioBean(EntornAplicacio __bean) {
    this.setEntornaplicacioid(__bean.getEntornaplicacioid());
    this.setAplicacioID(__bean.getAplicacioID());
    this.setEntornid(__bean.getEntornid());
	}

	public long getEntornaplicacioid() {
		return(entornaplicacioid);
	};
	public void setEntornaplicacioid(long _entornaplicacioid_) {
		this.entornaplicacioid = _entornaplicacioid_;
	};

	public long getAplicacioID() {
		return(aplicacioID);
	};
	public void setAplicacioID(long _aplicacioID_) {
		this.aplicacioID = _aplicacioID_;
	};

	public long getEntornid() {
		return(entornid);
	};
	public void setEntornid(long _entornid_) {
		this.entornid = _entornid_;
	};



  // ======================================

  public static EntornAplicacioBean toBean(EntornAplicacio __bean) {
    if (__bean == null) { return null;}
    EntornAplicacioBean __tmp = new EntornAplicacioBean();
    __tmp.setEntornaplicacioid(__bean.getEntornaplicacioid());
    __tmp.setAplicacioID(__bean.getAplicacioID());
    __tmp.setEntornid(__bean.getEntornid());
		return __tmp;
	}



}

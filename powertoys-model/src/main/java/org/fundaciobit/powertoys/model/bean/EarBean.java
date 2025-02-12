
package org.fundaciobit.powertoys.model.bean;

import org.fundaciobit.powertoys.model.entity.Ear;


public class EarBean implements Ear {



	long earID;// PK
	long fitxerID;


  /** Constructor Buit */
  public EarBean() {
  }

  /** Constructor amb tots els camps  */
  public EarBean(long earID , long fitxerID) {
    this.earID=earID;
    this.fitxerID=fitxerID;
}
  /** Constructor sense valors autoincrementals */
  public EarBean(long fitxerID) {
    this.fitxerID=fitxerID;
}
  public EarBean(Ear __bean) {
    this.setEarID(__bean.getEarID());
    this.setFitxerID(__bean.getFitxerID());
    // Fitxer
    this.setFitxer(FitxerBean.toBean(__bean.getFitxer()));
	}

	public long getEarID() {
		return(earID);
	};
	public void setEarID(long _earID_) {
		this.earID = _earID_;
	};

	public long getFitxerID() {
		return(fitxerID);
	};
	public void setFitxerID(long _fitxerID_) {
		this.fitxerID = _fitxerID_;
	};



  // ======================================

  public static EarBean toBean(Ear __bean) {
    if (__bean == null) { return null;}
    EarBean __tmp = new EarBean();
    __tmp.setEarID(__bean.getEarID());
    __tmp.setFitxerID(__bean.getFitxerID());
    // Fitxer
    __tmp.setFitxer(FitxerBean.toBean(__bean.getFitxer()));
		return __tmp;
	}

  protected FitxerBean fitxer;
  public FitxerBean getFitxer() {
    return fitxer;
  }
  public void setFitxer(FitxerBean __field) {
    this. fitxer = __field;
  }


}

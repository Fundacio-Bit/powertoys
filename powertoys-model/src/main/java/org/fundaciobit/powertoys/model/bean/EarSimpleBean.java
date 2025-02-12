
package org.fundaciobit.powertoys.model.bean;

import org.fundaciobit.powertoys.model.entity.EarSimple;


public class EarSimpleBean implements EarSimple {



	long earSimpleID;// PK
	long fitxerID;
	java.lang.String nom;
	java.lang.String detall;
	java.sql.Timestamp data;


  /** Constructor Buit */
  public EarSimpleBean() {
  }

  /** Constructor amb tots els camps  */
  public EarSimpleBean(long earSimpleID , long fitxerID , java.lang.String nom , java.lang.String detall , java.sql.Timestamp data) {
    this.earSimpleID=earSimpleID;
    this.fitxerID=fitxerID;
    this.nom=nom;
    this.detall=detall;
    this.data=data;
}
  /** Constructor sense valors autoincrementals */
  public EarSimpleBean(long fitxerID , java.lang.String nom , java.lang.String detall , java.sql.Timestamp data) {
    this.fitxerID=fitxerID;
    this.nom=nom;
    this.detall=detall;
    this.data=data;
}
  public EarSimpleBean(EarSimple __bean) {
    this.setEarSimpleID(__bean.getEarSimpleID());
    this.setFitxerID(__bean.getFitxerID());
    this.setNom(__bean.getNom());
    this.setDetall(__bean.getDetall());
    this.setData(__bean.getData());
    // Fitxer
    this.setFitxer(FitxerBean.toBean(__bean.getFitxer()));
	}

	public long getEarSimpleID() {
		return(earSimpleID);
	};
	public void setEarSimpleID(long _earSimpleID_) {
		this.earSimpleID = _earSimpleID_;
	};

	public long getFitxerID() {
		return(fitxerID);
	};
	public void setFitxerID(long _fitxerID_) {
		this.fitxerID = _fitxerID_;
	};

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
	};

	public java.lang.String getDetall() {
		return(detall);
	};
	public void setDetall(java.lang.String _detall_) {
		this.detall = _detall_;
	};

	public java.sql.Timestamp getData() {
		return(data);
	};
	public void setData(java.sql.Timestamp _data_) {
		this.data = _data_;
	};



  // ======================================

  public static EarSimpleBean toBean(EarSimple __bean) {
    if (__bean == null) { return null;}
    EarSimpleBean __tmp = new EarSimpleBean();
    __tmp.setEarSimpleID(__bean.getEarSimpleID());
    __tmp.setFitxerID(__bean.getFitxerID());
    __tmp.setNom(__bean.getNom());
    __tmp.setDetall(__bean.getDetall());
    __tmp.setData(__bean.getData());
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

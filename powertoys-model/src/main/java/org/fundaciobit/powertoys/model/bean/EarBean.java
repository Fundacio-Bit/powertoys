
package org.fundaciobit.powertoys.model.bean;

import org.fundaciobit.powertoys.model.entity.Ear;


public class EarBean implements Ear {



	long earID;// PK
	long fitxerID;
	java.sql.Timestamp data;
	java.lang.String nom;


  /** Constructor Buit */
  public EarBean() {
  }

  /** Constructor amb tots els camps  */
  public EarBean(long earID , long fitxerID , java.sql.Timestamp data , java.lang.String nom) {
    this.earID=earID;
    this.fitxerID=fitxerID;
    this.data=data;
    this.nom=nom;
}
  /** Constructor sense valors autoincrementals */
  public EarBean(long fitxerID , java.sql.Timestamp data , java.lang.String nom) {
    this.fitxerID=fitxerID;
    this.data=data;
    this.nom=nom;
}
  public EarBean(Ear __bean) {
    this.setEarID(__bean.getEarID());
    this.setFitxerID(__bean.getFitxerID());
    this.setData(__bean.getData());
    this.setNom(__bean.getNom());
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

	public java.sql.Timestamp getData() {
		return(data);
	};
	public void setData(java.sql.Timestamp _data_) {
		this.data = _data_;
	};

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
	};



  // ======================================

  public static EarBean toBean(Ear __bean) {
    if (__bean == null) { return null;}
    EarBean __tmp = new EarBean();
    __tmp.setEarID(__bean.getEarID());
    __tmp.setFitxerID(__bean.getFitxerID());
    __tmp.setData(__bean.getData());
    __tmp.setNom(__bean.getNom());
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

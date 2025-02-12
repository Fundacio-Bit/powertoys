
package org.fundaciobit.powertoys.persistence;
import org.fundaciobit.powertoys.model.entity.*;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Index;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import org.hibernate.annotations.Type;
import javax.persistence.Id;


@Entity(name = "EarSimpleJPA")
@Table(name = "pwt_earsimple" , indexes = { 
        @Index(name="pwt_earsimple_pk_i", columnList = "earsimpleid"),
        @Index(name="pwt_earsimple_fitxerid_fk_i", columnList = "fitxerid")})
@SequenceGenerator(name="EARSIMPLE_SEQ", sequenceName="pwt_earsimple_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class EarSimpleJPA implements EarSimple {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="EARSIMPLE_SEQ")
    @Column(name="earsimpleid",nullable = false,length = 19)
    long earSimpleID;

    @Column(name="fitxerid",nullable = false,length = 19)
    long fitxerID;

    @Column(name="nom",nullable = false,length = 255)
    java.lang.String nom;

    @Column(name="detall",nullable = false,length = 2147483647)
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    java.lang.String detall;

    @Column(name="data",nullable = false,length = 35,precision = 6)
    java.sql.Timestamp data;



  /** Constructor Buit */
  public EarSimpleJPA() {
  }

  /** Constructor amb tots els camps  */
  public EarSimpleJPA(long earSimpleID , long fitxerID , java.lang.String nom , java.lang.String detall , java.sql.Timestamp data) {
    this.earSimpleID=earSimpleID;
    this.fitxerID=fitxerID;
    this.nom=nom;
    this.detall=detall;
    this.data=data;
}
  /** Constructor sense valors autoincrementals */
  public EarSimpleJPA(long fitxerID , java.lang.String nom , java.lang.String detall , java.sql.Timestamp data) {
    this.fitxerID=fitxerID;
    this.nom=nom;
    this.detall=detall;
    this.data=data;
}
  public EarSimpleJPA(EarSimple __bean) {
    this.setEarSimpleID(__bean.getEarSimpleID());
    this.setFitxerID(__bean.getFitxerID());
    this.setNom(__bean.getNom());
    this.setDetall(__bean.getDetall());
    this.setData(__bean.getData());
    // Fitxer
    this.setFitxer(FitxerJPA.toJPA(__bean.getFitxer()));
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



    @Override
    public boolean equals(Object __obj) {
        boolean __result;
        if (__obj != null && __obj instanceof EarSimple) {
            EarSimple __instance = (EarSimple)__obj;
            __result = true;
            __result = __result && (this.getEarSimpleID() == __instance.getEarSimpleID()) ;
        } else {
            __result = false;
        }
        return __result;
    }

    @Override
    public int hashCode() {
        return (String.valueOf(this.getEarSimpleID())).hashCode();
    }

// IMP Field:fitxerid | Table: pwt_fitxer | Type: 1  

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fitxerid", referencedColumnName ="fitxerID", nullable = false, insertable=false, updatable=false, foreignKey=@ForeignKey(name="pwt_earsimple_fitxer_fk"))
    private FitxerJPA fitxer;

    public FitxerJPA getFitxer() {
    return this.fitxer;
  }

    public  void setFitxer(FitxerJPA fitxer) {
    this.fitxer = fitxer;
  }


 // ---------------  STATIC METHODS ------------------
  public static EarSimpleJPA toJPA(EarSimple __bean) {
    if (__bean == null) { return null;}
    EarSimpleJPA __tmp = new EarSimpleJPA();
    __tmp.setEarSimpleID(__bean.getEarSimpleID());
    __tmp.setFitxerID(__bean.getFitxerID());
    __tmp.setNom(__bean.getNom());
    __tmp.setDetall(__bean.getDetall());
    __tmp.setData(__bean.getData());
    // Fitxer
    __tmp.setFitxer(FitxerJPA.toJPA(__bean.getFitxer()));
		return __tmp;
	}


  public static EarSimpleJPA copyJPA(EarSimpleJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<EarSimpleJPA> copyJPA(java.util.Set<EarSimpleJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<EarSimpleJPA> __tmpSet = (java.util.Set<EarSimpleJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<EarSimpleJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (EarSimpleJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static EarSimpleJPA copyJPA(EarSimpleJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    EarSimpleJPA __tmp = (EarSimpleJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    // Copia de beans complexes (IMP)

    return __tmp;
  }




}

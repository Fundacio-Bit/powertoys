
package org.fundaciobit.powertoys.persistence;
import org.fundaciobit.powertoys.model.entity.*;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.GenerationType;
import javax.persistence.Index;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.FetchType;
import javax.persistence.Id;


@Entity(name = "EarJPA")
@Table(name = "pwt_ear" , indexes = { 
        @Index(name="pwt_ear_pk_i", columnList = "earid"),
        @Index(name="pwt_ear_fitxerid_fk_i", columnList = "fitxerid")})
@SequenceGenerator(name="EAR_SEQ", sequenceName="pwt_ear_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class EarJPA implements Ear {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="EAR_SEQ")
    @Column(name="earid",nullable = false,length = 19)
    long earID;

    @Column(name="fitxerid",nullable = false,length = 19)
    long fitxerID;

    @Column(name="data",nullable = false,length = 35,precision = 6)
    java.sql.Timestamp data;

    @Column(name="nom",nullable = false,length = 255)
    java.lang.String nom;



  /** Constructor Buit */
  public EarJPA() {
  }

  /** Constructor amb tots els camps  */
  public EarJPA(long earID , long fitxerID , java.sql.Timestamp data , java.lang.String nom) {
    this.earID=earID;
    this.fitxerID=fitxerID;
    this.data=data;
    this.nom=nom;
}
  /** Constructor sense valors autoincrementals */
  public EarJPA(long fitxerID , java.sql.Timestamp data , java.lang.String nom) {
    this.fitxerID=fitxerID;
    this.data=data;
    this.nom=nom;
}
  public EarJPA(Ear __bean) {
    this.setEarID(__bean.getEarID());
    this.setFitxerID(__bean.getFitxerID());
    this.setData(__bean.getData());
    this.setNom(__bean.getNom());
    // Fitxer
    this.setFitxer(FitxerJPA.toJPA(__bean.getFitxer()));
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



    @Override
    public boolean equals(Object __obj) {
        boolean __result;
        if (__obj != null && __obj instanceof Ear) {
            Ear __instance = (Ear)__obj;
            __result = true;
            __result = __result && (this.getEarID() == __instance.getEarID()) ;
        } else {
            __result = false;
        }
        return __result;
    }

    @Override
    public int hashCode() {
        return (String.valueOf(this.getEarID())).hashCode();
    }

// EXP  Field:earid | Table: pwt_earinfo | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ear")
    private Set<EarInfoJPA> earInfos = new HashSet<EarInfoJPA>(0);
    public  Set<EarInfoJPA> getEarInfos() {
    return this.earInfos;
  }

    public void setEarInfos(Set<EarInfoJPA> earInfos) {
      this.earInfos = earInfos;
    }


// IMP Field:fitxerid | Table: pwt_fitxer | Type: 1  

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fitxerid", referencedColumnName ="fitxerID", nullable = false, insertable=false, updatable=false, foreignKey=@ForeignKey(name="pwt_ear_fitxer_fk"))
    private FitxerJPA fitxer;

    public FitxerJPA getFitxer() {
    return this.fitxer;
  }

    public  void setFitxer(FitxerJPA fitxer) {
    this.fitxer = fitxer;
  }


 // ---------------  STATIC METHODS ------------------
  public static EarJPA toJPA(Ear __bean) {
    if (__bean == null) { return null;}
    EarJPA __tmp = new EarJPA();
    __tmp.setEarID(__bean.getEarID());
    __tmp.setFitxerID(__bean.getFitxerID());
    __tmp.setData(__bean.getData());
    __tmp.setNom(__bean.getNom());
    // Fitxer
    __tmp.setFitxer(FitxerJPA.toJPA(__bean.getFitxer()));
		return __tmp;
	}


  public static EarJPA copyJPA(EarJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<EarJPA> copyJPA(java.util.Set<EarJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<EarJPA> __tmpSet = (java.util.Set<EarJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<EarJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (EarJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static EarJPA copyJPA(EarJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    EarJPA __tmp = (EarJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    if(!"EarInfoJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.earInfos) || org.hibernate.Hibernate.isInitialized(__jpa.getEarInfos())) ) {
      __tmp.setEarInfos(EarInfoJPA.copyJPA(__jpa.getEarInfos(), __alreadyCopied,"EarJPA"));
    }
    // Copia de beans complexes (IMP)

    return __tmp;
  }




}

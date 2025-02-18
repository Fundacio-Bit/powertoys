
package org.fundaciobit.powertoys.persistence;
import org.fundaciobit.powertoys.model.entity.*;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;
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


@Entity(name = "EntornAplicacioJPA")
@Table(name = "pwt_entornaplicacio" , indexes = { 
        @Index(name="pwt_entornaplicacio_pk_i", columnList = "entornaplicacioid"),
        @Index(name="pwt_entornapli_aplica_fk_i", columnList = "aplicacioid"),
        @Index(name="pwt_entornapli_entornid_fk_i", columnList = "entornid")},
           uniqueConstraints = {
            @UniqueConstraint(name="pwt_entornapli_entorn_apli_uk", columnNames={"aplicacioid","entornid"}) } )
@SequenceGenerator(name="ENTORNAPLICACIO_SEQ", sequenceName="pwt_entornaplicacio_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class EntornAplicacioJPA implements EntornAplicacio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ENTORNAPLICACIO_SEQ")
    @Column(name="entornaplicacioid",nullable = false,length = 19)
    long entornaplicacioid;

    @Column(name="aplicacioid",nullable = false,length = 19)
    long aplicacioID;

    @Column(name="entornid",nullable = false,length = 19)
    long entornid;



  /** Constructor Buit */
  public EntornAplicacioJPA() {
  }

  /** Constructor amb tots els camps  */
  public EntornAplicacioJPA(long entornaplicacioid , long aplicacioID , long entornid) {
    this.entornaplicacioid=entornaplicacioid;
    this.aplicacioID=aplicacioID;
    this.entornid=entornid;
}
  /** Constructor sense valors autoincrementals */
  public EntornAplicacioJPA(long aplicacioID , long entornid) {
    this.aplicacioID=aplicacioID;
    this.entornid=entornid;
}
  public EntornAplicacioJPA(EntornAplicacio __bean) {
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



    @Override
    public boolean equals(Object __obj) {
        boolean __result;
        if (__obj != null && __obj instanceof EntornAplicacio) {
            EntornAplicacio __instance = (EntornAplicacio)__obj;
            __result = true;
            __result = __result && (this.getEntornaplicacioid() == __instance.getEntornaplicacioid()) ;
        } else {
            __result = false;
        }
        return __result;
    }

    @Override
    public int hashCode() {
        return (String.valueOf(this.getEntornaplicacioid())).hashCode();
    }

// EXP  Field:entornaplicacioid | Table: pwt_versio | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "entornAplicacio")
    private Set<VersioJPA> versios = new HashSet<VersioJPA>(0);
    public  Set<VersioJPA> getVersios() {
    return this.versios;
  }

    public void setVersios(Set<VersioJPA> versios) {
      this.versios = versios;
    }


// IMP Field:aplicacioid | Table: pwt_aplicacio | Type: 1  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aplicacioid", referencedColumnName ="aplicacioID", nullable = false, insertable=false, updatable=false, foreignKey=@ForeignKey(name="pwt_entornapli_aplicacio_fk"))
    private AplicacioJPA aplicacio;

    public AplicacioJPA getAplicacio() {
    return this.aplicacio;
  }

    public  void setAplicacio(AplicacioJPA aplicacio) {
    this.aplicacio = aplicacio;
  }

// IMP Field:entornid | Table: pwt_entorn | Type: 1  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entornid", referencedColumnName ="entornID", nullable = false, insertable=false, updatable=false, foreignKey=@ForeignKey(name="pwt_entornapli_entorn_entor_fk"))
    private EntornJPA entorn;

    public EntornJPA getEntorn() {
    return this.entorn;
  }

    public  void setEntorn(EntornJPA entorn) {
    this.entorn = entorn;
  }


 // ---------------  STATIC METHODS ------------------
  public static EntornAplicacioJPA toJPA(EntornAplicacio __bean) {
    if (__bean == null) { return null;}
    EntornAplicacioJPA __tmp = new EntornAplicacioJPA();
    __tmp.setEntornaplicacioid(__bean.getEntornaplicacioid());
    __tmp.setAplicacioID(__bean.getAplicacioID());
    __tmp.setEntornid(__bean.getEntornid());
		return __tmp;
	}


  public static EntornAplicacioJPA copyJPA(EntornAplicacioJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<EntornAplicacioJPA> copyJPA(java.util.Set<EntornAplicacioJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<EntornAplicacioJPA> __tmpSet = (java.util.Set<EntornAplicacioJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<EntornAplicacioJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (EntornAplicacioJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static EntornAplicacioJPA copyJPA(EntornAplicacioJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    EntornAplicacioJPA __tmp = (EntornAplicacioJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    if(!"VersioJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.versios) || org.hibernate.Hibernate.isInitialized(__jpa.getVersios())) ) {
      __tmp.setVersios(VersioJPA.copyJPA(__jpa.getVersios(), __alreadyCopied,"EntornAplicacioJPA"));
    }
    // Copia de beans complexes (IMP)
    if(!"EntornJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.entorn) || org.hibernate.Hibernate.isInitialized(__jpa.getEntorn()) ) ) {
      __tmp.setEntorn(EntornJPA.copyJPA(__jpa.getEntorn(), __alreadyCopied,"EntornAplicacioJPA"));
    }
    if(!"AplicacioJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.aplicacio) || org.hibernate.Hibernate.isInitialized(__jpa.getAplicacio()) ) ) {
      __tmp.setAplicacio(AplicacioJPA.copyJPA(__jpa.getAplicacio(), __alreadyCopied,"EntornAplicacioJPA"));
    }

    return __tmp;
  }




}

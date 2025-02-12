
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


@Entity(name = "EarInfoJPA")
@Table(name = "pwt_earinfo" , indexes = { 
        @Index(name="pwt_earinfo_pk_i", columnList = "earinfoid"),
        @Index(name="pwt_earinfo_earid_fk_i", columnList = "earid")})
@SequenceGenerator(name="EARINFO_SEQ", sequenceName="pwt_earinfo_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class EarInfoJPA implements EarInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="EARINFO_SEQ")
    @Column(name="earinfoid",nullable = false,length = 19)
    long earinfoID;

    @Column(name="earid",nullable = false,length = 19)
    long earid;

    @Column(name="filename",nullable = false,length = 2147483647)
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    java.lang.String fileName;

    @Column(name="errors",length = 2147483647)
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    java.lang.String errors;

    @Column(name="redhatjarstomodules",length = 2147483647)
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    java.lang.String redhatJarsToModules;

    @Column(name="jbossdeploymentstructure",length = 2147483647)
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    java.lang.String jbossDeploymentStructure;

    @Column(name="potencialcanvidejaramodul",length = 2147483647)
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    java.lang.String potencialCanviDeJarAModul;



  /** Constructor Buit */
  public EarInfoJPA() {
  }

  /** Constructor amb tots els camps  */
  public EarInfoJPA(long earinfoID , long earid , java.lang.String fileName , java.lang.String errors , java.lang.String redhatJarsToModules , java.lang.String jbossDeploymentStructure , java.lang.String potencialCanviDeJarAModul) {
    this.earinfoID=earinfoID;
    this.earid=earid;
    this.fileName=fileName;
    this.errors=errors;
    this.redhatJarsToModules=redhatJarsToModules;
    this.jbossDeploymentStructure=jbossDeploymentStructure;
    this.potencialCanviDeJarAModul=potencialCanviDeJarAModul;
}
  /** Constructor sense valors autoincrementals */
  public EarInfoJPA(long earid , java.lang.String fileName , java.lang.String errors , java.lang.String redhatJarsToModules , java.lang.String jbossDeploymentStructure , java.lang.String potencialCanviDeJarAModul) {
    this.earid=earid;
    this.fileName=fileName;
    this.errors=errors;
    this.redhatJarsToModules=redhatJarsToModules;
    this.jbossDeploymentStructure=jbossDeploymentStructure;
    this.potencialCanviDeJarAModul=potencialCanviDeJarAModul;
}
  /** Constructor dels valors Not Null */
  public EarInfoJPA(long earinfoID , long earid , java.lang.String fileName) {
    this.earinfoID=earinfoID;
    this.earid=earid;
    this.fileName=fileName;
}
  public EarInfoJPA(EarInfo __bean) {
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



    @Override
    public boolean equals(Object __obj) {
        boolean __result;
        if (__obj != null && __obj instanceof EarInfo) {
            EarInfo __instance = (EarInfo)__obj;
            __result = true;
            __result = __result && (this.getEarinfoID() == __instance.getEarinfoID()) ;
        } else {
            __result = false;
        }
        return __result;
    }

    @Override
    public int hashCode() {
        return (String.valueOf(this.getEarinfoID())).hashCode();
    }

// IMP Field:earid | Table: pwt_ear | Type: 1  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "earid", referencedColumnName ="earID", nullable = false, insertable=false, updatable=false, foreignKey=@ForeignKey(name="pwt_earinfo_ear_fk"))
    private EarJPA ear;

    public EarJPA getEar() {
    return this.ear;
  }

    public  void setEar(EarJPA ear) {
    this.ear = ear;
  }


 // ---------------  STATIC METHODS ------------------
  public static EarInfoJPA toJPA(EarInfo __bean) {
    if (__bean == null) { return null;}
    EarInfoJPA __tmp = new EarInfoJPA();
    __tmp.setEarinfoID(__bean.getEarinfoID());
    __tmp.setEarid(__bean.getEarid());
    __tmp.setFileName(__bean.getFileName());
    __tmp.setErrors(__bean.getErrors());
    __tmp.setRedhatJarsToModules(__bean.getRedhatJarsToModules());
    __tmp.setJbossDeploymentStructure(__bean.getJbossDeploymentStructure());
    __tmp.setPotencialCanviDeJarAModul(__bean.getPotencialCanviDeJarAModul());
		return __tmp;
	}


  public static EarInfoJPA copyJPA(EarInfoJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<EarInfoJPA> copyJPA(java.util.Set<EarInfoJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<EarInfoJPA> __tmpSet = (java.util.Set<EarInfoJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<EarInfoJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (EarInfoJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static EarInfoJPA copyJPA(EarInfoJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    EarInfoJPA __tmp = (EarInfoJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    // Copia de beans complexes (IMP)
    if(!"EarJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.ear) || org.hibernate.Hibernate.isInitialized(__jpa.getEar()) ) ) {
      __tmp.setEar(EarJPA.copyJPA(__jpa.getEar(), __alreadyCopied,"EarInfoJPA"));
    }

    return __tmp;
  }




}

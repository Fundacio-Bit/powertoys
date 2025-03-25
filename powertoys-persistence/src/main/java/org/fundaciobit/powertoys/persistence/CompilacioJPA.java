
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


@Entity(name = "CompilacioJPA")
@Table(name = "pwt_compilacio" , indexes = { 
        @Index(name="pwt_compilacio_pk_i", columnList = "compilacioid"),
        @Index(name="pwt_compilacio_repocompid_fk_i", columnList = "repocompilacioid")})
@SequenceGenerator(name="COMPILACIO_SEQ", sequenceName="pwt_compilacio_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class CompilacioJPA implements Compilacio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="COMPILACIO_SEQ")
    @Column(name="compilacioid",nullable = false,length = 19)
    long compilacioID;

    @Column(name="repocompilacioid",nullable = false,length = 19)
    long repocompilacioID;

    @Column(name="tagurl",nullable = false,length = 255)
    java.lang.String tagUrl;

    @Column(name="datainici",nullable = false,length = 29,precision = 6)
    java.sql.Timestamp dataInici;

    @Column(name="datafi",nullable = false,length = 29,precision = 6)
    java.sql.Timestamp dataFi;

    @Column(name="exitcode",nullable = false,length = 5)
    short exitCode;

    @Column(name="output",length = 2147483647)
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    java.lang.String output;



  /** Constructor Buit */
  public CompilacioJPA() {
  }

  /** Constructor amb tots els camps  */
  public CompilacioJPA(long compilacioID , long repocompilacioID , java.lang.String tagUrl , java.sql.Timestamp dataInici , java.sql.Timestamp dataFi , short exitCode , java.lang.String output) {
    this.compilacioID=compilacioID;
    this.repocompilacioID=repocompilacioID;
    this.tagUrl=tagUrl;
    this.dataInici=dataInici;
    this.dataFi=dataFi;
    this.exitCode=exitCode;
    this.output=output;
}
  /** Constructor sense valors autoincrementals */
  public CompilacioJPA(long repocompilacioID , java.lang.String tagUrl , java.sql.Timestamp dataInici , java.sql.Timestamp dataFi , short exitCode , java.lang.String output) {
    this.repocompilacioID=repocompilacioID;
    this.tagUrl=tagUrl;
    this.dataInici=dataInici;
    this.dataFi=dataFi;
    this.exitCode=exitCode;
    this.output=output;
}
  public CompilacioJPA(Compilacio __bean) {
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



    @Override
    public boolean equals(Object __obj) {
        boolean __result;
        if (__obj != null && __obj instanceof Compilacio) {
            Compilacio __instance = (Compilacio)__obj;
            __result = true;
            __result = __result && (this.getCompilacioID() == __instance.getCompilacioID()) ;
        } else {
            __result = false;
        }
        return __result;
    }

// IMP Field:repocompilacioid | Table: pwt_repocompilacio | Type: 1  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repocompilacioid", referencedColumnName ="repocompilacioID", nullable = false, insertable=false, updatable=false, foreignKey=@ForeignKey(name="pwt_compilacio_repocomp_rid_fk"))
    private RepoCompilacioJPA repoCompilacio;

    public RepoCompilacioJPA getRepoCompilacio() {
    return this.repoCompilacio;
  }

    public  void setRepoCompilacio(RepoCompilacioJPA repoCompilacio) {
    this.repoCompilacio = repoCompilacio;
  }


 // ---------------  STATIC METHODS ------------------
  public static CompilacioJPA toJPA(Compilacio __bean) {
    if (__bean == null) { return null;}
    CompilacioJPA __tmp = new CompilacioJPA();
    __tmp.setCompilacioID(__bean.getCompilacioID());
    __tmp.setRepocompilacioID(__bean.getRepocompilacioID());
    __tmp.setTagUrl(__bean.getTagUrl());
    __tmp.setDataInici(__bean.getDataInici());
    __tmp.setDataFi(__bean.getDataFi());
    __tmp.setExitCode(__bean.getExitCode());
    __tmp.setOutput(__bean.getOutput());
		return __tmp;
	}


  public static CompilacioJPA copyJPA(CompilacioJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<CompilacioJPA> copyJPA(java.util.Set<CompilacioJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<CompilacioJPA> __tmpSet = (java.util.Set<CompilacioJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<CompilacioJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (CompilacioJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static CompilacioJPA copyJPA(CompilacioJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    CompilacioJPA __tmp = (CompilacioJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    // Copia de beans complexes (IMP)
    if(!"RepoCompilacioJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.repoCompilacio) || org.hibernate.Hibernate.isInitialized(__jpa.getRepoCompilacio()) ) ) {
      __tmp.setRepoCompilacio(RepoCompilacioJPA.copyJPA(__jpa.getRepoCompilacio(), __alreadyCopied,"CompilacioJPA"));
    }

    return __tmp;
  }




}

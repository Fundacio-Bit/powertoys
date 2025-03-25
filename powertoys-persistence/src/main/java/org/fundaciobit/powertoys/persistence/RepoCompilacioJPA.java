
package org.fundaciobit.powertoys.persistence;
import org.fundaciobit.powertoys.model.entity.*;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.HashSet;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Index;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;
import javax.persistence.Id;


@Entity(name = "RepoCompilacioJPA")
@Table(name = "pwt_repocompilacio" , indexes = { 
        @Index(name="pwt_repocompilacio_pk_i", columnList = "repocompilacioid")})
@SequenceGenerator(name="REPOCOMPILACIO_SEQ", sequenceName="pwt_repocompilacio_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class RepoCompilacioJPA implements RepoCompilacio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="REPOCOMPILACIO_SEQ")
    @Column(name="repocompilacioid",nullable = false,length = 19)
    long repocompilacioID;

    @Column(name="nom",nullable = false,length = 255)
    java.lang.String nom;

    @Column(name="organitzaciogithub",nullable = false,length = 255)
    java.lang.String organitzacioGitHub;

    @Column(name="repositorigithub",nullable = false,length = 255)
    java.lang.String repositoriGitHub;

    @Column(name="ordre",length = 19)
    java.lang.Long ordre;

    @Column(name="actiu",nullable = false,length = 1)
    boolean actiu;



  /** Constructor Buit */
  public RepoCompilacioJPA() {
  }

  /** Constructor amb tots els camps  */
  public RepoCompilacioJPA(long repocompilacioID , java.lang.String nom , java.lang.String organitzacioGitHub , java.lang.String repositoriGitHub , java.lang.Long ordre , boolean actiu) {
    this.repocompilacioID=repocompilacioID;
    this.nom=nom;
    this.organitzacioGitHub=organitzacioGitHub;
    this.repositoriGitHub=repositoriGitHub;
    this.ordre=ordre;
    this.actiu=actiu;
}
  /** Constructor sense valors autoincrementals */
  public RepoCompilacioJPA(java.lang.String nom , java.lang.String organitzacioGitHub , java.lang.String repositoriGitHub , java.lang.Long ordre , boolean actiu) {
    this.nom=nom;
    this.organitzacioGitHub=organitzacioGitHub;
    this.repositoriGitHub=repositoriGitHub;
    this.ordre=ordre;
    this.actiu=actiu;
}
  public RepoCompilacioJPA(RepoCompilacio __bean) {
    this.setRepocompilacioID(__bean.getRepocompilacioID());
    this.setNom(__bean.getNom());
    this.setOrganitzacioGitHub(__bean.getOrganitzacioGitHub());
    this.setRepositoriGitHub(__bean.getRepositoriGitHub());
    this.setOrdre(__bean.getOrdre());
    this.setActiu(__bean.isActiu());
	}

	public long getRepocompilacioID() {
		return(repocompilacioID);
	};
	public void setRepocompilacioID(long _repocompilacioID_) {
		this.repocompilacioID = _repocompilacioID_;
	};

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
	};

	public java.lang.String getOrganitzacioGitHub() {
		return(organitzacioGitHub);
	};
	public void setOrganitzacioGitHub(java.lang.String _organitzacioGitHub_) {
		this.organitzacioGitHub = _organitzacioGitHub_;
	};

	public java.lang.String getRepositoriGitHub() {
		return(repositoriGitHub);
	};
	public void setRepositoriGitHub(java.lang.String _repositoriGitHub_) {
		this.repositoriGitHub = _repositoriGitHub_;
	};

	public java.lang.Long getOrdre() {
		return(ordre);
	};
	public void setOrdre(java.lang.Long _ordre_) {
		this.ordre = _ordre_;
	};

	public boolean isActiu() {
		return(actiu);
	};
	public void setActiu(boolean _actiu_) {
		this.actiu = _actiu_;
	};



    @Override
    public boolean equals(Object __obj) {
        boolean __result;
        if (__obj != null && __obj instanceof RepoCompilacio) {
            RepoCompilacio __instance = (RepoCompilacio)__obj;
            __result = true;
            __result = __result && (this.getRepocompilacioID() == __instance.getRepocompilacioID()) ;
        } else {
            __result = false;
        }
        return __result;
    }

// EXP  Field:repocompilacioid | Table: pwt_compilacio | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "repoCompilacio")
    private Set<CompilacioJPA> compilacios = new HashSet<CompilacioJPA>(0);
    public  Set<CompilacioJPA> getCompilacios() {
    return this.compilacios;
  }

    public void setCompilacios(Set<CompilacioJPA> compilacios) {
      this.compilacios = compilacios;
    }



 // ---------------  STATIC METHODS ------------------
  public static RepoCompilacioJPA toJPA(RepoCompilacio __bean) {
    if (__bean == null) { return null;}
    RepoCompilacioJPA __tmp = new RepoCompilacioJPA();
    __tmp.setRepocompilacioID(__bean.getRepocompilacioID());
    __tmp.setNom(__bean.getNom());
    __tmp.setOrganitzacioGitHub(__bean.getOrganitzacioGitHub());
    __tmp.setRepositoriGitHub(__bean.getRepositoriGitHub());
    __tmp.setOrdre(__bean.getOrdre());
    __tmp.setActiu(__bean.isActiu());
		return __tmp;
	}


  public static RepoCompilacioJPA copyJPA(RepoCompilacioJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<RepoCompilacioJPA> copyJPA(java.util.Set<RepoCompilacioJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<RepoCompilacioJPA> __tmpSet = (java.util.Set<RepoCompilacioJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<RepoCompilacioJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (RepoCompilacioJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static RepoCompilacioJPA copyJPA(RepoCompilacioJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    RepoCompilacioJPA __tmp = (RepoCompilacioJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    if(!"CompilacioJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.compilacios) || org.hibernate.Hibernate.isInitialized(__jpa.getCompilacios())) ) {
      __tmp.setCompilacios(CompilacioJPA.copyJPA(__jpa.getCompilacios(), __alreadyCopied,"RepoCompilacioJPA"));
    }
    // Copia de beans complexes (IMP)

    return __tmp;
  }




}


package org.fundaciobit.powertoys.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class RepoCompilacioQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public RepoCompilacioQueryPath() {
  }

  protected RepoCompilacioQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField REPOCOMPILACIOID() {
    return new LongField(getQueryPath(), RepoCompilacioFields.REPOCOMPILACIOID);
  }

  public StringField NOM() {
    return new StringField(getQueryPath(), RepoCompilacioFields.NOM);
  }

  public StringField ORGANITZACIOGITHUB() {
    return new StringField(getQueryPath(), RepoCompilacioFields.ORGANITZACIOGITHUB);
  }

  public StringField REPOSITORIGITHUB() {
    return new StringField(getQueryPath(), RepoCompilacioFields.REPOSITORIGITHUB);
  }

  public LongField ORDRE() {
    return new LongField(getQueryPath(), RepoCompilacioFields.ORDRE);
  }

  public BooleanField ACTIU() {
    return new BooleanField(getQueryPath(), RepoCompilacioFields.ACTIU);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (RepoCompilacioFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public CompilacioQueryPath COMPILACIOS() {
    return new CompilacioQueryPath(new QueryPath() {
      public String getQueryPath() {
          return RepoCompilacioQueryPath.this.getQueryPath() + "compilacios" + ".";
      }
    });
  }
*/

}

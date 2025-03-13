
package org.fundaciobit.powertoys.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class CompilacioQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public CompilacioQueryPath() {
  }

  protected CompilacioQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField COMPILACIOID() {
    return new LongField(getQueryPath(), CompilacioFields.COMPILACIOID);
  }

  public LongField REPOCOMPILACIOID() {
    return new LongField(getQueryPath(), CompilacioFields.REPOCOMPILACIOID);
  }

  public StringField TAGURL() {
    return new StringField(getQueryPath(), CompilacioFields.TAGURL);
  }

  public TimestampField DATAINICI() {
    return new TimestampField(getQueryPath(), CompilacioFields.DATAINICI);
  }

  public TimestampField DATAFI() {
    return new TimestampField(getQueryPath(), CompilacioFields.DATAFI);
  }

  public ShortField EXITCODE() {
    return new ShortField(getQueryPath(), CompilacioFields.EXITCODE);
  }

  public StringField OUTPUT() {
    return new StringField(getQueryPath(), CompilacioFields.OUTPUT);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (CompilacioFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


  public RepoCompilacioQueryPath REPOCOMPILACIO() {
    return new RepoCompilacioQueryPath(new QueryPath() {
      public String getQueryPath() {
          return CompilacioQueryPath.this.getQueryPath() + "repoCompilacio" + ".";
      }
    });
  }

}


package org.fundaciobit.powertoys.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class EarInfoQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public EarInfoQueryPath() {
  }

  protected EarInfoQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField EARINFOID() {
    return new LongField(getQueryPath(), EarInfoFields.EARINFOID);
  }

  public LongField EARID() {
    return new LongField(getQueryPath(), EarInfoFields.EARID);
  }

  public StringField FILENAME() {
    return new StringField(getQueryPath(), EarInfoFields.FILENAME);
  }

  public StringField ERRORS() {
    return new StringField(getQueryPath(), EarInfoFields.ERRORS);
  }

  public StringField REDHATJARSTOMODULES() {
    return new StringField(getQueryPath(), EarInfoFields.REDHATJARSTOMODULES);
  }

  public StringField JBOSSDEPLOYMENTSTRUCTURE() {
    return new StringField(getQueryPath(), EarInfoFields.JBOSSDEPLOYMENTSTRUCTURE);
  }

  public StringField POTENCIALCANVIDEJARAMODUL() {
    return new StringField(getQueryPath(), EarInfoFields.POTENCIALCANVIDEJARAMODUL);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (EarInfoFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


  public EarQueryPath EAR() {
    return new EarQueryPath(new QueryPath() {
      public String getQueryPath() {
          return EarInfoQueryPath.this.getQueryPath() + "ear" + ".";
      }
    });
  }

}

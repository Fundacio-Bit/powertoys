
package org.fundaciobit.powertoys.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class EarSimpleQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public EarSimpleQueryPath() {
  }

  protected EarSimpleQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField EARSIMPLEID() {
    return new LongField(getQueryPath(), EarSimpleFields.EARSIMPLEID);
  }

  public LongField FITXERID() {
    return new LongField(getQueryPath(), EarSimpleFields.FITXERID);
  }

  public StringField NOM() {
    return new StringField(getQueryPath(), EarSimpleFields.NOM);
  }

  public StringField DETALL() {
    return new StringField(getQueryPath(), EarSimpleFields.DETALL);
  }

  public TimestampField DATA() {
    return new TimestampField(getQueryPath(), EarSimpleFields.DATA);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (EarSimpleFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


  public FitxerQueryPath FITXER() {
    return new FitxerQueryPath(new QueryPath() {
      public String getQueryPath() {
          return EarSimpleQueryPath.this.getQueryPath() + "fitxer" + ".";
      }
    });
  }

}


package org.fundaciobit.powertoys.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class EarQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public EarQueryPath() {
  }

  protected EarQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField EARID() {
    return new LongField(getQueryPath(), EarFields.EARID);
  }

  public LongField FITXERID() {
    return new LongField(getQueryPath(), EarFields.FITXERID);
  }

  public TimestampField DATA() {
    return new TimestampField(getQueryPath(), EarFields.DATA);
  }

  public StringField NOM() {
    return new StringField(getQueryPath(), EarFields.NOM);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (EarFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public EarInfoQueryPath EARINFOS() {
    return new EarInfoQueryPath(new QueryPath() {
      public String getQueryPath() {
          return EarQueryPath.this.getQueryPath() + "earInfos" + ".";
      }
    });
  }
*/

  public FitxerQueryPath FITXER() {
    return new FitxerQueryPath(new QueryPath() {
      public String getQueryPath() {
          return EarQueryPath.this.getQueryPath() + "fitxer" + ".";
      }
    });
  }

}

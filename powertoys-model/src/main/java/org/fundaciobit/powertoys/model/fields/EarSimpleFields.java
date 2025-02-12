
package org.fundaciobit.powertoys.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface EarSimpleFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "pwt_earsimple";


  public static final String _TABLE_MODEL = "earSimple";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField EARSIMPLEID = new LongField(_TABLE_MODEL, "earSimpleID", "earsimpleid");  // PK
	 public static final LongField FITXERID = new LongField(_TABLE_MODEL, "fitxerID", "fitxerid");
	 public static final StringField NOM = new StringField(_TABLE_MODEL, "nom", "nom");
	 public static final StringField DETALL = new StringField(_TABLE_MODEL, "detall", "detall");
	 public static final TimestampField DATA = new TimestampField(_TABLE_MODEL, "data", "data");


  public static final Field<?>[] ALL_EARSIMPLE_FIELDS = {
    EARSIMPLEID,
    FITXERID,
    NOM,
    DETALL,
    DATA
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
EARSIMPLEID
  };
}

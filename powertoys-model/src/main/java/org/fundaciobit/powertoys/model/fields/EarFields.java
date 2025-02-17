
package org.fundaciobit.powertoys.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface EarFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "pwt_ear";


  public static final String _TABLE_MODEL = "ear";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField EARID = new LongField(_TABLE_MODEL, "earID", "earid");  // PK
	 public static final LongField FITXERID = new LongField(_TABLE_MODEL, "fitxerID", "fitxerid");
	 public static final TimestampField DATA = new TimestampField(_TABLE_MODEL, "data", "data");
	 public static final StringField NOM = new StringField(_TABLE_MODEL, "nom", "nom");


  public static final Field<?>[] ALL_EAR_FIELDS = {
    EARID,
    FITXERID,
    DATA,
    NOM
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
EARID
  };
}

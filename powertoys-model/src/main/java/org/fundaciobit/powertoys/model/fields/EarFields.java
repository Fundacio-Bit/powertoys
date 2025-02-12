
package org.fundaciobit.powertoys.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface EarFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "pwt_ear";


  public static final String _TABLE_MODEL = "ear";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField EARID = new LongField(_TABLE_MODEL, "earID", "earid");  // PK
	 public static final LongField FITXERID = new LongField(_TABLE_MODEL, "fitxerID", "fitxerid");


  public static final Field<?>[] ALL_EAR_FIELDS = {
    EARID,
    FITXERID
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
EARID
  };
}

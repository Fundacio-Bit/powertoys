
package org.fundaciobit.powertoys.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface CompilacioFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "pwt_compilacio";


  public static final String _TABLE_MODEL = "compilacio";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField COMPILACIOID = new LongField(_TABLE_MODEL, "compilacioID", "compilacioid");  // PK
	 public static final LongField REPOCOMPILACIOID = new LongField(_TABLE_MODEL, "repocompilacioID", "repocompilacioid");
	 public static final StringField TAGURL = new StringField(_TABLE_MODEL, "tagUrl", "tagurl");
	 public static final TimestampField DATAINICI = new TimestampField(_TABLE_MODEL, "dataInici", "datainici");
	 public static final TimestampField DATAFI = new TimestampField(_TABLE_MODEL, "dataFi", "datafi");
	 public static final ShortField EXITCODE = new ShortField(_TABLE_MODEL, "exitCode", "exitcode");
	 public static final StringField OUTPUT = new StringField(_TABLE_MODEL, "output", "output");


  public static final Field<?>[] ALL_COMPILACIO_FIELDS = {
    COMPILACIOID,
    REPOCOMPILACIOID,
    TAGURL,
    DATAINICI,
    DATAFI,
    EXITCODE,
    OUTPUT
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
COMPILACIOID
  };
}

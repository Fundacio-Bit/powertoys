
package org.fundaciobit.powertoys.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface EarInfoFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "pwt_earinfo";


  public static final String _TABLE_MODEL = "earInfo";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField EARINFOID = new LongField(_TABLE_MODEL, "earinfoID", "earinfoid");  // PK
	 public static final LongField EARID = new LongField(_TABLE_MODEL, "earID", "earid");
	 public static final StringField FILENAME = new StringField(_TABLE_MODEL, "fileName", "filename");
	 public static final StringField ERRORS = new StringField(_TABLE_MODEL, "errors", "errors");
	 public static final StringField REDHATJARSTOMODULES = new StringField(_TABLE_MODEL, "redhatJarsToModules", "redhatjarstomodules");
	 public static final StringField JBOSSDEPLOYMENTSTRUCTURE = new StringField(_TABLE_MODEL, "jbossDeploymentStructure", "jbossdeploymentstructure");
	 public static final StringField POTENCIALCANVIDEJARAMODUL = new StringField(_TABLE_MODEL, "potencialCanviDeJarAModul", "potencialcanvidejaramodul");


  public static final Field<?>[] ALL_EARINFO_FIELDS = {
    EARINFOID,
    EARID,
    FILENAME,
    ERRORS,
    REDHATJARSTOMODULES,
    JBOSSDEPLOYMENTSTRUCTURE,
    POTENCIALCANVIDEJARAMODUL
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
EARINFOID
  };
}


package org.fundaciobit.powertoys.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface RepoCompilacioFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "pwt_repocompilacio";


  public static final String _TABLE_MODEL = "repoCompilacio";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField REPOCOMPILACIOID = new LongField(_TABLE_MODEL, "repocompilacioID", "repocompilacioid");  // PK
	 public static final StringField NOM = new StringField(_TABLE_MODEL, "nom", "nom");
	 public static final StringField ORGANITZACIOGITHUB = new StringField(_TABLE_MODEL, "organitzacioGitHub", "organitzaciogithub");
	 public static final StringField REPOSITORIGITHUB = new StringField(_TABLE_MODEL, "repositoriGitHub", "repositorigithub");
	 public static final LongField ORDRE = new LongField(_TABLE_MODEL, "ordre", "ordre");
	 public static final BooleanField ACTIU = new BooleanField(_TABLE_MODEL, "actiu", "actiu");


  public static final Field<?>[] ALL_REPOCOMPILACIO_FIELDS = {
    REPOCOMPILACIOID,
    NOM,
    ORGANITZACIOGITHUB,
    REPOSITORIGITHUB,
    ORDRE,
    ACTIU
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
REPOCOMPILACIOID
  };
}

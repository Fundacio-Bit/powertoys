package org.fundaciobit.powertoys.model.dao;

import org.fundaciobit.powertoys.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IEarInfoManager extends org.fundaciobit.genapp.common.query.ITableManager<EarInfo, Long> {


	public EarInfo create( long _earid_, java.lang.String _fileName_, java.lang.String _errors_, java.lang.String _redhatJarsToModules_, java.lang.String _jbossDeploymentStructure_, java.lang.String _potencialCanviDeJarAModul_) throws I18NException;

	public EarInfo findByPrimaryKey(long _earinfoID_);

	public void delete(long _earinfoID_);

}

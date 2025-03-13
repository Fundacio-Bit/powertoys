package org.fundaciobit.powertoys.model.dao;

import org.fundaciobit.powertoys.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface ICompilacioManager extends org.fundaciobit.genapp.common.query.ITableManager<Compilacio, Long> {


	public Compilacio create( long _repocompilacioID_, java.lang.String _tagUrl_, java.sql.Timestamp _dataInici_, java.sql.Timestamp _dataFi_, short _exitCode_, java.lang.String _output_) throws I18NException;

	public Compilacio findByPrimaryKey(long _compilacioID_);

	public void delete(long _compilacioID_);

}

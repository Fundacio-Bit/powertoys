package org.fundaciobit.powertoys.model.dao;

import org.fundaciobit.powertoys.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IEarSimpleManager extends org.fundaciobit.genapp.common.query.ITableManager<EarSimple, Long> {


	public EarSimple create( long _fitxerID_, java.lang.String _nom_, java.lang.String _detall_, java.sql.Timestamp _data_) throws I18NException;

	public EarSimple findByPrimaryKey(long _earSimpleID_);

	public void delete(long _earSimpleID_);

}

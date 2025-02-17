package org.fundaciobit.powertoys.model.dao;

import org.fundaciobit.powertoys.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IEarManager extends org.fundaciobit.genapp.common.query.ITableManager<Ear, Long> {


	public Ear create( long _fitxerID_, java.sql.Timestamp _data_, java.lang.String _nom_) throws I18NException;

	public Ear findByPrimaryKey(long _earID_);

	public void delete(long _earID_);

}

package org.fundaciobit.powertoys.model.dao;

import org.fundaciobit.powertoys.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IRepoCompilacioManager extends org.fundaciobit.genapp.common.query.ITableManager<RepoCompilacio, Long> {


	public RepoCompilacio create( java.lang.String _nom_, java.lang.String _organitzacioGitHub_, java.lang.String _repositoriGitHub_, java.lang.Long _ordre_, boolean _actiu_) throws I18NException;

	public RepoCompilacio findByPrimaryKey(long _repocompilacioID_);

	public void delete(long _repocompilacioID_);

}

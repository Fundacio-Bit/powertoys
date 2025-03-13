package org.fundaciobit.powertoys.model;

import org.fundaciobit.powertoys.model.dao.*;

public interface IPowerToysDaoManagers {
	public IAplicacioManager getAplicacioManager();
	public ICompilacioManager getCompilacioManager();
	public IEarManager getEarManager();
	public IEarInfoManager getEarInfoManager();
	public IEarSimpleManager getEarSimpleManager();
	public IEntornManager getEntornManager();
	public IEntornAplicacioManager getEntornAplicacioManager();
	public IFitxerManager getFitxerManager();
	public IIdiomaManager getIdiomaManager();
	public IRepoCompilacioManager getRepoCompilacioManager();
	public ITraduccioManager getTraduccioManager();
	public IVersioManager getVersioManager();

}
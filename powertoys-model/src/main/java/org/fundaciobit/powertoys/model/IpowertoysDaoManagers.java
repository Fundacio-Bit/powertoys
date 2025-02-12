package org.fundaciobit.powertoys.model;

import org.fundaciobit.powertoys.model.dao.*;

public interface IpowertoysDaoManagers {
	public IEarManager getEarManager();
	public IEarInfoManager getEarInfoManager();
	public IEarSimpleManager getEarSimpleManager();
	public IFitxerManager getFitxerManager();
	public IIdiomaManager getIdiomaManager();
	public ITraduccioManager getTraduccioManager();

}
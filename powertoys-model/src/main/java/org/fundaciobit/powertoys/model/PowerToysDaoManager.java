package org.fundaciobit.powertoys.model;

public class PowerToysDaoManager {
  
  private static IPowerToysDaoManagers instance = null;
  
  public static void setDaoManagers(IPowerToysDaoManagers managers) {
    instance = managers;
  }
  
  public static IPowerToysDaoManagers getDaoManagers() throws Exception {
    if(instance == null) {
      throw new Exception("Ha de inicialitzar el sistema de Managers cridant "
          + " al mètode PowerToysDaoManager.setDaoManagers(...)");
    }
    return instance;
  }
  
}

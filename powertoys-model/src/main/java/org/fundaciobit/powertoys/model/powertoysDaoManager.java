package org.fundaciobit.powertoys.model;

public class powertoysDaoManager {
  
  private static IpowertoysDaoManagers instance = null;
  
  public static void setDaoManagers(IpowertoysDaoManagers managers) {
    instance = managers;
  }
  
  public static IpowertoysDaoManagers getDaoManagers() throws Exception {
    if(instance == null) {
      throw new Exception("Ha de inicialitzar el sistema de Managers cridant "
          + " al mètode powertoysDaoManager.setDaoManagers(...)");
    }
    return instance;
  }
  
}

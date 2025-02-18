package org.fundaciobit.powertoys.persistence;

import org.fundaciobit.powertoys.model.*;
import org.fundaciobit.powertoys.model.dao.*;
import javax.persistence.EntityManager;

public final class PowerToysJPADaoManagers implements IPowerToysDaoManagers{

   private final AplicacioJPAManager pwt_aplicacio;
   private final EarJPAManager pwt_ear;
   private final EarInfoJPAManager pwt_earinfo;
   private final EarSimpleJPAManager pwt_earsimple;
   private final EntornJPAManager pwt_entorn;
   private final EntornAplicacioJPAManager pwt_entornaplicacio;
   private final FitxerJPAManager pwt_fitxer;
   private final IdiomaJPAManager pwt_idioma;
   private final TraduccioJPAManager pwt_traduccio;
   private final VersioJPAManager pwt_versio;

  public  PowerToysJPADaoManagers(EntityManager __em) {
    this.pwt_aplicacio = new AplicacioJPAManager(__em);
    this.pwt_ear = new EarJPAManager(__em);
    this.pwt_earinfo = new EarInfoJPAManager(__em);
    this.pwt_earsimple = new EarSimpleJPAManager(__em);
    this.pwt_entorn = new EntornJPAManager(__em);
    this.pwt_entornaplicacio = new EntornAplicacioJPAManager(__em);
    this.pwt_fitxer = new FitxerJPAManager(__em);
    this.pwt_idioma = new IdiomaJPAManager(__em);
    this.pwt_traduccio = new TraduccioJPAManager(__em);
    this.pwt_versio = new VersioJPAManager(__em);
  }

    public IAplicacioManager getAplicacioManager() {
        return this.pwt_aplicacio;
    };

    public IEarManager getEarManager() {
        return this.pwt_ear;
    };

    public IEarInfoManager getEarInfoManager() {
        return this.pwt_earinfo;
    };

    public IEarSimpleManager getEarSimpleManager() {
        return this.pwt_earsimple;
    };

    public IEntornManager getEntornManager() {
        return this.pwt_entorn;
    };

    public IEntornAplicacioManager getEntornAplicacioManager() {
        return this.pwt_entornaplicacio;
    };

    public IFitxerManager getFitxerManager() {
        return this.pwt_fitxer;
    };

    public IIdiomaManager getIdiomaManager() {
        return this.pwt_idioma;
    };

    public ITraduccioManager getTraduccioManager() {
        return this.pwt_traduccio;
    };

    public IVersioManager getVersioManager() {
        return this.pwt_versio;
    };


}
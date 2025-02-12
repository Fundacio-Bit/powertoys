package org.fundaciobit.powertoys.back.controller;

import org.fundaciobit.powertoys.persistence.FitxerJPA;
import org.fundaciobit.powertoys.model.entity.Fitxer;

import org.fundaciobit.genapp.common.filesystem.IFileManager;
import org.fundaciobit.genapp.common.web.controller.FilesFormManager;


/**
 * Gestiona Multiples Fitxers d'un Form
 * 
 * @author anadal
 * 
 */
public class powertoysFilesFormManager extends FilesFormManager<Fitxer> {

  public powertoysFilesFormManager(IFileManager<Fitxer> fitxerEjb) {
    super(fitxerEjb);
  }

  @Override
  public FitxerJPA createEmptyFile() {    
    return new FitxerJPA();
  }

}

package org.fundaciobit.powertoys.logic.earmoduls;

import java.util.List;

/**
 * 
 * @author anadal
 * 11 jul 2025 12:19:47
 */
public class RedhatJarsToModules {

    String fileName;
    boolean isEar;
    List<String> redhatJarsToModules;
    String plugin;
    
    public RedhatJarsToModules(String fileName, boolean isEar, List<String> redhatJarsToModules, String plugin) {
        super();
        this.fileName = fileName;
        this.isEar = isEar;
        this.redhatJarsToModules = redhatJarsToModules;
        this.plugin = plugin;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isEar() {
        return isEar;
    }

    public void setEar(boolean isEar) {
        this.isEar = isEar;
    }

    public List<String> getRedhatJarsToModules() {
        return redhatJarsToModules;
    }

    public void setRedhatJarsToModules(List<String> redhatJarsToModules) {
        this.redhatJarsToModules = redhatJarsToModules;
    }

    public String getPlugin() {
        return plugin;
    }

    public void setPlugin(String plugin) {
        this.plugin = plugin;
    }
    
}

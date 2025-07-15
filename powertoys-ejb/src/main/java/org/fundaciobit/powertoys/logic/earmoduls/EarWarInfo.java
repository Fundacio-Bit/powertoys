package org.fundaciobit.powertoys.logic.earmoduls;

import java.util.List;

/**
 * 
 * @author anadal
 * 11 jul 2025 12:20:05
 */

public class EarWarInfo {

    protected final String fileName;

    protected RedhatJarsToModules redhatJarsToModules = null;

    protected JbossDeploymentStructure jbossDeploymentStructure = null;

    protected List<String> potencialCanviDeJarAModul = null;

    protected List<String> errors = null;

    public EarWarInfo(String fileName) {
        super();
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public RedhatJarsToModules getRedhatJarsToModules() {
        return redhatJarsToModules;
    }

    public void setRedhatJarsToModules(RedhatJarsToModules redhatJarsToModules) {
        this.redhatJarsToModules = redhatJarsToModules;
    }

    public JbossDeploymentStructure getJbossDeploymentStructure() {
        return jbossDeploymentStructure;
    }

    public void setJbossDeploymentStructure(JbossDeploymentStructure jbossDeploymentStructure) {
        this.jbossDeploymentStructure = jbossDeploymentStructure;
    }

    public List<String> getPotencialCanviDeJarAModul() {
        return potencialCanviDeJarAModul;
    }

    public void setPotencialCanviDeJarAModul(List<String> potencialCanviDeJarAModul) {
        this.potencialCanviDeJarAModul = potencialCanviDeJarAModul;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

}

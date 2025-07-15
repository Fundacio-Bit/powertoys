package org.fundaciobit.powertoys.logic.earmoduls;

import java.util.List;

/**
 * 
 * @author anadal
 * 11 jul 2025 13:57:06
 */
public class JbossDeploymentStructure {

    String titol;
    String deploymentStart;
    String deploymentEnd;
    List<String> modules;

    public JbossDeploymentStructure(String titol, String deploymentStart, String deploymentEnd, List<String> modules) {
        super();
        this.titol = titol;
        this.deploymentStart = deploymentStart;
        this.deploymentEnd = deploymentEnd;
        this.modules = modules;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getDeploymentStart() {
        return deploymentStart;
    }

    public void setDeploymentStart(String deploymentStart) {
        this.deploymentStart = deploymentStart;
    }

    public String getDeploymentEnd() {
        return deploymentEnd;
    }

    public void setDeploymentEnd(String deploymentEnd) {
        this.deploymentEnd = deploymentEnd;
    }

    public List<String> getModules() {
        return modules;
    }

    public void setModules(List<String> modules) {
        this.modules = modules;
    }

}

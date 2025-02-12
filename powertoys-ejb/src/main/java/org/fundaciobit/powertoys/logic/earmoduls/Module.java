package org.fundaciobit.powertoys.logic.earmoduls;

/**
 * Classe que representa un mòdul de JBoss.
 */
public class Module {
    private String[] jars;;

    private String module;

    public Module() {
        super();
    }

    public Module(String module, String[] jars) {
        super();
        this.module = module;
        this.jars = jars;
    }

    public String[] getJars() {
        return jars;
    }

    public void setJars(String[] jars) {
        this.jars = jars;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getEarEntry() {

        //             <!-- Requereix afegir mòdul 'org.bouncycastle' a jboss-deployment-structure.xml -->
        //                        **/bcprov-jdk*.redhat-*.jar,
        //                        **/bcmail-jdk*.redhat-*.jar,
        //                        **/bcpkix-jdk*.redhat-*.jar,

        StringBuffer sb = new StringBuffer();
        sb.append("                        <!-- Requereix afegir mòdul '" + getModule()
                + "' a jboss-deployment-structure.xml -->\n");

        for (String jar : jars) {

            String nameBeforeVersion = ParserJarName.getBaseOfRedhatJarFilename(jar); //getBaseNameOfJar(jar);

            if (nameBeforeVersion != null) {
                sb.append("                         **/" + nameBeforeVersion + "*redhat*.jar,\n");
            }

        }

        return sb.toString();

    }

    public String getDeploymentStructure() {
        return "            <module name=\"" + getModule() + "\" export=\"TRUE\"/>\n";
    }

}

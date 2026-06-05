package org.fundaciobit.powertoys.logic.earmoduls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jboss.logging.Logger;

/**
 * Classe abstracta que conté la lògica per a la gestió de mòduls de JBoss.
 */
public abstract class JBoss {
    
    protected final Logger log = Logger.getLogger(getClass());

    protected final List<Module> moduls;

    protected final Map<String, Module> modulByBaseName = new HashMap<String, Module>();

    protected final Map<String, Module> modulByModuleName = new HashMap<String, Module>();

    protected final Map<String, String> anothersBaseJarToModule; //new HashMap<String, String>();

    protected final Map<String, Module> jarNameToModule = new HashMap<String, Module>();

    public JBoss(List<Module> moduls) {

        this.moduls = new ArrayList<Module>(moduls);

        // PATCH per Log4J
        /*
        for (Module module : moduls) {
            if (module.getModule().equals("org.apache.log4j")) {
                module.setJars(new String[] {"log4j-1.2.17.jar"} );
            }
        //            if (module.getModule().equals("javax.xml.bind.api")) {
        //                
        //                String[] currentJars = module.getJars();
        //                String[] newJars = new String[currentJars.length + 1];
        //                System.arraycopy(currentJars, 0, newJars, 0, currentJars.length);
        //                newJars[currentJars.length] = "jaxb-api-2.3.1.jar";
        //                
        //                module.setJars(newJars);
        //            }
        }
        */

        for (Module module : moduls) {

            for (String jar : module.getJars()) {

                String base = ParserJarName.getBaseOfRedhatJarFilename(jar);

                if (base != null) {
                    modulByBaseName.put(base, module);
                }

            }

            modulByModuleName.put(module.getModule(), module);

        }

        for (Module m : moduls) {

            String[] jars = m.getJars();

            for (String jar : jars) {
                jarNameToModule.put(jar, m);
            }

        }

        /*
        Com incloure jaxb-core a la llista de moduls? 
                
                EXEMPLES
                
                javax.activation-api-1.2.0.jar  >>   MODUL   javax.activation.api
                javax.activation-1.2.0.jar  >>   MODUL   javax.activation.api
                javax.annotation-api-1.3.2.jar >>   MODUL   javax.annotation.api
                javax.ejb-api-3.2.2.jar >>   MODUL   javax.ejb.api
                javax.jws-api-1.1.jar >> MODUL javax.jws.api
                javax.transaction-api-1.3.jar >> MODUL javax.transaction.api
                jaxb-core-2.3.0.1.jar   >>   MODUL   com.sun.xml.bind
                */

        anothersBaseJarToModule = getDefaultAnothersBaseJarToModule();

        // Servlet API
        {
            // javax.servlet-api-4.0.1.jar

            final String msg = "CAS PUNTUAL: El jar {0} ja està inclòs a JBoss EAP/WildFly."
                    + " Es recomana cercar on s´utilitza i marcar-ho com a <scope>provided</scope>";

            anothersBaseJarToModule.put("javax.servlet-api", msg);

            // jboss-servlet-api_4.0_spec-2.0.0.Final-redhat-00001.jar
            anothersBaseJarToModule.put("jboss-servlet-api_4.0_spec", msg);

        }

        // jaxb-api-2.3.1.jar
        {
            final String msg = "CAS PUNTUAL: Es recomana substiruir la dependència associada al jar {0}"
                    + " per la dependència org.jboss.spec.javax.xml.bind::jboss-jaxb-api_2.3_spec";

            anothersBaseJarToModule.put("jaxb-api", msg);
        }

        // log4j-1.2.17.jar
        {
            Module module = modulByModuleName.get("org.apache.log4j");
            final String msg = "CAS PUNTUAL: Es recomana substiruir la dependència associada al jar {0} afegint "
                    + "entrada " + module.getDeploymentStructure() + " a jboss-deployment-structure.xml "
                    + "i afegint entrada " + module.getEarEntry()
                    + "\n**/log4j-*.jar, a <packagingExcludes> del plugin de ear/war";

            anothersBaseJarToModule.put("log4j", msg);
        }


        anothersBaseJarToModule.put("jersey-client",
                "Intentau actualitzar de Jersey 1.x (Dependència com.sun.jersey::jersey-client -> {0}) "
                + "a Jersey 2.x (Depèndència org.jboss.resteasy::resteasy-client)");
    }

    /**
     * Missatge per recomanar substituir un jar per un mòdul de JBoss
     * @param modulByModuleName
     * @param module
     * @return
     */
    public static String getMessageReplaceJarForModule(Map<String, Module> modulByModuleName, String module) {
        Module m = modulByModuleName.get(module);

        return "CAS PUNTUAL: Es recomana substiruir el jar {0} pel mòdul de JBoss [" + m.getModule() + "]:\n"
                + "(i) Afegir entrada '" + m.getDeploymentStructure() + "' a jboss-deployment-structure.xml\n"
                + "(ii) Afegir entrada **/{0} a <packagingExcludes> del plugin de ear/war.";
    }

    public List<Module> getModuls() {
        return moduls;
    }

    public Map<String, Module> getModulByBaseName() {
        return modulByBaseName;
    }

    public Map<String, Module> getModulByModuleName() {
        return modulByModuleName;
    }

    public abstract Map<String, String> getDefaultAnothersBaseJarToModule();

    public Map<String, String> getAnothersBaseJarToModule() {
        return anothersBaseJarToModule;
    }

    public Map<String, Module> getJarNameToModule() {
        return jarNameToModule;
    }

}

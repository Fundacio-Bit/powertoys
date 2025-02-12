package org.fundaciobit.powertoys.logic.earmoduls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe abstracta que conté la lògica per a la gestió de mòduls de JBoss.
 */
public abstract class JBoss {

    protected final List<Module> moduls;

    protected final Map<String, Module> modulByBaseName = new HashMap<String, Module>();

    protected final Map<String, Module> modulByModuleName = new HashMap<String, Module>();

    protected final Map<String, String> anothersBaseJarToModule = new HashMap<String, String>();

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

        // KEY es la base del jar !!!!   
        anothersBaseJarToModule.put("activation",
                getMessageReplaceJarForModule(modulByModuleName, "javax.activation.api"));
        
        anothersBaseJarToModule.put("javax.activation-api",
                getMessageReplaceJarForModule(modulByModuleName, "javax.activation.api"));
        anothersBaseJarToModule.put("javax.activation",
                getMessageReplaceJarForModule(modulByModuleName, "javax.activation.api"));
        anothersBaseJarToModule.put("javax.annotation-api",
                getMessageReplaceJarForModule(modulByModuleName, "javax.annotation.api"));
        anothersBaseJarToModule.put("javax.ejb-api", getMessageReplaceJarForModule(modulByModuleName, "javax.ejb.api"));
        anothersBaseJarToModule.put("javax.jws-api", getMessageReplaceJarForModule(modulByModuleName, "javax.jws.api"));
        anothersBaseJarToModule.put("javax.transaction-api",
                getMessageReplaceJarForModule(modulByModuleName, "javax.transaction.api"));
        anothersBaseJarToModule.put("jaxb-core", getMessageReplaceJarForModule(modulByModuleName, "com.sun.xml.bind"));
        
        anothersBaseJarToModule.put("jsr311-api", getMessageReplaceJarForModule(modulByModuleName, "javax.ws.rs.api"));
        
       
        // jaxb-api-2.3.1.jar
        {
           final String msg = "CAS PUNTUAL: Es recomana substiruir la dependència associada al jar {0} per la dependència org.jboss.spec.javax.xml.bind::jboss-jaxb-api_2.3_spec";   
        
           anothersBaseJarToModule.put("jaxb-api", msg);
        }
        
     // log4j-1.2.17.jar
        {
            Module module = modulByModuleName.get("org.apache.log4j");
            final String msg = "CAS PUNTUAL: Es recomana substiruir la dependència associada al jar {0} afegint "
                    + "entrada " + module.getDeploymentStructure() + " a jboss-deployment-structure.xml "
                    + "i afegint entrada " + module.getEarEntry() + "\n**/log4j-*.jar, a <packagingExcludes> del plugin de ear/war";   
         
            anothersBaseJarToModule.put("log4j", msg);
         }
        
        // "javax.xml.bind.api")) {
//      
//      String[] currentJars = module.getJars();
//      String[] newJars = new String[currentJars.length + 1];
//      System.arraycopy(currentJars, 0, newJars, 0, currentJars.length);
//      newJars[currentJars.length] = "jaxb-api-2.3.1.jar"
        

        anothersBaseJarToModule.put("jersey-client",
                "Intentau actualitzar de Jersey 1.x (Dependència com.sun.jersey::jersey-client -> {0}) a Jersey 2.x (Depèndència org.jboss.resteasy::resteasy-client)");
    }

    private static String getMessageReplaceJarForModule(Map<String, Module> modulByModuleName, String module) {
        Module m = modulByModuleName.get(module);
        return "CAS PUNTUAL: Es recomana susbtiruir el jar {0} pel mòdul de JBoss ''" + m.getModule() + "'' ("
                + Arrays.toString(m.getJars()) + ")";
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

    public Map<String, String> getAnothersBaseJarToModule() {
        return anothersBaseJarToModule;
    }

    public Map<String, Module> getJarNameToModule() {
        return jarNameToModule;
    }

}

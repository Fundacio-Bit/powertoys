package org.fundaciobit.powertoys.logic.earmoduls;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.io.IOUtils;

/**
 * @author anadal
 */
public class SearchJBossModulesInEar {

    public static void processFileEarWar(File earWarFile, List<EarWarInfo> trobats, JBoss jboss) throws Exception {
        processFileEarWar(earWarFile, earWarFile.getName(), trobats, jboss);

    }

    public static void processFileEarWar(File earWarFile, String name, List<EarWarInfo> trobats, JBoss jboss)
            throws Exception {
        //JBoss jboss = new JBoss7_2_8();
        //JBoss jboss = new JBoss7_2_0();

        Map<String, Module> jarNameToModule = jboss.getJarNameToModule();

        List<String> potencialCanviDeJarAModul = new ArrayList<String>();

        List<String> redhats = getLibsRedhat(earWarFile, name, potencialCanviDeJarAModul, jboss, trobats);

        Set<String> jaProcessats = new HashSet<String>();

        List<String> redhatJarsToModules = new ArrayList<String>();

        List<String> jbossDeploymentStructure = new ArrayList<String>();

        Set<String> errors = new HashSet<String>();

        Collections.sort(redhats);

        Map<String, String> modulenameToJar = new TreeMap<String, String>();

        for (String redhat : redhats) {
            Module m = jarNameToModule.get(redhat);
            if (m != null) {
                modulenameToJar.put(m.getModule(), redhat);
            }
        }

        for (String redhat : modulenameToJar.values()) {

            Module m = jarNameToModule.get(redhat);
            if (m == null) {
                errors.add(redhat);
            } else {

                if (jaProcessats.contains(m.getModule())) {
                    continue;
                }

                //System.out.println(" ----- " + redhat + " -------------");

                redhatJarsToModules.add(m.getEarEntry());

                jbossDeploymentStructure.add(m.getDeploymentStructure());

                jaProcessats.add(m.getModule());

            }

        }

        EarWarInfo ewinfo = new EarWarInfo(name);

        final boolean isEar = name.endsWith(".ear");

        if (redhatJarsToModules.size() != 0) {
            String plugin = isEar ? "maven-ear-plugin" : "maven-war-plugin";

            ewinfo.setRedhatJarsToModules(new RedhatJarsToModules(name.substring(0, name.lastIndexOf('.')), isEar,
                    redhatJarsToModules, plugin));

        }

        if (jbossDeploymentStructure.size() != 0) {

            String titol = "S'han trobat jars que poden ser substituits pels segünts mòduls de JBoss. Per activar aquests mòduls el que hem de fer és afegir aquestes entrades dins del fitxer src/main/application/META-INF/jboss-deployment-structure.xml del projecte d'ear";
            String deploymentStart = isEar ? "   <deployment>" : "   <sub-deployment name=\"" + name + "\">";
            String deploymentEnd = isEar ? "   </deployment>" : "   </sub-deployment>";

            ewinfo.setJbossDeploymentStructure(
                    new JbossDeploymentStructure(titol, deploymentStart, deploymentEnd, jbossDeploymentStructure));

        }

        if (errors.size() > 0) {
            /*
            StringBuilder sb = new StringBuilder();
            for (String error : errors) {
                sb.append("Revisi manualment el JAR " + error + " dins  [jboss7]\\modules\\system\\layers\\base")
                        .append("\n");
            }
            */
            ewinfo.setErrors(new ArrayList<String>(errors));

        }

        if (potencialCanviDeJarAModul.size() != 0) {
            /*
            StringBuilder sb = new StringBuilder(
                    "\n  +Potencials canvis de JAR a mòdul:\n");
            for (String potencial : potencialCanviDeJarAModul) {
                sb.append("   + " + potencial + "\n");
            }
            */
            ewinfo.setPotencialCanviDeJarAModul(potencialCanviDeJarAModul);

        }

        trobats.add(ewinfo);
    }

    /**
     * Mètode que se li passa un File a un fitxer .ear i retorna un llistat dels noms de fitxers del directori lib del fitxer .ear que contenen la paraula redhat
     */
    public static List<String> getLibsRedhat(File earFile, String name, List<String> potencialCanviDeJarAModul,
            JBoss jboss, List<EarWarInfo> trobats) throws Exception {
        // Llistat fitxers d'un zip
        // https://www.baeldung.com/java-compress-and-uncompress

        List<String> redhats = new ArrayList<String>();

        boolean isEar = name.endsWith(".ear");

        String lib = isEar ? "lib/" : "WEB-INF/lib/";

        ZipFile zipFile = new ZipFile(earFile);
        //ZipInputStream zis = new ZipInputStream(new FileInputStream(earFile));
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        ZipEntry zipEntry;
        while (entries.hasMoreElements()) {
            zipEntry = entries.nextElement();

            if (!zipEntry.isDirectory() && zipEntry.getName().startsWith(lib)) {

                String jar = zipEntry.getName().substring(lib.length());

                if (jar.contains("redhat")) {
                    redhats.add(jar);
                } else {

                    // És un jar que no conté redhat però podria tenir una versió REDHAT
                    String base = ParserJarName.getBaseOfRedhatJarFilename(jar);

                    if (base != null) {

                        // TODO
                        Module m = jboss.getModulByBaseName().get(base);

                        if (m != null) {
                            potencialCanviDeJarAModul.add("Revisau si el jar " + jar + " es pugui canviar pel mòdul "
                                    + m.getModule() + "  " + Arrays.toString(m.getJars()));
                        } else {
                            // TODO
                            base = ParserJarName.getBaseOfAnyJarFilename(jar);
                            String msg = jboss.getAnothersBaseJarToModule().get(base);
                            if (msg != null) {
                                potencialCanviDeJarAModul.add(MessageFormat.format(msg, jar));
                            }
                        }
                    }

                }
            } else {
                // Mirar si es un war

                if (zipEntry.getName().endsWith(".war")) {

                    InputStream aWar = zipFile.getInputStream(zipEntry);

                    byte[] war = IOUtils.toByteArray(aWar);

                    File temp = File.createTempFile("temp_", ".war");

                    IOUtils.write(war, new FileOutputStream(temp));

                    processFileEarWar(temp, zipEntry.getName(), trobats, jboss);

                    temp.delete();
                    temp.deleteOnExit();

                }
            }
        }

        zipFile.close();

        return redhats;

    }

}

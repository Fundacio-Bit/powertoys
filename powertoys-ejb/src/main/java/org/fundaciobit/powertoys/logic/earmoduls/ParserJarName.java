package org.fundaciobit.powertoys.logic.earmoduls;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserJarName {

    /**
     * Método para parsear el nombre del archivo JAR y eliminar la versión.
     * @param filename Nombre del archivo JAR.
     * @return Nombre del archivo sin la versión.
     */
    public static String getBaseOfAnyJarFilename(String filename) {
        if (filename == null || !filename.endsWith(".jar")) {
            return null;
        }

        // Patrón regex para capturar el nombre sin la versión
        Pattern pattern = Pattern.compile("^(.*?)-\\d+(\\.\\d+)*\\.jar$");
        Matcher matcher = pattern.matcher(filename);
        
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return null;
        }
    }
    
    
    public static final String getBaseOfRedhatJarFilename(String fileName) {
     // Expresión regular para extraer la parte del nombre antes de la versión
        String regex = "^(.+?)-\\d+\\.\\d+\\.\\d+.*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fileName);

        if (matcher.matches()) {
            // Obtener el primer grupo de captura que contiene el nombre antes de la versión
            String nameBeforeVersion = matcher.group(1);
            return nameBeforeVersion;
        } else {
           return null;
        }
    }
    

    public static void main(String[] args) {
        String[] filenames = {
            "javax.activation-api-1.2.0.4.jar",
            "javax.jws-api-1.1.jar",
            "javax.transaction-api-1.3.jar"
        };

        for (String filename : filenames) {
            try {
                String parsedName = getBaseOfAnyJarFilename(filename);
                System.out.println("Archivo: " + filename + " -> Nombre sin versión: " + parsedName);
            } catch (IllegalArgumentException e) {
                System.err.println("Error procesando archivo: " + filename + ". " + e.getMessage());
            }
        }
    }
}


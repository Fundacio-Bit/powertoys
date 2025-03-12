package org.fundaciobit.powertoys.logic.compiladornocturn;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Compilador {

    private GitHubManager ghManager;

    public void setGhManager(GitHubManager ghManager) {
        this.ghManager = ghManager;
    }

    /**
     * Constructor per inicialitzar el compilador.
     */
    public Compilador() {
    }

    /**
     * Constructor per inicialitzar el compilador amb una instància GitHubManager.
     *
     * @param gitHubManager Fitxer de propietats amb les credencials d'usuari
     */
    public Compilador(GitHubManager gitHubManager) {
        this.ghManager = gitHubManager;
    }

    /**
     * Descarrega un repositori de GitHub i fa checkout al tag especificat.
     *
     * @param tempDir Ruta del directori temporal on descarregar el repositori
     * @param gitUrl  URL del repositori de GitHub
     * @param tag     Tag del repositori a fer checkout
     * @return El directori on s'ha descarregat el repositori
     * @throws Exception Si hi ha algun error durant la descàrrega o el checkout
     */
    public File descarregarRepositori(Path tempDir, String gitUrl, String tag) throws Exception {
        if (this.ghManager == null) {
            throw new RuntimeException("GitHubManager no inicialitzat");
        }
        return this.ghManager.cloneRepositoryAtTag(tempDir, gitUrl, tag);
    }

    /**
     * Executa la comanda de compilació en el directori especificat.
     *
     * @param repoDir Directori on s'ha descarregat el repositori
     * @param comanda Comanda de compilació a executar
     * @throws Exception Si hi ha algun error durant l'execució de la comanda
     */
    public void compilarRepositori(File repoDir, String comanda) throws Exception {
        // Executar la comanda de compilació
        List<String> comandaList = new ArrayList<String>(Arrays.asList(comanda.split(" ")));
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            comandaList.add(0, "/C");
            comandaList.add(0, "cmd.exe");
        } else {
            comandaList.add(0, "-c");
            comandaList.add(0, "sh");
        }
        System.out.println("Comanda: " + comandaList);
        ProcessBuilder processBuilder = new ProcessBuilder(comandaList);
        processBuilder.directory(repoDir);
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();

        // Llegir la sortida de la comanda
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String output = reader.lines().collect(Collectors.joining("\n"));
            System.out.println(output);
        }

        // Esperar a que el procés acabi
        int exitCode = process.waitFor();
        System.out.println("Procés acabat: " + process.info() + ", codi de sortida: " + exitCode);
        if (exitCode != 0) {
            throw new RuntimeException("Error en la compilació, codi de sortida: " + exitCode + " -- comanda: "
                    + comanda + " -- directori: " + repoDir);
        }
    }

    /**
     * Descarrega un repositori de GitHub i el compila utilitzant la comanda
     * especificada.
     *
     * @param gitUrl  URL del repositori de GitHub
     * @param tag     Tag del repositori a fer checkout
     * @param comanda Comanda de compilació a executar
     * @throws Exception Si hi ha algun error durant la descàrrega o la compilació
     */
    public void descarregarICompilar(String gitUrl, String tag, String comanda) throws Exception {
        Path tempDir = null;
        try {
            // Crear un directori temporal per descarregar el repositori
            tempDir = Files.createTempDirectory("repositori");
            System.out.println("Directori temporal creat: " + tempDir);
            File repoDir = descarregarRepositori(tempDir, gitUrl, tag);
            compilarRepositori(repoDir, comanda);
        } finally {
            if (tempDir != null) {
                deleteDirectory(tempDir.toFile());
                System.out.println("Directori temporal eliminat: " + tempDir);
            }
        }
    }

    /**
     * Elimina un directori i tot el seu contingut.
     *
     * @param directory Directori a eliminar
     * @throws Exception Si hi ha algun error durant l'eliminació
     */
    private void deleteDirectory(File directory) throws Exception {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    deleteDirectory(file);
                }
            }
        }
        if (!directory.delete()) {
            throw new RuntimeException("No s'ha pogut eliminar el directori: " + directory.getAbsolutePath());
        }
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Ús: Compilador <git-url> <tag> <comanda>");
            System.exit(1);
        }

        String gitUrl = args[0];
        String tag = args[1];
        String comanda = args[2];

        Compilador compilador = new Compilador();
        try {
            compilador.descarregarICompilar(gitUrl, tag, comanda);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
package org.fundaciobit.powertoys.logic.earmoduls;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Classe que representa un mòdul de JBoss.
 */
public class GenerateModuleListOfJBoss {

    public static void main(String[] args) {
        try {

            File base = new File(
                    "D:\\dades\\dades\\CarpetesPersonals\\ProjecteBase\\jboss7\\modules\\system\\layers\\base\\");
            ArrayList<Module> moduls = new ArrayList<Module>();
            getModules(base, moduls);

            for (Module m : moduls) {
                String array = Arrays.toString(m.getJars());
                System.out.println("moduls.add(new Module(\"" + m.getModule() + "\","
                        + array.replace(", ", "\", \"").replace("]", "\"}));").replace("[", "new String[]{\""));

            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    protected static Module parseModuleXml(File modulexmlfile)
            throws ParserConfigurationException, SAXException, IOException {
        // Crear una instancia del DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true); // Habilitar el soporte de espacios de nombres
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parsear el archivo XML
        File xmlFile = modulexmlfile;
        Document document = builder.parse(xmlFile);

        // Normalizar el documento XML
        document.getDocumentElement().normalize();

        // Procesar el elemento raíz
        Element root = document.getDocumentElement();
        //System.out.println("Elemento raíz: " + root.getNodeName());
        //System.out.println("Elemento raíz [name]: " +  root.getAttribute("name"));

        Module module = new Module();
        module.setModule(root.getAttribute("name"));

        // Procesar recursos
        ArrayList<String> resources = new ArrayList<String>();
        NodeList resourceRoots = document.getElementsByTagName("resource-root");
        for (int i = 0; i < resourceRoots.getLength(); i++) {
            Node resourceRoot = resourceRoots.item(i);
            if (resourceRoot.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) resourceRoot;
                resources.add(element.getAttribute("path"));
            }
        }

        module.setJars(resources.toArray(new String[resources.size()]));

        return module;
    }

    /** 
     * Método recursivo que revise directorios en busca de ficheros module.xml
     */

    public static void getModules(File root, List<Module> moduls) throws Exception {
        if (root.isDirectory()) {
            File[] files = root.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    getModules(file, moduls);

                } else {
                    if (file.getName().equals("module.xml")) {
                        //return new Module(file);

                        Module m = parseModuleXml(file);

                        moduls.add(m);

                    }
                }
            }
        }

    }

}

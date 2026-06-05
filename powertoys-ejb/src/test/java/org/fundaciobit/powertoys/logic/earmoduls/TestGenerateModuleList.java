package org.fundaciobit.powertoys.logic.earmoduls;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author anadal
 * 13 oct 2025 11:36:38
 */
public class TestGenerateModuleList {

    
    public static void main(String[] args) {
        try {

            File base = new File(
                    "D:\\dades\\dades\\CarpetesPersonals\\ProjecteBase\\jboss-eap-7.4\\modules\\system\\layers\\base\\");
            ArrayList<Module> moduls = new ArrayList<Module>();
            GenerateModuleListOfJBoss.getModules(base, moduls);

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
}

package org.fundaciobit.powertoys.logic.earmoduls;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.fundaciobit.powertoys.logic.earmoduls.SearchJBossModulesInEar.EarWarInfo;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Jar2JBossModuleTest {

    public static void main(String[] args) {
        File earWarFile = new File(
                "test-files\\portafib.ear");
        try {

            List<EarWarInfo> trobats = new ArrayList<EarWarInfo>();

            SearchJBossModulesInEar.processFileEarWar(earWarFile, trobats);

            for (EarWarInfo earWarInfo : trobats) {
                System.out.println(" =============================================================================");
                System.out.println(
                        " =========================== " + earWarInfo.getFileName() + " ===========================");
                System.out.println(" =============================================================================");

                System.out.println(earWarInfo.getRedhatJarsToModules());

                System.out.println(earWarInfo.getJbossDeploymentStructure());

                System.out.println(earWarInfo.getPotencialCanviDeJarAModul());

                System.out.println(earWarInfo.getErrors());

            }

            System.out.println(" -- FINAL --");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

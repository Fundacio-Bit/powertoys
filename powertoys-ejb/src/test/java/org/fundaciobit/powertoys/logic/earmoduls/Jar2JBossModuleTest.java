package org.fundaciobit.powertoys.logic.earmoduls;

import static org.junit.Assert.fail;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.fundaciobit.powertoys.logic.earmoduls.SearchJBossModulesInEar.EarWarInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * Unit test for simple App.
 */
@RunWith(Parameterized.class)
public class Jar2JBossModuleTest {

    protected final static Logger log = Logger.getLogger(Jar2JBossModuleTest.class);

    // fields used together with @Parameter must be public
    @Parameter(0)
    public String testFolderPath;
    @Parameter(1)
    public String testFilePath;

    // creates the test data
    @Parameters
    public static Collection<Object[]> data() {
        final String TESTS_FOLDER_PATH = "src\\\\test\\\\java\\\\org\\\\fundaciobit\\\\powertoys\\\\logic\\\\earmoduls\\\\testfiles\\\\";
        Object[][] data = new Object[][] { { TESTS_FOLDER_PATH, "portafib.ear" },
                { TESTS_FOLDER_PATH, "portafib2.ear" } };
        return Arrays.asList(data);
    }

    @Test
    public final void testProcessFileEarWar() {
        File earWarFile = new File(testFolderPath, testFilePath);
        log.info("Processant EAR de: " + earWarFile.getAbsolutePath());

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
            log.info("Processat correctament EAR de: " + earWarFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

}

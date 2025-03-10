package org.fundaciobit.powertoys.logic.compiladornocturn;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized.Parameter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CompiladorTest {

    @Parameter(0)
    public String gitUrl;

    @Parameter(1)
    public String tag;

    @Parameter(2)
    public String comanda;

    private Compilador compilador;

    @Before
    public void setUp() {
        compilador = new Compilador();
    }

    @Parameters
    public static Collection<Object[]> data() {
        final String URL_REPO = "https://github.com/Fundacio-Bit/powertoys.git";
        final String TAG_REPO = "powertoys-1.0.1_2025-03-05";

        return Arrays.asList(new Object[][] {
                { URL_REPO, TAG_REPO, "echo No hem compilat, només hem clonat" },
                { URL_REPO, TAG_REPO, "invalidcommand" },
                { URL_REPO, TAG_REPO, "mvn clean install -DskipTests" }
        });
    }

    @Test
    public void testDescarregarICompilar() throws Exception {
        try {
            compilador.descarregarICompilar(gitUrl, tag, comanda);
        } catch (IOException e) {
            if (comanda.equals("invalidcommand")) {
                // Expected exception for invalid command
                System.out.println("Fi del test, NO hem fet la comanda, hem llançat una comanda invàlida a propòsit: " + "invalidcommand");
                return;
            } else {
                throw e;
            }
        }
    }
}
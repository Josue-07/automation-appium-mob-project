package br.com.josuelima.appium.tests;

import br.com.josuelima.appium.page.*;
import org.junit.*;

import static org.junit.Assert.*;

public class CliquesTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private CliquesPage cliquesPage = new CliquesPage();

    @Before
    public void appium() {
        menuPage.acessarMenuCliques();

    }

    @Test
    public void deveRealizarCliqueLongo() {
        cliquesPage.clicarNoBotaoDeCliqueLongo();
        assertEquals("Clique Longo", cliquesPage.obterValorDoCampo());
    }

    @Test
    public void deveRealizarCliqueDuplo() {
        cliquesPage.clicarPorTexto("Clique duplo");
        cliquesPage.clicarPorTexto("Clique duplo");

    }

}

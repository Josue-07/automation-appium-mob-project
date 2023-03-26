package br.com.josuelima.appium.tests;

import br.com.josuelima.appium.page.AbasPage;
import br.com.josuelima.appium.page.MenuPage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AbasTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private AbasPage abasPage = new AbasPage();

    @Test
    public void deveInteragirComAbas() {
        menuPage.acessarMenuAbas();
        assertTrue(abasPage.verificarConteudoAba1());
        assertEquals("Este é o conteúdo da Aba 1", abasPage.obterConteudoDaAba1());

        abasPage.clicarAba2();
        assertEquals("Este é o conteúdo da Aba 2",abasPage.obterConteudoDaAba2());


    }

}

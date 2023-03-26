package br.com.josuelima.appium.tests;

import br.com.josuelima.appium.page.MenuPage;
import org.junit.Test;

public class OpcaoEscondidaTest extends BaseTest {
    MenuPage menuPage = new MenuPage();

    @Test
    public void deveEncontrarOpcoesEscondidas() {
        menuPage.realizarScroolDown();
        menuPage.acessarMenuOpcaoBemEscondida();
        menuPage.clicarBotaoMenuOpcaoBemEscondida();
    }

}

package br.com.josuelima.appium.tests;

import br.com.josuelima.appium.page.AlertPage;
import br.com.josuelima.appium.page.MenuPage;
import io.appium.java_client.MobileBy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class AlertTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private AlertPage alertPage = new AlertPage();

    @Before
    public void setup() {
        menuPage.acessarMenuAlertas();

    }

    @Test
    public void deveConfirmarAlert() {
        alertPage.clicarBotaoAlertConfirm();

        alertPage.validarInfosDoAlert();
        assertEquals("Confirma a operação?", alertPage.obterMensagemConfirmarAlert());

        alertPage.clicarNoBotaoConfirmarNoAlert();

        alertPage.validarMensagemDeconfirmacaoAlert();
        assertEquals("Confirmado", alertPage.obterMensagemAlertConfirmado());

        alertPage.clicarBotaoSairDoAlert();
    }

    @Test
    public void deveClicarFora() {
        alertPage.clicarBotaoAlertaSimples();
        alertPage.clicarForaCaixa();
        assertTrue(!(alertPage.isElementoVisivel(MobileBy.xpath("//*[@text='Pode clicar no OK ou fora da caixa para sair']"))));


    }
}

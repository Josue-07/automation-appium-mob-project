package br.com.josuelima.appium.tests;

import br.com.josuelima.appium.page.AlertPage;
import br.com.josuelima.appium.page.MenuPage;
import org.junit.Test;

public class AlertTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private AlertPage alertPage = new AlertPage();

    @Test
    public void deveConfirmarAlert() {
        menuPage.acessarMenuAlertas();
    }
}

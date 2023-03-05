package br.com.josuelima.appium.tests;

import br.com.josuelima.appium.page.*;
import org.junit.Test;

public class SplashTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private SplashPage splashPage = new SplashPage();


    @Test
    public void deveAcessarMenuSplash() {
        menuPage.acessarMenuSplash();
        splashPage.verificarSeSplashEstaVisivel();
        splashPage.aguardarSplashSumir();
    }
}

package br.com.josuelima.appium.page;


import org.openqa.selenium.By;

public class SplashPage extends BasePage {


    public boolean verificarSeSplashEstaVisivel() {
        return isElementoVisivel(By.xpath("//*[@text='Splash!']"));

    }

    public void aguardarSplashSumir() {
        esperarElementoFicarInvisivel(By.xpath("//*[@text='Splash!']"), 5);
    }
}

package br.com.josuelima.appium.page;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class CliquesPage extends BasePage{


    public void clicarNoBotaoDeCliqueLongo(){
        cliqueLongo(MobileBy.xpath("//*[@text='Clique Longo']"));
    }

    public String obterValorDoCampo(){
        return obterTexto(By.xpath("(//android.widget.TextView)[3]"));
    }


}

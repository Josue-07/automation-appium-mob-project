package br.com.josuelima.appium.page;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class AccordionPage extends BasePage{

    public void devoClicarOP1(){
        clicar(MobileBy.xpath("//android.widget.TextView[@text='Opção 1']"));
    }

    public boolean validarDescricaoOP1(){
        return isElementoVisivel(MobileBy.xpath("//*[@text='Esta é a descrição da opção 1']"));
    }

    public String obterDescricaoOP1(){
        return obterTexto(By.xpath("//*[@text='Esta é a descrição da opção 1']"));
    }
}

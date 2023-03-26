package br.com.josuelima.appium.page;

import io.appium.java_client.MobileBy;

public class AbasPage extends BasePage {

    public boolean verificarConteudoAba1(){
        return isElementoVisivel(MobileBy.xpath("//*[@text='Este é o conteúdo da Aba 1']"));
    }

    public String obterConteudoDaAba1(){
        return obterTexto(MobileBy.xpath("//*[@text='Este é o conteúdo da Aba 1']"));
    }
    public String obterConteudoDaAba2(){
        return obterTexto(MobileBy.xpath("//*[@text='Este é o conteúdo da Aba 2']"));
    }
    public boolean verificarConteudoAba2(){
        return isElementoVisivel(MobileBy.xpath("//*[@text='Este é o conteúdo da Aba 2']"));
    }

    public void clicarAba2(){
        clicarPorTexto("ABA 2");
    }

}

package br.com.josuelima.appium.page;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class AlertPage extends BasePage {

    public void clicarBotaoAlertConfirm() {
        clicar(MobileBy.xpath("//*[@text='ALERTA CONFIRM']"));
    }

    public boolean validarInfosDoAlert() {
        return isElementoVisivel(MobileBy.xpath("//*[@text='Confirma a operação?']"));
    }

    public void clicarNoBotaoConfirmarNoAlert(){
        clicar(MobileBy.xpath("//*[@text='CONFIRMAR']"));
    }

    public boolean validarMensagemDeconfirmacaoAlert(){
        return isElementoVisivel(MobileBy.xpath("//*[@text='Confirmado']"));
    }

    public String obterMensagemConfirmarAlert(){
        return obterTexto(By.xpath("//*[@text='Confirma a operação?']"));
    }

    public void clicarBotaoSairDoAlert(){
        clicar(MobileBy.xpath("//*[@text='SAIR']"));
    }

    public String obterMensagemAlertConfirmado(){
        return obterTexto(By.xpath("//*[@text='Confirmado']"));
    }

    public void clicarBotaoAlertaSimples(){
        clicarPorTexto("ALERTA SIMPLES");
    }
    public void clicarForaCaixa(){
        esperarElementoSerVisivel(MobileBy.xpath("//*[@text='Pode clicar no OK ou fora da caixa para sair']"),5);
        tap(100,150);
    }
}

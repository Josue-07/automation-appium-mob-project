package br.com.josuelima.appium.page;

import io.appium.java_client.MobileBy;

public class MenuPage extends BasePage {

    public void acessarFormulario() {
        esperarElementoSerVisivel(MobileBy.xpath("//*[@text='Formulário']"), 10);
        clicarPorTexto("Formulário");

    }

    public void acessarMenuSplash() {
        clicarPorTexto("Splash");
    }

    public void acessarMenuAlertas() {
        clicarPorTexto("Alertas");
    }

    public void acessarMenuAbas() {
        clicarPorTexto("Abas");
    }

    public void acessarMenuAccordion() {
        clicarPorTexto("Accordion");
    }

    public void acessarMenuCliques() {
        clicarPorTexto("Cliques");
    }

    public void acessarMenuOpcaoBemEscondida(){
        clicarPorTexto("Opção bem escondida");
    }

    public void realizarScroolDown() {
        esperarElementoSerVisivel(MobileBy.xpath("//*[@text='Formulário']"), 5);
        scroll(0.9, 0.1);
    }

    public void clicarBotaoMenuOpcaoBemEscondida(){
        clicarPorTexto("OK");
    }

}

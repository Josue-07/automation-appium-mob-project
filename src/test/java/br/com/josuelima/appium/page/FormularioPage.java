package br.com.josuelima.appium.page;

import io.appium.java_client.MobileBy;

public class FormularioPage extends BasePage {

    public void preencherInputDoNome(String nome) {
        esperarElementoSerVisivel(MobileBy.AccessibilityId("nome"), 10);
        escrever(MobileBy.AccessibilityId("nome"), nome);

    }

    public String obterNomeInformado() {
        return obterTexto(MobileBy.AccessibilityId("nome"));
    }

    public void selecionarComboDeGame(String valor) throws InterruptedException {
        Thread.sleep(5000);
        selecionarComboPorTexto(MobileBy.AccessibilityId("console"), valor);
    }

    public String obterValorDoCombo() {
        return obterTexto(MobileBy.xpath("//android.widget.Spinner/android.widget.TextView"));
    }

    public void clicarCheckFormulario() {
        clicar(MobileBy.AccessibilityId("check"));
    }

    public void clicarSwitchFormulario() {
        clicar(MobileBy.AccessibilityId("switch"));
    }

    public boolean verificarCheckFormularioMarcado(String valorAtributo) {
        return isCheckMarcado(MobileBy.AccessibilityId("check"), valorAtributo);
    }

    public boolean verificarSwitchMarcado(String valorAtributo) {
        return isCheckMarcado(MobileBy.xpath("//*[@index='5']"), valorAtributo);
    }

    public void clicarBotaoSalvar() {
        clicar(MobileBy.xpath("//android.widget.Button/*[@index='0']"));
    }

    public void clicarBotaoSalvarDemorado() {
        clicar(MobileBy.xpath("//android.widget.Button/*[@text='SALVAR DEMORADO']"));
    }

    public boolean validarInformacoesDeCadastro(String texto) {
        esperarElementoSerVisivel(MobileBy.xpath("//*[starts-with(@text, '" + texto + "')]"), 10);
        return isElementoVisivel(MobileBy.xpath("//*[starts-with(@text, '" + texto + "')]"));
    }


    public void selecionarData() {
        clicarPorTexto("01/01/2000");
        esperarElementoSerVisivel(MobileBy.xpath("//*[@text='7']"), 10);
        clicarPorTexto("7");
        clicarPorTexto("OK");
    }

    public String validarDataSelecionada() {
        return obterTexto(MobileBy.xpath("//*[@text='7/2/2000']"));
    }


}

package br.com.josuelima.appium.page;

import io.appium.java_client.MobileBy;

public class FormularioPage extends BasePage {

    //private DSL dsl = new DSL();

    public void preencherInputDoNome(String nome) {
        escrever(MobileBy.AccessibilityId("nome"), nome);

    }

    public String obterNomeInformado() {
        return obterTexto(MobileBy.AccessibilityId("nome"));
    }

    public void selecionarComboDeGame(String valor) {
        selecionarComboPorTexto(MobileBy.xpath("//android.widget.Spinner[@index='2']"), valor);
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

    public boolean validarInformacoesDeCadastro(String texto) {
        return isElementoVisivel(MobileBy.xpath("//*[starts-with(@text, '" + texto + "')]"));
    }
}

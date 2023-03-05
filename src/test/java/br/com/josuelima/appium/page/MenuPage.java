package br.com.josuelima.appium.page;

public class MenuPage extends BasePage {

    public void acessarFormulario() {
        clicarPorTexto("Formulário");

    }

    public void acessarMenuSplash(){
        clicarPorTexto("Splash");
    }
    public void acessarMenuAlertas(){
        clicarPorTexto("Alertas");
    }

}

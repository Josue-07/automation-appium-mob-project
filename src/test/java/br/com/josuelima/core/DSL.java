package br.com.josuelima.core;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

import static br.com.josuelima.core.DriverFactory.getDriver;

public class DSL {

    /**
     * Clicar
     */
    public void clicar(By by) {
        getDriver().findElement(by).click();
    }

    public void clicarPorTexto(String texto) {
        getDriver().findElement(MobileBy.xpath("//*[@text='" + texto + "']")).click();
    }

    public void clicarPorIndex(int index) {
        getDriver().findElement(MobileBy.xpath("//*[@index='" + index + "']")).click();
    }

    /**
     * Escrever
     */
    public void escrever(By by, String text) {
        getDriver().findElement(by).sendKeys(text);
    }

    public String obterTexto(By by) {
        return getDriver().findElement(by).getText();
    }

    /**
     * Combo
     */
    public void selecionarComboPorTexto(By by, String valor) {
        getDriver().findElement(by).click();
        clicarPorTexto(valor);

    }

    public void selecionarComboPorIndex(By by, int index) {
        getDriver().findElement(by).click();
        clicarPorIndex(index);

    }

    /**
     * Validações de Elementos
     */
    public boolean isCheckMarcado(By by, String valor) {
        return getDriver().findElement(by).getAttribute(valor).equals("true");
    }

    public boolean isElementoVisivel(By by) {
        return getDriver().findElement(by).isDisplayed();
    }

    public boolean isElementoSelecionado(By by) {
        return getDriver().findElement(by).isSelected();
    }

    public boolean isElementoHabilitado(By by) {
        return getDriver().findElement(by).isEnabled();
    }


}

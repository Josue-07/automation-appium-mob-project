package br.com.josuelima.core;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static br.com.josuelima.core.DriverFactory.getDriver;

public class InteracoesMob {

    /*---------------------------------------------------------------------------------------*/

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
    /*---------------------------------------------------------------------------------------*/

    /**
     * Escrever
     */
    public void escrever(By by, String text) {
        getDriver().findElement(by).sendKeys(text);
    }

    public String obterTexto(By by) {
        return getDriver().findElement(by).getText();
    }

    /*---------------------------------------------------------------------------------------*/

    /**
     * Combos
     */
    public void selecionarComboPorTexto(By by, String valor) {
        getDriver().findElement(by).click();
        clicarPorTexto(valor);

    }

    public void selecionarComboPorIndex(By by, int index) {
        getDriver().findElement(by).click();
        clicarPorIndex(index);

    }
    /*---------------------------------------------------------------------------------------*/

    /*---------------------------------------------------------------------------------------*/
    /**
     * Validações de Elementos
     */
    public boolean isCheckMarcado(By by, String valor) {
        return getDriver().findElement(by).getAttribute(valor).equals("true");
    }

    public boolean isElementoVisivel(By by) {
        WebDriver driver = getDriver();
        WebElement elemento;

        try {
            elemento = driver.findElement(by);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println(e);
            return false;
        }

        return elemento.isDisplayed();
    }

    public boolean isElementoSelecionado(By by) {
        return getDriver().findElement(by).isSelected();
    }

    public boolean isElementoHabilitado(By by) {
        return getDriver().findElement(by).isEnabled();
    }
    /*---------------------------------------------------------------------------------------*/

    /**
     * Esperas
     */
    public void esperarElementoSerVisivel(By by, long tempoSegundos) {
        WebDriverWait wait = new WebDriverWait(getDriver(), tempoSegundos);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void esperarElementoFicarInvisivel(By by, long tempoSegundo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), tempoSegundo);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public boolean existeElementoPorTexto(String texto) {
        List<MobileElement> elementos = getDriver().findElements(MobileBy.xpath("//*[@text= '" + texto + "']"));
        return elementos.size() > 0;

    }
}

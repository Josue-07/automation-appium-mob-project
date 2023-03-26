package br.com.josuelima.core;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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

    public void tap(int x, int y) {
        new TouchAction(getDriver()).tap(x, y).perform();
    }

    public void clicarSeekBar(By by, double posicao) {
        MobileElement seek = getDriver().findElement(by);
        int y = seek.getLocation().y + (seek.getSize().height / 2);
        int x = (int) (seek.getLocation().x + (seek.getSize().width * posicao));

        tap(x, y);

    }

    public void cliqueLongo(By by) {
        new TouchAction(getDriver()).longPress(getDriver().findElement(by)).perform();
    }

    public void scroll(double inicio, double fim) {
        Dimension size = getDriver().manage().window().getSize();

        int x = size.width / 2;

        int start_y = (int) (size.height * inicio);
        int end_y = (int) (size.height * fim);

        new TouchAction(getDriver()).press(x, start_y)
                .waitAction(Duration.ofMillis(500))
                .moveTo(x, end_y)
                .release()
                .perform();
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

    public void esperarElementoSerClicavel(By by, long tempoSegundos) {
        WebDriverWait wait = new WebDriverWait(getDriver(), tempoSegundos);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public boolean existeElementoPorTexto(String texto) {
        List<MobileElement> elementos = getDriver().findElements(MobileBy.xpath("//*[@text= '" + texto + "']"));
        return elementos.size() > 0;

    }
}

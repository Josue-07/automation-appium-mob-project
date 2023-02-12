package br.com.josuelima.appium;

import br.com.josuelima.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FormularioTest extends DriverFactory {
    private AndroidDriver<MobileElement> driver;

    @Before
    public void setURL(){
        driver = getDriver();

        driver.findElement(MobileBy.xpath("//android.view.ViewGroup/*[@text='Formulário']")).click();

    }

    @After
    public void tearDown() {
        killDriver();
    }

    @Test
    public void CT001_devePreencherCampoTesxto() {

        MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
        campoNome.sendKeys("Josué Lima");

        String text = campoNome.getText();

        assertEquals("Josué Lima", text);

    }

    @Test
    public void CT002_deveInteragirCombo() {

        driver.findElement(MobileBy.xpath("//android.widget.Spinner[@index='2']")).click();

        driver.findElement(MobileBy.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();
        String comboName = driver.findElement(MobileBy.xpath("//android.widget.Spinner/android.widget.TextView")).getText();

        assertEquals("PS4", comboName);

    }

    @Test
    public void CT003_deveInteragirSwitchECheckBox() {

        driver.findElement(MobileBy.xpath("//*[@text='Nome']")).sendKeys("Josué Lima");
        driver.findElement(MobileBy.xpath("//android.widget.Spinner/android.widget.TextView")).click();
        driver.findElement(MobileBy.xpath("//android.widget.ListView/android.widget.CheckedTextView[@index='1']")).click();
        String comboName = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView[@index='0']")).getText();
        assertEquals("PS4", comboName);
        driver.findElement(MobileBy.AccessibilityId("check")).click();
        boolean check = driver.findElement(MobileBy.AccessibilityId("check")).isEnabled();
        assertTrue(check == true);
        driver.findElement(MobileBy.AccessibilityId("switch")).click();
        String checked = driver.findElement(MobileBy.xpath("//*[@index='5']")).getAttribute("checked");
        assertEquals("false", checked);

    }

    @Test
    public void CT004_deveRealizarCadastroCompleto() {
        driver.findElement(MobileBy.xpath("//android.widget.EditText[@index='1']")).sendKeys("Josué Lima");

        String name = driver.findElement(MobileBy.AccessibilityId("nome")).getText();
        assertEquals("Josué Lima", name);

        driver.findElement(MobileBy.AccessibilityId("console")).click();
        driver.findElement(MobileBy.xpath("//android.widget.ListView/*[@text='PS4']")).click();

        String videoGame = driver.findElement(MobileBy.xpath("//android.widget.Spinner/*[@text='PS4']")).getText();
        assertEquals("PS4", videoGame);

        driver.findElement(MobileBy.AccessibilityId("check")).click();

        String flagCheckBox = driver.findElement(MobileBy.AccessibilityId("check")).getAttribute("checked");
        assertEquals("true", flagCheckBox);

        driver.findElement(By.xpath("//*[@index='5']")).click();

        String flagSwitch = driver.findElement(By.xpath("//*[@index='5']")).getAttribute("checked");
        assertEquals("false", flagSwitch);

        driver.findElement(MobileBy.xpath("//android.widget.Button/*[@index='0']")).click();

        driver.findElement(MobileBy.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]")).isDisplayed();
        driver.findElement(MobileBy.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]")).isDisplayed();
        driver.findElement(MobileBy.xpath("//android.widget.TextView[starts-with(@text, 'Slider:')]")).isDisplayed();
        driver.findElement(MobileBy.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]")).isDisplayed();
        driver.findElement(MobileBy.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]")).isDisplayed();
        driver.findElement(MobileBy.xpath("//android.widget.TextView[starts-with(@text, 'Data:')]")).isDisplayed();
        driver.findElement(MobileBy.xpath("//android.widget.TextView[starts-with(@text, 'Hora:')]")).isDisplayed();
    }
}
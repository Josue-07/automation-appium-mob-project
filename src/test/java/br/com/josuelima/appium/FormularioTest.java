package br.com.josuelima.appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FormularioTest {

    @Test
    public void devePreencherCampoTesxto() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
//        desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
//        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:/Users/Public/workspace-QA/automation-appium-mob-project/src/test/resources/CTAppium_1_2.apk");

        AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<MobileElement> elements = driver.findElements(By.className("android.widget.TextView"));
        elements.get(1).click();

        MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
        campoNome.sendKeys("Josué Lima");

        String text = campoNome.getText();

        assertEquals("Josué Lima", text);

        driver.quit();
    }

    @Test
    public void deveInteragirCombo() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
//        desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
//        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:/Users/Public/workspace-QA/automation-appium-mob-project/src/test/resources/CTAppium_1_2.apk");

        AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Formulário']")).click();

//        MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
//        campoNome.sendKeys("Josué Lima");
//        String text = campoNome.getText();
//        Assert.assertEquals("Josué Lima", text);

        driver.findElement(MobileBy.xpath("//android.widget.Spinner[@index='2']")).click();

        driver.findElement(MobileBy.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();
        String comboName = driver.findElement(MobileBy.xpath("//android.widget.Spinner/android.widget.TextView")).getText();

        assertEquals("PS4", comboName);

        driver.quit();
    }

    @Test
    public void deveInteragirSwitchECheckBox() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
//        desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
//        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:/Users/Public/workspace-QA/automation-appium-mob-project/src/test/resources/CTAppium_1_2.apk");

        AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@text='Formulário']")).click();
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
        assertEquals("false",checked);


        //driver.quit();
    }
}
package br.com.josuelima.appium.tests;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.*;
import java.io.*;
import static br.com.josuelima.core.DriverFactory.*;

public class BaseTest {

    @Rule
    public TestName testName = new TestName();

    @AfterClass
    public static void finalizarClasse() {
        killDriver();

    }

    @After
    public void tearDown() {
        capiturarScreenShot();
        getDriver().resetApp();
    }

    public void capiturarScreenShot() {
        try {
            File img = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(img, new File("target/screeshots/" + testName.getMethodName() + ".png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

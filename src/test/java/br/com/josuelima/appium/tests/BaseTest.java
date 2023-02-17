package br.com.josuelima.appium.tests;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static br.com.josuelima.core.DriverFactory.getDriver;
import static br.com.josuelima.core.DriverFactory.killDriver;

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

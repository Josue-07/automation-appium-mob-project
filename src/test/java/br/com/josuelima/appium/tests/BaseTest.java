package br.com.josuelima.appium.tests;

import org.junit.After;
import org.junit.AfterClass;

import static br.com.josuelima.core.DriverFactory.getDriver;
import static br.com.josuelima.core.DriverFactory.killDriver;

public class BaseTest {

    @AfterClass
    public static void finalizarClasse() {
        killDriver();

    }

    @After
    public void tearDown() {
        getDriver().resetApp();
    }
}

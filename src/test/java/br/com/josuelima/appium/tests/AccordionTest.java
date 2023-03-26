package br.com.josuelima.appium.tests;

import br.com.josuelima.appium.page.AccordionPage;
import br.com.josuelima.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccordionTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private AccordionPage accordionPage = new AccordionPage();

    @Test
    public void devoInteragirComAccordion() {
        menuPage.acessarMenuAccordion();
        accordionPage.devoClicarOP1();
        accordionPage.validarDescricaoOP1();
        assertEquals("Esta é a descrição da opção 1",accordionPage.obterDescricaoOP1());


    }
}

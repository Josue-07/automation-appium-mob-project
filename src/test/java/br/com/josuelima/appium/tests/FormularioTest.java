package br.com.josuelima.appium.tests;

import br.com.josuelima.appium.page.FormularioPage;
import br.com.josuelima.appium.page.MenuPage;
import br.com.josuelima.core.DSL;
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

import static br.com.josuelima.core.DriverFactory.getDriver;
import static br.com.josuelima.core.DriverFactory.killDriver;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FormularioTest extends BaseTest {
    private DSL dsl = new DSL();
    private MenuPage menuFormulario = new MenuPage();
    private FormularioPage formularioPage = new FormularioPage();

    @Before
    public void startAppium() {
        menuFormulario.acessarFormulario();

    }



    @Test
    public void CT001_devePreencherCampoTesxto() {
        formularioPage.preencherInputDoNome("Josué Lima");
        String text = formularioPage.obterNomeInformado();

        assertEquals("Josué Lima", text);

    }

    @Test
    public void CT002_deveInteragirCombo() {
        formularioPage.selecionarComboDeGame("PS4");
        String comboName = formularioPage.obterValorDoCombo();
        assertEquals("PS4", comboName);

    }

    @Test
    public void CT003_deveInteragirSwitchECheckBox() {
        formularioPage.preencherInputDoNome("Josué Lima");
        formularioPage.selecionarComboDeGame("PS4");
//        clicar(MobileBy.xpath("//android.widget.Spinner/android.widget.TextView"));
//        clicar(MobileBy.xpath("//android.widget.ListView/android.widget.CheckedTextView[@index='1']"));
        String comboName = formularioPage.obterValorDoCombo();
        assertEquals("PS4", comboName);
        formularioPage.clicarCheckFormulario();
        boolean check = formularioPage.verificarCheckFormularioMarcado("checked");
        assertTrue(check == true);
        formularioPage.clicarSwitchFormulario();
        boolean checked = formularioPage.verificarSwitchMarcado("checked");
        assertTrue(checked == false);

    }

    @Test
    public void CT004_deveRealizarCadastroCompleto() {
        formularioPage.preencherInputDoNome("Josué Lima");
        String name = formularioPage.obterNomeInformado();
        assertEquals("Josué Lima", name);

        formularioPage.selecionarComboDeGame("PS4");
        String videoGame = formularioPage.obterValorDoCombo();
        assertEquals("PS4", videoGame);

        formularioPage.clicarCheckFormulario();
        boolean flagCheckBox = formularioPage.verificarCheckFormularioMarcado("checked");
        assertTrue(flagCheckBox == true);

        formularioPage.clicarSwitchFormulario();
        boolean flagSwitch = formularioPage.verificarSwitchMarcado("checked");

        assertTrue(flagSwitch == false);
        formularioPage.clicarBotaoSalvar();

        formularioPage.validarInformacoesDeCadastro("Nome:");
        formularioPage.validarInformacoesDeCadastro("Console:");
        formularioPage.validarInformacoesDeCadastro("Slider:");
        formularioPage.validarInformacoesDeCadastro("Switch:");
        formularioPage.validarInformacoesDeCadastro("Checkbox:");
        formularioPage.validarInformacoesDeCadastro("Data:");
        formularioPage.validarInformacoesDeCadastro("Hora:");

    }
}
package br.com.josuelima.appium.tests;

import br.com.josuelima.appium.page.FormularioPage;
import br.com.josuelima.appium.page.MenuPage;
import io.appium.java_client.MobileBy;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.concurrent.TimeUnit;

import static br.com.josuelima.core.DriverFactory.getDriver;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FormularioTest extends BaseTest {
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
    public void CT002_deveInteragirCombo() throws InterruptedException {
        formularioPage.selecionarComboDeGame("PS4");
        String comboName = formularioPage.obterValorDoCombo();
        assertEquals("PS4", comboName);

    }

    @Test
    public void CT003_deveInteragirSwitchECheckBox() throws InterruptedException {
        formularioPage.preencherInputDoNome("Josué Lima");
        formularioPage.selecionarComboDeGame("PS4");

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
    public void CT004_deveRealizarCadastroCompleto() throws InterruptedException {
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

    @Test
    public void CT005_deveRealizarCadastroDemorado() throws InterruptedException {
        getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

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
        formularioPage.clicarBotaoSalvarDemorado();

        formularioPage.validarInformacoesDeCadastro("Nome:");


    }

    @Test
    public void CT006_deveAlterarData() throws InterruptedException {
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

        formularioPage.selecionarData();
        assertEquals("7/2/2000", formularioPage.validarDataSelecionada());

        formularioPage.clicarBotaoSalvar();

        formularioPage.validarInformacoesDeCadastro("Nome:");
        formularioPage.validarInformacoesDeCadastro("Console:");
        formularioPage.validarInformacoesDeCadastro("Slider:");
        formularioPage.validarInformacoesDeCadastro("Switch:");
        formularioPage.validarInformacoesDeCadastro("Checkbox:");
        formularioPage.validarInformacoesDeCadastro("Data:");
        formularioPage.validarInformacoesDeCadastro("Hora:");

    }

    @Test
    public void CT007_deveInteragirComSeekBar(){

        formularioPage.clicarSeekBar(MobileBy.AccessibilityId("slid"),0.50);
        formularioPage.clicarBotaoSalvar();


    }
}
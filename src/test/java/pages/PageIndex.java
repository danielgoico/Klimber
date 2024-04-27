package pages;

import helpers.utils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageIndex {
    private WebDriver driver;
    private By inputFechNac;
    private By comboProvincia;
    private By inputCodTel;
    private By inputTel;

    private By lblMenuCoberturaVidaDesplegado;

    private By lblMenuCoberturaAccidenteDesplegado;

    private By lblMenuCoberturaInvalidezDesplegado;

    private By lblMenuCoberturaEnfermedadDesplegado;


    private By btnContratar;


    public PageIndex(WebDriver driver) {
        this.driver = driver;
        inputFechNac = By.name("Birthday");
        comboProvincia = By.xpath("//*[@id='select2-province-container']");
        inputCodTel = By.id("txtPhoneCode");
        inputTel = By.id("txtPhoneNumber");

        lblMenuCoberturaVidaDesplegado = By.xpath("//*[contains(text(),'Duelo')]");

        lblMenuCoberturaAccidenteDesplegado = By.xpath("//*[contains(text(),'Actos peligrosos')]");

        lblMenuCoberturaInvalidezDesplegado = By.xpath("//*[contains(text(),'envenenamientos de cualquier naturaleza')]");

        lblMenuCoberturaEnfermedadDesplegado = By.xpath("//*[contains(text(),'Herida o enfermedad')]");

        btnContratar = By.id("btnSaveStep1");
    }

    public void completarDatos(String fechNac, String datoProvincia, String codTel, String tel) {
        driver.findElement(inputFechNac).sendKeys(fechNac);
        utils util = new utils();
        util.sleepSeconds(2);
        driver.findElement(comboProvincia).click();
        util.sleepSeconds(2);
        driver.findElement(By.xpath("//input[@class='select2-search__field']")).click();
        // Crear una instancia de la clase Actions
        Actions actions = new Actions(driver);
        // Ingresar texto y simular la tecla "Enter"
        actions.sendKeys(datoProvincia, Keys.ENTER).perform();
        util.sleepSeconds(1);

        driver.findElement(inputCodTel).sendKeys(codTel);
        driver.findElement(inputTel).sendKeys(tel);
        util.sleepSeconds(2);
    }

    public void desplazarSlideCuota() {
        WebElement slider = driver.findElement(By.xpath("//div[@class='slider-handle min-slider-handle round']"));
        utils util = new utils();
        utils.scrollToElement(driver, slider);
        util.sleepSeconds(2);
        Actions actions = new Actions(driver);

        int offsetX = slider.getSize().getWidth() / 2; // Calcula la mitad del ancho del control deslizante
        actions.clickAndHold(slider).moveByOffset(offsetX, 0).release().perform();
        util.sleepSeconds(2);
    }

    public void adicionalInvalidez() {
        WebElement radioBtnInvalidez = driver.findElement(By.id("chkDisability"));
        // Se desplaza hasta el elemento
        utils.scrollToElement(driver, radioBtnInvalidez);
        radioBtnInvalidez.click();
        utils util = new utils();
        util.sleepSeconds(2);
        boolean estaMarcadoInvalidez = radioBtnInvalidez.isSelected();

        // Si no se marca a la primera, se intenta una segunda vez.
        if (!estaMarcadoInvalidez) {
            radioBtnInvalidez.click();
            util.sleepSeconds(2);
        }
    }

    public void adicionalAccidente() {
        WebElement radioBtnAccidente = driver.findElement(By.id("chkAccident"));
        // Llamar al método scrollToElement para desplazarte hasta el elemento
        utils.scrollToElement(driver, radioBtnAccidente);
        radioBtnAccidente.click();
        utils util = new utils();
        util.sleepSeconds(2);

        boolean estaMarcadoAccidente = radioBtnAccidente.isSelected();
        // Si no se marca a la primera, se intenta una segunda vez.
        if (!estaMarcadoAccidente) {
            radioBtnAccidente.click();
            util.sleepSeconds(2);
        }
    }

    public void adicionalEnfermedad() {
        WebElement radioBtnEnfermedad = driver.findElement(By.id("chkIllness"));
        // Llamar al método scrollToElement para desplazarte hasta el elemento
        utils.scrollToElement(driver, radioBtnEnfermedad);
        utils util = new utils();
        util.sleepSeconds(2);
        radioBtnEnfermedad.click();
        util.sleepSeconds(2);

        boolean estaMarcadoEnfermedad = radioBtnEnfermedad.isSelected();
        // Si no se marca a la primera, se intenta una segunda vez.
        if (!estaMarcadoEnfermedad) {
            radioBtnEnfermedad.click();
            util.sleepSeconds(2);
        }
    }

    public void todosLosAdicionales() {
        WebElement radioBtnInvalidez = driver.findElement(By.id("chkDisability"));
        // Se desplaza hasta el elemento
        utils.scrollToElement(driver, radioBtnInvalidez);
        radioBtnInvalidez.click();
        utils util = new utils();
        util.sleepSeconds(2);
        boolean estaMarcadoInvalidez = radioBtnInvalidez.isSelected();

        // Si no se marca a la primera, se intenta una segunda vez.
        if (!estaMarcadoInvalidez) {
            radioBtnInvalidez.click();
            util.sleepSeconds(2);
        }

        WebElement radioBtnAccidente = driver.findElement(By.id("chkAccident"));
        // Llamar al método scrollToElement para desplazarte hasta el elemento
        utils.scrollToElement(driver, radioBtnAccidente);
        radioBtnAccidente.click();
        util.sleepSeconds(2);

        boolean estaMarcadoAccidente = radioBtnAccidente.isSelected();
        // Si no se marca a la primera, se intenta una segunda vez.
        if (!estaMarcadoAccidente) {
            radioBtnAccidente.click();
            util.sleepSeconds(2);
        }

        WebElement radioBtnEnfermedad = driver.findElement(By.id("chkIllness"));
        // Llamar al método scrollToElement para desplazarte hasta el elemento
        utils.scrollToElement(driver, radioBtnEnfermedad);
        util.sleepSeconds(2);
        radioBtnEnfermedad.click();
        util.sleepSeconds(2);

        boolean estaMarcadoEnfermedad = radioBtnEnfermedad.isSelected();
        // Si no se marca a la primera, se intenta una segunda vez.
        if (!estaMarcadoEnfermedad) {
            radioBtnEnfermedad.click();
            util.sleepSeconds(2);
        }
    }

    public void desplegablesExclusiones() {
        WebElement lblMenuCoberturaVida = driver.findElement(By.xpath("//button[contains(text(),'Cobertura')]"));
        utils util = new utils();
        // Se dezplaza hasta el elemento
        utils.scrollToElement(driver, lblMenuCoberturaVida);
        util.sleepSeconds(2);
        lblMenuCoberturaVida.click();
        util.sleepSeconds(2);
        String txtLblCoberturaVida = driver.findElement(lblMenuCoberturaVidaDesplegado).getText();
        String txtEsperadoLblCoberturaVida = "Duelo";
        Assert.assertTrue("Cobertura de vida no coincide",
                txtLblCoberturaVida.contains(txtEsperadoLblCoberturaVida));

        WebElement lblMenuCoberturaAccidental = driver.findElement(By.xpath("//button[contains(text(),'Accidental')]"));
        // Se dezplaza hasta el elemento
        utils.scrollToElement(driver, lblMenuCoberturaAccidental);
        util.sleepSeconds(2);
        lblMenuCoberturaAccidental.click();
        util.sleepSeconds(2);
        String txtLblCoberturaAccidental = driver.findElement(lblMenuCoberturaAccidenteDesplegado).getText();
        String txtEsperadoLblAccidental = "Actos peligrosos";
        Assert.assertTrue("Cobertura por accidente no coincide",
                txtLblCoberturaAccidental.contains(txtEsperadoLblAccidental));

        WebElement lblMenuCoberturaInvalidez = driver.findElement(By.xpath("//button[contains(text(),'Asegurada por Invalidez por Accidente')]"));
        utils.scrollToElement(driver, lblMenuCoberturaInvalidez);
        util.sleepSeconds(2);
        lblMenuCoberturaInvalidez.click();
        util.sleepSeconds(2);
        String txtLblCoberturaInvalidez = driver.findElement(lblMenuCoberturaInvalidezDesplegado).getText();
        String txtEsperadoLblCoberturaInvalidez = "envenenamientos de cualquier naturaleza";
        Assert.assertTrue("Cobertura por invalidez no coincide",
                txtLblCoberturaInvalidez.contains(txtEsperadoLblCoberturaInvalidez));

        WebElement lblMenuCoberturaEnfermedad = driver.findElement(By.xpath("//button[contains(text(),'Enfermedad')]"));
        // Se dezplaza hasta el elemento
        utils.scrollToElement(driver, lblMenuCoberturaEnfermedad);
        util.sleepSeconds(2);
        lblMenuCoberturaEnfermedad.click();
        util.sleepSeconds(2);
        String txtLblCoberturaEnfermedad = driver.findElement(lblMenuCoberturaEnfermedadDesplegado).getText();
        String txtEsperadoLblCoberturaEnfermedad = "Herida o enfermedad";
        Assert.assertTrue("Cobertura por enfermedad no coincide",
                txtLblCoberturaEnfermedad.contains(txtEsperadoLblCoberturaEnfermedad));

    }

    public void obtenerHrefDeCondiciones() {

        WebElement enlaceDocxCondiciones = driver.findElement(By.xpath("//a[@class='custom-text-important']"));
        String hrefValor = enlaceDocxCondiciones.getAttribute("href");

        String hrefConsultarDocxCondiciones = "https://purchase-testing.klimber.com/assets-custom/images/tenant/klimber/Condiciones_Generales.pdf?v=20191111-1600";
        Assert.assertEquals(hrefValor, hrefConsultarDocxCondiciones);
    }

    public void obtenerHrefDeHipervinculos() {

        WebElement enlaceDireccionGralDefensa = driver.findElement(By.xpath("//*[contains(text(),'Direccion General')]"));
        String hrefDireccionGralDefensa = enlaceDireccionGralDefensa.getAttribute("href");

        WebElement enlaceDefensaConsumidor = driver.findElement(By.xpath("//*[contains(text(),'Defensa de las')]"));
        String hrefDefensaConsumidor = enlaceDefensaConsumidor.getAttribute("href");

        WebElement enlaceCertificado = driver.findElement(By.xpath("//*[contains(text(),'Certificado')]"));
        String hrefCertificado = enlaceCertificado.getAttribute("href");

        WebElement enlaceTyC = driver.findElement(By.xpath("//*[contains(text(),'Términos y Condiciones')]"));
        String hrefTyC = enlaceTyC.getAttribute("href");


        String hrefEsperadaDireccionGralDefensa = "https://www.buenosaires.gob.ar/defensaconsumidor";
        String hrefEsperadaDefensaDelConsumidor = "https://www.argentina.gob.ar/produccion/defensadelconsumidor/formulario";
        String hrefEsperadaCertificadoAptitud = "https://static1.squarespace.com/static/5e4c43aa99a6325e9fff6dfb/t/6027ec8be376630928007603/1613229197281/30716060574+-+11022021160456.pdf";
        String hrefEsperadaTyC = "https://www.klimber.com/tc-privacidad";

        Assert.assertEquals(hrefDireccionGralDefensa, hrefEsperadaDireccionGralDefensa);
        Assert.assertEquals(hrefDefensaConsumidor, hrefEsperadaDefensaDelConsumidor);
        Assert.assertEquals(hrefCertificado, hrefEsperadaCertificadoAptitud);
        Assert.assertEquals(hrefTyC, hrefEsperadaTyC);
    }


    public void contratar() {
        utils util = new utils();
        util.sleepSeconds(3);
        driver.findElement(btnContratar).click();
        util.sleepSeconds(3);
        String urlEsperada = "https://purchase-testing.klimber.com/ar/GroupLife/Index";
        String urlActual = driver.getCurrentUrl();
        if (urlActual == urlEsperada) {
            /* A veces el botón de "contratar" no actualiza la cifra, por eso se coloca una espera
            y que nuevamente haga click con el monto actualizado */
            driver.findElement(btnContratar).click();
            util.sleepSeconds(2);
            if (urlActual == urlEsperada) {
            /* A veces el botón de "contratar" no actualiza la cifra, por eso se coloca una espera
            y que nuevamente haga click con el monto actualizado */
                driver.findElement(btnContratar).click();
                util.sleepSeconds(2);
            }

        }

    }}




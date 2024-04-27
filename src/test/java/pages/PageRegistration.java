package pages;

import helpers.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class PageRegistration {
    private WebDriver driver;
    private By inputNombre;
    private By inputApellido;
    private By inputDocumento;
    private By comboBiologico;
    private By comboGenero;
    private By comboEstadoCivil;
       private By inputEmail;
    private By inputPassword;

    private By inputCodTel;
    private By inputNumTel;
    private By inputCalle;
    private By inputCalleNum;
    private By inputCodigoPostal;

    private By comboCiudad;
    //SELECT ciudad
    private By btnSiguienteRegistrar;

    public PageRegistration(WebDriver driver) {
        this.driver = driver;

        inputNombre = By.xpath("//input[@id='Name']");
        inputApellido = By.id("Surname");
        inputDocumento  = By.id("ID_Number");

        comboBiologico = By.xpath("//*[@id='select2-Gender-container']");
        comboGenero = By.xpath("//*[@id='select2-IdentificationGenderType-container']");
        comboEstadoCivil = By.xpath("//*[@id='select2-CivilStatus-container']");

        inputEmail  = By.id("txtEmail");
        inputPassword  = By.xpath("//input[@id='Password']");
        inputCodTel  = By.id("PhoneCode");
        inputNumTel  = By.id("PhoneNumber");
        inputCalle  = By.xpath("//input[@id='Street']");
        inputCalleNum  = By.id("HouseNumber");
        inputCodigoPostal  = By.id("zipCode");

        comboCiudad =

        btnSiguienteRegistrar  = By.id("btnRegister");

        }
        public void llenarCamposDeRegistro(String nombre, String apellido, String documento, String email, String pass, String codtel, String numtel, String calle, String callenum, String codigopostal){
        driver.findElement(inputNombre).sendKeys(nombre);
            driver.findElement(inputApellido).sendKeys(apellido);
            driver.findElement(inputDocumento).sendKeys(documento);

            driver.findElement(comboBiologico).click();
            utils util = new utils();
            util.sleepSeconds(1);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.ENTER).perform();
            util.sleepSeconds(1);

            driver.findElement(comboGenero).click();
            util.sleepSeconds(1);
            actions.sendKeys(Keys.ENTER).perform();
            util.sleepSeconds(1);

            driver.findElement(comboEstadoCivil).click();
            util.sleepSeconds(1);
            actions.sendKeys(Keys.ENTER).perform();
            util.sleepSeconds(1);

            driver.findElement(inputEmail).sendKeys(email);
            driver.findElement(inputPassword).sendKeys(pass);
            driver.findElement(inputCodTel).sendKeys(codtel);
            driver.findElement(inputNumTel).sendKeys(numtel);
            driver.findElement(inputCalle).sendKeys(calle);
            driver.findElement(inputCalleNum).sendKeys(callenum);
            driver.findElement(inputCodigoPostal).sendKeys(codigopostal);

            driver.findElement(comboCiudad).click();
            util.sleepSeconds(1);
            actions.sendKeys(Keys.ENTER).perform();
            util.sleepSeconds(1);

            utils.scrollToBottomOfPage(driver);
            util.sleepSeconds(2);
            driver.findElement(btnSiguienteRegistrar).click();

        }





}

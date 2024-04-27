package pages;

import helpers.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class PageStep6beneficiaries {
    private WebDriver driver;
    private By btnAgregarBeneficiarioPersona;
    private By inputNombreBenef;
    private By inputApellidoBenef;
    private By inputDniBenef;
    private By comboRelacion;
    private By inputDia;
    private By inputMes;
    private By inputAnio;
    private By inputCifraBeneficioPersona;

    private By btnAgregarBeneficiarioOrganizacion;
    private By inputRazonSocial;
    private By inputCuit;
    private By inputCifraBeneficioOrganizacion;
    private By btnBenefSiguiente;



    public PageStep6beneficiaries(WebDriver driver) {
        this.driver = driver;

        btnAgregarBeneficiarioPersona = By.xpath("//*[@id='btnAddBeneficiaryNatural']");
        inputNombreBenef = By.xpath("//input[@name='Beneficiaries[0].Name']");
        inputApellidoBenef = By.xpath("//input[@name='Beneficiaries[0].Surname']");
        inputDniBenef = By.xpath("//input[@name='Beneficiaries[0].IdNumber']");
        comboRelacion = By.xpath("//span[@title='Relación']");
        inputDia = By.xpath("//input[@name='Beneficiaries[0].DateDay']");
        inputMes = By.xpath("//input[@name='Beneficiaries[0].DateMonth']");
        inputAnio = By.xpath("//input[@name='Beneficiaries[0].DateYear']");
        inputCifraBeneficioPersona = By.xpath("//input[@placeholder='% Beneficio']");

        btnAgregarBeneficiarioOrganizacion = By.xpath("//*[@id='btnAddBeneficiaryLegal']");
        inputRazonSocial = By.xpath("//input[@name='Beneficiaries[1].Name']");
        inputCuit = By.xpath("//input[@name='Beneficiaries[1].TaxId']");
        inputCifraBeneficioOrganizacion = By.xpath("//input[@placeholder='% Beneficio' and @name='Beneficiaries[1].BeneficiaryPercentage']");
        btnBenefSiguiente = By.xpath("//button[@data-dontsubmit='true']");


    }

    public void agregarBeneficiarioPersona(String nombrePersona, String apellidoPersona, String dniPersona, String diaPersona, String mesPersona, String anioPersona, String cifraPersona) {
        utils util = new utils();
        util.sleepSeconds(1);
        driver.findElement(btnAgregarBeneficiarioPersona).click();
        util.sleepSeconds(1);
        driver.findElement(inputNombreBenef).sendKeys(nombrePersona);
        driver.findElement(inputApellidoBenef).sendKeys(apellidoPersona);
        driver.findElement(inputDniBenef).sendKeys(dniPersona);

        driver.findElement(comboRelacion).click();
        util.sleepSeconds(1);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
        util.sleepSeconds(1);

        driver.findElement(inputDia).sendKeys(diaPersona);
        driver.findElement(inputMes).sendKeys(mesPersona);
        driver.findElement(inputAnio).sendKeys(anioPersona);
        driver.findElement(inputCifraBeneficioPersona).sendKeys(cifraPersona);


        util.sleepSeconds(1);

    }

    public void agregarBeneficiarioOrganizacion(String razonsocial, String cuit, String cifraOrganizacion) {
        utils util = new utils();
        util.sleepSeconds(1);
        driver.findElement(btnAgregarBeneficiarioOrganizacion).click();
        util.sleepSeconds(1);
        driver.findElement(inputRazonSocial).sendKeys(razonsocial);
        driver.findElement(inputCuit).sendKeys(cuit);
        driver.findElement(inputCifraBeneficioOrganizacion).sendKeys(cifraOrganizacion);
        util.sleepSeconds(1);

    }
    public void avanzarStep6(){
        utils util = new utils();
        utils.scrollToBottomOfPage(driver);
        util.sleepSeconds(1);
        driver.findElement(btnBenefSiguiente).click();

    }

}

package pages;

import helpers.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class PageGroupLife {

    private WebDriver driver;
    private By comboNacionalidad;
    private By inputLugarNacimiento;
    private By radioBtnOtraNacionalidad;
    private By inputOtraNacionalidadPaises;
    private By inputOcupacion;
    private By inputIngresoBrutoAnual;
    private By comboOrigenDinero;
    private By btnSiguienteForm4;

    public PageGroupLife(WebDriver driver) {
        this.driver = driver;

        comboNacionalidad = By.xpath("//*[@id='select2-Nationality-container']");
        inputLugarNacimiento = By.id("PlaceOfBirth");
        radioBtnOtraNacionalidad = By.xpath("//input[@name='HasCitizenship' and @value='true']");
        inputOtraNacionalidadPaises = By.id("txtCountries");
       inputOcupacion = By.id("txtOccupation");
        inputIngresoBrutoAnual = By.id("txtSalaryAnual");
       comboOrigenDinero = By.xpath("//*[@id='select2-txtAnnualIncome-container']");
        btnSiguienteForm4 = By.id("btnSaveInfo");
    }

    public void completarDatosadicionales(String nacionalidad, String lugarnacimiento, String otranacionalidad, String ocupacion, String ingresoanual, String origendinero){

        //combo nacionalidad
        utils util = new utils();
        util.sleepSeconds(2);
        driver.findElement(comboNacionalidad).click();
        // Crear una instancia de la clase Actions
        Actions actions = new Actions(driver);
        // Ingresar texto y simular la tecla "Enter"
        actions.sendKeys(nacionalidad, Keys.ENTER).perform();
        util.sleepSeconds(1);

        driver.findElement(inputLugarNacimiento).sendKeys(lugarnacimiento);
        driver.findElement(radioBtnOtraNacionalidad).click();
        util.sleepSeconds(1);
        driver.findElement(inputOtraNacionalidadPaises).sendKeys(otranacionalidad);
        driver.findElement(inputOcupacion).sendKeys(ocupacion);
        driver.findElement(inputIngresoBrutoAnual).sendKeys(ingresoanual);

        //combo origen dinero
        driver.findElement(comboOrigenDinero).click();
        // Ingresar texto y simular la tecla "Enter"
        actions.sendKeys(origendinero, Keys.ENTER).perform();

        util.sleepSeconds(2);
        driver.findElement(btnSiguienteForm4).click();

    }



}

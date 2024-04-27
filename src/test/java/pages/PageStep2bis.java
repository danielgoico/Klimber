package pages;

import helpers.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageStep2bis {

    private WebDriver driver;
    private By inputNombreContacto;
    private By inputEmailContacto;
    private By inputTelContacto;
    private By btnSiguienteContacto;


    public PageStep2bis(WebDriver driver){
        this.driver = driver;
        inputNombreContacto = By.id("txtName");
        inputEmailContacto = By.id("txtEmailFrom");
        inputTelContacto = By.id("PhoneNumber");
        btnSiguienteContacto = By.id("btnSaveStep2_2");
    }
    public void llenarYenviarFormularoDeContacto(String nombrecontacto, String emailcontacto, String telcontacto){
        driver.findElement(inputNombreContacto).sendKeys(nombrecontacto);
        driver.findElement(inputEmailContacto).sendKeys(emailcontacto);
        driver.findElement(inputTelContacto).sendKeys(telcontacto);
        utils util = new utils();
        util.sleepSeconds(1);
        driver.findElement(btnSiguienteContacto).click();

}
}

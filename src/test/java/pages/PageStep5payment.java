package pages;

import helpers.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageStep5payment {

    private WebDriver driver;
    private By inputNumeroTarjeta;
    private By btnSiguienteFormTarjeta;

    public PageStep5payment(WebDriver driver){
        this.driver = driver;
        inputNumeroTarjeta = By.xpath("//*[@id='CardNumber']");
        btnSiguienteFormTarjeta = By.id("btnSubmitStep4");

    }

    public void cargarTarjeta(String numeroTarjeta){
        driver.findElement(inputNumeroTarjeta).sendKeys(numeroTarjeta);
        utils util = new utils();
        util.sleepSeconds(1);
        driver.findElement(btnSiguienteFormTarjeta).click();
        util.sleepSeconds(3);

    }

}

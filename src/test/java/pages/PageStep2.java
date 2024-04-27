package pages;

import helpers.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageStep2 {
    private WebDriver driver;
    private By radioBtnTratamiento;
    private By radioBtnAsistencia;
    private By radioBtnCovid;
    private By inputAltura;
    private By inputPeso;
    private By btnSiguiente;

    public PageStep2(WebDriver driver) {
        this.driver = driver;

        radioBtnTratamiento = By.xpath("//input[@name='UnderwritingCustom[0].ResponseBool' and @value='true']");
        radioBtnAsistencia = By.xpath("//input[@name='UnderwritingCustom[1].ResponseBool' and @value='true']");
        radioBtnCovid  = By.xpath("//input[@name='UnderwritingCustom[2].ResponseBool' and @value='true']");
        inputAltura  = By.id("txtHeight");
        inputPeso  = By.id("txtWeight");
        btnSiguiente  = By.id("btnSaveStep2");
}
public void seleccionarRadioButtons(){

    driver.findElement(radioBtnTratamiento).click();
    utils util = new utils();
    util.sleepSeconds(1);
    driver.findElement(radioBtnAsistencia).click();
    util.sleepSeconds(1);
    driver.findElement(radioBtnCovid).click();
    util.sleepSeconds(1);

}
public void IMC(String altura, String peso){
    driver.findElement(inputAltura).sendKeys(altura);
    driver.findElement(inputPeso).sendKeys(peso);
    utils util = new utils();
    util.sleepSeconds(1);
    }

    public void avanzar(){
        utils util = new utils();
        util.sleepSeconds(2);
        driver.findElement(btnSiguiente).click();
    }

}

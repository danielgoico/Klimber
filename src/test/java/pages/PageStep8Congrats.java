package pages;

import helpers.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertNotNull;

public class PageStep8Congrats {
    private WebDriver driver;
    private By linkPolizaEnTramite;

    // private By btnIrAmiCuenta;


    public PageStep8Congrats(WebDriver driver) {
        this.driver = driver;
        linkPolizaEnTramite = By.xpath("//*[contains(text(),'Descargá tu póliza en trámite')]");

    }

    public void verificarPolizaEnTramiteExistente() {
        driver.findElement(linkPolizaEnTramite);
        assertNotNull(linkPolizaEnTramite);
        utils util = new utils();
        util.sleepSeconds(1);
        driver.findElement(linkPolizaEnTramite).click();
        util.sleepSeconds(1);
    }
}

package pages;

import helpers.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageStep7Summary {
    private WebDriver driver;
    private By chkboxAceptarTyC;
    private By btnSiguienteTyC;
    //próximamente agregar elementos para hacer assertions sobre los datos que arroja el summary

    public PageStep7Summary(WebDriver driver) {
        this.driver = driver;
        chkboxAceptarTyC = By.id("chkTC");
        btnSiguienteTyC = By.id("btnSummarySubmit");
    }

    public void aceptarTyC() {
        WebElement chkboxAceptarTyC1 = driver.findElement(By.id("chkTC"));
        utils.scrollToElement(driver, chkboxAceptarTyC1);
        utils.scrollToBottomOfPage(driver);
        driver.findElement(chkboxAceptarTyC).click();
        utils util = new utils();
        util.sleepSeconds(1);
    }

    public void avanzarStep7() {

        utils util = new utils();
        util.sleepSeconds(1);
            driver.findElement(btnSiguienteTyC).click();
            util.sleepSeconds(5);
        }

    }


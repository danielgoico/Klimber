package helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class utils {
    public WebDriver driver;

    public void sleepSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void scrollToMiddleOfPage(WebDriver driver) {
        // Instancia de JavascriptExecutor desde WebDriver
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Obtener la altura total de la página
        Long totalHeight = (Long) js.executeScript("return document.body.scrollHeight;");

        // Desplazarse a media página
        Long middleHeight = totalHeight / 2;
        js.executeScript("window.scrollTo(0, " + middleHeight + ");");
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        // Crear instancia de JavascriptExecutor desde WebDriver
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Ejecutar el JavaScript para ir hasta el elemento
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollToBottomOfPage(WebDriver driver) {
        // Instancia JavascriptExecutor desde WebDriver
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Ejecutar el JavaScript para ir al final de la página
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        utils util = new utils();
        util.sleepSeconds(3);
    }

       public void takeScreenshot(WebDriver driver, String methodName) {
        // WebDriver a TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        // Capturar  como un archivo
        File screenshot = ts.getScreenshotAs(OutputType.FILE);
        try {
            // Guardar archivo en directorio
            FileUtils.copyFile(screenshot, new File("screenshots/" + methodName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




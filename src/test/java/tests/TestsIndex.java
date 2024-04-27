package tests;

import helpers.utils;
import io.qameta.allure.junit4.AllureJunit4;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.notification.RunListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PageIndex;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestsIndex {
    private WebDriver driver;


    @Before
    public void setUp() throws InterruptedException {
    //Usar Driver manager para ejecutar con chrome
        String browser = "firefox"; // Cambiar a "edge" para usar EdgeDriver

        if (browser.equals("firefox")) {

            System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");

            driver = new FirefoxDriver();
        } else if (browser.equals("edge")) {

            System.setProperty("webdriver.edge.driver", "Drivers/msedgedriver.exe");

            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://purchase-testing.klimber.com/ar/GroupLife/Index");

        Thread.sleep(2000);

    }

    @Test
//TC 01 - Cotizar seguro básico: Se probará la cotización de un seguro básico, con datos de entrada y sin coberturas adicionales.
    public void cotizarSeguroBasico() {
        System.out.println("Llenando datos de entrada para cotización.");
        PageIndex pageIndex = new PageIndex(driver);
        pageIndex.completarDatos("10071960", "Mendoza", "11", "33333333");

        System.out.println("Desplazándose hacia el final de la página.");
        utils.scrollToBottomOfPage(driver);
        System.out.println("Pulsando en 'Contratar'.");
        pageIndex.contratar();
        System.out.println("Tomando captura de los resultados.");
        utils tomarCaptura = new utils();
        tomarCaptura.takeScreenshot(driver, "TC 01 - Results");
        System.out.println("Proceso exitoso.");
    }

    @Test
//TC 02 - //Cotizar seguro adicionando invalidez: Se probará la cotización de un seguro, eligiendo la opción de seguro por invalidez como cobertura adicional.
    public void cotizarSeguroPorInvalidez() {
        System.out.println("Llenando datos de entrada para cotización.");
        PageIndex pageIndex = new PageIndex(driver);
        pageIndex.completarDatos("10071992", "CABA", "11", "44444444");
        System.out.println("Se selecciona adicional por invalidez.");
        pageIndex.adicionalInvalidez();
        System.out.println("Desplazándose hacia el final de la página.");
        System.out.println("Pulsando en 'Contratar'.");
        pageIndex.contratar();
        System.out.println("Tomando captura de los resultados.");
        utils tomarCaptura = new utils();
        tomarCaptura.takeScreenshot(driver, "TC 02 - Results");
        System.out.println("Proceso exitoso.");
    }

    @Test
////TC 03 - Cotizar seguro básico: Se probará la cotización de un seguro, eligiendo  la opción de seguro por accidente como cobertura adicional.
    public void cotizarSeguroPorAccidente() {
        System.out.println("Llenando datos de entrada para cotización.");
        PageIndex pageIndex = new PageIndex(driver);
        pageIndex.completarDatos("10072000", "Buenos Aires", "11", "55555555");

        pageIndex.adicionalAccidente();
        System.out.println("Desplazándose hacia el final de la página.");
        utils.scrollToBottomOfPage(driver);
        System.out.println("Pulsando en 'Contratar'.");
        pageIndex.contratar();
        System.out.println("Tomando captura de los resultados.");
        utils tomarCaptura = new utils();
        tomarCaptura.takeScreenshot(driver, "TC 03 - Results");
        System.out.println("Proceso exitoso.");
    }

    @Test
////TC 04 - Cotizar seguro básico: Se probará la cotización de un seguro, eligiendo  la opción de seguro por enfermedad como cobertura adicional.
    public void cotizarSeguroPorEnfermedad() {
        System.out.println("Llenando datos de entrada para cotización.");
        PageIndex pageIndex = new PageIndex(driver);
        pageIndex.completarDatos("10072000", "Catamarca", "11", "77777777");

        pageIndex.adicionalEnfermedad();
        System.out.println("Desplazándose hacia el final de la página.");
        utils.scrollToBottomOfPage(driver);
        System.out.println("Pulsando en 'Contratar'.");
        pageIndex.contratar();
        System.out.println("Tomando captura de los resultados.");
        utils tomarCaptura = new utils();
        tomarCaptura.takeScreenshot(driver, "TC 04 - Results");
        System.out.println("Proceso exitoso.");
    }

    @Test
    ////TC 05 - Cotizar seguro con todos los adicionales y desplazando slide de aumento de cuota: Se probará la cotización de un seguro, eligiendo  las tres opcines de seguro adicionales, y desplazando el slide que aumenta el valor de la cuota.
    public void cotizarConTresAdicionalesAumentanMoviendoSlide() {
        System.out.println("Llenando datos de entrada para cotización.");
        PageIndex pageIndex = new PageIndex(driver);
        pageIndex.completarDatos("10071991", "Jujuy", "11", "88888888");
        pageIndex.adicionalInvalidez();
        pageIndex.adicionalAccidente();
        pageIndex.adicionalEnfermedad();
        pageIndex.desplazarSlideCuota();
        System.out.println("Desplazándose hacia el final de la página.");
        utils.scrollToBottomOfPage(driver);
        System.out.println("Pulsando en 'Contratar'.");
        pageIndex.contratar();
        System.out.println("Tomando captura de los resultados.");
        utils tomarCaptura = new utils();
        tomarCaptura.takeScreenshot(driver, "TC 05 - Results");
        System.out.println("Proceso exitoso.");
    }

    @Test
    ////TC 06 - Verificar despliegue de documento de condiciones: Se probará la existencia y despliegue del documento de condiciones del servicio.
    public void documentoCondicionesDocx() {
        System.out.println("Comparando vínculo a archivo esperado '.docx'.");
        PageIndex pageIndex = new PageIndex(driver);
        pageIndex.obtenerHrefDeCondiciones();
        System.out.println("Vínculo obtenido coincide con el esperado.");
        System.out.println("Tomando captura de los resultados.");
        utils tomarCaptura = new utils();
        tomarCaptura.takeScreenshot(driver, "TC 06 - Results");
        System.out.println("Proceso exitoso.");
    }

    @Test
    ////TC 07 - Verificar exclusiones para cada seguro: Se probará la existencia y despliegue de los apartados de exclusiones, por cada opción adicional al seguro básico.
    public void verificarExclusiones() {
        System.out.println("Cargando datos de entrada.");
        PageIndex pageIndex = new PageIndex(driver);
        pageIndex.completarDatos("10071960", "Mendoza", "11", "33333333");
        System.out.println("Seleccionando todos los adicionales.");
        pageIndex.todosLosAdicionales();
        System.out.println("Adicionales seleccionados OK. Verificando desplegables de exclusiones.");
        pageIndex.desplegablesExclusiones();
        System.out.println("Desplegables de exclusiones con contenido OK.");
        System.out.println("Tomando captura de los resultados.");
        utils tomarCaptura = new utils();
        tomarCaptura.takeScreenshot(driver, "TC 07 - Results");
        System.out.println("Proceso exitoso.");
    }

    @Test
    ////TC 08 - Verificar hipervínculos: Se probará el correcto redireccionamiento de los vínculos al pie de la página.
    public void hipervinculos() {
        System.out.println("Comparando vínculos esperados con obtenidos.");
        PageIndex pageIndex = new PageIndex(driver);
        pageIndex.obtenerHrefDeHipervinculos();
        System.out.println("Vínculos obtenidos coinciden con los esperados.");
        System.out.println("Tomando captura de los resultados.");
        utils tomarCaptura = new utils();
        tomarCaptura.takeScreenshot(driver, "TC 08 - Results");
        System.out.println("Proceso exitoso.");
    }

    @Test
    //COLECCION DE REQUEST/TEST EXPORTADOS DE POSTMAN
    public void testWithPostman() {
        try {
            // Ejecutar Newman desde CMD
            Process process = Runtime.getRuntime().exec("newman run C:/Users/Equipo/KlimberExamen.postman_collection.json");

            // Capturar la salida de Newman
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {

                System.out.println(line);
            }

            // Esperar a que Newman termine y obtener el código de salida
            int exitCode = process.waitFor();
            System.out.println("Newman terminó con código de salida: " + exitCode);

            // Manejar resultado de Newman
            if (exitCode == 0) {
                System.out.println("Las pruebas de Postman se ejecutaron con éxito.");
            } else {
                System.out.println("Las pruebas de Postman fallaron. Verifique la salida para más detalles.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After

    public void tearDown(){

        driver.close();
    }
}


package tests;

import helpers.utils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;

public class TestsE2E {

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
/*TC - 09 - End to end de cotización de seguro básico con beneficiarios adicionales:
Se probará la cotización de un seguro básico, sin coberturas adicionales,
con datos de entrada en todos los formularios, con un perfil no político, sin cónyugue,
para uso personal, y agregando un beneficiario persona y otro beneficiario organización. */
    public void procesoCompletoAseguradoE2E(){
        System.out.println("Entrando a pantalla 1, llenando datos de entrada para cotización.");
        PageIndex pageIndex = new PageIndex(driver);
        pageIndex.completarDatos("10071960", "CABA", "11", "33333333");
        System.out.println("Desplazándose hacia el final de la página.");
        utils.scrollToBottomOfPage(driver);
        System.out.println("Pulsando en 'Contratar'.");
        pageIndex.contratar();
        pageIndex.contratar();
        System.out.println("Pantalla 1 completa y OK.");

        System.out.println("Entrando a pantalla 2, llenando los campos de IMC.");
        PageStep2 pageStep2 = new PageStep2(driver);
        pageStep2.IMC("150", "60");
        utils.scrollToBottomOfPage(driver);
        System.out.println("Pulsando en 'Siguiente'.");
        pageStep2.avanzar();
        System.out.println("Pantalla 2 completa y OK.");

        System.out.println("Entrando a pantalla 3, completando datos de registro y luego pulsando en 'Siguiente'");
        PageRegistration pageRegistration = new PageRegistration(driver);
        //IMPORTANTE - En la siguiente línea modificar el nro de documento y mail en cada ejecución, porque figuran como ya registrados.
        pageRegistration.llenarCamposDeRegistro("Carlos", "Alvarez", "33555558", "cdg03@yopmail.com", "123456789", "11", "55555555", "Rivadavia", "4500", "1080");
        System.out.println("Pantalla 3 completa y OK.");

        System.out.println("Entrando a pantalla 4, completando datos adicionales y luego pulsando en 'Siguiente'.");
        PageGroupLife pageGroupLife = new PageGroupLife(driver);
        pageGroupLife.completarDatosadicionales("Argentina", "Buenos Aires", "Brasil", "Empleado", "4.800.000", "Sueldo");
        System.out.println("Pantalla 4 completa y OK.");

        System.out.println("Entrando a pantalla 5, completando datos de tarjeta de pago, luego pulsando en 'Siguiente'.");
        PageStep5payment pageStep5payment = new PageStep5payment(driver);
        pageStep5payment.cargarTarjeta("4970100000000055");
        System.out.println("Pantalla 5 completa y OK.");

        System.out.println("Entrando a pantalla 6, agregando beneficiario persona");
        PageStep6beneficiaries pageStep6beneficiaries = new PageStep6beneficiaries(driver);
        pageStep6beneficiaries.agregarBeneficiarioPersona("Pedro", "Quiroz", "32322333", "10", "10", "1992", "50");
        System.out.println("Agregando beneficiario organización, y luego pulsar en 'Siguiente'.");
        pageStep6beneficiaries.agregarBeneficiarioOrganizacion("Femsa SA", "27336556552", "50");
        pageStep6beneficiaries.avanzarStep6();
        System.out.println("Pantalla 6 completa y OK.");

        System.out.println("Entrando a pantalla 7, revisando la info devuelta y aceptando los TyC.");
        PageStep7Summary pageStep7Summary = new PageStep7Summary(driver);
        pageStep7Summary.aceptarTyC();
        pageStep7Summary.avanzarStep7();
        System.out.println("Pantalla 7 completa y OK.");

        System.out.println("Entrando a pantalla 8, y verificando que exista una póliza en trámite.");
        PageStep8Congrats pageStep8Congrats = new PageStep8Congrats(driver);
        pageStep8Congrats.verificarPolizaEnTramiteExistente();
        System.out.println("Pantalla 8 completa y OK.");

    }


@Test
/* TC - 10 - Flujo E2E para persona no calificada para seguro - Formulario de contacto:
Habiendo elegido afirmativos los radio buttons de padecimientos en la pagina 2,
se probará llegar al formulario de contacto, llenarlo y enviarlo satisfactoriamente. */

public void procesoCompletoNoAseguradoE2E(){
    System.out.println("Entrando a pantalla 1, llenando datos de entrada para cotización.");
    PageIndex pageIndex = new PageIndex(driver);
    pageIndex.completarDatos("10071960", "CABA", "11", "33333333");
    System.out.println("Desplazándose hacia el final de la página.");
    utils.scrollToBottomOfPage(driver);
    System.out.println("Pulsando en 'Contratar'.");
    pageIndex.contratar();
    pageIndex.contratar();
    System.out.println("Pantalla 1 completa y OK.");

    System.out.println("Entrando a pantalla 2, seleccionando los radio buttons y llenando los campos de IMC.");
    PageStep2 pageStep2 = new PageStep2(driver);
    pageStep2.IMC("150", "60");
    pageStep2.seleccionarRadioButtons();
    utils.scrollToBottomOfPage(driver);
    System.out.println("Pulsando en 'Siguiente'.");
    pageStep2.avanzar();

    System.out.println("Entrando a pantalla 2 bis, llenando formulario de contacto y enviarlo.");
    PageStep2bis pageStep2bis = new PageStep2bis(driver);
    pageStep2bis.llenarYenviarFormularoDeContacto("Daniel Marconi","dm1990@yopmail.com", "1188887777");
}

}

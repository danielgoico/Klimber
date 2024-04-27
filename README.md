# klimber
Casos de prueba que hacen a la cobertura de la página propuesta:

TC 01 - Cotizar seguro básico: Se probará la cotización de un seguro básico, con datos de entrada y sin coberturas adicionales.

TC 02 - Cotizar seguro adicionando invalidez: Se probará la cotización de un seguro, eligiendo la opción de seguro por invalidez como cobertura adicional.

TC 03 - Cotizar seguro básico: Se probará la cotización de un seguro, eligiendo la opción de seguro por accidente como cobertura adicional.

TC 04 - Cotizar seguro básico: Se probará la cotización de un seguro, eligiendo la opción de seguro por enfermedad como cobertura adicional.

TC 05 - Cotizar seguro con todos los adicionales y desplazando slide de aumento de cuota: Se probará la cotización de un seguro, eligiendo las tres opcines de seguro adicionales, y desplazando el slide que aumenta el valor de la cuota.

TC 06 - Verificar despliegue de documento de condiciones: Se probará la existencia y despliegue del documento de condiciones del servicio.

TC 07 - Verificar exclusiones para cada seguro: Se probará la existencia y despliegue de los apartados de exclusiones, por cada opción adicional al seguro básico.

TC 08 - Verificar hipervínculos: Se probará el correcto redireccionamiento de los vínculos al pie de la página.

*** Se agregó la clase "TestsE2E" que comprende los Test Cases con flujos integrales. Los mismos proponen un end-to-end de lo propuesto en la documentación actualizada:

TC - 09 - End to end de cotización de seguro básico con beneficiarios adicionales: Se probará la cotización de un seguro básico, sin coberturas adicionales, con datos de entrada en todos los formularios, con un perfil no político, sin cónyugue, para uso personal, y agregando un beneficiario persona y otro beneficiario organización.

Se agrega otro flujo donde la persona no califica para obtener poliza (objetos mapeados en la "PageStep2bis.java")

TC - 10 - Persona no calificada para seguro - Formulario de contacto: Habiendo elegido afirmativos los radio buttons de padecimientos en la pagina 2, se probará llegar al formulario de contacto, llenarlo y enviarlo satisfactoriamente.

-------------------------------------

Descripción del Framework de automatización:

Se utiliza Java, con selenium como ejecutor utilizando comandos sobre el front, utilizando Page Object como patrón de diseño. Para el nombre de las pages se toman como referencia las urls de las distintas pantallas que recorren los flujos.

**NOTA IMPORTANTE DE LA EJECUCIÓN: Modificar los valores en "documento" y "email" en cada ejecución, porque figurarán como ya registrados (línea 66 de la clase "TestsE2E.java").

Framework para pruebas Front-end: IntelliJ IDEA 2023.3.3 (Community Edition) Java 21.0.2 Apache Maven 3.9.6

drivers: edgedriver Versión 124.0.2478.51 geckodriver Versión 125.0.2

Dependencias en 'POM.xml': Selenium-java 4.18.1 JUnit 4.13.2 maven-compiler-plugin 3.8.1 maven-surefire-plugin 3.0.0-M5

------------------------------

Pruebas de APIs: Autenticaciones, GET, PUT, POST.

Colección exportada desde Postman: 'KlimberExamen.postman_collection.json' que se encuentra en la raíz del proyecto.

Postman 10.24.24 Node.js v20.12.2 newman 6.1.2

------------------------------

Datos de Entorno: Windows 10 64 bits.

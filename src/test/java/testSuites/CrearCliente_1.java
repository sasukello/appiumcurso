package testSuites;

import conexion.DriverContext;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.CarruselPage;
import pages.CrearClientePage;
import pages.CrearProductoPage;
import pages.RegistroPage;

import static reports.Reports.finalAssert;

public class CrearCliente_1 {
    DriverContext driverContext;
    CarruselPage carruselPage;
    RegistroPage registroPage;
    CrearClientePage crearClientePage;
    @BeforeSuite
    public void iniciarSession(){
        driverContext = new DriverContext();
        driverContext.setUP("emulator-5554","Android","C:\\Users\\examonr\\Downloads\\OneDrive_1_28-12-2020\\registroDeUsuarios.apk",
                "emulator-5554",true);
        System.out.println("Applicacion desplegada");
    }
    @Test(priority = 1,description = "Validación carrusel")
    public void validarDespliegue(){
        carruselPage = new CarruselPage();
        carruselPage.validarVistaDesplegada();
        finalAssert();

    }
    @Test(priority = 2,description = "Recorrer carrusel")
    public void carrusel(){
        carruselPage.recorrerCarrusel();
        registroPage = new RegistroPage();
        // Validar que se recorre correctamente el carrusel hasta llegar a la siguiente page
        Assert.assertTrue(registroPage.validarRegistroPage());
        finalAssert();
    }
    @Test(priority = 3,description = "Ir a crear cliente")
    public void irCrearCliente(){
        registroPage.irCrearClientePage();
        crearClientePage = new CrearClientePage();
        //Validar que se llega a la page Crear cliente
        Assert.assertTrue(crearClientePage.validarCrearClientePage());
    }
    @Test(priority = 4,description = "Crear cliente")
    public void crearCliente(){
        crearClientePage.crearCliente("Anderson Montilla2", "00002", "123456789","santiago centro");
        // Validar que se haya creado el cliente correctamente
        Assert.assertTrue(registroPage.findClientByName("Anderson Montilla"));
    }
    @AfterSuite
    public void cerrarSession(){
        driverContext.quitDriver();
    }
}

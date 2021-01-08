package testSuites;

import conexion.DriverContext;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.CarruselPage;
import pages.ClientePage;
import pages.RegistroPage;

import static reports.Reports.finalAssert;

public class Case03_EliminarCliente_2 {
    DriverContext driverContext;
    CarruselPage carruselPage;
    RegistroPage registroPage;
    ClientePage clientePage;
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
    @Test(priority = 3,description = "Seleccionar cliente")
    public void seleccionarCliente(){
        registroPage.seleccionarCliente("Anderson Montilla");

    }
    @Test(priority = 4,description = "Eliminar cliente desde la page cliente")
    public void eliminarCliente(){
        clientePage = new ClientePage();
        clientePage.borrarCliente();
        /**
         *Se debe tener 2 cliente correr CrearCliente_1 [2]veces , para ver la accion de borrar ,
         * ya que con un solo cliente por alguna razon no borra un unico cliente mantiene el storage
         */
        Assert.assertFalse(registroPage.findClientByName("Anderson Montilla"));
    }
    @AfterSuite
    public void cerrarSession(){
        driverContext.quitDriver();
    }
}

package testSuites;

import conexion.DriverContext;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CarruselPage;
import pages.CrearProductoPage;
import pages.RegistroPage;

import static reports.Reports.finalAssert;

public class Case01_AddProduct {
    DriverContext driverContext;
    CarruselPage carruselPage;
    RegistroPage registroPage;
    CrearProductoPage crearProductoPage;
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

    /**/
    @Test(priority = 3, description = "expandir boton")
    public void ExpandirBtn() {
        RegistroPage expandir = new RegistroPage();
        expandir.irCrearProductoPage();
        finalAssert();
    }
  /*

    */

    @Test(priority = 4,description = "Crear un producto",enabled = false)
    public void crearProducto(){
        crearProductoPage.crearProducto("Producto1",5145.200);
        registroPage.irCrearProductoPage();
        // Validar que despues de crear un producto se vuelve a la pagina de Regsitro
        Assert.assertTrue(registroPage.validarRegistroPage());
        finalAssert();
    }

    @Test(priority = 5,description = "Ir a la page Crear Producto",enabled = false)
    public void irCrearProducto(){
        registroPage.irCrearProductoPage();
        crearProductoPage = new CrearProductoPage();
        // Validar que se navega exitosamente a la page Crear producto
        Assert.assertTrue(crearProductoPage.validarCrearProductoPage());
        finalAssert();
    }
   // @Test(priority = 6,description = "Validar si el producto se creó correctamente",enabled = true)
    public void validarProducto(){
        registroPage.clickProductos();
        //Validar que el producto registrado esté en la vista de registro
        Assert.assertTrue(registroPage.findProductByName("TV"));
        Assert.assertTrue(registroPage.findByPrice("2515.202"));
    }
    @AfterSuite
    public void cerrarSession(){
        driverContext.quitDriver();
    }
}

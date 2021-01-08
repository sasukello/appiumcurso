package pages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;

import static reports.Reports.addStep;
import static utils.Utils.esperarObjeto;
import static utils.Utils.esperaExplicita;

public class CrearClientePage {
    private AppiumDriver driver;
    public CrearClientePage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    /**
     * Objetos
     */
    @AndroidFindBy (id = "com.rodrigo.registro:id/ac_nombre")
    private MobileElement boxName;
    @AndroidFindBy (id = "com.rodrigo.registro:id/ruc")
    private MobileElement boxId;
    @AndroidFindBy (id = "com.rodrigo.registro:id/tel")
    private MobileElement boxTel;
    @AndroidFindBy (id = "com.rodrigo.registro:id/dir")
    private MobileElement boxDir;
    @AndroidFindBy (id = "com.rodrigo.registro:id/notas")
    private MobileElement boxNotas;
    @AndroidFindBy (id = "com.rodrigo.registro:id/cambiar_ubicacion")
    private MobileElement btnCambiarUbicacion;
    @AndroidFindBy (id = "com.rodrigo.registro:id/guardar")
    private MobileElement btnGuardar;
    /**
     * Métodos
     */
    public void crearCliente(String nombre, String id, String telefono, String direccion){
        esperaExplicita(1);
        driver.navigate().back();
        if (esperarObjeto(boxName,5)){
            boxName.sendKeys(nombre);
            addStep("Nombre del cliente rellenado",true, Status.PASSED,false);
        } else addStep("Nombre del cliente rellenado",true, Status.FAILED,false);

        if(esperarObjeto(boxId,5)){
            boxId.sendKeys(id);
            addStep("ID del cliente rellenado",true, Status.PASSED,false);
        } else addStep("Nombre del producto rellenado",true, Status.FAILED,false);

        if (esperarObjeto(boxTel,5)){
            boxTel.sendKeys(telefono);
            addStep("Telefono del cliente rellenado",true, Status.PASSED,false);
        } else addStep("Telefono del cliente rellenado",true, Status.FAILED,false);

        if (esperarObjeto(boxDir,5)){
            boxDir.sendKeys(direccion);
            addStep("Direccion del cliente rellenado",true, Status.PASSED,false);
        } else addStep("Direccion del cliente rellenado",true, Status.FAILED,false);

        if (esperarObjeto(btnGuardar,5)){
            btnGuardar.click();
            addStep("Cliente creado",false,Status.PASSED,false);
        } else addStep("Cliente creado",false,Status.FAILED,false);
    }
    public boolean validarCrearClientePage(){
        return esperarObjeto(boxName, 5);
    }
}

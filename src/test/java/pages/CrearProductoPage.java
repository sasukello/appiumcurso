package pages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;

import static reports.Reports.addStep;
import static utils.Utils.esperaExplicita;
import static utils.Utils.esperarObjeto;

public class CrearProductoPage {
    private AppiumDriver driver;


    public CrearProductoPage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    /**
     * Objetos
     */
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Más opciones\"]")
    private MobileElement options;
    @AndroidFindBy (id = "com.rodrigo.registro:id/nombre_producto")
    private MobileElement boxNombreProducto;
    @AndroidFindBy (id = "com.rodrigo.registro:id/precio")
    private MobileElement boxPrecio;
    @AndroidFindBy (xpath = "//android.widget.ImageButton[@content-desc=\"Navegar hacia arriba\"]")
    private MobileElement btnBack;
    @AndroidFindBy (id = "com.rodrigo.registro:id/confirmar")
    private MobileElement btnConfirmar;



    /**
     * Metodos
     */

    public void crearProducto(String nombre, Double precio){
        if (esperarObjeto(boxNombreProducto,5)){
            boxNombreProducto.click();
            boxNombreProducto.sendKeys("TV");
            this.driver.hideKeyboard();
            addStep("Nombre del producto rellenado",true, Status.PASSED,false);
        }
        else addStep("Nombre del producto rellenado",true, Status.FAILED,false);
        if (esperarObjeto(boxPrecio,5)){
            //boxPrecio.sendKeys(String.format("%.2f", precio));
            boxPrecio.sendKeys("2515.202");
            addStep("Precio del producto rellenado",true, Status.PASSED,false);
        }
        else addStep("Precio del producto rellenado",true, Status.FAILED,false);
        if (esperarObjeto(btnConfirmar,5)){
            btnConfirmar.click();
            esperaExplicita(1/2);
            addStep("Click en confirmar",true, Status.PASSED,false);
        }
        else addStep("Click en confirmar",true, Status.FAILED,false);
    }
    public boolean validarCrearProductoPage(){
        return esperarObjeto(boxNombreProducto, 5);
    }
}

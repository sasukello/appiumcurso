package pages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static reports.Reports.addStep;
import static utils.Utils.*;

public class ClientePage {
    private AppiumDriver driver;
    public ClientePage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    /**
     * Objetos
     */
    @AndroidFindBy(id = "com.rodrigo.registro:id/eliminar_cliente")
    private MobileElement btnEliminarCliente;

    @AndroidFindBy(id = "com.rodrigo.registro:id/editTextDialogUserInput")
    private MobileElement boxBorrar;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement btnOk;

    @AndroidFindBy(id = "com.rodrigo.registro:id/vc_anadirVenta")
    private MobileElement btnAnadirVenta;

    @AndroidFindBy(id = "com.rodrigo.registro:id/vercli_ultVenta")
    private MobileElement ventasRegistradas;


    /**
     * Métodos
     */
    public void clickNuevaVenta(){
        if (esperarObjeto(btnAnadirVenta,5)){
            btnAnadirVenta.click();
            esperaExplicita(1/2);
            addStep("Click en nueva venta",false, Status.PASSED,false);
        } else addStep("Click en nueva venta",false, Status.FAILED,false);
    }
    public void borrarCliente(){
        swipeAbajo();
        if(esperarObjeto(btnEliminarCliente,5)){
            btnEliminarCliente.click();
            esperaExplicita(1/2);
            addStep("Click en eliminar cliente",false, Status.PASSED,false);
        } else addStep("Click en eliminar cliente",false, Status.FAILED,false);
        if(esperarObjeto(boxBorrar,5)){
            boxBorrar.sendKeys("BORRAR");
            esperaExplicita(1/2);
            addStep("Escribir 'BORRAR'",false, Status.PASSED,false);
        } else addStep("Escribir 'BORRAR'",false, Status.FAILED,false);
        if (esperarObjeto(btnOk,5)){
            btnOk.click();
            esperaExplicita(1);
            addStep("Cliente eliminado",false, Status.PASSED,false);
        } else addStep("Cliente eliminado",false, Status.FAILED,false);

    }
    public boolean precioCorrecto(String precio){
        if (esperarObjeto(ventasRegistradas,5)){
            String venta = ventasRegistradas.getText();
            // Separar la cantidad y el precio final del objeto
            String cantidad = getPatternOfString("^\\d{1,2}",venta);
            String precioFinal = getPatternOfString("\\d{1,9}.\\d\\d",venta);
            float precioFinalFloat = Float.parseFloat(precioFinal);
            int cantidadInt = Integer.parseInt(cantidad);
            float precioFloat = Float.parseFloat(precio);
            if (precioFloat*cantidadInt == precioFinalFloat){
                addStep("Precio final validado",false, Status.PASSED,false);
                return true;
            }
        }
        addStep("Precio final validado",false, Status.FAILED,false);
        return false;
    }
    public String getPatternOfString(String regex,String text){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()){
            String finded = matcher.group(0);
            return finded;
        }
        return "Not found";
    }

}

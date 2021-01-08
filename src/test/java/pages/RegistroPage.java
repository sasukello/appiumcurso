package pages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static reports.Reports.addStep;
import static utils.Utils.esperaExplicita;
import static utils.Utils.esperarObjeto;

public class RegistroPage {
    private AppiumDriver driver;
    public RegistroPage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    /**
     * Objetos
     */
    @AndroidFindBy (id = "com.rodrigo.registro:id/fab_expand_menu_button")
    private MobileElement btnExpandir;
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.view.ViewGroup")
    private MobileElement clientsTab;
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup")
    private MobileElement productsTab;
    @AndroidFindBy (id = "com.rodrigo.registro:id/action_cliente")
    private MobileElement actionClient;
    @AndroidFindBy (id = "com.rodrigo.registro:id/action_producto")
    private MobileElement actionProduct;
    @AndroidFindBy (id = "com.rodrigo.registro:id/nombre_producto")
    private List<MobileElement> productNames;
    @AndroidFindBy (id = "com.rodrigo.registro:id/precio_producto")
    private List<MobileElement> productPrices;
    @AndroidFindBy (id = "com.rodrigo.registro:id/nombre_cliente")
    private List<MobileElement> clientNames;


    /**
     * Metodos
     */
    public void irCrearProductoPage(){
        if (esperarObjeto(btnExpandir,5)){
            btnExpandir.click();
            esperaExplicita(1/3);
            addStep("Click en boton expandir",true, Status.PASSED,false);
        }
        else addStep("Click en boton expandir",true, Status.FAILED,false);
        if (esperarObjeto(actionProduct,5)){

            actionProduct.click();
            esperaExplicita(1/3);
            addStep("Click en crear producto",true, Status.PASSED,false);
        }
        else addStep("Click en crear producto",true, Status.FAILED,false);
    }
    public void irCrearClientePage(){
        if (esperarObjeto(btnExpandir,5)){
            btnExpandir.click();
            esperaExplicita(1/3);
            addStep("Click en boton expandir",true, Status.PASSED,false);
        }
        else addStep("Click en boton expandir",true, Status.FAILED,false);
        if (esperarObjeto(actionClient,5)){
            actionClient.click();
            esperaExplicita(1/3);
            addStep("Click en crear cliente",true, Status.PASSED,false);
        }
        else addStep("Click en crear cliente",true, Status.FAILED,false);
    }
    public void clickProductos(){
        if (esperarObjeto(productsTab,5)){
            productsTab.click();
            esperaExplicita(1/3);
            addStep("Click en pestaña Productos",true, Status.PASSED,false);
        }
        else addStep("Click en pestaña Productos",true, Status.FAILED,false);
    }
    public boolean validarRegistroPage(){
        if (esperarObjeto(btnExpandir,5)) return true;
        else return false;
    }
    public boolean findProductByName(String name){

        for(MobileElement element:productNames){
            if(element.isDisplayed()){
                if (element.getText().equals(name)){
                    addStep("Nombre producto encontrado",true,Status.PASSED,false);
                    return true;
                }
            }
            else System.out.println("Lista de productos vacía");
        }
        addStep("Producto encontrado",true,Status.PASSED,false);
        return false;
    }
    public boolean findByPrice(String price){
        for(MobileElement element:productPrices){
            if(element.isDisplayed()){
                System.out.println(element.getText());
                if (element.getText().contains(price)){
                    addStep("Precio producto encontrado",true,Status.PASSED,false);
                    return true;
                }
            }
            else System.out.println("Lista de productos vacía");
        }
        addStep("Producto encontrado",true,Status.PASSED,false);
        return false;
    }
    public boolean findClientByName(String name){

        for(MobileElement element:clientNames){
            if(element.isDisplayed()){
                if (element.getText().equals(name)){
                    addStep("Nombre cliente encontrado",true,Status.PASSED,false);
                    System.out.println("Cliente "+name+" creado correctamente");
                    return true;
                }
            }
            else System.out.println("Lista de clientes vacía");
        }
        addStep("Nombre cliente encontrado",true,Status.FAILED,false);
        System.out.println("Cliente "+name+" no encontrado");
        return false;
    }
    public void seleccionarCliente(String name){
        for(MobileElement element:clientNames){
            if (element.isDisplayed()){
                if (element.getText().equals(name)){
                    element.click();
                    esperaExplicita(1/2);
                    addStep("Seleccionar cliente",true,Status.PASSED,false);
                    break;
                }

            }

        }

    }
}

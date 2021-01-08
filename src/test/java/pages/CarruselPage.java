package pages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;

import static reports.Reports.addStep;
import static utils.Utils.*;

public class CarruselPage {
    private AppiumDriver driver;
    public CarruselPage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    /**
     * Objetos
     */
    @AndroidFindBy(id = "com.rodrigo.registro:id/imageView2")
    private MobileElement iconoVista1;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[1]")
    private MobileElement tituloVista1;
    @AndroidFindBy(id = "com.rodrigo.registro:id/textView")
    private MobileElement descripcionVista;
    @AndroidFindBy(id = "com.rodrigo.registro:id/next")
    private MobileElement btnFlecha;
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private MobileElement alertPermitir;
    @AndroidFindBy(id = "com.rodrigo.registro:id/done")
    private MobileElement btnDone;

    /**
     * Metodos
     */

    public boolean validarVistaDesplegada(){
        if(esperarObjeto(iconoVista1,10)){
            addStep("Validar Vista 1 de Carrusel desplegada",true,Status.PASSED,false);
            return true;
        }
        else {
            addStep("Validar Vista 1 de Carrusel desplegada",true, Status.FAILED,false);
            return false;
        }
    }
    public void recorrerCarrusel(){
        for (int i = 1;i < 4;i++){
            if (esperarObjeto(btnFlecha,5)){
                btnFlecha.click();
                esperaExplicita(1/2);
                addStep(String.format("Recorriendo Carrusel vista 1.%s", i),true,Status.PASSED,false);
            }
            else {
                addStep(String.format("Recorriendo Carrusel vista 1.%s", i),true,Status.FAILED,false);
            }
        }
        if (esperarObjeto(alertPermitir,5)){
            alertPermitir.click();
            esperaExplicita(1/2);
            addStep("Permisos de escritura concedidos",true,Status.PASSED,false);
        }
        if (esperarObjeto(btnDone,5)){
            btnDone.click();
            esperaExplicita(1/2);
            addStep("Recorrido de carrusel terminado",true,Status.PASSED,false);
        }
        else {
            addStep("Recorrido de carrusel terminado",true,Status.FAILED,false);
        }


    }
    public void validarTextoVista1Carrusel(){
        String textoDescripcionVista1 = descripcionVista.getText();
        if(textoDescripcionVista1.equals("Con Registro podrás guardar de forma fácil y segura todo lo relacionado a la venta de productos o servicios.")){

        }
    }
}

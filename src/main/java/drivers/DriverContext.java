package drivers;

import io.appium.java_client.AppiumDriver;
import static drivers.DriverManager.*;

public class DriverContext {

    private static DriverManager driver = new DriverManager();


    public static void setUp(String nombreDispositivo, String SO, String aplicacion, String udid, boolean emulador){
        driver.iniciarsesion(nombreDispositivo,SO,aplicacion,udid,emulador);
    }

    public static AppiumDriver getDriver(){
        return driver.getDriver();
    }

    public static  void  quitDriver(){
        driver.getDriver().quit();
    }
}

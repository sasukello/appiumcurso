package conexion;

import io.appium.java_client.AppiumDriver;

public class DriverContext {
    private static DriverManager driverManager = new DriverManager();
    public static void setUP(String deviceName,String platformName,String appRoute,String uDID,Boolean emulador){
        driverManager.iniciarSession(deviceName,platformName,appRoute,uDID,emulador);
    }
    public static AppiumDriver getDriver(){
        return driverManager.getDriver();
    }
    public static void quitDriver(){
        driverManager.getDriver().quit();
    }
}

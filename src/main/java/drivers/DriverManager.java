package drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static drivers.DriverContext.setUp;

public class DriverManager {
    private AppiumDriver driver;
    private URL server = null;
    private DesiredCapabilities cap = new DesiredCapabilities();

    protected void iniciarsesion(String nombreDispositivo, String SO, String aplicacion, String udid, boolean emulador){

        try {
            server = new URL("http://0.0.0.0:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        cap.setCapability("deviceName","nombreDispositivo");
        cap.setCapability("platformName","SO");
        cap.setCapability("app","aplicacion");
        if(!emulador){
            cap.setCapability("udid","emulator-5554");
        }
        driver = new AndroidDriver(server, cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    protected AppiumDriver getDriver(){
        return driver;



    }
}

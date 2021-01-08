package conexion;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import sun.security.krb5.internal.crypto.Des;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    private AppiumDriver driver;
    private URL server = null;
    private DesiredCapabilities cap = new DesiredCapabilities();

    protected void iniciarSession(String deviceName,String platformName,String appRoute,String uDID,Boolean emulador){
        try {
            server = new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //cap.setCapability("deviceName","PIXEL_3_XL_8.1");
        //cap.setCapability("platformName","Android");
        //cap.setCapability("app","C:\\Users\\Gabriel.Marinan\\Downloads\\registroDeUsuarios.apk");
        //cap.setCapability("udid","PIXEL_3_XL_8.1");
        cap.setCapability("deviceName",deviceName);
        cap.setCapability("platformName",platformName);
        cap.setCapability("app",appRoute);
        if(!emulador){
            cap.setCapability("udid",uDID);
        }
        driver = new AndroidDriver(server,cap);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    protected AppiumDriver getDriver(){
        return driver;
    }
}

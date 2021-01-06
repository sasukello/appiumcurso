package TestSuites;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static drivers.DriverContext.setUp;

public class ExampleDriver {

@BeforeMethod
   public void iniciarsesion(){
//        AppiumDriver driver;
//        URL server = null;
//        try {
//            server = new URL("http://0.0.0.0:4723/wd/hub");
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//
//        DesiredCapabilities cap = new DesiredCapabilities();
//        cap.setCapability("deviceName","emulator-5554");
//        cap.setCapability("platformName","android");
//        cap.setCapability("app","C:\\Users\\examonr\\Downloads\\OneDrive_1_28-12-2020\\registroDeUsuarios.apk");
//        cap.setCapability("udid","emulator-5554");
//
//        driver = new AndroidDriver(server, cap);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    setUp("emulator-5554","android","C:\\Users\\examonr\\Downloads\\OneDrive_1_28-12-2020\\registroDeUsuarios.apk","emulator-5554",true);
}


    @Test
    public void test1(){
        System.out.println("PRUEBA");
    }
}

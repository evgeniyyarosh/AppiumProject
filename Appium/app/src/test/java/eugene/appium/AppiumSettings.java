package eugene.appium;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

/**
 * Created by eugene.iarosh on 1/19/2017.
 */

public class AppiumSettings {

    private static AndroidDriver wd;
    private static final String TESTDROID_SERVER = "http://127.0.0.1";
    public static String app = "D:/BusAPK/school_bus_app_1.0.1-debug-dev-f94349a.apk";  //set the link to app
    public static String appPackage = "com.smartnavigationsystems.ourschoolbus"; // Set your application's appPackage
    public static String activity = "com.smartnavigationsystems.ourschoolbus.presentation.views.activities.SplashActivity_";
    public static String device = "Android";
    public static String deviceName = "IVGAUGQGRSEESKY9";  //my devise name
    public static String platformVersion = "4.4.2";  //set mobile device OS version
    public static String platformName = "Android";  // set device platform


    public static AndroidDriver setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("device", device);
        dc.setCapability("deviceName", deviceName);
        dc.setCapability("platformVersion", platformVersion);
        dc.setCapability("platformName", platformName);
        dc.setCapability("app", app);
        dc.setCapability("app-package", appPackage);
        dc.setCapability("app-activity", activity);



        // Created object of RemoteWebDriver will all set capabilities.
        // Set appium server address and port number in URL string.
        wd = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);

        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        return wd;
    }

    public static void tearDown() {
        if (wd != null) {
            wd.quit();
        }
    }
}

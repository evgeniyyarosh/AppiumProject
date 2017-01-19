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
    public static String app = "D:/BusAPK/school_bus_app_1.0.1-debug-dev-f94349a.apk";
    public static String appPackage = "com.smartnavigationsystems.ourschoolbus";
    public static String activity = "com.smartnavigationsystems.ourschoolbus.presentation.views.activities.SplashActivity_";   // под вопросом
    public static String device = "Android";
    public static String deviceName = "IVGAUGQGRSEESKY9";
    public static String platformVersion = "4.4.2";
    public static String platformName = "Android";


//test

    public static AndroidDriver setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("device", device);
        dc.setCapability("deviceName", deviceName);
        dc.setCapability("platformVersion", platformVersion);
        dc.setCapability("platformName", platformName);
        dc.setCapability("app", app);
        dc.setCapability("app-package", appPackage);
        dc.setCapability("app-activity", activity);

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

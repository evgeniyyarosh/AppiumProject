package eugene.appium;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

import static java.lang.Math.random;
import java.util.Random;

/**
 * Created by eugene.iarosh on 1/19/2017.
 */

public class AppiumSettings {

    private static AndroidDriver driver;
    private static final String TESTDROID_SERVER = "http://127.0.0.1";
    public static String app = "D:/BusAPK/school_bus_app_2.1.4-debug-prod-732262e.apk";  //set the link to app
    public static String appPackage = "com.smartnavigationsystems.ourschoolbus"; // Set your application's appPackage
    public static String activity = "com.smartnavigationsystems.ourschoolbus.presentation.views.activities.SplashActivity_";
    public static String device = "Android";
    public static String deviceName = "014E233E1101A01D";  //my devise name
    public static String platformVersion = "4.3";  //set mobile device OS version
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
        dc.setCapability("noReset", true);



        // Created object of RemoteWebDriver will all set capabilities.
        // Set appium server address and port number in URL string.
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        return driver;
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void logOutFromApplication(){
        driver.findElement(By.xpath("//android.view.View[@resource-id='com.smartnavigationsystems.ourschoolbus:id/toolbar']/android.widget.ImageButton")).click();
        driver.findElement(By.name("Logout")).click();
        driver.findElement(By.name("Our School Bus")).isDisplayed();
    }

    public static String randomEmail() {
        return "CreatedByAppium-" + random() + "@example.com";
    }

    public static String randomName() {

        return "CombaineNotif-" + random();
    }

    public static int randomPhone(){
        Random random = new Random();
        int min = 111111;
        int max = 999999;
        int range = max - min;
        int value = random.nextInt(range) + min;
        return  value;
    }
}

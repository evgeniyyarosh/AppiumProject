package eugene.appium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;

/**
 * Created by eugene.iarosh on 2/16/2017.
 */

public class StartRouteButtonAvailable {
    private static AndroidDriver driver;
    private static final String BASEPATH = "com.smartnavigationsystems.ourschoolbus:id/";

    @BeforeClass
    public static void appiumInit(){
        try{
            driver = AppiumSettings.setUp();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loginLogout(){
        driver.findElement(By.id(BASEPATH + "phone_number_edit_text")).sendKeys("33333");
        driver.findElement(By.id(BASEPATH + "password_text_input_edit_text")).sendKeys("qweqwe");
        driver.hideKeyboard();
        driver.findElement(By.id(BASEPATH + "login_button")).click();
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.id(BASEPATH + "start_route")).click();
        driver.findElement(By.id(BASEPATH + "finish_route")).isDisplayed();
    }

    @AfterClass
    public static void signOut() {
        driver.findElement(By.id(BASEPATH + "finish_route")).click();
        AppiumSettings.logOutFromApplication();
        AppiumSettings.tearDown();
    }
}

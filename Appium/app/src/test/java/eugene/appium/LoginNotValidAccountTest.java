package eugene.appium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;

/**
 * Created by eugene.iarosh on 1/24/2017.
 */

public class LoginNotValidAccountTest {
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
    public void loginApp(){
        driver.findElement(By.id(BASEPATH + "phone_number_edit_text")).sendKeys("753357");
        driver.findElement(By.id(BASEPATH + "password_text_input_edit_text")).sendKeys("qweqwe$$f");
        driver.findElement(By.id(BASEPATH + "login_button")).click();
        driver.findElement(By.name("You have entered invalid Phone or Password")).isDisplayed();
    }

    @AfterClass
    public static void signOut(){
        driver.findElement(By.id("android:id/button1")).click();
        AppiumSettings.tearDown();
    }
}

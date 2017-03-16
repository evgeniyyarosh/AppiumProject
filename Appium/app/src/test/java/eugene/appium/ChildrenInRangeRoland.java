package eugene.appium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;

/**
 * Created by eugene.iarosh on 3/15/2017.
 */

public class ChildrenInRangeRoland {
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
    public void childrenInRange(){
        driver.findElement(By.id(BASEPATH + "phone_number_edit_text")).sendKeys("33333");
        driver.findElement(By.id(BASEPATH + "password_text_input_edit_text")).sendKeys("qweqwe");
        driver.hideKeyboard();
        driver.findElement(By.id(BASEPATH + "login_button")).click();
        driver.findElement(By.id("android:id/button1")).click();
        // This is Menu button in left side of header on Map screen
        driver.findElement(By.xpath("//android.view.View[@resource-id='com.smartnavigationsystems.ourschoolbus:id/toolbar']/android.widget.ImageButton")).click();
        driver.findElement(By.name("Students in range")).click();
        driver.findElement(By.name("Roland")).isDisplayed();
    }

    @AfterClass
    public static void signOut(){
        AppiumSettings.logOutFromApplication();
        AppiumSettings.tearDown();
    }

}

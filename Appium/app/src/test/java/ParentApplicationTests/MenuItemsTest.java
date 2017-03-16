package ParentApplicationTests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

import eugene.appium.AppiumSettings;
import io.appium.java_client.android.AndroidDriver;

/**
 * Created by eugene.iarosh on 3/15/2017.
 */

public class MenuItemsTest {
    public static AndroidDriver driver;
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
    public void checkAllItems(){
        driver.findElement(By.id(BASEPATH + "phone_number_edit_text")).sendKeys("952952");
        driver.findElement(By.id(BASEPATH + "password_text_input_edit_text")).sendKeys("qweqwe");
        //hide keyboard to see Login button
        driver.hideKeyboard();
        driver.findElement(By.id(BASEPATH + "login_button")).click();
        // This is Menu button in left side of header on Map screen
        driver.findElement(By.xpath("//android.view.View[@resource-id='com.smartnavigationsystems.ourschoolbus:id/toolbar']/android.widget.ImageButton")).click();
        // End now check ALL default menu items
        driver.findElement(By.name("Map")).isDisplayed();
        driver.findElement(By.name("Profile")).isDisplayed();
        driver.findElement(By.name("Distance settings")).isDisplayed();
        driver.findElement(By.name("Students list")).isDisplayed();
        driver.findElement(By.name("Change password")).isDisplayed();
    }

    @AfterClass
    public static void tearDown()
    {
        AppiumSettings.tearDown();
    }
}
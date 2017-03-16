package ParentApplicationTests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.util.UUID;

import eugene.appium.AppiumSettings;
import io.appium.java_client.android.AndroidDriver;

import static java.lang.Math.random;

/**
 * Created by eugene.iarosh on 3/15/2017.
 */

public class ChangeParentName {
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
    public void changeParent(){
        // This is Menu button in left side of header on Map screen
        driver.findElement(By.xpath("//android.view.View[@resource-id='com.smartnavigationsystems.ourschoolbus:id/toolbar']/android.widget.ImageButton")).click();
        driver.findElement(By.name("Profile")).click();
        driver.findElement(By.id(BASEPATH + "action_edit")).click();
        driver.findElement(By.id(BASEPATH + "name_text_input_edit_text")).clear();
        //generate random name
        String randomName = AppiumSettings.randomName();
        driver.findElement(By.id(BASEPATH + "name_text_input_edit_text")).sendKeys(randomName);
        driver.findElement(By.id(BASEPATH + "action_done")).click();
        driver.findElement(By.name("User profile has been updated successfully")).isDisplayed();
    }



    @AfterClass
    public static void tearDown()
    {
        AppiumSettings.tearDown();
    }
}

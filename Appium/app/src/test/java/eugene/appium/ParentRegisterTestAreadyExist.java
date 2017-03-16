package eugene.appium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;

/**
 * Created by eugene.iarosh on 2/22/2017.
 */

public class ParentRegisterTestAreadyExist {
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
    public void parentRegister(){
        driver.findElement(By.id(BASEPATH + "registration_parent_button")).click();
        driver.findElement(By.name("Parent registration")).isDisplayed();
        driver.findElement(By.id(BASEPATH + "name_text_input_edit_text")).sendKeys("ParentCreatedByAppium");
        driver.findElement(By.id(BASEPATH + "phone_number_edit_text")).sendKeys("952952");
        driver.hideKeyboard();
        driver.findElement(By.id(BASEPATH + "new_password_text_input_edit_text")).sendKeys("qweqwe");
        driver.hideKeyboard();
        driver.findElement(By.id(BASEPATH + "retype_password_text_input_edit_text")).sendKeys("qweqwe");
        driver.hideKeyboard();
        driver.findElement(By.id(BASEPATH + "terms_conditions_checkbox")).click();
        driver.findElement(By.id(BASEPATH + "submit_button")).click();
        driver.findElement(By.name("The phone number has already been taken.")).isDisplayed();
    }

    @AfterClass

    public static void signOut()
    {
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton")).click();
    }
}

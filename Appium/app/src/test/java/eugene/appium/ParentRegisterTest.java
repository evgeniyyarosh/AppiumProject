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

public class ParentRegisterTest {
    private static AndroidDriver driver;
    private static final String BASEPATH = "com.smartnavigationsystems.ourschoolbus:id/";
    // random phone for registration
    private int randomPhone = AppiumSettings.randomPhone();
    // convert int phone to string
    private String strRandomName = Integer.toString(randomPhone);

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
        driver.findElement(By.id(BASEPATH + "name_text_input_edit_text")).sendKeys("CreateByAppiumTest");
        driver.findElement(By.id(BASEPATH + "phone_number_edit_text")).sendKeys(strRandomName);
        driver.hideKeyboard();
        driver.findElement(By.id(BASEPATH + "new_password_text_input_edit_text")).sendKeys("qweqwe");
        driver.hideKeyboard();
        driver.findElement(By.id(BASEPATH + "retype_password_text_input_edit_text")).sendKeys("qweqwe");
        driver.hideKeyboard();
        driver.findElement(By.id(BASEPATH + "terms_conditions_checkbox")).click();
        driver.findElement(By.id(BASEPATH + "submit_button")).click();
        driver.findElement(By.name("Registration request was created and pending!")).isDisplayed();

    }

    @AfterClass
    public static void signOut()
    {
        //close popup
        driver.findElement(By.id("android:id/button1")).click();
        //close popup
        driver.findElement(By.id("android:id/button1")).click();
        AppiumSettings.logOutFromApplication();
    }
}

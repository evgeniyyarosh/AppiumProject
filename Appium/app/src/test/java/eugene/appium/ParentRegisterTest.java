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
    private static AndroidDriver wd;
    private static final String BASEPATH = "com.smartnavigationsystems.ourschoolbus:id/";

    @BeforeClass
    public static void appiumInit(){
        try{
            wd = AppiumSettings.setUp();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void parentRegister(){
        wd.findElement(By.id(BASEPATH + "registration_parent_button")).click();
        wd.findElement(By.name("Parent registration")).isDisplayed();
        wd.findElement(By.id(BASEPATH + "name_text_input_edit_text")).sendKeys("ParentCreatedByAppium");
        wd.findElement(By.id(BASEPATH + "phone_number_edit_text")).sendKeys("13654811");
        wd.findElement(By.id(BASEPATH + "new_password_text_input_edit_text")).sendKeys("qweqwe");
        wd.hideKeyboard();
        wd.findElement(By.id(BASEPATH + "retype_password_text_input_edit_text")).sendKeys("qweqwe");
        wd.hideKeyboard();
        wd.findElement(By.id(BASEPATH + "terms_conditions_checkbox")).click();
        wd.findElement(By.id(BASEPATH + "submit_button")).click();
        wd.findElement(By.name("Registration request was created and pending!")).isDisplayed();
    }

    @AfterClass
    public static void signOut(){
        AppiumSettings.tearDown();
    }
}

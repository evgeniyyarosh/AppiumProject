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

public class StartRoute {
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
    public void loginLogout(){
        wd.findElement(By.id(BASEPATH + "phone_number_edit_text")).sendKeys("11111");
        wd.findElement(By.id(BASEPATH + "password_text_input_edit_text")).sendKeys("qweqwe");
        wd.hideKeyboard();
        wd.findElement(By.id(BASEPATH + "login_button")).click();
        wd.findElement(By.id("android:id/button1")).click();
        wd.findElement(By.id(BASEPATH + "start_route")).click();
    }

    @AfterClass
    public static void signOut() {
        AppiumSettings.tearDown();
    }
}

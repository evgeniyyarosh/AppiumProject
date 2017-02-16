package eugene.appium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.List;

import io.appium.java_client.android.AndroidDriver;

/**
 * Created by eugene.iarosh on 2/15/2017.
 */

public class LoginLogoutTest {
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
        wd.findElement(By.xpath("//android.view.View[@resource-id='com.smartnavigationsystems.ourschoolbus:id/toolbar']/android.widget.ImageButton")).click();
        wd.findElement(By.name("Logout")).click();
        wd.findElement(By.name("Our School Bus")).isDisplayed();
    }

    @AfterClass
    public static void signOut() {
        AppiumSettings.tearDown();
    }

}

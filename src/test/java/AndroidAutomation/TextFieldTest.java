package AndroidAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TextFieldTest {

    AppiumDriver driver;

    @Test
    public void test1() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        URL url = new URL("http://localhost:4723/wd/hub");

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2); // this is mandatory
        //desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.hmh.api");
        //desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.hmh.api.ApiDemos");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"/Users/madhavimarrivada/Downloads/ApiDemos.apk");
        driver = new AndroidDriver(url, desiredCapabilities);

        driver.findElement(By.xpath("//*[@text='App']")).click();
        driver.findElement(By.xpath("//*[@text='Activity']")).click();
        driver.findElement(By.xpath("//*[@text='Animation']")).click();
        driver.findElement(By.xpath("//*[@text='Fade in']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@text='Text Entry dialog']")).click();
        driver.findElement(By.xpath("//*[contains(@resource-id,'username_edit')]")).sendKeys("Smith");
        driver.findElement(By.xpath("//*[contains(@resource-id,'password_edit')]")).sendKeys("Smith1");
        driver.findElement(By.xpath("//*[@text='OK']")).click();
    }
}

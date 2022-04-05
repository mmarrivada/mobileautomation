package IOSAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class IOSDemoTest {

    AppiumDriver driver;

    @Parameters({"urlIOS"})
    @Test
    public void test(String urlIOS) throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        URL url = new URL(urlIOS);

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.IOS);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone 13 Pro Max");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/madhavimarrivada/Desktop/MyRNDemoApp.app");
        driver = new IOSDriver(url, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.name("Sauce Labs Backpack")).click();
        driver.findElement(By.name("counter plus button")).click();
        driver.findElement(By.name("Add To Cart button")).click();
        driver.findElement(By.name("tab bar option cart")).click();
        driver.findElement(By.name("remove item")).click();
        String var1 = driver.findElement(By.name("No Items")).getText();
        System.out.println(var1);



    }

}

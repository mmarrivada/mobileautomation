package AndroidAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDemo {
    AppiumDriver driver;
    @Test
    public void test1() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        URL url = new URL("http://localhost:4723/wd/hub");

        if(System.getProperty("mobilePlatform").equalsIgnoreCase("android")){
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2); // this is mandatory
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.hmh.api");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.hmh.api.ApiDemos");
            driver = new AndroidDriver(url,desiredCapabilities);
        }else{
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.IOS);
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST); // this is mandatory
            desiredCapabilities.setCapability(IOSMobileCapabilityType.APP_NAME,"path of app");
            driver = new IOSDriver(url,desiredCapabilities);
        }

        driver.findElement(By.xpath("//*[contains(@resource-id,'continue_button')]")).click();

    }
}

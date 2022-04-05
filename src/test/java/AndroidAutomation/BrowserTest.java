package AndroidAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserTest {

    AppiumDriver driver;

    @Test
    public void test() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        URL url = new URL("http://localhost:4723/wd/hub");

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
        //desiredCapabilities.setCapability(MobileCapabilityType.APP,"/Users/madhavimarrivada/Downloads/ApiDemos.apk");
        driver = new AndroidDriver(url, desiredCapabilities);
        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(By.xpath("//a[.='A/B Testing']")).click();

    }
}

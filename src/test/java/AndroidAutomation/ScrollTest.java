package AndroidAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ScrollTest {
    AppiumDriver driver;

    @Test
    public void test1() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        URL url = new URL("http://localhost:4723/wd/hub");

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2); // this is mandatory
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/madhavimarrivada/Downloads/ApiDemos.apk");
        driver = new AndroidDriver(url, desiredCapabilities);

        driver.findElement(By.xpath("//*[@text='App']")).click();
        driver.findElement(By.xpath("//*[@text='Activity']")).click();

        String scrollTillElement = "new UiSelector().text(\"Wallpaper\")"; // finding the element till it will scroll
        String scrollDown = "new UiSelector().scrollable(true)"; // whether you want to scroll up/down
        String scrollCmd = "new UiScrollable("+ scrollDown +").scrollIntoView("+ scrollTillElement +")"; //
        MobileElement elem = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(scrollCmd));
    }
}
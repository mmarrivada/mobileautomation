package AndroidAutomation;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.interactions.Actions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class LongPressTest {

    AndroidDriver driver;
@Parameters({"urlAndroid"})
    @Test
    public void test(String urlAndroid) throws MalformedURLException, InterruptedException {
        SoftAssert sa = new SoftAssert();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        URL url = new URL(urlAndroid);

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/madhavimarrivada/Downloads/ApiDemos.apk");
        driver = new AndroidDriver(url, desiredCapabilities);

        driver.findElement(By.xpath("//*[@text='App']")).click();
        driver.findElement(By.xpath("//*[@text='Fragment']")).click();
        driver.findElement(By.xpath("//*[@text='Context Menu']")).click();

        TouchAction action = new TouchAction(driver);
        //TouchActions actions = new TouchActions(driver);
        Thread.sleep(5000);
    //Assert.assertTrue(false);// hard assert will stop execute next lines of the code
    //sa.assertTrue(false);  //Soft assert will execute next lines of the code even
        MobileElement longPress = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Long press me"));
//        Map<String,Object> longPressArg = new HashMap<>();
//        longPressArg.put("strategy","accessibility id");
//        longPressArg.put("selector","Long press me");
        driver.executeScript("mobile:longClickGesture", ImmutableMap.of("elementId",longPress.getId()));

    sa.assertTrue(true);
    sa.assertAll();//mandatory

       // WebElement press1 = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Long press me\"]"));
       //Thread.sleep(3000);
        //action.longPress((LongPressOptions) press1).waitAction(WaitOptions.waitOptions(Duration.ofMillis(8000))).release().perform();


        // driver.findElement(By.xpath("//*[@text='Long press menu']")).click();
        //action.longPress((LongPressOptions) press).release().perform();

        //actions.longPress(press1).release().perform();

    }


    @Test
    public void test1(String urlAndroid) throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        URL url = new URL(urlAndroid);

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/madhavimarrivada/Downloads/ApiDemos.apk");
        driver = new AndroidDriver(url, desiredCapabilities);

        driver.findElement(By.xpath("//*[@text='App']")).click();
        driver.findElement(By.xpath("//*[@text='Fragment']")).click();
        driver.findElement(By.xpath("//*[@text='Context Menu']")).click();

        TouchAction action = new TouchAction(driver);
        //TouchActions actions = new TouchActions(driver);
        Thread.sleep(5000);

        MobileElement longPress = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Long press me"));
//        Map<String,Object> longPressArg = new HashMap<>();
//        longPressArg.put("strategy","accessibility id");
//        longPressArg.put("selector","Long press me");
        driver.executeScript("mobile:longClickGesture", ImmutableMap.of("elementId",longPress.getId()));



        // WebElement press1 = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Long press me\"]"));
        //Thread.sleep(3000);
        //action.longPress((LongPressOptions) press1).waitAction(WaitOptions.waitOptions(Duration.ofMillis(8000))).release().perform();


        // driver.findElement(By.xpath("//*[@text='Long press menu']")).click();
        //action.longPress((LongPressOptions) press).release().perform();

        //actions.longPress(press1).release().perform();

    }

}

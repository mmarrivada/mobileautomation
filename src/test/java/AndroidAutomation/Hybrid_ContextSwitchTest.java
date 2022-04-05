package AndroidAutomation;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;

public class Hybrid_ContextSwitchTest {
    AndroidDriver driver;

    @Test
    public void test1() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        URL url = new URL("http://localhost:4723/wd/hub");

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

        HashMap<String,Object> map = new HashMap<>();
        map.put("w3c",false);
        desiredCapabilities.setCapability("chromeOptions",map);
        //desiredCapabilities.setCapability("chromeOptions", ImmutableMap.of("w3c", false));// not recommanded
        //desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.permissioncontroller");
        //desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.permissioncontroller.permission.ui.ReviewPermissionsActivity");

       // desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.hmh.api");
        //desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.hmh.api.ApiDemos");

        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/madhavimarrivada/Downloads/ApiDemos.apk");
        driver = new AndroidDriver(url, desiredCapabilities);

       // driver.findElement(By.xpath("//*[@text='Continue']")).click();
       // Thread.sleep(2000);
       // driver.findElement(By.xpath("//*[@text='OK']")).click();
        driver.findElement(By.xpath("//*[@text='Views']")).click();

        //Main window //NATIVE_APP
        String currentContext = driver.getContext();//NATIVE_APP


        String scrollTillElement = "new UiSelector().text(\"WebView\")"; // finding the element till it will scroll
        String scrollDown = "new UiSelector().scrollable(true)"; // whether you want to scroll up/down
        String scrollCmd = "new UiScrollable(" + scrollDown + ").scrollIntoView(" + scrollTillElement + ")"; //
        driver.findElement(MobileBy.AndroidUIAutomator(scrollCmd)).click();

        //driver.findElement(By.xpath("//*[@text='Hello World! - 4']")).click();


       //Code to switch to context

        Set<String> allContexts = driver.getContextHandles(); //NATIVE_APP and WEBVIEW_1 / WEBVIEW_<app package>
        System.out.println(allContexts.toString());

        for(String context : allContexts){
            driver.context(context);
            if(driver.findElements(By.id("i_am_a_textbox")).size()==1){
                System.out.println(context);
                driver.findElement(By.id("i_am_a_textbox")).sendKeys("Hi Hello How are you");
                Thread.sleep(5000);
                driver.context(currentContext);
                break;
            }
            driver.context(currentContext);
        }

        driver.closeApp();

    }
}

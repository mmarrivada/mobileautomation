package AndroidAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ScrollUsingTouchAction {
    AndroidDriver driver;
    @Test
    public void test() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        URL url = new URL("http://localhost:4723/wd/hub");

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/madhavimarrivada/Downloads/ApiDemos.apk");
        driver = new AndroidDriver(url, desiredCapabilities);

        driver.findElement(By.xpath("//*[@text='App']")).click();
        driver.findElement(By.xpath("//*[@text='Activity']")).click();

        int yCodStart =  driver.manage().window().getSize().getHeight()/2;
        int xCodStart =  driver.manage().window().getSize().getWidth()/2;

        int yCodEnd =  100;
        int xCodEnd =  driver.manage().window().getSize().getWidth()/2;

        int maxSwipe = 5;
        TouchAction action = new TouchAction(driver);

        //action.tap(TapOptions.tapOptions()).perform();

        for(int i=0; i<maxSwipe; i++){

            try{
                driver.findElement(By.xpath("//*[@text='Wallpaper']"));
                break;
            }catch (Exception e){
                action
                        .longPress(PointOption.point(xCodStart,yCodStart))
                        .moveTo(PointOption.point(xCodEnd,yCodEnd))
                        .release()
                        .perform();
           }
        }
        // KeyEvent homeBtn = new KeyEvent(AndroidKey.HOME);
        KeyEvent homeBtn = new KeyEvent(AndroidKey.BACK);
        driver.pressKey(homeBtn);
    }
}

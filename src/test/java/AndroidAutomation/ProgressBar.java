package AndroidAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ProgressBar {
    AppiumDriver driver;

    @Test
    public void test() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        URL url = new URL("http://localhost:4723/wd/hub");

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"/Users/madhavimarrivada/Downloads/ApiDemos.apk");
        driver = new AndroidDriver(url, desiredCapabilities);

        driver.findElement(By.xpath("//*[@text='Views']")).click();

        //Horizontal line  == X cordinate
        //Vertical Line = Y Cordinate

        int xcordSrating = driver.manage().window().getSize().getWidth()/2;
        int ycordStarting = driver.manage().window().getSize().getHeight()/2;
        int ycordending = 100;

        int maxSwipe = 5;
        TouchAction action = new TouchAction(driver);
        for(int i=0 ; i<maxSwipe ; i++) {
            try {

                driver.findElement(By.xpath("//*[@text='Seek Bar']")).click();
                break;

            } catch (Exception e) {
                action
                        .longPress(PointOption.point(xcordSrating, ycordStarting))
                        .moveTo(PointOption.point(xcordSrating, ycordending))
                        .release()
                        .perform();

            }
        }

        AndroidElement var = (AndroidElement)driver.findElement(By.xpath("//*[@text='50.0']"));
       // var.replaceValue("80.0");
        var.setValue("25.0");
        //var.sendKeys("70.0");



//            action.longPress(PointOption.point(xcordSrating, ycordStarting))
//                    .moveTo(PointOption.point(ycordending,xcordending)).
//                    release().perform();




    }


}

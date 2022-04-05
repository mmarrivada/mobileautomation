package AndroidAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ArrangeCatalogTest {

    AndroidDriver driver;

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        URL url = new URL("http://localhost:4723/wd/hub");

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/madhavimarrivada/Downloads/MyDemoAppRN.apk");
        driver = new AndroidDriver(url, desiredCapabilities);

        // click on Sort icon
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"sort button\"]/android.widget.ImageView")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@index='3']")).click();
        Thread.sleep(2000);

        int xcordstart = driver.manage().window().getSize().getWidth() / 2;
        int ycordstart = driver.manage().window().getSize().getHeight() / 2;

       // int xcordend = driver.manage().window().getSize().getWidth() / 2;
        int ycordend = 100;
        int maxswipes = 5;
        TouchAction action = new TouchAction(driver);


        for (int i = 0; i < maxswipes; i++) {
            try {

                driver.findElement(By.xpath("//*[@text='Sauce Labs Fleece Jacket']"));
                break;

            } catch (Exception e) {
                action
                        .longPress(PointOption.point(xcordstart, ycordstart))
                        .moveTo(PointOption.point(xcordstart, ycordend))
                        .release()
                        .perform();


            }

        }
        driver.findElement(By.xpath("//*[@text='Sauce Labs Fleece Jacket']")).click();
        //Add to Cart
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Add To Cart button\"]/android.widget.TextView")).click();

       //View Cart
       driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView")).click();
       Thread.sleep(2000);

       // Remove item
       driver.findElement(By.xpath("//*[@text='Remove Item']")).click();
       Thread.sleep(2000);

       //Status of Cart
       String var1 = driver.findElement(By.xpath("//*[@text='No Items']")).getText();
        System.out.println(var1);

    }
}







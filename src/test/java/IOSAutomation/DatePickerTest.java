package IOSAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DatePickerTest {

    IOSDriver driver;

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        URL url = new URL("http://localhost:4723/wd/hub");

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.IOS);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 13 Pro Max");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/madhavimarrivada/Downloads/UIKitCatalog-iphonesimulator.app");
        driver = new IOSDriver(url, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.name("Date Picker")).click();
        Thread.sleep(2000);
        MobileElement dayPicker = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypePickerWheel[1]"));
        MobileElement hrPicker = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypePickerWheel[2]"));

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        Map<String, Object> params = new HashMap<>();
//        params.put("order", "next");
//        params.put("offset", 0.5);
//        params.put("element", dayPicker.getId());
//        for (int i=0;i<10;i++) {
//            js.executeScript("mobile: selectPickerWheelValue", params);
//        }
        //js.executeScript("mobile: selectPickerWheelValue", params);

        int xcordstart = dayPicker.getRect().getWidth()/2;
        int ycordstart = dayPicker.getRect().getHeight()/2;

        int ycordend = ycordstart-50;
//        TouchAction action = new TouchAction(driver);
//
//        action.longPress(PointOption.point(xcordstart,ycordstart)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(xcordstart,ycordend)).release().perform();

        Map<String, Object> params = new HashMap<>();
        params.put("duration", 1.0);
        params.put("fromX", xcordstart);
        params.put("fromY", ycordstart);
        params.put("toX", xcordstart);
        params.put("toY", ycordend);
        params.put("element", dayPicker.getId());
        driver.executeScript("mobile: dragFromToForDuration", params);

        hrPicker.setValue("9");

    }
}

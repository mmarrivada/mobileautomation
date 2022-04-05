package IOSAutomation;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class PickerViewtest {

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

        driver.findElement(By.name("Picker View")).click();
        Thread.sleep(2000);
        MobileElement dayPicker = (MobileElement) driver.findElement(By.name("Red color component value"));
        MobileElement dayPicker1 = (MobileElement) driver.findElement(By.name("Green color component value"));

        dayPicker.setValue("80");
        dayPicker1.sendKeys("210");

//        int xcordstart = dayPicker.getRect().getWidth()/2;
//        int ycordstart = dayPicker.getRect().getHeight()/2;
//
//        int ycordend = ycordstart-50;
    }

}

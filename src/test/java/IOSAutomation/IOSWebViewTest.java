package IOSAutomation;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class IOSWebViewTest {

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

        String currentContext = driver.getContext(); // Know the what will be the context of current app (NATIVE_APP)

        driver.findElement(By.name("Web View")).click();
        Thread.sleep(5000);

//        Set<String> allContext = driver.getContextHandles(); // terurn all the contexts (NATIVE_APP & WEBVIEW_1234)
//        for(String context : allContext){
//
//            driver.context(context);   // Switching the context
//            if(driver.findElements(By.xpath("/html/body/h1")).size() == 1){
//
//                System.out.println(driver.findElement(By.xpath("//u")).getText());  // Printing the current context
//
//                driver.context(currentContext); // swithching back Native_APP
//                break;
//            }
//            driver.context(currentContext); // swithching back Native_APP
//        }


        List<String> allContext = (List<String>) driver.executeScript("mobile: getContexts");
        System.out.println(allContext.toString());

    }
}

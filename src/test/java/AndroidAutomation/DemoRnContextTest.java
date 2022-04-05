package AndroidAutomation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class DemoRnContextTest {

    AndroidDriver driver;

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        URL url = new URL("http://localhost:4723/wd/hub");

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/madhavimarrivada/Downloads/MyDemoAppRN.apk");
        driver = new AndroidDriver(url, desiredCapabilities);

        //Open Menu
        Thread.sleep(5000);
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@text='Webview']")).click();


    }
}

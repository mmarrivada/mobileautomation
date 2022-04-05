package AndroidAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ToastMessageValidation {
    AppiumDriver driver;

    @Test
    public void test1() throws IOException, InterruptedException, TesseractException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        URL url = new URL("http://localhost:4723/wd/hub");

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2); // this is mandatory
        //desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.hmh.api");
        //desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.hmh.api.ApiDemos");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/madhavimarrivada/Downloads/ApiDemos.apk");
        driver = new AndroidDriver(url, desiredCapabilities);

        driver.findElement(By.xpath("//*[@text='App']")).click();
        driver.findElement(By.xpath("//*[@text='Notification']")).click();
        driver.findElement(By.xpath("//*[@text='NotifyWithText']")).click();
        TakesScreenshot ts = (TakesScreenshot)driver;

        driver.findElement(By.xpath("//*[@text='Show Short Notification']")).click();
        File screenshot = ts.getScreenshotAs(OutputType.FILE);
        File target =new File("/Users/madhavimarrivada/IdeaProjects/MobileAutomation/images/abc.png");
        FileUtils.copyFile(screenshot, target);
        System.setProperty("jna.library.path","/Users/madhavimarrivada/.m2/repository/net/sourceforge/tess4j/tess4j/5.2.0/tess4j-5.2.0.jar");
        Tesseract iTesseract = new Tesseract();
       // iTesseract.setDatapath("tessData");

        String data = iTesseract.doOCR(target);
        System.out.println(data);
        Assert.assertTrue(data.contains("Short notification"));

        System.out.println(driver.findElement(By.xpath("//android.widget.Toast")).getText()); // defined xpath to get toast message



    }

}

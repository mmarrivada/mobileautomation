package AndroidAutomation;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CheckOutCartTest {

    AndroidDriver driver;
    @Parameters({"urlAndroid"})
    @Test
    public void test(String urlAndroid) throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //URL url = new URL("http://localhost:4723/wd/hub");
        URL url = new URL(urlAndroid);

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/madhavimarrivada/Downloads/MyDemoAppRN.apk");
        driver = new AndroidDriver(url, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"store item\"])[3]/android.view.ViewGroup[1]/android.widget.ImageView")).click();
        //increase the quantity
        //driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"counter plus button\"]/android.widget.ImageView")).click();
        driver.findElement(By.xpath("//*[@index='0']")).click();
        //Thread.sleep(2000);


        //Add to Cart
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Add To Cart button\"]/android.widget.TextView")).click();
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView")).click();
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Proceed To Checkout button\"]\n")).click();
        //driver.findElement(By.xpath("//*[@index='1']")).click();

        //Login Details
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@text='bob@example.com']")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Username input field\"]")).sendKeys("bob@example.com");
        //driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Password input field\"]")).sendKeys("10203040");
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Login button\"]")).click();

        //Address Info
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@text='Rebecca Winter']")).sendKeys("Smith");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@text='Mandorley 112']")).sendKeys("Smith 112");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@text='Entrance 1']")).sendKeys("Gate 122");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@text='Truro']")).sendKeys("Bruno");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@text='Cornwall']")).sendKeys("California");
        driver.hideKeyboard();

        String scroll1 = "new UiSelector().text(\"89750\")";
        String scrollDn = "new UiSelector().scrollable(true)";
        String scrollEnter = "new UiScrollable("+ scrollDn +").scrollIntoView("+ scroll1 +")";
        MobileElement elem1 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(scrollEnter));

        driver.findElement(By.xpath("//*[@text='89750']")).sendKeys("12345");
        driver.findElement(By.xpath("//*[@text='United Kingdom']")).sendKeys("United States");
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"To Payment button\"]")).click();
        Thread.sleep(2000);

        // Card Payment
        // driver.findElement(By.xpath("//*[@index='5']")).sendKeys("Smith");
        driver.findElement(By.xpath("//*[@text='Rebecca Winter']")).sendKeys("Smith");
        driver.hideKeyboard();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//*[@index='8']")).sendKeys("1234 2345 3456 456");
        driver.findElement(By.xpath("//*[@text='3258 1265 7568 789']")).sendKeys("1234 2345 3456 456");
        // driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Card Number* input field\"]")).sendKeys("1234 2345 3456 456");
        driver.hideKeyboard();

        //review order to check card number
        // driver.findElement(By.xpath("//*[@text='//android.view.ViewGroup[@content-desc=\"Review Order button\"]']")).click();

        driver.findElement(By.xpath("//*[@index='12']")).sendKeys("04/22");
        // driver.findElement(By.xpath("//*[@text='03/25']")).sendKeys("04/22");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@index='13']")).sendKeys("345");
        //  driver.findElement(By.xpath("//*[@text='123']")).sendKeys("345");
        driver.hideKeyboard();
        Thread.sleep(5000);

        String scroll2 = "new UiSelector().text(\"My billing address is the same as my shipping address.\")";
//        String scrollDn2 = "new UiSelector().scrollable(true)";
//        String scrollEnter1 = "new UiScrollable("+ scrollDn2 +").scrollIntoView("+ scroll2 +")";
//        MobileElement elem2 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(scrollEnter1));
//        Thread.sleep(5000);
        Map<String, Object> scrollArgs = new HashMap<>();
        scrollArgs.put("direction", "down"); //
        scrollArgs.put("strategy", "-android uiautomator"); //[id, xpath, accessibility id, class name, -android uiautomator]
        //scrollArgs.put("selector", "//*[@text='My billing address is the same as my shipping address.']");
        scrollArgs.put("selector",scroll2);
        driver.executeScript("mobile: scroll", scrollArgs);

        // Review Oder after scrolling
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Review Order button\"]")).click();

        Thread.sleep(2000);
        //Place Order Button
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Place Order button\"]")).click();

        //Order Status
        Thread.sleep(2000);
        String var1 = driver.findElement(By.xpath("//*[@text='Checkout Complete']")).getText();
        System.out.println(var1);
        driver.closeApp();




    }
}

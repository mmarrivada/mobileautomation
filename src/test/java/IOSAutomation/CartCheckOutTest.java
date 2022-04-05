package IOSAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.HideKeyboardStrategy;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CartCheckOutTest {

    AppiumDriver driver;
    @Parameters({"urlIOS"})
    @Test
    public void test(String urlIOS) throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
       // URL url = new URL("http://localhost:4723/wd/hub");
        //URL url = new URL("http://127.0.0.1:4723/wd/hub");
        URL url = new URL(urlIOS);

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.IOS);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 13 Pro Max");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/madhavimarrivada/Desktop/MyRNDemoApp.app");
        driver = new IOSDriver(url, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);


        int yCodStart = driver.manage().window().getSize().getHeight() / 2;
        int xCodStart = driver.manage().window().getSize().getWidth() / 2;

        int yCodEnd = 100;
        int xCodEnd = driver.manage().window().getSize().getWidth() / 2;

        int maxSwipe = 1;
        TouchAction action = new TouchAction(driver);
        boolean flag = false;
        for (int i = 0; i < maxSwipe; i++) {

            if(flag==false) {
                try {
                    flag = driver.findElement(By.xpath("//*[@text='Test.allTheThings() T-Shirt']")).isDisplayed();
                   // break;
                } catch (Exception e) {
                    action
                            .longPress(PointOption.point(xCodStart, yCodStart))
                            .moveTo(PointOption.point(xCodEnd, yCodEnd))
                            .release()
                            .perform();
                }
            }
            else
                break;
        }

        driver.findElement(By.name("store item text")).click();
        driver.findElement(By.name("counter plus button")).click();
        driver.findElement(By.name("Add To Cart button")).click();
        driver.findElement(By.name("tab bar option cart")).click();

        String var1 = driver.findElement(By.name("total price")).getText();
        System.out.println("Total Price" + var1);   // print total price
        driver.findElement(By.name("Proceed To Checkout button")).click();

        // User Login
        driver.findElement(By.name("Username input field")).sendKeys("bob@example.com");
        driver.findElement(By.name("Password input field")).sendKeys("10203040");
        driver.findElement(By.name("Login button")).click();

        // Address details
        driver.findElement(By.name("Full Name* input field")).sendKeys("Smith");

        driver.findElement(By.name("Address Line 1* input field")).sendKeys("Smith123");

        driver.findElement(By.name("Address Line 2 input field")).sendKeys("Gate10");

        driver.findElement(By.name("City* input field")).sendKeys("Sunnyvale");
        //driver.hideKeyboard();
        driver.findElement(By.name("State/Region input field")).sendKeys("California");
        // driver.hideKeyboard();
        //Thread.sleep(3000);
        MobileElement zipCode = (MobileElement)driver.findElement(MobileBy.AccessibilityId("Zip Code* input field"));
        zipCode.click();
        zipCode.setValue("12345");
//        Map<String,Object> zipCode1 = new HashMap<>();
//        zipCode1.put("elementId",zipCode.getId());
//        zipCode1.put("text","12345");
//        driver.executeScript("mobile:type",zipCode1);
       // driver.findElement(MobileBy.AccessibilityId("Zip Code* input field")).sendKeys("12345");
        // driver.hideKeyboard();
        driver.findElement(By.name("Country* input field")).click();
        driver.findElement(By.name("Country* input field")).sendKeys("UnitedStates");
        //driver.hideKeyboard();
        //driver.hideKeyboard(HideKeyboardStrategy.TAP_OUTSIDE);
       // driver.getKeyboard().pressKey(Keys.RETURN);
        driver.findElement(By.name("Checkout")).click();

        driver.findElement(By.name("To Payment button")).click();
        Thread.sleep(3000);
//        WebDriverWait wait = new WebDriverWait(driver,20);
//        try {
//            wait.ignoring(StaleElementReferenceException.class)
//                    .until(ExpectedConditions.visibilityOf(driver.findElement(By.name("Full Name* input field"))));
//            driver.findElement(By.name("Full Name* input field")).sendKeys("Smith");
//        }catch (Exception e){}


        //Payment Details
        WebElement ele1 = null;
        for (int i = 0; i < 20; i++) {
            try {
                ele1 = driver.findElement(By.name("Full Name* input field"));
                break;
            } catch (StaleElementReferenceException e) {
                Thread.sleep(1000);
            }
        }
        ele1.sendKeys("Smith");


        // driver.hideKeyboard();
        driver.findElement(By.name("Card Number* input field")).sendKeys("2345 3456 3456 123");
        // driver.hideKeyboard();
        driver.findElement(By.name("Expiration Date* input field")).sendKeys("05/24");
        // driver.hideKeyboard();
        driver.findElement(By.name("Security Code* input field")).click();
        driver.findElement(By.name("Security Code* input field")).sendKeys("267");
        //driver.hideKeyboard();
        driver.findElement(By.name("Card")).click();
        Thread.sleep(1000);
        MobileElement reviewOrderBtn = (MobileElement)driver.findElement(By.name("Review Order button"));
        int x = reviewOrderBtn.getCenter().getX();
        int y = reviewOrderBtn.getCenter().getY();
        TouchAction actionTap  = new TouchAction(driver);
        actionTap.tap(PointOption.point(x,y)).perform();
        actionTap.tap(TapOptions.tapOptions().withElement(ElementOption.element(reviewOrderBtn))).perform();

//        Map<String,Object> tapArg = new HashMap<>();
//        tapArg.put("element",reviewOrderBtn.getId());
//        tapArg.put("x",x);
//        tapArg.put("y",y);
//        driver.executeScript("mobile:tap",tapArg);

    //Place Order
        Thread.sleep(3000);
        driver.findElement(By.name("Place Order button")).click();
        String var2 = driver.findElement(By.name("Checkout Complete")).getText();
        System.out.println(var2);

    }

}

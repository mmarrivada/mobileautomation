package AndroidAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import sun.security.krb5.internal.crypto.Des;

import java.net.MalformedURLException;
import java.net.URL;

public class CheckboxandSwitch {

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
        driver.findElement(By.xpath("//*[@text='Controls']")).click();
        driver.findElement(By.xpath("//*[@text='2. Dark Theme']")).click();
        // Text Field
        driver.findElement(By.xpath("//*[@text='hint text']")).sendKeys("This is text Field");
        driver.hideKeyboard();
        //CheckBox
        driver.findElement(By.xpath("//*[@text='Checkbox 1']")).click();
        //RadioButton
        driver.findElement(By.xpath("//*[@text='RadioButton 2']")).click();
        //Star
        driver.findElement(By.xpath("//*[@text='Star']")).click();

        //Switch

        WebElement switch1 = driver.findElement(By.xpath("//*[@text='OFF']"));
        if(!(switch1.isSelected())){
              System.out.println("Switch is OFF");
              switch1.click();
              System.out.println("Switch is ON");
        }
       else{
            System.out.println("Switch is already ON");
        }
        //DropDown
        driver.findElement(By.xpath("//*[@text='Mercury']")).click();
        driver.findElement(By.xpath("//*[contains(@resource-id,'select_dialog_listview')]"));
        driver.findElement(By.xpath("//*[@text='Neptune']")).click();


    }


}

package com.companyname.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    AppiumDriver driver;
    DesiredCapabilities desiredCapabilities;

    public AppiumDriver openApplication()  {
        String platName = System.getProperty("platform");
        //String platName = "ios";
        URL url = null;
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        desiredCapabilities = new DesiredCapabilities();
        if(platName.equalsIgnoreCase("ios")){
           desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.IOS);
           desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
           desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 13 Pro Max");
           desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/madhavimarrivada/Desktop/MyRNDemoApp.app");
           driver = new IOSDriver(url, desiredCapabilities);
       }
       else {
           desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
           desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2); // this is mandatory
           desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.hmh.api");
           desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.hmh.api.ApiDemos");
           driver = new AndroidDriver(url, desiredCapabilities);
       }
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       return driver;
    }
}

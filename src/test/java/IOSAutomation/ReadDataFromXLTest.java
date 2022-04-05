package IOSAutomation;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ReadDataFromXLTest {

    public static void main(String[] args) throws IOException, InterruptedException {

        FileInputStream fis = new FileInputStream("/Users/madhavimarrivada/IdeaProjects/MobileAutomation/data/TestLogin.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet ws = wb.getSheet("Sheet1");
        Row row;
        Cell cell;
        IOSDriver driver;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        // URL url = new URL("http://localhost:4723/wd/hub");
        //URL url = new URL("http://127.0.0.1:4723/wd/hub");
        for(int rowNum=1; rowNum<ws.getPhysicalNumberOfRows(); rowNum++){
            row = ws.getRow(rowNum); // first row

           // for(int j=0; j<row.getPhysicalNumberOfCells(); j++){
              //  cell = row.getCell(j); // reading the cell from first row
                //System.out.println(cell.toString());
                URL url = new URL("http://127.0.0.1:4723/wd/hub");

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
                driver.findElement(By.name("Username input field")).sendKeys(row.getCell(0).toString());
                System.out.println(row.getCell(1).toString());
                driver.findElement(By.name("Password input field")).sendKeys(row.getCell(1).toString());
                driver.findElement(By.name("Login button")).click();

                // Address details
                driver.findElement(By.name("Full Name* input field")).sendKeys(row.getCell(2).toString());

                driver.findElement(By.name("Address Line 1* input field")).sendKeys(row.getCell(3).toString());

                driver.findElement(By.name("Address Line 2 input field")).sendKeys(row.getCell(4).toString());

                driver.findElement(By.name("City* input field")).sendKeys(row.getCell(5).toString());

                driver.findElement(By.name("State/Region input field")).sendKeys(row.getCell(6).toString());

                //Thread.sleep(3000);
                MobileElement zipCode = (MobileElement)driver.findElement(MobileBy.AccessibilityId("Zip Code* input field"));
                zipCode.click();
                zipCode.setValue(row.getCell(7).toString());

                driver.findElement(By.name("Country* input field")).click();
                driver.findElement(By.name("Country* input field")).sendKeys(row.getCell(8).toString());

                driver.findElement(By.name("Checkout")).click();

                driver.findElement(By.name("To Payment button")).click();
                Thread.sleep(3000);

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
                ele1.sendKeys(row.getCell(2).toString());


                // driver.hideKeyboard();
                driver.findElement(By.name("Card Number* input field")).sendKeys(row.getCell(9).toString());
                // driver.hideKeyboard();
                driver.findElement(By.name("Expiration Date* input field")).sendKeys(row.getCell(10).toString());
                // driver.hideKeyboard();
                driver.findElement(By.name("Security Code* input field")).click();
                driver.findElement(By.name("Security Code* input field")).sendKeys(row.getCell(11).toString());
                //driver.hideKeyboard();
                driver.findElement(By.name("Card")).click();
                Thread.sleep(1000);
                MobileElement reviewOrderBtn = (MobileElement)driver.findElement(By.name("Review Order button"));
                int x = reviewOrderBtn.getCenter().getX();
                int y = reviewOrderBtn.getCenter().getY();
                TouchAction actionTap  = new TouchAction(driver);
                actionTap.tap(PointOption.point(x,y)).perform();
                actionTap.tap(TapOptions.tapOptions().withElement(ElementOption.element(reviewOrderBtn))).perform();

                //Place Order
                Thread.sleep(3000);
                driver.findElement(By.name("Place Order button")).click();
                String var2 = driver.findElement(By.name("Checkout Complete")).getText();
                System.out.println(var2);
            }
        wb.close();
        fis.close();

    }
}

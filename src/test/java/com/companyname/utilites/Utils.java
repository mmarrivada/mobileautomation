package com.companyname.utilites;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Utils {

    public static void scrollDownIOS(AppiumDriver driver, WebElement ele) {

        int yCodStart = driver.manage().window().getSize().getHeight() / 2;
        int xCodStart = driver.manage().window().getSize().getWidth() / 2;

        int yCodEnd = 100;
        int xCodEnd = xCodStart;

        int maxSwipe = 3;
        TouchAction action = new TouchAction(driver);

        for (int i = 0; i < maxSwipe; i++) {

            try {
                ele.isDisplayed();
                break;
            } catch (Exception e) {
                action
                        .longPress(PointOption.point(xCodStart, yCodStart))
                        .moveTo(PointOption.point(xCodEnd, yCodEnd))
                        .release()
                        .perform();
            }
        }
    }

    public static String readdataFromXL(String key) {
        String value = "";
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("/Users/madhavimarrivada/IdeaProjects/MobileAutomation/data/TestLogin.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Workbook wb = null;
        try {
            wb = WorkbookFactory.create(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sheet ws = wb.getSheet("Sheet1");
        Row row;

        for (int i = 1; i < ws.getPhysicalNumberOfRows(); i++) {
            row = ws.getRow(i);
            if (row.getCell(0).toString().equalsIgnoreCase(key)) {
                value = row.getCell(1).toString();
                break;
            }
        }
        return value;
    }

}

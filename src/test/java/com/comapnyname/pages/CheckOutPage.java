package com.comapnyname.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
    AppiumDriver driver;


    @FindBy(name = "Checkout") //PageFactory
    WebElement checkoutLabel;

    public CheckOutPage(AppiumDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //MobileElement getRedShirt =(MobileElement) driver.findElement(By.xpath("//*[@text='Test.allTheThings() T-Shirt']"));


    public boolean isCheckOutDisplayed(){
        return checkoutLabel.isDisplayed();
        //return driver.findElements(By.name("Checkout")).size()>0;
    }

}

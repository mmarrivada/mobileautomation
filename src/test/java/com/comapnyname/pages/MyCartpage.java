package com.comapnyname.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCartpage {
    AppiumDriver driver;


    @FindBy(name = "Proceed To Checkout button") //PageFactory
    WebElement checkOutBtn;

    public MyCartpage(AppiumDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //MobileElement getRedShirt =(MobileElement) driver.findElement(By.xpath("//*[@text='Test.allTheThings() T-Shirt']"));



    public void checkOutClick(){
        checkOutBtn.click();
    }


}

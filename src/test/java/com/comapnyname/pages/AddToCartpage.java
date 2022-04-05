package com.comapnyname.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartpage {
    AppiumDriver driver;

    @FindBy(name = "Add To Cart button") //PageFactory
    WebElement addToCart;
    @FindBy(name = "tab bar option cart") //PageFactory
    WebElement cartBtn;

    public AddToCartpage(AppiumDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this); //Mandatory
    }

    //MobileElement getRedShirt =(MobileElement) driver.findElement(By.xpath("//*[@text='Test.allTheThings() T-Shirt']"));

    public void clickAddToCart(){
        addToCart.click();
    }

    public void clickCartBtn(){
        cartBtn.click();
    }

}

package com.comapnyname.pages;

import com.companyname.utilites.Utils;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Products {
    AppiumDriver driver;

    @FindBy(xpath = "//*[@name='Test.allTheThings() T-Shirt']") //PageFactory
    WebElement redShirt;

    public Products(AppiumDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this); //Mandatory
    }

    //By redShirtBy = By.xpath("//*[@name='Test.allTheThings() T-Shirt']");

    public void clickOnRedShirt(){
        Utils.scrollDownIOS(driver,redShirt);
        redShirt.click();
    }

}

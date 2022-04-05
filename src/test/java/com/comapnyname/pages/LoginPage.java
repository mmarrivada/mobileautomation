package com.comapnyname.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    AppiumDriver driver;


    @FindBy(name = "Username input field") //PageFactory
    WebElement userName;

    @FindBy(name = "Password input field") //PageFactory
    WebElement passWord;

    @FindBy(name = "Login button") //PageFactory
    WebElement loginBtn;

    public LoginPage(AppiumDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //MobileElement getRedShirt =(MobileElement) driver.findElement(By.xpath("//*[@text='Test.allTheThings() T-Shirt']"));


    public void loginClick(){
        loginBtn.click();
    }

    public void setDataOnUserName(String uid){
        userName.sendKeys(uid);
    }
    public void setDataOnPassWord(String passwd){
        passWord.sendKeys(passwd);
    }
    

}

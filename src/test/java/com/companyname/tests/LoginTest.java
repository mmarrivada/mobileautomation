package com.companyname.tests;

import com.comapnyname.pages.*;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    AppiumDriver driver;
    Products products;
    AddToCartpage addToCartpage;
    MyCartpage myCartpage;
    LoginPage loginPage;
    CheckOutPage checkOutPage;

    @BeforeClass
    public void setUp() {
        driver = openApplication();
        products = new Products(driver);
        addToCartpage = new AddToCartpage(driver);
        myCartpage = new MyCartpage(driver);
        loginPage = new LoginPage(driver);
        checkOutPage = new CheckOutPage(driver);
    }

    @Test
    public void loginValidation(){
        products.clickOnRedShirt();
        addToCartpage.clickAddToCart();
        addToCartpage.clickCartBtn();
        myCartpage.checkOutClick();
        loginPage.setDataOnUserName("bob@example.com");
        //loginPage.setDataOnUserName(Utils.readdataFromXL("UserName"));
        loginPage.setDataOnPassWord("10203040");
        loginPage.loginClick();
        Assert.assertTrue(checkOutPage.isCheckOutDisplayed()); // validation
    }

}

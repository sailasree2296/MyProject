package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.CheckoutCompletePage;
import com.mystore.pageobjects.CheckoutOverviewPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.YourCartPage;

public class CheckoutOverviewPageTest extends BaseClass 

{
	HomePage homePage;
	YourCartPage yourCartPage;
	IndexPage indexPage;
	AddressPage address;
	CheckoutOverviewPage checkoutOver;
	CheckoutCompletePage complete;
	
	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setup(String browser)
	{
		launchApp(browser);
	}
	
	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown()
	{
		getDriver().quit();
	}
	
	@Test(groups= {"Sanity","Regression"})
	public void ClickOnFinishBtn()
	{
		indexPage=new IndexPage();
		homePage=new HomePage();
		address=new AddressPage();
		complete=new CheckoutCompletePage();
		checkoutOver=new CheckoutOverviewPage();
		yourCartPage=new YourCartPage();
		homePage=indexPage.logIn(prop.getProperty("username"),prop.getProperty("password"));
		homePage.sortOrder();
		homePage.cartButton();
		yourCartPage=homePage.cartLogoClick();
		address=yourCartPage.checkOutBtn();
		checkoutOver=address.credentialS(prop.getProperty("firstname"),prop.getProperty("lastname"),prop.getProperty("code"));
		String actualURL=indexPage.getCurrentURL();
		String expectedURL="https://www.saucedemo.com/checkout-step-two.html";
		Assert.assertEquals(actualURL, expectedURL);
	}
}

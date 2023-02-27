package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.YourCartPage;

public class YourCartPageTest extends BaseClass 
{
	HomePage homePage;
	YourCartPage yourCartPage;
	IndexPage indexPage;
	AddressPage address;
	
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
	
	@Test(groups= {"Smoke","Sanity"})
	public void clickOnCartLogo()
	{
		indexPage=new IndexPage();
		homePage=indexPage.logIn(prop.getProperty("username"),prop.getProperty("password"));
		homePage.sortOrder();
		homePage.clickOnProd();
		homePage.cartButton();
		yourCartPage=homePage.cartLogoClick();
	}
	
	@Test(groups="Regression")
	public void verifyPrice()
	{
		indexPage=new IndexPage();
		homePage=indexPage.logIn(prop.getProperty("username"),prop.getProperty("password"));
		homePage.sortOrder();
		homePage.clickOnProd();
		homePage.cartButton();
		yourCartPage=homePage.cartLogoClick();
		YourCartPage.verifyPriceOfProduct();
		boolean result=YourCartPage.verifyPriceOfProduct();
		Assert.assertFalse(result);
	}
	
	@Test(groups={"Sanity","Regression"})
	public void clickOnCheckoutBtn()
	{
		indexPage=new IndexPage();
		homePage=new HomePage();
		address=new AddressPage();
		yourCartPage=new YourCartPage();
		homePage=indexPage.logIn(prop.getProperty("username"),prop.getProperty("password"));
		homePage.sortOrder();
		homePage.clickOnProd();
		homePage.cartButton();
		yourCartPage=homePage.cartLogoClick();
		address=yourCartPage.checkOutBtn();
		String actualURL=yourCartPage.getCurrentURL();
		String expectedURL="https://www.saucedemo.com/checkout-step-one.html";
		Assert.assertEquals(actualURL, expectedURL);
	}
}

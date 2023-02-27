package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.YourCartPage;

public class HomePageTest extends BaseClass 
{
HomePage homePage;
IndexPageTest indexPageTest;
YourCartPage yourCartPage;
IndexPage indexPage;

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
	
	@Test(groups="Smoke")
	public void homePageLogo()
	{
		indexPage=new IndexPage();
		homePage=indexPage.logIn(prop.getProperty("username"),prop.getProperty("password"));
		boolean logoHomePage = homePage.verifyHomePageLogo();
		Assert.assertTrue(logoHomePage);
	}
	
	@Test(groups={"Smoke","Sanity"})
	public void cartButton()
	{
		indexPage=new IndexPage();
		homePage=indexPage.logIn(prop.getProperty("username"),prop.getProperty("password"));
		homePage.sortOrder();
		homePage.clickOnProd();
		homePage.cartButton();
		yourCartPage=homePage.cartLogoClick();
	}
	
	@Test(groups= {"Smoke","Sanity"})
	public void sortProduct()
	{
		indexPage=new IndexPage();
		homePage=indexPage.logIn(prop.getProperty("username"),prop.getProperty("password"));
		homePage.sortOrder();
		Assert.assertTrue(false);
	}
	

}	

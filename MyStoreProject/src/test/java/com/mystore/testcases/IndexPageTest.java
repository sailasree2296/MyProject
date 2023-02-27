/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.utility.Log;

/**
 * @author Saila Sree T
 *
 */
public class IndexPageTest extends BaseClass
{
	IndexPage indexPage;
	HomePage homePage;
	
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
	public void verifyLogo()
	{
		indexPage=new IndexPage();
		boolean result=indexPage.validateLogo();
		Assert.assertTrue(result);
	}
	
	@Test(groups="Smoke")
	public void verifyTitle()
	{
		String actTitle=indexPage.getMyStoreTitle();
		Assert.assertEquals(actTitle,"Swag Labs");
	}
	
	@Test(dataProvider="credentials",dataProviderClass=DataProviders.class,groups= {"Smoke","Sanity"})
	public void logIn(String username,String password)
	{
		Log.startTestCase("logIn");
		indexPage=new IndexPage();
		Log.info("user is going to click in login button");
		homePage=indexPage.clickOnLoginBtn();
		Log.info("user is going to enter username and password in testbox");
		//homePage=indexPage.logIn(prop.getProperty("username"),prop.getProperty("password"));
		homePage=indexPage.logIn(username,password);
		String actualURL=indexPage.getCurrentURL();
		String expectedURL="https://www.saucedemo.com/inventory.html";
		Log.info("verifying if user able to login");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Login is success");
		Log.endTestCase("logIn");	
	}
}

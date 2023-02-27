package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass{
	
	@FindBy(xpath ="//div[@class='login_logo']")
	WebElement myStoreLogo;
	
	@FindBy(id="user-name")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement passWord;
	
	@FindBy(id="login-button")
	WebElement logInBtn;
	
	@FindBy(xpath="//div[@class='bot_column']")
	WebElement botLogo;
	
	@FindBy(id="login_credentials")
	WebElement credentialUsername;
	
	@FindBy(id="login_password")
	WebElement credentialPassword;
	
	public IndexPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage clickOnLoginBtn()
	{
		Action.click(getDriver(), logInBtn);
		return new HomePage();
	}
	
	public boolean validateLogo()
	{
		return Action.isDisplayed(getDriver(), myStoreLogo);
	}
	
	public String getMyStoreTitle()
	{
		String myStoreTitle=getDriver().getTitle();
		return myStoreTitle;
	}
	
	public HomePage logIn(String credentialUn, String credentialPwd)
	{
		Action.type(userName,credentialUn);
		Action.type(passWord,credentialPwd);
		Action.click(getDriver(),logInBtn );
		return new HomePage();
	}
	
	public HomePage popUp()
	{
		Action.getDriver().switchTo().alert().accept();
		return null;
	}
	
	public String getCurrentURL()
	{
		String homePageURL=getDriver().getCurrentUrl();
		return homePageURL;
	}
	
}


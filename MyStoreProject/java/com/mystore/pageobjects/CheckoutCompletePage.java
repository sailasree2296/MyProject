package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class CheckoutCompletePage extends BaseClass {

	@FindBy(xpath="//h2[text()='THANK YOU FOR YOUR ORDER']")
	WebElement textOnTop;
	
	@FindBy(xpath="//div[@class='complete-text']")
	WebElement prodDispatchMsg;
	
	@FindBy(xpath="//img[@class='pony_express']")
	WebElement logo;
	
	@FindBy(id="back-to-products")
	WebElement backHomeBtn;
	
	public CheckoutCompletePage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage clickBackHomeBtn()
	{
		Action.click(getDriver(), backHomeBtn);
		return new HomePage();
	}
	
	public String getTopText()
	{
		
		String topText=textOnTop.getText();
		return topText;
	}
	
	public String getDispatchText()
	{
		String topText=prodDispatchMsg.getText();
		return topText;
	}
	
	public boolean validateLogo()
	{
		return Action.isDisplayed(getDriver(), logo);
	}
}

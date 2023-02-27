/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author Saila Sree T
 *
 */
public class CheckoutOverviewPage extends BaseClass {

	@FindBy(id="cancel")
	WebElement cancelBtn;
	
	@FindBy(id="finish")
	WebElement finishBtn;
	
	
	public CheckoutOverviewPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public CheckoutCompletePage clickFinishBtn(WebDriver driver) 
	{
		Action.click(driver,finishBtn );
		return new CheckoutCompletePage();
	}
	
}

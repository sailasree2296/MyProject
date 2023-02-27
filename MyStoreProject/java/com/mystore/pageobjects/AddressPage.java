/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author Saila Sree T
 *
 */
public class AddressPage extends BaseClass {

	@FindBy(id="first-name")
	WebElement firstName;
	
	@FindBy(id="last-name")
	WebElement lastName;
	
	@FindBy(id="postal-code")
	WebElement zipOrPostalCode;
	
	@FindBy(id="cancel")
	WebElement cancelBtn;
	
	@FindBy(id="continue")
	WebElement continueBtn;
	
	public AddressPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public CheckoutOverviewPage credentialS(String fName, String lName, String Code)
	{
		Action.type(firstName, fName);
		Action.type(lastName, lName);
		Action.type(zipOrPostalCode, Code);
		Action.click(getDriver(), continueBtn);
		return new CheckoutOverviewPage();
	}
}

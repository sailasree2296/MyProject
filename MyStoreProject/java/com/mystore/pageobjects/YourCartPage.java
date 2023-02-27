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
public class YourCartPage extends BaseClass
{
	
	@FindBy(id="remove-sauce-labs-onesie")
	WebElement removeFromCartBtn;
	
	@FindBy(id="continue-shopping")
	WebElement continueShoppingBtn;
	
	@FindBy(id="checkout")
	WebElement checkOutBtn;
	
	@FindBy(xpath="//div[@class='inventory_item_price']")
	static WebElement verifyUnitPriceOfProduct;
	
	
	public YourCartPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public AddressPage checkOutBtn()
	{
		Action.click(getDriver(), checkOutBtn);
		return new AddressPage();
	}
	
	public String getCurrentURL()
	{
		String cartPageURL=getDriver().getCurrentUrl();
		return cartPageURL;
	}
	
	public static boolean verifyPriceOfProduct()
	{
		Action.isDisplayed(getDriver(),verifyUnitPriceOfProduct);	
		return null != null;
		
	}
}

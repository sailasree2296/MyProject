package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass
{
	
	@FindBy(id="react-burger-menu-btn")
	WebElement menuDropDown;
	
	@FindBy(xpath="//div[@class='peek']")
	WebElement homePageBotLogo;
	
	@FindBy(xpath="//select[@class='product_sort_container']")
	WebElement SortProdTextBox;
	
	@FindBy(xpath="//a[@id='item_2_title_link']")
	WebElement selectProduct;
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']")
	WebElement addTocartBtn;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement cartLogoClick;
	
	public HomePage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean verifyHomePageLogo()
	{
		return Action.isDisplayed(getDriver(), homePageBotLogo);
	}
	public void menuBtn()
	{
		Action.click(getDriver(),menuDropDown );
	}
	
	public int sortOrder()
	{
		Action.selectByIndex(SortProdTextBox, 1);
		Action.click(getDriver(), SortProdTextBox);
		return 0;
	}
	
	public void clickOnProd()
	{
		Action.click(getDriver(),selectProduct);
	}

	public void cartButton()
	{
		Action.click(getDriver(),addTocartBtn);
	}
	
	public YourCartPage cartLogoClick()
	{
		Action.click(getDriver(), cartLogoClick);
		return new YourCartPage();
	}
	
	
	
}
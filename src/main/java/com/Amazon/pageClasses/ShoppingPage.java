package com.Amazon.pageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.Amazon.commonFunctions.CommonMethods;
public class ShoppingPage extends CommonMethods {
	
	@FindBy(xpath="//*[contains(text(),'Proceed to Buy')]")
	WebElement ProceedToBuy;
	
	@FindBy(xpath="//span[@id='hlb-view-cart']//a[contains(@href,'cart')]")
	WebElement cart;
	
	public CartPage openCart() {
		click(cart);
		
		return new CartPage();
	}

}

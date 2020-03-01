package com.Amazon.pageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.Amazon.commonFunctions.CommonMethods;

public class LaptopDetailsPage extends CommonMethods{

	@FindBy(id="productTitle")
	private WebElement LaptopDetails;
	
	@FindBy(xpath="//*[text()='Without Exchange']/ancestor::h5/preceding-sibling::i")
	WebElement WithoutExchange;
	
	@FindBy(xpath="//*[@id='selectQuantity']//select")
	WebElement SelectQtty;
	
	@FindBy(id="add-to-cart-button")
	WebElement AddToCart;
	
	public String printDetails() {
		System.out.println(LaptopDetails.getText());
		return LaptopDetails.getText();		 
	}

	public ShoppingPage addToCart() {
		if(!WithoutExchange.isSelected()) {
			click(WithoutExchange);
		}
		
		//click(selectQtty);
		selectFromDropdown(SelectQtty, "4");
		click(AddToCart);
		
		return new ShoppingPage();
		
	}
}

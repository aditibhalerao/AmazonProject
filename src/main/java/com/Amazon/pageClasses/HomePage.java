package com.Amazon.pageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Amazon.commonFunctions.CommonMethods;

public class HomePage extends CommonMethods {
	
	@FindBy(id="nav-cart-count")
	WebElement Cart;
	
	@FindBy(xpath="//*[@type='submit'][@data-action='delete']")
	WebElement DeleteCart;
	
	@FindBy(xpath="//a[@id='nav-hamburger-menu']/i")
	WebElement OpenMenu;
	
	@FindBy(xpath="//div[contains(text(), 'Computers')]")
	WebElement Computers;
	
	@FindBy(xpath="//li/a[contains(@href, 'laptop')]")
	WebElement LaptopMenu;
	
	public HomePage emptyCart() {
				
		if(!(Integer.parseInt(Cart.getText())==0)) {
			System.out.println(Cart.getText());
			click(Cart);
			click(DeleteCart);
			return this;
		}
		return this;
		
	}

	public HomePage clickMainMenu() {
		click(OpenMenu);
		
		return this;
	}
	
	public HomePage clickComputerMenu() {
		click(Computers);	
		
		return this;
	}
	
	public LaptopResultsPage clickLaptopMenu() {
		click(LaptopMenu);
		
		return new LaptopResultsPage();
	}
	


	
}

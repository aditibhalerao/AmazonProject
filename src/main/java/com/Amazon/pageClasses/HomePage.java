package com.Amazon.pageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Amazon.commonFunctions.CommonMethods;

public class HomePage extends CommonMethods {
	
	@FindBy(xpath="//a[@id='nav-hamburger-menu']/i")
	WebElement OpenMenu;
	
	@FindBy(xpath="//ul[@class='hmenu  hmenu-visible']//div[contains(text(), 'Computers')]")
	WebElement Computers;
	
	@FindBy(xpath="//li/a[contains(@href, 'laptop')]")
	WebElement LaptopMenu;

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

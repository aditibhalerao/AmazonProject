package com.Amazon.pageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Amazon.basePackage.Driver;
import com.Amazon.commonFunctions.CommonMethods;

public class LaptopResultsPage extends CommonMethods {
	
	@FindBy(xpath="//input[@name='s-ref-checkbox-Apple']")
	WebElement AppleCheckbox;
	
	@FindBy(xpath="//*[@aria-label='4 Stars & Up']/i")
	WebElement ratingSelector;
	
	@FindBy(xpath="//span[@class=\"a-dropdown-label\"][text()='Sort by:']")
	WebElement SortButton;
	
	@FindBy(xpath="//select[@name='s']")
	WebElement SortOptions;
	
	By stars= By.xpath("//span[contains(@aria-label,'out of')]");
	 
	public LaptopResultsPage selectAppleLaptops() {
		checkBox(AppleCheckbox);	
		return this;
	}
	
	public LaptopResultsPage selectRatings() {
		click(ratingSelector);
		
		return this;
	}
	
	public LaptopResultsPage sortLaptopsByPrice() {
		click(SortButton);
		selectFromDropdown(SortOptions, "Price: High to Low");
		
		return this;
		
	}
	
	public LaptopDetailsPage select5Stars() {
		click(ratingSelector);
		
		List<WebElement> list = Driver.d.findElements(stars);
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getAttribute("aria-label").contains("5.0")) {
				String s= "//*[@data-index='" +i+"']//h2/a";
				click(Driver.d.findElement(By.xpath(s)));
				switchToWindow();
				break;
			}
		}		
		return new LaptopDetailsPage();	
	}
	

}

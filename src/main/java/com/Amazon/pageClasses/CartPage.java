package com.Amazon.pageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Amazon.commonFunctions.CommonMethods;

public class CartPage extends CommonMethods {
	
	@FindBy(xpath="//*[contains(@href, 'product')]/span[contains(@class, 'sc-product-title')]")
	WebElement Product;
	
	public String getProductName() {
		return Product.getText();
	}

}

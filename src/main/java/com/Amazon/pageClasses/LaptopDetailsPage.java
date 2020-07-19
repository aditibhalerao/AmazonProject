package com.Amazon.pageClasses;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.Amazon.commonFunctions.CommonMethods;

public class LaptopDetailsPage extends CommonMethods{
	
	public static int laptopQtty = 4;

	@FindBy(id="productTitle")
	private WebElement LaptopDetails;
	
	@FindBy(id="priceblock_ourprice")
	private WebElement laptopPrice;
	
	@FindBy(xpath="//*[text()='Without Exchange']/ancestor::h5/preceding-sibling::i")
	WebElement WithoutExchange;
	
	@FindBy(xpath="//*[@id='selectQuantity']//select")
	WebElement QuantityDropdown;
	
	@FindBy(id="add-to-cart-button")
	WebElement AddToCart;
	
	public String getProductName() {
		System.out.println(LaptopDetails.getText());
		return LaptopDetails.getText();		 
	}
	
	public Long getProductPrice() throws ParseException {
		System.out.println(laptopPrice.getAttribute("innerHTML"));
		String priceString =laptopPrice.getAttribute("innerHTML").substring(7);
		Long priceLong=(Long)NumberFormat.getNumberInstance(Locale.US).parse(priceString);
		return priceLong;		 
	}

	public ShoppingPage addToCart() {
		if(!WithoutExchange.isSelected()) {
			click(WithoutExchange);
		}
		
		//click(selectQtty);
		selectFromDropdown(QuantityDropdown, String.valueOf(laptopQtty));
		click(AddToCart);
		
		return new ShoppingPage();
		
	}

	
}

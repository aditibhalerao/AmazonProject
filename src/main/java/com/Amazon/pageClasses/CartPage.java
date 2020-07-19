package com.Amazon.pageClasses;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.Amazon.basePackage.Driver;
import com.Amazon.commonFunctions.CommonMethods;


public class CartPage extends CommonMethods {
	
	static WebElement CartLaptopPrice=null;
	
	@FindBy(xpath="//*[contains(@href, 'product')]/span[contains(@class, 'sc-product-title')]")
	WebElement CartLaptopName;
	 	
	By CartLaptopPrice2 =By.xpath("//*[@data-name='Subtotals']//*[@class='a-price']/span[@class='a-offscreen']");
	By CartLaptopPrice1 =By.xpath("//*[@data-name='Subtotals']//*[@class='currencyINR']/parent::span");

	
	@FindBy(css="input[name='proceedToRetailCheckout']")
	WebElement ProceedButton;
	
	public String getCartLaptopName() {
		System.out.println(CartLaptopName.getText());
		return CartLaptopName.getText();
	}

	public String getCartLaptopPrice() throws ParseException{
		
				
		List<WebElement>LP1 = Driver.d.findElements(CartLaptopPrice1);
		List<WebElement>LP2= Driver.d.findElements(CartLaptopPrice2);
		
		if(LP1.size()>0) {
			System.out.println("LP1 "+LP1.size());
			CartLaptopPrice = Driver.d.findElement(CartLaptopPrice1);
			
			Long price = (Long) NumberFormat.getInstance(Locale.US).parse(CartLaptopPrice.getText().substring(3)); 
			System.out.println(price);
			return price.toString();
			
		}else{
			System.out.println("LP2 "+LP2.size());
			CartLaptopPrice = Driver.d.findElement(CartLaptopPrice2);
			 System.out.println(CartLaptopPrice.getAttribute("innerHTML"));
			 
				Long price = (Long) NumberFormat.getInstance(Locale.US).parse(CartLaptopPrice.getAttribute("innerHTML").substring(7)); 
				System.out.println(price);
				return price.toString();
			}
		}
	
	public LoginPage proceedToBuy() {
		
		click(ProceedButton);
		return new LoginPage();
		
	}
		
	
}
	
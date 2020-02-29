package com.Amazon.pageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.Amazon.commonFunctions.CommonMethods;

public class LaptopDetailsPage extends CommonMethods{

	@FindBy(id="productTitle")
	private WebElement LaptopDetails;
	
	public String printDetails() {
		System.out.println(LaptopDetails.getText());
		return LaptopDetails.getText();
		
		 
	}

}

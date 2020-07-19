package com.Amazon.pageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Amazon.basePackage.Driver;
import com.Amazon.commonFunctions.CommonMethods;

public class LoginPage extends CommonMethods {
	
	public static String pageTitle=null;
	public static String areaTitle= null;
	
	@FindBy(xpath="//h1[contains(text(),'Login')]")
	WebElement LoginTitle;
	
	@FindBy(css="input#ap_email")
	WebElement Email;
	
	@FindBy(css="input#continue")
	WebElement Continue;
	
	
	public LoginPage loginPageAttributes() {
		
		pageTitle= Driver.d.getTitle();
		areaTitle = LoginTitle.getText();
		
		System.out.println(pageTitle);
		System.out.println(areaTitle);
		click(Continue);
		return new LoginPage();
	}
	

}

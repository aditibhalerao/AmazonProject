package com.Amazon.commonFunctions;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Amazon.basePackage.Driver;
import com.Amazon.constants.ConstantValues;

public class CommonMethods {
	
	public CommonMethods() {
		PageFactory.initElements(Driver.d, this);
	}
	
	public static void waitExplicitly(WebElement el) {
		WebDriverWait wait= new WebDriverWait(Driver.d, ConstantValues.EXPLICITWAIT);
		wait.until(ExpectedConditions.elementToBeClickable(el));
	}
	
	public static void click(WebElement el) {
		waitExplicitly(el);
		el.click();		
	}
	
	public static void checkBox(WebElement el) {
		waitExplicitly(el);
		click(el);
	}
	
	public static void selectFromDropdown(WebElement el, String valueToBeSelected) {
		Select s= new Select(el);
		s.selectByVisibleText(valueToBeSelected);
	}
	
	public static String customizeXpath(WebElement el) {
		String origXpath =el.toString();
		String [] splitXpath = origXpath.split(":");
		String desiredXpath = splitXpath[2];
		
		return desiredXpath;
		
	}
	
	public static void switchToWindow() {
		
		String parentWindow = Driver.d.getWindowHandle();
		
		Set<String> windows=Driver.d.getWindowHandles();
		for(String window:windows) {
			if(!(window.equalsIgnoreCase(parentWindow))){
				Driver.d.switchTo().window(window);
			}
		}
	}
	
	public static void quitBrowser() {
		Driver.d.quit();
	}
	

}

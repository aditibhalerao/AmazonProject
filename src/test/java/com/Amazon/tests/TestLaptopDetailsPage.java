package com.Amazon.tests;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.Amazon.basePackage.Driver;
import com.Amazon.commonFunctions.CommonMethods;
import com.Amazon.pageClasses.CartPage;
import com.Amazon.pageClasses.HomePage;
import com.Amazon.pageClasses.LaptopDetailsPage;
import com.Amazon.pageClasses.LaptopResultsPage;
import com.Amazon.pageClasses.LoginPage;
import com.Amazon.pageClasses.ShoppingPage;

public class TestLaptopDetailsPage extends TestPrerequisites {

	HomePage homePage;
	LaptopResultsPage laptops;
	LaptopDetailsPage laptopDetails;
	ShoppingPage shopping;
	CartPage cart;
	LoginPage loginPage;
	static String expectedLaptopName ;
	static String expectedLaptopPrice;
	
	//@Test(description="Test if the Laptop details are displayed correctly.", retryAnalyzer=RetryTestcases.class)
	
	@Test(description="Test if the Laptop details are displayed correctly.")
	public void testLaptopDetails () throws ParseException {
		
		SoftAssert softAssert = new SoftAssert();
		
				
		 homePage =Driver.startDriver();
		 laptops= homePage.emptyCart().clickMainMenu().clickComputerMenu().clickLaptopMenu();
		 laptopDetails= laptops.selectAppleLaptops().selectRatings().sortLaptopsByPrice().select5Stars();
		
		 
		String actual=laptopDetails.getProductName();
		expectedLaptopName  ="Apple MacBook Pro (16-inch, 16GB RAM, 1TB Storage, 2.3GHz 9th Gen Intel Core i9) - Silver";
		softAssert.assertEquals(actual, expectedLaptopName, "The laptop details test passed");
		
		long pricePerLaptop= laptopDetails.getProductPrice();
		expectedLaptopPrice = String.valueOf(pricePerLaptop*LaptopDetailsPage.laptopQtty);		
		
		 shopping =laptopDetails.addToCart();
		 cart =shopping.openCart();
		 String actualProductName =cart.getCartLaptopName();	
   		String actualPrice = cart.getCartLaptopPrice();
		
		softAssert.assertEquals(actualProductName, expectedLaptopName);
		softAssert.assertEquals(actualPrice, expectedLaptopPrice);
		
		loginPage =cart.proceedToBuy();
		loginPage.loginPageAttributes();
		Assert.assertTrue(loginPage.pageTitle.contains("Amazon Sign In"));
		
		softAssert.assertAll();
		
			
	}


}

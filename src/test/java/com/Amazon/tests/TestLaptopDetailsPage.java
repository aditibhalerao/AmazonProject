package com.Amazon.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.Amazon.basePackage.Driver;
import com.Amazon.commonFunctions.CommonMethods;
import com.Amazon.pageClasses.CartPage;
import com.Amazon.pageClasses.HomePage;
import com.Amazon.pageClasses.LaptopDetailsPage;
import com.Amazon.pageClasses.LaptopResultsPage;
import com.Amazon.pageClasses.ShoppingPage;

public class TestLaptopDetailsPage extends TestPrerequisites {

	HomePage homePage;
	LaptopResultsPage laptops;
	LaptopDetailsPage laptopDetails;
	SoftAssert softAssert = new SoftAssert();;
	ShoppingPage shopping;
	CartPage cart;
	static String expected;
	String actual;
	
	@Test(description="Test if the Laptop details are displayed correctly.", retryAnalyzer=RetryTestcases.class)
	public void testLaptopDetails () {
		
		try {
				
		 homePage =Driver.startDriver();
		 laptops= homePage.clickMainMenu().clickComputerMenu().clickLaptopMenu();
		 laptopDetails= laptops.selectAppleLaptops().selectRatings().sortLaptopsByPrice().select5Stars();
		
		actual=laptopDetails.printDetails();
		expected ="Apple MacBook Pro (15-inch, Latest Model, 16GB RAM, 512GB Storage, 2.3GHz Intel Core i9) - Space Grey";
		softAssert.assertEquals(actual, expected, "The laptop details test passed");

		}
		catch(Exception e){
			e.printStackTrace();			
		}
					
	}
	
	@Test(dependsOnMethods = {"testLaptopDetails"} )
	public void testCart() {
		shopping =laptopDetails.addToCart();
		cart =shopping.openCart();
		String actual =cart.getProductName();
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
		
		
	}

}

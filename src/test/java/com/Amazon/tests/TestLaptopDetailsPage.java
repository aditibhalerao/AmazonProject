package com.Amazon.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Amazon.basePackage.Driver;
import com.Amazon.commonFunctions.CommonMethods;
import com.Amazon.pageClasses.HomePage;
import com.Amazon.pageClasses.LaptopDetailsPage;
import com.Amazon.pageClasses.LaptopResultsPage;

public class TestLaptopDetailsPage extends TestPrerequisites {

	@Test(description="Test if the Laptop details are displayed correctly.")
	public void testLaptopDetails () {
		
		try {
				
		HomePage homePage =Driver.startDriver();
		LaptopResultsPage laptops= homePage.clickMainMenu().clickComputerMenu().clickLaptopMenu();
		LaptopDetailsPage laptopDetails= laptops.selectAppleLaptops().selectRatings().sortLaptopsByPrice().select5Stars();
		
		String actual=laptopDetails.printDetails();
		String expected ="Apple MacBook Pro (15-inch, Latest Model, 16GB RAM, 512GB Storage, 2.3GHz Intel Core i9) - Space Grey";
		Assert.assertEquals(actual, expected, "The laptop details test passed");
		}
		catch(Exception e){
			e.printStackTrace();			
		}

	}

}

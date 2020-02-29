package com.Amazon.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.Amazon.basePackage.Driver;

public class TestPrerequisites {
	
	@BeforeMethod
	public void initializeDriver() {
		
		try {
			Driver drv = new Driver();
			Driver.startDriver();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@AfterMethod
	public void tearDown() {
		Driver.d.quit();
		
	}

}

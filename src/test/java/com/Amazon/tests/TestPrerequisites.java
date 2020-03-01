package com.Amazon.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.Amazon.basePackage.Driver;

public class TestPrerequisites {
	
	@BeforeTest
	public void initializeDriver() {
		
		try {
			Driver drv = new Driver();
			Driver.startDriver();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@AfterTest
	public void tearDown() {
		Driver.d.quit();
		
	}

}

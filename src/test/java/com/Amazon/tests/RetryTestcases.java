package com.Amazon.tests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTestcases implements IRetryAnalyzer {

	public boolean retry(ITestResult result) {
		
		int count =0;
		int maxTry =2;
		
		if(!result.isSuccess()) {
			if(count<maxTry) {
				count++;
				return true; 
			}			
		}
		return false;
	}

}

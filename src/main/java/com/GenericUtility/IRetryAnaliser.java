package com.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryAnaliser implements IRetryAnalyzer{

	
	int count = 0;
	int RetryLimit=2;
	@Override
	public boolean retry(ITestResult result) {
		
		if(count<RetryLimit) {
			
			count++;
			return true;
		}
		return false;
	}
	
	

}

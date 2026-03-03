package com.ditto.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {

	public static final int MAX_NO_OF_ATTEMPTS = 3;
	public static int currentAttempt = 1;

	@Override
	public boolean retry(ITestResult result) {
		if (currentAttempt <= MAX_NO_OF_ATTEMPTS) {
			currentAttempt++;
			return true;
		}
		return false;
	}

}

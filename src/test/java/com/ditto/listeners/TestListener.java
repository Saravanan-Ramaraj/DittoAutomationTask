package com.ditto.listeners;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.ditto.utils.BrowserUtility;
import com.ditto.utils.DriverFactory;
import com.ditto.utils.ExtentReporterUtility;
import com.ditto.utils.LoggerUtility;

public class TestListener implements ITestListener {

	Logger logger = LoggerUtility.getLogger(this.getClass());

	@Override
	public void onStart(ITestContext context) {
		logger.info("Test Suite Started");
		ExtentReporterUtility.setupSparkReporter("report.html");
	}

	@Override
	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " PASSED!");
		ExtentReporterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " PASSED!");
		WebDriver driver = DriverFactory.getDriver();
		if (driver != null) {
			String screenshotPath = BrowserUtility.takeScreenShot(driver, result.getMethod().getMethodName());
			ExtentReporterUtility.getTest().addScreenCaptureFromPath(screenshotPath);
		} else {
			logger.warn("Driver was null, screenshot not captured.");
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName() + " FAILED!");
		logger.error(result.getThrowable().getMessage());
		ExtentReporterUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " FAILED!");
		ExtentReporterUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());
		WebDriver driver = DriverFactory.getDriver();
		if (driver != null) {
			String screenshotPath = BrowserUtility.takeScreenShot(driver, result.getMethod().getMethodName());
			ExtentReporterUtility.getTest().addScreenCaptureFromPath(screenshotPath);
		} else {
			logger.warn("Driver was null, screenshot not captured.");
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName() + " SKIPPED!");
		ExtentReporterUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " SKIPPED!");
	}

	@Override
	public void onFinish(ITestContext context) {
		logger.info("Test Suite Finished");
		ExtentReporterUtility.flushReport();
	}
}
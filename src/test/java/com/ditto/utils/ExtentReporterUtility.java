package com.ditto.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterUtility {
	private static ExtentReports extentReports;
	private static ExtentTest extentTest;

	public static void setupSparkReporter(String reportName) {
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "//" + reportName);
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
	}

	public static void createExtentTest(String testName) {
		extentTest = extentReports.createTest(testName);

	}

	public static ExtentTest getTest() {
		return extentTest;
	}

	public static void flushReport() {
		extentReports.flush();
	}
}

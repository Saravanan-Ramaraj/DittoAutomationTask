
package com.ditto.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtility {

	protected WebDriver driver;
	private Logger logger = LoggerUtility.getLogger(this.getClass());
	private WebDriverWait wait;

	public BrowserUtility(WebDriver driver) {
		logger.info("Launching Browser ");
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void goToWebsite(String url) {
		logger.info("Visiting the website " + url);
		driver.get(url);
	}

	public void maximizeWindow() {
		logger.info("Maximizing the browser window");

		driver.manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("Finding Element with the locator" + locator);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		logger.info("Element Found and now performing Click");

		element.click();
	}

	public void enterText(By locator, String textToEnter) {
		logger.info("Finding Element with the locator" + locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element Found and now enter text " + textToEnter);

		element.sendKeys(textToEnter);
	}

	public void clearText(By textBoxLocator) {
		logger.info("Finding Element with the locator" + textBoxLocator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxLocator));
		logger.info("Element Found and clearing the text box field");

		element.clear();
	}

	public void waitUntilButtonEnabled(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));

	}

	public String getVisibleText(By locator) {
		logger.info("Finding Element with the locator" + locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element Found and now returning the visibile " + element.getText());
		return element.getText();
	}

	public static String takeScreenShot(WebDriver driver, String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String path = System.getProperty("user.dir") + "//screenshots//" + name + " - " + timeStamp + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return path;
	}

}

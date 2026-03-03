package com.ditto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ditto.utils.BrowserUtility;

public class UserDetailsPage extends BrowserUtility {

	private static final By SELF_MALE_LOCATOR = By.xpath("//span[text()='Self']/following::div[text()='Male']");
	private static final By NEXT_STEP_BUTTON_LOCATOR = By.xpath("//span[text()='Next step']");
	private static final By AGE_INPUT_FIELD_LOCATOR = By.xpath("//input[@placeholder='Your age']");
	private static final By PIN_CODE_INPUT_FIELD_LOCATOR = By.xpath("//input[@placeholder='Enter your pin code']");
	private static final By CALCULATE_PREMIUM_BUTTON_LOCATOR = By
			.xpath("//span[text()='Calculate Premium']/ancestor::button");

	public UserDetailsPage(WebDriver driver) {
		super(driver);
		;

	}

	public PremiumPage selectSelfAndFillDetails() {
		clickOn(SELF_MALE_LOCATOR);
		clickOn(NEXT_STEP_BUTTON_LOCATOR);
		enterText(AGE_INPUT_FIELD_LOCATOR, "28");
		enterText(PIN_CODE_INPUT_FIELD_LOCATOR, "627756");
		clickOn(CALCULATE_PREMIUM_BUTTON_LOCATOR);
		return new PremiumPage(getDriver());
	}

}

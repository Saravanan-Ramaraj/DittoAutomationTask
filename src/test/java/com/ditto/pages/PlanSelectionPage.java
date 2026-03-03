package com.ditto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ditto.utils.BrowserUtility;

public class PlanSelectionPage extends BrowserUtility {

	

	private static final By OPTIMA_SECURE_BUTTON_LOCATOR = By.xpath("//span[text()='Optima Secure']");
	private static final By NEXT_BUTTON_LOCATOR = By.xpath("//span[text()='Next']");
	private static final By CONTINUE_BUTTON_LOCATOR = By.xpath("//span[text()='Continue']");

	public PlanSelectionPage(WebDriver driver) {
		super(driver);
		goToWebsite("https://app.joinditto.in/fq");
	}

	public PlanSelectionPage selectPlan() {
		clickOn(OPTIMA_SECURE_BUTTON_LOCATOR);
		return this;
	}

	public PlanSelectionPage goToNext() {
		clickOn(NEXT_BUTTON_LOCATOR);
		return this;
	}

	public UserDetailsPage proceed() {
		clickOn(CONTINUE_BUTTON_LOCATOR);
		return new UserDetailsPage(getDriver());
	}

}

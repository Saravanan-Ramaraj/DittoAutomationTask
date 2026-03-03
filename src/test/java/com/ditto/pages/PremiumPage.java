package com.ditto.pages;

import java.math.BigDecimal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ditto.utils.BrowserUtility;

public class PremiumPage extends BrowserUtility {

	private static final By BASE_PREMIUM_AMOUNT_ONE_YEAR_LOCATOR = By
			.xpath("//span[text()='Policy Periods']/following::span[3]");
	private static final By UNLIMITED_RESTORATION_ADDON_LOCATOR = By
			.xpath("//input[@name='Unlimited Restoration']/following::span[5]");
	private static final By UNLIMITED_RESTORATION_ADDON_CHECKBOX_LOCATOR = By
			.xpath("//input[@name='Unlimited Restoration']");
	private static final By OTHER_ADDONS_BUTTON_LOCATOR = By.xpath("//button[contains(@id, 'other-add-ons')]");
	private static final By HOSPITAL_CASH_BENFIT_ADDON_LOCATOR = By
			.xpath("//input[@name='Hospital Cash Benefit']/following::span[5]");
	private static final By HOSPITAL_CASH_BENFIT_ADDON_CHECKBOX_LOCATOR = By
			.xpath("//input[@name='Hospital Cash Benefit']");
	private static final By BUY_THIS_POLICY_LOCATOR = By.xpath("//span[text()='Buy this policy']");

	public PremiumPage(WebDriver driver) {
		super(driver);
	}

	public BigDecimal getBasePremium() {

		String basePremiumAmountOneYearText = getVisibleText(BASE_PREMIUM_AMOUNT_ONE_YEAR_LOCATOR).replaceAll("[^0-9.]",
				"");
		System.out.println("Base Premium 1 Year : " + basePremiumAmountOneYearText);
		return new BigDecimal(basePremiumAmountOneYearText);

	}

	public BigDecimal getUnlimitedRestorationAddOn() {

		String unlimitedRestorationAddOnAmountText = getVisibleText(UNLIMITED_RESTORATION_ADDON_LOCATOR)
				.replaceAll("[^0-9.]", "");
		System.out.println("Unlimited Restoration : " + unlimitedRestorationAddOnAmountText);
		return new BigDecimal(unlimitedRestorationAddOnAmountText);

	}

	public PremiumPage clickOtherAddOnsDropDownButton() {
		clickOn(OTHER_ADDONS_BUTTON_LOCATOR);
		return this;
	}

	public BigDecimal getHospitalCashBenefitAddOn() {

		String hospitalCashBenefitAddOnAmountText = getVisibleText(HOSPITAL_CASH_BENFIT_ADDON_LOCATOR)
				.replaceAll("[^0-9.]", "");
		System.out.println("Hospital Cash Benefit : " + hospitalCashBenefitAddOnAmountText);
		return new BigDecimal(hospitalCashBenefitAddOnAmountText);
	}

	public PremiumPage clickUnlimitedRestorationAddOnCheckBox() {
		clickOn(UNLIMITED_RESTORATION_ADDON_CHECKBOX_LOCATOR);
		return this;
	}

	public PremiumPage clickHospitalCashBenefitAddOnCheckBox() {
		clickOn(HOSPITAL_CASH_BENFIT_ADDON_CHECKBOX_LOCATOR);
		return this;
	}

	public PremiumPage waitUntilBuyButtonEnabled() {
		waitUntilButtonEnabled(BUY_THIS_POLICY_LOCATOR);
		return this;
	}

	public BigDecimal getFinalBasePremium() {

		String updatedBasePremiumAmountOneYearText = getVisibleText(BASE_PREMIUM_AMOUNT_ONE_YEAR_LOCATOR)
				.replaceAll("[^0-9.]", "");
		System.out.println("Final Base Premium : " + updatedBasePremiumAmountOneYearText);
		return new BigDecimal(updatedBasePremiumAmountOneYearText);

	}

}

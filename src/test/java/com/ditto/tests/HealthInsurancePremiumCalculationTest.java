package com.ditto.tests;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ditto.pages.PlanSelectionPage;
import com.ditto.pages.PremiumPage;


@Listeners(com.ditto.listeners.TestListener.class)
public class HealthInsurancePremiumCalculationTest extends BaseTest {
	PlanSelectionPage planPage;
	PremiumPage premiumPage;
	
	@Test(description = "Validating the Premium amount after adding the Add-Ons", retryAnalyzer = com.ditto.listeners.MyRetryAnalyzer.class)
	public void validatePremiumCalculationTest() {
		
		planPage = new PlanSelectionPage(driver);
		premiumPage = planPage.selectPlan()
							  .goToNext()
							  .goToNext()
							  .goToNext()
							  .proceed()
							  .selectSelfAndFillDetails();

		BigDecimal basePremium = premiumPage.getBasePremium();
		BigDecimal addOn1 = premiumPage.getUnlimitedRestorationAddOn();
		premiumPage.clickOtherAddOnsDropDownButton();
		BigDecimal addOn2 = premiumPage.getHospitalCashBenefitAddOn();

		BigDecimal expectedFinalBasePremium = basePremium.add(addOn1).add(addOn2);
		expectedFinalBasePremium = expectedFinalBasePremium.setScale(0, RoundingMode.HALF_UP);

		premiumPage.clickUnlimitedRestorationAddOnCheckBox()
				   .clickHospitalCashBenefitAddOnCheckBox()
				   .waitUntilBuyButtonEnabled();
		BigDecimal actualFinalBasePremium = premiumPage.getFinalBasePremium();

		Assert.assertEquals(expectedFinalBasePremium, actualFinalBasePremium, "Final premium after add-ons does not match expected value");
		
	}


}

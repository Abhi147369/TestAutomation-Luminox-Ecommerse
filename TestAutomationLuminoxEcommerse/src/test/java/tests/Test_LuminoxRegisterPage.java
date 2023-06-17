package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LuminoxRegisterPage;

public class Test_LuminoxRegisterPage extends Basetest{
	

	@Test
	public void validTest() {
		LuminoxRegisterPage lr = new LuminoxRegisterPage(driver);
		String randomEmail = lr.generateRandomEmail();
		lr.clickOnRegisterLink();
		lr.registerGender();
		lr.enterFirstName("Abhishek");
		lr.enterLastName("Gavkare");
		lr.enterBirthday(2);
		lr.enterBirthMonth(9);
		lr.enterBirthYear("2000");
		lr.enterEmail(randomEmail);
		lr.enterPassword("12345678");
		lr.confirmPassword("12345678");
		lr.clickRegisterButton();
		boolean isRegistrationSuccessful = lr.isRegistrationSuccessful();
        Assert.assertTrue(isRegistrationSuccessful, "Your registration completed");
	}
	

}

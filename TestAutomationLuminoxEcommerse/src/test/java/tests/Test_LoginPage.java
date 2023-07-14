package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.LoginPage;

@Listeners(listners.TestNGListners.class)
public class Test_LoginPage extends Basetest {
	private LoginPage loginPage;
	private String validEmail = "gavkare.abhishek@gmail.com";
	private String validPassword = "12345678";
	private String invalidEmail = "gavkare@gmail.com";
	private String invalidPassword = "125678";

	@BeforeMethod
	public void setUpLoginPage() {
		loginPage = new LoginPage(driver);
		loginPage.clickLoginLink();
	}

	@Test
	public void validDataTest() {
		loginPage.enterEmail(validEmail);
		loginPage.enterPassword(validPassword);
		loginPage.clickLoginButton();
	}

	@Test
	public void invalidEmailPassword() {
		loginPage.enterEmail(invalidEmail);
		loginPage.enterPassword(invalidPassword);
		loginPage.clickLoginButton();
		String LoginErrorText = loginPage.getErrorMsgBothOrEmailWrong();
		String ExpectedLoginErrorText = "Login was unsuccessful. Please correct the errors and try again.\n"
				+ "No customer account found";
		AssertJUnit.assertEquals(LoginErrorText, ExpectedLoginErrorText);
	}

	@Test
	public void invalidEmail() {
		loginPage.enterEmail(invalidEmail);
		loginPage.enterPassword(validPassword);
		loginPage.clickLoginButton();
		String LoginErrorText = loginPage.getErrorMsgBothOrEmailWrong();
		String ExpectedLoginErrorText = "Login was unsuccessful. Please correct the errors and try again.\n"
				+ "No customer account found";
		AssertJUnit.assertEquals(LoginErrorText, ExpectedLoginErrorText);
	}

	@Test
	public void invalidPassword() {
		loginPage.enterEmail(validEmail);
		loginPage.enterPassword(invalidPassword);
		loginPage.clickLoginButton();
		String LoginErrorText = loginPage.getErrorMsg();
		String ExpectedLoginErrorText = "Login was unsuccessful. Please correct the errors and try again.\n"
				+ "The credentials provided are incorrect";
		AssertJUnit.assertEquals(LoginErrorText, ExpectedLoginErrorText);
	}

	@Test
	public void testEmptyUsername() {
		loginPage.enterEmail("");
		loginPage.enterPassword(validPassword);
		loginPage.clickLoginButton();
		String errorMsg = loginPage.getErrorMSgEmptyEmail();
		Assert.assertEquals(errorMsg, "Please enter your email");
	}

	@Test
	public void testEmptyPassword() {
		loginPage.enterEmail(invalidEmail);
		loginPage.enterPassword("");
		loginPage.clickLoginButton();
		String errorMsg = loginPage.getErrorMsg();
		Assert.assertEquals(errorMsg,
				"Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");
	}

	@Test
	public void testForgotPasswordLink() {
		loginPage.clickForgotPasswordLink();
		String resetPageTitle = driver.getTitle();
		Assert.assertEquals(resetPageTitle, "Luminoex Online Shopping Application | luminoex.com. Password Recovery");
	}
}

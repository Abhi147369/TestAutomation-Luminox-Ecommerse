package tests;

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
	public void invalidData() {
		loginPage.enterEmail(invalidEmail);
		loginPage.enterPassword(invalidPassword);
		loginPage.clickLoginButton();
		loginPage.getErrorMsgBothOrEmailWrong();
	}

	@Test
	public void invalidEmail() {
		loginPage.enterEmail(invalidEmail);
		loginPage.enterPassword(validPassword);
		loginPage.clickLoginButton();
		loginPage.getErrorMsgBothOrEmailWrong();
	}

	@Test
	public void invalidPassword() {
		loginPage.enterEmail(validEmail);
		loginPage.enterPassword(invalidPassword);
		loginPage.clickLoginButton();
		loginPage.getErrorMsg();
	}
}

package tests;

import org.testng.annotations.Test;

import pages.LoginPage;

public class Test_LoginPage extends Basetest {

	@Test
	public void validDataTest() {
		LoginPage lp = new LoginPage(driver);
		lp.clickLoginLink();
		lp.enterEmail("gavkare.abhishek@gmail.com");
		lp.enterPassword("12345678");
		lp.clickLoginButton();

	}

	@Test
	public void invalidData() {
		LoginPage lp = new LoginPage(driver);
		lp.clickLoginLink();
		lp.enterEmail("gavkare@gmail.com");
		lp.enterPassword("125678");
		lp.clickLoginButton();
		lp.getErrorMsgBothOrEmailWrong();
	}

	@Test
	public void invalidEmail() {
		LoginPage lp = new LoginPage(driver);
		lp.clickLoginLink();
		lp.enterEmail("abhishek@gmail.com");
		lp.enterPassword("12345678");
		lp.clickLoginButton();
		lp.getErrorMsgBothOrEmailWrong();
	}

	@Test
	public void invalidPassword() {
		LoginPage lp = new LoginPage(driver);
		lp.clickLoginLink();
		lp.enterEmail("gavkare.abhishek@gmail.com");
		lp.enterPassword("12346");
		lp.clickLoginButton();
		lp.getErrorMsg();
	}

}

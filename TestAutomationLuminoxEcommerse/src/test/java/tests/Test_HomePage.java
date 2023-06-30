package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

@Listeners(listners.TestNGListners.class)
public class Test_HomePage extends Basetest {

	@Test
	public void verifyHomePageHeaderLinks() {
		HomePage homePage = new HomePage(driver);

		LoginPage lp = new LoginPage(driver);

		lp.clickLoginLink();
		lp.enterEmail("gavkare.abhishek@gmail.com");
		lp.enterPassword("12345678");
		lp.clickLoginButton();

		homePage.clickMyAccountLink();
		homePage.clickWishListLink();
		homePage.clickShoppingCartLink();
		homePage.clickLogOutLink();

	}

	@Test
	public void verifyLogo() {
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isLogoDisplayed());
		homePage.clickLogo();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.luminoex.com/");
	}

	@Test
	public void verifySearchFunctionality() {
		HomePage homePage = new HomePage(driver);
		homePage.performSearch("laptop");
		Assert.assertTrue(driver.getCurrentUrl().contains("search?q=laptop"));
	}

}

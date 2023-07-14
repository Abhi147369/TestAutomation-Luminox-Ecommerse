package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MobilesPage;

@Listeners(listners.TestNGListners.class)
public class Test_MobilePage extends Basetest {
	private LoginPage loginPage;

	@BeforeMethod
	public void setUpLoginPage() {
		loginPage = new LoginPage(driver);
		loginPage.clickLoginLink();
		loginPage.enterEmail("gavkare.abhishek@gmail.com");
		loginPage.enterPassword("12345678");
		loginPage.clickLoginButton();
	}

	@AfterMethod
	public void setUpLogOut() {
		HomePage homePage = new HomePage(driver);
		homePage.clickLogOutLink();
	}

	@Test(priority = 1)
	public void testClickMobileLink() {
		MobilesPage mobilePage = new MobilesPage(driver);

		// Click on the Mobiles link
		mobilePage.clickMobileLink();

		// Perform assertions
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Luminoex Online Shopping Application | luminoex.com. Mobiles");

	}

	@Test(priority = 2)
	public void testClickAndroidOption() {
		MobilesPage mobilePage = new MobilesPage(driver);
		mobilePage.clickMobileLink();

		// Click on the Android option
		mobilePage.clickAndroidOption();

		// Perform assertions
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("android"),
				"URL does not contain 'android' after clicking Android image");
	}

	@Test(priority = 3)
	public void testClickIOSOption() {
		MobilesPage mobilePage = new MobilesPage(driver);
		mobilePage.clickMobileLink();

		// Click on the iOS option
		mobilePage.clickIOSOption();

		// Perform assertions
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("ios"), "URL does not contain 'ios' after clicking iOS image");
	}
}

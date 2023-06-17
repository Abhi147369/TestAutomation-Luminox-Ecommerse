package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage {
	private WebDriver driver;

	private By searchBox = By.name("q");
	private By searchButton = By.xpath("//input[@value='Search']");
	private By logo = By.xpath("//img[@alt='luminoex']");
	private By myAccountLink = By.linkText("My account");
	private By logOutLink = By.linkText("Log out");
	private By wishListLink = By.partialLinkText("Wishlist");
	private By shoppingCartLink = By.partialLinkText("Shopping cart");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickMyAccountLink() {
		WebElement myAccountElement = driver.findElement(myAccountLink);
		myAccountElement.click();
		String MyAccountTitle = driver.getTitle();
		String ExpectedMyAccountTitle = "Luminoex Online Shopping Application | luminoex.com. Account";
		Assert.assertEquals(MyAccountTitle, ExpectedMyAccountTitle);
		driver.navigate().back();
	}

	public void clickWishListLink() {
		WebElement wishListElement = driver.findElement(wishListLink);
		wishListElement.click();
		String WishlistTitle = driver.getTitle();
		String ExpectedWishlistTitle = "Luminoex Online Shopping Application | luminoex.com. Wishlist";
		Assert.assertEquals(WishlistTitle, ExpectedWishlistTitle);
		driver.navigate().back();

	}

	public void clickShoppingCartLink() {
		WebElement shoppingCartElement = driver.findElement(shoppingCartLink);
		shoppingCartElement.click();
		String ShoppingCartTitle = driver.getTitle();
		String ExpectedShoppingCart = "Luminoex Online Shopping Application | luminoex.com. Shopping Cart";
		Assert.assertEquals(ShoppingCartTitle, ExpectedShoppingCart);
		driver.navigate().back();
	}

	public void clickLogOutLink() {
		WebElement logOutElement = driver.findElement(logOutLink);
		logOutElement.click();
		String LogoutTitle = driver.getTitle();
		String ExpectedLogoutTitle = "Luminoex Online Shopping Application | luminoex.com";
		Assert.assertEquals(LogoutTitle, ExpectedLogoutTitle);
	}

	public boolean isLogoDisplayed() {
		return driver.findElement(logo).isDisplayed();
	}

	public void clickLogo() {
		driver.findElement(logo).click();
	}

	public void performSearch(String query) {
		WebElement searchInput = driver.findElement(searchBox);
		searchInput.sendKeys(query);
		driver.findElement(searchButton).click();
	}
	
}

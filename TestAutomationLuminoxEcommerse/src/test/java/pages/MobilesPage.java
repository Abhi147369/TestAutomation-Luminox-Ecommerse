package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MobilesPage {
	private WebDriver driver;
	static WebElement element;

	public MobilesPage(WebDriver driver) {
		this.driver = driver;
	}

	private By mobile_link_linkText = By.linkText("Mobiles");
	private By android_image_xpath = By.xpath("//img[@title='Show products in category Android']");
	private By ios_image_xpath = By.xpath("//img[@title='Show products in category iOS']");

	public void clickMobileLink() {
		WebElement mobileLink = driver.findElement(mobile_link_linkText);
		mobileLink.click();
	}

	public void clickAndroidOption() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement androidOption = wait.until(ExpectedConditions.elementToBeClickable(android_image_xpath));
		androidOption.click();
	}

	public void clickIOSOption() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement iosOption = wait.until(ExpectedConditions.elementToBeClickable(ios_image_xpath));
		iosOption.click();
	}

}

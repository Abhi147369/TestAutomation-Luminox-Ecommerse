package pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LuminoxRegisterPage {
	static WebElement element;
	private WebDriver driver;

	public LuminoxRegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	By register_link_linktext = By.linkText("Register");
	By gender_radio_button_id = By.id("gender-male");
	By first_name_id = By.id("FirstName");
	By last_name_id = By.id("LastName");
	By date_of_birthday_name = By.name("DateOfBirthDay");
	By date_of_birthmonth_name = By.name("DateOfBirthMonth");
	By date_of_birthyear_name = By.name("DateOfBirthYear");
	By email_id = By.id("Email");
	By password_id = By.id("Password");
	By confirm_password_id = By.id("ConfirmPassword");
	By register_button_id = By.id("register-button");
	By successMessage = By.xpath("//div[@class='result']");

	// Methods
	public void clickOnRegisterLink() {
		driver.findElement(register_link_linktext).click();
	}

	public void registerGender() {
		driver.findElement(gender_radio_button_id).click();
	}

	public void enterFirstName(String name) {
		driver.findElement(first_name_id).clear();
		driver.findElement(first_name_id).sendKeys(name);
	}

	public void enterLastName(String lastName) {
		driver.findElement(last_name_id).clear();
		driver.findElement(last_name_id).sendKeys(lastName);
	}

	public void enterBirthday(int day) {
		WebElement birthday = driver.findElement(date_of_birthday_name);
		Select select = new Select(birthday);
		select.selectByIndex(day);
	}

	public void enterBirthMonth(int month) {
		WebElement birthday = driver.findElement(date_of_birthmonth_name);
		Select select = new Select(birthday);
		select.selectByIndex(month);
	}

	public void enterBirthYear(String year) {
		WebElement birthday = driver.findElement(date_of_birthyear_name);
		Select select = new Select(birthday);
		select.selectByVisibleText(year);
	}

	public String generateRandomEmail() {
		String allowedChars = "abcdefghijklmnopqrstuvwxyz1234567890";
		StringBuilder email = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < 10; i++) {
			int randomIndex = random.nextInt(allowedChars.length());
			email.append(allowedChars.charAt(randomIndex));
		}

		email.append("@gmail.com");

		return email.toString();
	}

	public void enterEmail(String email) {
		driver.findElement(email_id).clear();
		driver.findElement(email_id).sendKeys(email);
	}

	public void enterPassword(String password) {
		driver.findElement(password_id).clear();
		driver.findElement(password_id).sendKeys(password);
	}

	public void confirmPassword(String confirmPassword) {
		driver.findElement(confirm_password_id).clear();
		driver.findElement(confirm_password_id).sendKeys(confirmPassword);
	}

	public void clickRegisterButton() {
		driver.findElement(register_button_id).click();
	}

	public boolean isRegistrationSuccessful() {
		WebElement successMessageElement = driver.findElement(successMessage);
		return successMessageElement.isDisplayed();

	}

}

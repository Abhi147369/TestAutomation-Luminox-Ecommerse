package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class LuminoxRegisterPage {
	private WebDriver driver;

	private By registerLink = By.linkText("Register");
	private By genderRadioButton = By.id("gender-male");
	private By firstNameInput = By.id("FirstName");
	private By lastNameInput = By.id("LastName");
	private By dateOfBirthDaySelect = By.name("DateOfBirthDay");
	private By dateOfBirthMonthSelect = By.name("DateOfBirthMonth");
	private By dateOfBirthYearSelect = By.name("DateOfBirthYear");
	private By emailInput = By.id("Email");
	private By passwordInput = By.id("Password");
	private By confirmPasswordInput = By.id("ConfirmPassword");
	private By registerButton = By.id("register-button");
	private By successMessage = By.xpath("//div[@class='result']");
	private By nameRquiredErrorMsg = By.xpath("//span[@id='FirstName-error']");
	private By LastnameRquiredErrorMsg = By.xpath("//span[@id='LastName-error']");
	private By invalidEmailErrorMsg = By.xpath("//span[@id='Email-error']");
	private By mismatchedPasswordsErrorMsg = By.xpath("//span[@id='ConfirmPassword-error']");

	public LuminoxRegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickRegisterLink() {
		driver.findElement(registerLink).click();
	}

	public void selectGender() {
		driver.findElement(genderRadioButton).click();
	}

	public void enterFirstName(String firstName) {
		WebElement firstNameElement = driver.findElement(firstNameInput);
		firstNameElement.clear();
		firstNameElement.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		WebElement lastNameElement = driver.findElement(lastNameInput);
		lastNameElement.clear();
		lastNameElement.sendKeys(lastName);
	}

	public void enterDateOfBirth(int day, int month, String year) {
		selectOptionByIndex(dateOfBirthDaySelect, day);
		selectOptionByIndex(dateOfBirthMonthSelect, month);
		selectOptionByVisibleText(dateOfBirthYearSelect, year);
	}

	private void selectOptionByIndex(By locator, int index) {
		WebElement element = driver.findElement(locator);
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	private void selectOptionByVisibleText(By locator, String visibleText) {
		WebElement element = driver.findElement(locator);
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	public String generateRandomEmail() {
		String allowedChars = "abcdefghijklmnopqrstuvwxyz1234567890";
		StringBuilder email = new StringBuilder(20);
		Random random = new Random();

		for (int i = 0; i < 10; i++) {
			int randomIndex = random.nextInt(allowedChars.length());
			email.append(allowedChars.charAt(randomIndex));
		}

		email.append("@gmail.com");

		return email.toString();
	}

	public void enterEmail(String email) {
		WebElement emailElement = driver.findElement(emailInput);
		emailElement.clear();
		emailElement.sendKeys(email);
	}

	public void enterPassword(String password) {
		WebElement passwordElement = driver.findElement(passwordInput);
		passwordElement.clear();
		passwordElement.sendKeys(password);
	}

	public void confirmPassword(String confirmPassword) {
		WebElement confirmPasswordElement = driver.findElement(confirmPasswordInput);
		confirmPasswordElement.clear();
		confirmPasswordElement.sendKeys(confirmPassword);
	}

	public void clickRegisterButton() {
		driver.findElement(registerButton).click();
	}

	public boolean isRegistrationSuccessful() {
		WebElement successMessageElement = driver.findElement(successMessage);
		return successMessageElement.isDisplayed();
	}

	public String getNameRequiredErrorMessage() {
		return driver.findElement(nameRquiredErrorMsg).getText();
	}

	public String getLastNameRequiredErrorMessage() {
		return driver.findElement(LastnameRquiredErrorMsg).getText();
	}

	public String getInvalidEmailErrorMessage() {
		return driver.findElement(invalidEmailErrorMsg).getText();
	}

	public String getMismatchedPasswordsErrorMessage() {
		return driver.findElement(mismatchedPasswordsErrorMsg).getText();
	}

}

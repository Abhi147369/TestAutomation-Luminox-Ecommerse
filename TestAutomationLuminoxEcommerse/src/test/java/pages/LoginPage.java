package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {
	private WebDriver driver;
	static WebElement element;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators

	private By login_xpath = By.xpath("//a[@class='ico-login']");
	private By input_email_id = By.id("Email");
	private By input_password_id = By.id("Password");
	private By button_login_xpath = By.xpath("//input[@class ='button-1 login-button']");
	private By errorMsg_xpath = By.xpath("//div[@class='message-error validation-summary-errors']");
	private By emptyEmail_xpath= By.xpath("//span[@id='Email-error']");
	private By click_forgot_pass_xpath = By.xpath("//a[normalize-space()='Forgot password?']");

	// Methods
	public void clickLoginLink() {
		driver.findElement(login_xpath).click();
	}

	public void enterEmail(String email) {
		driver.findElement(input_email_id).clear();
		driver.findElement(input_email_id).sendKeys(email);
	}

	public void enterPassword(String password) {
		driver.findElement(input_password_id).clear();
		driver.findElement(input_password_id).sendKeys(password);
	}

	public void clickLoginButton() {
		driver.findElement(button_login_xpath).click();
	}

	public String getErrorMsg() {
		String LoginErrorText = driver.findElement(errorMsg_xpath).getText();
		return LoginErrorText;
	}
	
	public String getErrorMSgEmptyEmail() {
		String EmptyEmailErrorText = driver.findElement(emptyEmail_xpath).getText();
		return EmptyEmailErrorText;
		
	}

	public String getErrorMsgBothOrEmailWrong() {
		String LoginErrorText = driver.findElement(errorMsg_xpath).getText();
		return LoginErrorText;
	}

	public void clickForgotPasswordLink() {
		driver.findElement(click_forgot_pass_xpath).click();

	}

}

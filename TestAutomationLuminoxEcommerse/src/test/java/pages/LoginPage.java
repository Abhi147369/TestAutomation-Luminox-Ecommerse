package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {
	public WebDriver driver;
	static WebElement element;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators

	By login_xpath = By.xpath("//a[@class='ico-login']");
	By input_email_id = By.id("Email");
	By input_password_id = By.id("Password");
	By button_login_xpath = By.xpath("//input[@class ='button-1 login-button']");
	By errorMsg_xpath = By.xpath("//div[@class='message-error validation-summary-errors']");
	

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
	
	public void getErrorMsg() {
		String LoginErrorText = driver.findElement(errorMsg_xpath).getText();
		System.out.println(LoginErrorText);
		String ExpectedLoginErrorText = "Login was unsuccessful. Please correct the errors and try again.\n"
				+ "The credentials provided are incorrect";
		Assert.assertEquals(LoginErrorText,ExpectedLoginErrorText);
	}
	
	public void getErrorMsgBothOrEmailWrong() {
		String LoginErrorText = driver.findElement(errorMsg_xpath).getText();
		System.out.println(LoginErrorText);
		String ExpectedLoginErrorText = "Login was unsuccessful. Please correct the errors and try again.\n"
				+ "No customer account found";
		Assert.assertEquals(LoginErrorText,ExpectedLoginErrorText);
		
	}

}

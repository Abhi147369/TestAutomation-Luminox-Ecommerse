package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.LuminoxRegisterPage;

@Listeners(listners.TestNGListners.class)
public class Test_LuminoxRegisterPage extends Basetest {

    @Test
    public void validTest() {
        LuminoxRegisterPage lr = new LuminoxRegisterPage(driver);
        String randomEmail = lr.generateRandomEmail();
        lr.clickRegisterLink();
        lr.selectGender();
        lr.enterFirstName("Abhishek");
        lr.enterLastName("Gavkare");
        lr.enterDateOfBirth(2, 9, "2000");
        lr.enterEmail(randomEmail);
        lr.enterPassword("12345678");
        lr.confirmPassword("12345678");
        lr.clickRegisterButton();

        boolean isRegistrationSuccessful = lr.isRegistrationSuccessful();
        AssertJUnit.assertTrue(isRegistrationSuccessful);
    }

    @Test
    public void missingFirstNameTest() {
        LuminoxRegisterPage lr = new LuminoxRegisterPage(driver);
        lr.clickRegisterLink();
        lr.selectGender();
        lr.enterLastName("Gavkare");
        lr.enterDateOfBirth(2, 9, "2000");
        lr.enterEmail(lr.generateRandomEmail());
        lr.enterPassword("12345678");
        lr.confirmPassword("12345678");
        lr.clickRegisterButton();

        String nameRequiredErrorMessage = lr.getNameRequiredErrorMessage();
        AssertJUnit.assertEquals(nameRequiredErrorMessage, "First name is required.", "Incorrect name required error message");
    }

    @Test
    public void missingLastNameTest() {
        LuminoxRegisterPage lr = new LuminoxRegisterPage(driver);
        lr.clickRegisterLink();
        lr.selectGender();
        lr.enterFirstName("Abhishek");
        lr.enterDateOfBirth(2, 9, "2000");
        lr.enterEmail(lr.generateRandomEmail());
        lr.enterPassword("12345678");
        lr.confirmPassword("12345678");
        lr.clickRegisterButton();

        String lastNameRequiredErrorMessage = lr.getLastNameRequiredErrorMessage();
        AssertJUnit.assertEquals(lastNameRequiredErrorMessage, "Last name is required.", "Incorrect last name required error message");
    }

    @Test
    public void invalidEmailTest() {
        LuminoxRegisterPage lr = new LuminoxRegisterPage(driver);
        lr.clickRegisterLink();
        lr.selectGender();
        lr.enterFirstName("Abhishek");
        lr.enterLastName("Gavkare");
        lr.enterDateOfBirth(2, 9, "2000");
        lr.enterEmail("invalid_email");
        lr.enterPassword("12345678");
        lr.confirmPassword("12345678");
        lr.clickRegisterButton();

        String invalidEmailErrorMessage = lr.getInvalidEmailErrorMessage();
        AssertJUnit.assertEquals(invalidEmailErrorMessage, "Wrong email", "Incorrect invalid email error message");
    }

    @Test
    public void mismatchedPasswordsTest() {
        LuminoxRegisterPage lr = new LuminoxRegisterPage(driver);
        lr.clickRegisterLink();
        lr.selectGender();
        lr.enterFirstName("Abhishek");
        lr.enterLastName("Gavkare");
        lr.enterDateOfBirth(2, 9, "2000");
        lr.enterEmail(lr.generateRandomEmail());
        lr.enterPassword("12345678");
        lr.confirmPassword("87654321");
        lr.clickRegisterButton();

        String mismatchedPasswordsErrorMessage = lr.getMismatchedPasswordsErrorMessage();
        AssertJUnit.assertEquals(mismatchedPasswordsErrorMessage, "The password and confirmation password do not match.", "Incorrect mismatched passwords error message");
    }
}

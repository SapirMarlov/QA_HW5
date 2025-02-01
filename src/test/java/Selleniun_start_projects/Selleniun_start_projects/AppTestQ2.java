package Selleniun_start_projects.Selleniun_start_projects;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class AppTestQ2 {

    static WebDriver browser;

    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        browser = new FirefoxDriver();
        browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  // Adjusted to 10 seconds
        browser.get("https://testpages.eviltester.com/styled/apps/7charval/simple7charvalidation.html");
    }

    @After
    public void tearDown() {
        if (browser != null) {
            browser.quit();
        }
    }

    @Test
    public void testPasswordTooShort() {
        String actualResult = testPasswordValidation("Ab1!");
        assertEquals("Invalid Value", actualResult);
    }

    @Test
    public void testPasswordWithStars() {
        String actualResult = testPasswordValidation("*******");
        assertEquals("Valid Value", actualResult);
    }

    @Test
    public void testValidPassword() {
        String actualResult = testPasswordValidation("A1b2C3d");
        assertEquals("Valid Value", actualResult);
    }

    @Test
    public void testPasswordWithDigitsOnly() {
        String actualResult = testPasswordValidation("1234567");
        assertEquals("Valid Value", actualResult);
    }

    @Test
    public void testPasswordWithSpecialCharacters() {
        String actualResult = testPasswordValidation("@#$%^&*");
        assertEquals("Invalid Value", actualResult);
    }

    @Test
    public void testPasswordWithLowercaseOnly() {
        String actualResult = testPasswordValidation("abcdefg");
        assertEquals("Valid Value", actualResult);
    }

    @Test
    public void testEmptyPassword() {
        String actualResult = testPasswordValidation("");
        assertEquals("Invalid Value", actualResult);
    }

    @Test
    public void testPasswordWithUppercaseOnly() {
        String actualResult = testPasswordValidation("ABCDEFG");
        assertEquals("Valid Value", actualResult);
    }

    @Test
    public void testPasswordTooLong() {
        String actualResult = testPasswordValidation("AaBbCcDdEe");
        assertEquals("Invalid Value", actualResult);
    }

    @Test
    public void testPasswordWithSpaces() {
        String actualResult = testPasswordValidation("Valid* 123");
        assertEquals("Invalid Value", actualResult);
    }

    // Helper method to perform the test for password validation
    private String testPasswordValidation(String password) {
        // Locate the password input field using its name attribute
        WebElement passwordField = browser.findElement(By.name("characters"));
        passwordField.clear();
        passwordField.sendKeys(password);

        // Click the validation button using its name attribute
        browser.findElement(By.name("validate")).click();

        // Wait for the validation message to appear in the result input field
        WebDriverWait wait = new WebDriverWait(browser, 10);
        WebElement resultElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("validation_message")));

        // Retrieve the validation message from the value attribute
        return resultElement.getAttribute("value");
    }

}

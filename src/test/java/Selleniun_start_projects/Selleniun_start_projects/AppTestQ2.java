package Selleniun_start_projects.Selleniun_start_projects;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class AppTestQ2 {
  

    static WebDriver  browser;
	 
	 @Before
	  public void setup() {
		 
			  System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		      browser = new FirefoxDriver();
		  	  browser.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
		      browser.get("https://testpages.eviltester.com/styled/apps/7charval/simple7charvalidation.html");
		
	  }

    @After
    public void tearDown() {
        if (browser != null) {
            browser.quit();
        }
    }

    @Test
    public void testPasswordValidation() {
        // Updated table of test cases with positive and negative examples
        Object[][] testCases = {
            {"Password is invalid", "Ab1!"},    // Too short
            {"Password is valid", "*******"},    // 7 * in password
            {"Password is valid", "A1b2C3d"},      // Valid: diverse characters
            {"Password is valid", "1234567"},     // Only digits
            {"Password is invalid", "@#$%^&*"},     // Only special characters
            {"Password is valid", "abcdefg"},      // Valid: lowercase           
            {"Password is invalid", ""},            // Empty password
            {"Password is valid", "ABCDEFG"},         // Valid: Uppercase
            {"Password is invalid", "AaBbCcDdEe"},  // too long
            {"Password is invalid", "Valid* 123"}   // Invalid: contains space in special position
        };

        for (Object[] testCase : testCases) {
            String expectedResult = (String) testCase[0];
            String password = (String) testCase[1];

            // Enter password into the input field
            WebElement passwordField = browser.findElement(By.id("password"));
            passwordField.clear();
            passwordField.sendKeys(password);

            // Click the submit button
            browser.findElement(By.id("submitbutton")).click();

            // Retrieve the result
            WebElement resultElement = browser.findElement(By.id("password-result"));
            String actualResult = resultElement.getText();

            // Validate the result
            assertEquals("Test failed for password: " + password, expectedResult, actualResult);
        }
    }
}

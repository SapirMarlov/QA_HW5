package Selleniun_start_projects.Selleniun_start_projects;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class traingle_test {

 static WebDriver  browser;
	 
	 @Before
	  public void setup() {
		 
			  System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		      browser = new FirefoxDriver();
		  	  browser.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
		      browser.get("https://testpages.eviltester.com/styled/apps/triangle/triangle001.html");
		
	  }
	 
    // Function to classify triangle (local validation if needed)
    public String classifyTriangle(int a, int b, int c) {
        if (a + b <= c || a + c <= b || b + c <= a) {
            return "Not a triangle";
        } else if (a == b && b == c) {
            return "equilateral";
        } else if (a == b || b == c || a == c) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }

    @Test
    public void testTriangleClassificationOnWebsite() {
        // Updated test cases array without IDs
        Object[][] testCases = {
            {"Not a triangle", 2, 3, 6},   // Not a triangle
            {"Not a triangle", 0, 1, 1},   // Zero-length side
            {"Not a triangle", 1, 1, 5},   // Not a triangle
            {"equilateral", 7, 7, 7},      // All sides equal
            {"isosceles", 5, 5, 3},        // Two sides equal
            {"isosceles", 10, 15, 10},     // Two sides equal, longer third side
            {"scalene", 8, 10, 12},        // All sides different
            {"scalene", 7, 24, 25}         // Pythagorean triple (right-angled)
        };

        for (Object[] testCase : testCases) {
            String expectedResult = (String) testCase[0];
            int a = (int) testCase[1];
            int b = (int) testCase[2];
            int c = (int) testCase[3];

            // Enter data into the input fields on the website
            WebElement sideA = browser.findElement(By.id("triangle_side1"));
            WebElement sideB = browser.findElement(By.id("triangle_side2"));
            WebElement sideC = browser.findElement(By.id("triangle_side3"));

            sideA.clear();
            sideB.clear();
            sideC.clear();

            sideA.sendKeys(String.valueOf(a));
            sideB.sendKeys(String.valueOf(b));
            sideC.sendKeys(String.valueOf(c));

            // Click the calculate button
            browser.findElement(By.id("calculate")).click();

            // Read the result from the output field
            WebElement resultElement = browser.findElement(By.id("triangle_type"));
            String actualResult = resultElement.getText();

            // Compare the expected and actual results
            assertEquals("Test failed for input: " + a + ", " + b + ", " + c, expectedResult, actualResult);
        }
    }

    @Test
    public void tearDown() {
        if (browser != null) {
            browser.quit();
        }
    }
}
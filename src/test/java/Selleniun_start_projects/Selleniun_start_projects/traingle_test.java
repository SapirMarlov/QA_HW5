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

public class traingle_test {

    static WebDriver browser;

    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        browser = new FirefoxDriver();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Adjusted to 10 seconds
        browser.get("https://testpages.eviltester.com/styled/apps/triangle/triangle001.html");
    }

    @After
    public void tearDown() {
        if (browser != null) {
            browser.quit();
        }
    }

    @Test
    public void testNotATriangle1() {
    	
        String actualResult = testTriangleClassification(2, 3, 6);
        assertEquals("Error: Not a Triangle", actualResult);
    }

    @Test
    public void testNotATriangle2() {
        String actualResult = testTriangleClassification(1, 1, 0);
        assertEquals("Error: Not a Triangle", actualResult);
    }				  

    @Test
    public void testNotATriangle3() {
        String actualResult = testTriangleClassification(1, 1, 5);
        assertEquals("Error: Not a Triangle", actualResult);
    }

    @Test
    public void testEquilateralTriangle() {
        String actualResult = testTriangleClassification(7, 7, 7);
        assertEquals("Equilateral", actualResult);
    }

    @Test
    public void testIsoscelesTriangle1() {
        String actualResult = testTriangleClassification(5, 5, 3);
        assertEquals("Isosceles", actualResult);
    }

    @Test
    public void testIsoscelesTriangle2() {
        String actualResult = testTriangleClassification(10, 15, 10);
        assertEquals("Isosceles", actualResult);
    }

    @Test
    public void testIsoscelesTriangle3() {
        String actualResult = testTriangleClassification(6, 8, 8);
        assertEquals("Isosceles", actualResult);
    }

    @Test
    public void testScaleneTriangle1() {
        String actualResult = testTriangleClassification(8, 10, 12);
        assertEquals("Scalene", actualResult);
    }

    @Test
    public void testScaleneTriangle2() {
        String actualResult = testTriangleClassification(7, 24, 25);
        assertEquals("Scalene", actualResult);
    }

    // Helper method to perform the test for triangle classification
    private String testTriangleClassification(int a, int b, int c) {
        // Enter data into the input fields on the website
        WebElement sideA = browser.findElement(By.id("side1"));
        WebElement sideB = browser.findElement(By.id("side2"));
        WebElement sideC = browser.findElement(By.id("side3"));

        sideA.clear();
        sideB.clear();
        sideC.clear();

        sideA.sendKeys(String.valueOf(a));
        sideB.sendKeys(String.valueOf(b));
        sideC.sendKeys(String.valueOf(c));

        // Click the calculate button
        browser.findElement(By.id("identify-triangle-action")).click();

        // Read the result from the output field
        WebElement resultElement = browser.findElement(By.id("triangle-type"));
        return resultElement.getText();
    }
}

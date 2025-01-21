package Selleniun_start_projects.Selleniun_start_projects;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.After;
import org.junit.Before;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.lang.Thread;
import org.openqa.selenium.support.ui.Select;
public class AppTest {
	 
	
	 static WebDriver  browser;
	 
	 @Before
	  public void setup() {
		 
			  System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		      browser = new FirefoxDriver();
		  	  browser.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
		      browser.get("https://testpages.eviltester.com/styled/apps/7charval/simple7charvalidation.html");
		
	  }
		
	@Test
	public void Tests1() {
    	
		
			WebElement textBox = browser.findElement(By.id("firstname"));
			textBox.sendKeys("chaya");
			textBox = browser.findElement(By.id("surname"));
			textBox.sendKeys("Zilberstein");
			textBox = browser.findElement(By.id("age"));
			textBox.sendKeys("21");
			Select drpCountry = new Select(browser.findElement(By.name("country")));
			drpCountry.selectByVisibleText("Israel");
			String currentPage=browser.getCurrentUrl();
			browser.findElement(By.cssSelector("input[type='submit']")).click();
			String newPage = browser.getCurrentUrl();
			assertNotEquals(currentPage, newPage);
    }
	
	
}
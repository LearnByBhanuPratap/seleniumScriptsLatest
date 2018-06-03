package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class KeyboardAndMouseEventUsingActionClassInSelenium{

	// Create instance of web driver
	WebDriver driver;
	
	@Test
	public void keyboardAndMouseEventUsingActionClassInSelenium() throws InterruptedException{
		
		// First step set the driver location
		//For Window user
		//System.setProperty("webdriver.chrome.driver", "/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", "/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver");
		
		// Create Object of driver.
		driver = new ChromeDriver();
		
		// Navigate to site
		driver.get("https://www.facebook.com/");
		WebElement webElement = driver.findElement(By.name("firstname"));
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.moveToElement(webElement).click()
		.keyDown(webElement,Keys.SHIFT).
		sendKeys(webElement,"hello")
		.keyUp(webElement,Keys.SHIFT)
		.doubleClick(webElement)
		.contextClick().build();
		action.perform();
		// enter email address
		//driver.findElement(By.xpath("//*[@id='email']")).sendKeys("test@gmail.com");
		
		

	}
}

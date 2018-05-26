package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HowToEnterDataInTextbox {
	
	// Create instance of web driver
	WebDriver driver;
	
	@Test
	public void enterDataInTextField(){
		
		// First step set the driver location
		//For Window user
		//System.setProperty("webdriver.chrome.driver", "/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", "/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver");
		
		// Create Object of driver.
		driver = new ChromeDriver();
		
		// Navigate to site
		driver.get("https://www.facebook.com/");
		// enter email address
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("test@gmail.com");;
	}
}

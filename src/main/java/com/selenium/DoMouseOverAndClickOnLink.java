package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DoMouseOverAndClickOnLink {

	WebDriver driver;
	
	@Test
	public void enterText(){
		
		// First step set the driver location
		// For Window user
		// System.setProperty("webdriver.chrome.driver", "/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", "/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver");
		
		// Create Object of driver.
		driver = new ChromeDriver();
		
		// Navigate to site
		driver.get("https://www.actitime.com/download");
		WebElement features = driver.findElement(By.xpath("/html/body/header/div/nav/ul/li[2]/a"));
		
		// Create Object of Action Class 
		Actions action = new Actions(driver);
		
		// Move to element for which you want mouse Over
		action.moveToElement(features).build().perform();
		
		// Just sleep for 1 second to make sure mouse over is successful.
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Click on link
		driver.findElement(By.linkText("Work Scope Management")).click();
		
	}
}

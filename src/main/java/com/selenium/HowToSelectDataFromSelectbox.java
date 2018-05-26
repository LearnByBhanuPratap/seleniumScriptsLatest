package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HowToSelectDataFromSelectbox {

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
		driver.get("https://www.facebook.com/");
		
		WebElement day = driver.findElement(By.xpath("//*[@id='day']"));
		
		// To work with select box we need to create object of select class
		Select select = new Select(day);
		select.selectByValue("10");
		
		WebElement month = driver.findElement(By.xpath("//*[@id='month']"));
		select = new Select(month);
		select.selectByIndex(3);
		
		WebElement year = driver.findElement(By.xpath("//*[@id='year']"));
		select = new Select(year);
		select.selectByVisibleText("2016");
		
	}
}

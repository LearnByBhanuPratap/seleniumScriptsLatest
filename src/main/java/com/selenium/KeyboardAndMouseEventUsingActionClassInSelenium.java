package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class KeyboardAndMouseEventUsingActionClassInSelenium {

	// Create instance of web driver
	WebDriver driver;

	@Test
	public void keyboardAndMouseEventUsingActionClassInSelenium() throws InterruptedException {

		// First step set the driver location
		// For Window user
		// System.setProperty("webdriver.chrome.driver","/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver.exe");

		System.setProperty("webdriver.chrome.driver","/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver");

		// Create Object of driver.
		driver = new ChromeDriver();
		driver.get("http://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement text = driver.findElement(By.name("q"));
		Actions action = new Actions(driver);
		Action action1 = action.keyDown(text, Keys.SHIFT)
		.sendKeys("Bhanu Pratap")
		.keyUp(text,Keys.SHIFT).build();
		action1.perform();

	}
}

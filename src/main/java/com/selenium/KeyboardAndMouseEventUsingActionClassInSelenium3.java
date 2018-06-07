package com.selenium;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class KeyboardAndMouseEventUsingActionClassInSelenium3 {

	// Create instance of web driver
	WebDriver driver;

	@Test
	public void keyboardAndMouseEventUsingActionClassInSelenium() throws InterruptedException{

		// First step set the driver location
		// For Window user
		// System.setProperty("webdriver.chrome.driver","/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver.exe");

		System.setProperty("webdriver.chrome.driver","/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver");

		// Create Object of driver.
		driver = new ChromeDriver();
		//Launch the first URL
		driver.get("https://www.seleniumhq.org/");
		WebElement link = driver.findElement(By.xpath("//*[@id='menu_projects']/a"));
		Actions action = new Actions(driver);
		// for mac
		action.keyDown(Keys.COMMAND).keyDown(Keys.SHIFT).click(link).keyUp(Keys.COMMAND).keyUp(Keys.SHIFT).build().perform();
		// for window
		//action.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).click(link).keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).build().perform();
		//Thread.sleep(5000);
	}
}

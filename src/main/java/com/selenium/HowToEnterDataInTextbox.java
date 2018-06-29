package com.selenium;

import java.util.Date;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class HowToEnterDataInTextbox {

	// Create instance of web driver
	WebDriver driver;

	@Test
	public void enterDataInTextField() {

		// First step set the driver location
		// For Window user
		// System.setProperty("webdriver.chrome.driver",
		// "/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver.exe");

		System.setProperty("webdriver.chrome.driver",
				"/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver");

		DesiredCapabilities caps = DesiredCapabilities.chrome();
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.BROWSER, Level.ALL);
		caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
		driver = new ChromeDriver(caps);

		// Navigate to site
		driver.get("https://www.facebook.com/");
		// enter email address
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("test@gmail.com");
		analyzeLog();

	}

	public void analyzeLog() {
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry entry : logEntries) {
			System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
			// do something useful with the data
		}
	}
}

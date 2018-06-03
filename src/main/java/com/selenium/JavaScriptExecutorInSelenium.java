package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaScriptExecutorInSelenium {

	// Create instance of web driver
	WebDriver driver;

	@Test
	public void enterDataInTextField() throws InterruptedException {

		// First step set the driver location
		// For Window user
		// System.setProperty("webdriver.chrome.driver",
		// "/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver.exe");

		System.setProperty("webdriver.chrome.driver",
				"/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver");

		// Create Object of driver.
		driver = new ChromeDriver();

		// Navigate to site
		driver.get("https://www.facebook.com/");
		JavascriptExecutor webdriver = (JavascriptExecutor) driver;
		webdriver.executeScript("document.getElementById('email').setAttribute('value','text@gmail.com')");
		webdriver.executeScript("document.getElementById('pass').setAttribute('value','password')");
		//webdriver.executeScript("arguments[0].click();",driver.findElement(By.xpath("//input[@data-testid='royal_login_button']")));

		// Fetching the Domain Name of the site. Tostring() change object to
		// name.
		String DomainName = webdriver.executeScript("return document.domain;").toString();
		System.out.println("Domain name of the site = " + DomainName);

		// Fetching the URL of the site. Tostring() change object to name
		String url = webdriver.executeScript("return document.URL;").toString();
		System.out.println("URL of the site = " + url);

		// Method document.title fetch the Title name of the site. Tostring()
		// change object to name
		String TitleName = webdriver.executeScript("return document.title;").toString();
		System.out.println("Title of the page = " + TitleName);

		// it will go till the end vertically
		webdriver.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		// it will come up vertically
		webdriver.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		Thread.sleep(3000);
		// it will go till the pixel specified
		webdriver.executeScript("window.scrollBy(0,100)");
		Thread.sleep(3000);
		// it will come back till the pixel specified
		webdriver.executeScript("window.scrollBy(0,-100)");
		Thread.sleep(3000);
		
		webdriver.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//*[@id='reg_pages_msg']/a")));
	    
	}
}

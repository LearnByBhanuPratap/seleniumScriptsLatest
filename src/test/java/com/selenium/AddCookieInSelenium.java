package com.selenium;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AddCookieInSelenium {

	WebDriver driver;
	
	@Test
	public void addCookie()
	{
		// First step set the driver location
		// For Window user
		// System.setProperty("webdriver.chrome.driver", "/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", "/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver");
		// create chrome object	
		driver = new ChromeDriver();
		driver.navigate().to("http://flipkart.com/");
         //we should pass name and value for cookie as parameters
         // In this example we are passing, name=mycookie and value=123456789123
		Cookie name = new Cookie("mycookie", "123456789123");
		driver.manage().addCookie(name);
		
        // After adding the cookie we will check that by displaying all the cookies.
		Set<Cookie> cookiesList =  driver.manage().getCookies();
		for(Cookie getcookies :cookiesList) {
		    System.out.println(getcookies );
		}
	}
}

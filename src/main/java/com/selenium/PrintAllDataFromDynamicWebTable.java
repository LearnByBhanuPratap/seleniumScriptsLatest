package com.selenium;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PrintAllDataFromDynamicWebTable {
	WebDriver driver;
	
	@Test
	public void enterText() throws InterruptedException, ParseException{

		// First step set the driver location
		// For Window user
		// System.setProperty("webdriver.chrome.driver", "/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", "/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver");
		// create driver object
		driver = new ChromeDriver();
		// navigate to site
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		// An implicit wait tells WebDriver to poll the DOM for a certain amount of time when trying to find an element
		// or elements if they are not immediately available.
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// row x path
		String row = "//*[@id='leftcontainer']/table/tbody/tr";
		// get number of rows in table
		int rowData = driver.findElements(By.xpath(row)).size();
		System.out.println(rowData);
		// column x path
		String col = "//*[@id='leftcontainer']/table/tbody/tr[1]/td";
		// get number of columns 
		int colData = driver.findElements(By.xpath(col)).size();
		System.out.println(colData);
		
		String firstPart = "//*[@id='leftcontainer']/table/tbody/tr[";
		String secondPart = "]/td[";
		String thirdPart = "]";
		// run for loop on rows
		for(int i = 1; i<= rowData;i++){
			// for every row run for loop for columns
			for(int j = 1; j<=colData; j++){
				// construct x path based on row and column
				String finalPart = firstPart+i+secondPart+j+thirdPart;
				//System.out.println(finalPart);
				// get text from object
				String text = driver.findElement(By.xpath(finalPart)).getText();
				// print data in console
				System.out.print(text+" | ");
			}
			// add new line after internal for loop to make new line for every row
			System.out.println();
		}
	}
}

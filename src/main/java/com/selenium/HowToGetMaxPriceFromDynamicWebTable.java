package com.selenium;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HowToGetMaxPriceFromDynamicWebTable {
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
		// get total number of rows
		int rowData = driver.findElements(By.xpath(row)).size();
		System.out.println(rowData);
		
		String firstPart = "//*[@id='leftcontainer']/table/tbody/tr[";
		String secondPart = "]/td[4]";
		// create arrayList object
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		for(int i = 1 ; i< rowData; i++){
			// construct x path based on row numbers
			// starting i from 1 since x path index start from 1 not 0
			String finalPart = firstPart+i+secondPart;
			System.out.println(finalPart);
			// get price vale based on x path
			String price = driver.findElement(By.xpath(finalPart)).getText();
			
			//Double dPrice = Double.parseDouble(price);
			//int intPrice = dPrice.intValue();
			
			// create instance of NumberFormat
			NumberFormat numberFormat = NumberFormat.getNumberInstance();
			// parse the price, using NumberFormat object because price has "," e.g "1,234.90"
			// that double will not handle
            Number num = numberFormat.parse(price);
            // convert to String
            price = num.toString();
            System.out.println(price);
            // now parse to double
            Double m = Double.parseDouble(price);
            // get integer value from double
            int intPrice = m.intValue();
            // add into arrayList 
			array.add(intPrice);
		}
		// sort the array to get highest data
		Collections.sort(array);
		// print array just to see the data
		System.out.println(array);
		// get first data from array
		System.out.println(array.get(0));
		// get last data from array list
		// using array.size()-1 since "array.size()" will give total length and index starts from 0 
		// so we have to keep one less
		System.out.println(array.get(array.size()-1));
	}
}

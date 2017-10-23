package com.metacube.testSearchQuery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * The Class SearchQueryTesting.
 * 
 * @author Gaurav Gupta
 */
public class SearchQueryTesting {

	/**
	 * The main method send the data to search bar and search by click on it
	 * then close the page after 3 second.
	 *
	 * @param args    the arguments
	 */
	public static void main(String[] args) {
		try {
			WebDriver driver = new FirefoxDriver();
			driver.get("http://automationpractice.com/index.php");
			Thread.sleep(3000);
			driver.quit();
		} catch (InterruptedException e) {
			System.out.println("Error: " + e);
		}
	}
}
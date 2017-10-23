package com.metacube.testNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Test class to perform automatic testing in Firefox.
 * 
 * @author Gaurav Gupta
 */
public class SignInTesting {
	private WebDriver driver;

	@BeforeTest
	public void setUp() throws InterruptedException {
		driver = new FirefoxDriver();
	}

	@Test (priority = 1)
	public void test1() throws InterruptedException {
		String actualTitle;
		String expectedTitle;

		driver.get("http://automationpractice.com/");
		driver.findElement(By.className("login")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Forgot your password?")).click();

		actualTitle = driver.getTitle();
		expectedTitle = "Forgot your password - My Store";
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@Test (priority = 0)
	public void test2() throws InterruptedException {
		String actualUrl;
		String expectedUrl;

		driver.get("http://automationpractice.com/");
		driver.findElement(By.className("login")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("email_create")).sendKeys("abc4@xyz.com");
		Thread.sleep(2000);
		driver.findElement(By.id("SubmitCreate")).click();

		actualUrl = driver.getCurrentUrl();
		expectedUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
		Assert.assertEquals(expectedUrl, actualUrl);
	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
package com.TestNGDemos;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class D04Before_After_Method {
	WebDriver driver;

	@BeforeTest
	public void launchTheBrowser() {
		System.out.println("Before Test");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
		System.out.println("After Test");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("\tBefore Method");
	}
	
	@AfterMethod
	public void displayTitle()
	{
		System.out.println("\t\tTitle: " + driver.getTitle());
		System.out.println("\tAfter Method");
	}
	

	@Test(priority = 2)
	public void OHRMTest() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}

	@Test(priority = 3)
	public void googleTest() {
		driver.get("https://www.google.com/");
	}

	@Test(priority = 4)
	public void bingTest() {
		driver.get("https://www.bing.com/");
	}

	@Test(priority = 1)
	public void rediffTest() {
		driver.get("https://www.rediff.com/");
	}
}

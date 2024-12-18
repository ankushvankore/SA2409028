package com.MyTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.MyTests.OHRM_Listners.class)
public class D06LoginToOHRM {
	WebDriver driver;
	
	@Test
	public void validLogin() {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("dash"));
	}
	@Test
	public void invalidLogin() {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("manisha");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("manisha123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("dash"));
	}
	@Test
	public void forSkiping()
	{
		throw new SkipException("Skipping this test case!!!");
	}
	@BeforeTest
	public void launchBrowser()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
}

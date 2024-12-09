package com.TestNGDemos;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class D09KeywordDrivenFramework {
	File file;
	FileInputStream fis;
	Properties prop;
	
	WebDriver driver;
	
	@Test
	public void createAccount() {
		driver.findElement(By.cssSelector(prop.getProperty("fullNameCss"))).sendKeys(prop.getProperty("fullName"));
		driver.findElement(By.xpath(prop.getProperty("rediffIdXPath"))).sendKeys("Acharya");
		driver.findElement(By.id(prop.getProperty("passwordId"))).sendKeys("swati123");
		driver.findElement(By.id(prop.getProperty("retypePassId"))).sendKeys("swati123");
	}

	@BeforeTest
	public void beforeTest() throws IOException {
		file = new File("D:\\StarAgile\\Demos\\SA2409028\\SeleniumAutomationProject\\src\\com\\TestNGDemos\\RediffRegistration.properties");
		fis = new FileInputStream(file);
		prop = new Properties();
		prop.load(fis); 			//Load all the properties from .properties file.
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("URL"));
	}

	@AfterTest
	public void afterTest() {
		
	}

}

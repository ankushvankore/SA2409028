package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D05LocateById {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		
		WebElement emailID = driver.findElement(By.id("email"));
		emailID.sendKeys("7878787878");
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys("1234567890");
		WebElement loginBtn = driver.findElement(By.name("login"));
		loginBtn.click();
				
	}

}

package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D06LocateByClass {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.co.in/");
		
		//WebElement searchBox = driver.findElement(By.className("gLFyf"));
		//searchBox.sendKeys("Funny images");
		//searchBox.sendKeys(Keys.ENTER);		//Will hit the enter key
		
		driver.findElement(By.className("gLFyf")).sendKeys("Selenium");
		driver.findElement(By.className("gLFyf")).sendKeys(Keys.ENTER);
		
	}

}

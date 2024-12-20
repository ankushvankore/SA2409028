package com.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A26DemoQA_Registration {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demoqa.com/automation-practice-form");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.findElement(By.id("firstName")).sendKeys("Ankush");
		driver.findElement(By.id("lastName")).sendKeys("Vankore");
		driver.findElement(By.id("userEmail")).sendKeys("ankushvankore@gmail.com");
		
		js.executeScript("arguments[0].click()", driver.findElement(By.id("gender-radio-1")));
		
		WebElement bDate = driver.findElement(By.id("dateOfBirthInput"));
		bDate.sendKeys(Keys.CONTROL + "A");
		bDate.sendKeys("29 Jan 1979");
		
		js.executeScript("window.scrollBy(0, 600)", "");
		
		driver.findElement(By.xpath("//*[@id=\"state\"]/div/div[1]/div[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"react-select-3-option-1\"]")).click();
	}

}

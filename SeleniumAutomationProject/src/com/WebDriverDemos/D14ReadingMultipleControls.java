package com.WebDriverDemos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D14ReadingMultipleControls {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
		
		//List<WebElement>txtBox = driver.findElements(By.cssSelector("input[name^=\"txt\"]"));
		//txtBox.get(0).sendKeys("akshay");
		//txtBox.get(1).sendKeys("akshay123");
		
		driver.findElements(By.cssSelector("input[name^=\"txt\"]")).get(0).sendKeys("akshay");
		driver.findElements(By.cssSelector("input[name^=\"txt\"]")).get(1).sendKeys("akshay123");
	}

}

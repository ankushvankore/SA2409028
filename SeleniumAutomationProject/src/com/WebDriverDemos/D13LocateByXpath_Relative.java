package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D13LocateByXpath_Relative {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("//form[@data-testid=\"royal_login_form\"]/div/div/input")).sendKeys("test@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("1234");
		driver.findElement(By.xpath("//*[@name=\"login\"]")).click();
	}

}

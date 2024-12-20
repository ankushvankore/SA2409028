package com.Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D24DemoQA_Table {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demoqa.com/webtables");
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		
		driver.findElement(By.id("addNewRecordButton")).click();
		
		driver.findElement(By.id("firstName")).sendKeys("Swathi");
		driver.findElement(By.id("lastName")).sendKeys("Acharya");
		driver.findElement(By.id("userEmail")).sendKeys("swathi@gmail.com");
		driver.findElement(By.id("age")).sendKeys("20");
		driver.findElement(By.id("salary")).sendKeys("50000");
		driver.findElement(By.id("department")).sendKeys("Testing");
		driver.findElement(By.id("submit")).submit();
		
		List<WebElement> firstName = driver.findElements(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div/div/div[1]"));
		int i;
		for(i = 0; i < firstName.size(); i++)
		{
			if(firstName.get(i).getText().equals("Kierra"))
			{
				break;
			}	
		}
		System.out.println("Found in row: " + (i+1));
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div["+(i+1)+"]/div/div[7]/div/span[2]")).click();
	}

}

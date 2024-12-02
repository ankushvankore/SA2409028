package com.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A06RedbusDate {

	public static void main(String[] args) throws InterruptedException {
		String expMonth = "Mar", expDay = "10";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.redbus.in/");
		
		//From
		driver.findElement(By.id("src")).sendKeys("Kolh");
		driver.findElement(By.xpath("//*[@id=\"autoSuggestContainer\"]/div/div/div[1]/div/div[1]/ul/li[1]/div/text")).click();
		
		//To
		driver.findElement(By.id("dest")).sendKeys("Ban");
		driver.findElement(By.xpath("//*[@id=\"autoSuggestContainer\"]/div/div/div[3]/div[1]/ul/li[1]/div/text")).click();
		
		//Calender
		driver.findElement(By.xpath("//*[@id=\"onwardCal\"]/div/i")).click();
		
		WebElement month = driver.findElement(By.xpath("//*[@id=\"onwardCal\"]/div/div[2]/div/div/div[1]/div[2]"));
		WebElement nextBtn = driver.findElement(By.xpath("//*[@id=\"onwardCal\"]/div/div[2]/div/div/div[1]/div[3]"));
		
		while(!month.getText().contains(expMonth))
			nextBtn.click();
		
		driver.findElement(By.xpath("//span[contains(text(), "+expDay+")]")).click();
		
		Thread.sleep(5000);
		
		//Search Bus
		driver.findElement(By.id("search_button")).click();
		
		//Display result
		System.out.println(driver.findElement(By.xpath("//*[@id=\"13872137\"]/div/div[1]/div[1]/div[1]/div[1]")).getText());
		
		driver.close();
	}

}

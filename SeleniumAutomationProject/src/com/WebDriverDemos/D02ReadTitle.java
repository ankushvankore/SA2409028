package com.WebDriverDemos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D02ReadTitle {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.selenium.dev/");
		
		String title = driver.getTitle();
		System.out.println("Title: " + title);
		
		if(title.equals("Selenium"))
			System.out.println("Launched correct site\nTest case pass");
		else
			System.out.println("Launched worng web site\nTest case fail");
		
		driver.close();
	}

}

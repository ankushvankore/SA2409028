package com.WebDriverDemos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D03ReadURL {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.selenium.dev/");
		
		String url = driver.getCurrentUrl();
		
		//if(url.equals("https://www.selenium.dev/"))
		if(url.contains("selenium")) {
			System.out.println("Launched correct site\nTest case pass");
			System.out.println("One more statement");
		}
		else
			System.out.println("Launched worng web site\nTest case fail");
		
		driver.close();
	}

}

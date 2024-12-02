package com.WebDriverDemos;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class D31HoveringMouse {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://istqb.in/");
		
		Actions act = new Actions(driver);
		
		WebElement spMenu = driver.findElement(By.linkText("SPECIALIST"));
		act.moveToElement(spMenu).perform();
		
		Thread.sleep(2000);
		
		List<WebElement>subMenus = driver.findElements(By.xpath("//*[@id=\"sp-menu\"]/div/nav/ul/li[6]/div/div/ul/li/a"));
		
		System.out.println("Sub menus from Specialist menu are");
		for(WebElement s : subMenus)
			System.out.println(s.getText());
		
		driver.close();
	}

}

package com.Hooks;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.StepDef.S05AmazonTest.driver;

public class AmazonHooks {
	//@Before
	public void launchBrowser()
	{
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    driver.get("https://www.amazon.in/");
	}
	
	//@After
	public void tearDown()
	{
		driver.close();
	}
}

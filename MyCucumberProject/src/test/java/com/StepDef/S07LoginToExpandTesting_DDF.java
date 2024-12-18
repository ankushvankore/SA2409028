package com.StepDef;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class S07LoginToExpandTesting_DDF {
	WebDriver driver;
	JavascriptExecutor js;
	@Given("Launch ExpandTesting using URL {string}")
	public void launch_expand_testing_using_url(String URL) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(URL);
		
		js = (JavascriptExecutor) driver;
	}

	@When("I Enter username as {string} and password as {string}")
	public void i_enter_username_as_and_password_as(String un, String ps) {
	    driver.findElement(By.id("username")).sendKeys(un);
	    driver.findElement(By.id("password")).sendKeys(ps);
	}

	@When("Click on Login button for verify")
	public void click_on_login_button_for_verify() {
		js.executeScript("window.scrollBy(0, 400)", "");
	    driver.findElement(By.className("btn-primary")).click();
	}

	@Then("Login should successful")
	public void login_should_successful() {
	    Assert.assertTrue(driver.getCurrentUrl().contains("secure"));
	    
	    driver.close();
	}
}

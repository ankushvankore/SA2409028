package com.StepDef;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class S03LoginToOHRM {
	WebDriver driver;
	//Valid data
	
	@Given("Launch Orange HRM")
	public void launch_orange_hrm() {
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@When("I enter valid user name")
	public void i_enter_valid_user_name() {
	    driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("admin");
	}

	@When("I enter valid password")
	public void i_enter_valid_password() {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("admin123");
	}

	@When("I Click on Login button")
	public void i_click_on_login_button() {
	    driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).submit();
	}

	@Then("Dashboard page should display")
	public void dashboard_page_should_display() {
	    Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
	}

	//Invalid data

	@When("I Enter invalid user name")
	public void i_enter_invalid_user_name() {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("priya");
	}

	@When("I Enter invalid password")
	public void i_enter_invalid_password() {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("priya123");
	}


	@When("Click on login button")
	public void click_on_login_button() {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).submit();
	}

	@Then("Error message should display")
	public void error_message_should_display() {
	    System.out.println(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")).getText());
	}
}

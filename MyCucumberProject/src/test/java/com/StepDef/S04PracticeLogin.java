package com.StepDef;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class S04PracticeLogin {
	WebDriver driver;
	@Given("Open Practice Automation page")
	public void open_practice_automation_page() {
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://practicetestautomation.com/practice-test-login/");
	}

	@When("Enter valid userName as {string} and Password as {string}")
	public void enter_valid_user_name_as_and_password_as(String un, String ps) {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(un);
	    driver.findElement(By.xpath("//input[@id='password']")).sendKeys(ps);
	}

	@When("I Will Click on Login button")
	public void i_will_click_on_login_button() {
	    driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
	}

	@Then("Home page should display")
	public void home_page_should_display() {
	    Assert.assertTrue(driver.getCurrentUrl().contains("successfully"));
	}

	@When("Enter invalid userName as {string} and Password as {string}")
	public void enter_invalid_user_name_as_and_password_as(String un, String ps) {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(un);
	    driver.findElement(By.xpath("//input[@id='password']")).sendKeys(ps);
	}

	@Then("Click on Submit button")
	public void click_on_submit_button() {
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
	}

	@Then("I should get Error Message")
	public void i_should_get_error_message() {
		Assert.assertTrue(driver.getCurrentUrl().contains("successfully"));
	}
}

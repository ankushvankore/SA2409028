package com.StepDef;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class S02GoogleSearch {
	WebDriver driver;
	@Given("Open Google Application")
	public void open_google_application() {
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://www.google.com");
	}

	@When("Enter some text in search box")
	public void enter_some_text_in_search_box() {
	    driver.findElement(By.name("q")).sendKeys("Funny Cat Images");
	}

	@When("Hit Enter")
	public void hit_enter() {
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@Then("A valid search result should display")
	public void a_valid_search_result_should_display() {
	    Assert.assertTrue(driver.getTitle().contains("Cat"));
	}
}

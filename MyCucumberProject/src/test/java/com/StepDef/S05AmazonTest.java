package com.StepDef;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class S05AmazonTest {
	public static WebDriver driver;
	
	@Given("Open {string}")
	public void open(String URL) {
	    
	}

	@When("I Click on Sell Link")
	public void i_click_on_sell_link() {
	    driver.findElement(By.linkText("Sell")).click();
	}

	@Then("Sell page should open")
	public void sell_page_should_open() {
		Assert.assertTrue(driver.getTitle().contains("All Categories"));
	    System.out.println(driver.getTitle());
	}

	@When("I Click on Best Sellers Link")
	public void i_click_on_best_sellers_link() {
	    driver.findElement(By.partialLinkText("Best")).click();
	}

	@Then("Best Sellers page should open")
	public void best_sellers_page_should_open() {
		Assert.assertTrue(driver.getTitle().contains("Bestsellers"));
		System.out.println(driver.getTitle());
	}

	@When("I Click on Mobiles Link")
	public void i_click_on_mobiles_link() {
	    driver.findElement(By.linkText("Mobiles")).click();
	}

	@Then("Mobiles page should open")
	public void mobiles_page_should_open() {
		Assert.assertTrue(driver.getTitle().contains("Mobile Phones"));
		System.out.println(driver.getTitle());
	}

	@When("I Click on Electronics Link")
	public void i_click_on_electronics_link() {
	    driver.findElement(By.linkText("Electronics")).click();
	}

	@Then("Electronics page should open")
	public void electronics_page_should_open() {
		Assert.assertTrue(driver.getTitle().contains("Electronic"));
		System.out.println(driver.getTitle());
	}
}

package com.RunnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/MyCucumberProject/MyCucumberProject/F05AmazonTest.feature",
					glue = {"com.StepDef","com.Hooks"},
					publish = true,
					tags = "@AmazonLinks")
public class R05AmazonTest {
	/*
	 * Execute Single Scenario		tags = "@MobilesLink"
	 * Execute Multiple Scenarios	tags = "@MobilesLink or @SellLink"
	 * Skip Single Scenario			tags = "not @ElectronicsLink"
	 * 
	 */

}

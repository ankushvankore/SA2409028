package com.StepDef;


import java.util.List;
import java.util.Map;

import io.cucumber.java.en.*;

public class S06Registration {
	@Given("Launch Registration page")
	public void launch_registration_page() {
		System.out.println("Registration process started!!!");
	}

	@When("I Enter following data")
	public void i_enter_following_data(io.cucumber.datatable.DataTable dataTable) {
		//System.out.println(dataTable);
		List<List<String>>data = dataTable.asLists();
		System.out.println(data);
		
		for(List<String>d : data)
		{
			System.out.println(d);
			for(String s : d)
				System.out.println(s);
		}
	}

	@Then("Registration process should success")
	public void registration_process_should_success() {
		System.out.println("Registration process completed!!!");
	}
	
	@When("Enter the data as follows")
	public void enter_the_data_as_follows(io.cucumber.datatable.DataTable dataTable) {
	    List<Map<String, String>>data = dataTable.asMaps();
	    System.out.println(data);
	}

	@Then("Registration Success")
	public void registration_success() {
	    System.out.println("Registration Completed!!!");
	}
}

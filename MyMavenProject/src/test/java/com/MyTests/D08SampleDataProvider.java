package com.MyTests;

import org.testng.annotations.Test;

public class D08SampleDataProvider {

	@Test(dataProvider = "generateData", dataProviderClass = com.MyTests.MySampleClass.class)
	public void login(String un, String ps) {
		System.out.println(un);
		System.out.println(ps);
	}
}

package com.MyTests;

import org.testng.annotations.DataProvider;

public class MySampleClass {

	@DataProvider
	public String[][] generateData()
	{
		String[][] data = {{"abc", "pqr"}, {"lmn", "POI"}, {"ZXC", "VBN"}};
		return data;
	}
}

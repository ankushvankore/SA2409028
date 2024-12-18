package com.MyTests;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class OHRM_Listners implements ITestListener
{
	public void onStart(ITestContext result)
	{
		System.out.println("Test Started!!!");
	}
	public void onFinish(ITestContext result)
	{
		System.out.println("Test Finished!!!");
	}
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Test FAIL!!!" + result.getName());
	}
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("Test Skipped!!!" + result.getName());
	}
	public void onTestStart(ITestResult result)
	{
		System.out.println("Test case Started!!!");
	}
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Test Passed!!!" + result.getName());
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}
	public void onTestFailedWithTimeout(ITestResult result)
	{
		
	}
}

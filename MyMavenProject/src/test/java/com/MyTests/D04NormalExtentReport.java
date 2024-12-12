package com.MyTests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class D04NormalExtentReport {

	public static void main(String[] args) {
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("MyFirstReport.html");	
		//Represents the report file
		ExtentReports report = new ExtentReports();		
		//Represents the report
		report.attachReporter(htmlReport);
		//Attached the report with report file (html file)
		ExtentTest test;
		//Represents the test cases
		
		//Set environment details
		report.setSystemInfo("Machine Name", "Dell");
		report.setSystemInfo("User Name", "Ankush");
		report.setSystemInfo("Browser", "Google Chrome");
		report.setSystemInfo("OS", "Windows 10");
		report.setSystemInfo("Company", "StarAgile");
		
		//Configuration for look and feel of the report file
		htmlReport.config().setDocumentTitle("My First Extent Report");
		htmlReport.config().setReportName("Trial Report");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setTimeStampFormat("dd-MMMM-yyyy");
		
		//Create A Report
		test = report.createTest("Google Test");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com");
		System.out.println("Title: " + driver.getTitle());
		
		driver.close();
		
		test.log(Status.PASS, MarkupHelper.createLabel("Google Test: Pass", ExtentColor.GREEN));
		
		test = report.createTest("OHRM Test");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("Title: " + driver.getTitle());
		
		driver.close();
		
		test.log(Status.FAIL, MarkupHelper.createLabel("OHRM: Fail", ExtentColor.RED));
		
		report.flush();			//Will generates the report.
	}

}

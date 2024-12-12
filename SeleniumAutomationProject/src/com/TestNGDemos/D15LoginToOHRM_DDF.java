package com.TestNGDemos;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class D15LoginToOHRM_DDF {
	String fPath = System.getProperty("user.dir") + "\\ExcelFiles\\LoginData.xlsx";
	File file;
	FileInputStream fis;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	int i, j, rows, index = 1;
	
	WebDriver driver;
	
	@Test(dataProvider = "getLoginDetails")
	public void loginToOHRM(String un, String ps) {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(ps);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@AfterMethod
	public void logout() throws IOException, InterruptedException {
		Thread.sleep(2000);
		File ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(ss, new File("ScreenShots\\OHRM_SS"+index+".jpeg"));
		row = sheet.getRow(index);
		cell = row.getCell(2);
		if (driver.getCurrentUrl().contains("dashboard")) {
			driver.findElement(By.xpath("//img[@class='oxd-userdropdown-img']")).click();
			driver.findElement(By.linkText("Logout")).click();
			System.out.println("Test case pass");
			cell.setCellValue("Pass");
		}
		else
		{
			System.out.println("Invalid data");
			cell.setCellValue("Fail");
		}
		index++;
	}


	@DataProvider
	public Object[][] getLoginDetails() {
		rows = sheet.getPhysicalNumberOfRows();
		String[][]loginData = new String[rows-1][2];
		
		for(i = 0; i < rows-1; i++)
		{
			row = sheet.getRow(i + 1);
			for(j = 0; j < 2; j++)
			{
				cell = row.getCell(j);
				loginData[i][j] = cell.getStringCellValue();
			}
		}
		
		return loginData;
	}
	@BeforeTest
	public void beforeTest() throws IOException {
		file = new File(fPath);
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(0);
		fos = new FileOutputStream(file);
		//Always configure fos after configuration of sheet
		//especially when you are performing read and write both operations
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@AfterTest
	public void afterTest() throws IOException {
		wb.write(fos);
		wb.close();
		fis.close();
		
		driver.close();
	}

}

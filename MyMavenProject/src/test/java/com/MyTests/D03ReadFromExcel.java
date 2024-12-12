package com.MyTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class D03ReadFromExcel {
	String fPath = "D:/StarAgile/Demos/SA2409028/SeleniumAutomationProject/ExcelFiles/FriendsData.xlsx";
	File file;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	@Test
	public void readData() {
		int rows = sheet.getPhysicalNumberOfRows();
		int cells = sheet.getRow(0).getPhysicalNumberOfCells();
		
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cells; j++)
			{
				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
			}
		}
	}

	@BeforeTest
	public void beforeTest() throws IOException {
		file = new File(fPath);
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(0);
	}

	@AfterTest
	public void afterTest() throws IOException {
		wb.close();
		fis.close();
	}

}

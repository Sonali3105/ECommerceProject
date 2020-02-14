package com.qa.guru.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.guru.Testbase.TestBase;

public class TestUtil extends TestBase {

	public static final long PAGE_LOAD_TIMEOUT = 30;
	
	public static long IMPLICIT_WAIT =20;
	
	public static WebDriver driver;
	
	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet1;
	static JavascriptExecutor js;
	
	public static String sheetPath = "C:\\eclipse_workspace\\Magento\\src\\main"+
					"\\java\\com\\qa\\guru\\TestData\\guru99_registration.xlsx";
	
	public static Object[][] getTestData(String sheetName)
	{
	FileInputStream file= null;
	try
	{
	file= new FileInputStream(sheetPath);	
	}
	catch (FileNotFoundException e)
	{
		e.printStackTrace();
	}
	try 
	{
		book = WorkbookFactory.create(file);
	}
	catch(InvalidFormatException e)
	{
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	sheet1 = book.getSheet(sheetName);
	int rowCount = sheet1.getLastRowNum();
	int colNo = sheet1.getRow(0).getLastCellNum();

	//Two-Dimentional Object Array
	Object[][] data= new Object[rowCount][colNo];
	
	for(int i=0;i<rowCount;i++)
	{       for (int j=0;j<colNo;j++)
			{
			data[i][j] 	= sheet1.getRow(i+1).getCell(j).toString();
			System.out.println(data[i][j]);
			}
	}
return data;
	
	}
	
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	
}

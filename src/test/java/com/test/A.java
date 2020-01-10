package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vignesh Chinnappa\\eclipse-workspace\\Integration\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		WebElement username = driver.findElement(By.id("email"));
		username.sendKeys(getDate(1,0));
		WebElement pass = driver.findElement(By.id("pass"));
		pass.sendKeys(getDate(1,1));
		System.out.println("Success");

}

	private static String getDate(int rowNo, int cellno) throws Throwable {
		String v = null;
		File loc = new File("C:\\Users\\Vignesh Chinnappa\\eclipse-workspace\\Integration\\Testdata\\file_example_XLSX_10.xlsx");
		FileInputStream stream = new FileInputStream(loc);
		Workbook w = new XSSFWorkbook(stream);
		Sheet s = w.getSheet("Sheet1");
		Row r = s.getRow(rowNo);
		Cell c = r.getCell(cellno);
		v = c.getStringCellValue();
		return v;
	
	}
}
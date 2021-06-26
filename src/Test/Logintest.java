package Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Page.Loginpages;

public class Logintest extends Base{
	
	
	/*@Test(priority=0 , description = "Verify User is able to click on login button")
	@Parameters({"username","password"})
	public void test1(String usrnm , String Pass) {
		
		Loginpages loginobj = new Loginpages();
		loginobj.Login(usrnm, Pass);
		
	} */
	
	// ============================Fetching data from excel sheet============================
	
	@Test(priority=1 , description = "Verify User is able to click on login button")
	@Parameters()
	public void test1() {
		
		String usrnm = sheet.getRow(1).getCell(0).getStringCellValue();
		String pass = sheet.getRow(1).getCell(1).getStringCellValue();
		
		Loginpages loginobj = new Loginpages();
		loginobj.Login(usrnm, pass);
		
	}
	
}

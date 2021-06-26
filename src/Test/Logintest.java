package Test;

import java.util.concurrent.TimeUnit;

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

public class Logintest {
	
	public static WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest  test;
	SoftAssert soft = new SoftAssert();
	@BeforeMethod
	public void Setup() {
		
        driver = new ChromeDriver();
		
		driver.get("https://simplilearn.com/");
		 
		//To maximize the browser 
		
		driver.manage().window().maximize();
		
		//To wait for 5 sec in every page
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		reports = new  ExtentReports("ExtentReports.html");
	}
	
	@Test(priority=0 , description = "Verify User is able to click on login button")
	@Parameters({"username","password"})
	public void test1(String usrnm , String Pass) {
		
		Loginpages loginobj = new Loginpages();
		loginobj.Login(usrnm, Pass);
		
	}
	
	
	@AfterMethod
	public void teardown() {
		reports.endTest(test);
		reports.flush();
		
		driver.quit();
		
	}
	
	

}

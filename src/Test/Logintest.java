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

public class Logintest {
	
	WebDriver driver;
	ExtentReports reports;
	ExtentTest  test;
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
		
		test = reports.startTest("Login Test Case");
		
		
		// To click on any tab
		
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		
		LoginLink.click();
		
		test.log(LogStatus.PASS, "Successfully clicked on the login button");

		

		//to enter email / to enter any name in webpage
		
		WebElement UserName = driver.findElement(By.name("user_login"));
		
		UserName.sendKeys(usrnm);
		
		test.log(LogStatus.PASS, "Successfully Entered Username");

		
		// Enter Password
		
		WebElement UserPassword = driver.findElement(By.name("user_pwd"));
		
		UserPassword.sendKeys(Pass);
		
		test.log(LogStatus.PASS, "Successfully Entered Username");

		
		//Click on Remember me check box
		
		WebElement RememberMe =driver.findElement(By.className("rememberMe"));
		RememberMe.click();
		
		test.log(LogStatus.PASS, "Successfully clicked on remember me checkbox");

		
		WebElement LoginName = driver.findElement(By.name("btn_login"));
		LoginName.click();
		
		test.log(LogStatus.PASS, "Successfully clicked on login button");

		
		WebElement Error =driver.findElement(By.id("msg_box"));
		String Actmsg = Error.getText();
		
		String expectmsg = "The email or password you have entered is invali";
		
		Assert.assertTrue(Error.isDisplayed());

		/*try {
			Assert.assertEquals(Actmsg, expectmsg);
			test.log(LogStatus.PASS, "Expected and Actual value matches");
			
		}catch(Throwable e) {
			test.log(LogStatus.FAIL, "Expected and Actual value does not match");
	    } */
		
		

	}
	@AfterMethod
	public void teardown() {
		reports.endTest(test);
		reports.flush();
		
		driver.quit();
		
	}
	
	

}

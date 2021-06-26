package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Test.Logintest;

public class Loginpages {
	
	WebDriver driver;
	ExtentReports reports;
	ExtentTest test;
	
public Loginpages() {
	
	driver = Logintest.driver;
	reports = Logintest.reports;
	test = Logintest.test;
			
	
}
	
	
	

	
public void Login(String usrnm , String Pass) {
		
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
		
		String expectmsg = "The email or password you have entered is invalid.";
		
		Assert.assertTrue(Error.isDisplayed());
		Assert.assertEquals(Actmsg, expectmsg);


}}

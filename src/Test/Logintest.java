package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Logintest {
	
	WebDriver driver;
	@BeforeMethod
	public void Setup() {
		
        driver = new ChromeDriver();
		
		driver.get("https://simplilearn.com/");
		
		//To maximize the browser 
		
		driver.manage().window().maximize();
		
		//To wait for 5 sec in every page
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}
	
	@Test(priority=0 , description = "Verify User is able to click on login button")
	@Parameters({"username","password"})
	public void test1(String usrnm , String Pass) {
		
		
		// To click on any tab
		
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		
		LoginLink.click();
		

		//to enter email / to enter any name in webpage
		
		WebElement UserName = driver.findElement(By.name("user_login"));
		
		UserName.sendKeys(usrnm);
		
		// Enter Password
		
		WebElement UserPassword = driver.findElement(By.name("user_pwd"));
		
		UserPassword.sendKeys(Pass);
		
		//Click on Remember me check box
		
		WebElement RememberMe =driver.findElement(By.className("rememberMe"));
		RememberMe.click();
		
		WebElement LoginName = driver.findElement(By.name("btn_login"));
		LoginName.click();
		
		WebElement Error =driver.findElement(By.id("msg_box"));
		String Actmsg = Error.getText();
		
		String expectmsg = "The email or password you have entered  invalid.";
		
		Assert.assertTrue(Error.isDisplayed());
		Assert.assertEquals(Actmsg , expectmsg);

		
		driver.close();
		
		
		}
	
	

}

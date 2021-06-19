package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Logintest {
	
	@Test(priority=0 , description = "Verify User is able to click on login button")
	public void test1() {
		
       System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://simplilearn.com/");
		
		//To maximize the browser 
		
		driver.manage().window().maximize();
		
		//To wait for 5 sec in every page
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		// To click on any tab
		
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		
		LoginLink.click();
		
		
	}

}

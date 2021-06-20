package Shopping;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

public class NewApplication {
	
	WebDriver driver;

	@BeforeTest
	public void Setup() {
		
        driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		//To maximize the browser 
		
		driver.manage().window().maximize();
		
		//To wait for 5 sec in every page
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		//reports = new  ExtentReports("ExtentReports.html");
	}
	@Test(priority =0 , description ="verify user is able to login")
	public void Logintest() {
		
		WebElement username = driver.findElement(By.xpath("//*[@name='user-name']"));
	    username.sendKeys("standard_user");
	    
	    WebElement password = driver.findElement(By.xpath("//*[@name='password']"));
	    password.sendKeys("secret_sauce");
	    
	    WebElement login = driver.findElement(By.xpath("//*[@id='login-button']"));
	    login.click();
	    
		}
	@Test(priority =1 , description = "Verify user is able to select item to cart" ,dependsOnMethods = "Logintest")
	public void selectcart() {
		
		/*WebElement username = driver.findElement(By.xpath("//*[@name='user-name']"));
	    username.sendKeys("standard_user");
	    
	    WebElement password = driver.findElement(By.xpath("//*[@name='password']"));
	    password.sendKeys("secret_sauce");
	    
	    WebElement login = driver.findElement(By.xpath("//*[@id='login-button']"));
	    login.click(); */
		
		WebElement select = driver.findElement(By.xpath("//*[@name='add-to-cart-sauce-labs-backpack']"));
		select.click();
		
		
		
		
	}
	@Test(priority = 3 , description ="verify user is able to clcik on cart", dependsOnMethods = "selectcart")
	public void Opencart() {
		
		/*WebElement username = driver.findElement(By.xpath("//*[@name='user-name']"));
	    username.sendKeys("standard_user");
	    
	    WebElement password = driver.findElement(By.xpath("//*[@name='password']"));
	    password.sendKeys("secret_sauce");
	    
	    WebElement login = driver.findElement(By.xpath("//*[@id='login-button']"));
	    login.click();
		
		WebElement select = driver.findElement(By.xpath("//*[@name='add-to-cart-sauce-labs-backpack']"));
		select.click(); */
		
		WebElement cart = driver.findElement(By.className("shopping_cart_link"));
		cart.click();
		
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	

}

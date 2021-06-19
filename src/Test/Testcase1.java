package Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testcase1 {
	
	@BeforeTest
	public void BeforeTestMethod() {
		System.out.println("Before Test");
	}
	
	@BeforeMethod
	public void setup() {
		System.out.println("Before Test");
	}
	
	@Test(groups= {"Sanity"})
	public void Login() {
		
		System.out.println("TEst case 1");
	}
	
	
		
	@Test(groups= {"Regression"})
	public void Signup() {
			
			System.out.println("TEst case 1");
		}
	
	@AfterMethod
	public void setup2() {
		System.out.println("after Test");
	}
	
	@AfterTest
	public void AftreTestMethod() {
		System.out.println("After Test");
	}


}

package Test;

//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testcase2 {
	
	
	
	@Test(priority=3 ,groups= {"Sanity"},description= "Homepage 2 Test ")
	public void HomePage1() {
		
		System.out.println("HomePage2");
	} 
	
	@Test(priority=0, description= "Homepage 1 Test ",dependsOnMethods = "HomePage1")
	public void HomePage2() {
		
		System.out.println("HomePage1");
	}
	
	@Test(priority=1,description= "Homepage 3 Test ")
	public void HomePage3() {
		
		System.out.println("HomePage3");
	}
	
	@Test(priority=2,description= "Homepage 4 Test ")
	public void HomePage4() {
		
		System.out.println("HomePage4");
	}

}

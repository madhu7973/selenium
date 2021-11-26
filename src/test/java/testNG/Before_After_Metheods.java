package testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Before_After_Metheods {

	/*
	 * @BeforeMethod - always runs just before each @Test methods defined inside the
	 * same class.
	 * 
	 * @AfterMethod - always runs just after the completion of each test methods
	 * defined in the same class.
	 */

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method");
	}

	@Test
	public void testMethod1() {
		System.out.println("test method1");
	}

	@Test
	public void testMethod2() {
		System.out.println("test method2");
	}

	@AfterMethod
	public void afterMethid() {
		System.out.println("after method");
	}
	
	@Test
	public void testMethod3()
	{
		System.out.println("test method3");
	}
}

package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Befores_Afters {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite");
	}

//	@BeforeGroups
//	public void beforeGroups() {
//		System.out.println("before groups");
//	}
//
//	@AfterGroups
//	public void afterGroups() {
//		System.out.println("after groups");
//	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("before class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("after class");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("before test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("after test");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("after method");
	}

	@Test
	public void testMethod() {
		System.out.println("test method");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite");
	}
}

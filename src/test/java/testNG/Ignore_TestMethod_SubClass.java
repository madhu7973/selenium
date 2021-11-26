package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ignore_TestMethod_SubClass  {

	public static WebDriver driver;
	SoftAssert soft = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test(priority = 1, alwaysRun = true, enabled = true)
	public void facebookLogin() {
		System.out.println("Ignore_TestMethod_SubClass - facebook login method - p1");
		driver.get("https://www.facebook.com/");
		soft.assertEquals(driver.getTitle(), "Facebook – log in or sign up");
		soft.assertAll();
	}

	@Test(priority = 2)
	public void walmartLogin() {
		System.out.println("Ignore_TestMethod_SubClass - walmart login method - p2");
		driver.get("https://www.walmart.com/account/login");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(driver.getTitle(), "Login");
		soft.assertAll();
	}

	@Ignore
	@Test(priority = 3)
	public void instaLogin() {
		System.out.println("Ignore_TestMethod_SubClass - insta login method - p3");
		driver.get("https://www.instagram.com/accounts/login/");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(driver.getTitle(), "Login • Instagram");
		soft.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}

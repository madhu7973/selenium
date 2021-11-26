package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelMethodsExecution {

//	@BeforeMethod
//	public void setUp() {
//		WebDriverManager.chromedriver().setup();	
//	}

	@Test(priority = 1)
	public void facebookLogin() throws InterruptedException {
		System.out.println("ParallelMethodsExecution - facebook login method - p1");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(driver.getTitle(), "Facebook – log in or sign up");
		Thread.sleep(1000);
		driver.close();
		soft.assertAll();
	}

	@Test(priority = 2)
	public void walmartLogin() throws InterruptedException {
		System.out.println("ParallelMethodsExecution - walmart login method - p2");
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.walmart.com/account/login");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(driver.getTitle(), "Login");
		Thread.sleep(1000);
		driver.close();
		soft.assertAll();
	}

	@Test(priority = 3)
	public void instaLogin() throws InterruptedException {
		System.out.println("ParallelMethodsExecution - insta login method - p3");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.instagram.com/accounts/login/");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(driver.getTitle(), "Login • Instagram");
		Thread.sleep(1000);
		driver.close();
		soft.assertAll();
	}

//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}

}

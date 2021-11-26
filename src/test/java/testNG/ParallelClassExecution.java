package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelClassExecution {

//	@BeforeMethod
//	public void setUp() {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//	}

	@Test(priority = 1)
	public void oracleLogin() throws InterruptedException {
		System.out.println("ParallelClassExecution - oracle login method - p1");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.oracle.com/oaam_server/login.do");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(driver.getTitle(), "Sign On");
		Thread.sleep(1000);
		driver.close();
		soft.assertAll();
	}

	@Test(priority = 2)
	public void naukriLogin() throws InterruptedException {
		System.out.println("ParallelClassExecution - naukri login method - p2");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/nlogin/login");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(driver.getTitle(),
				"Jobseeker's Login: Search the Best Jobs available in India & Abroad - Naukri.com");
		Thread.sleep(1000);
		driver.close();
		soft.assertAll();
	}

	@Test(priority = 3)
	public void SFLogin() throws InterruptedException {
		System.out.println("ParallelClassExecution - stack overflow login method - p3");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://stackoverflow.com/users/login");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(driver.getTitle(), "Log In - Stack Overflow");
		Thread.sleep(1000);
		driver.close();
		soft.assertAll();
	}

//	@AfterMethod
//	public void tearDown() {
//		driver.close();
//	}
}

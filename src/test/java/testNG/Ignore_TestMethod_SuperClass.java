package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

@Ignore
public class Ignore_TestMethod_SuperClass {

	public static WebDriver driver;
	SoftAssert soft = new SoftAssert();

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Ignore
	@Test(priority = 1, alwaysRun = true, enabled = true)
	public void oracleLogin() {
		System.out.println("Ignore_TestMethod_SuperClass - oracle login method - p1");
		driver.get("https://login.oracle.com/oaam_server/login.do");
		soft.assertEquals(driver.getTitle(), "Sign On");
		soft.assertAll();
	}

	@Test(priority = 2)
	public void naukriLogin() {
		System.out.println("Ignore_TestMethod_SuperClass - naukri login method - p2");
		driver.get("https://www.naukri.com/nlogin/login");
		soft.assertEquals(driver.getTitle(),
				"Jobseeker's Login: Search the Best Jobs available in India & Abroad - Naukri.com");
		soft.assertAll();
	}

	@Test(priority = 3)
	public void SFLogin() {
		System.out.println("Ignore_TestMethod_SuperClass - stack overflow login method - p3");
		driver.get("https://stackoverflow.com/users/login");
		soft.assertEquals(driver.getTitle(), "Log In - Stack Overflow");
		soft.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}

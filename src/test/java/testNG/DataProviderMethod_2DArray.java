package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners(Eventlistner.class)
public class DataProviderMethod_2DArray {

	public static WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.walmart.com/account/signup");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@DataProvider
	public Object[][] getData() {
//		Object[][] testData = new Object[3][4];
//
//		testData[0][0] = "madhu1";
//		testData[0][1] = "sudan1";
//		testData[0][2] = "test@test.com";
//		testData[0][3] = "1234";
//		testData[1][0] = "madhu2";
//		testData[1][1] = "sudan2";
//		testData[1][2] = "test@test.com";
//		testData[1][3] = "1234";
//		testData[2][0] = "madhu3";
//		testData[2][1] = "sudan3";
//		testData[2][2] = "test@test.com";
//		testData[2][3] = "1234";

		Object[][] testData = { { "madhu1", "sudan1", "test@test.com", "1234" },
				{ "madhu2", "sudan2", "test@test.com", "1234" },{ "madhu3", "sudan3", "test@test.com", "1234" } };

		return testData;

	}

	@Test(dataProvider = "getData")
	public void Signup(String fname, String lname, String email, String pwd) {
		driver.findElement(By.id("first-name-su1")).sendKeys(fname);
		driver.findElement(By.id("last-name-su")).sendKeys(lname);
		driver.findElement(By.id("email-su")).sendKeys(email);
		driver.findElement(By.id("password-su")).sendKeys(pwd);
//		Assert.assertTrue(false);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}

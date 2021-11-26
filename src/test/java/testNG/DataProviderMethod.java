package testNG;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderMethod {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.walmart.com/account/signup");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	/*
	 * Data provider stores the test data in a two dimensional array and returns the
	 * same
	 */

	@DataProvider(name = "getTestData")
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		Object[][] userInfo = DataProviderUtility_ExceL.testData("SignUp");
		return userInfo;
	}

	/*
	 * Method which uses the data provider must declare the parameters in the same
	 * order in which test data is declared. I.e., one-to-one mapped other wise it
	 * leads to error.
	 * 
	 */
	@Test(dataProvider = "getTestData")
	public void Signup(String fname, String lname, String email, String pwd) {
		driver.findElement(By.id("first-name-su")).sendKeys(fname);
		driver.findElement(By.id("last-name-su")).sendKeys(lname);
		driver.findElement(By.id("email-su")).sendKeys(email);
		driver.findElement(By.id("password-su")).sendKeys(pwd);
		driver.findElement(By.xpath("(//button[@data-automation-id='signup-submit-btn'])[1]")).click();
	}

	@AfterMethod
	public void tearDown()

	{
		driver.close();
	}
}

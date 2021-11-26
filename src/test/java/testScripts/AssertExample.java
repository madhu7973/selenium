package testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertExample 
{
	WebDriver driver;

	SoftAssert soft = new SoftAssert();
	
	@BeforeMethod
	public void openBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/login");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void errorMessage()
	{
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("username");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("password");
		driver.findElement(By.xpath("//button[@id='loginbutton']")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		SoftAssert soft = new SoftAssert();
		Boolean errorDiv = driver.findElement(By.xpath("//div[@id='error_box']")).isDisplayed();
		if (errorDiv)
		{
			System.out.println("error msg displayed");
			String str = driver.findElement(By.xpath("//div[@id='error_box']")).getText();
			System.out.println("erro mesage displayed is: "+ str );
		}
		else System.out.println("error message not displayed");
		soft.assertAll();
	}

	/*@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}*/
}

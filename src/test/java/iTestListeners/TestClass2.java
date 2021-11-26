package iTestListeners;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass2 extends TestClass 
{

	@BeforeMethod
	public void openBrowser2()
	{
//		System.setProperty("webdriver.chrome.driver", "src\\BrowserDrivers\\chromedriver.exe");
//		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@Test
	public void login()
	{
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("username");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		if (driver.findElement(By.xpath("//div[@id='eerror']")).isDisplayed())//wrong xpath
			System.out.println("error message displayed");
		else System.out.println("error message not displayed");
	}
	
	@AfterMethod
	public void closeBrowser2()
	{
		driver.quit();
	}

}
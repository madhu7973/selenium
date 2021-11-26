package testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RediffLogin 
{
	WebDriver driver;
	@BeforeMethod
	public void OpenBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.rediff.com/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@Test
	public void Login()
	{
		driver.findElement(By.xpath("//a[contains (@title,'Sign in')]")).click();
		driver.findElement(By.cssSelector("#login1")).sendKeys("username");
		//the above locator can also be found using below css locator using regular expression.
		// //input[contains (@id, 'log')]
		
	}
	
	@AfterMethod
	public void cloceBrowser()
	{
		driver.quit();
	}

}

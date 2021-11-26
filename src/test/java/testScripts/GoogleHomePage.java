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

public class GoogleHomePage 
{
	WebDriver driver;
	@BeforeMethod
	public void openBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void searchBox()
	{
		driver.findElement(By.xpath("//div[@class = 'sbib_b']/div/input[1]")).sendKeys("Madhusudan");
		driver.findElement(By.xpath("//a[@class = 'gb_P' and  @data-pid= '23']")).click();
	}

	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}

}

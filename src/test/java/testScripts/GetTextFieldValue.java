package testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTextFieldValue 
{
	WebDriver driver;
	
	@BeforeMethod
	public void openBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/login/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@Test
	public void getText() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys("Username field");
		Thread.sleep(3000);
		String x = driver.findElement(By.xpath("//input[@id = 'email']")).getAttribute("vaue");
		System.out.println(x);
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}

}

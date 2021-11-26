package testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBookLogin 
{
	WebDriver driver;
	
	@BeforeMethod
	public void openBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/login/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@Test
	public void xpath()
	{
		driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("username");
		driver.findElement(By.xpath("//input[@name = 'pass']")).sendKeys("Password");
		driver.findElement(By.xpath("//button[@name = 'login']")).click();
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}

}

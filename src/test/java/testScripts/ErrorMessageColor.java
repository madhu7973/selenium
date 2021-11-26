package testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorMessageColor 
{
	WebDriver driver;
	@BeforeMethod
	public void openBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
	}
	
	@Test
	public void errorMessage()
	{
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("aaaaa");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String s = driver.findElement(By.xpath("//div[@id='error']")).getCssValue("color");
		System.out.println(s);
		String c = Color.fromString(s).asHex();
		System.out.println(c);
		if (c.equals("#c23934"))
			System.out.println("color is red");
		else System.out.println("color is not red");
	}
	
	@AfterMethod
	public void closeBrowser() 
	{
		driver.quit();
	}

}
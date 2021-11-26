package testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickUsingJS 
{
	WebDriver driver;

	@BeforeMethod
	public void openBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/login/");
	}

	@Test
	public void click() throws InterruptedException
	{
		WebElement button = driver.findElement(By.xpath("//button[@id = 'loginbutton']"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click()", button);
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", button);
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}

}
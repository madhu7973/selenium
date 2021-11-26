package scrolling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollUsingscrollIntoViewFunction
{
	WebDriver driver;
	@BeforeMethod
	public void openBrowser()
	{
		//System.setProperty("webdriver.chrome.driver", "D:\\BrowserExecutables\\chromedriver-2.45.exe");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@Test
	public void scroll() throws InterruptedException
	{
		WebElement element = driver.findElement(By.xpath("//span[@id='Today.27s_featured_picture']"));
		Thread.sleep(3000);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void closeBrowser() 
	{
		driver.quit();
	}

}

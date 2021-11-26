package scrolling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollPageByPixel {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setEnvi()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.wikipedia.org/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void scrollByPixel() throws InterruptedException
	{
		Thread.sleep(1500);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		boolean wb = driver.findElement(By.xpath("//span[text() = 'Wikibooks']")).isDisplayed();
		System.out.println(wb);
		
		//((JavascriptExecutor)driver).executeAsyncScript("window.scrollBy(0,686)");
	}
	
	@AfterMethod
	public void closeEnvi()
	{
		driver.close();
	}

}

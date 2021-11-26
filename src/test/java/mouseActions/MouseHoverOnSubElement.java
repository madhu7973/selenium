package mouseActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHoverOnSubElement {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setEnvi()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void hoverOnSubElement() throws InterruptedException
	{
		WebElement main_element = driver.findElement(By.xpath("//span[text()='Hello, Sign in']"));
		WebElement sub_element = driver.findElement(By.cssSelector("span.nav-action-inner"));
		
		Actions act = new Actions(driver);
		Thread.sleep(1500);
		act.moveToElement(main_element).moveToElement(sub_element).click().perform();
		Thread.sleep(1500);
//		act.moveToElement(main_element).moveToElement(sub_element).click().build().perform();
//		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void closeEnvi()
	{
		driver.close();
	}

}

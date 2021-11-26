package mouseActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BsicMouseActions {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setupEnvi()
	{
		WebDriverManager.chromedriver().setup();
		driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void mouseActions() throws InterruptedException
	{
		WebElement searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		Actions actions = new Actions(driver);
		Thread.sleep(1500);
		actions.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("mobiles ").keyUp(Keys.SHIFT).sendKeys("asus")
		.doubleClick().build().perform();
		Thread.sleep(3000);
		
		WebElement langSelector = driver.findElement(By.cssSelector(".icp-nav-link-inner"));
		actions.moveToElement(langSelector).contextClick().build().perform();
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}

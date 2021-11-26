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

public class MouseHoverOnMainElement {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setEnvi()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void hoverOnMainElement() throws InterruptedException
	{
		WebElement element = driver.findElement(By.xpath("//span[text()='Departments']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		Thread.sleep(1500);
		act.moveToElement(element).click().perform();
		Thread.sleep(3000);
		String aTitle = driver.getTitle();
		String eTitle = "Amazon.com - Earth's Biggest Selection";
		
		if(aTitle.equalsIgnoreCase(eTitle))
			System.out.println("Navigated to departments page");
		
	}
	
	@AfterMethod
	public void closeEnvi()
	{
		driver.close();
	}

}

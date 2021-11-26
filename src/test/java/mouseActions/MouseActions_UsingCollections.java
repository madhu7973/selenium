package mouseActions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseActions_UsingCollections 
{

	WebDriver driver;
	@BeforeMethod
	public void setEnvi()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/?locale=in");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void links() throws InterruptedException 
	{
		List <WebElement> link = driver.findElements(By.xpath("//div[@id = 'main']//a"));
		int linkCount = link.size();
		System.out.println(linkCount);

		for (int i = 0; i < linkCount; i++)
		{
			WebElement element = link.get(i);
			String s  = element.getAttribute("text");
			boolean status = element.isEnabled();
			System.out.println("Link name is "+ s +"and status is " + status );

			if (s.equals("Try for Free"))
			{
				element.click();
				break;
			}
		}

	}

	@AfterMethod
	public void closeEnvi()
	{
		driver.quit();
	}

}

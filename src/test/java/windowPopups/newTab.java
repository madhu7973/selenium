package windowPopups;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class newTab 
{
	WebDriver driver;

	@BeforeMethod
	public void openEnvi()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.qaclickacademy.com/practice.php");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	@Test
	public void voidClickFooterLinks() throws InterruptedException
	{
		List<WebElement> footerLinks = driver.findElements(By.xpath("(//table[@class='gf-t']//td)[1]//li[@class='gf-li']/a"));
		int linksNumber = footerLinks.size();

		for (int i=0; i<linksNumber; i++)
		{
			String openNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			footerLinks.get(i).sendKeys(openNewTab);
			Thread.sleep(1500);
		}
		
		Set <String> winHandles = driver.getWindowHandles();
		Iterator<String> it = winHandles.iterator();
		while (it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

	}

	@AfterMethod
	public void closeEnvi()
	{
		driver.quit();
	}

}
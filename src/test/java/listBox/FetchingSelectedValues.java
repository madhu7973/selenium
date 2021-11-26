package listBox;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FetchingSelectedValues 
{
	WebDriver driver;
	@BeforeMethod
	public void setEnvi()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumDependencies\\BrowserExecutables\\chromedriver-2.41.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test (priority=1)
	public void FSV_BefroreSelection()
	{
		System.out.println("===========Before Selection==========");
		WebElement element = driver.findElement(By.xpath("//select[@id='day']"));
		Select select = new Select (element);
		WebElement option = select.getFirstSelectedOption();
		System.out.println(option.getText());
	}

	@Test (priority=2)
	public void FSV_AfterSelection()
	{
		System.out.println("===========After Selection==========");
		WebElement element1 = driver.findElement(By.xpath("//select[@id='day']"));
		Select select1 = new Select (element1);
		select1.selectByVisibleText("13");
		WebElement option1 = select1.getFirstSelectedOption();
		System.out.println(option1.getText());
	}

	@AfterMethod
	public void closeEnvi()
	{
		driver.quit();
	}
}
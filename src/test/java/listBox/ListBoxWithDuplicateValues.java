package listBox;

import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ListBoxWithDuplicateValues 
{
	WebDriver driver;
	@BeforeMethod
	public void setEnvi()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumDependencies\\BrowserExecutables\\chromedriver-2.41.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///E:/ListBox.html");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@Test
	public void duplicate()
	{
		WebElement element = driver.findElement(By.xpath("//select[@id='sel1']"));
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		TreeSet<String> ts = new TreeSet<String>();
		for(int i=0; i<options.size(); i++)
		{
			String optionName = options.get(i).getText();
			ts.add(optionName);
		}
		
		for (String s: ts)
			System.err.println(s);
	}
	
	@AfterMethod
	public void CloseEnvi()
	{
		driver.close();
	}

}

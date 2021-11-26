package listBox;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PrintingOnlyDuplicates 
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
	public void POPD()
	{
		WebElement element = driver.findElement(By.xpath("//select[@id='sel1']"));
		Select select = new  Select(element);
		List<WebElement> options = select.getOptions();

		ArrayList <String> list = new ArrayList<String>();
		for(int i =0; i<options.size(); i++)
		{
			String optionName = options.get(i).getText();
			list.add(optionName);
		}
//		list.add(driver.findElement(By.xpath("//option[@value='0']")).getText());
//		list.add(driver.findElement(By.xpath("//option[@value='1']")).getText());
//		list.add(driver.findElement(By.xpath("//option[@value='2']")).getText());
//		list.add(driver.findElement(By.xpath("//option[@value='3']")).getText());
//		list.add(driver.findElement(By.xpath("//option[@value='4']")).getText());
//		list.add(driver.findElement(By.xpath("//option[@value='5']")).getText());

		Set <String> set = new HashSet<String>();

		for (String s: list)
		{
			//***set do not allow to add duplicate elements. If the elements are not added
			//then add method returns false
			if(set.add(s)==false)
				System.out.println(s);
		}

	}

	@AfterMethod
	public void CloseEnvi()
	{
		driver.close();
	}

}

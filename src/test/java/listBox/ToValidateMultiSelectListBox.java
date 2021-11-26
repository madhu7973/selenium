package listBox;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToValidateMultiSelectListBox 
{
	WebDriver driver;
	@BeforeMethod
	public void setEnvi()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///E:/ListBox.html");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void MSB() throws InterruptedException
	{
		WebElement element = driver.findElement(By.xpath("//select[@id='sel1']"));
		Select select = new Select(element);
		List <WebElement> list = select.getOptions();

		if(select.isMultiple())
		{
			System.out.println("list box is multiselect");
			for (int i=0; i<list.size(); i++)
			{
				System.out.println(list.get(i).getText());
				Thread.sleep(500);
			}

		}

		else System.out.println("list box is multi select");
	}

	@AfterMethod
	public void CloseEnvi()
	{
		driver.close();
	}

}
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

public class SelectingValues {
	WebDriver driver;

	@BeforeMethod
	public void setEnvi() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\SeleniumDependencies\\BrowserExecutables\\chromedriver-2.41.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void FBLB_SelectingDay() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//select[@id='day']"));
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++)
			System.out.println(options.get(i).getText());
		select.selectByVisibleText("13");
		Thread.sleep(2000);
	}

	@Test
	public void FBLB_SelectingMonth() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//select[@id='month']"));
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		System.out.println(options.size());
		for (int i = 0; i < options.size(); i++)
			System.out.println(options.get(i).getText());
		select.selectByValue("5");
		Thread.sleep(2000);
	}

	@Test
	public void FBLB_SelectingYear() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//select[@id='year']"));
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		System.out.println(options.size());
		for (int i = 0; i < options.size(); i++)
			System.out.println(options.get(i).getText());
		select.selectByIndex(28);
		Thread.sleep(2000);
	}

	@AfterMethod
	public void closeEnvi() {
		driver.close();
	}

}

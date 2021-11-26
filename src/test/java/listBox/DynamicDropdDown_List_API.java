package listBox;

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

public class DynamicDropdDown_List_API {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.walmart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void dynamicDropDown() throws InterruptedException {

		// Located the search box
		WebElement searchBox = driver.findElement(By.cssSelector("div #global-search-input"));
		searchBox.click();
		searchBox.sendKeys("mobile");
		Thread.sleep(2000);

		// Locates the search options flyout, collects all the options and stores it in
		// a List
		List<WebElement> options = driver.findElements(By.xpath("//ul[@id='global-search-dropdown']//li//div"));

		for (int i = 0; i < options.size(); i++) {
			System.out.println(options.get(i).getText());

			// Provide the required options to select in the condition statement
			if (options.get(i).getText().equalsIgnoreCase("mobile hotspot")) {
				options.get(i).click();
				Thread.sleep(2000);
				break;
			}
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

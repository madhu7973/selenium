package listBox;

import java.util.List;
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

public class AutoSuggestiveListBox {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.walmart.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void autoSuggestiveListBox() throws InterruptedException {

		WebElement searchField = driver.findElement(By.name("query"));
//		fromField.clear();
		searchField.sendKeys("shirt");

		for (int i = 0; i <= 3; i++) {
			searchField.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000);
		}

		searchField.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.name("query")).getAttribute("value"));
		
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}

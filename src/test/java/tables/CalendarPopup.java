package tables;

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

public class CalendarPopup {
	WebDriver driver;

	@BeforeMethod
	public void setEnvi() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumhq.org/download/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void Tables() {
		// Below are the total number of tables, rows and columns in the page
		List<WebElement> tables = driver.findElements(By.xpath("//table"));
		System.out.println("Toatal tables in the page are " + tables.size());

		List<WebElement> rows = driver.findElements(By.xpath("//table//tr"));
		System.out.println("Toatal rows in the page are " + rows.size());

		List<WebElement> columns = driver.findElements(By.xpath("//table//th"));
		System.out.println("Toatal columns in the page are " + columns.size());

		List<WebElement> cells = driver.findElements(By.xpath("//table//th|//table//td"));
		System.out.println("Toatal columns in the page are " + cells.size());

		System.out.println("----------------------------------------------------");

		// Below are the total number of tables, rows and columns in the page's first
		// table
		List<WebElement> tables1 = driver.findElements(By.xpath("(//table)[1]"));
		System.out.println("Toatal tables in the first table are " + tables1.size());

		List<WebElement> rows1 = driver.findElements(By.xpath("(//table)[1]//tr"));
		System.out.println("Toatal tables in the first table are " + rows1.size());

		List<WebElement> columns1 = driver.findElements(By.xpath("(//table)[1]//th"));
		System.out.println("Toatal tables in the first table are " + columns1.size());

		List<WebElement> cells1 = driver.findElements(By.xpath("(//table)[1]//th|(//table)[1]//td"));
		System.out.println("Toatal tables in the first table are " + cells1.size());

		System.out.println("=====================================================");

		for (int i = 0; i < cells1.size(); i++) {
			String text = cells1.get(i).getText();
			System.out.println(text);
		}

	}

	@AfterMethod
	public void closeEnvi() {
		driver.quit();
	}

}

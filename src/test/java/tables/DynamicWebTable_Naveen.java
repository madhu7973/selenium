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

public class DynamicWebTable_Naveen {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void dynamicWebTables() {

		// xpaths pattern
		//*[@id="customers"]/tbody/tr[6]/td[1]

		String before_row_xpath = "//*[@id=\"customers\"]/tbody/tr[";
		String after_row_xpath = "]/td[1]";
		List<WebElement> trs = driver.findElements(By.xpath("//table[@id='customers']//tr"));

		// Printing the data in the first column
		for (int i = 2; i < trs.size(); i++) {
			String xpath = before_row_xpath + i + after_row_xpath;
			// System.out.println(driver.findElement(By.xpath(xpath)).getText());
			if (driver.findElement(By.xpath(xpath)).getText().equalsIgnoreCase("Ernst Handel")) {
				System.out.println("Ersnts company found at position : " + i);
				break;
			}
		}

		// xpaths patters
		//*[@id="customers"]/tbody/tr[1]/th[2]
		//*[@id="customers"]/tbody/tr[1]/th[3]
		//*[@id="customers"]/tbody/tr[1]/th[1]

		String bfore_column_xpath = "//*[@id=\"customers\"]/tbody/tr[1]/th[";
		String after_column_xpath = "]";
		List<WebElement> ths = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr[1]/th"));
		System.out.println("*****Columns*****");
		for (int i = 1; i < ths.size() + 1; i++)
			System.out.println(driver.findElement(By.xpath(bfore_column_xpath + i + after_column_xpath)).getText());

	}

	@AfterMethod
	public void closeEnvi() {
		driver.quit();
	}

}

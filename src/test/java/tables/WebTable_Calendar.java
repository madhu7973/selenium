package tables;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable_Calendar {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void calendar() {

		driver.findElement(By.xpath("//i[@class='glyphicon glyphicon-th']")).click();

		// Counting number of rows
		List<WebElement> rows = driver.findElements(By.xpath("(//table[@class='table-condensed'])[1]//tbody//tr"));
		System.out.println("Total rows : " + rows.size());

		// Counting the number of columns
		// Here just count the columns of the first row.

		List<WebElement> columns = driver
				.findElements(By.xpath("((//table[@class='table-condensed'])[1]//tbody//tr)[1]//td"));
		System.out.println("Total columns : " + columns.size());

		List<WebElement> cells = driver.findElements(By.xpath("(//table[@class='table-condensed'])[1]//tbody//tr//td"));
		System.out.println("Total cells : " + cells.size());

		int sum = 0;

		for (int i = 0; i < cells.size(); i++) {
			System.out.println(i + " : " + cells.get(i).getText());
			String cellNumStr = cells.get(i).getText();
			int cellNumInt = Integer.parseInt(cellNumStr);
			sum = sum + cellNumInt;
		}

		System.out.println(sum);
	}

	@AfterMethod
	public void closeEnvi() {
		driver.quit();
	}

}

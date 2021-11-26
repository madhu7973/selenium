package popups;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HiddenDivisionPopup {
	public static String mon = "Jun";
	WebDriver driver;

	@BeforeMethod
	public void setupEnvi() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("https://tinyurl.com/y9wbguuj");

		driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

//	@Test
//	public void HDP() throws InterruptedException {
//
//		WebElement element = driver.findElement(By.xpath("(//span[@class='near'])[1]"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//		Thread.sleep(1000);
//
//		driver.findElement(By.xpath("(//div[(contains(@class, 'heading-refinement') )])[1]")).click();
//		Thread.sleep(1000);
//
//		driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[1]")).click();
//		Thread.sleep(1000);
//
//		// Selects all the date boxes in the calendar popup
//		List<WebElement> dates = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));
//		System.out.println(dates.size());
//
//		// getting the system date
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd");
//		LocalDate localDate = LocalDate.now();
//		String dd = (dtf.format(localDate));
//
//		// iterating the dates
//		for (int i = 0; i < dates.size(); i++) {
//
//			// getting the dates form the date picker of application
//			String arcdate = dates.get(i).getText();
//			System.out.println(arcdate);
//
//			// comparing the system date and the current date in the date picker of the
//			// application
//			// if they are equal if loop executes
//			if (arcdate.equals(dd)) {
//
//				dates.get(i).click();
//				Thread.sleep(2000);
//
//				// verifying the date selected
//				String selectedDate = driver.findElement(By.xpath("//input[@id='from']")).getAttribute("value");
//				System.out.println(selectedDate);
//
//				break;
//			}
//		}
//
//	}

	@Test
	public void datePicker() throws InterruptedException {
//		driver.findElement(By.xpath("//input[@placeholder=\"Start date\"]")).click();
//		Thread.sleep(500);
//		driver.findElement(By.xpath("//div[@class=\"datepicker-days\"]//th[@class=\"datepicker-switch\"]")).click();
//		Thread.sleep(500);
//		List<WebElement> months = driver.findElements(By.xpath("//td[@colspan=\"7\"]//span[@class=\"month\"]"));
//		
//		for(int i=0; i < months.size(); i++)
//		{
//			if(months.get(i).getText().equalsIgnoreCase(mon))
//			{
//				months.get(i).click();
//			}
//		}

		String date = "17-Jul-2019";
		String dateArr[] = date.split("-");
		String day = dateArr[0];
		String month = dateArr[1];
		String year = dateArr[2];

		// Clicking on the datePicker box.
		driver.findElement(By.xpath("//input[@placeholder=\"Start date\"]")).click();
		Thread.sleep(500);

		// Clicking on the month selector switch
		driver.findElement(By.xpath("//div[@class=\"datepicker-days\"]//th[@class=\"datepicker-switch\"]")).click();
		Thread.sleep(2000);

		// Creating List months and storing all the months name in it.
		List<WebElement> months = driver.findElements(By.xpath("//td[@colspan=\"7\"]//span[@class=\"month\"]"));
		Thread.sleep(2000);

		// Iterating trough the months List and clicking on that month which is equal to
		// the String month.
		for (int i = 0; i < months.size(); i++) {
			if (months.get(i).getText().equalsIgnoreCase(month)) {
				months.get(i).click();
				Thread.sleep(2000);
				break;
			}
		}

		// Creating List days and storing all the days name in it.
		List<WebElement> days = driver.findElements(By.xpath("//div[@class=\"datepicker-days\"]//td"));

		// Iterating trough the days List and clicking on that day which is equal to
		// the String day.
		for (int j = 0; j < days.size(); j++) {
			if (days.get(j).getText().equalsIgnoreCase(day)) {
				days.get(j).click();
				Thread.sleep(2000);
				break;
			}
		}

//
//		// Locating all the months and storing it in a list.
//		List<WebElement> months = driver.findElements(By.xpath("//td[@colspan=\"7\"]//span[@class=\"month\"]"));
//
//		// Iterating through the list and selecting the required moth represented by
//		// "mon" String.
//		String mon = "Jul";
//		for (int i = 0; i < months.size(); i++) {
//			if (months.get(i).getText().equalsIgnoreCase(mon)) {
//				months.get(i).click();
//				Thread.sleep(2000);
//				break;
//			}
//		}

	}

	@AfterMethod
	public void closeEnvi() {
		driver.close();
	}

}

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

public class SelectDayFromCalender {

	WebDriver driver;

	@BeforeMethod
	public void setEnvi() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void clickDate() throws InterruptedException {
		driver.findElement(By.xpath("//label[@for='departure']")).click();

//		System.out.println(driver.findElement(By.xpath("//div[@aria-label='Wed Aug 21 2019']")).getText());

		List<WebElement> dates = driver
				.findElements(By.xpath("//div[@class='DayPicker-Months']//div[contains(@class,'DayPicker-Day')]"));

		for (int j = 0; j < dates.size(); j++) {

			// Checks only those cells which are in active
			if (dates.get(j).getAttribute("aria-disabled").equalsIgnoreCase("false")) {

				// Substring only captures only the date
				String subDate = dates.get(j).getText().substring(0, 2);
				System.out.println(subDate);
				if (subDate.equalsIgnoreCase("25")) {
					dates.get(j).click();
					Thread.sleep(1000);
					System.out.println(
							driver.findElement(By.xpath("(//p[@class='blackText font20 code'])[1]")).getText());
					break;
				}
			}
		}

//		for (int i = 0; i < dates.size(); i++) {
//			if (dates.get(i).getAttribute("aria-disabled").equalsIgnoreCase("true"))
//				System.out.println(dates.get(i).getText() + " : is disabled");
//
//			else if (dates.get(i).getAttribute("aria-disabled").equalsIgnoreCase("false")) {
//				// String dateNumber =
//				// driver.findElement(By.xpath("//div[@class='dateInnerCell']//p")).getText();
//				System.out.println(dates.get(i).getText().substring(0, 2) + " : is enabled");
//			}
//
//		}
//		List<WebElement> allDP = driver
//				.findElements(By.xpath("//div[@class='dateFilter hasDatepicker']//div//div//td"));
//		int totalDates = allDP.size();
//
//		for (int i=0 ; i < allDP.size(); i++)
//			System.out.println(allDP.get(i).getAttribute("aria-disabled"));

//		for (int i = 0; i < totalDates; i++) {
//			String dateText = allDP.get(i).getText();
//			if (dateText.equalsIgnoreCase("26")) {
//				allDP.get(i).click();
//				Thread.sleep(1000);
//				// System.out.println(driver.findElement(By.id("hp-widget__depart")).getText());
//				break;
//			}
//
//		}
	}

	@AfterMethod
	public void closeEnvi() {
		driver.close();
	}

}

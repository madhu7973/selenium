package listBox;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleListBoxWiithoutSelect {

	static WebDriver driver;

	// Following are the xpaths which locates the month, year and day dropdown
	// options.
	static String dayList = "//select[@id='day']//option";
	static String monthList = "//select[@id='month']//option";
	static String yearList = "//select[@id='year']//option";

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// following statements calls the generic method which passes the month, year
		// and day xpaths and also the required values
		genericMethod(dayList, "13");
		genericMethod(monthList, "may");
		genericMethod(yearList, "1991");
		driver.quit();

	}

	/*
	 * below is a generic method to select the day which is passed in the "value"
	 * parameter. xpath is another parameter where its locator which identifies all
	 * the options in the dropdown
	 */

	public static void genericMethod(String xpath, String value) throws InterruptedException {
		List<WebElement> options = driver.findElements(By.xpath(xpath));

		// Prints the size of the options.
		// System.out.println(options.size());

		for (int i = 0; i < options.size(); i++) {
			// Prints the List of options
			// System.out.println(options.get(i).getText());
			if (options.get(i).getText().equalsIgnoreCase(value)) {
				System.out.println(options.get(i).getText());
				options.get(i).click();
				// Thread.sleep(1000);
				break;
			}
		}

	}
}
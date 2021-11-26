package listBox;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListBox_GenericMethodToSetDate {

	public static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement dayList = driver.findElement(By.id("day"));
		WebElement monthList = driver.findElement(By.id("month"));
		WebElement yearList = driver.findElement(By.id("year"));

		// Declaring the date in one string. So if date needs to be changed, it can be
		// changed in one place.
		String birthday = "13-May-1991";
		String dobArr[] = birthday.split("-");

		//The splitted date is passed as argument to the generic method caller.
		selectMethod(dayList, dobArr[0]);
		selectMethod(monthList, dobArr[1]);
		selectMethod(yearList, dobArr[2]);

	}

	public static void selectMethod(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
}

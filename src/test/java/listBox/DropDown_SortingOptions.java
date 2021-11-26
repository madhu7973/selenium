package listBox;

import java.util.ArrayList;
import java.util.Collections;
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

public class DropDown_SortingOptions {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
//		driver.manage().window().maximize();
		driver.get("D:\\DuplicateDropDown.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void dropDownOptions() {

		List<WebElement> options = driver.findElements(By.xpath("//option"));
		ArrayList<String> textOptions = new ArrayList<String>();

		// adds the options to the list
		for (int i = 0; i < options.size(); i++) {
			String text = options.get(i).getText();
			textOptions.add(text);
		}

		// Prints the options as it is
		System.out.println("=====Unsorted options=====");
		for (int j = 0; j < options.size(); j++)
			System.out.println(options.get(j).getText());

		// Prints the options in the sorted order (Alphabetical Order)
		Collections.sort(textOptions);
		System.out.println("=====Sorted options=====");
		for (String s : textOptions)
			System.out.println(s);

		// Prints the options in the reverse order of the way they are stored in list.
		Collections.reverse(textOptions);
		System.out.println("=====Reverse order=====");
		for (String s : textOptions)
			System.out.println(s);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

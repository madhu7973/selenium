package listBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown_DuplicateOptions {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("D:\\DuplicateDropDown.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void duplicateOptions() {
		List<WebElement> options = driver.findElements(By.xpath("//option"));
		ArrayList<String> ListOptions = new ArrayList<String>();
//		TreeSet<String> TreeOptions = new TreeSet<String>();

		// Adds the options to tree set
		for (int i = 0; i < options.size(); i++) {
			String text = options.get(i).getText();
			ListOptions.add(text);

//			// Before adding the options to tree set checks if the element already added
//			if (TreeOptions.add(text) == false) {
//				System.out.println("Dulpicate :" + text);
//			} else
//				TreeOptions.add(text);
		}

//		// Prints the options
//		for (String s : textOptions)
//			System.out.println(s);

		for (String s : ListOptions)
			System.out.println(s + " :" + Collections.frequency(ListOptions, s));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

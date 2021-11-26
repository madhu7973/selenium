package listBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompareListBoxOptions {
	WebDriver driver;

	@BeforeMethod
	public void setEnvi() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\SeleniumDependencies\\BrowserExecutables\\chromedriver-2.41.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void CLB() {
		WebElement element = driver.findElement(By.xpath("//select[@id='month']"));
		Select select = new Select(element);

//		select.selectByIndex(0);
//		select.selectByValue("1");
//		select.selectByVisibleText("Options");

		List<WebElement> options = select.getOptions();
		ArrayList<String> al = new ArrayList<String>();
		for (int i = 0; i < options.size(); i++) {
			String listOptions = options.get(i).getText();
			al.add(listOptions);
		}

		for (String s : al) {
			System.out.println(s);
		}

		ArrayList<String> al1 = new ArrayList<String>();
		al1.add("Month");
		al1.add("Jan");
		al1.add("Feb");
		al1.add("Mar");
		al1.add("Apr");
		al1.add("May");
		al1.add("Jun");
		al1.add("Jul");
		al1.add("Aug");
		al1.add("Sept");
		al1.add("Oct");
		al1.add("Nov");
		al1.add("Dec");

		if (al.containsAll(al1))
			System.out.println("All months are displayed");
		else
			System.out.println("All moths are not displayed");

		Collections.reverse(al);

		System.out.println("==============After reversing===========");
		for (String s : al) {
			System.out.println(s);
		}

		System.out.println("==============After sorting===========");
		Collections.sort(al);
		for (String s : al) {
			System.out.println(s);
		}

	}

	@AfterMethod
	public void closeEnvi() {
		driver.quit();
	}

}
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

public class MathOnTableDta {
	WebDriver driver;

	@BeforeMethod
	public void openEnvi() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///E:/sampleTable.html");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void tdCalc() {
		List<WebElement> element = driver.findElements(By.xpath("//td[last()]"));

		int sum = 0;
		int totalInt = 0;
		for (int i = 0; i < element.size() - 1; i++) {
			String text = element.get(i).getText();
			int intValue = Integer.parseInt(text);
			sum = sum + intValue;
			System.out.println("sum is " + sum);
		}

		String total = driver.findElement(By.xpath("(//td[last()])[4]")).getText();
		totalInt = Integer.parseInt(total);
		System.out.println(totalInt);

		if (totalInt == sum)
			System.out.println("both values are same");
		else
			System.out.println("both values are different");
	}

	@AfterMethod
	public void closeEnvi() {
		driver.close();
	}

}

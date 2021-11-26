package listBox;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListBox_isMultiple {

	public static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement multiSelect = driver.findElement(By.id("multi-select"));

		List<WebElement> allOptions;

		Select select = new Select(multiSelect);
		if (select.isMultiple()) {
			allOptions = select.getOptions();
			for (int i = 0; i < allOptions.size(); i++) {
				multiSelect.sendKeys(Keys.CONTROL);
				if (allOptions.get(i).getText().equalsIgnoreCase("Ohio"))
					allOptions.get(i).click();
				if (allOptions.get(i).getText().equalsIgnoreCase("New Jersey"))
					allOptions.get(i).click();
			}
		}

		List<WebElement> allSelOptions = select.getAllSelectedOptions();
		for (WebElement element : allSelOptions)
			System.out.println(element.getText());

		driver.close();
	}
}
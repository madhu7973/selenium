package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchFFWithoutSystemProperty {
	
	 

	public static void main(String[] args) 
	{
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.seleniumhq.org/download/");
		String x = driver.findElement(By.xpath("//tr/td[text() = 'Java']/../td[2]")).getText();
		System.out.println(x);
		driver.close();
	}
}

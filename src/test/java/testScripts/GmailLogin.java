package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GmailLogin {

	WebDriver driver;

	@Test
	public void gmailLogin() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://accounts.google.com/signin/v2/identifier?"
				+ "continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&"
				+ "sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.findElement(By.id("identifierId")).sendKeys("devarajumadhusudan");
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Krishna9$");
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		String url = driver.getCurrentUrl();
		System.out.println(driver.findElement(By.xpath("(//span[text()='2-step Verification'])[1]")).isDisplayed());

	}

}

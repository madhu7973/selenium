package frames;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dummy {

	WebDriver driver;

	@BeforeMethod
	public void openEnv() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
//		driver.get("https://madhusudan.devaraju@capgemini.com:India39$@development-webstore-claires.demandware.net/on/demandware.store/Sites-clairesEU-Site");
		driver.get("https://storefront:ITCUK2017@dev-itc-uk.dw-sites.com/");
	}

	@Test
	public void test() {

	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}
}

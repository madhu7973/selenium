package popups;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticationPopup {

	WebDriver driver;
	
//	public static void main(String[] args) {
//	WebDriver driver;
//
//	WebDriverManager.iedriver().setup();
//	driver = new InternetExplorerDriver();
//	driver.manage().window().maximize();
//	// driver.get("https://www.actitime.com/contact-support");
//	// driver.get("http://tinyupload.com/");
//	 driver.get("https://www.engprod-charter.net");
//	
//	// driver.get("https://storefront:DMCEAST2016@www-dev-dmc-cz.dw-sites.com/");
//	
//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	
//}
	
	
	@BeforeMethod
	public void setEnvi()
	{
		WebDriverManager.iedriver().setup();
		driver= new InternetExplorerDriver();
		driver.manage().window().maximize();
		// driver.get("https://storefront:DMCEAST2016@www-dev-dmc-cz.dw-sites.com/");
		
		// driver.get("https://storefront:Madhu123!@dev09-latam-loreal.demandware.net/s/lancome/en/home");
		
		// driver.get("https://www-dev-dmc-cz.dw-sites.com/");
		
		// driver.get("https://www.engprod-charter.net");
		
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
//	@Test
//	public void dummy() throws IOException
//	{
//		
//	}
	
	@Test
	public void authPopup() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("D:\\AutoIT\\Scripts\\AuthPopup\\authPopup.exe");
		Thread.sleep(2500);
	}
	
	
	@AfterMethod
	public void closeEnvi() {
		driver.quit();
	}
	
}

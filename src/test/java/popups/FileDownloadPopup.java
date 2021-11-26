package popups;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.compress.compressors.FileNameUtil;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileDownloadPopup {
	WebDriver driver;

	String fileDownloadPath = "D:\\Users\\maddevar\\Downloads\\FDP";

	File folder;

	@BeforeMethod
	public void setEnvi() {

		/*
		 * WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver();
		 * FirefoxProfile profile = new FirefoxProfile(); FirefoxOptions options = new
		 * FirefoxOptions();
		 * 
		 * profile.setPreference("browser.download.folderList", 2);
		 * profile.setPreference("browser.download.manager.showWhenStarting", false);
		 * profile.setPreference("browser.download.dir", "E:\\Downloads");
		 * profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
		 * "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		 * 
		 * options.setProfile(profile); WebDriverManager.firefoxdriver().setup(); driver
		 * = new FirefoxDriver(options);
		 * driver.get("http://www.sampledocs.in/BrowseFile/DummyFiles/xlsx"); //
		 * driver.get(
		 * "https://shriresume.com/download-template/smart-and-balanced/word#aceptconditabc"
		 * ); driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 */

//		for chrome download
//
//		String fileDownloadPath = "E:\\Downloads";
//
//		HashMap<String, Object> chromePref = new HashMap<String, Object>();
//
//		// Do not show any popup when clicked on download link.
//		chromePref.put("profile.default_content_settings.popups", 0);
//
//		// Download to the specified location which is passed a value in the below
//		// statement
//		chromePref.put("download.default_directory", fileDownloadPath);
//
//		ChromeOptions options = new ChromeOptions();
//		options.setExperimentalOption("prefs", chromePref);
//
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		driver.get("http://www.sampledocs.in/BrowseFile/DummyFiles/xlsx");

//		for firefox download

		FirefoxOptions options = new FirefoxOptions();

		// 2 - Download the doc to the specified location i.e., fileDownloadPath
		// Similarly 0 - downloads to desktop and
		// 1 - downloads to downloads folder
		options.addPreference("browser.download.folderList", 2);

		// This do not allow any popups to be displayed during download.
		options.addPreference("browser.helperApps.alwaysAsk.force", false);

		options.addPreference("browser.download.dir", fileDownloadPath);
		// options.addPreference("browser.download.defaultFolder", fileDownloadPath);

		// This do not allow the download progress popup displayed at the top of the
		// browser.
		options.addPreference("browser.download.manager.showWhenStarting", false);

		// Here we mention the MIME type of the document that will be downloaded.
		options.addPreference("browser.helperApps.neverAsk.saveToDisk",
				"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-xls-download/");
	}

	@Test
	public void FDPP() throws InterruptedException {
		// driver.findElement(By.xpath("//input[@id='checkboxclick']")).click();
		// driver.findElement(By.xpath("//a[@id='final-download-link1']")).click();
		driver.findElement(By.xpath("//a[contains(@href, 'XLSX_10.xlsx')]")).click();

		// String actualExtension = FilenameUtils.getExtension(fileDownloadPath);

		// System.out.println("extension of file downloaded is " + actualExtension);

		// Assert.assertTrue(actualExtension.equalsIgnoreCase(".xlsx"), "The file
		// downloaded is not correct");

		// Assert.assertTrue(folder.getAbsolutePath().contains(".xlsx"), "The file
		// downloaded is not correct" );

		File fileLocation = new File(fileDownloadPath);
		File[] allFiles = fileLocation.listFiles();

		// Used for assertion
		boolean flag = false;

		// Iterates all the files present in fileDownloadPath location
		for (File file : allFiles)

			// fetches the the entire path of the document along with name and extension of
			// the document
			if (file.getAbsolutePath().contains(".xlsx")) {
				System.out.println("Downloaded file name is " + file.getName());

				// deletes all the file one by one which have extension .xlsx and raises the
				// flag
				flag = file.delete();
				break;
			}
		Assert.assertTrue(flag, "Downloaded file is not correct");

		Thread.sleep(3000);
	}

	@AfterMethod
	public void closeEnvi() {
		driver.close();
//		for (File file : folder.listFiles())
//			file.delete();
//		folder.delete();
	}

}

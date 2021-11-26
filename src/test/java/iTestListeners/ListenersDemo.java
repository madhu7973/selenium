package iTestListeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersDemo extends TestClass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) 
	{
	
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("Testcase failed: " + result.getMethod());
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File ("./FaliedTCsScreenShots/"+"FailedTCs_"+result.getName()+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{


	}

	@Override
	public void onStart(ITestContext context) 
	{


	}

	@Override
	public void onFinish(ITestContext context) 
	{


	}

}

package testNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DependencyExample 
{
	@BeforeMethod (description = "before method")
	public void beforeMethod ()
	{
		System.out.println("Executing BeforeMethod");
	}

	@Test ( description = "first method")
	public void method1 ()
	{
		System.out.println("Executing Metod 1");
	}

	@Test (dependsOnMethods = "method1",description = "second method")
	public void method2 ()
	{
		System.out.println("Executing Metod 2");
		Assert.assertEquals(13, 15);
	}

	@Test (dependsOnMethods = {"method2", "method1"},  description = "third method")
	public void amethod3 ()
	{
		System.out.println("Executing Metod 3");
	}

	@AfterMethod
	public  void afterMetod ()
	{
		System.out.println("Executing after method");
	}

}

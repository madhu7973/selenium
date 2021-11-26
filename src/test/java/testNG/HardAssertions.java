package testNG;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HardAssertions {

	public static WebDriver driver; //null object

	@BeforeMethod
	public void setUp() {
		System.out.println("BeforMethod");
	}

	@Test
	public void login() {

		System.out.println("login method");
		Assert.assertFalse(false);
		Assert.assertFalse(true, "assertion Failed");
	}

	@Test(enabled = false)
	public void checkOut() {
		System.out.println("checkout method");
		Assert.assertTrue(true);
		Assert.assertTrue(false, "assertion failed");
	}

	@Test
	public void accountCreation() {
		System.out.println("accountCreation method");
		Assert.assertEquals(true, true);
		Assert.assertEquals("assert", "assert");
		Assert.assertEquals(3, 9, "assertion failed");
	}

	@Test
	public void addToBag() {
		System.out.println("addToBag method");
		Assert.fail();
		Assert.fail("intentional fail");
		Assert.fail("purpose", new NumberFormatException("intoduced error"));
	}

	@Test
	public void wishList() {
		System.out.println("wishlist method");
		Assert.assertNotEquals(true, true);
		Assert.assertNotEquals("assert", "assert");
		Assert.assertNotEquals(3, 9, "assertion failed");
	}

	@Test
	public void search() {
		System.out.println("search method");
		Assert.assertNull(driver, "driver is not null");
		Assert.assertNull(9);// 9 is not a null so assertion fails
	}

	@Test
	public void internalLogin() {
		System.out.println("internalLogin method");
		Assert.assertNotNull(9);
		Assert.assertNotNull(driver, "driver is not null");//driver object is null so assertion fails
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("AfterMethod");

	}

}

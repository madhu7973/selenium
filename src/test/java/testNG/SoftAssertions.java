package testNG;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertions {
	SoftAssert soft = new SoftAssert();

	public static WebDriver driver; // null object

	@BeforeMethod
	public void setUp() {
		System.out.println("BeforMethod");
	}

	@Test
	public void login() {
		System.out.println("login method before soft assertion");
		soft.assertFalse(false);
		soft.assertFalse(true, "assertion Failed");
		System.out.println("login method after soft assertion");
		soft.assertAll();
	}

	@Test
	public void checkOut() {
		System.out.println("checkout method before soft assertion");
		soft.assertTrue(true);
		soft.assertTrue(false, "assertion failed");
		System.out.println("checkout method after soft assertion");
		soft.assertAll();
	}

	@Test
	public void accountCreation() {
		System.out.println("accountCreation method before soft asertion");
		soft.assertEquals(true, true);
		soft.assertEquals("assert", "assert");
		soft.assertEquals(3, 9, "assertion failed");
		System.out.println("accountCreation method after soft asertion");
		soft.assertAll();
		System.out.println("accountCreation method after asertAll()");
	}

	@Test
	public void addToBag() {
		System.out.println("addToBag method before soft assertion");
		soft.fail();
		soft.fail("intentional fail");
		soft.fail("purpose", new NumberFormatException("intoduced error"));
		System.out.println("addToBag method after soft assertion");
		soft.assertAll();
	}

	@Test
	public void wishList() {
		System.out.println("wishlist method before soft assertion");
		soft.assertNotEquals(true, true);
		soft.assertNotEquals("assert", "assert");
		soft.assertNotEquals(3, 9, "assertion failed");
		System.out.println("wishlist method after soft assertion");
		soft.assertAll();
	}

	@Test
	public void search() {
		System.out.println("search method before soft assertion");
		soft.assertNull(driver, "driver is not null");
		soft.assertNull(9);// 9 is not a null so assertion fails
		System.out.println("search method after soft assertion");
		soft.assertAll();
	}

	@Test
	public void internalLogin() {
		System.out.println("internalLogin method before soft asertion");
		soft.assertNotNull(9);
		soft.assertNotNull(driver, "driver is not null");// driver object is null so assertion fails
		System.out.println("internalLogin method after soft asertion");
		soft.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("AfterMethod");

	}
}

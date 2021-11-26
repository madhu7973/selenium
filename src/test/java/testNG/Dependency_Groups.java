package testNG;

import org.testng.annotations.Test;

public class Dependency_Groups {

	@Test(dependsOnGroups = { "checkout" })
	public void logout() {
		System.out.println("logout - closeBrowser");
	}

	@Test(groups = { "account-login" })
	public void login() {
		System.out.println("login - group: account-login");
	}

	@Test(groups = { "search" }, dependsOnGroups = { "account-login" })
	public void addToBag() {
		System.out.println("addToBag - group: search");
	}

//	@Test(groups = { "search" }, dependsOnGroups = { "account-login" })
//	public void PLP() {
//		System.out.println("PLP - groups: search");
//	}

//	@Test(groups = { "search" }, dependsOnGroups = { "account-login" })
//	public void searchPage() {
//		System.out.println("searchPage - groups: search");
//	}

//	@Test(groups = { "checkout" }, dependsOnGroups = { "account-login", "search" })
//	public void shipping() {
//		System.out.println("shipping - groups: checkout");
//	}

//	@Test(groups = { "checkout" }, dependsOnGroups = { "account-login", "search" })
//	public void billing() {
//		System.out.println("billing - groups: checkout");
//	}

	@Test(groups = { "checkout" }, dependsOnGroups = { "account.*", "search" })
	public void payment() {
		System.out.println("payment - groups: checkout");
	}
}

package testNG;

import org.testng.annotations.Test;

public class TestGroups1 {
	
	@Test (groups= {"regression", "sanity"})
	public void tc_1()
	{
		System.out.println("tc - 1: regression, sanity");
	}

	@Test (groups= {"regression", "smoke", "unit"})
	public void tc_2()
	{
		System.out.println("tc - 2: regression, smoke, unit");
	}
	
	@Test (groups= {"sanity"})
	public void tc_3()
	{
		System.out.println("tc - 3: sanity");
	}
	
	@Test (groups= {"regression"})
	public void tc_4()
	{
		System.out.println("tc - 4: regression");
	}
	
	@Test (groups= {"smoke", "sanity"})
	public void tc_5()
	{
		System.out.println("tc - 5: smoke, sanity");
	}

}

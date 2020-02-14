package com.qa.guru.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.guru.Testbase.TestBase;
import com.qa.guru.pages.HomePage;
import com.qa.guru.pages.MobilePage;
import com.qa.guru.pages.SearchPage;


public class HomePageTest extends TestBase {

	HomePage homePage;
	MobilePage mobilePage;
	SearchPage searchPage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		homePage = new HomePage();
		mobilePage = new MobilePage();
		searchPage = new SearchPage();
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle() throws InterruptedException
	{
		Thread.sleep(3000);
		String homePageTitle = homePage.displayHomePageTitle();
		Assert.assertEquals(homePageTitle, "Home page","Home page title not matched");
	
	}
	
	@Test(priority=2)
	public void clickOnMobileMenu() throws InterruptedException
	{
		Thread.sleep(3000);
		mobilePage= homePage.clickOnMobileLink();
	}
	
	@Test(priority=3)
	public void verifySearchFunctionality() throws InterruptedException
	{
		mobilePage.searchTextBox();
		Assert.assertEquals(searchPage.searchPageResultText(), "SEARCH RESULTS FOR 'SAMSUNG'");	
	}
	

	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
}

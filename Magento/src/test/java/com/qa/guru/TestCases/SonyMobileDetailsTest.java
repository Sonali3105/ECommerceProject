package com.qa.guru.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.guru.Testbase.TestBase;
import com.qa.guru.pages.HomePage;

import com.qa.guru.pages.MobilePage;
import com.qa.guru.pages.ShoppingCartPage;
import com.qa.guru.pages.SonyMobileDetailsPage;
import com.qa.guru.util.TestUtil;

public class SonyMobileDetailsTest extends TestBase{

	HomePage homePage;
	MobilePage mobilePage;
	ShoppingCartPage shoppingCart;
	 SonyMobileDetailsPage sonyMobileDetailsPage;
	
	public SonyMobileDetailsTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		homePage = new HomePage();
		mobilePage = new MobilePage();
		shoppingCart = new ShoppingCartPage();
		sonyMobileDetailsPage = new SonyMobileDetailsPage();
		homePage.clickOnMobileLink();
	}
	
	@Test(priority=1)
	public void verifySonyMobilePageTitle() throws InterruptedException
	{
		//Thread.sleep(3000);
		String PageTitle = sonyMobileDetailsPage.displaySonyMobilePageTitle();
		Assert.assertEquals(PageTitle, "Sony Xperia - Mobile","Sony Xperia - Mobile title not matched");
	}
	
	//Verify that cost of product in list page and details page are equal
	//Read the Sony Xperia mobile Product value in list and details page should be equal ($100). 
	@Test(priority=2)
	public void verifySonyMobileValue() throws InterruptedException, IOException
	{
		mobilePage.clickOnSonyImage();
		try { 
		Assert.assertEquals( sonyMobileDetailsPage.getSonyMobilePrice(), "$100.00");
		} catch(Exception e) { e.printStackTrace();}
		try { 
			Assert.assertEquals(mobilePage.getSonyMobilePrice(), sonyMobileDetailsPage.getSonyMobilePrice(), "Sony Price on MobilePage and SonyMobileDetailsPage is not equal");
			} catch(Exception e) {  e.printStackTrace();}
			TestUtil.takeScreenshotAtEndOfTest();
	}
	

	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}

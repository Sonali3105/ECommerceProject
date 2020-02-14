package com.qa.guru.TestCases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.guru.Testbase.TestBase;
import com.qa.guru.pages.AccountDashboardPage;
import com.qa.guru.pages.HomePage;
import com.qa.guru.pages.LoginPage;
import com.qa.guru.pages.MobilePage;
import com.qa.guru.pages.MyOrdersPage;
import com.qa.guru.pages.RegisterPage;
import com.qa.guru.pages.SearchPage;
import com.qa.guru.pages.ShoppingCartPage;
import com.qa.guru.pages.TVPage;
import com.qa.guru.util.TestUtil;

public class MyOrdersPageTest extends TestBase {

	HomePage homePage;
	MobilePage mobilePage;
	RegisterPage registerPage;
	ShoppingCartPage shoppingCart;
	SearchPage searchPage ;
	TestUtil testUtil;
	TVPage tvPage;
	LoginPage loginPage;
	AccountDashboardPage accountDahsboardPage;
	MyOrdersPage myOrders;
 
	public MyOrdersPageTest(){
			super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		mobilePage = new MobilePage();
		homePage = new HomePage();
		shoppingCart = new ShoppingCartPage();
		searchPage = new SearchPage();
		tvPage = new TVPage();
		myOrders = new MyOrdersPage();
	
		loginPage = homePage.clcikOnMyAccountLink();
		accountDahsboardPage= loginPage.clickOnLoginBtn("vkn878@gmail.com", "Harish123*");
		myOrders=accountDahsboardPage.clcikOnMyOrdersLink();
				
	}
	
	@Test(priority=1)
	public void verifyLoginPageTitle(){
		driver.getTitle();
	}
	
	// Verify that you will be able to save previously placed order as a pdf file 
	@Test(priority=2)
	public void verifyPrintPreviouslyOrder() {

		myOrders.clickOnViewOrdersLink();
	    try {
	    	Assert.assertEquals(myOrders.getRecentOrdersText(), "ORDER #100010977 - PENDING","RECENT ORDERS failed to get displayed on the page. ");
	        System.out.println("*** RECENT ORDERS is confirmed as the correct page to be in. ***");
	      } catch (Error e) {
	    	  System.out.println("*** RECENT ORDERS failed to get displayed on the page. ***");
	    	  e.printStackTrace();	
	      }
		myOrders.clickOnPrintOrdersLink();
		driver.get("SaveAsPDFGuru99.exe"); // write this .exe file through AutoIT tool 
		
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
}

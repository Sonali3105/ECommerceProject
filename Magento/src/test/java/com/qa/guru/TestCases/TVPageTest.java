package com.qa.guru.TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.guru.Testbase.TestBase;
import com.qa.guru.pages.AccountDashboardPage;
import com.qa.guru.pages.HomePage;
import com.qa.guru.pages.MobilePage;
import com.qa.guru.pages.RegisterPage;
import com.qa.guru.pages.SearchPage;
import com.qa.guru.pages.ShoppingCartPage;
import com.qa.guru.pages.TVPage;
import com.qa.guru.util.TestUtil;

public class TVPageTest extends TestBase {

	HomePage homePage;
	MobilePage mobilePage;
	RegisterPage registerPage;
	ShoppingCartPage shoppingCart;
	SearchPage searchPage ;
	AccountDashboardPage accountDashboardPage;
	TestUtil testUtil;
	TVPage tvPage;
	
	String sheetName = "register";
	
	   
	public TVPageTest(){
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
		accountDashboardPage = new AccountDashboardPage();
		//registerPage = homePage.clickOnAccountLink();
		tvPage = accountDashboardPage.clickOnTVPage();
		
	}
	
	@Test(priority=1)
	public void verifyTVPageTitle(){
		driver.getTitle();
	}
	
	
	
}

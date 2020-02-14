package com.qa.guru.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.guru.Testbase.TestBase;
import com.qa.guru.pages.AccountDashboardPage;
import com.qa.guru.pages.HomePage;
import com.qa.guru.pages.LoginPage;
import com.qa.guru.pages.MobilePage;
import com.qa.guru.pages.RegisterPage;
import com.qa.guru.pages.SearchPage;
import com.qa.guru.pages.ShoppingCartPage;
import com.qa.guru.pages.TVPage;
import com.qa.guru.util.TestUtil;

public class LoginPageTest extends TestBase{

	HomePage homePage;
	MobilePage mobilePage;
	RegisterPage registerPage;
	ShoppingCartPage shoppingCart;
	SearchPage searchPage ;
	TestUtil testUtil;
	TVPage tvPage;
	LoginPage loginPage;
	AccountDashboardPage accountDahsboardPage;
 
	public LoginPageTest(){
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
		loginPage = homePage.clcikOnMyAccountLink();
		
	}
	
	@Test(priority=1)
	public void verifyLoginPageTitle(){
		driver.getTitle();
	}
	
	
	@Test(priority=2)
	public void loginTest(){
		accountDahsboardPage = loginPage.clickOnLoginBtn(prop.getProperty("Email"), prop.getProperty("Password"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}

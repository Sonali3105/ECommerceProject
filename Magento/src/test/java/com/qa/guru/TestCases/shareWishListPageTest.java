package com.qa.guru.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.guru.Testbase.TestBase;
import com.qa.guru.pages.AccountDashboardPage;
import com.qa.guru.pages.HomePage;
import com.qa.guru.pages.MobilePage;
import com.qa.guru.pages.MyWishlistPage;
import com.qa.guru.pages.RegisterPage;
import com.qa.guru.pages.SearchPage;
import com.qa.guru.pages.ShoppingCartPage;
import com.qa.guru.pages.TVPage;
import com.qa.guru.pages.shareWishListPage;
import com.qa.guru.util.TestUtil;

public class shareWishListPageTest extends TestBase{
	HomePage homePage;
	MobilePage mobilePage;
	RegisterPage registerPage;
	ShoppingCartPage shoppingCart;
	SearchPage searchPage ;
	AccountDashboardPage accountDashboard;
	MyWishlistPage myWishList;
	TestUtil testUtil;
	shareWishListPage ShareWishList;
	TVPage tvPage;
	

	public shareWishListPageTest(){
			super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		mobilePage = new MobilePage();
		shoppingCart = new ShoppingCartPage();
		searchPage = new SearchPage();
		accountDashboard = new AccountDashboardPage();
		tvPage = new TVPage();
		myWishList = new MyWishlistPage();
		ShareWishList = new shareWishListPage();
		registerPage =new RegisterPage();
	
	}
	
	@Test(priority=1)
	public void verifyshareWishListPageTestPageTitle(){
		driver.getTitle();
	}
	
	//Verify can create an account in e-Commerce site and can share wishlist to other poeple using email.  
	@Test(priority=2)
	public void VerifyShareWishListFunctionality() {	
	 homePage.clickOnRegisterLink();
	 registerPage.register("Viken", "T", "Uperiya", "vkn88@gmail.com", "Harish123*", "Harish123*");
	 registerPage.clickOnRegisterBtn();
	// Assert.assertEquals(accountDashboard.getReistrationVerificationMsg(), "Hello, Viken T Uperiya!");
	 accountDashboard.clickOnTVPage();
	 tvPage.clcikOnAddToWishListLG();
	 myWishList.clickOnshareWishListBtn();
	 myWishList.enterShareWishListInfo();
	 //Assert.assertEquals(myWishList.verifyShareWishlistMsg(), "LG LCD has been added to your wishlist. Click here to continue shopping.");
	 Assert.assertEquals(ShareWishList.verifyShareEmailMsg(), "Your Wishlist has been shared.");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}

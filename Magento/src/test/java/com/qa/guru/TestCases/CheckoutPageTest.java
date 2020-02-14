package com.qa.guru.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.guru.Testbase.TestBase;
import com.qa.guru.pages.AccountDashboardPage;
import com.qa.guru.pages.CheckoutPage;
import com.qa.guru.pages.HomePage;
import com.qa.guru.pages.LoginPage;
import com.qa.guru.pages.MobilePage;
import com.qa.guru.pages.MyWishlistPage;
import com.qa.guru.pages.RegisterPage;
import com.qa.guru.pages.SearchPage;
import com.qa.guru.pages.ShoppingCartPage;
import com.qa.guru.pages.TVPage;
import com.qa.guru.pages.shareWishListPage;
import com.qa.guru.util.TestUtil;

public class CheckoutPageTest extends TestBase{
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
	CheckoutPage checkoutPage;
	LoginPage loginPage;

	public CheckoutPageTest(){
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
		loginPage = new LoginPage();
		checkoutPage = new CheckoutPage();
		
		homePage.clcikOnMyAccountLink();
		loginPage.clickOnLoginBtn("vkn878@gmail.com", "Harish123*");
	}
	
	@Test(priority=1)
	public void verifyshareCheckoutPageTestPageTitle(){
		driver.getTitle();
	}
	
	//Verify user is able to purchase product using registered email id(USE CHROME BROWSER)     
	@Test(priority=2)
	public void verifyOrderIsPlaced() throws IOException {
		
//		homePage.clcikOnMyAccountLink();
//		loginPage.clickOnLoginBtn("sonaupe@gmail.com", "SonaTeja");
		accountDashboard.clcikOnMywishListLink();
		myWishList.clickOnAddToCartSamsungTV();
		//Assert.assertEquals(shoppingCart.displaySamsungTVText(), "Samsung LCD was added to your shopping cart.");
		shoppingCart.clcikOnProceedToCheckoutBtn();
		checkoutPage.enterShippingInfo();
		Assert.assertEquals(checkoutPage.diplayFixedRate(),"$5.00");
		checkoutPage.clcikOnShippingAndPaymentMethod();
		TestUtil.takeScreenshotAtEndOfTest();
		Assert.assertEquals(checkoutPage.clickOnPlaceOrderBtn(),"YOUR ORDER HAS BEEN RECEIVED.");
		TestUtil.takeScreenshotAtEndOfTest();
		
	}
	
	//Verify you are able to change or reorder previously added product
	// Test Data = QTY = 10
	@Test(priority=3)
	public void verifyReOrderProduct() throws IOException, InterruptedException {
		
		accountDashboard.clickOnReorderLink();
		shoppingCart.updateQty();
		//TestUtil.takeScreenshotAtEndOfTest();
		shoppingCart.clcikOnProceedToCheckoutBtn();
		checkoutPage.clickOnAllContinueBtn();
		Thread.sleep(500); 
		checkoutPage.clickOnPlaceOrderBtn();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}

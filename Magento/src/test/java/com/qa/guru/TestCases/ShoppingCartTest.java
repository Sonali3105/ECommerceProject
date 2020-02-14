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

public class ShoppingCartTest extends TestBase{
	
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
	
	public ShoppingCartTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		
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
		

	}
	
	@Test(priority=1)
	public void verifyCartPageTitle() throws InterruptedException
	{
		Thread.sleep(3000);
		homePage.clickOnMobileLink();
		mobilePage.clickOnAddToCartSonyBtn();
		String PageTitle = shoppingCart.displayShoppingCartPageTitle();
		Assert.assertEquals(PageTitle, "Shopping Cart","Shopping Cart page title not matched");
	
	}
	
	@Test(priority=2)
	public void verifyDisplayIphoneText() 
	{
		homePage.clickOnMobileLink();
		shoppingCart = mobilePage.clickOnAddToCartIphoneBtn();
		shoppingCart.displayShoppingCartPageTitle();
		shoppingCart.displayIphoneText();
	}
	
	@Test(priority=3)
	public void verifyDisplaySamsungText() 
	{
		homePage.clickOnMobileLink();
		shoppingCart = mobilePage.clickOnAddToCartSamsungBtn();
		shoppingCart.displayShoppingCartPageTitle();
		shoppingCart.displaySamsungText();
	}

	@Test(priority=4)
	public void verifyDisplaySonyText() 
	{
		homePage.clickOnMobileLink();
		shoppingCart = mobilePage.clickOnAddToCartSonyBtn();
		shoppingCart.displayShoppingCartPageTitle();
		shoppingCart.displaySonyText();
	}
	
	
	//Verify that you cannot add more product in cart than the product available in store
	@Test(priority=4)
	public void verifyPrdctQty() 
	{  
		homePage.clickOnMobileLink();
		shoppingCart = mobilePage.clickOnAddToCartSonyBtn();
	    try {	
	    	//verify the error msg
	    	Assert.assertEquals(shoppingCart.editQty(), "Some of the products cannot be ordered in requested quantity.");
		    } catch (Exception e) {
		    	e.printStackTrace();	    	
		    }
	    String noItemsStg = ("SHOPPING CART IS EMPTY");
	    System.out.println("You have no items msg = " + noItemsStg); 
	    try {
	    	//Verify cart is empty
	    	Assert.assertEquals(shoppingCart.emptyCart(), noItemsStg);
	    } catch (Exception e) {
	    	e.printStackTrace();	    	
	    }		
	}
	
	//Verify cart is empty
	@Test(priority=5)
	public void shoppingCartEmpty() 
	{      
	    String noItemsStg = ("You have no items in your shopping cart.");
	    System.out.println("You have no items msg = " + noItemsStg); 
	    try {	    	
	    	Assert.assertEquals(shoppingCart.emptyCart(), noItemsStg);
	    } catch (Exception e) {
	    	e.printStackTrace();	    	
	    }		
		
	}
	
	//Verify Discount Coupon works correctly
	@Test(priority=5)
	public void verifyDiscountCouponfunctionality() throws IOException, InterruptedException {
		homePage.clcikOnMyAccountLink();
		loginPage.clickOnLoginBtn("Tejaupe@gmail.com", "TejaSona");
		accountDashboard.clickOnMobilePage();
		mobilePage.clickOnAddToCartIphoneBtn();
		shoppingCart.enterDiscountCoupon();
		Thread.sleep(3000);
		 // discount amount calculations and comparisons between the derived amount against the discount amount displayed on the page
		double dSubTot = Double.parseDouble(shoppingCart.displaySubTotalAmt());       // e.g.$500.00 
		double dDiscDisp = Double.parseDouble(shoppingCart.displayDiscAmt());          // e.g. $25.00
		double dDiscountedAmtDisplayed = Double.parseDouble(shoppingCart.displayGrandTotalAmt()); // e.g.$475.00
		    
		Thread.sleep(3000);
		// multiply the dSubTot by the GURU50 discount rate (GURU50 = 5% = 0.05) 
	    double discountedAmt = (dSubTot * 0.05);     // discountedAmt is the calculated discounted amount (e.g. $25.00)	
	    double dDiscPrice = (dSubTot - discountedAmt); // e.g. Discounted Price (e.g. $475) = Sub Total ($500.00) less the 5% discount amount ($25.00)
	    
	    // ************************************************************************************************
	    //   compare & assert that the displayed discount amount is equal to the derived discount amount
	    // ************************************************************************************************
	    // the amount of discount (e.g. $25.00 = $500 * 5%) compared to the amount of discount as displayed on the page (e.g. $25)
		Thread.sleep(3000);
	    if (discountedAmt == dDiscDisp){
	    		System.out.println("*** Derived discount amount   = " + discountedAmt);
	    		System.out.println("*** Displayed discount amount = " + dDiscDisp);
	    }else
	      { System.out.println("*** Derived discount amount not equal displayed discount amount ***");
	    }	
	   
		Thread.sleep(3000);
	    String string_discountedAmt = Double.toString(discountedAmt);
	    String string_dDiscDisp = Double.toString(dDiscDisp);
	    try {
	        Assert.assertEquals(string_discountedAmt, string_dDiscDisp);
	      } catch (Error e) {
	    	  System.out.println("*** Derived discount amount not equal displayed discount amount ***");
	    	  e.printStackTrace();	
	      }
	 
	    // **************************************************************************************************************************************
	    // compare & assert that the displayed discounted price is equal to the derived discounted price
	    // derived discounted price (e.g. $475.00 = $500 less $25)) compared to the displayed discounted price ($475.00) as displayed on the page
	    // **************************************************************************************************************************************
		Thread.sleep(3000);
	    if (dDiscPrice == dDiscountedAmtDisplayed){
    		System.out.println("*** Derived discounted price   = " + dDiscPrice);
    		System.out.println("*** Displayed discounted price = " + dDiscountedAmtDisplayed);
	    }else
	    	{ System.out.println("*** Derived discounted price not equal displayed discounted price ***");
	    }	
	    
		Thread.sleep(3000);
	    String string_dDiscPrice = Double.toString(dDiscPrice);
	    String string_discountedAmtDisplayed = Double.toString(dDiscountedAmtDisplayed);
	    try {
	        Assert.assertEquals(string_dDiscPrice, string_discountedAmtDisplayed);
	      } catch (Error e) {
	    	  System.out.println("*** Derived discount amount not equal displayed discount amount ***");
	    	  e.printStackTrace();	
	      }
		
		Thread.sleep(3000);
		//TestUtil.takeScreenshotAtEndOfTest();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}

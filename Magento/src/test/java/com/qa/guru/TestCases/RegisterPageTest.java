package com.qa.guru.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.guru.Testbase.TestBase;
import com.qa.guru.pages.HomePage;
import com.qa.guru.pages.MobilePage;
import com.qa.guru.pages.RegisterPage;
import com.qa.guru.pages.SearchPage;
import com.qa.guru.pages.ShoppingCartPage;
import com.qa.guru.pages.TVPage;
import com.qa.guru.util.TestUtil;

public class RegisterPageTest extends TestBase {

	HomePage homePage;
	MobilePage mobilePage;
	RegisterPage registerPage;
	ShoppingCartPage shoppingCart;
	SearchPage searchPage ;
	TestUtil testUtil;
	TVPage tvPage;
	
	String sheetName = "register";
	
	   
	public RegisterPageTest(){
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
		//registerPage = homePage.clickOnAccountLink();
		registerPage = homePage.clickOnRegisterLink();
		
	}
	
	@Test(priority=1)
	public void verifyRegisterPageLabel(){
		driver.getTitle();
	}
	
	
	@DataProvider
	public Object[][] getTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=2, dataProvider="getTestData")
	public void validateRegisterInfo(String fn, String mn, String ln, String email, String pwd, String cpwd){
		
		//contactsPage.createNewContact("Sonali", "T", "Uperiya", "sonaupe@gmail.com", "SonaTeja", "SonaTeja");
		registerPage.register(fn, mn, ln, email, pwd, cpwd);
		Assert.assertEquals(registerPage.verifyRegistrationMsg(), "Thank you for registering with Main Website Store.");
	}
	
	public void clickOnRegisterLink() {
		registerPage = homePage.clickOnRegisterLink();
	}
	
//	@Test(priority=3, dataProvider="getTestData")
//	public void validateShareWishList(String fn, String mn, String ln, String email, String pwd, String cpwd){
//		
//		//contactsPage.createNewContact("Sonali", "T", "Uperiya", "sonaupe@gmail.com", "SonaTeja", "SonaTeja");
//		registerPage.register(fn, mn, ln, email, pwd, cpwd);
//		Assert.assertEquals(registerPage.verifyRegistrationMsg(), "Thank you for registering with Main Website Store.");
//		
//	}
	
}

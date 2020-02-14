package com.qa.guru.TestCases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.guru.Testbase.TestBase;
import com.qa.guru.pages.MobilePage;
import com.qa.guru.pages.SearchPage;
import com.qa.guru.pages.ShoppingCartPage;
import com.qa.guru.util.TestUtil;

public class MobilePageTest extends TestBase {

	MobilePage mobilePage;
	ShoppingCartPage shoppingCart;
	SearchPage searchPage ;
	
	public MobilePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		mobilePage = new MobilePage();
		searchPage = new SearchPage();
		//mobilePage = homePage.clickOnMobileLink();	
	}
	
	@Test(priority=1)
	public void VerifyMobilePageTitleTest()
	{
		mobilePage.clickOnMobileLink();
		String pageTitle = mobilePage.displayMobilePageTitle();
		Assert.assertEquals(pageTitle, "Mobile","Mobile page title not matched");
	}
	
	//Verify item in MobileListPage can be sorted By Name 
	@Test(priority=2)
	public void verifyProductSortedByName() throws IOException 
	{
		mobilePage.clickOnMobileLink();
		mobilePage.clickOnSortDrpdwn();
		//Verify all products are sorted by name like IPHONE , SAMSUNG GALAXY OR SONY XPERIA
		boolean flag = mobilePage.displayIphoneByName();
		Assert.assertTrue(flag);
		
		boolean flag1 = mobilePage.displaySamsungByName();
		Assert.assertTrue(flag1);
		
		boolean flag2 = mobilePage.displaySonyExperiaeByName();
		Assert.assertTrue(flag2);
		
		TestUtil.takeScreenshotAtEndOfTest();
	}
	
	@Test(priority=3)
	public void verifyClickOnAddToCartIphoneBtn() 
	{
	shoppingCart = mobilePage.clickOnAddToCartIphoneBtn();
	shoppingCart.displayShoppingCartPageTitle();
	shoppingCart.displayIphoneText();
	}
	
	@Test(priority=4)
	public void verifyClickOnAddToCartSamsungBtn() throws InterruptedException 
	{
		shoppingCart = mobilePage.clickOnAddToCartSamsungBtn();
		Thread.sleep(2000);
		shoppingCart.displayShoppingCartPageTitle();
		shoppingCart.displaySamsungText();	
	}
		
	@Test(priority=5)
	public void verifyClickOnAddToCartSonyBtn() throws InterruptedException 
	{
		shoppingCart = mobilePage.clickOnAddToCartSonyBtn();
		Thread.sleep(2000);
		shoppingCart.displayShoppingCartPageTitle();
		shoppingCart.displaySonyText();
	}
	
	@Test(priority=6)
	public void verifySonyMobilePrice() throws InterruptedException
	{
		String text= mobilePage.getSonyMobilePrice();
		Assert.assertEquals(text, "$100.00");
	}
	
	@Test(priority=7)
	public void verifySearchFunctionality() throws InterruptedException
	{
		mobilePage.searchTextBox();
		Assert.assertEquals(searchPage.searchPageResultText(), "SEARCH RESULTS FOR 'SAMSUNG'");	
	}
	
	//Verify that you are able to compare two product and Handling the PopUp window
	@Test(priority=8)
	public void verifyAddToCompareFunctionality() throws InterruptedException
	{
		String sonyMsg=mobilePage.clickOnAddToCompareSonyLink();
		Assert.assertEquals(sonyMsg, "The product Sony Xperia has been added to comparison list.");
		Thread.sleep(2000);
		
		String IphoneMsg = mobilePage.clickOnAddToCompareIphoneLink();
		Assert.assertEquals(IphoneMsg, "The product IPhone has been added to comparison list.");	
		Thread.sleep(2000);
		
		mobilePage.clickOnCompareBtn();
		Thread.sleep(2000);
//		Alert a=driver.switchTo().alert();
//		String popupMsg=a.getText(); 
//		System.out.println(popupMsg);
//		
//		Assert.assertEquals(compareHeaderInPoPUp, "COMPARE PRODUCTS");	
//		
//		mobilePage.clickOnClosePopUpWindow();
//	
		String MainWindow=driver.getWindowHandle();		
		
		// To handle all new opened window.				
            Set<String> s1=driver.getWindowHandles();		
            Iterator<String> i1=s1.iterator();		
      		
        while(i1.hasNext())			
        {		
           String ChildWindow=i1.next();		
           		
           if(!MainWindow.equalsIgnoreCase(ChildWindow))			
            {    		
       
                 // Switching to Child window
                    driver.switchTo().window(ChildWindow);	                                                                                                           
                    Alert a=driver.switchTo().alert();
					String popupMsg=a.getText(); 
					System.out.println(popupMsg);
			
					//Assert.assertEquals(compareHeaderInPoPUp, "COMPARE PRODUCTS");	
			
				mobilePage.clickOnClosePopUpWindow();	
				
				driver.close();
	}
        }
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	
	
}


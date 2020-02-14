package com.qa.guru.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guru.Testbase.TestBase;

public class AccountDashboardPage extends TestBase {

	//*[@id="nav"]/ol/li[2]/a
	@FindBy(xpath="//*[@id=\"nav\"]/ol/li[2]/a")
	WebElement TVLink;
	
	@FindBy(xpath="//a[contains(text(),'Mobile')]")
	WebElement mobileLink;

	@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div/div/ul/li/ul/li/span")
	WebElement rigistrationVerificationMsg;
	
	@FindBy(xpath="//div[@class='block-content']//a[contains(text(),'My Wishlist')]")
	WebElement mywishListLink;
	
	@FindBy(xpath="//tr[@class='first odd']//a[@class='link-reorder'][contains(text(),'Reorder')]")
	WebElement reOrderLink;
	
	@FindBy(linkText="MY ORDERS")
	WebElement myOrdersLink;
	
	//Intializing the WebElements
			public AccountDashboardPage(){
				PageFactory.initElements(driver, this);
			}
	
			public String getReistrationVerificationMsg() {
				return rigistrationVerificationMsg.getText();
			}
			public  TVPage clickOnTVPage() {
				TVLink.click();
				return new TVPage();	
			}
			public  MobilePage clickOnMobilePage() {
				mobileLink.click();
				return new MobilePage();	
			}
			
			public MyWishlistPage clcikOnMywishListLink() {
				mywishListLink.click();
				return new MyWishlistPage();
			}
			
			public MyOrdersPage clcikOnMyOrdersLink() {
				myOrdersLink.click();
				return new MyOrdersPage();
			}
			
			public ShoppingCartPage clickOnReorderLink() {
				reOrderLink.click();
				return new ShoppingCartPage();
			}
			
}

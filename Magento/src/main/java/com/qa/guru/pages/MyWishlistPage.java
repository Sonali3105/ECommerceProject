package com.qa.guru.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guru.Testbase.TestBase;

public class MyWishlistPage extends TestBase{

	@FindBy(xpath = "//span[contains(text(),'Share Wishlist')]")
	WebElement shareWishlistBtnOnMyWishListPage;
	
	@FindBy(xpath = "//span[contains(text(),'Your Wishlist has been shared.')]")
	WebElement shareWishlistMsg;
	
	@FindBy(id = "email_address")
	WebElement emailOnshareWishListPage;
	
	@FindBy(id = "message")
	WebElement msgOnshareWishListPage;
	
	@FindBy(xpath = "//button[@title='Share Wishlist']")
	WebElement shareWishListBtnOnShareWishListPage;
	
	@FindBy(xpath = ".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li/span")
	WebElement shareWishListPageMsg;
	
	@FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
	WebElement SamsungLCDAddToCartBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
	WebElement addToCartTV;
	
	
	
	
	public MyWishlistPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnshareWishListBtn() {
		shareWishlistBtnOnMyWishListPage.click();
	}
	
	public void enterShareWishListInfo() {
		emailOnshareWishListPage.sendKeys("sonateja@gmail.com");
		msgOnshareWishListPage.sendKeys("Hello this is nice LCD check it out !");
		shareWishListBtnOnShareWishListPage.click();
	}

	public String verifyShareEmailMsg() {
		return shareWishListPageMsg.getText();	
	}
	
	
	public String verifyShareWishlistMsg() {
		return shareWishlistMsg.getText();
	}
	
	public ShoppingCartPage clickOnAddToCartSamsungTV() {
		SamsungLCDAddToCartBtn.click();
		return new ShoppingCartPage();
	}
	
	
	
	
	
}

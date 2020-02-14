package com.qa.guru.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guru.Testbase.TestBase;

public class shareWishListPage extends TestBase {

	@FindBy(id = "email_address")
	WebElement emailOnshareWishListPage;
	
	@FindBy(id = "message")
	WebElement msgOnshareWishListPage;
	
	@FindBy(xpath = "//button[@title='Share Wishlist']")
	WebElement shareWishListBtnOnShareWishListPage;
	
	@FindBy(xpath = ".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li/span")
	WebElement shareWishListPageMsg;
	
	
	
	public shareWishListPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnShareWishList() {
		emailOnshareWishListPage.sendKeys("sonateja@gmail.com");
		msgOnshareWishListPage.sendKeys("Hello this is nice LCD check it out !");
		shareWishListBtnOnShareWishListPage.click();
	}


	public String verifyShareEmailMsg() {
		return shareWishListPageMsg.getText();
		
	}
	
	
	
}

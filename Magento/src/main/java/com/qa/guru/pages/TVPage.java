package com.qa.guru.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guru.Testbase.TestBase;

public class TVPage extends TestBase {

	
	
	@FindBy(xpath = "//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/ul/li[1]/a")
	WebElement LGAddToWishlist;
	
	
	@FindBy(xpath = "//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/ul/li[1]/a")
	WebElement addToWishListOnLGLCD; 
	//Intializing the WebElements
			public TVPage(){
				PageFactory.initElements(driver, this);
			}
			
			public MyWishlistPage clcikOnAddToWishListLG() {
				addToWishListOnLGLCD.click();
				return new MyWishlistPage();
			}
			
}

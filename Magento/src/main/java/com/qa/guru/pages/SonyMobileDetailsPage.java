package com.qa.guru.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guru.Testbase.TestBase;

public class SonyMobileDetailsPage extends TestBase{
	
	@FindBy(xpath="//a[contains(text(),'Mobile')]")
	WebElement mobileLinkOnHomePage;
	
	@FindBy(xpath=".//*[@id='product-price-1']/span")
	WebElement SonyPrice;
	
	@FindBy(xpath="//img[@alt='Xperia']")
	WebElement SonyImg;
	
	public SonyMobileDetailsPage(){
		PageFactory.initElements(driver, this);
	}

	public  String displaySonyMobilePageTitle() {
		// TODO Auto-generated method stub
		SonyImg.click();
		return driver.getTitle();	
	}
	
	public String getSonyMobilePrice() {
		return SonyPrice.getText();
	}
	

}

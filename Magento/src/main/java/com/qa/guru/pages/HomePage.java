package com.qa.guru.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guru.Testbase.TestBase;

public class HomePage extends TestBase{

	// Page factory
	
	@FindBy(xpath="//a[contains(text(),'Mobile')]")
	WebElement mobileLink;
	
	@FindBy(xpath="//a[contains(text(),'TV')]")
	WebElement TVLink;
	
	@FindBy(xpath="//span[contains(text(),'Cart')]")
	WebElement cartLink;
	
	@FindBy(xpath="//div[@class='paypal-logo']//a//img")
	WebElement paypal;
	
	@FindBy(xpath="//a[contains(text(),'About Us')]")
	WebElement aboutUsLink;
	
	@FindBy(xpath="//a[contains(text(),'Customer Service')]")
	WebElement customerService;
	
	@FindBy(xpath="//a[contains(text(),'Privacy Policy')]")
	WebElement privacyPolicy;
	
	@FindBy(xpath="//div[@class='footer-container']//div[3]//ul[1]//li[1]")
	WebElement siteMapLink;
	
	@FindBy(xpath="//div[@class='footer']//a[contains(text(),'My Account')]")
	WebElement myAccountLink;
	
	@FindBy(xpath="//a[contains(text(),'Orders and Returns')]")
	WebElement ordersAndReturnsLink;
	
	@FindBy(xpath="//input[@id='search']")
	WebElement searchTextBox;
	
	@FindBy(xpath="//span[@class='label'][contains(text(),'Account')]")
	WebElement accountLink;
	
	@FindBy(xpath="//div[@id='header-account']//a[contains(text(),'My Account')]")
	WebElement myAccountLinkunderAccount;
	
	@FindBy(xpath="//a[contains(text(),'Register')]")
	WebElement registerLinkunderAccount;
	
	//Intializing the WebElements
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String displayHomePageTitle() {
		return driver.getTitle();	
	}
	
	public MobilePage clickOnMobileLink() {
		mobileLink.click();
		return new MobilePage(); 
	}
	
	public SearchPage searchTextBox()
	{
		searchTextBox.sendKeys("Samsung" + Keys.ENTER);
		//searchBtn.click();
		return new SearchPage();	
	}
	
	public void clickOnAccountLink() 
	{
		accountLink.click();
	}
	
	public RegisterPage clickOnRegisterLink()
	{
		accountLink.click();
		registerLinkunderAccount.click();
		return new RegisterPage();
	}
	
	public LoginPage clcikOnMyAccountLink() {
		accountLink.click();
		myAccountLinkunderAccount.click();
		return new LoginPage();
	}
	
	
}

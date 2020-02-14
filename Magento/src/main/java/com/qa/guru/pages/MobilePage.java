package com.qa.guru.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.guru.Testbase.TestBase;

public class MobilePage extends TestBase {
	
		// Page factory
		@FindBy(xpath="//a[contains(text(),'Mobile')]")
		WebElement mobileLink;
	
		@FindBy(xpath="//body[contains(@class,'catalog-category-view categorypath-mobile-html category-mobile')]/div[@class='wrapper']/div[@class='page']/div[@class='main-container col3-layout']/div[@class='main']/div[@class='col-wrapper']/div[@class='col-main']/div[@class='category-products']/div[@class='toolbar']/div[@class='sorter']/div[@class='sort-by']/select[1]")
		WebElement sortByDrpdwn;
		
		@FindBy(xpath="//a[contains(text(),'Sony Xperia')]")
		WebElement sonyExperia;
		
		@FindBy(xpath="//a[contains(text(),'Samsung Galaxy')]")
		WebElement Samsung;
		
		@FindBy(xpath="//h2[@class='product-name']//a[contains(text(),'IPhone')]")
		WebElement IPhone;
		
		@FindBy(xpath=".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/button")
		WebElement addToCartIPhone;
		
		@FindBy(xpath=".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/button")
		WebElement addToCartSamsung;
		
		@FindBy(xpath=".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/button")
		WebElement addToCartSony;
		
		@FindBy(xpath=".//*[@id='product-price-1']/span")
		WebElement SonyPrice;
		
		@FindBy(xpath=".//*[@id='product-price-2']/span")
		WebElement IphonePrice;
		
		@FindBy(xpath=".//*[@id='product-price-3']")
		WebElement SamsungPrice;
		
		@FindBy(xpath="//img[@alt='Xperia']")
		WebElement SonyImg;
		
		@FindBy(xpath="//img[@alt='IPhone']")
		WebElement IphoneImg;
		
		@FindBy(xpath="//img[@alt='Samsung Galaxy']")
		WebElement SamsungImg;
		
		@FindBy(xpath="//input[@id='search']")
		WebElement searchTextBox;
		
		@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/ul/li[2]/a")
		WebElement addToCompareSony;
		
		@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a")
		WebElement addToCompareIphone;
		
		@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/ul/li[2]/a")
		WebElement addToCompareSamsung;
		
		@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/ul/li/ul/li/span")
		WebElement compareMsg;
		
		@FindBy(xpath="//button[@class='button']//span//span[contains(text(),'Compare')]")
		WebElement compareBtn;
	
		@FindBy(xpath="//*[@id=\"top\"]/body/div/div[2]/button/span/span")
		WebElement closePopUpBtn;
		
		@FindBy(xpath="//*[@id=\"top\"]/body/div/div[1]/h1")
		WebElement compareProductsHeaderInPopUp;
		
		@FindBy(xpath="//button[@class='button search-button']")
		WebElement searchBtn;
		
		//Intializing the WebElements
		
		public MobilePage(){
			PageFactory.initElements(driver, this);
		}
		
		public String displayMobilePageTitle() {
			return driver.getTitle();	
		}
		
		public void clickOnMobileLink() {
			mobileLink.click();
		}
		
		public void clickOnSortDrpdwn() {
			//select ‘SORT BY’ dropdown as ‘name’
			Select select = new Select(sortByDrpdwn);
			select.selectByVisibleText("Name");	
		}
	
		public boolean displayIphoneByName() {
			return IPhone.isDisplayed();
		}
		
		public boolean displaySamsungByName() {
			return Samsung.isDisplayed();
		}
		
		public boolean displaySonyExperiaeByName() {
			return sonyExperia.isDisplayed();
		}
		
		public ShoppingCartPage clickOnAddToCartIphoneBtn()
		{
			mobileLink.click();
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", addToCartIPhone);
			//addToCartIPhone.click();
			return new ShoppingCartPage(); 
		}
		
		public ShoppingCartPage clickOnAddToCartSamsungBtn()
		{
			mobileLink.click();
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", addToCartSamsung);
			//addToCartSamsung.click();
			return new ShoppingCartPage(); 
		}

		public ShoppingCartPage clickOnAddToCartSonyBtn() {
			mobileLink.click();
			addToCartSony.click();
			return new ShoppingCartPage(); 
		}
		
		public String getSonyMobilePrice() {
			mobileLink.click();
			return SonyPrice.getText();
		}
		public SonyMobileDetailsPage clickOnSonyImage()
		{
			mobileLink.click();
			SonyImg.click();
			return new SonyMobileDetailsPage();
		}
		
		public SearchPage searchTextBox()
		{
			searchTextBox.sendKeys("Samsung" + Keys.ENTER);
			//searchBtn.click();
			return new SearchPage();	
		}
		
		public String clickOnAddToCompareSonyLink() {
			mobileLink.click();
			addToCompareSony.click();
			return compareMsg.getText();
		}
		public String clickOnAddToCompareIphoneLink() {
			mobileLink.click();
			addToCompareIphone.click();
			return compareMsg.getText();
		}
		public void clickOnCompareBtn() {
			compareBtn.click();	
			//return compareProductsHeaderInPopUp.getText();	
		}
		public void clickOnClosePopUpWindow() {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", closePopUpBtn);
			closePopUpBtn.click();
			
		}
}

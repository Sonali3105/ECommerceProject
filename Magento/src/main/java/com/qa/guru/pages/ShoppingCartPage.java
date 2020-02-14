package com.qa.guru.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guru.Testbase.TestBase;

public class ShoppingCartPage extends TestBase {


			// Page factory
			@FindBy(xpath="//span[contains(text(),'Sony Xperia was added to your shopping cart.')]")
			WebElement SonyXperiaText;
			
			@FindBy(xpath="//span[contains(text(),'IPhone was added to your shopping cart.')]")
			WebElement IphoneText;
			
			@FindBy(xpath="//span[contains(text(),'Samsung Galaxy was added to your shopping cart.')]")
			WebElement SamsungText;
			
			@FindBy(xpath="//span[contains(text(),'Samsung LCD was added to your shopping cart.')]")
			WebElement SamsungTVText;
		
			@FindBy(xpath="//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/input")
			WebElement qtyTextBox;
			
			@FindBy(xpath="//td[@class='product-cart-actions']//button[@name='update_cart_action']//span//span[contains(text(),'Update')]")
			WebElement updateBtn;
			
			@FindBy(xpath="//span[contains(text(),'Some of the products cannot be ordered in requeste')]")
			WebElement verificationErrMsg;
			
			@FindBy(xpath="//*[@id=\"empty_cart_button\"]/span/span")
			WebElement emptyCartBtn;
			
			@FindBy(xpath="//h1[contains(text(),'Shopping Cart is Empty')]")
			WebElement emptyVerificationMsg;
			
			@FindBy(xpath="//li[@class='method-checkout-cart-methods-onepage-bottom']//button[@class='button btn-proceed-checkout btn-checkout']//span//span[contains(text(),'Proceed to Checkout')]")
			WebElement proceedToCheckOutBtn;
			
			@FindBy(xpath="//tbody//span[@class='price'][contains(text(),'$7,615.00')]")
			WebElement grandTotal;
			
			 
			@FindBy(xpath=".//*[@id='shopping-cart-totals-table']/tbody/tr[1]/td[2]/span")
			WebElement SubTot;
		    
		    // this is the discount amount displayed (e.g. $50.00)
			@FindBy(xpath=".//*[@id='shopping-cart-totals-table']/tbody/tr[2]/td[2]/span")
			WebElement DiscDisp ;
			
		    // this is the Generated discount amount displayed (e.g. $475.00)
			@FindBy(xpath =".//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span")
			WebElement DiscountedAmtDisplayed ;
			
			@FindBy(xpath="//div[@class='button-wrapper']//button[@class='button2']")
			WebElement discountCodeApplyLink;
			
			@FindBy(xpath="//input[@id='coupon_code']")
			WebElement discountCodeTextbox;
			
			
			@FindBy(xpath="//span[contains(text(),'-$25.00')]")
			WebElement discountPercentage;
			
			//Intializing the WebElements
	
			public ShoppingCartPage(){
				PageFactory.initElements(driver, this);
			}
	

			public String displayShoppingCartPageTitle() {
				return driver.getTitle();	
			}
			
			public boolean displayIphoneText()
			{
				
				return IphoneText.isDisplayed();
			}
			
			public boolean displaySamsungText()
			{
				return SamsungText.isDisplayed();
			}
	
			public boolean displaySonyText()
			{
				return SonyXperiaText.isDisplayed();
			}
			
			public String editQty()
			{
				qtyTextBox.clear();
				qtyTextBox.sendKeys("1000");
				updateBtn.click();
				return verificationErrMsg.getText();
			}
			
			public String  emptyCart()
			{
				emptyCartBtn.click();
				return emptyVerificationMsg.getText();
			}
			
			public String displaySamsungTVText()
			{
				return SamsungTVText.getText();
			}
			
			public void updateQty()
			{
				qtyTextBox.clear();
				qtyTextBox.sendKeys("10");
				updateBtn.click();	
			}
			
			public CheckoutPage clcikOnProceedToCheckoutBtn() {
				proceedToCheckOutBtn.click();
				return new CheckoutPage();
			}
			
			public void enterDiscountCoupon() {
				discountCodeTextbox.clear();
				discountCodeTextbox.sendKeys("GURU50");
				discountCodeApplyLink.click();
			}
			
			public String displaySubTotalAmt() {
				org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", SubTot);
				// this is the Sub Total amount displayed (e.g. $500.00)
				  String vSubTot =SubTot.getText().trim(); 
				  // Remove the $ sign 
				    String sSubTot = vSubTot.replaceAll("\\$", " ");   // e.g. $500.00
				 // trim the String variables to get it ready for calculation
			     return  sSubTot.trim();   // e.g. $500.00	    
			}
			
			public String displayDiscAmt() {
				org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", DiscDisp);
				// this is the discount amount displayed (e.g. $50.00)
			    String vDiscDisp = DiscDisp.getText().trim();
			    // Remove the $ sign 
                String sDiscDisp = vDiscDisp.replaceAll("\\$", " ");            // e.g. $25.00	 
                // Remove the - negative sign
		        String sNegDisc = sDiscDisp.replaceAll("\\-", " ");              // e.g. -25.00
		        // trim the String variables to get it ready for calculation
		       return sNegDisc.trim();                              // e.g. $25.00	
			}
			
			public String displayGrandTotalAmt() {
				org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", DiscountedAmtDisplayed);
				 // this is the Generated discount amount displayed (e.g. $475.00)
			    String vDiscountedAmtDisplayed = DiscountedAmtDisplayed.getText().trim();
			    // Remove the $ sign  
		        String sDiscountedAmtDisplayed = vDiscountedAmtDisplayed.replaceAll("\\$", " "); 
		        // trim the String variables to get it ready for calculation      
		        return sDiscountedAmtDisplayed.trim(); // e.g. $475.00  
			}
			
		public void clickOnCheckoutBtn() {
			proceedToCheckOutBtn.click();
		}
		
		public Boolean displayDiscountedPercentage() {
				org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", discountPercentage);
				 return discountPercentage.isDisplayed();
		}
			
			
	
}

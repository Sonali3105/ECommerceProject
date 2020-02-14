package com.qa.guru.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guru.Testbase.TestBase;

public class CheckoutPage extends TestBase {
	
				// Page factory
				@FindBy(id="billing:firstname")
				WebElement fn;
				
				@FindBy(id="billing:middlename")
				WebElement mn;
				
				@FindBy(id="billing:lastname")
				WebElement ln;
				
				@FindBy(id="billing:street1")
				WebElement address;
				
				@FindBy(id="billing:city")
				WebElement city;
				
				@FindBy(id="billing:region_id")
				WebElement state;
				
				@FindBy(id="billing:postcode")
				WebElement zip;
				
				@FindBy(id="billing:country_id")
				WebElement country;
				
				@FindBy(id="billing:telephone")
				WebElement phone;
				
				@FindBy(xpath="//div[@id='billing-buttons-container']//button[@class='button']//span//span[contains(text(),'Continue')]")
				WebElement continueBtnForBillingInfo;
				
				@FindBy(xpath="//input[@id='billing:use_for_shipping_yes']")
				WebElement shipToThisAddressRadio;
				
				@FindBy(xpath="//span[contains(text(),'$5.00')]")
				WebElement fixedRate$5;
				
				@FindBy(xpath="//div[@id='shipping-method-buttons-container']//button[@class='button']//span//span[contains(text(),'Continue')]")
				WebElement continueBtnForShippingMethod;
				
				@FindBy(id="p_method_checkmo")
				WebElement checkRadio;
				
				@FindBy(xpath="//div[@id='payment-buttons-container']//button[@class='button']//span//span[contains(text(),'Continue')]")
				WebElement continueBtnForPaymentInfo;
				
				@FindBy(xpath="//h1[contains(text(),'Your order has been received.')]")
				WebElement orderConfirmationMsg;
				
				@FindBy(css="body.checkout-onepage-index:nth-child(2) div.wrapper div.page:nth-child(2) div.main-container.col2-right-layout div.main div.col-main ol.opc.opc-firststep-billing:nth-child(5) li.section.allow.active:nth-child(5) div.step.a-item div.order-review div:nth-child(2) div.buttons-set > button.button.btn-checkout")
				WebElement placeOrderBtn;
				
				//Intializing the WebElements
				
				public CheckoutPage(){
					PageFactory.initElements(driver, this);
				}
		
				public String displayCheckoutPageTitle() {
					return driver.getTitle();	
				}
				
				public void enterShippingInfo() {
					fn.clear();
					fn.sendKeys("Sonali");
					mn.clear();
					mn.sendKeys("H");
					ln.clear();
					ln.sendKeys("Patel");
					address.sendKeys("Jan Rd");
					city.sendKeys("Etobicoke");
					state.sendKeys("Ontario" + Keys.ENTER);
					zip.sendKeys("M5K6L3");
					country.sendKeys("Canada"+ Keys.ENTER);
					phone.sendKeys("123456789");
					continueBtnForBillingInfo.click();
				}
				public String diplayFixedRate() {
					return fixedRate$5.getText();
				}
				
				public void clcikOnShippingAndPaymentMethod() {
					continueBtnForShippingMethod.click();
					checkRadio.click();
					continueBtnForPaymentInfo.click();
				}
				
				public void clickOnAllContinueBtn() {
					shipToThisAddressRadio.click();
					continueBtnForBillingInfo.click();
					continueBtnForShippingMethod.click();
					checkRadio.click();
					continueBtnForPaymentInfo.click();
				}
				
				public String clickOnPlaceOrderBtn() {
					org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView(true);", placeOrderBtn);
					 placeOrderBtn.click();
					return orderConfirmationMsg.getText(); // YOUR ORDER HAS BEEN RECEIVED.
				}
				
				
}

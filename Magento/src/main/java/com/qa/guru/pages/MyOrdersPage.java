package com.qa.guru.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.guru.Testbase.TestBase;

public class MyOrdersPage extends TestBase {

	@FindBy(xpath="//a[contains(text(),'View Order')]")
	WebElement viewOrdersLink;
	
	@FindBy(css="h1")
	WebElement recentOrdersText;
	
	@FindBy(xpath="//a[@class='link-print']")
	WebElement printOrdersLink;
	
	@FindBy(xpath="//*[@id=\"destinationSelect\"]//select")
	WebElement selectDestination;
	
	@FindBy(xpath="//*[@id=\"sidebar\"]//print-preview-button-strip//cr-button[1]")
	WebElement saveBtnOnPrintPage;
	
	
	@FindBy(xpath="//a[@class='link-reorder']")
	WebElement reOrderLink;
	
	public MyOrdersPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnViewOrdersLink() {
		viewOrdersLink.click();
	}
	
	public String getRecentOrdersText() {
		return recentOrdersText.getText();
	}
	
	public void clickOnPrintOrdersLink() {
		printOrdersLink.click();
		saveBtnOnPrintPage.click();
	}
	
	public ShoppingCartPage clickOnReorderLink() {
		reOrderLink.click();
		return new ShoppingCartPage();
	}
	
	
}

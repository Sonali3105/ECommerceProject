package com.qa.guru.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.guru.Testbase.TestBase;

public class SearchPage  extends TestBase{
	
	
	
	// Page factory
			@FindBy(xpath="//a[contains(text(),'Mobile')]")
			WebElement mobileLink;
		
			@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[2]/div[1]/h1")
			WebElement searchResultForProductLabel;
			
			public SearchPage(){
				PageFactory.initElements(driver, this);
			}
			
			public String displaySearchPageTitle() {
				return driver.getTitle();	
			}
			
			public String searchPageResultText() {
				return searchResultForProductLabel.getText();
			}

}

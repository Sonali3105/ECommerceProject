package com.qa.guru.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guru.Testbase.TestBase;

public class LoginPage extends TestBase {


	// Page factory
	
	@FindBy(id="email")
	WebElement emailTextBox;
	
	@FindBy(id="pass")
	WebElement passTextBox;
	
	@FindBy(id="send2")
	WebElement loginBtn;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String displayLoginPageTitle() {
		return driver.getTitle();	
	}
	
	public AccountDashboardPage clickOnLoginBtn(String Email, String Password) {
		emailTextBox.sendKeys(Email);
		passTextBox.sendKeys(Password);
		loginBtn.click();
		return new AccountDashboardPage(); 
	}

	
//	public MyOrdersPage clickOnLoginBtn(String Email, String Password) {
//		emailTextBox.sendKeys(Email);
//		passTextBox.sendKeys(Password);
//		loginBtn.click();
//		return new AccountDashboardPage(); 
//}

}
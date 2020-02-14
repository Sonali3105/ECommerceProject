package com.qa.guru.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guru.Testbase.TestBase;

public class RegisterPage extends TestBase {
	// Page factory
	
		@FindBy(xpath="//input[@id='firstname']")
		WebElement firstnameTextbox;
		
		@FindBy(xpath="//input[@id='middlename']")
		WebElement middlenameTestbox;
		
		@FindBy(xpath="//input[@id='lastname']")
		WebElement lastnameTextbox;

		@FindBy(xpath="//input[@id='email_address']")
		WebElement emailTextbox;
		
		@FindBy(xpath="//input[@id='password']")
		WebElement passwordTextbox;
		
		@FindBy(xpath="//input[@id='confirmation']")
		WebElement confirmPwdTextBox;
		
		@FindBy(xpath="//span[contains(text(),'Register')]")
		WebElement registerBtn;
		
		
//		@FindBy(xpath="//span[contains(text(),'Thank you for registering with Main Website Store.')]")
//		WebElement registrationConfirmationMsg;
		
		
		@FindBy(xpath=".//*[@id='top']/body/div[1]/div/div[1]/div/p")
		WebElement registrationConfirmationMsg;
		
		
		//Intializing the WebElements
		public RegisterPage(){
			PageFactory.initElements(driver, this);
		}
		
		public String displayRegisterPageTitle() {
			return driver.getTitle();	
		}
		
		
		public void register(String fn, String mn, String ln, String email, String pwd, String cpwd)
		{
			firstnameTextbox.sendKeys(fn);
			middlenameTestbox.sendKeys(mn);
			lastnameTextbox.sendKeys(ln);
			emailTextbox.sendKeys(email);
			passwordTextbox.sendKeys(pwd);
			confirmPwdTextBox.sendKeys(cpwd);
			//registerBtn.click();
		}
		
		public AccountDashboardPage clickOnRegisterBtn() {
			registerBtn.click();
			 return new AccountDashboardPage();
		}
		public String verifyRegistrationMsg()
		{
			 //String vWelcome = ("WELCOME, " + fn + " " + ln + "!");
			return registrationConfirmationMsg.getText();
			
		}
		
}

package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//demo site - https://www.saucedemo.com/
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		/*What is Page Factory in Selenium? 
		Page Factory is a class provided by Selenium WebDriver to implement the Page Object Model. 
		The Page Object Repository is separated from the Test Methods using the Page Factory concept. 
		Using it, you can initialize the Page Objects or directly instantiate them.
		@FindBy
		@FindBys - AND conditions
		@FindAll - OR conditions
		*/
		
	}
	
	//@FindBy(how = How.name, using = "userName")
	@FindBy(name="user-name")
	WebElement txtUserName;
	
	@FindBy(xpath="//input[@id=\"password\"]")
	WebElement txtPassword;
	
	@FindBy(name="login-button")
	WebElement btnLogin;
	
	
	@FindBy(xpath="//button[contains(text(),\"Open Menu\")]")
	WebElement btnMenu;
	
	@FindBy(xpath="//a[contains(text(),\"Logout\") and @tabindex =\"0\"]")
	WebElement btnLogout;
	
	//action methods
	
	public void setUserName(String name) {
		txtUserName.sendKeys(name);
	}
	public void clearUserName() {
		
		txtUserName.clear();
	}
	
	public void setPassword(String password) {
		//first click and then clear the password.
		Actions action = new Actions(ldriver);
		action.moveToElement(txtPassword).doubleClick().click().build().perform();
		txtPassword.sendKeys(password);
	}
	public void clearPassword() {
		txtPassword.clear();
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	public void clickMenu() {
		btnMenu.click();
	}
	
	public void clickLogout() {
		btnLogout.click();
	}

}

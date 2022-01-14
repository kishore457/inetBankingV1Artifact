package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	WebDriver ldriver;
	public ProductsPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how=How.XPATH, using="//div[text()=\"Sauce Labs Backpack\"]/following::button[1]")
	@CacheLookup
	WebElement btnAddToCartBackpack;
	
	@FindBy(how=How.XPATH,using="//div[text()=\"Sauce Labs Bike Light\"]/following::button[1]")
	@CacheLookup
	WebElement btnAddToCartBikeLight;
	
	@FindBy(how=How.XPATH,using="//a[@class=\"shopping_cart_link\"]")
	@CacheLookup
	WebElement lnkCart;
	
	//Action methods
	
	public void clickAddToCartBackpack() {
		btnAddToCartBackpack.click();
	}
	
	public void clickAddToCartBikeLight() {
		btnAddToCartBikeLight.click();
	}
	
	public void clickCartIcon() {
		lnkCart.click();
	}
	

}

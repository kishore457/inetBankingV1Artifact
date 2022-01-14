package com.inetBanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.pageObjects.ProductsPage;

public class TC_AddProductsTest_003 extends BaseClass{

	@Test
	public void addProductsToCart() throws InterruptedException, IOException{
		//interrupted exception due to thread.sleep method.
		//IO exception for screenshot script.
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickLogin();
		
		Thread.sleep(2000);
		
		ProductsPage pp = new ProductsPage(driver);
		pp.clickAddToCartBackpack();
		pp.clickAddToCartBikeLight();
		pp.clickCartIcon();
		String randomemail = randomString()+"@yahoo.com";
		System.out.println(randomemail);
		boolean res = driver.getPageSource().contains("Your Cart");
		if(res==true) {
			Assert.assertTrue(true);
		}else {
			captureScreen(driver,"AddProductsTest");
			Assert.assertTrue(false);
		}
	}
	
	
	
	
	
}

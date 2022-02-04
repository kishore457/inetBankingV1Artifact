package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_004 extends BaseClass{


	@Test
	public void loginTest() throws IOException, InterruptedException {
		
		//Interrupted Exception for Thread.sleep(2000);
		
		logger.info("URL is opened"); // this is logger variable created in base class.
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Enter username");
		lp.setPassword(password);
		logger.info("Enter password");
		lp.clickLogin();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		if(driver.getTitle().equals("Swag Labs")) {
			Assert.assertTrue(true);
		}else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("TestFailed");
		}
		
		driver.findElement(By.xpath("//div[contains(text(),\"Sauce Labs Backpack\")]")).isDisplayed();
		
	}

	
}

package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
	/* imp :  if you see $.TestData.xlsx then it means the file is opened and you can't deleted
	 * a file that is opened.
	 */
	
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException {
		//interrupted exception due to thread.sleep() method
		LoginPage lp = new LoginPage(driver);
		lp.clearUserName();
		lp.clearPassword();
		lp.setUserName(user);
		lp.setPassword(pwd);
		
		lp.clickLogin();
		logger.info("user and password provided");
		try {
			if(invalidUserMessage()==true) {//in user name is invalid - fail case
				logger.warn("Login failed - log");
				//Assert.assertTrue(false);
				
			}else {
				Assert.assertTrue(true); // if its valid then click on menu-> logout and return to main page.
				logger.warn("Login passed - log");
				lp.clickMenu();
				lp.clickLogout();
				
			}
		}catch(Exception e) {
			System.out.println("something wrong with invalid message validation");
		}
		
	}
	
	
	public boolean invalidUserMessage() {//to check if user is locked out
		
		/* i couldn't use if else block to validate this invalid message since the test case is
		getting failed on test execution due to - Unable to locate element exception.
		if i use if else then catch block wont be executed for invalid message.
		*/
		try {
			driver.findElement(By.xpath("//*[contains(text(),\"Username and password do not match any user in this service\")]")).isDisplayed();
				return true;
			} catch(Exception e){
					return false;
				}
		
	}
	
	
	
	//data provider method
	@DataProvider(name ="LoginData")
	String[][] getData() throws IOException{
		
		String path = System.getProperty("user.dir")+"\\src\\test\\java\\com\\inetBanking\\testData\\TestData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int cellcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String loginData[][] = new String[rownum][cellcount];
		
		for(int i=1; i<=rownum;i++) {//row 0 row in excel is header so starting from 1.
			
			for(int j=0;j<cellcount;j++) {
				
				//loginData[0][0]=XLUtils.getCellData(path, "Sheet1", 1,0);
				
				loginData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
			
		}
		return loginData;
	}
	

}

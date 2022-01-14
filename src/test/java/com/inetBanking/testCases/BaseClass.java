package com.inetBanking.testCases;


import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;

public class BaseClass {
	//I have added a comment in github. :)
	
	//it contains all the common thing used in test case.
	
	//common variables
	
	ReadConfig readconfiguration = new ReadConfig();
	public String baseURL = readconfiguration.getApplicationURL();
	public String username = readconfiguration.getUsername();
	public String password =readconfiguration.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters({"browser"})
	@BeforeClass
	public void setUp(String browserToLaunch) {
		//3.System.setProperty("webdriver.chrome.driver", readconfiguration.getChromepath());
		//2.System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe"
	//1.System.getProperty("user.dir") = C:\\Users\\Kiran G\\Desktop\\Kishore\\inetBankingV1Artifact
		
		logger = Logger.getLogger("TC_LoginTest_001");
		PropertyConfigurator.configure("log4j.properties");
		
		if(browserToLaunch.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", readconfiguration.getChromepath());
			//readconfiguration.getChromepath()
			driver = new ChromeDriver();
		}else if(browserToLaunch.equals("edge")) {
			System.setProperty("webdriver.edge.driver", readconfiguration.getEdgepath());
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURL);
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	//generate random email
		public String randomString() {
			
			String generatedString = RandomStringUtils.randomAlphabetic(10);//create a string with 10 characters.
			return generatedString;
		}
		//generate random num
	public String randomNum() {
			String generatedNum = RandomStringUtils.randomNumeric(5);//create a int with 5 characters.
			return generatedNum;
			
		}
		

}

/*Prerequisites of extent reports : 
 * 1. Jar files
 * 2. extent-config.xml file
 * 3. listner (Reporting.java) - > utility file
 * */

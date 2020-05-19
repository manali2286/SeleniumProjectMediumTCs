package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginRegUserPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_002_LoginRegUser {

	private WebDriver driver;
	private String baseUrl;
	public LoginRegUserPOM loginRegUserPOM;
	private static Properties properties;
	private ScreenShot screenShot;

		@BeforeClass
		public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
		}

		@BeforeMethod
		public void setUp() throws Exception {
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			loginRegUserPOM = new LoginRegUserPOM(driver);
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver);
			// open the browser
			driver.get(baseUrl);
			Thread.sleep(3000);
		}

		
		 @AfterClass public void tearDown() throws Exception { Thread.sleep(1000);
		 driver.quit(); }
		 

		@Test
		public void regUserLoginTest() throws InterruptedException {
			//driver.findElement(By.xpath("//a[@class='sign-in']")).click();
			loginRegUserPOM.clickSignInLink();
			Thread.sleep(4000);
			loginRegUserPOM.sendUserName("manali2286");			
			loginRegUserPOM.sendPwd("Star2211");
			loginRegUserPOM.clickSignInBtn();
			
			screenShot.captureScreenShot("TC002");
		}


	}



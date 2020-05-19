package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddPropertyPOM;
import com.training.pom.LoginRegUserPOM;
import com.training.pom.REPropertiesPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import junit.framework.Assert;

public class RETC_031_AddNewProperty {

	private WebDriver driver;
	private String baseUrl;
	private LoginRegUserPOM loginRegUserPOM;
	private REPropertiesPOM rePropertiesPOM;
	private AddPropertyPOM addPropertyPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeClass
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginRegUserPOM = new LoginRegUserPOM(driver);
		rePropertiesPOM = new REPropertiesPOM(driver);
		addPropertyPOM = new AddPropertyPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		Thread.sleep(10000);
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test(priority = 0)
	public void adminLoginTest() throws InterruptedException {
		loginRegUserPOM.clickSignInLink();
		Thread.sleep(4000);
		loginRegUserPOM.sendUserName("admin");
		loginRegUserPOM.sendPwd("admin@123");
		loginRegUserPOM.clickSignInBtn();
		Thread.sleep(4000);
		screenShot.captureScreenShot("TC31_login");
		System.out.println(" TC31_login Screenshot captured!");
	}

	@Test(priority = 1)
	public void clickPropertiesTest() throws InterruptedException {
		rePropertiesPOM.clickPropertiesLink();
		Thread.sleep(5000);
		rePropertiesPOM.clickAddNewLink();
		screenShot.captureScreenShot("TC31_addNewPropertieslink");
		System.out.println(" TC31_addNewPropertieslink Screenshot captured!");
	}

	@Test(priority = 2)
	public void addNewPropertyTest() throws InterruptedException {
		addPropertyPOM.sendTitle("new launch");
		addPropertyPOM.sendText("new launch");
		addPropertyPOM.sendPrice("80000.00");
		addPropertyPOM.sendPriceSqFt("400.00");
		addPropertyPOM.clickMainTab();
		addPropertyPOM.sendStatus("New");
		addPropertyPOM.sendLocation("DLF");
		addPropertyPOM.sendPossession("immediate");
		addPropertyPOM.clickLocationTab();
		addPropertyPOM.sendAdr("Hoshiarpur");
		addPropertyPOM.sendGMapAdr("Hoshiarpur");
		addPropertyPOM.sendLatitude("120");
		addPropertyPOM.sendLongitude("56");
		addPropertyPOM.clickDetailsTab();
		addPropertyPOM.sendStoreRoom("2");

		// Scroll down to Checkbox
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", addPropertyPOM.keywordTag);
		if (addPropertyPOM.keywordTag.isDisplayed()) {
			System.out.println("Element is visible");
		} else {
			System.out.println("Element is InVisible");
		}
		Thread.sleep(4000);
		addPropertyPOM.clickCBloreCheckBox();
		Thread.sleep(3000);

		// Scroll up to Publish button
		js.executeScript("arguments[0].scrollIntoView(true);", addPropertyPOM.keywordTag);
		Thread.sleep(4000);

		Actions act = new Actions(driver);
		act.moveToElement(addPropertyPOM.publishBtn).click(addPropertyPOM.publishBtn).build().perform();
		Thread.sleep(8000);

		String expMsg = "Post published";
		String actMsg = addPropertyPOM.getPostMsg();
		Assert.assertTrue(actMsg.contains(expMsg));

		// Capture screenshot
		screenShot.captureScreenShot("TC31_post published");
		System.out.println(" TC31_post published captured!");

	}
}

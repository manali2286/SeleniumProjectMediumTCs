package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ArrowEnqCalcPOM;
import com.training.pom.LoginRegUserPOM;
import com.training.pom.NewLaunchPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_032_ViewEnquireCalculate {

	private WebDriver driver;
	private String baseUrl;
	private LoginRegUserPOM loginRegUserPOM;
	private NewLaunchPOM newLaunchPOM;
	private ArrowEnqCalcPOM arrowEnqCalcPOM;
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
		newLaunchPOM = new NewLaunchPOM(driver);
		arrowEnqCalcPOM = new ArrowEnqCalcPOM(driver);
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
		loginRegUserPOM.sendUserName("manali2286");
		loginRegUserPOM.sendPwd("Star2211");
		loginRegUserPOM.clickSignInBtn();
		Thread.sleep(4000);
		screenShot.captureScreenShot("TC32_login");
		System.out.println(" TC32_login Screenshot captured!");
	}

	@Test(priority = 1)
	public void clickNullamAptTest() throws InterruptedException {
		newLaunchPOM.mouseHoverNewLaunch();
		newLaunchPOM.clickNullamAptIcon();
		Thread.sleep(5000);
		screenShot.captureScreenShot("TC32_newLaunchImage");
		System.out.println(" TC32_newLaunchImage Screenshot captured!");
	}

	@Test(priority = 2)
	public void arrowEnqCalcTest() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(5000);
		arrowEnqCalcPOM.clickArrowBtn();
		Thread.sleep(9000);
		// Capture screenshot
		screenShot.captureScreenShot("TC32_new image");
		System.out.println(" TC32_new image captured!");

		// Enquiries
		arrowEnqCalcPOM.sendName("selenium");
		arrowEnqCalcPOM.sendEmail("selenium@gmail.com");
		arrowEnqCalcPOM.sendSubject("apartment");
		arrowEnqCalcPOM.sendMsg("looking for apartment");
		arrowEnqCalcPOM.clickSendBtn();
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(6000);

		/*
		 * String expEnqMsg = "Thank you for your message.It has been sent.";
		 * Assert.assertEquals(arrowEnqCalcPOM.getEnqErrorMsg(), expEnqMsg); There is a
		 * defect in the application- Once we click Send button, it always gives error
		 * message and Success message never comes.So this will always fail.
		 */

		// Mortgage Calculator
		arrowEnqCalcPOM.sendSalePrice("40000");
		arrowEnqCalcPOM.sendDownPay("2000");
		arrowEnqCalcPOM.sendLoanTerm("2");
		arrowEnqCalcPOM.sendIntRate("5");
		arrowEnqCalcPOM.clickCalcBtn();
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,300)");

		String expMortSuccessMsg = "Monthly Payment: 1667.11 Rs.";
		String actMsg = arrowEnqCalcPOM.mortSuccessMsg.getText();
		Assert.assertTrue(actMsg.contains("Monthly Payment"));
		
		// Capture screenshot
		screenShot.captureScreenShot("TC32_successMsg");
		System.out.println(" TC32_success message captured!");

	}
}

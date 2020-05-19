package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.ArrowEnqCalcPOM;
import com.training.pom.LoginRegUserPOM;
import com.training.pom.NewLaunchPOM;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_063_EnqMultiUsers {
	private WebDriver driver;
	private String baseUrl;
	private RegisterPOM registerPOM;
	private LoginRegUserPOM loginRegUserPOM;
	private NewLaunchPOM newLaunchPOM;
	private ArrowEnqCalcPOM arrowEnqCalcPOM;
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
		registerPOM = new RegisterPOM(driver);
		loginRegUserPOM = new LoginRegUserPOM(driver);
		newLaunchPOM = new NewLaunchPOM(driver);
		arrowEnqCalcPOM = new ArrowEnqCalcPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test(dataProvider = "excel-inputs2", dataProviderClass = LoginDataProviders.class)
	public void arrowEnqCalcTest(String nameTxt, String emailTxt, String subjectTxt, String msgTxt)
			throws InterruptedException {

		loginRegUserPOM.clickSignInLink();
		Thread.sleep(4000);
		loginRegUserPOM.sendUserName("manali2286");
		loginRegUserPOM.sendPwd("Star2211");
		loginRegUserPOM.clickSignInBtn();
		Thread.sleep(4000);
		screenShot.captureScreenShot("TC63_login");
		System.out.println(" TC63_login Screenshot captured!");

		newLaunchPOM.mouseHoverNewLaunch();
		newLaunchPOM.clickDonecQuisLink();
		Thread.sleep(5000);
		screenShot.captureScreenShot("TC63_donecQuis");
		System.out.println(" TC63_donecQuis Screenshot captured!");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(3000);

		// Enquiries
		arrowEnqCalcPOM.sendName(nameTxt);
		Thread.sleep(2000);
		arrowEnqCalcPOM.sendEmail(emailTxt);
		Thread.sleep(2000);
		arrowEnqCalcPOM.sendSubject(subjectTxt);
		Thread.sleep(2000);
		arrowEnqCalcPOM.sendMsg(msgTxt);
		Thread.sleep(2000);
		arrowEnqCalcPOM.clickSendBtn();
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(6000);

		String expMsg = "There was an error trying to send your message. Please try again later.";
		String actMsg = arrowEnqCalcPOM.getEnqErrorMsg();
		Assert.assertTrue(actMsg.contains(expMsg));
		screenShot.captureScreenShot("TC63_Enquiry Error");
		System.out.println(" TC63_Enquiry Error captured!");

	}

}

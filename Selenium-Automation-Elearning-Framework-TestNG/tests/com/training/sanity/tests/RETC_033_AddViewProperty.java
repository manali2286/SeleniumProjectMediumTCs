package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddPropertyPOM;
import com.training.pom.AllPropPOM;
import com.training.pom.LoginRegUserPOM;
import com.training.pom.REPropertiesPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import junit.framework.Assert;

public class RETC_033_AddViewProperty {
	private WebDriver driver;
	private String baseUrl;
	private LoginRegUserPOM loginRegUserPOM;
	private REPropertiesPOM rePropertiesPOM;
	private AddPropertyPOM addPropertyPOM;
	private AllPropPOM allPropPOM;
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
		allPropPOM = new AllPropPOM(driver);
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
		screenShot.captureScreenShot("TC33_login");
		System.out.println(" TC33_login Screenshot captured!");
	}

	@Test(priority = 1)
	public void clickNewPropertiesTest() throws InterruptedException {
		rePropertiesPOM.clickPropertiesLink();
		Thread.sleep(5000);
		rePropertiesPOM.clickAddNewLink();
		screenShot.captureScreenShot("TC33_addNewPropertieslink");
		System.out.println(" TC33_addNewPropertieslink Screenshot captured!");
	}

	@Test(priority = 2)
	public void addViewPropertyTest() throws InterruptedException {
		addPropertyPOM.sendTitle("new launch by Steve Jobs");
		addPropertyPOM.sendText("new launch by Steve Jobs at Turkey");

		Actions act1 = new Actions(driver);
		act1.moveToElement(addPropertyPOM.publishBtn).click(addPropertyPOM.publishBtn).build().perform();
		Thread.sleep(8000);

		String expMsg = "Post published";
		String actMsg = addPropertyPOM.getPostMsg();
		Assert.assertTrue(actMsg.contains(expMsg));

		Thread.sleep(4000);
		rePropertiesPOM.clickAllPropLink();

		WebElement propTable = driver
				.findElement(By.xpath("//table[@class='wp-list-table widefat fixed striped posts']"));
		List<WebElement> listTR = driver
				.findElements(By.xpath("//table[@class='wp-list-table widefat fixed striped posts']/tbody/tr"));
		List<WebElement> listTH = driver
				.findElements(By.xpath("//table[@class='wp-list-table widefat fixed striped posts']//th"));

		List<WebElement> listTRUsingTable = propTable.findElements(By.xpath(".//tr"));
		List<WebElement> listTHUsingTable = propTable.findElements(By.xpath(".//th"));

		System.out.println("ROWSCount=" + listTR.size());
		System.out.println("COLSCount=" + listTH.size());

		System.out.println("ROWSCount=" + listTRUsingTable.size());
		System.out.println("COLSCount=" + listTHUsingTable.size());

		int iRow = 1;
		boolean broke = false;
		for (WebElement weEachRow : listTRUsingTable) {
			List<WebElement> listTDUsingTable = weEachRow.findElements(By.xpath(".//td"));
			System.out.println("ROW#:" + iRow);
			int iCol = 1;
			for (WebElement weEachCellofCurrentRow : listTDUsingTable) {
				System.out.println("COL#" + iCol + "::" + weEachCellofCurrentRow.getText());
				String actStr = weEachCellofCurrentRow.getText();
				if (actStr.contains("Steve Jobs")) {
					System.out.println("Match Found");
					broke = true;
					break;
				}
				iCol++;
			}
			if (broke) {
				break;
			} else
				iRow++;
		}

		// Capture screenshot
		screenShot.captureScreenShot("TC33_post published");
		System.out.println(" TC33_post published captured!");

	}

}

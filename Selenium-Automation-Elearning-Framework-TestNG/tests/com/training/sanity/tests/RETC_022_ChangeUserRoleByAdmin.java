package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AllUserLinksPOM;
import com.training.pom.LoginRegUserPOM;
import com.training.pom.UsersPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_022_ChangeUserRoleByAdmin {

	private WebDriver driver;
	private String baseUrl;
	private LoginRegUserPOM loginRegUserPOM;
	private UsersPOM usersPOM;
	private AllUserLinksPOM allUserLinksPOM;
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
		usersPOM = new UsersPOM(driver);
		allUserLinksPOM = new AllUserLinksPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		Thread.sleep(10000);
	}

	
	 @AfterClass public void tearDown() throws Exception { Thread.sleep(1000);
	 driver.quit(); }
	 

	@Test(priority = 0)
	public void adminLoginTest() throws InterruptedException {
		loginRegUserPOM.clickSignInLink();
		Thread.sleep(4000);
		loginRegUserPOM.sendUserName("admin");
		loginRegUserPOM.sendPwd("admin@123");
		loginRegUserPOM.clickSignInBtn();
		Thread.sleep(4000);
		screenShot.captureScreenShot("TC22_login");
		System.out.println(" TC22_login Screenshot captured!");
	}

	@Test(priority = 1)
	public void clickUsersLinkTest() throws InterruptedException {
		usersPOM.clickUsersLink();
		Thread.sleep(4000);
		screenShot.captureScreenShot("TC22_userslink");
		System.out.println(" TC22_userslink Screenshot captured!");
	}

	@Test(priority = 2)
	public void changeUserRoleTest() throws InterruptedException {
		//Click All Users Link
		allUserLinksPOM.clickAllUsersLink();
		
		//Click Checkbox for selecting user
		allUserLinksPOM.clickCheckbox();
		
		//Accept user input for the new role
		Scanner in = new Scanner(System.in);
		System.out.println("Enter new role for user:");
		String name = in.nextLine();
		System.out.println("New Role to be assigned is:" + name);
		
		//Click listbox
		allUserLinksPOM.clickListbox();		
		Select objSel = new Select(allUserLinksPOM.listbox);
		objSel.selectByVisibleText(name);
				
		//Click Change button
		allUserLinksPOM.clickChangeBtn();
		Thread.sleep(10000);
		
		//Verify Actual message with Expected message using assert 
		String expectedMsg = "Changed roles.";
		String str = allUserLinksPOM.getMessage();
		Assert.assertEquals(str, expectedMsg);
		System.out.println("Changed Roles.");
		
		//Verify new role under Role column
		if(allUserLinksPOM.newRole.getText()==name) 
		System.out.println("User role is displayed as "+name);
		
		//Capture screenshot
		screenShot.captureScreenShot("TC22_rolechanged");
		System.out.println(" TC22_rolechanged Screenshot captured!");
		
		//Close Scanner class object.
		in.close();
	}

}

package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginRegUserPOM {
	WebDriver driver;

	public LoginRegUserPOM(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//a[@class='sign-in']")
	public WebElement signInLink;

	@FindBy(xpath = "//li[@class='active']//a[contains(text(),'Log In')]")
	private WebElement loginTab;

	@FindBy(xpath = "//input[@id='user_login']")
	private WebElement myUserName;

	@FindBy(xpath = "//input[@id='user_pass']")
	private WebElement myPwd;

	@FindBy(xpath = "//input[@name='login']")
	private WebElement signInBtn;

	public void sendUserName(String myUserName) {
		this.myUserName.clear();
		this.myUserName.sendKeys(myUserName);
	}

	public void sendPwd(String myPwd) {
		this.myPwd.clear();
		this.myPwd.sendKeys(myPwd);
	}

	public void clickSignInBtn() {
		this.signInBtn.click();
	}

	public void clickSignInLink() {
		this.signInLink.click();
	}

}

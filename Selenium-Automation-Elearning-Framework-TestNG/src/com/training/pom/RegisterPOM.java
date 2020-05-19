
package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPOM {
	private WebDriver driver;

	public RegisterPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "sign-in")
	private WebElement signin;

	@FindBy(linkText = "Register")
	private WebElement registerlnk;

	@FindBy(id = "email")
	private WebElement myEmail;

	@FindBy(id = "first-name")
	private WebElement firstName;

	@FindBy(id = "last-name")
	private WebElement lastName;

	@FindBy(name = "submit")
	private WebElement registerbtn;

	@FindBy(xpath = "//div//p[contains(text(),'You have successfully registered to')]")
	private WebElement successMsg;

	public void sendEmail(String myEmail) {
		this.myEmail.clear();
		this.myEmail.sendKeys(myEmail);
	}

	public void sendFirstName(String firstName) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
	}

	public void sendLastName(String lastName) {
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
	}

	public void clickSignBtn() {
		this.signin.click();
	}

	public void clickRegBtn() {
		this.registerbtn.click();
	}

	public void clickRegLink() {
		this.registerlnk.click();
	}

	public String getMessage() {
		return successMsg.getText();

	}
}
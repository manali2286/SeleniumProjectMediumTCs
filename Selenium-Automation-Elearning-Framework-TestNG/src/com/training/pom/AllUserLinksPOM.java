package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AllUserLinksPOM {
	private WebDriver driver;

	public AllUserLinksPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='wp-first-item current']")
	public WebElement allUserslink;

	@FindBy(xpath = "//input[@id='user_569']")
	public WebElement checkbox;

	@FindBy(xpath = "//select[@id='new_role']")
	public WebElement listbox;

	@FindBy(xpath = "//input[@id='changeit']")
	public WebElement changeBtn;

	@FindBy(xpath = "//div//p[contains(text(),'Changed roles')]")
	public WebElement sucessMsg;
	
	@FindBy(xpath = "//tr[@id='user-569']//td[@class='role column-role']")
	public WebElement newRole;

	public void clickAllUsersLink() {
		this.allUserslink.click();
	}

	public void clickCheckbox() {
		this.checkbox.click();
	}

	public void clickListbox() {
		this.listbox.click();
	}

	public void clickChangeBtn() {
		this.changeBtn.click();
	}

	public String getMessage() {
		return this.sucessMsg.getText();
	}
}

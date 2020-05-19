package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLaunchPOM {

	WebDriver driver;

	public NewLaunchPOM(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locators
	@FindBy(xpath = "//a[contains(text(),'New Launch')]")
	public WebElement newLaunchDropDown;

	//@FindBy(xpath = "//img[contains(@src,'http://realty-real-estatem1.upskills.in/wp-content/uploads/2017/08/apartment05-345x250.jpg')]")
	@FindBy (xpath = "//div[@id='wpmm-megamenu']//div[@class='wpmm-post post-156']//img[@class='attachment-wpmm_thumb size-wpmm_thumb wp-post-image']")
	private WebElement img;
	
	@FindBy(xpath = "//div[@id='wpmm-megamenu']//a[contains(text(),'Donec quis')]")
	public WebElement donecQuisLink;
	
	public void mouseHoverNewLaunch() {
		Actions action = new Actions(driver);
		action.moveToElement(newLaunchDropDown).perform();
	}
	
	public void clickNullamAptIcon() {
		this.img.click();
	}
	
	public void clickDonecQuisLink() {
		this.donecQuisLink.click();
	}

}

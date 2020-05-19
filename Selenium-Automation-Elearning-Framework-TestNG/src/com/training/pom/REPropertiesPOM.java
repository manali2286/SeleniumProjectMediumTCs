package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class REPropertiesPOM {
	WebDriver driver;

	public REPropertiesPOM(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(),'Properties')]")
	public WebElement propertiesLink;

	@FindBy(xpath = "//li[@id='menu-posts-property']//ul[@class='wp-submenu wp-submenu-wrap']//li//a[contains(text(),'Add New')]")
	private WebElement addNewLink;
	

	@FindBy(xpath = "//a[@class='wp-first-item current']")
	public WebElement allPropLink;

	public void clickPropertiesLink() {
		this.propertiesLink.click();
	}
	
	public void clickAddNewLink() {
		this.addNewLink.click();
	}
	
	public void clickAllPropLink() {
		this.addNewLink.click();
	}

	/*
	 * public void clickAddNewLink() throws InterruptedException { // WebDriverWait
	 * wait = new WebDriverWait(driver,20); //
	 * wait.until(ExpectedConditions.elementToBeClickable(addNewLink)); Actions act
	 * = new Actions(driver); //act.moveToElement(propertiesLink).perform();
	 * //act.moveToElement(addNewLink).click().build().perform();
	 * act.moveToElement(propertiesLink).moveToElement(addNewLink).perform();
	 * act.click(addNewLink).build().perform(); }
	 */

}

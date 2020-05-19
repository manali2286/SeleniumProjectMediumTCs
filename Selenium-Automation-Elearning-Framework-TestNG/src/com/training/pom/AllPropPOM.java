package com.training.pom;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllPropPOM {
	
	WebDriver driver;

	public AllPropPOM(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//th[@id='title']//span[contains(text(),'Title')]")
	public WebElement title;
	 
	@FindBy(xpath = "//input[@id='post-search-input']")
	public WebElement searchInputTxt;
	
	@FindBy(xpath = "//input[@id='search-submit']")
	public WebElement searchInputBtn;
	
	/*
	 * @FindBy(xpath =
	 * "//table[@class='wp-list-table widefat fixed striped posts']") public
	 * WebElement propTable;
	 */
	
	public void sendSearchInput(String searchInputTxt) {
		this.searchInputTxt.clear();
		this.searchInputTxt.sendKeys(searchInputTxt);
	}
	
	public void clickSearchBtn() {
		this.searchInputBtn.click();
	}
	

}

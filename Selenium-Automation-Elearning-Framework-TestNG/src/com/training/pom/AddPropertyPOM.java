package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPropertyPOM {

	WebDriver driver;

	public AddPropertyPOM(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locators
	@FindBy(xpath = "//input[@id='title']")
	public WebElement titleTextBox;

	@FindBy(xpath = "//textarea[@id='content']")
	private WebElement textBox;

	@FindBy(xpath = "//textarea[@id='_price']")
	private WebElement price;

	@FindBy(xpath = "//input[@id='_price_per']")
	private WebElement priceSqFt;

	// Main Details Tab
	@FindBy(xpath = "//a[@id='ui-id-2']")
	private WebElement mainTab;

	@FindBy(xpath = "//input[@id='_status']")
	private WebElement statusBox;

	@FindBy(xpath = "//input[@id='_location']")
	private WebElement locationBox;

	@FindBy(xpath = "//input[@id='_possession']")
	private WebElement possessionBox;

	// Location Tab
	@FindBy(xpath = "//a[@id='ui-id-3']")
	private WebElement locationTab;

	@FindBy(xpath = "//input[@id='_friendly_address']")
	private WebElement adrTxt;

	@FindBy(xpath = "//input[@id='_address']")
	private WebElement gMapAdrTxt;

	@FindBy(xpath = "//input[@id='_geolocation_lat']")
	private WebElement latTxt;

	@FindBy(xpath = "//input[@id='_geolocation_long']")
	private WebElement longiTxt;

	// Details Tab
	@FindBy(xpath = "//a[@id='ui-id-4']")
	private WebElement detailsTab;

	@FindBy(xpath = "//input[@id='_storage_room']")
	private WebElement storeRoomTxt;

	@FindBy(xpath = "//li[@id='region-57']//label[@class='selectit'][contains(text(),'Central Bangalore')]")
	private WebElement centralBloreCheckox;

	@FindBy(xpath = "//input[@id='publish']")
	public WebElement publishBtn;
	
	@FindBy(xpath = "//p[contains(text(),'Post published.')]")
	public WebElement postPublishMsg;
	
	@FindBy(xpath = "//div[@class='acf-label']//label[contains(text(),'Keyword Tags')]")
	public WebElement keywordTag;	

	// ----------------------------------------------------------------------------------------

	// SendKeys Methods
	public void sendTitle(String titleTextBox) {
		this.titleTextBox.clear();
		this.titleTextBox.sendKeys(titleTextBox);
	}

	public void sendText(String textBox) {
		this.textBox.clear();
		this.textBox.sendKeys(textBox);
	}

	public void sendPrice(String price) {
		this.price.clear();
		this.price.sendKeys(price);
	}

	public void sendPriceSqFt(String priceSqFt) {
		this.priceSqFt.clear();
		this.priceSqFt.sendKeys(priceSqFt);
	}

	public void sendStatus(String statusBox) {
		this.statusBox.clear();
		this.statusBox.sendKeys(statusBox);
	}

	public void sendLocation(String locationBox) {
		this.locationBox.clear();
		this.locationBox.sendKeys(locationBox);
	}

	public void sendPossession(String possessionBox) {
		this.possessionBox.clear();
		this.possessionBox.sendKeys(possessionBox);
	}

	public void sendAdr(String adrTxt) {
		this.adrTxt.clear();
		this.adrTxt.sendKeys(adrTxt);
	}

	public void sendGMapAdr(String gMapAdrTxt) {
		this.gMapAdrTxt.clear();
		this.gMapAdrTxt.sendKeys(gMapAdrTxt);
	}

	public void sendLatitude(String latTxt) {
		this.latTxt.clear();
		this.latTxt.sendKeys(latTxt);
	}

	public void sendLongitude(String longiTxt) {
		this.longiTxt.clear();
		this.longiTxt.sendKeys(longiTxt);
	}

	public void sendStoreRoom(String storeRoomTxt) {
		this.storeRoomTxt.clear();
		this.storeRoomTxt.sendKeys(storeRoomTxt);
	}

	// ------------------------------------------------------------------------------------------------
	// Click Methods
	public void clickMainTab() {
		this.mainTab.click();
	}

	public void clickLocationTab() {
		this.locationTab.click();
	}

	public void clickDetailsTab() {
		this.detailsTab.click();
	}

	public void clickCBloreCheckBox() {
		this.centralBloreCheckox.click();
		System.out.println(centralBloreCheckox.isSelected());
	}

	public void clickPublishBtn() {
		this.publishBtn.click();
	}

	public String getPostMsg() {
		return this.postPublishMsg.getText();
	}
}

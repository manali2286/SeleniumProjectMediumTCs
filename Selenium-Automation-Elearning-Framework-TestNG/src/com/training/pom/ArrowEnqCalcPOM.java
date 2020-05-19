package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArrowEnqCalcPOM {

	WebDriver driver;

	public ArrowEnqCalcPOM(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locators
	@FindBy(xpath = "//div[contains(@class,'col-md-12')]//button[contains(@class,'slick-next slick-arrow')][contains(text(),'Next')]")
	public WebElement arrowBtn;

	@FindBy(xpath = "//input[contains(@name,'your-name')]")
	public WebElement nameTxt;

	@FindBy(xpath = "//input[contains(@name,'your-email')]")
	public WebElement emailTxt;

	@FindBy(xpath = "//input[contains(@name,'your-subject')]")
	public WebElement subjectTxt;

	@FindBy(xpath = "//textarea[contains(@name,'your-message')]")
	public WebElement msgTxt;

	@FindBy(xpath = "//input[contains(@class,'wpcf7-form-control wpcf7-submit')]")
	public WebElement sendBtn;

	@FindBy(xpath = "//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")
	public WebElement errorMsg;

	@FindBy(xpath = "//input[@id='amount']")
	public WebElement salePriceTxtBox;

	@FindBy(xpath = "//input[@id='downpayment']")
	public WebElement downPayTxtBox;

	@FindBy(xpath = "//input[@id='years']")
	public WebElement loanTermTxtBox;

	@FindBy(xpath = "//input[@id='interest']")
	public WebElement intRateTxtBox;

	@FindBy(xpath = "//button[@class='button calc-button']")
	public WebElement calcBtn;

	@FindBy(xpath = "//div[@class='notification success']")
	public WebElement mortSuccessMsg;
	
	

	// Methods
	public void clickArrowBtn() {
		this.arrowBtn.click();
	}

	public void sendName(String nameTxt) {
		this.nameTxt.clear();
		this.nameTxt.sendKeys(nameTxt);
	}

	public void sendEmail(String emailTxt) {
		this.emailTxt.clear();
		this.emailTxt.sendKeys(emailTxt);
	}

	public void sendSubject(String subjectTxt) {
		this.subjectTxt.clear();
		this.subjectTxt.sendKeys(subjectTxt);
	}

	public void sendMsg(String msgTxt) {
		this.msgTxt.clear();
		this.msgTxt.sendKeys(msgTxt);
	}

	public void sendSalePrice(String salePriceTxtBox) {
		this.salePriceTxtBox.clear();
		this.salePriceTxtBox.sendKeys(salePriceTxtBox);
	}

	public void sendDownPay(String downPayTxtBox) {
		this.downPayTxtBox.clear();
		this.downPayTxtBox.sendKeys(downPayTxtBox);
	}

	public void sendLoanTerm(String loanTermTxtBox) {
		this.loanTermTxtBox.clear();
		this.loanTermTxtBox.sendKeys(loanTermTxtBox);
	}

	public void sendIntRate(String intRateTxtBox) {
		this.intRateTxtBox.clear();
		this.intRateTxtBox.sendKeys(intRateTxtBox);
	}

	public void clickSendBtn() {
		this.sendBtn.click();
	}

	public void clickCalcBtn() {
		this.calcBtn.click();
	}

	public String getEnqErrorMsg() {
		return this.errorMsg.getText();
	}

	public String getMortSuccessMsg() {
		return this.mortSuccessMsg.getText();
	}
}

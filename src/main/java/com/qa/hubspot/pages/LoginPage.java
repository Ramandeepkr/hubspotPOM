package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.Util.Constants;
import com.qa.hubspot.Util.ElementAction;
import com.qa.hubspot.base.BasePage;
public class LoginPage extends BasePage {

	WebDriver driver;
	ElementAction elementActions;
	// 1.define OR/Page Object:using By class

	By emailId = By.id("username");
	By password = By.id("password");
	By loginbtn = By.id("loginBtn");
	By signUp = By.linkText("Sign up");
	By showPassword = By.xpath("//span[text()='Show Password']");
	By forgotLink = By.xpath("//i18n-string[text()='Forgot my password']");
	By checkBox = By.xpath("//*[@id=\"hs-login\"]//div[@class='private-checkbox m-bottom-4']");
	// 2.Define Constructor

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementAction(this.driver);

	}

	// 3. Page Actions/Methods

	public String getTitle() {
		return elementActions.waitForPageTitle(Constants.LOGIN_PAGE_TITLE);
//		String title = driver.getTitle();
//		return title;
	}

	public HomePage doLogin(String username, String pwd) {
//		driver.findElement(emailId).sendKeys(username);
//		driver.findElement(password).sendKeys(pwd);
//		driver.findElement(loginbtn).click();
//		try {
//			Thread.sleep(6000);
//		} catch (InterruptedException e) {
//				e.printStackTrace();
//		}
		//return new HomePage(driver);
		
		elementActions.doSendKeys(emailId,username);
		elementActions.doSendKeys(password,pwd);
		elementActions.doClick(loginbtn);
		return new HomePage(driver);
	}

	public boolean signIsDisplayed() {
		return elementActions.isElementDisplayed(signUp);

		//return driver.findElement(signUp).isDisplayed();
	}
	public boolean showPasswordLinkIsDisplayed()
	{
		return elementActions.isElementDisplayed(showPassword);
		//return driver.findElement(showPassword).isDisplayed();
	}
	public boolean forgotPasswordLink()
	{
		return elementActions.isElementDisplayed(forgotLink);
		//return driver.findElement(forgotLink).isDisplayed();
	}
//	public boolean checkBoxIsSelected()
//	{
//		return driver.findElement(checkBox).isSelected();
//	}

}

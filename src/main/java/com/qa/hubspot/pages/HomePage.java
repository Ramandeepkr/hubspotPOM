package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.Util.Constants;
import com.qa.hubspot.Util.ElementAction;
import com.qa.hubspot.base.BasePage;

public class HomePage extends BasePage{
	WebDriver driver;
	ElementAction elementActions;
	//locator/OR
	By header = By.cssSelector("h1.private-header__heading>i18n-string");
	By accountName = By.xpath("//*[text()=' ']");
	By contactMain = By.xpath("(//*[@id='nav-primary-contacts-branch'])");
	By contactChild = By.xpath("(//*[@id='nav-secondary-contacts'])");
	By profilePage = By.id("account-menu");
	
	//constructor
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		elementActions = new ElementAction(this.driver);
	}
	
	//page actions
	public String getHomePageTitle()
	{
		return elementActions.waitForPageTitle(Constants.HOME_PAGE_TITLE);
		//return driver.getTitle();
	}
	public boolean verifyHomePageHeaderVisible()
	{
		return elementActions.isElementDisplayed(header);
		//return driver.findElement(header).isDisplayed();
	}
	public String getHomePageHeaderText()
	{
		return elementActions.doGetText(header);
		//return driver.findElement(header).getText();
	}
	public String verifyAccountName()
	{
		return elementActions.doGetText(accountName);
		//return driver.findElement(accountName).getText();
	}
//	public void clickOnProfilePage()
//	{
//		driver.findElement(profilePage).click();
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	public ContactsPage gotoContacts()
	{
		clickOnContact();	
		return new ContactsPage(driver);
	}
	private void clickOnContact()
	{
		elementActions.doClick(contactMain);
		//driver.findElement(contactMain).click();
		elementActions.doClick(contactMain);
		//driver.findElement(contactChild).click();
		
		
	}

}

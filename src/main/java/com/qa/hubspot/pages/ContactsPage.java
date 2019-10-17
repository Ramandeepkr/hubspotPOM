package com.qa.hubspot.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.Util.ElementAction;
import com.qa.hubspot.base.BasePage;
public class ContactsPage extends BasePage {
	WebDriver driver;
	ElementAction elementActions;
	By header = By.cssSelector("h1.private-header__heading>i18n-string");
	By createBtn = By.xpath("//span[text()='Create contact']");
	// By createHeader = By.xpath("//h3[text()='Create contact']");
	By email = By.xpath("//*[@name='textInput']");
	By firstname = By.xpath("//*[@data-field='firstname']");
	By lastname = By.xpath("//*[@data-field='lastname']");
	By jobTitle = By.xpath("//*[@data-field='jobtitle']");
	By createBtn2 = By.xpath("(//*[@class='UIIcon__IconContent-pg6n1x-0 dEdOCo'])[1]");

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementAction(this.driver);
	}

	public String getContactHeader() {
		return elementActions.doGetText(header);
		//return driver.findElement(header).getText();
	}

	public void createNewContact(String emailId, String firstn, String lastn, String jobtitle) {
		elementActions.waitForElementClickable(createBtn);
		elementActions.doClickByAction(createBtn);
		elementActions.doSendKeys(email, emailId);
		elementActions.doSendKeys(firstname, firstn);
		elementActions.doSendKeys(lastname, lastn);
		elementActions.doSendKeys(jobTitle, jobtitle);
		elementActions.doClickByAction(createBtn2);
		
		//		driver.findElement(createBtn).click();
//		
//		driver.findElement(email).sendKeys(emailId);
//		driver.findElement(firstname).sendKeys(firstn);
//		driver.findElement(lastname).sendKeys(lastn);
//		driver.findElement(jobTitle).sendKeys(jobtitle);
		
		//driver.findElement(createBtn2).click();
	}

}

package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.hubspot.Util.Constants;
import com.qa.hubspot.Util.ExcelUtil;
import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;

public class ContactPageTest {
	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	HomePage homepage;
	ContactsPage contactsPage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_property();
		driver = basePage.init_Driver(prop);
		loginPage = new LoginPage(driver);
		homepage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homepage.gotoContacts();
	}

	@Test(priority = 1)
	public void contactsPageHeaderTest() {
		String header = contactsPage.getContactHeader();
		System.out.print("Contact page header :" + header);
		Assert.assertEquals(header, Constants.CONTACT_PAGE_HEADER);

	}
	@DataProvider
	public Object[][] getContactData() {
		Object data[][] = ExcelUtil.getTestData("contacts");
		return data;

	}
	@Test(priority = 2,dataProvider="getContactData")
	public void createContactsPagetest(String emailId,String firstName,String lastName,String JobTitle) {
		contactsPage.createNewContact(emailId,firstName,lastName,JobTitle);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

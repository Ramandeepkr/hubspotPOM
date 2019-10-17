package com.qa.hubspot.test;
import java.util.Properties;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.hubspot.Util.Constants;
import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.pages.ProfilePage;
public class HomePageTest {
	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	HomePage homepage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_property();
		driver = basePage.init_Driver(prop);
		loginPage = new LoginPage(driver);
		homepage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void homePageTitleTest() {
		String title = homepage.getHomePageTitle();
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void homepageHeaderTest() {
		Assert.assertTrue(homepage.verifyHomePageHeaderVisible());
		String headerText = homepage.getHomePageHeaderText();
		System.out.println("Home Page Title :" + headerText);
		Assert.assertEquals(headerText, Constants.HOME_PAGE_HEADER);

	}
	@Test(priority = 3,enabled = false)
	public void verifyAccountNameTest() {
		String accountName = homepage.verifyAccountName();
		Assert.assertEquals(accountName,prop.getProperty("accountname"));
		

	}
//	@Test(priority = 4)
//	public void clickOnProfilePageTest() {
//		homepage.clickOnProfilePage();
//		new ProfilePage(driver);
//
//	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

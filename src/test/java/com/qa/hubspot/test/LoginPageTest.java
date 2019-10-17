package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.Util.Constants;
import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;

public class LoginPageTest {
	// BM

	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_property();
		driver = basePage.init_Driver(prop);
		loginPage = new LoginPage(driver);
			}

	@Test(priority = 1)
	public void loginPageTitle() {
		String title = loginPage.getTitle();
		System.out.println("Login page title :" + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);

	}

	@Test(priority = 2)
	public void signUpLinkTest() {
		Assert.assertTrue(loginPage.signIsDisplayed());
	}
	@Test(priority = 3)
	public void showLinkIsDisplayedTest()
	{
		Assert.assertTrue(loginPage.showPasswordLinkIsDisplayed());
	}
	@Test(priority = 4)
	public void forgotLinkIsDisplayedTest()
	{
		Assert.assertTrue(loginPage.forgotPasswordLink());
	}
	
//	@Test(priority = 5)
//	public void checkBoxIsSelectedTest()
//	{
//		Assert.assertTrue(loginPage.checkBoxIsSelected());
//	}
	
	
	@Test(priority = 5)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"), 
				prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

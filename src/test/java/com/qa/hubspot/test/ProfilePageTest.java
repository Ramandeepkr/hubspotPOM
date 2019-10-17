package com.qa.hubspot.test;

import java.util.Properties;

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

public class ProfilePageTest {
	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	HomePage homepage;
	ProfilePage profilepage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_property();
		driver = basePage.init_Driver(prop);
		loginPage = new LoginPage(driver);
		homepage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		profilepage = new ProfilePage(driver);
	}
	@Test
	public void checkProfileTitleTest() {
		String profileHeader = profilepage.checkProfileTitle();
		Assert.assertEquals(profileHeader,Constants.PROFILE_HEADER);

	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

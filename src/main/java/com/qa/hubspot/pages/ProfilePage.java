package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class ProfilePage extends BasePage{
	WebDriver driver;
	
	By profileHeader = By.xpath("//*[@class='private-header__heading private-header__heading--solo']");
	
	public ProfilePage(WebDriver driver)
	{
	this.driver = driver;	
	}
	
	public String checkProfileTitle()
	{
		return driver.findElement(profileHeader).getText();
	}

}

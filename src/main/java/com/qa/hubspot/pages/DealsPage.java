package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class DealsPage extends BasePage {
	
		WebDriver driver;

		public DealsPage(WebDriver driver) {
			this.driver = driver;
		}
		public void createDealPage()
		{
			
		}
		/**
		 * this method is used to get the title of a page
		 */
		public void getTitle()
		{
			System.out.println(driver.getTitle());
		}

}

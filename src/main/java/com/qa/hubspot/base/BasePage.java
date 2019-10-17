package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
//import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	WebDriver driver;
	Properties prop;
/**
 * this method is used to initialize driver on the basis of browser
 * @return driver
 */
	public WebDriver init_Driver(Properties prop) {
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		//String browser = "chrome";
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equals("firefox")) {
			WebDriverManager.chromedriver().setup();
			//driver = new FirefoxDriver();

		} else {
			System.out.println("Pls define correct driver");
		}
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get(url);
		
		return driver;

	}
/**
 * 
 * @return prop
 */
	public Properties init_property()  {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\Sandeep\\eclipse-workspace1\\AugPOMFrameWork\\config.properties");
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return prop;

	}

}

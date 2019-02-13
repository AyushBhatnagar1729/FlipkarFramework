package com.flipkart.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.flipkart.Utiliity.Constants;
import com.flipkart.Utiliity.XlsReader;

public class Base {

	public static WebDriver driver;
	
	public Base()
	{
		XlsReader.getTestData(Constants.sheetName);
	}
	
	public static void browserInitition()
	{
		if (Constants.browser.equalsIgnoreCase("chrome"))
		{ 
			System.setProperty("webdriver.chrome.driver", "C://chomedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-notification");
			 driver = new ChromeDriver(option);
			 driver.get(Constants.url);
			
		}
		else
		{
			System.setProperty("webdriver.gecko.driver", "C://geckodriver.exe");
			FirefoxOptions option = new FirefoxOptions();
			option.addArguments("--disable-notification");
			 driver = new FirefoxDriver(option);
			 driver.get(Constants.url);
		}
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
}

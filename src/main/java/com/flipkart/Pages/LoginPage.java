package com.flipkart.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.Base;

public class LoginPage extends Base {

	//Object repository
	@FindBy(xpath = "//input[@class = '_2zrpKA']")
	WebElement username;
	
	@FindBy(xpath = "//input[@type= 'password']")
	WebElement password;
	
	@FindBy(xpath = "//span[text() = 'Forgot?']")
	WebElement forgotPassword;
	
	@FindBy(xpath = "//button/span[text() = 'Login']")
	WebElement login;
	
	//It will instantiate all the page objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
}

package com.Pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	//declaration
	@FindBy(name="username") private WebElement usernameTF;
	@FindBy(name="password") private WebElement passwordTF;
	@FindBy(name="login") private WebElement loginButton;
	
	//initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public void loginToApp(String USERNAME, String PASSWORD) {
		usernameTF.sendKeys(USERNAME);
		passwordTF.sendKeys(PASSWORD);
		loginButton.click();
		
	}
	
	
	
	
	
	

}

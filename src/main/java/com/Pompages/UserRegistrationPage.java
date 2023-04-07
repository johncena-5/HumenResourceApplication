package com.Pompages;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserRegistrationPage {

	
	@FindBy(xpath="//a[text()='Register']") private WebElement register;
	@FindBy(name = "fullname")
	private WebElement fullnameTF;
	@FindBy(name = "username")
	private WebElement usernameTF;
	@FindBy(name = "mobile")
	private WebElement mobileTF;
	@FindBy(name = "email")
	private WebElement emailTF;
	@FindBy(name = "password")
	private WebElement passwordTF;
	@FindBy(name = "c_password")
	private WebElement cpasswordTF;
	@FindBy(name = "register")
	private WebElement submitButton;

	public UserRegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	

	public void creatID(String fullname, String username, String mobileNo, String email, String password, String cpassword) {
      
		fullnameTF.sendKeys(fullname);
		usernameTF.sendKeys(username);
		mobileTF.sendKeys(mobileNo+"");
		emailTF.sendKeys(email);
		passwordTF.sendKeys(password+"");
		cpasswordTF.sendKeys(cpassword+"");
		submitButton.click();
	}
	
	public void fetchDataFromExcel(Map<String,String> map, WebDriver driver ) {
		
	       for (Entry<String, String> set : map.entrySet()) 
	       {
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			}
	       submitButton.click();
		}
	
	public void clickOnRegister() {
		register.click();
	}
}

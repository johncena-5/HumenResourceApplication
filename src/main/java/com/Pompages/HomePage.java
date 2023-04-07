package com.Pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath="//a[@class=\"nav-link\" and text()='Login']") private WebElement loginbutton;
	@FindBy(xpath="//h1[text()='Dash board']") private WebElement header;
	@FindBy(xpath="//b[text()='Registered Users: ']") private WebElement registeruser;
	@FindBy(xpath="//b[text()='Rooms for Rent: ']") private WebElement roomforrent;
	@FindBy(xpath="//a[text()='Register']") private WebElement registerModuel;
	@FindBy(xpath="//a[text()='Details/Update']") private WebElement detailsUpdateModuel;
	@FindBy(xpath="//a[text()='Send SMS']") private WebElement sendSmsModuel;
	@FindBy(xpath="//a[text()='Complaint List']") private WebElement complaintListModuel;
	@FindBy(xpath="//a[text()='Logout']") private WebElement logout;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String header() {
		return header.getText();
	}
	
	public void registerUser() {
		registeruser.click();
	}
	
	public void roomForRent() {
		roomforrent.click();
	}
	
	public void registerModuel() {
		registerModuel.click();
	}
	public void detailsUpdateModuel() {
		detailsUpdateModuel.click();
	}
	public void sendSmsModuel() {
		sendSmsModuel.click();
	}
	public void complaintListModuel() {
		complaintListModuel.click();
	}
	public void logoutToApp() {
		logout.click();
	}
	public void clickOnLogin() {
		loginbutton.click();
	}
	
	
	

}

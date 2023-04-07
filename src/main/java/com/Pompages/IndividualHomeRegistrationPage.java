package com.Pompages;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.WebDriverUtility;

public class IndividualHomeRegistrationPage {

	@FindBy(xpath = "//h2[text()='Register Room']")
	private WebElement header;
	@FindBy(id = "fullname")
	private WebElement fullnameTF;
	@FindBy(id = "mobile")
	private WebElement mobileTF;
	@FindBy(id = "alternat_mobile")
	private WebElement alternatmobileTF;
	@FindBy(id = "email")
	private WebElement emailTF;
	@FindBy(id = "plot_number")
	private WebElement plotnumberTF;
	@FindBy(id = "rooms")
	private WebElement roomsTF;
	@FindBy(id = "country")
	private WebElement countryTF;
	@FindBy(id = "state")
	private WebElement stateTF;
	@FindBy(id = "city")
	private WebElement cityTF;
	@FindBy(id = "rent")
	private WebElement rentTF;
	@FindBy(id = "sale")
	private WebElement saleTF;
	@FindBy(id = "deposit")
	private WebElement depositTF;
	@FindBy(id = "accommodation")
	private WebElement accommodationTF;
	@FindBy(id = "description")
	private WebElement descriptionTF;
	@FindBy(id = "landmark")
	private WebElement landmarkTF;
	@FindBy(id = "address")
	private WebElement addressTF;
	@FindBy(id = "vacant")
	private WebElement vacantdrop;
	@FindBy(id = "image")
	private WebElement image;
	@FindBy(name = "register_individuals")
	private WebElement submitButton;

	public IndividualHomeRegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement pageHeader() {
		return header;
	}

	public void imageButton(String filepath) {
		image.sendKeys(filepath);
	}

	public void submitButton() {
		submitButton.click();
	}

	public void fetchDataFromExcel(Map<String, String> map, WebDriver driver) {

		for (Entry<String, String> set : map.entrySet()) {

			driver.findElement(By.id(set.getKey())).sendKeys(set.getValue());
		}

	}

	public void handleDropDown(WebDriverUtility wLib) {
		wLib.dropDown("Vacant", vacantdrop);
	}
}

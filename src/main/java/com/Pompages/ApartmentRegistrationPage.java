package com.Pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.WebDriverUtility;

public class ApartmentRegistrationPage {

	@FindBy(xpath = "//a[text()='Apartment Registration']")
	private WebElement apartmentTab;
	@FindBy(xpath = "//h2[text()='Apartment Room']")
	private WebElement pageHeader;
	@FindBy(id = "apartment_name")
	private WebElement apartmentTF;
	@FindBy(xpath = "//h2[text()='Apartment Room']/parent::div/descendant::input[@name=\"mobile\"]")
	private WebElement mobileTF;
	@FindBy(xpath = "//h2[text()='Apartment Room']/parent::div/descendant::input[@name=\"alternat_mobile\"]")
	private WebElement alternateMobileTF;
	@FindBy(xpath = "//h2[text()='Apartment Room']/parent::div/descendant::input[@name=\"email\"]")
	private WebElement emailTF;
	@FindBy(xpath = "//h2[text()='Apartment Room']/parent::div/descendant::input[@name=\"plot_number\"]")
	private WebElement plotnoTF;
	@FindBy(xpath = "//h2[text()='Apartment Room']/parent::div/descendant::input[@name=\"country\"]")
	private WebElement countryTF;
	@FindBy(xpath = "//h2[text()='Apartment Room']/parent::div/descendant::input[@name=\"state\"]")
	private WebElement stateTF;
	@FindBy(xpath = "//h2[text()='Apartment Room']/parent::div/descendant::input[@name=\"city\"]")
	private WebElement cityTF;
	@FindBy(xpath = "//h2[text()='Apartment Room']/parent::div/descendant::input[@name=\"landmark\"]")
	private WebElement landmarkTF;
	@FindBy(xpath = "//h2[text()='Apartment Room']/parent::div/descendant::input[@name=\"address\"]")
	private WebElement addressTF;
	@FindBy(xpath = "//a[text()='Add More(Plat Number/Description)']")
	private WebElement platno;
	@FindBy(xpath = "//h2[text()='Apartment Room']/parent::div/descendant::input[@name=\"image\"]")
	private WebElement imageButton;
	@FindBy(name = "fullname[]")
	private WebElement fullnameTF;
	@FindBy(name = "ap_number_of_plats[]")
	private WebElement flatnoTF;
	@FindBy(name = "rooms[]")
	private WebElement roomTF;
	@FindBy(name = "area[]")
	private WebElement areaTF;
	@FindBy(name = "purpose[]")
	private WebElement PurposeDropdown;
	@FindBy(name = "floor[]")
	private WebElement FloorDropdown;
	@FindBy(name = "own[]")
	private WebElement ownDropdown;
	@FindBy(name="rent[]")
	private WebElement rentTF;
	@FindBy(name = "deposit[]")
	private WebElement depositeTF;
	@FindBy(name = "accommodation[]")
	private WebElement accomodationTF;
	@FindBy(name = "description[]")
	private WebElement descriptionTF;
	@FindBy(name = "vacant[]")
	private WebElement vacantDropdown;
	@FindBy(name = "register_apartment")
	private WebElement submitButton;

	public ApartmentRegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement pageHeader() {
		return pageHeader;
	}

	public void submitDetails(WebDriverUtility wLib, String apartmentName, String mobile, String alternatemobile,
			String email, String plotno, String country, String state, String city, String landmark, String address,
			String FILEPATH, String fullname, String flatno, String roomNo, String area, String rent, String deposit,
			String accommodation, String description) {

		apartmentTF.sendKeys(apartmentName);
		mobileTF.sendKeys(mobile + " ");
		alternateMobileTF.sendKeys(alternatemobile + "");
		emailTF.sendKeys(email);
		plotnoTF.sendKeys(plotno + "");
		countryTF.sendKeys(country);
		stateTF.sendKeys(state);
		cityTF.sendKeys(city);
		landmarkTF.sendKeys(landmark);
		addressTF.sendKeys(address);
		imageButton.sendKeys(FILEPATH);
		platno.click();
		fullnameTF.sendKeys(fullname);
		flatnoTF.sendKeys(flatno + "");
		roomTF.sendKeys(roomNo + "");
		areaTF.sendKeys(area);
		wLib.dropDown("Residential", PurposeDropdown);
		wLib.dropDown("2nd", FloorDropdown);
		wLib.dropDown("Rented", ownDropdown);
		rentTF.sendKeys(rent + "");
		depositeTF.sendKeys("" + deposit);
		accomodationTF.sendKeys(accommodation);
		descriptionTF.sendKeys(description);
		wLib.dropDown("Vacant", vacantDropdown);
		submitButton.click();
	}

	public void clickOnApartmentTab() {
		apartmentTab.click();
	}

}

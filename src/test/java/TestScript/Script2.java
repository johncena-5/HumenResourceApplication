package TestScript;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.GenericUtility.BaseClass;
import com.GenericUtility.DatabaseUtility;
import com.GenericUtility.ExcelUtility;
import com.GenericUtility.FileUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriverUtility;
import com.Pompages.ApartmentRegistrationPage;
import com.Pompages.HomePage;
import com.Pompages.LoginPage;

public class Script2 extends BaseClass {

	@Test
	public void script2() throws Throwable  {
	 
		home.clickOnLogin();
	    login.loginToApp(USERNAME, PASSWORD);
		home.registerModuel();

		apartment.clickOnApartmentTab();

		HashMap<String, String> map = eLib.readMultipleDataFromExcel("Apartment Registration");

		
		
		apartment.submitDetails(wLib, map.get("apartment_name"), map.get("mobile"), map.get("alternat_mobile"),
				map.get("email"), map.get("plot_number"), map.get("country"), map.get("state"), map.get("city"),
				map.get("landmark"), map.get("address"), FILEPATH, map.get("fullname[]"), map.get("ap_number_of_plats[]"),
				map.get("rooms[]"), map.get("area[]"), map.get("rent[]"), map.get("deposit[]"),
				map.get("accommodation[]"), map.get("description[]") );
		
		

	}
}

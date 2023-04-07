package TestScript;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;
import com.GenericUtility.DatabaseUtility;
import com.GenericUtility.ExcelUtility;
import com.GenericUtility.FileUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriverUtility;
import com.Pompages.HomePage;
import com.Pompages.IndividualHomeRegistrationPage;
import com.Pompages.LoginPage;
import com.Pompages.SendSmsPage;

public class Script4 extends BaseClass{

	@Test
	public void script4() throws Throwable {
		
		
		home.clickOnLogin();
		login.loginToApp(USERNAME, PASSWORD);
		home.registerModuel();
		
	 	Map<String, String> map = eLib.readMultipleDataFromExcel("Sheet1");

		individual.fetchDataFromExcel(map, driver);
		individual.handleDropDown(wLib);

		individual.imageButton(FILEPATH);

		individual.submitButton();
		Thread.sleep(4000);
		
		home.sendSmsModuel();
		Thread.sleep(4000);
		sms.sendSmsToUser(driver);
		
		

	}
}

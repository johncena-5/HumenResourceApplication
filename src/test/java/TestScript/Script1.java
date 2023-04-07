package TestScript;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;




public class Script1 extends BaseClass   {


	@Test
	public void individualHomeRegistration() throws Throwable {

		
		home.clickOnLogin();
		login.loginToApp(USERNAME, PASSWORD);
		
		home.registerModuel();

		Map<String, String> map = eLib.readMultipleDataFromExcel("Sheet1");

		
		individual.fetchDataFromExcel(map, driver);
		individual.handleDropDown(wLib);

		individual.imageButton(FILEPATH);
		
		individual.submitButton();
       
		
	}
}

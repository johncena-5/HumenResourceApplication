package TestScript;

import java.util.Map;

import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;

public class Script5 extends BaseClass {
	
	@Test
	public void script5() throws Throwable {
		
		home.clickOnLogin();
		
		login.loginToApp(USERNAME, PASSWORD);
		
		home.registerModuel();
		
		Map<String, String> map = eLib.readMultipleDataFromExcel("Sheet1");

		individual.fetchDataFromExcel(map, driver);
		individual.handleDropDown(wLib);

		individual.imageButton(FILEPATH);

		individual.submitButton();
		
		home.detailsUpdateModuel();
		
		details.clickOnEditButton(driver);
		
		
		
	}

}

package TestScript;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.GenericUtility.BaseClass;
import com.GenericUtility.DatabaseUtility;
import com.GenericUtility.ExcelUtility;
import com.GenericUtility.FileUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriverUtility;
import com.Pompages.HomePage;
import com.Pompages.UserRegistrationPage;

public class Script3 extends BaseClass {

	@Test
	public void script3() throws Throwable {

		
		user.clickOnRegister();
		
		HashMap<String, String> map = eLib.readMultipleDataFromExcel("Sheet2");
		user.fetchDataFromExcel(map, driver);
		

	}
}

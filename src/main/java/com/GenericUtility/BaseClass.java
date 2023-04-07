package com.GenericUtility;



import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.Pompages.ApartmentRegistrationPage;
import com.Pompages.DetailsUpdatePage;
import com.Pompages.HomePage;
import com.Pompages.IndividualHomeRegistrationPage;
import com.Pompages.LoginPage;
import com.Pompages.SendSmsPage;
import com.Pompages.UserRegistrationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	protected WebDriverUtility wLib ;
	protected FileUtility fLib ;
	protected JavaUtility jLib ;
	protected ExcelUtility eLib ;
	protected DatabaseUtility dLib ;
	protected WebDriver driver;
    static WebDriver sdriver;
	protected LoginPage login;
	protected HomePage home;
	protected SendSmsPage sms;
	protected UserRegistrationPage user;
	protected IndividualHomeRegistrationPage individual;
	protected ApartmentRegistrationPage apartment;
	protected DetailsUpdatePage details;
	protected String FILEPATH;
	protected String USERNAME;
	protected String PASSWORD;
	
    @BeforeSuite
    public void suiteConfiguration() throws Throwable {
    	
    	dLib = new DatabaseUtility();
    	dLib.registerDB();
    	System.out.println("--connect to DB--");
    }
    
    
    @BeforeClass
	public void classConfiguration() {
    	
    	wLib = new WebDriverUtility();
    	eLib = new ExcelUtility();
    	jLib = new JavaUtility();
    	fLib = new FileUtility();
    	
    	String BROWSER = fLib.readDataFromPropertyFile("browser");
    	String URL = fLib.readDataFromPropertyFile("url");
    	FILEPATH = fLib.readDataFromPropertyFile("filepath");
    	
    	
    	driver = wLib.openBrowser(BROWSER, URL);
    	sdriver = driver;
    	wLib.maximizeWindow();
    	wLib.implicitlyWait();
    	System.out.println("launch the browser");
		
	}
	
	@BeforeMethod
	public void methodConfiguration()   {
		
		login = new LoginPage(driver);
		home = new HomePage(driver);
		sms = new SendSmsPage(driver);
		user = new UserRegistrationPage(driver);
		individual = new IndividualHomeRegistrationPage(driver);
		apartment = new ApartmentRegistrationPage(driver);
		details = new DetailsUpdatePage(driver);
		
	    USERNAME = fLib.readDataFromPropertyFile("username");
		PASSWORD = fLib.readDataFromPropertyFile("password");
		
		System.out.println("login to the application");
		
	}

	@AfterMethod
	public void methodTearDown() {
		eLib.closeExcel();
		System.out.println("close the excel ");
	}

	@AfterClass
	public void classTearDown()  {
		wLib.quitBrowser();
		System.out.println("close the browser");
	}
	
	@AfterSuite
	public void suiteTearDown() throws SQLException {
		dLib.closeDatabase();
		System.out.println("close the database connection");
	}
}

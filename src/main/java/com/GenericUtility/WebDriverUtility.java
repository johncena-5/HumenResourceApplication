	package com.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {
	
	 WebDriver driver ;
	 Actions action ;
	 WebDriverWait wait ;
	 Select select;
	 /**
	  * This method is used for select the drop down element using index
	  * @param element
	  * @param index
	  */
	public void dropDown(WebElement element, int index) {
		
		select= new Select(element);
		select.selectByIndex(index);
		
	}
	/**
	 * This method is used to select the drop down  element using value
	 * @param element
	 * @param value
	 */
	
     public void dropDown(WebElement element, String value) {
		
		select = new Select(element);
		select.selectByValue(value);
	}
     /**
      * This method is used to select the element using text
      * @param text
      * @param element
      */
     public void dropDown(String text, WebElement element) {
 		
 		select = new Select(element);
 		select.selectByVisibleText(text);
 	}
     /**
      * This method is used to mouse over on the particular element
      * @param element
      */
    public void mouseHover(WebElement element) {
    	 action= new Actions(driver);
    	 action.moveToElement(element).perform();
     }
    /**
     * This method is used to double click on element
     * @param element
     */
    public void doubleClick(WebElement element) {
     action= new Actions(driver);
   	 action.doubleClick(element).perform();
    }
    /**
     * This method is used to right click on element
     * @param element
     */
    public void rightClick(WebElement element) {
     action= new Actions(driver);
   	 action.contextClick(element).perform();
    }
    /**
     * This method is used to drag and drop
     * @param element
     * @param src
     * @param dest
     */
    public void dragAndDrop(WebElement element, WebElement src, WebElement dest) {
   	 
   	 action.dragAndDrop(src , dest).perform();
    }
    /**
     * This method is used to maximize the window
     */
    public void maximizeWindow() {
    	driver.manage().window().maximize();
    }
    /**
     * This method is for implicitly wait
     */
    public void implicitlyWait() {
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    /**
     * This method is used to wait until element to visible
     * @param element
     */
    public void visibilityOfElement(WebElement element) {
    	wait= new WebDriverWait(driver,10);
    	wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    /**
     * This method is used to wait until element to be click able
     * @param element
     */
    public void elementToBeClickable(WebElement element) {
    	wait= new WebDriverWait(driver,10);
    	wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    /**
     * This method is used to take a screenshot
     * @param shot
     * @return 
     * @throws Throwable
     */
    
    public String getScreenshot(WebDriver driver, String name) {
    	
    	TakesScreenshot ts = (TakesScreenshot)driver;
    	File src = ts.getScreenshotAs(OutputType.FILE);
    	File dest = new File("./Screen/"+name+".png");
    	try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	 return dest.getAbsolutePath();
    }
       
    
    
    /**
     * This method is used to switch into frame by index value
     * @param index 
     */
    public void switchToFrame(int index) {
    	driver.switchTo().frame(index);
    }
    /**
     * This method is used to switch into frame by using WebElement reference
     * @param element
     */
    public void switchToFrame(String element) {
    	driver.switchTo().frame(element);
    }
    /**
     * This method is used to switch back to frame
     */
    public void switchBackToFrame() {
    	driver.switchTo().defaultContent();
    }
    /**
     * This method is used to close current window
     */
    public void closeCurrentWindow() {
    	driver.close();
    }
    /**
     * This method is used to close all the tab and quit the browser
     */
    public void quitBrowser() {
    	driver.quit();
    }
    /**
     * This method is used switch into alert pop up and accept alert pop
     */
    public void acceptAlert() {
    	driver.switchTo().alert().accept();
    }
    /**
     * This method is used to switch into alert pop up and dismiss
     */
    public void dismissAlert() {
    	driver.switchTo().alert().dismiss();
    }
    /**
     * This method is used to get the text from alert pop up
     */
    public void getTextAlert() {
    	driver.switchTo().alert().getText();
    }
   /**
    * This method is used to handle child browser
    */
    public void handleChildBrowserPop() {
    	
    	Set<String> child = driver.getWindowHandles();
    	for (String str : child) {
			driver.switchTo().window(str);
		}
    }
    /**
     * This method is used to switch back from child to parent window
     */
    public void switchBackToParentWindow() {
    	driver.switchTo().window(driver.getWindowHandle());
    }
    /**
     * This method is used to disable notification
     * @return
     */
    public ChromeOptions disableNotification() {
    	ChromeOptions option = new ChromeOptions();
    	option.addArguments("--disable-notifications");
    	return option;
    }
    /**
     * This method is used  to scroll till element
     * @param element
     */
    public void scrollToElement(WebElement element) {
    	
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments.scrollIntoView(true)", element);
    }
    /**
     * This method is used to open browser
     * @param browser
     * @param URL 
     * @param driver
     * @return
     */
   public WebDriver openBrowser(String browser, String URL) {
	  
       switch(browser) {
       
       case "chrome" : WebDriverManager.chromedriver().setup();
                       driver = new ChromeDriver();
                       break;
       case "firefox": WebDriverManager.firefoxdriver().setup();
                       driver = new FirefoxDriver();
                       break;
       case "edge"   : WebDriverManager.edgedriver().setup();
                       driver = new EdgeDriver();
                       break; 
           default   : System.out.println("enter valid browser");
       }
       driver.get(URL);
       return driver;
   }
   /**
    * This is used to get the full screen
    */
   public void fullScreen() {
	   driver.manage().window().fullscreen();
   }
   /**
    * This method is used to refresh the page
    */
   public void refreshThePage() {
	   driver.navigate().refresh();
   }
   /**
    * This method is used to back to previous page
    */
   public void backToThePreviousPage() {
	   driver.navigate().back();
   }
   /**
    * This method is used to go to next page
    */
   public void goToNextPage() {
	   driver.navigate().forward();
   }
 }
    





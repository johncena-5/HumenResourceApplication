package com.Pompages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendSmsPage {
	
	@FindBy(name="message") private WebElement messageTF;
	@FindBy(name="sms_alert") private WebElement sendSmsButton;
	@FindBy(id="selectAll") private WebElement selectAll;
	@FindBy(xpath="//tbody/tr") private List<WebElement> particularperson;
	
    public SendSmsPage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
    
    public void sendSmsToUser(WebDriver driver) {
    	
    	String FullName="Mohit Malhotra";
    	boolean flag = false;
    	for (int i=0; i<particularperson.size(); i++) {
			
		
    	if(particularperson.get(i).getText().contains(FullName)) {
    		flag = true;
    		driver.findElements(By.xpath("//tbody/tr/th/input")).get(i).click();
    	}
    	
      }
    	if(!flag)
    		selectAll.click();
    	
    }
    
    public void writeMessageAndSend() {
    	messageTF.sendKeys("offer");
    	sendSmsButton.click();
    }
}

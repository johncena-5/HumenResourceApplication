package com.Pompages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailsUpdatePage {

	

	public DetailsUpdatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnEditButton(WebDriver driver) {
		String fullname = "admin";
		String mob = "8426587596";
		
		driver.findElement(By.xpath("//p[contains(text(),'"+fullname+"')]/following-sibling::p[text()='"+mob+"']/ancestor::div[@class=\"card-block\"]/child::a")).click();
			
		
	}
}

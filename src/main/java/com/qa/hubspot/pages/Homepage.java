package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class Homepage extends BasePage {
	
	private WebDriver driver;
	
	By header = By.cssSelector("h1.private-header__heading ");
	By accountName = By.cssSelector("span.account-name ");
	
	
	public Homepage (WebDriver driver) {
		
		this.driver = driver;
		
		
	}
	
	
	public String getHomePageTitle() {
		
		return driver.getTitle();
		
	}
	

	public String getHomepageHeaderText() {
		
		if (driver.findElement(header).isDisplayed()){
			
			return driver.findElement(header).getText();
		}
		
		return null;
	}
	
	
	
	public String getLoggedInUser() {
		
		if (driver.findElement(accountName).isDisplayed()){
			
			return driver.findElement(accountName).getText();
			
		}
		
		return null;
	}
	
}

package com.qa.hubspot.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
		
WebDriver driver;


public ElementUtil(WebDriver driver) {
	
	
	this.driver = driver;
	
}	

public List<WebElement> getElements(By locator) {
	
	List<WebElement>elementsList = driver.findElements(locator);
	
	return elementsList;
	
	
	
	
	
}

public WebElement getElement(By locator) {
	
WebElement element = null;	
	
try {
	
	element = driver.findElement(locator);
	
	System.out.println("WebElement created sucessfully : " + locator);
	
}

catch(Exception e) {
	
	
	
	System.out.println("some exception got occured in locator :" +  locator);
}



return element;
	
}

public void doSendKeys(By locator, String value) {
	getElement(locator).sendKeys(value);
	
	
}

public void doClick(By locator) {
	
	getElement(locator).click();
	
	
}

	
public String doGetText(By locator) {
	
	return getElement(locator).getText();
	
	
	
}

public boolean doIsDisplayed(By locator) {

	return getElement(locator).isDisplayed();
	
	
}

public  void doselectByVisibleText(By locator, String value) {
	
    Select select = new Select(getElement (locator));
   
   select.selectByVisibleText(value);	
 		
	
}



public void doselectByIndex(By locator, int index) {
	
   Select select = new Select(getElement(locator));
   
   select.selectByIndex(index);		
 		

}


public void doselectByValue(By locator, String value) {
	
   Select select = new Select(getElement(locator));
   
   select.selectByValue(value);	
}


public int doDropDownoptionsCount( By locator) {
	
	
	return doGetDropdownOptions(locator).size();
	
	
}



public  ArrayList<String> doGetDropdownOptions( By locator){
	
	
	ArrayList<String>ar = new ArrayList<String>();
	
	
	Select select = new Select(getElement(locator));
     List<WebElement> OptionsList = select.getOptions();
     //System.out.println(optionsList.size());
     	
		for (int i = 0; i<OptionsList.size();i++) {
			String text = OptionsList.get(i).getText();
			ar.add(text);
			//System.out.println(text);
			
	
		}
	
	return ar;
}

public void doSelectDropDownValue(By locator, String value) {
	
	 Select selectday = new Select(getElement(locator));
    List<WebElement> OptionsList = selectday.getOptions();
   // System.out.println(daysList.size());
    
		for (int i = 0; i< OptionsList.size();i++) {
			String text = OptionsList.get(i).getText();
			//System.out.println(text);
			if(text.equals(value)) {
			OptionsList.get(i).click();
			break;
				
			}
		}			
	
}


public  void doSelectDropDownValueWithoutSelect(By locator,String value){
	  
	 List<WebElement> optionsList = driver.findElements(locator); 
	
	 for (int i = 0;i<optionsList.size();i++) {
  	  
	    	 String text = optionsList.get(i).getText();
	    	  
	    	 if(text.equals(value)) {
	    		  
	    		 optionsList.get(i).click();
	    		  
	    	  break;
	    		  
	    		  
	    		  
	    	  }
	    	  
	 }
	 
	 
	 
}

public WebElement waitForElementPresent(By locator, int timeout) {
	
	WebDriverWait wait = new WebDriverWait(driver, timeout);
	WebElement element = wait.until(ExpectedConditions. presenceOfElementLocated(locator));
	return element;
	
}



public WebElement waitForElementToBeVisible(By locator, int timeout) {
	
	WebDriverWait wait = new WebDriverWait(driver, timeout);
	WebElement element = wait.until(ExpectedConditions. presenceOfElementLocated(locator));
	return element;
}



public WebElement waitForElementToBeClickable(By locator, int timeout) {
	
	WebDriverWait wait = new WebDriverWait(driver, timeout);
	WebElement element = wait.until(ExpectedConditions. presenceOfElementLocated(locator));
	return element;
}















}


	
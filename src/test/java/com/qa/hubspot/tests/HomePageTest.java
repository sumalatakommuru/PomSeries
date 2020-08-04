package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.Homepage;
import com.qa.hubspot.utils.Constants;

public class HomePageTest extends BaseTest{
	
	Homepage homePage;
	
	@BeforeClass
	
	public void homeSetup() {
		
	homePage = loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	

@Test(priority = 3)
public void verifyHomePageTitleTest () {
	
String title = homePage.getHomePageTitle();

System.out.println("home page title is:" + title);

Assert.assertEquals(title, Constants.HOME_PAGE_TITLE, "home page title is not found..");


}


@Test(priority=1)

public void verifyHomePageHeaderTest() {
	
	String header = homePage.getHomepageHeaderText();
	System.out.println("home page header is :" + header);
	Assert.assertEquals(header, Constants.HOME_PAGE_HEADER, "home page header not present....");
	
	
}



@Test (priority=2)

public void verifyLoggedInUser() {
	
	String loggedInUser = homePage.getLoggedInUser();
	
	System.out.println("Loggedin user is :" + loggedInUser);
	
	Assert.assertEquals(loggedInUser, prop.getProperty("accountName"), "loggedi n user is not matched.....");
	
	
	
}










}
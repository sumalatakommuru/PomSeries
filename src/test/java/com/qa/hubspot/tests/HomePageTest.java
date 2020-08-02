package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.Homepage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.Constants;

public class HomePageTest {
	
WebDriver driver;
Properties prop;
BasePage basepage;
LoginPage loginpage;
Homepage  homePage;

@BeforeTest

public void setUp() {

	basepage = new BasePage();
	prop = basepage.init_prop();

	driver = basepage.inti_driver(prop);

	loginpage = new LoginPage(driver);
	
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




@AfterTest

public void teardown() {

	driver.quit();

}





}
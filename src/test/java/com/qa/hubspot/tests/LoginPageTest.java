package com.qa.hubspot.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.Homepage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.Constants;

public class LoginPageTest extends BaseTest {

	@Test(priority = 2)

	public void VerifyLoginPageTitleTest() {

		String title = loginpage.getLoginPageTitle();
		System.out.println("login page title is: " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE,"login page is not found");

	}

	@Test(priority = 1)

	public void verifysignuplink() {

		Assert.assertTrue(loginpage.verifySignUpLink(), "signup link is not found");

	}

	@Test(priority = 3)

	public void loginTest() {

		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	

}

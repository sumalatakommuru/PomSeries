package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class LoginPage extends BasePage {

	private WebDriver driver;

	// Bylocators:(OR)

	By username = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");

	// Constructors of PageClass:

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	// Page actions:(Page Features)

	public String getLoginPageTitle() {

		return driver.getTitle();
	}

	public boolean verifySignUpLink() {

		return driver.findElement(signUpLink).isDisplayed();

	}

	public Homepage doLogin(String username, String password) {

		driver.findElement(this.username).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(this.loginButton).click();
			
		return new Homepage(driver);

	}

}
	
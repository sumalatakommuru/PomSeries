	package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	WebDriver driver;
	Properties prop;
	/**
	 * This method is used to initilize the WebDriver on the basis of given browser
	 * @param browserName
	 * @return driver
	 */
	
	
	public WebDriver inti_driver(Properties prop) {
		
		String browserName = prop.getProperty("browser");
		
		
		if (browserName.equalsIgnoreCase("Chrome")) {
			
			WebDriverManager.chromedriver().setup();
			
			driver =new ChromeDriver();
		}
			
			else if (browserName.equalsIgnoreCase("firefox")) {
				
				WebDriverManager.firefoxdriver().setup();
				
				driver = new FirefoxDriver();
			}
		
			else if (browserName.equalsIgnoreCase("Safari")) {
				
				WebDriverManager.getInstance(SafariDriver.class).setup();
				
				driver = new SafariDriver();
			}
				
		
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		return driver;
		
					
				
				
				
				
				
				
			}
		/**
		 * This method is used to intialise the property from  the confi.properties	
		 * @return
		 */
				
				public Properties init_prop() { //(have to create object of property class)
					
					prop = new Properties();
					
					try {
						FileInputStream ip = new FileInputStream ("./src/main/java/com/qa/hubspot/config/config.properties ");
						
						prop.load(ip);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				return prop;
					
	
						
					
					
					
					
				}
		
			
			
			
		}
		
	



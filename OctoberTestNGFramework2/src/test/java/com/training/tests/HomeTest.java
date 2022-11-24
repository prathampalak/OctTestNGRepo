package com.training.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;

public class HomeTest extends BaseTest{
	WebDriver driver;
	String browser;
	String url;
	String username;
	String password;
	CommonUtilities common = new CommonUtilities();
	LoginPage login;
	HomePage home;
	
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		browser = common.getproperty("browser");
		driver= getDriver(browser);
		url = common.getproperty("url");
		driver.get(url);
		username = common.getproperty("name");
		password = common.getproperty("password");
	
		
		login = new LoginPage(driver);
		home = new HomePage(driver);
	}
	@Test
	public void userMenu()
	{
		login.enterIntoEmail(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickuserdropdown();
	}
	@AfterMethod
	public void teardown() {
		takescreenshot(driver);
		driver.close();
	}
}

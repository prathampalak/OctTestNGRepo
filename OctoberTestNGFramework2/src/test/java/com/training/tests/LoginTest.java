package com.training.tests;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.log.Log;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;

public class LoginTest extends BaseTest{
	WebDriver driver;
	String url;
	CommonUtilities common =new CommonUtilities();	
	String browser;
	String username;
	String password;
	String wrongusername;
	String wrongpwd;
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
		wrongusername=common.getproperty("wrongname");
		wrongpwd=common.getproperty("wrongpassword");
		
		login = new LoginPage(driver);
		home = new HomePage(driver);
		DOMConfigurator.configure("log4j.xml");
	}
	
	
	@Test
	public void loginwithValidUsername() {
		Log.info("Username="+username);
		login.enterIntoEmail(username);
		Log.info("Password="+password);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		}
	@Test
	public void loginErrormessage() {
		login.enterIntoEmail(username);
		login.clearElement();
		login.clickOnLogin();
	}
	@Test
	public void checkRemeberMe() 
	{
		login.enterIntoEmail(username);
		login.enterIntoPassword(password);
		login.checkbox();
		login.clickOnLogin();
		home.clickuserdropdown();
		home.logout();
		login.validation(username);
	}
	@Test
	public void forgotPassword4A()
	{
		login.clickonForgot();
		login.forgotEnterUserName(username);
		login.clickonContinue();
	}
	@Test
	
	public void forgotPassword4B()
	{

		login.enterIntoEmail(wrongusername);
		login.enterIntoPassword(wrongpwd);
		login.clickOnLogin();
		Log.error("error message");
		login.errormsg();
	}
	@AfterMethod
	public void teardown() {
		takescreenshot(driver);
		driver.close();
	}
	

}

package com.training.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.HomePage;
import com.training.pages.LeadPage;
import com.training.pages.LoginPage;
import com.training.pages.UserMenuPage;
import com.training.utilities.CommonUtilities;

public class LeadTest extends BaseTest{
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
	LeadPage lead;
	UserMenuPage menu;
	
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
		lead =new  LeadPage(driver);
		menu=new UserMenuPage(driver);
	}
	
	@Test
	public void checkLeadsTab()
	{
		login.enterIntoEmail(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnLeadTab();	
	}
	
	@Test
	public void leadSelectView()
	{
		login.enterIntoEmail(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnLeadTab();
		lead.clickOnLeadDropDown();
		}
	@Test()
	
	public void defaultView()
	{
		login.enterIntoEmail(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnLeadTab();
		lead.selectMyUnread();
		home.clickuserdropdown();
		menu.clickLogout();
		login.enterIntoEmail(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnLeadTab();
		lead.clickOnGo();
		
	}
	@Test
	public void listTodaysLeads()
	{
		login.enterIntoEmail(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnLeadTab();
		lead.selectTodayLead();
	}
	@Test
	public void checkNewOnLeads()
	{

		login.enterIntoEmail(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnLeadTab();
		lead.clickOnNew();
		lead.enterLastName("ABCD");
		lead.enterCompanyName("ABCD");
		lead.clickONSave();
	}

}

package com.training.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.ContactPage;
import com.training.pages.HomePage;
import com.training.pages.LeadPage;
import com.training.pages.LoginPage;
import com.training.pages.UserMenuPage;
import com.training.utilities.CommonUtilities;

public class RandomScenarioTest extends BaseTest{
	WebDriver driver;
	String url;
	CommonUtilities common =new CommonUtilities();	
	String browser;
	String username;
	String password;

	LoginPage login;
	HomePage home;
	LeadPage lead;
	UserMenuPage menu;
	ContactPage contact;
	
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
		menu=new UserMenuPage(driver);
		contact=new ContactPage(driver);
	}
	@Test
	public void verifyFirstLastName33()
	{

		login.enterIntoEmail(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnHomeTab();
		home.verifyUserName();
	}
	@Test
	public void verifyTheEditedLastName34()
	{
		login.enterIntoEmail(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnHomeTab();
		
		home.clickOnUserNameLink();
		menu.clickOnEditProfile();
		menu.switchToFrame();
		menu.clickOnAboutTab();
		menu.enterlastName("Abcd");
		menu.clickOnSaveall();
		
		}
	@Test
	public void verifyTheTabCustomization35()
	{
		login.enterIntoEmail(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnAllTab();
		home.ClickCustomizeMyTab();
		home.removeSelectedtab();
		home.clickOnSave();
		home.userMenuoption();
		home.logout();
		login.enterIntoEmail(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		}
	@Test
	public void blockingAnEvent36()
	{
		login.enterIntoEmail(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnHomeTab();
		home.clickOnCurrentDate();
		home.clickonStartTime();
		home.clickonSubjectCombo();
		home.clickOnEndtime();
		home.pickEndTimeFromDropDown();
		home.clickOnSave();
	}
	
	@Test
	public void blockingEventWeeklyRecurrance37()
	{
		login.enterIntoEmail(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnHomeTab();
		home.clickOnCurrentDate();
		home.clickonTimelink();
		home.clickonSubjectCombo();
		home.clickOnEndtime();
		home.clickRecurrenceCheckox();
		home.selectWeeklyradioButton();
		home.enterEnddate();
		home.clickOnSave();


	}
}

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

public class ContactTest extends BaseTest{
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
		lead =new  LeadPage(driver);
		menu=new UserMenuPage(driver);
		contact=new ContactPage(driver);
}
@Test
public void createNewContact25()
{

	login.enterIntoEmail(username);
	login.enterIntoPassword(password);
	login.clickOnLogin();
	home.clickOnContactTab();
	contact.clickNewButton();
	contact.enterlastName("Singh");
	contact.accountName("Account");
	contact.clickOnsave();
}
@Test
public void createNewView26()
{
	login.enterIntoEmail(username);
	login.enterIntoPassword(password);
	login.clickOnLogin();
	home.clickOnContactTab();
	contact.createNewview();
	contact.enterViewName("View1");
	contact.enterUniqueViewName("UniqueView1");
	contact.clickOnsave();
}
@Test
public void recentlyCreatedContact27()
{
	login.enterIntoEmail(username);
	login.enterIntoPassword(password);
	login.clickOnLogin();
	home.clickOnContactTab();
	contact.RecentlyCreatedContact();
}
	@Test
	public void checkMyContactView28()
	{
		login.enterIntoEmail(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnContactTab();
		contact.selectMyContact();
	}
	@Test
	public void viewContact29()
	{

		login.enterIntoEmail(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnContactTab();
		contact.contactname();
	}
	@Test
	public void checkTheError30()
	{

		login.enterIntoEmail(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnContactTab();
		contact.clickOnCreateNewview();
		contact.enterUniqueViewName("EFGH");
		contact.clickOnsave();
		contact.errorValidation();
	}
	@Test
	public void checkTheCancelButton31()
	{
		login.enterIntoEmail(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnContactTab();
		contact.clickOnCreateNewview();
		contact.enterViewName("ABCD");
		contact.enterUniqueViewName("EFGH");
		contact.clickOnCancel();
	}
	
	@Test
	public void checkSaveAndNewButton()
	{
		login.enterIntoEmail(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnContactTab();
		contact.clickNewButton();
		contact.enterlastName("Indian");
		contact.accountName("Global Media");
		contact.clickOnSaveNew();
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

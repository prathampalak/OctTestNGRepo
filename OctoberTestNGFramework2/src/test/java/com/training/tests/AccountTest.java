package com.training.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.AccountPage;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;

public class AccountTest extends BaseTest{
	WebDriver driver;
	String url;
	String browser;
	String username;
	String password;
	CommonUtilities common =new CommonUtilities();
	LoginPage login;
	HomePage home;
	AccountPage account;
	@BeforeMethod
	public void beforeMethod() throws IOException
	{
		browser=common.getproperty("browser");
		driver=getDriver(browser);
		url=common.getproperty("url");
		driver.get(url);
		username = common.getproperty("name");
		password = common.getproperty("password");
		login=new LoginPage(driver);
		home=new HomePage(driver);
		account=new AccountPage(driver);
		
	}
	@Test
	public void createAccount10()
	{
		login.enterIntoEmail(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnAccountTab();
		account.clickNewaccount();
		account.enterAccountName("Account12");
		account.enterAccountType();
		account.priority();
		account.clickOnSave();
	}
	@Test
	public void createNewView11()
	{
		login.enterIntoEmail(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnAccountTab();
		account.clickCreateNewview();
		account.enterViewName();
		account.enterUniqueName();
		account.clickOnSave();
	}
	@Test
	public void editView12()
	{
		login.enterIntoEmail(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnAccountTab();
		account.clickCreateNewview();
		
		account.enterViewName();
		account.selectField();
		account.selectOperator();
		account.enterValue();
		account.clickOnSave();
	}
	@Test
	public void mergeAccount13()
	{

		login.enterIntoEmail(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnAccountTab();
		account.clickOnMergeAccount();
		account.enterSearchAccount("Account12");
		account.clickonFindButton();
		account.clickcheckBox();
		account.clickOnNext();
		account.merge();
		driver.switchTo().alert().accept();

	}
	@Test
	public void createAccountReport14()
	{
		login.enterIntoEmail(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnAccountTab();
		account.createAccountReport();
		account.selectReport();
		account.saveReport();
		
	}
	@AfterMethod
	public void teardown() {
		takescreenshot(driver);
		driver.close();

}
	

}
	
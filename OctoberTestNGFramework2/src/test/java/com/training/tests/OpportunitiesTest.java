package com.training.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.pages.OpportunitiesPage;
import com.training.utilities.CommonUtilities;

public class OpportunitiesTest extends BaseTest {
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
	OpportunitiesPage oppo;
	
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
		oppo= new OpportunitiesPage(driver);
		
	}
	@Test
	
	public void opportunitiesDropdown15()
	{
		login.enterIntoEmail(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickonOpportunityTab();
		oppo.clickonOppoDropDown();
		
	}
	@Test
	public void createNewOpty16()
	{
		login.enterIntoEmail(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickonOpportunityTab();
		oppo.clickOnNewbtn();
		oppo.enterOpportunityName("OpportunityOne");
		oppo.enteraccountName();
//		oppo.closingDate();
//		oppo.selectFromStage();
//		oppo.enterProbability("50");
//		oppo.selectLeadSource();
//		oppo.primaryCampaignSource("Campaign");
//		oppo.clickonSave();
		
	}
		@Test
		
	public void opportunityPipelineReport()
	{
		login.enterIntoEmail(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickonOpportunityTab();
		oppo.clickOnOpportunityPipeline();
	}
		@Test
		
		public void stuckOpportunitiesReport()
		{
			login.enterIntoEmail(username);
			login.enterIntoPassword(password);
			login.clickOnLogin();
			home.clickonOpportunityTab();
			oppo.stuckOpportunities();
		}
		@Test
		
		public void quarterlySummaryReport()
		{
			login.enterIntoEmail(username);
			login.enterIntoPassword(password);
			login.clickOnLogin();
			home.clickonOpportunityTab();
			oppo.clickOnInterval();
			oppo.clickOnInclude();
			oppo.clickOnRunReport();
		}
		
//	@AfterMethod
//	public void teardown() {
//		
//		
//		takescreenshot(driver);
//		driver.close();
//	}

}

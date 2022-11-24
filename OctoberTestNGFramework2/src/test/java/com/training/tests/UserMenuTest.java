package com.training.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.pages.UserMenuPage;
import com.training.utilities.CommonUtilities;

public class UserMenuTest extends BaseTest {
	WebDriver driver;
	String url;
	CommonUtilities common=new CommonUtilities();

	String browser;
	String username;
	String password;
	LoginPage login;
	HomePage home;
	UserMenuPage menu;
	
	
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
		menu=new UserMenuPage(driver);
		
	}
	@Test
	public void SelectUserMenu5()
	{
			login.enterIntoEmail(username);
			login.enterIntoPassword(password);
			login.clickOnLogin();
			home.clickuserdropdown();
			home.userMenuoption();
			
	}
	@Test
	public void selectMyProfile6()
	{
		login.enterIntoEmail(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickuserdropdown(); 
		
		menu.clickMyProfile();
		menu.clickOnEditProfile();
		menu.switchToFrame();
		menu.clickOnAboutTab();
		menu.enterlastName("kumari");
		menu.clickOnSaveall();
        menu.clickpostlink();
		menu.switchToPostFrame();
		menu.enterTextTopost("how are you");
		menu.switchToDefault();
		menu.clickOnshareButton();
		menu.clickOnFilelLink();
		menu.clickonUploadFile();
		menu.ClickonChooseFile();
	}
	@Test
	public void selectMysetting7()
		{
			login.enterIntoEmail(username);
			login.enterIntoPassword(password);
			login.clickOnLogin();
			home.clickuserdropdown(); 
			
		}
		
		

	
	@Test
	public void selectDevloperConsole8() throws InterruptedException
	{
		SelectUserMenu5();
		menu.clickDevloperConsole();
		menu.switchWindowPopUp();
	}
	@Test
	
	public void selectLogout9()
	{
		SelectUserMenu5();
		menu.clickLogout();
	}
	@AfterMethod
	public void teardown() {
		takescreenshot(driver);
		driver.close();

}
}
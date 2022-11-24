package com.training.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.training.base.BasePage;

public class UserMenuPage extends BasePage {
	public UserMenuPage(WebDriver driver)
	{
		super(driver);
	}
//	@FindBy(id="userNav")
//	WebElement userMenubtn;
	
	@FindBy(id="userNav-menuItems")
	WebElement menuOptions;
	@FindBy(xpath="//a[@title='My Profile']")
	WebElement myprofile;
	@FindBy (xpath="//a[(@class='contactInfoLaunch editLink')]//img")
	WebElement editProfile;
	@FindBy(xpath="//a[@title='My Settings']")
	WebElement mysetting;
	@FindBy(xpath="//a[@title='Developer Console (New Window)']")
	WebElement devloperconsole;
	@FindBy(xpath="//a[@title='Logout']")
	WebElement logout;
	@FindBy(xpath="//iframe[@id='contactInfoContentId']")
	WebElement editProfileFrame;
	@FindBy(xpath="//a[contains(text(),'About')]")	
	WebElement about;
	@FindBy(id="lastName")
	WebElement lastname;
	@FindBy(xpath="//input[@value='Save All']")
	WebElement saveAllbtn;
	
	@FindBy(xpath="//iframe[@class='cke_wysiwyg_frame cke_reset']")
	WebElement postframe;
	@FindBy(className="publisherattachtext")
	WebElement post;
	@FindBy(xpath="//body[@class='chatterPublisherRTE cke_editable cke_editable_themed cke_contents_ltr cke_show_borders placeholder']")
	WebElement postText;
	
	@FindBy(id="publishersharebutton")
	WebElement share;
	@FindBy(xpath="//span[text()='File']")
	WebElement file;
	@FindBy(id="chatterUploadFileAction")
	WebElement uploadFile;
	@FindBy(id="chatterFile")
	WebElement choosefile;
	@FindBy(id="PersonalInfo_font")
	WebElement personal;
	@FindBy(id="LoginHistory_font")
	WebElement loginHistory;
	@FindBy(id="firstName")
	WebElement firstname;
//	public void clickOnMenuButton()
//	{
//		userMenubtn.click();
//	}
	public void switchToDefault()
	{
		driver.switchTo().defaultContent();
	}
	public void clickMyProfile()
	{
		waitForElement(20,myprofile);
		myprofile.click();
	}
	public void clickOnMysetting()
	{
	mysetting.click();
	}
	public void clickOnPersonal()
	{
		personal.click();
	}
	public void enterTextTopost(String str)
	{
		waitForElement(20,postText);
		
		postText.sendKeys(str);
	}
	public void clickOnEditProfile()
	{
		waitForElement(20,editProfile);
		editProfile.click();
	}
	public void switchToFrame()
	{
		driver.switchTo().frame(editProfileFrame);
	}
	public void switchToPostFrame()
	{
		driver.switchTo().frame(postframe);
	}
	public void clickOnAboutTab()
	{
		about.click();
		
	}
	public void enterlastName(String lname)
	{
		lastname.clear();
		lastname.sendKeys(lname);
	}
	public void clickOnSaveall()
	{
		saveAllbtn.click();
	}
	
	public void clickpostlink()
	{
		post.click();
	}
	public void clickOnshareButton()
	{
		share.click();
	}
	public void clickOnFilelLink()
	{
		file.click();
	}
	public void clickonUploadFile()
	{
		uploadFile.click();
	}
	public void ClickonChooseFile()
	{
		choosefile.click();
		choosefile.sendKeys("C:\\Users\\deepa\\Documents\\flower.bmp");
	}
	
	public void clickDevloperConsole()
	{
		devloperconsole.click();
		System.out.println("console clicked");
	}
	public void clickLogout()
	{
		waitForElement(20,logout);
		logout.click();
	}
	public void switchWindowPopUp() throws InterruptedException
	{
		String oldwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		for (String handle : allwindows) {
			if (!oldwindow.equals(handle)) {
				driver.switchTo().window(handle);
				System.out.println("current window Title is=" + driver.getTitle());
				driver.close();
				break;
			}
			Thread.sleep(3000);
		}
		
		driver.switchTo().window(oldwindow);
		System.out.println("current window Title is=" + driver.getTitle());
		}
	
	public void userMenuoption() {
		waitForElement(20, menuOptions);
		System.out.println(menuOptions.getText());
		String actual=menuOptions.getText();
		System.out.println("actual"+actual);
		String expected="My Profile\n"
						+"My Settings\n"
						+"Developer Console\n"
						+"Switch to Lightning Experience\n"
						+"Logout";
		
		assertmethod(actual,expected);
		System.out.println("Pass");
	}
	public void assertmethod(String actualString,String expectedString)
	{
		Assert.assertEquals(actualString, expectedString);
		System.out.println("content are same");
	}
}

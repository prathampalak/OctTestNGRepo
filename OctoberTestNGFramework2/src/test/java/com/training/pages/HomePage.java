package com.training.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.training.base.BasePage;

public class HomePage extends BasePage
{
	public HomePage(WebDriver driver) {
		 super(driver);
	 }
	
	@FindBy(id="userNavButton")
	WebElement usermenudropdown;
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement logout;
	@FindBy(id="Account_Tab")
	WebElement accountTab;
	@FindBy(id="userNav-menuItems")
	WebElement menuOptions;
	@FindBy(id="Opportunity_Tab")
	WebElement opportunity;
	@FindBy(id="tryLexDialogX")
	WebElement closebtn;
	@FindBy(id="Lead_Tab")
	WebElement leadtab;
	@FindBy(id="Contact_Tab")
	WebElement contactTab;
	@FindBy(id="home_Tab")
	WebElement homeTab;
	@FindBy(xpath="//a[contains(text(),'luxmi ABCD')]")
	WebElement usernamelink;
	@FindBy(id="AllTab_Tab")
	WebElement allTab;
	@FindBy(className="btnImportant")
	WebElement customTab;
	@FindBy(xpath="//select[@id='duel_select_1']")
	WebElement selectedTab;
	@FindBy(xpath="//img[contains(@class,'leftArrowIcon')]")
	WebElement removeBtn;
	@FindBy(name="save")
	WebElement save;
	@FindBy(xpath="//span[@class='pageDescription']/a[1]")
	WebElement currentDate;
	@FindBy(xpath="//a[contains(text(),'8:00 PM')]")
	WebElement startTime;
	@FindBy(xpath="//img[@class='comboboxIcon']")
	WebElement subjectCombo;
	@FindBy(xpath="//a[contains(text(),'Other')]")
	WebElement other;
	@FindBy(id="EndDateTime_time")
	WebElement endTime;
	@FindBy(xpath="//div[@id='timePickerItem_42']")
	WebElement pickEndTime;
@FindBy(xpath="//a[contains(text(),'4:00 PM')]")
	WebElement timelink;
	@FindBy(id="simpleTimePicker")
	WebElement pickTime;
	@FindBy(id="IsRecurrence")
	WebElement recurrence;
	@FindBy(id="//input[@id='rectypeftw']")
	WebElement weekly;
	@FindBy(id="di")
	WebElement recurs;
	@FindBy (id="16")
	WebElement day;
	@FindBy(id="RecurrenceEndDateOnly")
	WebElement endDate;
	@FindBy(id="timePickerItem_38")
	WebElement etime;
	public void selectWeeklyradioButton()
	{
		waitForElement(20,weekly);
		weekly.click();
		waitForElement(20,recurs);
		recurs.sendKeys("1");
		waitForElement(20,day);
		day.click();
		}
	public void enterEnddate()
	{
		waitForElement(20,endDate);
		endDate.sendKeys("11/29/2022");
	}
	public void clickOnPickTime()
	{
		waitForElement(20,pickTime);
		Select select = new Select(pickTime);
		select.selectByValue("7:00 PM");

	}
	public void clickRecurrenceCheckox()
	{
		waitForElement(20,recurrence);
		recurrence.click();

		
	}
	public void clickonTimelink()
	{
		waitForElement(20,timelink);
		timelink.click();

	}
	public void clickOnCurrentDate()
	{
		waitForElement(20,currentDate);
		currentDate.click();
	}
	public void clickonStartTime()
	{
		waitForElement(20,startTime);
		startTime.click();
	}
	public void clickonSubjectCombo()
	{
		waitForElement(20,subjectCombo);
		subjectCombo.click();
		ArrayList<String> win = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(win.get(1));
		driver.manage().window().maximize();
		other.click();
		driver.switchTo().window(win.get(0));
	}
	public void clickOnEndtime()
	{
		waitForElement(20,etime);
		etime.click();
//		//waitForElement(20,pickTime);
//		Select select = new Select(endTime);
//		select.selectByVisibleText("7:00 PM");
	}
	public void pickEndTimeFromDropDown()
	{
		waitForElement(20,pickEndTime);
		pickEndTime.click();
	}
	public void clickOnSave()
	{
		waitForElement(20,save);
		save.click();
		

	}
	
	public void clickOnAllTab()
	{
		waitForElement(20,allTab);
		allTab.click();
		}
	public void ClickCustomizeMyTab()
	{
		waitForElement(20,customTab);
		customTab.click();
			}
	public void removeSelectedtab()
	{
		waitForElement(20,removeBtn);
		Select select = new Select(selectedTab);
		select.selectByIndex(1);
		waitForElement(20,removeBtn);
		removeBtn.click();
	}
	public void verifyUserName()
	{
		waitForElement(20,usernamelink);
		String expected="luxmi ABCD";
		String actual=usernamelink.getText();
		System.out.println("actual="+actual);
		if(actual.equalsIgnoreCase(expected))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
	}
	public void clickOnUserNameLink()
	{
		waitForElement(20,usernamelink);
		usernamelink.click();

	}
	public void clickOnHomeTab()
	{
		waitForElement(20,homeTab);
		homeTab.click();
		lighteningExperiencePrompt();
	}
	
	
	public void clickOnContactTab()
	{
		waitForElement(20,contactTab);
		contactTab.click();
		lighteningExperiencePrompt();
	}
	public void clickOnLeadTab()
	{
		waitForElement(20,leadtab);
		leadtab.click();
		lighteningExperiencePrompt();
	}
	
	
	
	public void lighteningExperiencePrompt()
	{
		waitForElement(20,closebtn);
		
	
		if (closebtn.isEnabled()) 
		{
			closebtn.click();
			System.out.println("closed the popup");
		
			
		}
		
		
	}
	public void clickonOpportunityTab()
	{
		opportunity.click();
		
		lighteningExperiencePrompt();
	}
	public void clickOnAccountTab()
	{
		accountTab.click();
		lighteningExperiencePrompt();
		
	}
	
	
	public void clickuserdropdown() {
		//waitForElement(40,usermenudropdown);
		usermenudropdown.click();
		System.out.println("button clicked");
	}
	public void userMenuoption() {
		String actual=menuOptions.getText();
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
	
	
	public  void logout()
	{
		logout.click();
		System.out.println("logout");
	}
}

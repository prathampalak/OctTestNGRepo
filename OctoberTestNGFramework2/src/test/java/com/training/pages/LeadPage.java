package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.training.base.BasePage;

public class LeadPage extends BasePage{
	public LeadPage(WebDriver driver) {
		 super(driver);
	 }

@FindBy(id="fcf")
WebElement leadDropDown;
@FindBy(name="go")
WebElement goBtn; 
@FindBy(name="new")
WebElement newBtn;
@FindBy(id="name_lastlea2")
WebElement lastName;
@FindBy(id="lea3")
WebElement company;
@FindBy(name="save")
WebElement saveBtn;

public void clickOnLeadDropDown()
{
	waitForElement(20, leadDropDown);
	leadDropDown.click();
	validateLeadView();
	}
public void clickOnGo()
{
	waitForElement(20,goBtn);
	goBtn.click();
}
public void  selectMyUnread()
{
	waitForElement(20, leadDropDown);
	leadDropDown.click();
	Select select = new Select(leadDropDown);
	select.selectByVisibleText("My Unread Leads");
	
}
public void clickOnNew()
{
	waitForElement(20,newBtn);
	newBtn.click();
}
public void enterLastName(String lname)
{
	waitForElement(20,lastName);
	lastName.sendKeys(lname);
	
}
public void enterCompanyName(String compname)
{
	waitForElement(20,company);
	company.sendKeys(compname);
	
}
public void clickONSave()
{
	waitForElement(20,saveBtn);
	saveBtn.click();
}
public void selectTodayLead()
{
	waitForElement(20, leadDropDown);
	leadDropDown.click();
	Select select = new Select(leadDropDown);
	select.selectByVisibleText("Today's Leads");
}
public void validateLeadView()
{
	waitForElement(20,leadDropDown);
	System.out.println(leadDropDown.getText());
	String actual=leadDropDown.getText();
	System.out.println("actual"+actual);
	String expected="All Open Leads\n"
					+"My Unread Leads\n"
					+"Recently Viewed Leads\n"
					+"Today's Leads\n"
					+"View - Custom 1\n"
					+"View - Custom 2";
	
	assertmethod(actual,expected);
	System.out.println("Pass");
}
public void assertmethod(String actualString,String expectedString)
{
	Assert.assertEquals(actualString, expectedString);
	System.out.println("content are same");
}
}

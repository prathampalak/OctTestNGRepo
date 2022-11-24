package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class ContactPage extends BasePage{
	public ContactPage(WebDriver driver) {
		 super(driver);
}
	@FindBy(name="new")
	WebElement newContact;
	@FindBy(id="name_lastcon2")
	WebElement lastName;
	@FindBy(id="con4")
	WebElement accName;
	@FindBy(name="save")
	WebElement saveBtn;
	@FindBy(xpath="//a[contains(text(),'Create New View')]")
	WebElement newView;
	@FindBy(id="fname")
	WebElement viewName;
	@FindBy(id="devname")
	WebElement uniqueName;
	@FindBy(id="hotlist_mode")
	WebElement recent;
	@FindBy(id="fcf")
	WebElement contactView;
	@FindBy(xpath="//a[contains(text(),'kumar')]")
	WebElement contactName;
	@FindBy(xpath="//a[contains(text(),'Create New View')]")
	WebElement createView;
	@FindBy(xpath="//tbody/tr[1]/td[2]/div[1]/div[2]/strong[1]")
	WebElement error;
	@FindBy(name="cancel")
	WebElement cancel;
	@FindBy(name="save_new")
	WebElement savenew;
	public void clickOnSaveNew()
	{
		waitForElement(20,savenew);
		savenew.click();
	}
	public void clickOnCancel()
	{
		waitForElement(20,cancel);
		cancel.click();
	}
	public void contactname()
	{
		waitForElement(20,contactName);
		contactName.click();

	}
	public void clickOnCreateNewview()
	{
		waitForElement(20,createView);
		createView.click();
	}
	public void errorValidation()
	{
		String expected="Error:";
		System.out.println("expected="+expected);
		String actual=error.getText();
		System.out.println("actual="+actual);

		if(actual.equalsIgnoreCase(expected))
			System.out.println("pass");
		else
			System.out.println("fail");
	}

	public void RecentlyCreatedContact()
	{

		waitForElement(20,recent);
		recent.click();
		Select select = new Select(recent);
		select.selectByVisibleText("Recently Created");
	}
	public void selectMyContact()
	{
		waitForElement(20,contactView);
		Select select = new Select(contactView);
		select.selectByVisibleText("My Contacts");
	}
	public void createNewview()
	{
		waitForElement(20,newView);
		newView.click();
	}
	public void enterViewName(String vname)
	{
		waitForElement(20,viewName);
		viewName.sendKeys(vname);
	}
	public void enterUniqueViewName(String uniname)
	{
		waitForElement(20,uniqueName);
		uniqueName.sendKeys(uniname);
	}
	
	public void clickNewButton()
	{
		waitForElement(20,newContact);
		newContact.click();
	}
	public void enterlastName(String lname)
	{
		waitForElement(20,lastName);
		lastName.sendKeys(lname);
	}
	public void accountName(String accountname)
	{
		waitForElement(20,accName);
		accName.sendKeys(accountname);
	}
	public void clickOnsave()
	{
		waitForElement(20,saveBtn);
		saveBtn.click();
	}
}
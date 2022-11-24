package com.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class AccountPage extends BasePage {
	public AccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[@name='new']")
	WebElement newaccount;
	@FindBy(xpath="//input[@id ='acc2']")
	WebElement accountName;

	@FindBy(id= "acc6")
	WebElement accountType;
	@FindBy(id = "00N4x00000WL0VR")
	WebElement priority;
	@FindBy(name = "save")
	WebElement save;
	@FindBy(xpath = "//a[contains(text(),'Create New View')]")
	WebElement createNewView;
	@FindBy(id = "fname")
	WebElement newView;
	@FindBy(id = "devname")
	WebElement uniName;
	@FindBy(id="fcf")
	WebElement viewbox;
	@FindBy(xpath="//a[contains(text(),'Edit')]")
	WebElement edit;
	@FindBy(id="fname")
	WebElement viewName;
	@FindBy(id="fcol1")
	WebElement field;
	@FindBy(id="fop1")
	WebElement operator;
	@FindBy(id="fval1")
	WebElement value;
	@FindBy(xpath="//a[contains(text(),'Merge Accounts')]")
	WebElement mergeAccount;
	@FindBy(id="srch")
	WebElement searchAccount;
	@FindBy(name="srchbutton")
	WebElement searchBtn;
	@FindBy(id="cid0")
	WebElement checkbox1;
	@FindBy(id="cid1")
	WebElement checkbox2;
	@FindBy(name="goNext")
	WebElement next;
	@FindBy(xpath="//div[@class='pbTopButtons']//input[@title='Merge']")
	WebElement merge;
	@FindBy(xpath="//a[contains(text(),'Accounts with last activity > 30 days')]")
	WebElement lastact;
	@FindBy(css="#ext-gen20")
	WebElement dateField;
	@FindBy(xpath="//div[contains(text(),'Created Date')]")
	WebElement createDate;
	@FindBy(id="ext-gen152")
	WebElement fromCalender;
	@FindBy(xpath="//button[contains(text(),'Today')]")
	WebElement fromDate;
	@FindBy(id="ext-gen154")
	WebElement toCalender;
	@FindBy (id="ext-gen3")
	WebElement toDate;
	@FindBy(id="ext-gen49")
	WebElement savebtn;
	@FindBy(id="saveReportDlg_reportNameField")
	WebElement reportName;
	@FindBy(id="saveReportDlg_DeveloperName")
	WebElement reportUniqueName;
	@FindBy (id="ext-gen314")
	WebElement saverun;
	public void createAccountReport()
	{
		waitForElement(20,lastact);
		lastact.click();
	}
	public void selectReport()
	{
		waitForElement(20,dateField);
		dateField.click();
		waitForElement(20,createDate);
		createDate.click();
		waitForElement(20,fromCalender);
		fromCalender.click();
		waitForElement(20,fromDate);
		fromDate.click();
		waitForElement(20,toCalender);
		toCalender.click();
		waitForElement(20,toDate);
		toDate.click();
	}
	public void saveReport()
	{
		
		waitForElement(20,savebtn);
		savebtn.click();
		waitForElement(20,reportName);
		reportName.clear();
		reportName.sendKeys("report456");
		waitForElement(20,reportUniqueName);
		reportUniqueName.clear();
		reportUniqueName.sendKeys("uniqueReport456");
		waitForElement(20,saverun);
		saverun.click();
		
	}	
	public void clickcheckBox() {
		waitForElement(20,checkbox1);
if(checkbox1.isDisplayed())
{
	if(checkbox1.isSelected())
	{
		System.out.println("checkbox selected");
	}
		else
		{
			checkbox1.click();
		}
	}
	
		
waitForElement(20,checkbox2);
if(checkbox2.isDisplayed())
{
	if(checkbox2.isSelected())
	{
		System.out.println("checkbox selected");
	}
		else
		{
			checkbox2.click();
		}
	}
}
	public void clickOnNext()
	{
		waitForElement(10,next);
		next.click();
	}
	public void merge()
	{
		waitForElement(20, merge);
		merge.click();
		
	}


public void clickOnMergeAccount()
{
	waitForElement(20,mergeAccount);
	mergeAccount.click();
}
public void enterSearchAccount(String accountname)
{
	waitForElement(20,searchAccount);
	searchAccount.sendKeys(accountname);
}
public void clickonFindButton()
{
	waitForElement(20,searchBtn);
	searchBtn.click();
}
	public void clickNewaccount() {
		waitForElement(20,newaccount);
		newaccount.click();
	}

	public void enterAccountName(String accname) {
		waitForElement(20,accountName);
		accountName.sendKeys(accname);
	}

	public void enterAccountType() {
		// accountType.sendKeys("Technology Partner");
		Select select = new Select(accountType);
		select.selectByVisibleText("Technology Partner");
	}

	public void priority() {
		Select select = new Select(priority);
		select.selectByVisibleText("High");
	}

	public void clickCreateNewview() {
		waitForElement(20,createNewView);
		createNewView.click();
	}

	public void enterViewName() {
		waitForElement(20,newView);
		newView.sendKeys("Day Account");
	}

	public void enterUniqueName() {
		waitForElement(20,uniName);
		uniName.sendKeys("day_account");
	}
	public void selectview()
	{
		Select select=new Select(viewbox);
		select.selectByIndex(4);
	}

	public void clickOnSave() {
		waitForElement(20,save);
		save.click();
	}
	public void clickOnEdit()
	{
		waitForElement(20,edit);
		edit.click();
	}
	public void selectField()
	{
	
		Select select=new Select(field);
		select.selectByValue("ACCOUNT.NAME");
	}
	public void selectOperator()
	{ 
		Select select=new Select(operator);
		select.selectByValue("c");
	}
	public void enterValue()
	{
		waitForElement(20,value);
		value.sendKeys("a");
	}
	

}
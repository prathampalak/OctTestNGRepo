package com.training.pages;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class OpportunitiesPage extends BasePage{
	public OpportunitiesPage(WebDriver driver)
	{
		 super(driver);

}
	@FindBy(id="fcf")
	WebElement oppoDropDown;
	
	@FindBy(xpath="//input[@name=\"new\"]")	
	WebElement newOppo;

	@FindBy(id="opp3")
	WebElement oppoName;
	@FindBy(id="opp4")
	WebElement accName;
	@FindBy(id="opp9")
	WebElement closeDate;
	@FindBy(id="opp11")
	WebElement stage;
	@FindBy(id="opp12")
	WebElement probab;
	@FindBy(id="opp6")
	WebElement leadSource;
	@FindBy(id="opp17")
	WebElement priCampSource;
	@FindBy (className="btn")
	WebElement save;
	@FindBy(id="datePicker")
	WebElement datepicker;
@FindBy(className="lookupIcon")
WebElement accountLookUp;
@FindBy(id="resultsFrame")
WebElement resultframe;
@FindBy(id="SearchFrame")
WebElement searchframe;
@FindBy(xpath="//table[@class='list']/tbody/tr[2]/td[1]")
WebElement table;
@FindBy(xpath="//a[contains(text(),'Opportunity Pipeline')]")
WebElement oppoPipeline;
@FindBy(xpath="//a[contains(text(),'Stuck Opportunities')]")
WebElement stuckOppo;
@FindBy(id="quarter_q")
WebElement interval;
@FindBy(id="open")
WebElement include;
@FindBy(xpath="//input[@title='Run Report']")
WebElement runReport;
public void clickOnInclude()
{
	waitForElement(20,include);
	Select select1 = new Select(include);
	select1.selectByValue("all");
}
public void clickOnRunReport()
{
	waitForElement(20,runReport);
	runReport.click();
}

public void clickOnInterval()
{
	waitForElement(20,interval);
	Select select = new Select(interval);
	select.selectByValue("current");
}
public void clickOnOpportunityPipeline()
{
	oppoPipeline.click();
}
public void stuckOpportunities()
{
	stuckOppo.click();
}
	
	
	public void clickonOppoDropDown()
	{
		oppoDropDown.click();
		waitForElement(20,oppoDropDown);
		String str[] = { "All Opportunities", "Closing Next Month", "Closing This Month", "My Opportunities",
				"New Last Week", "New This Week", "Opportunity Pipeline", "Private", "Recently Viewed Opportunities",
				"Won" };
		boolean found = false;
		
		Select select = new Select(oppoDropDown);
		
		List<WebElement> allOptions = select.getOptions();
		for (int i = 0; i < allOptions.size(); i++) {
			String value = str[i];
			if (allOptions.equals(value)) 
			{
				System.out.println(value);
				found = true;
				break;
			}
		}
		if (found) {
			System.out.println("Value exists");
		}


	}
	public void clickOnNewbtn()
	{
		waitForElement(20,newOppo);
		newOppo.click();
	}
	public void enterOpportunityName(String name)
	{
		waitForElement(20,oppoName);
		oppoName.sendKeys(name);
	}
	public void enteraccountName()
	//table[@class='list']/tbody/tr[2]/td[1]//table[@class='list']/tbody/tr[2]/td[1]
	{
		accountLookUp.click();
		switchAccountWindow();
	}
	public void switchAccountWindow()
		{
		
			String oldwindow = driver.getWindowHandle();
			System.out.println("old window");
			Set<String> allwindows = driver.getWindowHandles();
			for (String handle : allwindows) {
				if (!oldwindow.equals(handle)) {
					System.out.println(driver.getTitle());
					driver.switchTo().window(handle);
					driver.switchTo().frame(searchframe);
					
					System.out.println("inframe");
					table.click();
					break;
				}
				//Thread.sleep(3000);
				}
			driver.switchTo().window(oldwindow);
		}
	
	
//	public void enterAccountName(String account)
//	{
//		waitForElement(20,accName);
//		accName.sendKeys(account);
//	}
	public void closingDate()
	{
		closeDate.click();
		datepicker.click();
	}
	public void selectFromStage()
	{
		Select select=new Select(stage);
		select.selectByIndex(1);
	}
	public void enterProbability(String pro)
	{
		probab.sendKeys(pro);
	}
	public void selectLeadSource()
	{
		Select select =new Select(leadSource);
		select.selectByIndex(1);
	}
	public void primaryCampaignSource(String source)
	{
		waitForElement(20,priCampSource);
		priCampSource.sendKeys(source);
	}
	public void clickonSave()
	{
		save.click();
	}
}
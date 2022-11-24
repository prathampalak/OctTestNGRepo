package com.training.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class LoginPage extends BasePage{
	 public LoginPage(WebDriver driver) {
		 super(driver);
	 }
	
	
		@FindBy(id="username")
		WebElement username;
	@FindBy(id="idcard")
	WebElement username2;
		
		@FindBy(xpath="//input[@id='password']")
		WebElement password;
		
		@FindBy(id="Login")
		WebElement loginButton;
		
		@FindBy(id="rememberUn")
		WebElement rememberme;
		
		@FindBy(id="forgot_password_link")
		WebElement forgot;
	
		@FindBy(id="continue")
		WebElement contbutton;
	@FindBy(id="un")
	WebElement fusername;
	@FindBy(className="loginError")
	WebElement namerrormsg;
	
	public void enterIntoEmail(String strname) {
		waitForElement(20,username);
		username.sendKeys(strname);
	}
	
	
	public void enterIntoPassword(String strpassword) {
		password.sendKeys(strpassword);
	}
	
	public void clickOnLogin() {
		loginButton.click();
	}
	public void clearElement()
	{
	password.clear();
	}
	public void checkbox()
	{
	rememberme.click();
	}
	public void validation(String expectedname)
	{
		waitForElement(20,username2);
		String actualname=username2.getText();
		System.out.println("Actual name="+actualname);
		assertEquals(actualname, expectedname);
		System.out.println("Both String are Equal");
	}
	public void clickonForgot()
	{
		forgot.click();
	}
	public void forgotEnterUserName(String strusername)
	{;
		fusername.sendKeys(strusername);
	}
	public void clickonContinue()
	{
		contbutton.click();
	}
public void errormsg()
{
	String actualname=namerrormsg.getText();
	String expected="Please check your username and password."
			+ " If you still can't log in, contact your"
			+ " Salesforce administrator.";
	if(actualname.equalsIgnoreCase(expected))
	{
		System.out.println("pass");
	}
	else
	{
		System.out.println("fail");
	}
}
}

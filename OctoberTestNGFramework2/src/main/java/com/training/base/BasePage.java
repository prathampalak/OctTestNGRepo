package com.training.base;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;

public class BasePage {
protected WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void waitForElement(int time, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}

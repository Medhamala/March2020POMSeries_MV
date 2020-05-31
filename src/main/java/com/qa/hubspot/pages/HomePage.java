package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.hubspot.base.BasePage;

public class HomePage extends BasePage {
	
	private WebDriver driver;

	//Step1: By locators - -OR
	By header =By.xpath("//i18n-string[text()='Dashboard Library']");
	By accountName = By.cssSelector("span.account-name ");
	
	
	//Step2: Constructor
	public HomePage (WebDriver driver) {
		this.driver=driver;
	}
	
	//Step3: Page Actions
	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public String  getHomePageHeaderText() {
		if (driver.findElement(header).isDisplayed()) {
		return driver.findElement(header).getText();}
		return null;
	}
		
	public String getLoggedInUser() {
		if(driver.findElement(accountName).isDisplayed()){
		return driver.findElement(accountName).getText(); }
		return null;
	}
		
	
}

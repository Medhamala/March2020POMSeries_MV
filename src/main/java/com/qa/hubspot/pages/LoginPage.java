package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class LoginPage  extends BasePage {
	private WebDriver  driver;
	
	//here 3 things we need to maintain, By locators (OR), Constructor and Page actions
	
	By username = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	
	
	//Constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Page actions or methods
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean getSignUpLink() {
		return driver.findElement(signUpLink).isDisplayed();
	}
	
	public HomePage doLogin(String username, String password) {
		//System.out.println("HI I am in doLogin");
		driver.findElement(this.username).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(this.loginButton).click();
		
		return new HomePage(driver);
	}

}

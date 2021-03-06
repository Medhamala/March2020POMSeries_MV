package com.qa.hubspot.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.Constants;


public class LoginPageTest {
	 BasePage basePage;
	 WebDriver driver;
	 LoginPage loginPage;
	
	@BeforeTest
	public void setUp() {
	basePage = new BasePage();  //if not used nullPointerException
	driver = basePage.init_driver("Chrome");
	loginPage = new  LoginPage(driver);
	}
	
	@Test(priority=2)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("login page title is: " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "LoginPage not matching...");
	}
	@Test(priority=1)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginPage.getSignUpLink(), "login Page title not matched...");				
	}
	
	@Test(priority=3)
	public void verifyLogin() {
		loginPage.doLogin("medhamala7@gmail.com", "Shivsai@786");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	} 

}

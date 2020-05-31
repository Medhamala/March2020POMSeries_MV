package com.qa.hubspot.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.Constants;

public class HomePageTest {
	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	
@BeforeTest	
public void  setUp() {
	basePage = new BasePage();
	driver=basePage.init_driver("chrome");
	loginPage = new LoginPage(driver);
	homePage =loginPage.doLogin("medhamala7@gmail.com","Shivsai@786");		
}

@Test(priority=2)
public void verifyHomePageTitleTest() {
//	try {
	String title = homePage.getHomePageTitle();
	System.out.println("Home Page title is :" + title);
	Assert.assertEquals(title, Constants.HOME_PAGE_TITLE, "Home page title did not match...."); 
//	}
//	catch (Exception e) { 
//		e.printStackTrace();
//		System.out.println("HOME PAGE TITLE IS FAILING"); }
}

@Test(priority=1)
public void verifyHomePageHeaderTest() {
	String header = homePage.getHomePageHeaderText();
	System.out.println("Home Page header is :" + header);
	Assert.assertEquals(header, Constants.HOME_PAGE_HEADER, "Home page Header did not match....");
}


@Test(priority=3)
public void verifyLoggedInUserTest() {
//	try {
	String loggedInUser = homePage.getLoggedInUser(); 
	System.out.println("Home page account name is I am here....: " + loggedInUser);
	//Assert.assertEquals(loggedInUser, "www.myhome.com", "logged in user is not matched");
	Assert.assertEquals(loggedInUser, Constants.HOME_PAGE_ACCOUNT, "logged in user is not matched");
//	} catch(Exception e) { 
//		e.printStackTrace();
//		System.out.println("System is throwing an exception");  }
	}

	

@AfterTest
public void tearDown() {
	driver.quit();
} 
	
}
	
	



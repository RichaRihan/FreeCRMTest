package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		
		initialization();
		testUtil=new TestUtil();
		loginPage=new LoginPage();
		contactsPage=new ContactsPage();
		Thread.sleep(5000);
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyUserName());	
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		testUtil.switchToFrame();
		contactsPage = homePage.clickContactsLink();
		
	}
		
	@AfterMethod
	 public void tearDown(){
		driver.quit();
	}
}

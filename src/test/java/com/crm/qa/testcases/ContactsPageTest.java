package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage; 
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName="contacts";
	
	ContactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		loginPage=new LoginPage();
		Thread.sleep(5000);
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage=homePage.clickContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"Contacts label is missing on the page");
		
	}
	
	@Test(priority=2)
	public void selectSingleContactsTest() {
		contactsPage.selectContactsByName("New Account");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest() {
		contactsPage.selectContactsByName("New Account");
		contactsPage.selectContactsByName("Anil Sharma");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object[][] data=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=4 , dataProvider="getCRMTestData")
	public void validateCreateNewContactTest(String title, String firstName, String lastName, String company) {
		homePage.clickNewContactLink();
		contactsPage.createNewContact(title,firstName,lastName,company);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}

package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalendarPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.EventPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class CalendarPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	CalendarPage calendarPage;
	EventPage eventPage;;
	TestUtil testUtil;	
//	String day="25";
//	String month="July";
//	String year="2021";
//	String time="10:00AM";
//	String eventTitle="New event for "+day+month+year+"";
	String sheetName="Events";

	public CalendarPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		testUtil=new TestUtil();
		loginPage=new LoginPage();
		Thread.sleep(5000);
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
	}
	
	@DataProvider
	public Object getEventDetails() {
		Object[][] data=TestUtil.getTestData(sheetName);
		return data; 
	}
	
	@Test(dataProvider="getEventDetails")
	public void createEvent(String day, String month, String year, String time) throws InterruptedException {
		homePage.selectDate(day, month, year);
		calendarPage = new CalendarPage();
		eventPage=calendarPage.selectTime(time);
		String message=eventPage.addEvent("New event for"+day+month+year+"");
		Assert.assertEquals(message, "Email notifications were sent to all attendees.");
		
	}

	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}

package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MessageBoardPage;
import com.crm.qa.pages.MessageBoardPostPage;
import com.crm.qa.util.TestUtil;

public class MessagePageTestParameters extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	MessageBoardPage messageBoardPage;
	MessageBoardPostPage messageBoardPostPage;
	
	public MessagePageTestParameters() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		testUtil=new TestUtil();
		loginPage=new LoginPage();
		Thread.sleep(5000);
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
	}
	
	@Parameters({"msgSubject","msgText"})
	@Test()
	public void createMessage(String subject, String text) {
		homePage.clickMessagesLink();
		messageBoardPage=new MessageBoardPage();
		messageBoardPage.clickNewMsgBtn();
		messageBoardPostPage=new MessageBoardPostPage();
		messageBoardPostPage.createMessage(subject, text);
		String message=messageBoardPostPage.validateMessage();
		if(message.contains(text)) {
			Assert.assertTrue(true);
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}

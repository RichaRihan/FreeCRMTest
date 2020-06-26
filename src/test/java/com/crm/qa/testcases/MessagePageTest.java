package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MessageBoardPage;
import com.crm.qa.pages.MessageBoardPostPage;
import com.crm.qa.util.TestUtil;

public class MessagePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	MessageBoardPage messageBoardPage;
	MessageBoardPostPage messageBoardPostPage;
	String msgSubject = "Security Message";
	String msgText ="Test Message created for User1";
	
	public MessagePageTest() {
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
	
	@Test
	public void createMessage() {
		homePage.clickMessagesLink();
		messageBoardPage=new MessageBoardPage();
		messageBoardPage.clickNewMsgBtn();
		messageBoardPostPage=new MessageBoardPostPage();
		messageBoardPostPage.createMessage(msgSubject, msgText);
		String message=messageBoardPostPage.validateMessage();
		if(message.contains(msgText)) {
			Assert.assertTrue(true);
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}

package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class MessageBoardPage extends TestBase{
	
	public MessageBoardPage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@value='New Message']")
	WebElement newMsgBtn;
	
	public MessageBoardPostPage clickNewMsgBtn() {
		newMsgBtn.click();
		return new MessageBoardPostPage();
	}

}

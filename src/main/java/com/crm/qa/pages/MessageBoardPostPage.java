package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class MessageBoardPostPage extends TestBase{
	
	public MessageBoardPostPage() {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="subject")
	WebElement subjectTxt;
	
	@FindBy(name="msg")
	WebElement messageTxt;
	
	@FindBy(xpath="//input[@value='Post']")
	WebElement postBtn;
	
	@FindBy(xpath="//td[@class='datafield']")
	WebElement message;
	
	public void createMessage(String subject, String message) {
		subjectTxt.sendKeys(subject);
		messageTxt.sendKeys(message);
		postBtn.click();
	}
	
	public String validateMessage() {
		return message.getText();
	}
}

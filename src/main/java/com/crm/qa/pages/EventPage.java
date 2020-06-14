package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class EventPage extends TestBase {
	
	public EventPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="title")
	WebElement eventTitleField;
	
	@FindBy(xpath="(//input[@type='submit' and @value='Save'])[1]")
	WebElement saveBtn;
	
	@FindBy(name="assigned_to_user_id_src")
	WebElement assignedUsr;
	
	@FindBy(xpath="//input[@onclick='addMember();']")
	WebElement addBtn;
	
	@FindBy(xpath="//td[contains(text(),'Email notifications were sent to all attendees.')]")
	WebElement successMsg;
	
	public String addEvent(String eventTitle) {
		eventTitleField.sendKeys(eventTitle);
		assignedUsr.click();
		addBtn.click();
		saveBtn.click();
		return successMsg.getText();
		
	}

}

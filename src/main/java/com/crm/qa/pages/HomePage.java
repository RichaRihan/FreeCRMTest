package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[contains(text(),'Test1')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[@title='Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[@title='Tasks']")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement newContactLink;
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}

}

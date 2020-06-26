package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[contains(text(),'Test1')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[@title='Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[@title='Tasks']")
	WebElement tasksLink;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[@title='Messages']")
	WebElement messagesLink;
	
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
	
	public void clickNewContactLink() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		Thread.sleep(10000);
		newContactLink.click();
	}
	
	public CalendarPage selectDate(String day, String month, String year) throws InterruptedException {
		Select s1 = new Select(driver.findElement(By.name("slctMonth")));
		s1.selectByVisibleText(month);
		Thread.sleep(5000);
		
		Select s2=new Select(driver.findElement(By.name("slctYear")));
		s2.selectByVisibleText(year);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//td[contains(text(),'"+day+"')]")).click();
		Thread.sleep(5000);
		
		return new CalendarPage();
		
	}
	
	public MessageBoardPage clickMessagesLink() {
		messagesLink.click();
		return new MessageBoardPage();
	}
	
	

}

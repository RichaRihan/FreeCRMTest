package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CalendarPage extends TestBase{
	
	
	public CalendarPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public EventPage selectTime(String time) {
		driver.findElement(By.xpath("//a[@name='"+time+"']//parent::td/following-sibling::td[@align='left']")).click();

		return new EventPage();
	}
}

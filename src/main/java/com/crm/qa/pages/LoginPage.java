package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	public LoginPage(){
		PageFactory.initElements(driver, this); //used to initialize current class objects with this driver
	}

	//Page Factory (Object Respository)
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="(//img[@class='img-responsive'])[1]")
	WebElement crmLogo;
	
	//Actions on the current page
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public Boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
}

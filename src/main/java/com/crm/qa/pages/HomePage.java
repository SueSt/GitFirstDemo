package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'Sue Mc')]")
	WebElement userNamelabel;

	@FindBy(xpath = "//span[contains(text(), 'Contacts')]")
	WebElement ContactsLink;

	@FindBy(xpath = "//span[contains(text(), 'Deals')]")
	WebElement DealsLink;

	@FindBy(xpath = "//span[contains(text(), 'Tasks')]")
	WebElement TasksLink;

	@FindBy(xpath="//button[text()='New']")
	WebElement NewContactsLink;
	
	
	// Initializing The page Objects(elements)
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String VerifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean VerifyUserNamelabel() {
		return userNamelabel.isDisplayed();	
	}

	public ContactsPage clickContactsLink() {
		ContactsLink.click();
		return new ContactsPage();
	}

	public DealsPage clickDealsLink() {
		DealsLink.click();
		return new DealsPage();
	}

	public TasksPage clickTasksLink() {
		TasksLink.click();
		return new TasksPage();
	}
	
	public void AddNewContactsLink() {
		ContactsLink.click();
		NewContactsLink.click();
		
		
	}

}


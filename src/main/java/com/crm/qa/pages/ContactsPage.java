package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath= "//div[@class='ui header item mb5 light-black']")
	WebElement contactslabel;
	
	@FindBy(xpath= "//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement LastName;
	
	@FindBy(xpath="//div[@name='company']//input[@aria-autocomplete='list']")
	WebElement Company;
	
	@FindBy(xpath= "//button[text()='Save']")
	WebElement SaveBtn;
	

	//Initializing The page Objects(elements)
		public ContactsPage() {
			PageFactory.initElements(driver, this);
		}
		
		public boolean Verifycontactslabel() {
			return contactslabel.isDisplayed();
		}
		
		public void SelectContactsByName(String Name) {
			driver.findElement(By.xpath("//td[(text()= '"+Name+"')]//preceding-sibling::td")).click();
		}
	
		
		public void CreateNewContact(String fName, String lName, String Comp) {
			firstName.sendKeys(fName);
			LastName.sendKeys(lName);
			Company.sendKeys(Comp);
			SaveBtn.click();
		}
}

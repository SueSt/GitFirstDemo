package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page factory- OR:
	
	@FindBy(linkText= "LOG IN")
	WebElement LoginBtn;
	
	@FindBy(name= "email")
	WebElement Email;
	
	@FindBy(name= "password")
	WebElement Password;
	
	@FindBy(xpath= "//div[@class='ui fluid large blue submit button']")
	WebElement LoginBtn2;
	
	@FindBy(linkText= "SIGN UP")
	WebElement SignUpBtn;
	
	@FindBy(xpath="//a[@title='free crm home']")
	WebElement crmlogo;
	
	//Initializing The page Objects(elements)
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	//Actions:
	public String ValidateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean ValidateCRFMImage(){
		return crmlogo.isDisplayed();
	}
	
	public HomePage login(String Eml, String pass) {
		LoginBtn.click();
		Email.sendKeys(Eml);
		Password.sendKeys(pass);
		LoginBtn2.click();
		
		return new HomePage();
		
	}

}


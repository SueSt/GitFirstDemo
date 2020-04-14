package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage lgpage;
	HomePage homePage;
	ContactsPage Contacts;
	String SheetName="Contacts";
	
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() throws InterruptedException {
		Initialization();
		lgpage = new LoginPage();
		Contacts= new ContactsPage();
		homePage = lgpage.login(prop.getProperty("Emal"), prop.getProperty("password"));
		homePage.clickContactsLink();
		Thread.sleep(5000);
	}
	
	@Test(priority=1)
	public void VerifycontactslabelTest() {
		Assert.assertTrue(Contacts.Verifycontactslabel(), "Contacts label is missing");
	}
	
	@Test(priority=2)
	public void SelectSingleContactsByNameTest() {
		Contacts.SelectContactsByName("Naveen K");
	}
	
	
	  @Test(priority=3)
	  public void SelectmultipleContactsByNameTest() {
	Contacts.SelectContactsByName("Naveen K");
	  Contacts.SelectContactsByName("Nicole Smith"); 
	  }
	 
	  
	  @DataProvider
	  public  Object[][] getCrmTestData() {
		 Object[][] data=  TestUtil.getTestData(SheetName);
		 return data;
	  }
	  
	  @Test(priority=4, dataProvider="getCrmTestData")
	  public void CreateNewContactTest(String FirstName, String LastName, String Company) throws InterruptedException {
		  homePage.AddNewContactsLink();
		  //Contacts.CreateNewContact("David", "Peter", "Google");
		  Thread.sleep(3000);
		  Contacts.CreateNewContact(FirstName, LastName, Company);
	  }
	 
	
	  @AfterMethod 
	  public void TearDown() { 
		driver.quit();
		  }	
}


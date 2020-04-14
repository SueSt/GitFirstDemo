package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage lgpage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		Initialization();
	    lgpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest(){
		String title= lgpage.ValidateLoginPageTitle();
		System.out.println(title);
		AssertJUnit.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
	}
	
	@Test(priority=2)
	public void CRFMImageTest() {
		boolean flag= lgpage.ValidateCRFMImage();
		AssertJUnit.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() {
		homePage= lgpage.login(prop.getProperty("Emal"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void TearDown(){
		driver.quit();
	}	
}

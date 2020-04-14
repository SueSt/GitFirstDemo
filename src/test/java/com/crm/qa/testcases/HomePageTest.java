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
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;

public class HomePageTest extends TestBase {
	LoginPage lgpage;
	HomePage homePage;
	ContactsPage Contacts;
	DealsPage Deals;
	TasksPage Tasks;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() {
		Initialization();
		lgpage = new LoginPage();
		homePage = lgpage.login(prop.getProperty("Emal"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void VerifyHomePageTitleTest() {
		String HPtitle = homePage.VerifyHomePageTitle();
		AssertJUnit.assertEquals(HPtitle, "Cogmento CRM", "Home Page Title not matched");
	}

	@Test(priority=2)
	public void VerifyUserNamelabelTest() {
		boolean usernamelabel = homePage.VerifyUserNamelabel();
		AssertJUnit.assertTrue(usernamelabel);
	}

	@Test(priority=3)
	public void VerifyContactsLinkTest()  {
		Contacts = homePage.clickContactsLink();
	}

	@Test(priority=4)
	public void VerifyDealsLinkTest() {
		Deals = homePage.clickDealsLink();
	}

	@Test(priority=5)
	public void VerifyTaskLinkTest() {
		Tasks = homePage.clickTasksLink();
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}


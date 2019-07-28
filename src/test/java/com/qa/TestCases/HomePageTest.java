package com.qa.TestCases;

import org.testng.annotations.Test;

import com.qa.Base.BaseClass;
import com.qa.Pages.HomePage;
import com.qa.Pages.LogINPage;

//import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class HomePageTest extends BaseClass
{
	
  HomePage Page;
  LogINPage Page2;
   public HomePageTest() {
	super();// To initialize super class constructor
}

   @Test(priority = 1)
   public void Logo_Verification() 
   {
 	  Assert.assertTrue(Page.ValidateLogoDisplayed());
   }

   @Test(priority = 2)
   public void HomePage_Title_Verification() 
   {
	   System.out.println(Page.ValidatePageTitle());
 	  Assert.assertEquals(Page.ValidatePageTitle(), "Home - Ultimate QA");  
   }
   
   @Test(priority = 3)
  public void NavigateTo_LOGIN_Page_Verification() throws InterruptedException 
  {
	 Page2 =  Page.navigateToLogIN();
  }
  @BeforeMethod
  @Parameters("BrowserName")
  public void beforeMethod(String BrowserName)
  {
	  initialize(BrowserName);
	  Page = new HomePage();
  }

  @AfterMethod
  public void beforeTest() 
  {
	  Method_Count++;
	  System.out.println("Method "+Method_Count+" Executed");
	  driver.quit();
  }

}

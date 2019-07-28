package com.qa.TestCases;

import org.testng.annotations.Test;

import com.qa.Base.BaseClass;
import com.qa.Pages.HomePage;
import com.qa.Pages.LogINPage;
import com.qa.Pages.MyAccount;
import com.qa.Utils.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterMethod;

public class MyAccountTest extends BaseClass
{
	HomePage homepage;
	LogINPage Loginpage;
	MyAccount Myaccount;
	
	public MyAccountTest() 
	{
		super();
	}
  @Test(priority = 1,dataProvider ="get_test_Data")
  public void Submiting_Form(String email,String Name,String Surname,String Company,String Title,String TimeZone) throws IOException 
  {
	  Myaccount.submit_Form(email, Name, Surname, Company, Title, TimeZone);
	  Utilities.get_Screenshot();
  }
  @Test
  public void Upload_Profile_Image() throws AWTException
  {
	  Myaccount.upload_Image();
	  
  }
  
  @DataProvider
  public Object[][] get_test_Data() throws IOException
  {
	Object[][] formData = Utilities.get_Data();
	return formData;
	  
  }
  
  @BeforeMethod
  @Parameters("BrowserName")
  public void beforeMethod(String BrowserName) throws InterruptedException 
  {
	  initialize(BrowserName);
	  homepage = new HomePage();
	  Loginpage = homepage.navigateToLogIN();
	  System.out.println(Loginpage.Log_In());
	  Myaccount = Loginpage.Navigate_MyAccount();
  }

  @AfterMethod
  public void afterMethod() 
  {
	  Method_Count++;
	  System.out.println("Method "+Method_Count+" Executed");
	  driver.quit();
  }

}

package com.qa.TestCases;

import org.testng.annotations.Test;

//import com.beust.jcommander.Parameter;
import com.qa.Base.BaseClass;
import com.qa.Pages.HomePage;
import com.qa.Pages.LogINPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LogINPageTest extends BaseClass

{
	HomePage obj1;
	LogINPage obj2;
	
	public LogINPageTest() {
		super();
	}
  @Test
  public void validate_LogIN() throws InterruptedException 
  {
	  
	  String user_Prof =  obj2.Log_In();
	  Assert.assertEquals(user_Prof, "Arijit G");
	  System.out.println(user_Prof+" is logged into the system");
  }
  @BeforeMethod
  @Parameters("BrowserName")
  public void beforeMethod(String BrowserName) throws InterruptedException 
  {   
	  //BrowserName = "chrome";
	  initialize(BrowserName);
	  obj1 = new HomePage();
	  obj2 = obj1.navigateToLogIN();
	  
  }

  @AfterMethod
  public void afterMethod() 
  {
	  Method_Count++;
	  System.out.println("Method "+Method_Count+" Executed");
	  driver.quit();
  }

}

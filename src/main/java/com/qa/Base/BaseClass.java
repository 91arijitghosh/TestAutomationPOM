package com.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass 
{
   public static WebDriver driver;//declaring public static to give global access
   public static Properties prop;//declaring public static to give global access
   public static int Method_Count = 0;
   
   
   public BaseClass()//creating constructor to initializing the properties file
   {
	   prop = new Properties();
	   try {
		FileInputStream fis = new FileInputStream("C:\\Users\\Arijit Ghosh\\eclipse-workspace\\UltimateQA_Automation\\src\\main\\java\\com\\qa\\Config\\TestProperties.properties");
	    prop.load(fis);
	   } catch (FileNotFoundException e) {
		System.out.println("File is not visible");
	   } catch (IOException e) {
		System.out.println("IO Exceptiom occured");
	}
   }
   public static void initialize(String BrowserName) //method to initialize the webdriver object and other primary methods 
   {
	   if(BrowserName.equalsIgnoreCase("Chrome")){
		   System.setProperty("webdriver.chrome.driver", prop.getProperty("ChromeDriverPath"));
			   driver = new ChromeDriver();
	   }else if(BrowserName.equalsIgnoreCase("firefox")) {
		   System.setProperty("webdriver.gecko.driver", prop.getProperty("FireFoxDriverPath"));
		   driver = new FirefoxDriver();
	   }else System.out.println("Invalid browser name given");
	   
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
	   driver.get(prop.getProperty("url"));
	   driver.manage().timeouts().pageLoadTimeout(Long.parseLong(prop.getProperty("pageloadtimeout")),TimeUnit.SECONDS);
	   driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("implicitwait")), TimeUnit.SECONDS);
	   
	   
   }
}

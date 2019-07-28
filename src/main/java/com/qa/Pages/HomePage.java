package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.BaseClass;

public class HomePage extends BaseClass
{   
	//Page Factory
	@FindBy(xpath="//img[@id='logo']")
	WebElement LOGO;
	
	//@FindBy(xpath="//li[@id='menu-item-504']//following::a[@href='https://www.ultimateqa.com/video-tutorials/']")
	@FindBy(xpath="//ul[@id='top-menu']//li[@id='menu-item-504']")
	WebElement COURCES;
	
	
	//initializing Page Factory
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String ValidatePageTitle()
	{
		return driver.getTitle();
	}	
	public boolean ValidateLogoDisplayed()
	{
		return LOGO.isDisplayed();
	}
	public LogINPage navigateToLogIN() throws InterruptedException {
		COURCES.click();
		Thread.sleep(100);
		
		return new LogINPage();
	}

}

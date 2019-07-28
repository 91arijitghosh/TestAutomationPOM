package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.BaseClass;

//import net.bytebuddy.asm.Advice.Return;

public class LogINPage extends BaseClass{
	
	@FindBy(xpath="//a[@href='/users/sign_in']")
	WebElement SignIn_Link;
	
	@FindBy(xpath="//input[@id='user_email']")
	WebElement User_ID;
	
	@FindBy(xpath="//input[@id='user_password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@type='submit' and @name='commit']")
	WebElement LogIN_Button;
	
	@FindBy(xpath = "//span[@class='user-name']")
	WebElement User_Profile;
	
    @FindBy(xpath = "//li[@class='dropdown header-nav__item']")
    WebElement dropdown;
    
    @FindBy(xpath = "//ul[@class='dropdown-menu']/child::li/child::a[@ href='/account']")
    WebElement MyAccount;
	
	public LogINPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String Log_In() throws InterruptedException
	{
		//COURCES.click();
		//Thread.sleep(5);
		SignIn_Link.click();
		//Thread.sleep(5);
		User_ID.sendKeys(prop.getProperty("UserName"));
		//Thread.sleep(5);
		Password.sendKeys(prop.getProperty("Password"));
		//Thread.sleep(5);
		LogIN_Button.click();
		return User_Profile.getText();
	}
	public MyAccount Navigate_MyAccount() throws InterruptedException
	{   
		Thread.sleep(5000);
		dropdown.click();
		MyAccount.click();
		return new MyAccount();
	}

}

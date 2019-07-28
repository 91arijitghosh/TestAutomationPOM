package com.qa.Pages;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.Base.BaseClass;
import com.qa.Utils.Utilities;

public class MyAccount extends BaseClass
{
	@FindBy(xpath="//input[@class='form-control' and @type='email']")
	WebElement email_id;

	@FindBy(xpath="//input[@class='form-control' and @id='user_first_name']")
	WebElement First_Name;

	@FindBy(xpath="//input[@class='form-control' and @id='user_last_name']")
	WebElement Last_Name;

	@FindBy(xpath="//input[@class='form-control' and @id='user_profile_attributes_company']")
	WebElement Company_Name;

	@FindBy(xpath="//input[@class='form-control' and @id='user_profile_attributes_headline']")
	WebElement Title;

	@FindBy(xpath="//select[@class='form-control' and @id='user_profile_attributes_timezone']")
	WebElement TimeZone;

	@FindBy(xpath="//input[@type='submit' and @value='Save Changes' ]")
	WebElement Submit;
	
	@FindBy(xpath="//input[@class='btn-upload image']//following-sibling::label")
	WebElement UploadImage;
	
	public MyAccount () {
		PageFactory.initElements(driver, this);
	}
	
	
	public void submit_Form(String email,String Name,String Surname,String Company,String title,String Timezone)
	{
		email_id.clear();
		email_id.sendKeys(email);
		
		First_Name.clear();
		First_Name.sendKeys(Name);
		
		Last_Name.clear();
		Last_Name.sendKeys(Surname);
		
		Company_Name.clear();
		Company_Name.sendKeys(Company);
		
		Title.clear();
		Title.sendKeys(title);
		
		Select timeZone = new Select(TimeZone);
		timeZone.selectByVisibleText(Timezone);
		
		Submit.click();
	}
	public void upload_Image() throws AWTException
	{
		UploadImage.click();
		Utilities.upload_File();
		Submit.click();
		
	}
}

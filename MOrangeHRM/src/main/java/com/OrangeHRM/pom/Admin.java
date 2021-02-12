package com.OrangeHRM.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin 
{
	@FindBy(xpath="//b[.='Admin']")
	private WebElement Adminlink;
	
	@FindBy(id="menu_admin_Organization")
	private WebElement organization;
	
	@FindBy(id="menu_admin_viewOrganizationGeneralInformation")
	private WebElement Gk;
	
	@FindBy(id="btnSaveGenInfo")
	private WebElement EditBtn;
	
	@FindBy(id = "organization_name")
	private WebElement Organizationname;
	
	@FindBy(id = "organization_email")
	private WebElement Email;
	
	@FindBy(id = "btnSaveGenInfo")
	private WebElement SavEBtn;
	
	public Admin(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getOrganizationDropDown()
	{
	return organization;
	}	
	
	public WebElement getGeneralInformationOption()
	{
	return Gk;
	}	
	
	public WebElement getEditBtn()
	{
	return EditBtn;
	}
	
	public WebElement getOrganisationNametbx()
	{
	return Organizationname;
	}	
	
	public WebElement getEmailTbx()
	{
	return Email;
	}	
	

}
